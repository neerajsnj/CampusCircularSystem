import javax.swing.*;
import java.awt.*;

public class ViewCircularsFrame {

    public static void main(String[] args) {

        JFrame frame = new JFrame("View Circulars");

        JLabel title = new JLabel("AVAILABLE CIRCULARS");
        title.setFont(new Font("Arial", Font.BOLD, 24));
        title.setHorizontalAlignment(SwingConstants.CENTER);

        String[] circulars = {
                "Internal Examination",
                "College Arts Day",
                "Holiday Announcement",
                "Assignment Submission",
                "Sports Day"
        };

        JList<String> circularList = new JList<>(circulars);

        JButton viewButton = new JButton("View");
        JButton backButton = new JButton("Back");

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(viewButton);
        buttonPanel.add(backButton);

        frame.setLayout(new BorderLayout(15, 15));

        frame.add(title, BorderLayout.NORTH);
        frame.add(new JScrollPane(circularList), BorderLayout.CENTER);
        frame.add(buttonPanel, BorderLayout.SOUTH);

        viewButton.addActionListener(e ->
                JOptionPane.showMessageDialog(frame, "View button clicked"));

        backButton.addActionListener(e ->
                JOptionPane.showMessageDialog(frame, "Back button clicked"));

        frame.setSize(600, 450);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
