import javax.swing.*;
import java.awt.*;

public class CategoriesFrame {

    public static void main(String[] args) {

        JFrame frame = new JFrame("Circular Categories");

        JLabel title = new JLabel("CIRCULAR CATEGORIES");
        title.setFont(new Font("Arial", Font.BOLD, 24));
        title.setHorizontalAlignment(SwingConstants.CENTER);

        JButton academicButton = new JButton("Academic");
        JButton examButton = new JButton("Examination");
        JButton eventsButton = new JButton("Events");
        JButton generalButton = new JButton("General");
        JButton backButton = new JButton("Back");

        JPanel buttonPanel = new JPanel(new GridLayout(4, 1, 10, 10));
        buttonPanel.add(academicButton);
        buttonPanel.add(examButton);
        buttonPanel.add(eventsButton);
        buttonPanel.add(generalButton);

        JPanel centerPanel = new JPanel(new GridBagLayout());
        centerPanel.add(buttonPanel);

        JPanel backPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        backPanel.add(backButton);

        frame.setLayout(new BorderLayout(20, 20));
        frame.add(title, BorderLayout.NORTH);
        frame.add(centerPanel, BorderLayout.CENTER);
        frame.add(backPanel, BorderLayout.SOUTH);

        academicButton.addActionListener(e -> {
            ViewCircularsFrame.show("Academic");
            frame.dispose();
        });

        examButton.addActionListener(e -> {
            ViewCircularsFrame.show("Examination");
            frame.dispose();
        });

        eventsButton.addActionListener(e -> {
            ViewCircularsFrame.show("Events");
            frame.dispose();
        });

        generalButton.addActionListener(e -> {
            ViewCircularsFrame.show("General");
            frame.dispose();
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