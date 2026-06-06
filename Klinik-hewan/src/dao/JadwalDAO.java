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

    public List<String[]> getAllHewan() {
        List<String[]> list = new ArrayList<>();
        String sql = "SELECT id_hewan, nama_hewan, jenis FROM hewan";
        try (PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                String id = String.valueOf(rs.getInt("id_hewan"));
                String nama = rs.getString("nama_hewan");
                String jenis = rs.getString("jenis");
                list.add(new String[]{id, nama, jenis});
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public void insert(Jadwal j) {
        String sql = "INSERT INTO jadwal (id_dokter, tanggal, jam, status, id_hewan, keluhan, created_at) VALUES (?, ?, ?, ?, ?, ?, NOW())";
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, j.getIdDokter());
            ps.setString(2, j.getTanggal());
            ps.setString(3, j.getJam());
            ps.setString(4, j.getStatus());
            ps.setInt(5, j.getIdHewan());
            ps.setString(6, j.getKeluhan());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(Jadwal j) {
        String sql = "UPDATE jadwal SET id_dokter=?, tanggal=?, jam=?, status=?, id_hewan=?, keluhan=? WHERE id_jadwal=?";
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, j.getIdDokter());
            ps.setString(2, j.getTanggal());
            ps.setString(3, j.getJam());
            ps.setString(4, j.getStatus());
            ps.setInt(5, j.getIdHewan());
            ps.setString(6, j.getKeluhan());
            ps.setInt(7, j.getIdJadwal());
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
        model.addColumn("Dokter");
        model.addColumn("Hewan");
        model.addColumn("Tanggal");
        model.addColumn("Jam");
        model.addColumn("Status");
        model.addColumn("Keluhan");
       // model.addColumn("Dibuat pada");

        String sql = "SELECT j.id_jadwal, d.nama_dokter, h.nama_hewan, j.tanggal, j.jam, j.status, j.keluhan, j.created_at " +
                     "FROM jadwal j " +
                     "JOIN dokter d ON j.id_dokter = d.id_dokter " +
                     "LEFT JOIN hewan h ON j.id_hewan = h.id_hewan";
        try (PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                model.addRow(new Object[]{
                    rs.getInt("id_jadwal"),
                    rs.getString("nama_dokter"),
                    rs.getString("nama_hewan") == null ? "-" : rs.getString("nama_hewan"),
                    rs.getString("tanggal"),
                    rs.getString("jam"),
                    rs.getString("status"),
                    rs.getString("keluhan") == null ? "-" : rs.getString("keluhan"),
                   // rs.getString("created_at") == null ? "-" : rs.getString("created_at")
                });
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return model;
    }
}
