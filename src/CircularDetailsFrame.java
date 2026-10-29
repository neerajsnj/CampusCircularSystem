import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class CircularDetailsFrame {

    private static final Color PAGE_COLOR = new Color(241, 245, 249);
    private static final Color CARD_COLOR = Color.WHITE;
    private static final Color TITLE_COLOR = new Color(30, 58, 85);
    private static final Color PRIMARY_COLOR = new Color(37, 99, 235);
    private static final Color FIELD_BORDER = new Color(203, 213, 225);

    public static void main(String[] args) {
        show("Internal Examination");
    }

    public static void show(String circularTitle) {
        if (SwingUtilities.isEventDispatchThread()) {
            createWindow(circularTitle);
        } else {
            SwingUtilities.invokeLater(() -> createWindow(circularTitle));
        }
    }

    private static void createWindow(String circularTitle) {
        JFrame frame = new JFrame("Circular Details");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        String date;
        String category;
        String description;

        switch (circularTitle) {
            case "Internal Examination":
                date = "08-10-2026";
                category = "Examination";
                description =
                        "Internal examination will be conducted from next Monday.";
                break;

            case "College Arts Day":
                date = "15-10-2026";
                category = "Events";
                description =
                        "The college Arts Day celebration will be held on campus.";
                break;

            case "Holiday Announcement":
                date = "20-10-2026";
                category = "General";
                description =
                        "The college will remain closed on the announced holiday.";
                break;

            case "Assignment Submission":
                date = "25-10-2026";
                category = "Academic";
                description =
                        "Students should submit their assignments to the subject teachers.";
                break;

            case "Sports Day":
                date = "30-10-2026";
                category = "Events";
                description =
                        "The annual Sports Day will be held on the college grounds.";
                break;

            default:
                date = "Not specified";
                category = "General";
                description =
                        "No additional information is available for this circular.";
        }

        JLabel heading = new JLabel("CIRCULAR DETAILS");
        heading.setFont(new Font("Arial", Font.BOLD, 26));
        heading.setForeground(TITLE_COLOR);
        heading.setHorizontalAlignment(SwingConstants.CENTER);

        JPanel headingPanel = new JPanel(new BorderLayout());
        headingPanel.setOpaque(false);
        headingPanel.add(heading, BorderLayout.CENTER);

        JPanel infoPanel = new JPanel(new GridBagLayout());
        infoPanel.setOpaque(false);

        addInfoRow(infoPanel, "Circular Title:", circularTitle, 0);
        addInfoRow(infoPanel, "Date:", date, 1);
        addInfoRow(infoPanel, "Category:", category, 2);

        JLabel descriptionLabel = new JLabel("Description");
        descriptionLabel.setFont(new Font("Arial", Font.BOLD, 15));
        descriptionLabel.setForeground(TITLE_COLOR);

        JTextArea descriptionArea = new JTextArea(description);
        descriptionArea.setFont(new Font("Arial", Font.PLAIN, 15));
        descriptionArea.setLineWrap(true);
        descriptionArea.setWrapStyleWord(true);
        descriptionArea.setEditable(false);
        descriptionArea.setBackground(Color.WHITE);
        descriptionArea.setBorder(new EmptyBorder(10, 11, 10, 11));

        JScrollPane descriptionScroll = new JScrollPane(descriptionArea);
        descriptionScroll.setPreferredSize(new Dimension(570, 150));
        descriptionScroll.setBorder(
                BorderFactory.createLineBorder(FIELD_BORDER)
        );

        JPanel descriptionPanel = new JPanel(new BorderLayout(0, 8));
        descriptionPanel.setOpaque(false);
        descriptionPanel.add(descriptionLabel, BorderLayout.NORTH);
        descriptionPanel.add(descriptionScroll, BorderLayout.CENTER);

        JPanel bodyPanel = new JPanel(new BorderLayout(0, 20));
        bodyPanel.setOpaque(false);
        bodyPanel.add(infoPanel, BorderLayout.NORTH);
        bodyPanel.add(descriptionPanel, BorderLayout.CENTER);

        JButton backButton = new JButton("Back");
        backButton.setFont(new Font("Arial", Font.BOLD, 14));
        backButton.setBackground(PRIMARY_COLOR);
        backButton.setForeground(Color.WHITE);
        backButton.setPreferredSize(new Dimension(125, 40));
        backButton.setFocusPainted(false);
        backButton.setOpaque(true);
        backButton.setBorderPainted(false);
        backButton.setCursor(new Cursor(Cursor.HAND_CURSOR));

        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 0, 0));
        buttonPanel.setOpaque(false);
        buttonPanel.add(backButton);

        JPanel card = new JPanel(new BorderLayout(0, 24));
        card.setBackground(CARD_COLOR);
        card.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(new Color(226, 232, 240), 1),
                new EmptyBorder(28, 34, 25, 34)
        ));
        card.setPreferredSize(new Dimension(680, 455));
        card.add(headingPanel, BorderLayout.NORTH);
        card.add(bodyPanel, BorderLayout.CENTER);
        card.add(buttonPanel, BorderLayout.SOUTH);

        JPanel page = new JPanel(new GridBagLayout());
        page.setBackground(PAGE_COLOR);
        page.setBorder(new EmptyBorder(24, 24, 24, 24));
        page.add(card);

        frame.setContentPane(page);

        backButton.addActionListener(e -> {
            ViewCircularsFrame.main(new String[0]);
            frame.dispose();
        });

        frame.setSize(900, 620);
        frame.setMinimumSize(new Dimension(700, 520));
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    private static void addInfoRow(
            JPanel panel,
            String labelText,
            String valueText,
            int row
    ) {
        JLabel label = new JLabel(labelText);
        label.setFont(new Font("Arial", Font.BOLD, 14));
        label.setForeground(TITLE_COLOR);

        JLabel value = new JLabel(valueText);
        value.setFont(new Font("Arial", Font.PLAIN, 15));
        value.setForeground(new Color(51, 65, 85));
        value.setBorder(new EmptyBorder(9, 11, 9, 11));
        value.setOpaque(true);
        value.setBackground(new Color(248, 250, 252));
        value.setPreferredSize(new Dimension(475, 38));

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridy = row;
        gbc.insets = new Insets(5, 6, 5, 10);
        gbc.anchor = GridBagConstraints.WEST;

        gbc.gridx = 0;
        gbc.weightx = 0;
        gbc.fill = GridBagConstraints.NONE;
        panel.add(label, gbc);

        gbc.gridx = 1;
        gbc.weightx = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        panel.add(value, gbc);
    }
}
