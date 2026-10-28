import javax.swing.*;
import java.awt.*;

public class AddCircularFrame {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(AddCircularFrame::showWindow);
    }

    private static void showWindow() {
        JFrame frame = new JFrame("Add Circular");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JLabel heading = new JLabel("ADD NEW CIRCULAR");
        heading.setFont(new Font("Arial", Font.BOLD, 24));
        heading.setHorizontalAlignment(SwingConstants.CENTER);
        heading.setBorder(BorderFactory.createEmptyBorder(20, 10, 15, 10));

        JLabel titleLabel = new JLabel("Circular Title:");
        JLabel categoryLabel = new JLabel("Category:");
        JLabel dateLabel = new JLabel("Date (DD-MM-YYYY):");
        JLabel descriptionLabel = new JLabel("Description:");

        JTextField titleField = new JTextField(28);
        JComboBox<String> categoryBox = new JComboBox<>(
                new String[]{"Academic", "Examination", "Events", "General"}
        );
        JTextField dateField = new JTextField(28);

        JTextArea descriptionArea = new JTextArea(6, 28);
        descriptionArea.setLineWrap(true);
        descriptionArea.setWrapStyleWord(true);

        JScrollPane descriptionScroll =
                new JScrollPane(descriptionArea);

        JPanel formPanel = new JPanel(new GridBagLayout());
        formPanel.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(9, 8, 9, 8);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.anchor = GridBagConstraints.NORTHWEST;

        // Label column
        gbc.gridx = 0;
        gbc.weightx = 0;
        gbc.gridy = 0;
        formPanel.add(titleLabel, gbc);

        gbc.gridy = 1;
        formPanel.add(categoryLabel, gbc);

        gbc.gridy = 2;
        formPanel.add(dateLabel, gbc);

        gbc.gridy = 3;
        formPanel.add(descriptionLabel, gbc);

        // Input column
        gbc.gridx = 1;
        gbc.weightx = 1;
        gbc.gridy = 0;
        formPanel.add(titleField, gbc);

        gbc.gridy = 1;
        formPanel.add(categoryBox, gbc);

        gbc.gridy = 2;
        formPanel.add(dateField, gbc);

        gbc.gridy = 3;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.weighty = 1;
        formPanel.add(descriptionScroll, gbc);

        JButton addButton = new JButton("Add Circular");
        JButton clearButton = new JButton("Clear");
        JButton backButton = new JButton("Back");

        JPanel buttonPanel = new JPanel(
                new FlowLayout(FlowLayout.CENTER, 12, 12)
        );
        buttonPanel.add(addButton);
        buttonPanel.add(clearButton);
        buttonPanel.add(backButton);

        JPanel centerPanel = new JPanel(new GridBagLayout());
        centerPanel.add(formPanel);

        frame.setLayout(new BorderLayout(10, 10));
        frame.add(heading, BorderLayout.NORTH);
        frame.add(centerPanel, BorderLayout.CENTER);
        frame.add(buttonPanel, BorderLayout.SOUTH);

        addButton.addActionListener(e -> {
            String circularTitle = titleField.getText().trim();
            String date = dateField.getText().trim();
            String description = descriptionArea.getText().trim();
            String category = (String) categoryBox.getSelectedItem();

            if (circularTitle.isEmpty() || date.isEmpty()
                    || description.isEmpty()) {
                JOptionPane.showMessageDialog(
                        frame,
                        "Please fill in the title, date, and description."
                );
                return;
            }

            JOptionPane.showMessageDialog(
                    frame,
                    "Circular details entered.\n\n"
                            + "Title: " + circularTitle + "\n"
                            + "Category: " + category + "\n"
                            + "Date: " + date
            );
        });

        clearButton.addActionListener(e -> {
            titleField.setText("");
            categoryBox.setSelectedIndex(0);
            dateField.setText("");
            descriptionArea.setText("");
        });

        backButton.addActionListener(e -> {
            ManageCircularsFrame.main(new String[0]);
            frame.dispose();
        });

        frame.setSize(760, 560);
        frame.setMinimumSize(new Dimension(700, 520));
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
