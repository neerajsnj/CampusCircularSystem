import javax.swing.*;
import java.awt.*;

public class LoginFrame extends JFrame {
    public LoginFrame() {
        setTitle("Campus Circular System - Login");
        setSize(400, 280);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JLabel heading = new JLabel(
            "Campus Circular System",
            SwingConstants.CENTER
        );
        heading.setFont(new Font("Arial", Font.BOLD, 20));

        JTextField usernameField = new JTextField(15);
        JPasswordField passwordField = new JPasswordField(15);

        JButton loginButton = new JButton("Login");
        JButton clearButton = new JButton("Clear");

        JPanel form = new JPanel(new GridLayout(3, 2, 8, 8));
        form.add(new JLabel("Username:"));
        form.add(usernameField);
        form.add(new JLabel("Password:"));
        form.add(passwordField);
        form.add(loginButton);
        form.add(clearButton);

        loginButton.addActionListener(e ->
            JOptionPane.showMessageDialog(this, "Login button clicked.")
        );

        clearButton.addActionListener(e -> {
            usernameField.setText("");
            passwordField.setText("");
        });

        setLayout(new BorderLayout(10, 10));
        add(heading, BorderLayout.NORTH);
        add(form, BorderLayout.CENTER);

        setVisible(true);
    }

    public static void main(String[] args) {
        new LoginFrame();
    }
}