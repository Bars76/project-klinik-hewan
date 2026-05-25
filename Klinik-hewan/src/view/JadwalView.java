package view;

import controller.JadwalController;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class JadwalView extends JFrame {

    public JComboBox<String> cbDokter;
    public JTextField txtTanggal;
    public JTextField txtJam;

    private JButton btnTambah;
    private JButton btnEdit;
    private JButton btnHapus;
    private JButton btnReset;
    private JButton btnKembali;

    public JTable tableJadwal;

    private JadwalController controller;

    public JadwalView() {
        setTitle("Jadwal Praktik Dokter");
        setSize(950, 650);
        setLayout(null);
        setLocationRelativeTo(null);
        setResizable(false);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        getContentPane().setBackground(new Color(240, 244, 248));

        JPanel header = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                Graphics2D g2d = (Graphics2D) g;
                g2d.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
                GradientPaint gp = new GradientPaint(0, 0, new Color(255, 165, 0), getWidth(), 0, new Color(230, 126, 34));
                g2d.setPaint(gp);
                g2d.fillRect(0, 0, getWidth(), getHeight());
            }
        };
        header.setLayout(null);
        header.setBounds(0, 0, 950, 90);
        add(header);

        JLabel title = new JLabel("ADWAL PRAKTIK DOKTER HEWAN", SwingConstants.CENTER);
        title.setForeground(Color.WHITE);
        title.setFont(new Font("Segoe UI", Font.BOLD, 26));
        title.setBounds(0, 28, 950, 35);
        header.add(title);

        JPanel formPanel = new JPanel();
        formPanel.setLayout(null);
        formPanel.setBackground(Color.WHITE);
        formPanel.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(new Color(200, 200, 200), 1),
                BorderFactory.createEmptyBorder(15, 20, 20, 20)
        ));
        formPanel.setBounds(30, 115, 360, 380);
        add(formPanel);

        JLabel formTitle = new JLabel("FORM JADWAL");
        formTitle.setFont(new Font("Segoe UI", Font.BOLD, 20));
        formTitle.setForeground(new Color(255, 165, 0));
        formTitle.setBounds(20, 10, 200, 30);
        formPanel.add(formTitle);

        JLabel lblDokter = new JLabel("Pilih Dokter");
        lblDokter.setFont(new Font("Segoe UI", Font.BOLD, 13));
        lblDokter.setBounds(20, 60, 120, 25);
        formPanel.add(lblDokter);
        cbDokter = new JComboBox<>();
        cbDokter.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        cbDokter.setBounds(20, 85, 300, 35);
        cbDokter.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(new Color(200, 200, 200)),
                BorderFactory.createEmptyBorder(5, 10, 5, 10)
        ));
        formPanel.add(cbDokter);

        JLabel lblTanggal = new JLabel("Tanggal (YYYY-MM-DD)");
        lblTanggal.setFont(new Font("Segoe UI", Font.BOLD, 13));
        lblTanggal.setBounds(20, 135, 180, 25);
        formPanel.add(lblTanggal);
        txtTanggal = new JTextField();
        txtTanggal.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        txtTanggal.setBounds(20, 160, 300, 35);
        txtTanggal.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(new Color(200, 200, 200)),
                BorderFactory.createEmptyBorder(5, 10, 5, 10)
        ));
        formPanel.add(txtTanggal);

        JLabel lblJam = new JLabel("Jam (HH:MM:SS)");
        lblJam.setFont(new Font("Segoe UI", Font.BOLD, 13));
        lblJam.setBounds(20, 210, 150, 25);
        formPanel.add(lblJam);
        txtJam = new JTextField();
        txtJam.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        txtJam.setBounds(20, 235, 300, 35);
        txtJam.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(new Color(200, 200, 200)),
                BorderFactory.createEmptyBorder(5, 10, 5, 10)
        ));
        formPanel.add(txtJam);

        JPanel tablePanel = new JPanel();
        tablePanel.setLayout(null);
        tablePanel.setBackground(Color.WHITE);
        tablePanel.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(new Color(200, 200, 200), 1),
                BorderFactory.createEmptyBorder(15, 20, 20, 20)
        ));
        tablePanel.setBounds(420, 115, 500, 460);
        add(tablePanel);

        JLabel tableTitle = new JLabel(" DATA JADWAL");
        tableTitle.setFont(new Font("Segoe UI", Font.BOLD, 20));
        tableTitle.setForeground(new Color(255, 165, 0));
        tableTitle.setBounds(160, 10, 200, 30);
        tablePanel.add(tableTitle);

        tableJadwal = new JTable();
        tableJadwal.setFont(new Font("Segoe UI", Font.PLAIN, 13));
        tableJadwal.setRowHeight(25);
        JScrollPane scrollPane = new JScrollPane(tableJadwal);
        scrollPane.setBounds(20, 50, 460, 280);
        scrollPane.getViewport().setBackground(Color.WHITE);
        tablePanel.add(scrollPane);

        btnTambah = new JButton(" Tambah");
        btnTambah.setBounds(20, 360, 105, 40);
        styleButton(btnTambah, new Color(46, 204, 113));
        tablePanel.add(btnTambah);

        btnEdit = new JButton("️ Edit");
        btnEdit.setBounds(135, 360, 95, 40);
        styleButton(btnEdit, new Color(52, 152, 219));
        tablePanel.add(btnEdit);

        btnHapus = new JButton("Hapus");
        btnHapus.setBounds(240, 360, 105, 40);
        styleButton(btnHapus, new Color(231, 76, 60));
        tablePanel.add(btnHapus);

        btnReset = new JButton("Reset");
        btnReset.setBounds(355, 360, 95, 40);
        styleButton(btnReset, new Color(155, 89, 182));
        tablePanel.add(btnReset);

        btnKembali = new JButton("← Kembali ke Dashboard");
        btnKembali.setBounds(30, 580, 180, 38);
        styleButton(btnKembali, new Color(108, 117, 125));
        add(btnKembali);

        JLabel footer = new JLabel("Sistem Manajemen Klinik Hewan | © 2026");
        footer.setFont(new Font("Segoe UI", Font.PLAIN, 12));
        footer.setForeground(Color.GRAY);
        footer.setBounds(380, 590, 300, 20);
        add(footer);

        controller = new JadwalController(this);
        controller.loadDokterToCombo();
        controller.tampilData();

        tableJadwal.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int baris = tableJadwal.getSelectedRow();
                if (baris >= 0) {
                    int id = (int) tableJadwal.getValueAt(baris, 0);
                    controller.idJadwal = id;
                    String namaDokter = (String) tableJadwal.getValueAt(baris, 1);
                    for (int i = 0; i < cbDokter.getItemCount(); i++) {
                        if (cbDokter.getItemAt(i).startsWith(namaDokter)) {
                            cbDokter.setSelectedIndex(i);
                            break;
                        }
                    }
                    txtTanggal.setText((String) tableJadwal.getValueAt(baris, 2));
                    txtJam.setText((String) tableJadwal.getValueAt(baris, 3));
                }
            }
        });

        btnTambah.addActionListener(e -> controller.simpanData());
        btnEdit.addActionListener(e -> controller.editData());
        btnHapus.addActionListener(e -> controller.hapusData());
        btnReset.addActionListener(e -> controller.resetForm());
        btnKembali.addActionListener(e -> dispose());
    }

    private void styleButton(JButton button, Color color) {
        button.setBackground(color);
        button.setForeground(Color.WHITE);
        button.setFocusPainted(false);
        button.setFont(new Font("Segoe UI", Font.BOLD, 13));
        button.setCursor(new Cursor(Cursor.HAND_CURSOR));
        button.setBorder(BorderFactory.createEmptyBorder(5, 10, 5, 10));
        button.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                button.setBackground(button.getBackground().darker());
            }
            @Override
            public void mouseExited(MouseEvent e) {
                button.setBackground(color);
            }
        });
    }
}