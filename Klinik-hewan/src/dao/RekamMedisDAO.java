// dao/RekamMedisDAO.java
package dao;

import database.Koneksi;
import interfacepkg.CRUD;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.table.DefaultTableModel;
import model.RekamMedis;

public class RekamMedisDAO implements CRUD<RekamMedis> {
    Connection conn = Koneksi.getConnection();

    @Override
    public void insert(RekamMedis rm) {
        try {
            String sql = "INSERT INTO rekam_medis VALUES(NULL,?,?,?,?)";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, rm.getNamaHewan());
            ps.setString(2, rm.getDiagnosa());
            ps.setString(3, rm.getTindakan());
            ps.setString(4, rm.getObat());
            ps.executeUpdate();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void update(RekamMedis rm) {
        try {
            String sql = "UPDATE rekam_medis SET nama_hewan=?, diagnosa=?, tindakan=?, obat=? WHERE id_rekam=?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, rm.getNamaHewan());
            ps.setString(2, rm.getDiagnosa());
            ps.setString(3, rm.getTindakan());
            ps.setString(4, rm.getObat());
            ps.setInt(5, rm.getIdRekam());
            ps.executeUpdate();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void delete(int id) {
        try {
            String sql = "DELETE FROM rekam_medis WHERE id_rekam=?";
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
        model.addColumn("Diagnosa");
        model.addColumn("Tindakan");
        model.addColumn("Obat");

        try {
            String sql = "SELECT * FROM rekam_medis";
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                model.addRow(new Object[]{
                    rs.getInt("id_rekam"),
                    rs.getString("nama_hewan"),
                    rs.getString("diagnosa"),
                    rs.getString("tindakan"),
                    rs.getString("obat")
                });
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return model;
    }

    // Method tambahan khusus untuk keperluan combobox hewan
    public String[] getAllHewan() {
        java.util.List<String> list = new java.util.ArrayList<>();
        try {
            String sql = "SELECT nama_hewan, jenis FROM hewan";
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                list.add(rs.getString("nama_hewan") + " - " + rs.getString("jenis"));
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return list.toArray(new String[0]);
    }
}