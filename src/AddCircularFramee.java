import javax.swing.*;
import java.awt.*;

public class AddCircularFrame {

    public static void main(String[] args) {

        JFrame frame = new JFrame("Add Circular");

        JLabel heading = new JLabel("ADD NEW CIRCULAR");
        heading.setFont(new Font("Arial", Font.BOLD, 24));
        heading.setHorizontalAlignment(SwingConstants.CENTER);

        JLabel titleLabel = new JLabel("Circular Title:");
        JTextField titleField = new JTextField(20);

        JLabel categoryLabel = new JLabel("Category:");
        String[] categories = {
                "Academic",
                "Examination",
                "Events",
                "General"
        };
        JComboBox<String> categoryBox = new JComboBox<>(categories);

        JLabel dateLabel = new JLabel("Date:");
        JTextField dateField = new JTextField(20);

        JLabel descriptionLabel = new JLabel("Description:");
        JTextArea descriptionArea = new JTextArea(5, 20);
        descriptionArea.setLineWrap(true);
        descriptionArea.setWrapStyleWord(true);

        JPanel formPanel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(8, 8, 8, 8);
        gbc.anchor = GridBagConstraints.WEST;
        gbc.fill = GridBagConstraints.HORIZONTAL;

        gbc.gridx = 0;
        gbc.gridy = 0;
        formPanel.add(titleLabel, gbc);
        gbc.gridx = 1;
        formPanel.add(titleField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        formPanel.add(categoryLabel, gbc);
        gbc.gridx = 1;
        formPanel.add(categoryBox, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        formPanel.add(dateLabel, gbc);
        gbc.gridx = 1;
        formPanel.add(dateField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 3;
        formPanel.add(descriptionLabel, gbc);
        gbc.gridx = 1;
        gbc.fill = GridBagConstraints.BOTH;
        formPanel.add(new JScrollPane(descriptionArea), gbc);

        JButton addButton = new JButton("Add Circular");
        JButton clearButton = new JButton("Clear");
        JButton backButton = new JButton("Back");

        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        buttonPanel.add(addButton);
        buttonPanel.add(clearButton);
        buttonPanel.add(backButton);

        frame.setLayout(new BorderLayout(15, 15));
        frame.add(heading, BorderLayout.NORTH);
        frame.add(formPanel, BorderLayout.CENTER);
        frame.add(buttonPanel, BorderLayout.SOUTH);

        addButton.addActionListener(e -> {
            String circularTitle = titleField.getText().trim();
            String date = dateField.getText().trim();
            String description = descriptionArea.getText().trim();

            if (circularTitle.isEmpty() || date.isEmpty() || description.isEmpty()) {
                JOptionPane.showMessageDialog(
                        frame,
                        "Please fill in the title, date, and description."
                );
                return;
            }

            JOptionPane.showMessageDialog(
                    frame,
                    "Circular added successfully."
            );
        });

        clearButton.addActionListener(e -> {
            titleField.setText("");
            dateField.setText("");
            descriptionArea.setText("");
            categoryBox.setSelectedIndex(0);
        });

        backButton.addActionListener(e -> {
            ManageCircularsFrame.main(new String[0]);
            frame.dispose();
        });

        frame.setSize(600, 450);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
