package controller;

import dao.JadwalDAO;
import model.Jadwal;
import view.JadwalView;
import javax.swing.JOptionPane;
import java.util.HashMap;
import java.util.Map;

public class JadwalController {
    private final JadwalView view;
    private final JadwalDAO dao;
    private final Map<String, Integer> mapDokter;
    public int idJadwal;

    public JadwalController(JadwalView view) {
        this.view = view;
        this.dao = new JadwalDAO();
        this.mapDokter = new HashMap<>();
    }

    public void loadDokterToCombo() {
        view.cbDokter.removeAllItems();
        mapDokter.clear();
        for (String[] dokter : dao.getAllDokter()) {
            int id = Integer.parseInt(dokter[0]);
            String nama = dokter[1];
            String spesialis = dokter[2];
            String tampilan = nama + " - " + spesialis;
            view.cbDokter.addItem(tampilan);
            mapDokter.put(tampilan, id);
        }
        if (view.cbDokter.getItemCount() > 0) {
            view.cbDokter.setSelectedIndex(0);
        }
    }

    private int getIdDokterTerpilih() {
        String selected = (String) view.cbDokter.getSelectedItem();
        return mapDokter.getOrDefault(selected, -1);
    }

    public void simpanData() {
        int idDokter = getIdDokterTerpilih();
        if (idDokter == -1) {
            JOptionPane.showMessageDialog(view, "Dokter tidak valid", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        String tanggal = view.txtTanggal.getText().trim();
        String jam = view.txtJam.getText().trim();
        if (tanggal.isEmpty() || jam.isEmpty()) {
            JOptionPane.showMessageDialog(view, "Tanggal dan jam harus diisi", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        if (!tanggal.matches("\\d{4}-\\d{2}-\\d{2}")) {
            JOptionPane.showMessageDialog(view, "Format tanggal harus YYYY-MM-DD", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        if (!jam.matches("\\d{2}:\\d{2}:\\d{2}")) {
            JOptionPane.showMessageDialog(view, "Format jam harus HH:MM:SS", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        Jadwal j = new Jadwal();
        j.setIdDokter(idDokter);
        j.setTanggal(tanggal);
        j.setJam(jam);
        dao.insert(j);
        tampilData();
        resetForm();
        JOptionPane.showMessageDialog(view, "Data jadwal berhasil disimpan");
    }

    public void editData() {
        if (idJadwal <= 0) {
            JOptionPane.showMessageDialog(view, "Pilih data yang akan diedit", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        int idDokter = getIdDokterTerpilih();
        if (idDokter == -1) {
            JOptionPane.showMessageDialog(view, "Dokter tidak valid", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        String tanggal = view.txtTanggal.getText().trim();
        String jam = view.txtJam.getText().trim();
        if (tanggal.isEmpty() || jam.isEmpty()) {
            JOptionPane.showMessageDialog(view, "Tanggal dan jam harus diisi", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        if (!tanggal.matches("\\d{4}-\\d{2}-\\d{2}")) {
            JOptionPane.showMessageDialog(view, "Format tanggal harus YYYY-MM-DD", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        if (!jam.matches("\\d{2}:\\d{2}:\\d{2}")) {
            JOptionPane.showMessageDialog(view, "Format jam harus HH:MM:SS", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        Jadwal j = new Jadwal();
        j.setIdJadwal(idJadwal);
        j.setIdDokter(idDokter);
        j.setTanggal(tanggal);
        j.setJam(jam);
        dao.update(j);
        tampilData();
        resetForm();
        JOptionPane.showMessageDialog(view, "Data jadwal berhasil diubah");
    }

    public void hapusData() {
        if (idJadwal <= 0) {
            JOptionPane.showMessageDialog(view, "Pilih data yang akan dihapus", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        int confirm = JOptionPane.showConfirmDialog(view, "Yakin ingin menghapus jadwal ini?", "Konfirmasi", JOptionPane.YES_NO_OPTION);
        if (confirm == JOptionPane.YES_OPTION) {
            dao.delete(idJadwal);
            tampilData();
            resetForm();
            JOptionPane.showMessageDialog(view, "Data jadwal berhasil dihapus");
        }
    }

    public void tampilData() {
        view.tableJadwal.setModel(dao.getData());
    }

    public void resetForm() {
        view.txtTanggal.setText("");
        view.txtJam.setText("");
        if (view.cbDokter.getItemCount() > 0) {
            view.cbDokter.setSelectedIndex(0);
        }
        idJadwal = 0;
    }
}