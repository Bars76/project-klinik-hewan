/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

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
import javax.swing.SwingConstants;
import threading.JamThread;

public class DashboardView extends JFrame {

    JLabel lblJam;
    JButton btnHewan, btnDokter, btnJadwal, btnRekam, btnLogout;

    public DashboardView() {
        setTitle("Dashboard Klinik Hewan");
        setSize(900, 600);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        getContentPane().setBackground(new Color(240, 244, 248));
        setLayout(null);

        JPanel header = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                Graphics2D g2d = (Graphics2D) g;
                g2d.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
                GradientPaint gp = new GradientPaint(0, 0, new Color(46, 134, 222), getWidth(), 0, new Color(52, 73, 94));
                g2d.setPaint(gp);
                g2d.fillRect(0, 0, getWidth(), getHeight());
            }
        };
        header.setLayout(null);
        header.setBounds(0, 0, 900, 100);
        add(header);

        JLabel title = new JLabel(" SISTEM MANAJEMEN KLINIK HEWAN", SwingConstants.CENTER);
        title.setForeground(Color.WHITE);
        title.setFont(new Font("Segoe UI", Font.BOLD, 24));
        title.setBounds(0, 25, 900, 35);
        header.add(title);

        lblJam = new JLabel();
        lblJam.setFont(new Font("Segoe UI", Font.BOLD, 18));
        lblJam.setForeground(Color.WHITE);
        lblJam.setBounds(760, 35, 120, 30);
        header.add(lblJam);
        JamThread jt = new JamThread(lblJam);
        jt.start();

        JPanel panelMenu = new JPanel();
        panelMenu.setLayout(null);
        panelMenu.setBackground(Color.WHITE);
        panelMenu.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(new Color(200, 200, 200), 1),
                BorderFactory.createEmptyBorder(20, 30, 30, 30)
        ));
        panelMenu.setBounds(100, 130, 700, 320);
        add(panelMenu);

        JLabel menuTitle = new JLabel(" MENU UTAMA");
        menuTitle.setFont(new Font("Segoe UI", Font.BOLD, 22));
        menuTitle.setForeground(new Color(52, 73, 94));
        menuTitle.setBounds(270, 10, 200, 35);
        panelMenu.add(menuTitle);

        btnHewan = createMenuButton(" Data Hewan", 80, 80);
        btnDokter = createMenuButton("️ Data Dokter", 370, 80);
        btnJadwal = createMenuButton(" Jadwal Konsultasi", 80, 170);
        btnRekam = createMenuButton(" Rekam Medis", 370, 170);
        panelMenu.add(btnHewan);
        panelMenu.add(btnDokter);
        panelMenu.add(btnJadwal);
        panelMenu.add(btnRekam);

        btnLogout = new JButton("🚪 Logout");
        btnLogout.setFont(new Font("Segoe UI", Font.BOLD, 14));
        btnLogout.setForeground(Color.WHITE);
        btnLogout.setBackground(new Color(231, 76, 60));
        btnLogout.setFocusPainted(false);
        btnLogout.setBorderPainted(false);
        btnLogout.setCursor(new Cursor(Cursor.HAND_CURSOR));
        btnLogout.setBounds(750, 520, 120, 40);
        add(btnLogout);
        btnLogout.addMouseListener(new MouseAdapter() {
            public void mouseEntered(MouseEvent e) { btnLogout.setBackground(new Color(192, 57, 43)); }
            public void mouseExited(MouseEvent e) { btnLogout.setBackground(new Color(231, 76, 60)); }
        });

        JLabel footer = new JLabel("© 2026 - Klinik Hewan | Versi 1.0");
        footer.setFont(new Font("Segoe UI", Font.PLAIN, 12));
        footer.setForeground(Color.GRAY);
        footer.setBounds(350, 570, 250, 20);
        add(footer);

        btnHewan.addActionListener(e -> new HewanView().setVisible(true));
        btnDokter.addActionListener(e -> new DokterView().setVisible(true));
        btnJadwal.addActionListener(e -> new JadwalView().setVisible(true));
        btnRekam.addActionListener(e -> new RekamMedisView().setVisible(true));
        btnLogout.addActionListener(e -> {
            new LoginView().setVisible(true);
            dispose();
        });
    }

    private JButton createMenuButton(String text, int x, int y) {
        JButton btn = new JButton(text);
        btn.setBounds(x, y, 240, 60);
        btn.setFont(new Font("Segoe UI", Font.BOLD, 16));
        btn.setForeground(Color.WHITE);
        btn.setBackground(new Color(52, 152, 219));
        btn.setFocusPainted(false);
        btn.setBorderPainted(false);
        btn.setCursor(new Cursor(Cursor.HAND_CURSOR));
        btn.addMouseListener(new MouseAdapter() {
            public void mouseEntered(MouseEvent e) { btn.setBackground(new Color(41, 128, 185)); }
            public void mouseExited(MouseEvent e) { btn.setBackground(new Color(52, 152, 219)); }
        });
        return btn;
    }
}