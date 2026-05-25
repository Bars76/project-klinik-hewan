package dao;

import database.Koneksi;
import interfacepkg.CRUD;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.table.DefaultTableModel;
import model.Dokter;

public class DokterDAO implements CRUD<Dokter> {
    Connection conn = Koneksi.getConnection();

    @Override
    public void insert(Dokter d) {
        try {
            String sql = "INSERT INTO dokter VALUES(NULL,?,?,?)";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, d.getNama());   // <- perbaiki: getNama()
            ps.setString(2, d.getSpesialis());
            ps.setString(3, d.getNoHp());
            ps.executeUpdate();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void update(Dokter d) {
        try {
            String sql = "UPDATE dokter SET nama_dokter=?, spesialis=?, no_hp=? WHERE id_dokter=?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, d.getNama());   // <- perbaiki: getNama()
            ps.setString(2, d.getSpesialis());
            ps.setString(3, d.getNoHp());
            ps.setInt(4, d.getIdDokter());
            ps.executeUpdate();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void delete(int id) {
        try {
            String sql = "DELETE FROM dokter WHERE id_dokter=?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public DefaultTableModel getData() {
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("ID");
        model.addColumn("Nama Dokter");
        model.addColumn("Spesialis");
        model.addColumn("No HP");
        try {
            String sql = "SELECT * FROM dokter";
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                model.addRow(new Object[]{
                    rs.getInt("id_dokter"),
                    rs.getString("nama_dokter"),
                    rs.getString("spesialis"),
                    rs.getString("no_hp")
                });
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return model;
    }
}