import javax.swing.*;
import java.awt.*;

public class ManageCircularsFrame {

    public static void main(String[] args) {

        // Create frame
        JFrame frame = new JFrame("Manage Circulars");

        // Title
        JLabel title = new JLabel("MANAGE CIRCULARS");
        title.setFont(new Font("Arial", Font.BOLD, 22));
        title.setHorizontalAlignment(SwingConstants.CENTER);

        // Circular list
        String[] circulars = {
                "Internal Examination",
                "College Arts Day",
                "Holiday Notice",
                "Assignment Notice",
                "Sports Day"
        };

        JList<String> circularList = new JList<>(circulars);

        circularList.setFont(new Font("Arial", Font.PLAIN, 15));
        circularList.setSelectionMode(
                ListSelectionModel.SINGLE_SELECTION
        );

        // Scroll pane for list
        JScrollPane scrollPane = new JScrollPane(circularList);
        scrollPane.setPreferredSize(new Dimension(430, 220));

        // Center the list
        JPanel listPanel = new JPanel(new GridBagLayout());
        listPanel.add(scrollPane);

        // Buttons
        JButton addButton = new JButton("Add");
        JButton editButton = new JButton("Edit");
        JButton deleteButton = new JButton("Delete");
        JButton clearButton = new JButton("Clear");

        // Button panel
        JPanel buttonPanel = new JPanel(
                new FlowLayout(FlowLayout.CENTER, 10, 5)
        );

        buttonPanel.add(addButton);
        buttonPanel.add(editButton);
        buttonPanel.add(deleteButton);
        buttonPanel.add(clearButton);

        // Main layout
        frame.setLayout(new BorderLayout(15, 15));

        frame.add(title, BorderLayout.NORTH);
        frame.add(listPanel, BorderLayout.CENTER);
        frame.add(buttonPanel, BorderLayout.SOUTH);

        // Button actions
        addButton.addActionListener(e -> {
            JOptionPane.showMessageDialog(
                    frame,
                    "Add button clicked"
            );
        });

        editButton.addActionListener(e -> {
            JOptionPane.showMessageDialog(
                    frame,
                    "Edit button clicked"
            );
        });

        deleteButton.addActionListener(e -> {
            JOptionPane.showMessageDialog(
                    frame,
                    "Delete button clicked"
            );
        });

        clearButton.addActionListener(e -> {
            circularList.clearSelection();
        });

        // Frame settings
        frame.setSize(650, 500);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
