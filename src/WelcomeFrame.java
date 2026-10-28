import javax.swing.*;
import java.awt.*;

public class WelcomeFrame {

    public static void main(String[] args) {

        JFrame frame = new JFrame("Campus Circular Management System");

        JLabel title = new JLabel("Campus Circular Management System");
        title.setFont(new Font("Arial", Font.BOLD, 24));
        title.setHorizontalAlignment(SwingConstants.CENTER);

        JLabel subtitle = new JLabel("College Circular Management");
        subtitle.setHorizontalAlignment(SwingConstants.CENTER);

        JButton loginButton = new JButton("Login");
        JButton exitButton = new JButton("Exit");

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(2, 1, 10, 10));
        panel.add(loginButton);
        panel.add(exitButton);

        frame.setLayout(new BorderLayout(20, 20));

        frame.add(title, BorderLayout.NORTH);
        frame.add(subtitle, BorderLayout.CENTER);
        frame.add(panel, BorderLayout.SOUTH);

        exitButton.addActionListener(e -> System.exit(0));

        loginButton.addActionListener(e -> {
            LoginOptionsFrame.main(new String[0]);
            frame.dispose();
        });

        frame.setSize(600, 400);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}