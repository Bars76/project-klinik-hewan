package dao;

import database.Koneksi;
import interfacepkg.CRUD;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.table.DefaultTableModel;
import model.Hewan;

public class HewanDAO implements CRUD<Hewan> {
    Connection conn = Koneksi.getConnection();

    @Override
    public void insert(Hewan h) {
        try {
            String sql = "INSERT INTO hewan VALUES(NULL,?,?,?,?)";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, h.getNamaHewan());
            ps.setString(2, h.getJenis());
            ps.setInt(3, h.getUmur());
            ps.setString(4, h.getPemilik());
            ps.executeUpdate();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void update(Hewan h) {
        try {
            String sql = "UPDATE hewan SET nama_hewan=?, jenis=?, umur=?, pemilik=? WHERE id_hewan=?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, h.getNamaHewan());
            ps.setString(2, h.getJenis());
            ps.setInt(3, h.getUmur());
            ps.setString(4, h.getPemilik());
            ps.setInt(5, h.getIdHewan());
            ps.executeUpdate();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void delete(int id) {
        try {
            String sql = "DELETE FROM hewan WHERE id_hewan=?";
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
        model.addColumn("Nama Hewan");
        model.addColumn("Jenis");
        model.addColumn("Umur");
        model.addColumn("Pemilik");
        try {
            String sql = "SELECT * FROM hewan";
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                model.addRow(new Object[]{
                    rs.getInt("id_hewan"),
                    rs.getString("nama_hewan"),
                    rs.getString("jenis"),
                    rs.getInt("umur"),
                    rs.getString("pemilik")
                });
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return model;
    }
}