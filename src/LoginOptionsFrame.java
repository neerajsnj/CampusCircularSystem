import javax.swing.*;
import java.awt.*;

public class LoginOptionsFrame {

    public static void main(String[] args) {

        JFrame frame = new JFrame("Choose Login");

        JLabel title = new JLabel("CHOOSE LOGIN TYPE");
        title.setFont(new Font("Arial", Font.BOLD, 24));
        title.setHorizontalAlignment(SwingConstants.CENTER);

        JButton studentButton = new JButton("Student Login");
        JButton adminButton = new JButton("Admin Login");
        JButton backButton = new JButton("Back");

        JPanel choicePanel = new JPanel(new GridLayout(2, 1, 10, 10));
        choicePanel.add(studentButton);
        choicePanel.add(adminButton);

        JPanel centerPanel = new JPanel(new GridBagLayout());
        centerPanel.add(choicePanel);

        JPanel backPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        backPanel.add(backButton);

        frame.setLayout(new BorderLayout(20, 20));
        frame.add(title, BorderLayout.NORTH);
        frame.add(centerPanel, BorderLayout.CENTER);
        frame.add(backPanel, BorderLayout.SOUTH);

        studentButton.addActionListener(e -> {
            LoginFrame.main(new String[0]);
            frame.dispose();
        });

        adminButton.addActionListener(e -> {
            AdminLoginFrame.main(new String[0]);
            frame.dispose();
        });

        backButton.addActionListener(e -> {
            WelcomeFrame.main(new String[0]);
            frame.dispose();
        });

        frame.setSize(600, 400);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}