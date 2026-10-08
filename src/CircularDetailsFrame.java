import javax.swing.*;
import java.awt.*;

public class CircularDetailsFrame {

    public static void main(String[] args) {

        // Create the frame
        JFrame frame = new JFrame("Circular Details");

        // Title
        JLabel title = new JLabel("CIRCULAR DETAILS");
        title.setFont(new Font("Arial", Font.BOLD, 22));
        title.setHorizontalAlignment(SwingConstants.CENTER);

        // Circular information
        JLabel titleLabel = new JLabel("Circular Title:");
        JLabel titleValue = new JLabel("Internal Examination");

        JLabel dateLabel = new JLabel("Date:");
        JLabel dateValue = new JLabel("08-10-2026");

        JLabel categoryLabel = new JLabel("Category:");
        JLabel categoryValue = new JLabel("Examination");

        JLabel descriptionLabel = new JLabel("Description:");

        JTextArea descriptionArea = new JTextArea(
                "Internal examination will be conducted from next Monday."
        );

        descriptionArea.setLineWrap(true);
        descriptionArea.setWrapStyleWord(true);
        descriptionArea.setEditable(false);

        // Information panel
        JPanel infoPanel = new JPanel(new GridLayout(3, 2, 10, 10));

        infoPanel.add(titleLabel);
        infoPanel.add(titleValue);

        infoPanel.add(dateLabel);
        infoPanel.add(dateValue);

        infoPanel.add(categoryLabel);
        infoPanel.add(categoryValue);

        // Description panel
        JPanel descriptionPanel = new JPanel(new BorderLayout(5, 5));

        descriptionPanel.add(descriptionLabel, BorderLayout.NORTH);
        descriptionPanel.add(
                new JScrollPane(descriptionArea),
                BorderLayout.CENTER
        );

        // Main content panel
        JPanel contentPanel = new JPanel(new BorderLayout(15, 15));

        contentPanel.add(infoPanel, BorderLayout.NORTH);
        contentPanel.add(descriptionPanel, BorderLayout.CENTER);

        // Back button
        JButton backButton = new JButton("Back");

        // Button panel
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        buttonPanel.add(backButton);

        // Add everything to frame
        frame.setLayout(new BorderLayout(15, 15));

        frame.add(title, BorderLayout.NORTH);
        frame.add(contentPanel, BorderLayout.CENTER);
        frame.add(buttonPanel, BorderLayout.SOUTH);

        // Button action
        backButton.addActionListener(e -> {
            JOptionPane.showMessageDialog(
                    frame,
                    "Back button clicked"
            );
        });

        // Frame settings
        frame.setSize(600, 450);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}