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

        JPanel buttonPanel = new JPanel(new GridLayout(4, 1, 10, 10));

        buttonPanel.add(academicButton);
        buttonPanel.add(examButton);
        buttonPanel.add(eventsButton);
        buttonPanel.add(generalButton);

        JPanel centerPanel = new JPanel(new GridBagLayout());
        centerPanel.add(buttonPanel);

        frame.setLayout(new BorderLayout(20, 20));

        frame.add(title, BorderLayout.NORTH);
        frame.add(centerPanel, BorderLayout.CENTER);

        academicButton.addActionListener(e ->
                JOptionPane.showMessageDialog(frame, "Academic category selected"));

        examButton.addActionListener(e ->
                JOptionPane.showMessageDialog(frame, "Examination category selected"));

        eventsButton.addActionListener(e ->
                JOptionPane.showMessageDialog(frame, "Events category selected"));

        generalButton.addActionListener(e ->
                JOptionPane.showMessageDialog(frame, "General category selected"));

        frame.setSize(600, 450);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}