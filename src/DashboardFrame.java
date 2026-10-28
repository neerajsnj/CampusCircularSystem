import javax.swing.*;
import java.awt.*;

public class DashboardFrame {

    public static void main(String[] args) {

        JFrame frame = new JFrame("Student Dashboard");

        JLabel title = new JLabel("STUDENT DASHBOARD");
        title.setFont(new Font("Arial", Font.BOLD, 24));
        title.setHorizontalAlignment(SwingConstants.CENTER);

        JButton circularButton = new JButton("View Circulars");
        JButton categoryButton = new JButton("Categories");
        JButton notificationButton = new JButton("Notifications");
        JButton searchButton = new JButton("Search Circular");
        JButton adminButton = new JButton("Admin");
        JButton logoutButton = new JButton("Logout");

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(6, 1, 10, 10));

        buttonPanel.add(circularButton);
        buttonPanel.add(categoryButton);
        buttonPanel.add(notificationButton);
        buttonPanel.add(searchButton);
        buttonPanel.add(adminButton);
        buttonPanel.add(logoutButton);

        JPanel centerPanel = new JPanel(new GridBagLayout());
        centerPanel.add(buttonPanel);

        frame.setLayout(new BorderLayout(20, 20));
        frame.add(title, BorderLayout.NORTH);
        frame.add(centerPanel, BorderLayout.CENTER);

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

        adminButton.addActionListener(e -> {
            AdminLoginFrame.main(new String[0]);
            frame.dispose();
        });

        logoutButton.addActionListener(e -> {
            WelcomeFrame.main(new String[0]);
            frame.dispose();
        });

        frame.setSize(600, 500);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}