import javax.swing.*;
import java.awt.*;

public class AdminLoginFrame {

    public static void main(String[] args) {

        JFrame frame = new JFrame("Admin Login");

        JLabel title = new JLabel("ADMIN LOGIN");
        title.setFont(new Font("Arial", Font.BOLD, 24));
        title.setHorizontalAlignment(SwingConstants.CENTER);

        JLabel usernameLabel = new JLabel("Admin Username:");
        JLabel passwordLabel = new JLabel("Admin Password:");

        JTextField usernameField = new JTextField(15);
        JPasswordField passwordField = new JPasswordField(15);

        JButton loginButton = new JButton("Login");
        JButton clearButton = new JButton("Clear");

        JPanel formPanel = new JPanel(new GridLayout(3, 2, 10, 10));

        formPanel.add(usernameLabel);
        formPanel.add(usernameField);

        formPanel.add(passwordLabel);
        formPanel.add(passwordField);

        formPanel.add(loginButton);
        formPanel.add(clearButton);

        JPanel centerPanel = new JPanel(new GridBagLayout());
        centerPanel.add(formPanel);

        frame.setLayout(new BorderLayout(20, 20));

        frame.add(title, BorderLayout.NORTH);
        frame.add(centerPanel, BorderLayout.CENTER);

        clearButton.addActionListener(e -> {
            usernameField.setText("");
            passwordField.setText("");
        });

        loginButton.addActionListener(e ->
                JOptionPane.showMessageDialog(
                        frame,
                        "Admin Login button clicked"
                ));

        frame.setSize(600, 400);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}