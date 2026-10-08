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
        JButton logoutButton = new JButton("Logout");

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(5, 1, 10, 10));

        buttonPanel.add(circularButton);
        buttonPanel.add(categoryButton);
        buttonPanel.add(notificationButton);
        buttonPanel.add(searchButton);
        buttonPanel.add(logoutButton);

        JPanel centerPanel = new JPanel(new GridBagLayout());
        centerPanel.add(buttonPanel);

        frame.setLayout(new BorderLayout(20, 20));

        frame.add(title, BorderLayout.NORTH);
        frame.add(centerPanel, BorderLayout.CENTER);

        circularButton.addActionListener(e ->
                JOptionPane.showMessageDialog(frame, "View Circulars clicked"));

        categoryButton.addActionListener(e ->
                JOptionPane.showMessageDialog(frame, "Categories clicked"));

        notificationButton.addActionListener(e ->
                JOptionPane.showMessageDialog(frame, "Notifications clicked"));

        searchButton.addActionListener(e ->
                JOptionPane.showMessageDialog(frame, "Search Circular clicked"));

        logoutButton.addActionListener(e ->
                JOptionPane.showMessageDialog(frame, "Logout clicked"));

        frame.setSize(600, 500);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}