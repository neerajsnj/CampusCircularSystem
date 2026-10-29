import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class NotificationsFrame {

    private static final Color PAGE_COLOR = new Color(241, 245, 249);
    private static final Color CARD_COLOR = Color.WHITE;
    private static final Color TITLE_COLOR = new Color(30, 58, 85);
    private static final Color PRIMARY_COLOR = new Color(37, 99, 235);
    private static final Color SECONDARY_COLOR = new Color(226, 232, 240);

    public static void main(String[] args) {
        SwingUtilities.invokeLater(NotificationsFrame::showWindow);
    }

    private static void showWindow() {
        JFrame frame = new JFrame("Notifications");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JLabel title = new JLabel("NOTIFICATIONS");
        title.setFont(new Font("Arial", Font.BOLD, 26));
        title.setForeground(TITLE_COLOR);
        title.setHorizontalAlignment(SwingConstants.CENTER);

        JLabel subtitle = new JLabel("Campus circular updates");
        subtitle.setFont(new Font("Arial", Font.PLAIN, 14));
        subtitle.setForeground(new Color(100, 116, 139));
        subtitle.setHorizontalAlignment(SwingConstants.CENTER);

        JPanel headingPanel = new JPanel(new GridLayout(2, 1, 0, 8));
        headingPanel.setOpaque(false);
        headingPanel.add(title);
        headingPanel.add(subtitle);

        String[] notifications = {
                "New Examination Circular",
                "Arts Day Announcement",
                "Assignment Submission Notice",
                "Holiday Announcement",
                "Sports Day Registration"
        };

        DefaultListModel<String> notificationModel = new DefaultListModel<>();
        for (String notification : notifications) {
            notificationModel.addElement(notification);
        }

        JList<String> notificationList = new JList<>(notificationModel);
        notificationList.setFont(new Font("Arial", Font.PLAIN, 16));
        notificationList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        notificationList.setFixedCellHeight(38);
        notificationList.setSelectionBackground(new Color(219, 234, 254));
        notificationList.setSelectionForeground(TITLE_COLOR);
        notificationList.setBorder(new EmptyBorder(6, 8, 6, 8));

        JScrollPane scrollPane = new JScrollPane(notificationList);
        scrollPane.setPreferredSize(new Dimension(570, 280));
        scrollPane.setBorder(
                BorderFactory.createLineBorder(new Color(203, 213, 225))
        );

        JButton clearSelectedButton = new JButton("Clear Selected");
        JButton clearAllButton = new JButton("Clear All");
        JButton backButton = new JButton("Back");

        styleButton(clearSelectedButton, PRIMARY_COLOR, Color.WHITE, 145);
        styleButton(clearAllButton, SECONDARY_COLOR, TITLE_COLOR, 120);
        styleButton(backButton, SECONDARY_COLOR, TITLE_COLOR, 105);

        JPanel buttonPanel = new JPanel(
                new FlowLayout(FlowLayout.CENTER, 10, 0)
        );
        buttonPanel.setOpaque(false);
        buttonPanel.add(clearSelectedButton);
        buttonPanel.add(clearAllButton);
        buttonPanel.add(backButton);

        JPanel card = new JPanel(new BorderLayout(0, 22));
        card.setBackground(CARD_COLOR);
        card.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(new Color(226, 232, 240), 1),
                new EmptyBorder(28, 30, 26, 30)
        ));
        card.setPreferredSize(new Dimension(650, 430));
        card.add(headingPanel, BorderLayout.NORTH);
        card.add(scrollPane, BorderLayout.CENTER);
        card.add(buttonPanel, BorderLayout.SOUTH);

        JPanel page = new JPanel(new GridBagLayout());
        page.setBackground(PAGE_COLOR);
        page.setBorder(new EmptyBorder(24, 24, 24, 24));
        page.add(card);

        frame.setContentPane(page);

        clearSelectedButton.addActionListener(e -> {
            int selectedIndex = notificationList.getSelectedIndex();

            if (selectedIndex == -1) {
                JOptionPane.showMessageDialog(
                        frame,
                        "Please select a notification first."
                );
            } else {
                notificationModel.remove(selectedIndex);
            }
        });

        clearAllButton.addActionListener(e -> notificationModel.clear());

        backButton.addActionListener(e -> {
            DashboardFrame.main(new String[0]);
            frame.dispose();
        });

        frame.setSize(850, 600);
        frame.setMinimumSize(new Dimension(680, 500));
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
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
