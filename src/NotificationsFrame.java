import javax.swing.*;
import java.awt.*;

public class NotificationsFrame {

    public static void main(String[] args) {

        JFrame frame = new JFrame("Notifications");

        JLabel title = new JLabel("NOTIFICATIONS");
        title.setFont(new Font("Arial", Font.BOLD, 22));
        title.setHorizontalAlignment(SwingConstants.CENTER);

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
        notificationList.setFont(new Font("Arial", Font.PLAIN, 15));
        notificationList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        JScrollPane scrollPane = new JScrollPane(notificationList);
        scrollPane.setPreferredSize(new Dimension(420, 220));

        JPanel listPanel = new JPanel(new GridBagLayout());
        listPanel.add(scrollPane);

        JButton clearSelectedButton = new JButton("Clear Selected");
        JButton clearAllButton = new JButton("Clear All");
        JButton backButton = new JButton("Back");

        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        buttonPanel.add(clearSelectedButton);
        buttonPanel.add(clearAllButton);
        buttonPanel.add(backButton);

        frame.setLayout(new BorderLayout(15, 15));
        frame.add(title, BorderLayout.NORTH);
        frame.add(listPanel, BorderLayout.CENTER);
        frame.add(buttonPanel, BorderLayout.SOUTH);

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

        clearAllButton.addActionListener(e -> {
            notificationModel.clear();
        });

        backButton.addActionListener(e -> {
            DashboardFrame.main(new String[0]);
            frame.dispose();
        });

        frame.setSize(600, 450);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
