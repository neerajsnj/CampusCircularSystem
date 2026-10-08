import javax.swing.*;
import java.awt.*;

public class NotificationsFrame {

    public static void main(String[] args) {

        // Create frame
        JFrame frame = new JFrame("Notifications");

        // Title
        JLabel title = new JLabel("NOTIFICATIONS");
        title.setFont(new Font("Arial", Font.BOLD, 22));
        title.setHorizontalAlignment(SwingConstants.CENTER);

        // Notification list
        String[] notifications = {
                "New Examination Circular",
                "Arts Day Announcement",
                "Assignment Submission Notice",
                "Holiday Announcement",
                "Sports Day Registration"
        };

        JList<String> notificationList = new JList<>(notifications);

        notificationList.setFont(new Font("Arial", Font.PLAIN, 15));
        notificationList.setSelectionMode(
                ListSelectionModel.SINGLE_SELECTION
        );

        // Give the list a reasonable size
        JScrollPane scrollPane = new JScrollPane(notificationList);
        scrollPane.setPreferredSize(new Dimension(420, 220));

        // Center the notification list
        JPanel listPanel = new JPanel(new GridBagLayout());
        listPanel.add(scrollPane);

        // Clear button
        JButton clearButton = new JButton("Clear Notifications");

        // Keep button small and centered
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        buttonPanel.add(clearButton);

        // Main layout
        frame.setLayout(new BorderLayout(15, 15));

        frame.add(title, BorderLayout.NORTH);
        frame.add(listPanel, BorderLayout.CENTER);
        frame.add(buttonPanel, BorderLayout.SOUTH);

        // Button action
        clearButton.addActionListener(e -> {

            notificationList.clearSelection();

            JOptionPane.showMessageDialog(
                    frame,
                    "Notifications cleared"
            );
        });

        // Frame settings
        frame.setSize(600, 450);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}