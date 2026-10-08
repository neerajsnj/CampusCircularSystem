import javax.swing.*;
import java.awt.*;

public class AddCircularFrame {

    public static void main(String[] args) {

        // Create frame
        JFrame frame = new JFrame("Add Circular");

        // Title
        JLabel title = new JLabel("ADD NEW CIRCULAR");
        title.setFont(new Font("Arial", Font.BOLD, 22));
        title.setHorizontalAlignment(SwingConstants.CENTER);

        // Labels
        JLabel titleLabel = new JLabel("Circular Title:");
        JLabel categoryLabel = new JLabel("Category:");
        JLabel dateLabel = new JLabel("Date:");
        JLabel descriptionLabel = new JLabel("Description:");

        // Text fields
        JTextField titleField = new JTextField(20);
        JTextField dateField = new JTextField(20);

        // Category
        String[] categories = {
                "Academic",
                "Examination",
                "Events",
                "General"
        };

        JComboBox<String> categoryBox =
                new JComboBox<>(categories);

        // Description
        JTextArea descriptionArea = new JTextArea(5, 20);
        descriptionArea.setLineWrap(true);
        descriptionArea.setWrapStyleWord(true);

        JScrollPane descriptionScroll =
                new JScrollPane(descriptionArea);

        // Buttons
        JButton addButton = new JButton("Add Circular");
        JButton clearButton = new JButton("Clear");

        // Form panel
        JPanel formPanel = new JPanel(new GridBagLayout());

        GridBagConstraints gbc = new GridBagConstraints();

        gbc.insets = new Insets(8, 8, 8, 8);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        // Circular Title
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weightx = 0;
        formPanel.add(titleLabel, gbc);

        gbc.gridx = 1;
        gbc.weightx = 1;
        formPanel.add(titleField, gbc);

        // Category
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.weightx = 0;
        formPanel.add(categoryLabel, gbc);

        gbc.gridx = 1;
        gbc.weightx = 1;
        formPanel.add(categoryBox, gbc);

        // Date
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.weightx = 0;
        formPanel.add(dateLabel, gbc);

        gbc.gridx = 1;
        gbc.weightx = 1;
        formPanel.add(dateField, gbc);

        // Description
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.weightx = 0;
        gbc.anchor = GridBagConstraints.NORTH;
        formPanel.add(descriptionLabel, gbc);

        gbc.gridx = 1;
        gbc.weightx = 1;
        gbc.fill = GridBagConstraints.BOTH;
        formPanel.add(descriptionScroll, gbc);

        // Button panel
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 5));

        buttonPanel.add(addButton);
        buttonPanel.add(clearButton);

        // Main panel to keep form centered
        JPanel centerPanel = new JPanel(new GridBagLayout());
        centerPanel.add(formPanel);

        // Frame layout
        frame.setLayout(new BorderLayout(15, 15));

        frame.add(title, BorderLayout.NORTH);
        frame.add(centerPanel, BorderLayout.CENTER);
        frame.add(buttonPanel, BorderLayout.SOUTH);

        // Add button
        addButton.addActionListener(e -> {

            JOptionPane.showMessageDialog(
                    frame,
                    "Circular added successfully!"
            );
        });

        // Clear button
        clearButton.addActionListener(e -> {

            titleField.setText("");
            dateField.setText("");
            descriptionArea.setText("");

            categoryBox.setSelectedIndex(0);
        });

        // Frame settings
        frame.setSize(700, 500);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}