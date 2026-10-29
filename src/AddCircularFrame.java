import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class AddCircularFrame {

    private static final Color PAGE_COLOR = new Color(241, 245, 249);
    private static final Color CARD_COLOR = Color.WHITE;
    private static final Color TITLE_COLOR = new Color(30, 58, 85);
    private static final Color PRIMARY_COLOR = new Color(37, 99, 235);
    private static final Color SECONDARY_COLOR = new Color(226, 232, 240);
    private static final Color FIELD_BORDER = new Color(203, 213, 225);

    public static void main(String[] args) {
        SwingUtilities.invokeLater(AddCircularFrame::showWindow);
    }

    private static void showWindow() {
        JFrame frame = new JFrame("Add Circular");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JLabel heading = new JLabel("ADD NEW CIRCULAR");
        heading.setFont(new Font("Arial", Font.BOLD, 26));
        heading.setForeground(TITLE_COLOR);
        heading.setHorizontalAlignment(SwingConstants.CENTER);

        JLabel subtitle = new JLabel("Enter the details for the campus notice");
        subtitle.setFont(new Font("Arial", Font.PLAIN, 14));
        subtitle.setForeground(new Color(100, 116, 139));
        subtitle.setHorizontalAlignment(SwingConstants.CENTER);

        JPanel headingPanel = new JPanel(new GridLayout(2, 1, 0, 7));
        headingPanel.setOpaque(false);
        headingPanel.add(heading);
        headingPanel.add(subtitle);

        JLabel titleLabel = new JLabel("Circular Title:");
        JLabel categoryLabel = new JLabel("Category:");
        JLabel dateLabel = new JLabel("Date (DD-MM-YYYY):");
        JLabel descriptionLabel = new JLabel("Description:");

        JLabel[] labels = {
                titleLabel, categoryLabel, dateLabel, descriptionLabel
        };

        for (JLabel label : labels) {
            label.setFont(new Font("Arial", Font.BOLD, 14));
            label.setForeground(TITLE_COLOR);
        }

        JTextField titleField = new JTextField();
        JTextField dateField = new JTextField();

        JComboBox<String> categoryBox = new JComboBox<>(
                new String[]{"Academic", "Examination", "Events", "General"}
        );
        categoryBox.setFont(new Font("Arial", Font.PLAIN, 15));
        categoryBox.setPreferredSize(new Dimension(420, 38));

        styleField(titleField);
        styleField(dateField);

        JTextArea descriptionArea = new JTextArea(6, 28);
        descriptionArea.setFont(new Font("Arial", Font.PLAIN, 15));
        descriptionArea.setLineWrap(true);
        descriptionArea.setWrapStyleWord(true);
        descriptionArea.setBorder(new EmptyBorder(8, 9, 8, 9));

        JScrollPane descriptionScroll = new JScrollPane(descriptionArea);
        descriptionScroll.setPreferredSize(new Dimension(420, 155));
        descriptionScroll.setBorder(
                BorderFactory.createLineBorder(FIELD_BORDER)
        );

        JPanel formPanel = new JPanel(new GridBagLayout());
        formPanel.setOpaque(false);

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(9, 8, 9, 8);
        gbc.anchor = GridBagConstraints.WEST;

        // Labels on the left
        gbc.gridx = 0;
        gbc.weightx = 0;
        gbc.fill = GridBagConstraints.NONE;

        gbc.gridy = 0;
        formPanel.add(titleLabel, gbc);

        gbc.gridy = 1;
        formPanel.add(categoryLabel, gbc);

        gbc.gridy = 2;
        formPanel.add(dateLabel, gbc);

        gbc.gridy = 3;
        gbc.anchor = GridBagConstraints.NORTHWEST;
        formPanel.add(descriptionLabel, gbc);

        // Input fields on the right
        gbc.gridx = 1;
        gbc.weightx = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.anchor = GridBagConstraints.WEST;

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

        styleButton(addButton, PRIMARY_COLOR, Color.WHITE, 145);
        styleButton(clearButton, SECONDARY_COLOR, TITLE_COLOR, 115);
        styleButton(backButton, SECONDARY_COLOR, TITLE_COLOR, 115);

        JPanel buttonPanel = new JPanel(
                new FlowLayout(FlowLayout.CENTER, 12, 0)
        );
        buttonPanel.setOpaque(false);
        buttonPanel.add(addButton);
        buttonPanel.add(clearButton);
        buttonPanel.add(backButton);

        JPanel card = new JPanel(new BorderLayout(0, 22));
        card.setBackground(CARD_COLOR);
        card.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(
                        new Color(226, 232, 240), 1
                ),
                new EmptyBorder(28, 32, 25, 32)
        ));
        card.add(headingPanel, BorderLayout.NORTH);
        card.add(formPanel, BorderLayout.CENTER);
        card.add(buttonPanel, BorderLayout.SOUTH);

        JPanel centerPanel = new JPanel(new GridBagLayout());
        centerPanel.setOpaque(false);
        centerPanel.add(card);

        JPanel page = new JPanel(new GridBagLayout());
        page.setBackground(PAGE_COLOR);
        page.setBorder(new EmptyBorder(24, 24, 24, 24));
        page.add(centerPanel);

        frame.setContentPane(page);
        frame.getRootPane().setDefaultButton(addButton);

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
            titleField.requestFocusInWindow();
        });

        backButton.addActionListener(e -> {
            ManageCircularsFrame.main(new String[0]);
            frame.dispose();
        });

        frame.setSize(900, 650);
        frame.setMinimumSize(new Dimension(720, 560));
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    private static void styleField(JTextField field) {
        field.setFont(new Font("Arial", Font.PLAIN, 15));
        field.setPreferredSize(new Dimension(420, 38));
        field.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(FIELD_BORDER),
                new EmptyBorder(5, 9, 5, 9)
        ));
    }

    private static void styleButton(
            JButton button,
            Color background,
            Color foreground,
            int width
    ) {
        button.setFont(new Font("Arial", Font.BOLD, 14));
        button.setBackground(background);
        button.setForeground(foreground);
        button.setPreferredSize(new Dimension(width, 40));
        button.setFocusPainted(false);
        button.setOpaque(true);
        button.setBorderPainted(false);
        button.setCursor(new Cursor(Cursor.HAND_CURSOR));
    }
}
