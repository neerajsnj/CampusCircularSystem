import javax.swing.*;
import java.awt.*;

public class StudentDashboardFrame extends JFrame {
    public StudentDashboardFrame() {
        setTitle("Campus Circular System - Student Home");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JLabel heading = new JLabel(
            "Latest Campus Circulars",
            SwingConstants.CENTER
        );
        heading.setFont(new Font("Arial", Font.BOLD, 20));

        JTextArea circulars = new JTextArea();
        circulars.setEditable(false);
        circulars.setText(
            "1. College Fest Registration - Student Affairs\n\n" +
            "2. Library Hours Update - Library\n\n" +
            "3. Mid-term Exam Schedule - Examination Cell"
        );

        JButton viewButton = new JButton("View Circular");
        viewButton.addActionListener(e ->
            JOptionPane.showMessageDialog(this, "View button clicked.")
        );

        setLayout(new BorderLayout(10, 10));
        add(heading, BorderLayout.NORTH);
        add(new JScrollPane(circulars), BorderLayout.CENTER);
        add(viewButton, BorderLayout.SOUTH);

        setVisible(true);
    }

    public static void main(String[] args) {
        new StudentDashboardFrame();
    }
}