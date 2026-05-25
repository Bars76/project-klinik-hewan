/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

import controller.RekamMedisController;
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
import javax.swing.JTextArea;
import javax.swing.SwingConstants;

public class RekamMedisView extends JFrame {

    public JComboBox<String> cbHewan;
    public JTextArea txtDiagnosa;
    public JTextArea txtTindakan;
    public JTextArea txtObat;

    JButton btnTambah;
    JButton btnEdit;
    JButton btnHapus;
    JButton btnReset;
    JButton btnKembali;

    public JTable tableRekam;

    RekamMedisController controller;
    int selectedId;

    public RekamMedisView() {
        setTitle("Rekam Medis");
        setSize(950, 680);
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
                GradientPaint gp = new GradientPaint(0, 0, new Color(231, 76, 60), getWidth(), 0, new Color(192, 57, 43));
                g2d.setPaint(gp);
                g2d.fillRect(0, 0, getWidth(), getHeight());
            }
        };
        header.setLayout(null);
        header.setBounds(0, 0, 950, 90);
        add(header);

        JLabel title = new JLabel("REKAM MEDIS PASIEN HEWAN", SwingConstants.CENTER);
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
        formPanel.setBounds(30, 115, 360, 490);
        add(formPanel);

        JLabel formTitle = new JLabel("FORM REKAM MEDIS");
        formTitle.setFont(new Font("Segoe UI", Font.BOLD, 20));
        formTitle.setForeground(new Color(231, 76, 60));
        formTitle.setBounds(20, 10, 250, 30);
        formPanel.add(formTitle);

        JLabel lblHewan = new JLabel("Pilih Hewan");
        lblHewan.setFont(new Font("Segoe UI", Font.BOLD, 13));
        lblHewan.setBounds(20, 60, 120, 25);
        formPanel.add(lblHewan);

        cbHewan = new JComboBox<>();
        cbHewan.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        cbHewan.setBounds(20, 85, 300, 35);
        cbHewan.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(new Color(200, 200, 200)),
                BorderFactory.createEmptyBorder(5, 10, 5, 10)
        ));
        formPanel.add(cbHewan);

        JLabel lblDiagnosa = new JLabel("Diagnosa");
        lblDiagnosa.setFont(new Font("Segoe UI", Font.BOLD, 13));
        lblDiagnosa.setBounds(20, 135, 120, 25);
        formPanel.add(lblDiagnosa);

        txtDiagnosa = new JTextArea();
        txtDiagnosa.setLineWrap(true);
        txtDiagnosa.setFont(new Font("Segoe UI", Font.PLAIN, 13));
        JScrollPane spDiagnosa = new JScrollPane(txtDiagnosa);
        spDiagnosa.setBounds(20, 160, 300, 70);
        spDiagnosa.setBorder(BorderFactory.createLineBorder(new Color(200, 200, 200)));
        formPanel.add(spDiagnosa);

        JLabel lblTindakan = new JLabel("Tindakan");
        lblTindakan.setFont(new Font("Segoe UI", Font.BOLD, 13));
        lblTindakan.setBounds(20, 245, 120, 25);
        formPanel.add(lblTindakan);

        txtTindakan = new JTextArea();
        txtTindakan.setLineWrap(true);
        txtTindakan.setFont(new Font("Segoe UI", Font.PLAIN, 13));
        JScrollPane spTindakan = new JScrollPane(txtTindakan);
        spTindakan.setBounds(20, 270, 300, 70);
        spTindakan.setBorder(BorderFactory.createLineBorder(new Color(200, 200, 200)));
        formPanel.add(spTindakan);

        JLabel lblObat = new JLabel("Obat");
        lblObat.setFont(new Font("Segoe UI", Font.BOLD, 13));
        lblObat.setBounds(20, 355, 120, 25);
        formPanel.add(lblObat);

        txtObat = new JTextArea();
        txtObat.setLineWrap(true);
        txtObat.setFont(new Font("Segoe UI", Font.PLAIN, 13));
        JScrollPane spObat = new JScrollPane(txtObat);
        spObat.setBounds(20, 380, 300, 70);
        spObat.setBorder(BorderFactory.createLineBorder(new Color(200, 200, 200)));
        formPanel.add(spObat);

        JPanel tablePanel = new JPanel();
        tablePanel.setLayout(null);
        tablePanel.setBackground(Color.WHITE);
        tablePanel.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(new Color(200, 200, 200), 1),
                BorderFactory.createEmptyBorder(15, 20, 20, 20)
        ));
        tablePanel.setBounds(420, 115, 500, 490);
        add(tablePanel);

        JLabel tableTitle = new JLabel("? DATA REKAM MEDIS");
        tableTitle.setFont(new Font("Segoe UI", Font.BOLD, 20));
        tableTitle.setForeground(new Color(231, 76, 60));
        tableTitle.setBounds(145, 10, 250, 30);
        tablePanel.add(tableTitle);

        tableRekam = new JTable();
        tableRekam.setFont(new Font("Segoe UI", Font.PLAIN, 13));
        tableRekam.setRowHeight(25);
        JScrollPane scrollPane = new JScrollPane(tableRekam);
        scrollPane.setBounds(20, 50, 460, 310);
        scrollPane.getViewport().setBackground(Color.WHITE);
        tablePanel.add(scrollPane);

        btnTambah = new JButton(" Tambah");
        btnTambah.setBounds(20, 390, 105, 40);
        styleButton(btnTambah, new Color(46, 204, 113));
        tablePanel.add(btnTambah);

        btnEdit = new JButton("️ Edit");
        btnEdit.setBounds(135, 390, 95, 40);
        styleButton(btnEdit, new Color(52, 152, 219));
        tablePanel.add(btnEdit);

        btnHapus = new JButton("️ Hapus");
        btnHapus.setBounds(240, 390, 105, 40);
        styleButton(btnHapus, new Color(231, 76, 60));
        tablePanel.add(btnHapus);

        btnReset = new JButton("? Reset");
        btnReset.setBounds(355, 390, 95, 40);
        styleButton(btnReset, new Color(155, 89, 182));
        tablePanel.add(btnReset);

        btnKembali = new JButton("← Kembali ke Dashboard");
        btnKembali.setBounds(30, 610, 180, 38);
        styleButton(btnKembali, new Color(108, 117, 125));
        add(btnKembali);

        JLabel footer = new JLabel("Sistem Manajemen Klinik Hewan | © 2026");
        footer.setFont(new Font("Segoe UI", Font.PLAIN, 12));
        footer.setForeground(Color.GRAY);
        footer.setBounds(380, 610, 300, 20);
        add(footer);

        controller = new RekamMedisController(this);
        controller.tampilData();
        controller.loadHewanToCombo();

        tableRekam.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int baris = tableRekam.getSelectedRow();
                if (baris >= 0) {
                    selectedId = Integer.parseInt(tableRekam.getValueAt(baris, 0).toString());
                    controller.idRekam = selectedId;
                    cbHewan.setSelectedItem(tableRekam.getValueAt(baris, 1).toString());
                    txtDiagnosa.setText(tableRekam.getValueAt(baris, 2).toString());
                    txtTindakan.setText(tableRekam.getValueAt(baris, 3).toString());
                    txtObat.setText(tableRekam.getValueAt(baris, 4).toString());
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
