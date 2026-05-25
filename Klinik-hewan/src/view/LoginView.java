package view;

import controller.LoginController;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class LoginView extends JFrame {

    private JTextField txtUsername;
    private JPasswordField txtPassword;
    private JButton btnLogin;

    public LoginView() {
        initComponents();
    }

    private void initComponents() {
        setTitle("Login - Klinik Hewan");
        setSize(450, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(true); // Bisa diubah ukurannya (fullscreen)
        getContentPane().setBackground(new Color(240, 244, 248));
        setLayout(null);

        JPanel cardPanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                Graphics2D g2 = (Graphics2D) g;
                g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
                g2.setColor(getBackground());
                g2.fillRoundRect(0, 0, getWidth(), getHeight(), 30, 30);
            }
        };
        cardPanel.setBackground(Color.WHITE);
        cardPanel.setLayout(null);
        cardPanel.setBounds(35, 35, 380, 420);
        cardPanel.setBorder(BorderFactory.createLineBorder(new Color(200, 200, 200), 1));
        add(cardPanel);

        JLabel title = new JLabel("Klinik Hewan", SwingConstants.CENTER);
        title.setFont(new Font("Segoe UI", Font.BOLD, 26));
        title.setForeground(new Color(46, 134, 222));
        title.setBounds(0, 30, 380, 40);
        cardPanel.add(title);

        JLabel subtitle = new JLabel("Sistem Manajemen Klinik", SwingConstants.CENTER);
        subtitle.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        subtitle.setForeground(Color.GRAY);
        subtitle.setBounds(0, 75, 380, 25);
        cardPanel.add(subtitle);

        JLabel lblUsername = new JLabel("Username");
        lblUsername.setFont(new Font("Segoe UI", Font.BOLD, 13));
        lblUsername.setForeground(new Color(80, 80, 80));
        lblUsername.setBounds(50, 130, 280, 25);
        cardPanel.add(lblUsername);

        txtUsername = new JTextField();
        txtUsername.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        txtUsername.setBounds(50, 155, 280, 35);
        txtUsername.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(new Color(200, 200, 200)),
                BorderFactory.createEmptyBorder(5, 10, 5, 10)
        ));
        cardPanel.add(txtUsername);

        JLabel lblPassword = new JLabel("Password");
        lblPassword.setFont(new Font("Segoe UI", Font.BOLD, 13));
        lblPassword.setForeground(new Color(80, 80, 80));
        lblPassword.setBounds(50, 205, 280, 25);
        cardPanel.add(lblPassword);

        txtPassword = new JPasswordField();
        txtPassword.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        txtPassword.setBounds(50, 230, 280, 35);
        txtPassword.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(new Color(200, 200, 200)),
                BorderFactory.createEmptyBorder(5, 10, 5, 10)
        ));
        cardPanel.add(txtPassword);

        btnLogin = new JButton("LOGIN");
        btnLogin.setFont(new Font("Segoe UI", Font.BOLD, 14));
        btnLogin.setForeground(Color.WHITE);
        btnLogin.setBackground(new Color(46, 134, 222));
        btnLogin.setFocusPainted(false);
        btnLogin.setBorderPainted(false);
        btnLogin.setBounds(100, 295, 180, 40);
        btnLogin.setCursor(new Cursor(Cursor.HAND_CURSOR));

        btnLogin.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                btnLogin.setBackground(new Color(41, 128, 185));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                btnLogin.setBackground(new Color(46, 134, 222));
            }
        });
        cardPanel.add(btnLogin);

        JLabel footer = new JLabel("© 2026 - Klinik Hewan", SwingConstants.CENTER);
        footer.setFont(new Font("Segoe UI", Font.PLAIN, 11));
        footer.setForeground(Color.LIGHT_GRAY);
        footer.setBounds(0, 385, 380, 20);
        cardPanel.add(footer);

        btnLogin.addActionListener(e -> {
            LoginController lc = new LoginController();
            String username = txtUsername.getText();
            String password = new String(txtPassword.getPassword());
            if (lc.login(username, password)) {
                JOptionPane.showMessageDialog(null, "Login Berhasil!", "Sukses", JOptionPane.INFORMATION_MESSAGE);
                new DashboardView().setVisible(true);
                dispose();
            } else {
                JOptionPane.showMessageDialog(null, "Username atau Password Salah!", "Gagal Login", JOptionPane.ERROR_MESSAGE);
            }
        });
    }
}