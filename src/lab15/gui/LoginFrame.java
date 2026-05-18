package lab15.gui;
import lab15.dao.UserDAO;
import lab15.model.User;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.sql.SQLException;

public class LoginFrame extends JFrame {

    // UI Components 
    private final JTextField     usernameField;
    private final JTextField     emailField;
    private final JPasswordField passwordField;
    private final JLabel         messageLabel;
    private final JButton        loginButton;

    // DAO 
    private final UserDAO userDAO = new UserDAO();

    // Colour palette (matches mockup) 
    private static final Color BG_TOP    = new Color(173, 216, 230); // light-blue
    private static final Color BG_BOT    = new Color(200, 230, 245);
    private static final Color CARD_BG   = new Color(245, 248, 252);
    private static final Color BLUE_BTN  = new Color(30, 100, 180);
    private static final Color BLUE_LINK = new Color(30, 100, 180);
    private static final Color TITLE_CLR = new Color(20, 70, 130);
    private static final Color FIELD_BG  = Color.WHITE;
    private static final Color HINT_CLR  = new Color(150, 160, 175);
    private static final Color ERR_CLR   = new Color(200, 50, 50);
    private static final Color OK_CLR    = new Color(30, 140, 80);

    // Constructor 
    public LoginFrame() {
        setTitle("Login");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(900, 620);
        setLocationRelativeTo(null);
        setResizable(false);

        // Gradient background panel 
        JPanel background = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                Graphics2D g2 = (Graphics2D) g;
                g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                                    RenderingHints.VALUE_ANTIALIAS_ON);

                // Gradient sky
                GradientPaint gp = new GradientPaint(
                    0, 0, BG_TOP, getWidth(), getHeight(), BG_BOT);
                g2.setPaint(gp);
                g2.fillRect(0, 0, getWidth(), getHeight());

                // Decorative blobs (left)
                g2.setComposite(AlphaComposite.getInstance(
                    AlphaComposite.SRC_OVER, 0.55f));
                g2.setColor(new Color(80, 140, 220));
                g2.fillOval(-60, 180, 260, 220);
                g2.setColor(new Color(30, 80, 200));
                g2.fillOval(30, 280, 160, 160);

                // Decorative blobs (right)
                g2.setColor(new Color(80, 160, 230));
                g2.fillOval(620, 40, 280, 260);
                g2.setColor(new Color(50, 100, 210));
                g2.fillOval(700, 120, 180, 160);

