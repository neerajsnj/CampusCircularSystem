import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class WelcomeFrame {

    private static final Color PAGE_COLOR = new Color(241, 245, 249);
    private static final Color CARD_COLOR = Color.WHITE;
    private static final Color TITLE_COLOR = new Color(30, 58, 85);
    private static final Color PRIMARY_COLOR = new Color(37, 99, 235);
    private static final Color SECONDARY_COLOR = new Color(226, 232, 240);

    public static void main(String[] args) {
        SwingUtilities.invokeLater(WelcomeFrame::showWindow);
    }

    private static void showWindow() {
        JFrame frame = new JFrame("Campus Circular Management System");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JLabel title = new JLabel("Campus Circular");
        title.setFont(new Font("Arial", Font.BOLD, 32));
        title.setForeground(TITLE_COLOR);
        title.setHorizontalAlignment(SwingConstants.CENTER);

        JLabel titleSecondLine = new JLabel("Management System");
        titleSecondLine.setFont(new Font("Arial", Font.BOLD, 32));
        titleSecondLine.setForeground(TITLE_COLOR);
        titleSecondLine.setHorizontalAlignment(SwingConstants.CENTER);

        JLabel subtitle = new JLabel("College Circular Management");
        subtitle.setFont(new Font("Arial", Font.PLAIN, 17));
        subtitle.setForeground(new Color(100, 116, 139));
        subtitle.setHorizontalAlignment(SwingConstants.CENTER);

        JLabel description = new JLabel(
                "View campus announcements, events, and academic notices."
        );
        description.setFont(new Font("Arial", Font.PLAIN, 14));
        description.setForeground(new Color(100, 116, 139));
        description.setHorizontalAlignment(SwingConstants.CENTER);

        JButton loginButton = new JButton("Login");
        JButton exitButton = new JButton("Exit");

        styleButton(loginButton, PRIMARY_COLOR, Color.WHITE);
        styleButton(exitButton, SECONDARY_COLOR, TITLE_COLOR);

        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 12, 0));
        buttonPanel.setOpaque(false);
        buttonPanel.add(loginButton);
        buttonPanel.add(exitButton);

        JPanel card = new JPanel(new GridBagLayout());
        card.setBackground(CARD_COLOR);
        card.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(new Color(226, 232, 240), 1),
                new EmptyBorder(38, 42, 38, 42)
        ));

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridwidth = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.weightx = 1;
        gbc.insets = new Insets(5, 5, 5, 5);

        gbc.gridy = 0;
        card.add(title, gbc);

        gbc.gridy = 1;
        card.add(titleSecondLine, gbc);

        gbc.insets = new Insets(20, 5, 5, 5);
        gbc.gridy = 2;
        card.add(subtitle, gbc);

        gbc.insets = new Insets(8, 5, 20, 5);
        gbc.gridy = 3;
        card.add(description, gbc);

        gbc.insets = new Insets(8, 5, 5, 5);
        gbc.gridy = 4;
        card.add(buttonPanel, gbc);

        JPanel page = new JPanel(new GridBagLayout());
        page.setBackground(PAGE_COLOR);
        page.setBorder(new EmptyBorder(28, 28, 28, 28));
        page.add(card);

        frame.setContentPane(page);
        frame.getRootPane().setDefaultButton(loginButton);

        loginButton.addActionListener(e -> {
            LoginOptionsFrame.main(new String[0]);
            frame.dispose();
        });

        exitButton.addActionListener(e -> System.exit(0));

        frame.setSize(800, 540);
        frame.setMinimumSize(new Dimension(650, 440));
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    private static void styleButton(
            JButton button,
            Color background,
            Color foreground
    ) {
        button.setFont(new Font("Arial", Font.BOLD, 15));
        button.setBackground(background);
        button.setForeground(foreground);
        button.setPreferredSize(new Dimension(145, 44));
        button.setFocusPainted(false);
        button.setOpaque(true);
        button.setBorderPainted(false);
        button.setCursor(new Cursor(Cursor.HAND_CURSOR));
    }
}
