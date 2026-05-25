/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

import controller.HewanController;
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
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class HewanView extends JFrame {

    public JTextField txtNama;
    public JTextField txtJenis;
    public JTextField txtUmur;
    public JTextField txtPemilik;

    public JTable tableHewan;

    JButton btnTambah;
    JButton btnEdit;
    JButton btnHapus;
    JButton btnReset;
    JButton btnKembali;

    HewanController controller;
    int selectedId;

    public HewanView() {
        setTitle("Data Hewan");
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
                GradientPaint gp = new GradientPaint(0, 0, new Color(52, 152, 219), getWidth(), 0, new Color(41, 128, 185));
                g2d.setPaint(gp);
                g2d.fillRect(0, 0, getWidth(), getHeight());
            }
        };
        header.setLayout(null);
        header.setBounds(0, 0, 950, 90);
        add(header);

        JLabel title = new JLabel("🐾 DATA PASIEN HEWAN", SwingConstants.CENTER);
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
        formPanel.setBounds(30, 115, 360, 420);
        add(formPanel);

        JLabel formTitle = new JLabel(" FORM DATA HEWAN");
        formTitle.setFont(new Font("Segoe UI", Font.BOLD, 20));
        formTitle.setForeground(new Color(52, 152, 219));
        formTitle.setBounds(20, 10, 250, 30);
        formPanel.add(formTitle);

        JLabel lblNama = new JLabel("Nama Hewan");
        lblNama.setFont(new Font("Segoe UI", Font.BOLD, 13));
        lblNama.setBounds(20, 60, 120, 25);
        formPanel.add(lblNama);
        txtNama = new JTextField();
        txtNama.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        txtNama.setBounds(20, 85, 300, 35);
        txtNama.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(new Color(200, 200, 200)),
                BorderFactory.createEmptyBorder(5, 10, 5, 10)
        ));
        formPanel.add(txtNama);

        JLabel lblJenis = new JLabel("Jenis Hewan");
        lblJenis.setFont(new Font("Segoe UI", Font.BOLD, 13));
        lblJenis.setBounds(20, 135, 120, 25);
        formPanel.add(lblJenis);
        txtJenis = new JTextField();
        txtJenis.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        txtJenis.setBounds(20, 160, 300, 35);
        txtJenis.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(new Color(200, 200, 200)),
                BorderFactory.createEmptyBorder(5, 10, 5, 10)
        ));
        formPanel.add(txtJenis);

        JLabel lblUmur = new JLabel("Umur (tahun)");
        lblUmur.setFont(new Font("Segoe UI", Font.BOLD, 13));
        lblUmur.setBounds(20, 210, 120, 25);
        formPanel.add(lblUmur);
        txtUmur = new JTextField();
        txtUmur.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        txtUmur.setBounds(20, 235, 300, 35);
        txtUmur.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(new Color(200, 200, 200)),
                BorderFactory.createEmptyBorder(5, 10, 5, 10)
        ));
        formPanel.add(txtUmur);

        JLabel lblPemilik = new JLabel("Nama Pemilik");
        lblPemilik.setFont(new Font("Segoe UI", Font.BOLD, 13));
        lblPemilik.setBounds(20, 285, 120, 25);
        formPanel.add(lblPemilik);
        txtPemilik = new JTextField();
        txtPemilik.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        txtPemilik.setBounds(20, 310, 300, 35);
        txtPemilik.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(new Color(200, 200, 200)),
                BorderFactory.createEmptyBorder(5, 10, 5, 10)
        ));
        formPanel.add(txtPemilik);

        JPanel tablePanel = new JPanel();
        tablePanel.setLayout(null);
        tablePanel.setBackground(Color.WHITE);
        tablePanel.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(new Color(200, 200, 200), 1),
                BorderFactory.createEmptyBorder(15, 20, 20, 20)
        ));
        tablePanel.setBounds(420, 115, 500, 460);
        add(tablePanel);

        JLabel tableTitle = new JLabel(" DATA PASIEN");
        tableTitle.setFont(new Font("Segoe UI", Font.BOLD, 20));
        tableTitle.setForeground(new Color(52, 152, 219));
        tableTitle.setBounds(160, 10, 200, 30);
        tablePanel.add(tableTitle);

        tableHewan = new JTable();
        tableHewan.setFont(new Font("Segoe UI", Font.PLAIN, 13));
        tableHewan.setRowHeight(25);
        JScrollPane scrollPane = new JScrollPane(tableHewan);
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

        btnHapus = new JButton("️ Hapus");
        btnHapus.setBounds(240, 360, 105, 40);
        styleButton(btnHapus, new Color(231, 76, 60));
        tablePanel.add(btnHapus);

        btnReset = new JButton(" Reset");
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

        controller = new HewanController(this);
        controller.tampilData();

        tableHewan.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int baris = tableHewan.getSelectedRow();
                if (baris >= 0) {
                    selectedId = Integer.parseInt(tableHewan.getValueAt(baris, 0).toString());
                    controller.idHewan = selectedId;
                    txtNama.setText(tableHewan.getValueAt(baris, 1).toString());
                    txtJenis.setText(tableHewan.getValueAt(baris, 2).toString());
                    txtUmur.setText(tableHewan.getValueAt(baris, 3).toString());
                    txtPemilik.setText(tableHewan.getValueAt(baris, 4).toString());
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