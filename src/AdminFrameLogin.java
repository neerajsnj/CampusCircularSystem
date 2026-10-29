import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class AdminLoginFrame {

    private static final Color PAGE_COLOR = new Color(241, 245, 249);
    private static final Color CARD_COLOR = Color.WHITE;
    private static final Color TITLE_COLOR = new Color(30, 58, 85);
    private static final Color PRIMARY_COLOR = new Color(37, 99, 235);
    private static final Color SECONDARY_COLOR = new Color(226, 232, 240);
    private static final Color FIELD_BORDER = new Color(203, 213, 225);

    public static void main(String[] args) {
        SwingUtilities.invokeLater(AdminLoginFrame::showWindow);
    }

    private static void showWindow() {
        JFrame frame = new JFrame("Admin Login");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JLabel title = new JLabel("ADMIN LOGIN");
        title.setFont(new Font("Arial", Font.BOLD, 26));
        title.setForeground(TITLE_COLOR);
        title.setHorizontalAlignment(SwingConstants.CENTER);

        JLabel subtitle = new JLabel("Sign in to manage campus circulars");
        subtitle.setFont(new Font("Arial", Font.PLAIN, 14));
        subtitle.setForeground(new Color(100, 116, 139));
        subtitle.setHorizontalAlignment(SwingConstants.CENTER);

        JPanel headingPanel = new JPanel(new GridLayout(2, 1, 0, 8));
        headingPanel.setOpaque(false);
        headingPanel.add(title);
        headingPanel.add(subtitle);

        JLabel usernameLabel = new JLabel("Admin Username:");
        JLabel passwordLabel = new JLabel("Admin Password:");
        usernameLabel.setFont(new Font("Arial", Font.BOLD, 14));
        passwordLabel.setFont(new Font("Arial", Font.BOLD, 14));
        usernameLabel.setForeground(TITLE_COLOR);
        passwordLabel.setForeground(TITLE_COLOR);

        JTextField usernameField = new JTextField();
        JPasswordField passwordField = new JPasswordField();
        styleField(usernameField);
        styleField(passwordField);

        JButton loginButton = new JButton("Login");
        JButton clearButton = new JButton("Clear");
        JButton backButton = new JButton("Back");

        styleButton(loginButton, PRIMARY_COLOR, Color.WHITE, 125);
        styleButton(clearButton, SECONDARY_COLOR, TITLE_COLOR, 125);
        styleButton(backButton, SECONDARY_COLOR, TITLE_COLOR, 110);

        JPanel actionPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 12, 0));
        actionPanel.setOpaque(false);
        actionPanel.add(loginButton);
        actionPanel.add(clearButton);

        JPanel card = new JPanel(new GridBagLayout());
        card.setBackground(CARD_COLOR);
        card.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(new Color(226, 232, 240), 1),
                new EmptyBorder(28, 34, 24, 34)
        ));

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(9, 8, 9, 8);
        gbc.anchor = GridBagConstraints.WEST;

        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.weightx = 1;
        card.add(headingPanel, gbc);

        gbc.gridwidth = 1;
        gbc.weightx = 0;
        gbc.gridy = 1;
        gbc.fill = GridBagConstraints.NONE;
        gbc.anchor = GridBagConstraints.EAST;
        card.add(usernameLabel, gbc);

        gbc.gridx = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.weightx = 1;
        card.add(usernameField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.fill = GridBagConstraints.NONE;
        gbc.weightx = 0;
        gbc.anchor = GridBagConstraints.EAST;
        card.add(passwordLabel, gbc);

        gbc.gridx = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.weightx = 1;
        card.add(passwordField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.gridwidth = 2;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.weightx = 1;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.insets = new Insets(16, 8, 8, 8);
        card.add(actionPanel, gbc);

        gbc.gridy = 4;
        gbc.fill = GridBagConstraints.NONE;
        gbc.insets = new Insets(8, 8, 0, 8);
        card.add(backButton, gbc);

        JPanel centerPanel = new JPanel(new GridBagLayout());
        centerPanel.setOpaque(false);
        centerPanel.add(card);

        JPanel page = new JPanel(new GridBagLayout());
        page.setBackground(PAGE_COLOR);
        page.setBorder(new EmptyBorder(28, 28, 28, 28));
        page.add(centerPanel);

        frame.setContentPane(page);
        frame.getRootPane().setDefaultButton(loginButton);

        clearButton.addActionListener(e -> {
            usernameField.setText("");
            passwordField.setText("");
            usernameField.requestFocusInWindow();
        });

        loginButton.addActionListener(e -> {
            String username = usernameField.getText().trim();
            String password = new String(passwordField.getPassword());

            if (username.isEmpty() || password.isEmpty()) {
                JOptionPane.showMessageDialog(
                        frame,
                        "Enter both username and password."
                );
            } else {
                ManageCircularsFrame.main(new String[0]);
                frame.dispose();
            }
        });

        backButton.addActionListener(e -> {
            LoginOptionsFrame.main(new String[0]);
            frame.dispose();
        });

        frame.setSize(800, 540);
        frame.setMinimumSize(new Dimension(650, 460));
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    private static void styleField(JTextField field) {
        field.setFont(new Font("Arial", Font.PLAIN, 15));
        field.setPreferredSize(new Dimension(290, 38));
        field.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(FIELD_BORDER),
                new EmptyBorder(5, 9, 5, 9)
        ));
    }

    private static void styleButton(
            JButton button,
            Color background,
            Color foreground,
            int width
    ) {
        button.setFont(new Font("Arial", Font.BOLD, 14));
        button.setBackground(background);
        button.setForeground(foreground);
        button.setPreferredSize(new Dimension(width, 40));
        button.setFocusPainted(false);
        button.setOpaque(true);
        button.setBorderPainted(false);
        button.setCursor(new Cursor(Cursor.HAND_CURSOR));
    }
}
