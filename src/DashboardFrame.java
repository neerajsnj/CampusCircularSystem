import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class DashboardFrame {

    private static final Color PAGE_COLOR = new Color(241, 245, 249);
    private static final Color CARD_COLOR = Color.WHITE;
    private static final Color TITLE_COLOR = new Color(30, 58, 85);
    private static final Color PRIMARY_COLOR = new Color(37, 99, 235);
    private static final Color SECONDARY_COLOR = new Color(226, 232, 240);

    public static void main(String[] args) {
        SwingUtilities.invokeLater(DashboardFrame::showWindow);
    }

    private static void showWindow() {
        JFrame frame = new JFrame("Student Dashboard");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JLabel title = new JLabel("STUDENT DASHBOARD");
        title.setFont(new Font("Arial", Font.BOLD, 26));
        title.setForeground(TITLE_COLOR);
        title.setHorizontalAlignment(SwingConstants.CENTER);

        JLabel subtitle = new JLabel("Choose a service");
        subtitle.setFont(new Font("Arial", Font.PLAIN, 14));
        subtitle.setForeground(new Color(100, 116, 139));
        subtitle.setHorizontalAlignment(SwingConstants.CENTER);

        JPanel headingPanel = new JPanel(new GridLayout(2, 1, 0, 8));
        headingPanel.setOpaque(false);
        headingPanel.add(title);
        headingPanel.add(subtitle);

        JButton circularButton = new JButton("View Circulars");
        JButton categoryButton = new JButton("Categories");
        JButton notificationButton = new JButton("Notifications");
        JButton searchButton = new JButton("Search Circular");
        JButton logoutButton = new JButton("Logout");

        styleButton(circularButton, PRIMARY_COLOR, Color.WHITE);
        styleButton(categoryButton, PRIMARY_COLOR, Color.WHITE);
        styleButton(notificationButton, PRIMARY_COLOR, Color.WHITE);
        styleButton(searchButton, PRIMARY_COLOR, Color.WHITE);
        styleButton(logoutButton, SECONDARY_COLOR, TITLE_COLOR);

        JPanel buttonPanel = new JPanel(new GridBagLayout());
        buttonPanel.setOpaque(false);

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(7, 7, 7, 7);
        gbc.fill = GridBagConstraints.NONE;

        gbc.gridx = 0;
        gbc.gridy = 0;
        buttonPanel.add(circularButton, gbc);

        gbc.gridx = 1;
        buttonPanel.add(categoryButton, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        buttonPanel.add(notificationButton, gbc);

        gbc.gridx = 1;
        buttonPanel.add(searchButton, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        buttonPanel.add(logoutButton, gbc);

        JPanel card = new JPanel(new BorderLayout(0, 24));
        card.setBackground(CARD_COLOR);
        card.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(new Color(226, 232, 240), 1),
                new EmptyBorder(32, 38, 34, 38)
        ));
        card.setPreferredSize(new Dimension(620, 390));
        card.add(headingPanel, BorderLayout.NORTH);
        card.add(buttonPanel, BorderLayout.CENTER);

        JPanel page = new JPanel(new GridBagLayout());
        page.setBackground(PAGE_COLOR);
        page.setBorder(new EmptyBorder(28, 28, 28, 28));
        page.add(card);

        frame.setContentPane(page);

        circularButton.addActionListener(e -> {
            ViewCircularsFrame.main(new String[0]);
            frame.dispose();
        });

        categoryButton.addActionListener(e -> {
            CategoriesFrame.main(new String[0]);
            frame.dispose();
        });

        notificationButton.addActionListener(e -> {
            NotificationsFrame.main(new String[0]);
            frame.dispose();
        });

        searchButton.addActionListener(e -> {
            SearchCircularFrame.main(new String[0]);
            frame.dispose();
        });

        logoutButton.addActionListener(e -> {
            WelcomeFrame.main(new String[0]);
            frame.dispose();
        });

        frame.setSize(900, 650);
        frame.setMinimumSize(new Dimension(700, 540));
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
        button.setPreferredSize(new Dimension(240, 58));
        button.setFocusPainted(false);
        button.setOpaque(true);
        button.setBorderPainted(false);
        button.setCursor(new Cursor(Cursor.HAND_CURSOR));
    }
}