                g2.setComposite(AlphaComposite.getInstance(
                    AlphaComposite.SRC_OVER, 1.0f));
            }
        };
        background.setLayout(new GridBagLayout());
        setContentPane(background);

        // Card panel 
        JPanel card = new JPanel();
        card.setOpaque(true);
        card.setBackground(CARD_BG);
        card.setPreferredSize(new Dimension(380, 460));
        card.setLayout(new BoxLayout(card, BoxLayout.Y_AXIS));
        card.setBorder(new EmptyBorder(40, 40, 36, 40));

        // Rounded corners via a custom border
        card.setBorder(BorderFactory.createCompoundBorder(
            new RoundedBorder(18, new Color(210, 220, 235), CARD_BG),
            new EmptyBorder(36, 40, 36, 40)
        ));

        // Title 
        JLabel titleLabel = new JLabel("Login", SwingConstants.CENTER);
        titleLabel.setFont(new Font("Segoe UI", Font.PLAIN, 34));
        titleLabel.setForeground(TITLE_CLR);
        titleLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        card.add(titleLabel);
        card.add(Box.createVerticalStrut(28));

        // Username field 
        usernameField = createPlaceholderField("User Name");
        card.add(usernameField);
        card.add(Box.createVerticalStrut(14));

        // Email field 
        emailField = createPlaceholderField("Email Address");
        card.add(emailField);
        card.add(Box.createVerticalStrut(14));

        // Password field 
        passwordField = new JPasswordField();
        stylePlaceholder(passwordField, "Password");
        card.add(passwordField);
        card.add(Box.createVerticalStrut(22));

        // Login button 
        loginButton = new JButton("Login");
        loginButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        loginButton.setMaximumSize(new Dimension(Integer.MAX_VALUE, 44));
        loginButton.setFont(new Font("Segoe UI", Font.BOLD, 15));
        loginButton.setForeground(Color.WHITE);
        loginButton.setBackground(BLUE_BTN);
        loginButton.setFocusPainted(false);
        loginButton.setBorderPainted(false);
        loginButton.setOpaque(true);
        loginButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        loginButton.addActionListener(this::handleLogin);
        card.add(loginButton);
        card.add(Box.createVerticalStrut(14));

        // Message label 
        messageLabel = new JLabel(" ", SwingConstants.CENTER);
        messageLabel.setFont(new Font("Segoe UI", Font.PLAIN, 13));
        messageLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        card.add(messageLabel);
        card.add(Box.createVerticalStrut(6));

        // Register link 
        JLabel registerLabel = new JLabel("Register Now", SwingConstants.CENTER);
        registerLabel.setFont(new Font("Segoe UI", Font.PLAIN, 13));
        registerLabel.setForeground(BLUE_LINK);
        registerLabel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        registerLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        card.add(registerLabel);

        background.add(card);
        setVisible(true);
    }

    // Helper: create a styled text field with placeholder 
    private JTextField createPlaceholderField(String placeholder) {
        JTextField field = new JTextField();
        stylePlaceholder(field, placeholder);
        return field;
    }

    /** Applies consistent styling + placeholder behaviour to any JTextField. */
    private void stylePlaceholder(JTextField field, String placeholder) {
        field.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        field.setForeground(HINT_CLR);
        field.setBackground(FIELD_BG);
        field.setMaximumSize(new Dimension(Integer.MAX_VALUE, 44));
        field.setBorder(BorderFactory.createCompoundBorder(
            BorderFactory.createLineBorder(new Color(200, 210, 225), 1, true),
            new EmptyBorder(8, 14, 8, 14)
        ));
        field.setText(placeholder);

        field.addFocusListener(new java.awt.event.FocusAdapter() {
            @Override
            public void focusGained(java.awt.event.FocusEvent e) {
                if (field.getText().equals(placeholder)) {
                    field.setText("");
                    field.setForeground(Color.DARK_GRAY);
                    if (field instanceof JPasswordField) {
                        ((JPasswordField) field).setEchoChar('•');
                    }
                }
            }
            @Override
            public void focusLost(java.awt.event.FocusEvent e) {
                if (field.getText().isEmpty()) {
                    field.setText(placeholder);
                    field.setForeground(HINT_CLR);
                    if (field instanceof JPasswordField) {
                        ((JPasswordField) field).setEchoChar((char) 0);
                    }
                }
            }
        });

        // JPasswordField shows placeholder as plain text initially
        if (field instanceof JPasswordField) {
            ((JPasswordField) field).setEchoChar((char) 0);
        }
    }

    // Login handler 
    private void handleLogin(ActionEvent e) {
        String username = usernameField.getText().trim();
        String password = new String(passwordField.getPassword()).trim();

        // Basic validation
        if (username.isEmpty() || username.equals("User Name")) {
            showMessage("Please enter your username.", ERR_CLR);
            return;
        }
        if (password.isEmpty() || password.equals("Password")) {
            showMessage("Please enter your password.", ERR_CLR);
            return;
        }

        loginButton.setEnabled(false);
        loginButton.setText("Logging in…");

        // Run DB call on a background thread to keep UI responsive
        SwingWorker<User, Void> worker = new SwingWorker<>() {
            @Override
            protected User doInBackground() throws Exception {
                return userDAO.authenticate(username, password);
            }

            @Override
            protected void done() {
                try {
                    User user = get();
                    if (user != null) {
                        showMessage("✓ Login successful! Welcome, "
                            + user.getUsername() + ".", OK_CLR);
                        // TODO: open the main application window here
                    } else {
                        showMessage("✗ Invalid username or password.", ERR_CLR);
                    }
                } catch (Exception ex) {
                    Throwable cause = ex.getCause() != null ? ex.getCause() : ex;
                    showMessage("✗ DB Error: " + cause.getMessage(), ERR_CLR);
                    cause.printStackTrace();
                } finally {
                    loginButton.setEnabled(true);
                    loginButton.setText("Login");
                }
            }
        };
        worker.execute();
    }

    private void showMessage(String msg, Color color) {
        messageLabel.setText(msg);
        messageLabel.setForeground(color);
    }

    // Inner class: rounded-rectangle border 
    private static class RoundedBorder extends javax.swing.border.AbstractBorder {
        private final int   arc;
        private final Color borderColor;
        private final Color fillColor;

        RoundedBorder(int arc, Color borderColor, Color fillColor) {
            this.arc         = arc;
            this.borderColor = borderColor;
            this.fillColor   = fillColor;
        }

        @Override
        public void paintBorder(Component c, Graphics g,
                                int x, int y, int w, int h) {
            Graphics2D g2 = (Graphics2D) g.create();
            g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                                RenderingHints.VALUE_ANTIALIAS_ON);
            // Fill
            g2.setColor(fillColor);
            g2.fillRoundRect(x, y, w - 1, h - 1, arc, arc);
            // Border
            g2.setColor(borderColor);
            g2.drawRoundRect(x, y, w - 1, h - 1, arc, arc);
            g2.dispose();
        }

        @Override
        public Insets getBorderInsets(Component c) {
            return new Insets(arc / 2, arc / 2, arc / 2, arc / 2);
        }
        @Override
        public boolean isBorderOpaque() { return false; }
    }
}
