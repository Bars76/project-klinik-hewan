package dao;

import database.Koneksi;
import interfacepkg.CRUD;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.DefaultTableModel;
import model.Jadwal;

public class JadwalDAO implements CRUD<Jadwal> {
    private final Connection conn;

    public JadwalDAO() {
        this.conn = Koneksi.getConnection();
    }

    public List<String[]> getAllDokter() {
        List<String[]> list = new ArrayList<>();
        String sql = "SELECT id_dokter, nama_dokter, spesialis FROM dokter";
        try (PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                String id = String.valueOf(rs.getInt("id_dokter"));
                String nama = rs.getString("nama_dokter");
                String spesialis = rs.getString("spesialis");
                list.add(new String[]{id, nama, spesialis});
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public void insert(Jadwal j) {
        String sql = "INSERT INTO jadwal (id_dokter, tanggal, jam) VALUES (?, ?, ?)";
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, j.getIdDokter());
            ps.setString(2, j.getTanggal());
            ps.setString(3, j.getJam());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(Jadwal j) {
        String sql = "UPDATE jadwal SET id_dokter=?, tanggal=?, jam=? WHERE id_jadwal=?";
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, j.getIdDokter());
            ps.setString(2, j.getTanggal());
            ps.setString(3, j.getJam());
            ps.setInt(4, j.getIdJadwal());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(int id) {
        String sql = "DELETE FROM jadwal WHERE id_jadwal=?";
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public DefaultTableModel getData() {
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("ID Jadwal");
        model.addColumn("Nama Dokter");
        model.addColumn("Tanggal");
        model.addColumn("Jam");
        String sql = "SELECT j.id_jadwal, d.nama_dokter, j.tanggal, j.jam " +
                     "FROM jadwal j JOIN dokter d ON j.id_dokter = d.id_dokter";
        try (PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                model.addRow(new Object[]{
                    rs.getInt("id_jadwal"),
                    rs.getString("nama_dokter"),
                    rs.getString("tanggal"),
                    rs.getString("jam")
                });
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return model;
    }
}