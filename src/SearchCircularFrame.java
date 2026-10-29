import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class SearchCircularFrame {

    private static final Color PAGE_COLOR = new Color(241, 245, 249);
    private static final Color CARD_COLOR = Color.WHITE;
    private static final Color TITLE_COLOR = new Color(30, 58, 85);
    private static final Color PRIMARY_COLOR = new Color(37, 99, 235);
    private static final Color SECONDARY_COLOR = new Color(226, 232, 240);
    private static final Color FIELD_BORDER = new Color(203, 213, 225);

    public static void main(String[] args) {
        SwingUtilities.invokeLater(SearchCircularFrame::showWindow);
    }

    private static void showWindow() {
        JFrame frame = new JFrame("Search Circular");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JLabel title = new JLabel("SEARCH CIRCULAR");
        title.setFont(new Font("Arial", Font.BOLD, 26));
        title.setForeground(TITLE_COLOR);
        title.setHorizontalAlignment(SwingConstants.CENTER);

        JLabel subtitle = new JLabel("Find a notice by title or keyword");
        subtitle.setFont(new Font("Arial", Font.PLAIN, 14));
        subtitle.setForeground(new Color(100, 116, 139));
        subtitle.setHorizontalAlignment(SwingConstants.CENTER);

        JPanel headingPanel = new JPanel(new GridLayout(2, 1, 0, 8));
        headingPanel.setOpaque(false);
        headingPanel.add(title);
        headingPanel.add(subtitle);

        JLabel searchLabel = new JLabel("Search:");
        searchLabel.setFont(new Font("Arial", Font.BOLD, 14));
        searchLabel.setForeground(TITLE_COLOR);

        JTextField searchField = new JTextField();
        searchField.setFont(new Font("Arial", Font.PLAIN, 15));
        searchField.setPreferredSize(new Dimension(420, 40));
        searchField.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(FIELD_BORDER),
                new EmptyBorder(5, 9, 5, 9)
        ));

        JButton searchButton = new JButton("Search");
        JButton backButton = new JButton("Back");

        styleButton(searchButton, PRIMARY_COLOR, Color.WHITE, 115);
        styleButton(backButton, SECONDARY_COLOR, TITLE_COLOR, 105);

        JPanel searchPanel = new JPanel(new GridBagLayout());
        searchPanel.setOpaque(false);

        GridBagConstraints searchGbc = new GridBagConstraints();
        searchGbc.insets = new Insets(5, 7, 5, 7);
        searchGbc.gridy = 0;
        searchGbc.anchor = GridBagConstraints.CENTER;

        searchGbc.gridx = 0;
        searchGbc.weightx = 0;
        searchGbc.fill = GridBagConstraints.NONE;
        searchPanel.add(searchLabel, searchGbc);

        searchGbc.gridx = 1;
        searchGbc.weightx = 1;
        searchGbc.fill = GridBagConstraints.HORIZONTAL;
        searchPanel.add(searchField, searchGbc);

        searchGbc.gridx = 2;
        searchGbc.weightx = 0;
        searchGbc.fill = GridBagConstraints.NONE;
        searchPanel.add(searchButton, searchGbc);

        JTextArea resultArea = new JTextArea(
                "Enter a keyword above and select Search to find matching notices."
        );
        resultArea.setFont(new Font("Arial", Font.PLAIN, 15));
        resultArea.setForeground(new Color(51, 65, 85));
        resultArea.setBackground(Color.WHITE);
        resultArea.setEditable(false);
        resultArea.setLineWrap(true);
        resultArea.setWrapStyleWord(true);
        resultArea.setBorder(new EmptyBorder(12, 14, 12, 14));

        JScrollPane resultScroll = new JScrollPane(resultArea);
        resultScroll.setPreferredSize(new Dimension(590, 250));
        resultScroll.setBorder(
                BorderFactory.createLineBorder(FIELD_BORDER)
        );

        JPanel backPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 0, 0));
        backPanel.setOpaque(false);
        backPanel.add(backButton);

        JPanel contentPanel = new JPanel(new BorderLayout(0, 16));
        contentPanel.setOpaque(false);
        contentPanel.add(searchPanel, BorderLayout.NORTH);
        contentPanel.add(resultScroll, BorderLayout.CENTER);
        contentPanel.add(backPanel, BorderLayout.SOUTH);

        JPanel card = new JPanel(new BorderLayout(0, 24));
        card.setBackground(CARD_COLOR);
        card.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(new Color(226, 232, 240), 1),
                new EmptyBorder(28, 30, 26, 30)
        ));
        card.setPreferredSize(new Dimension(680, 450));
        card.add(headingPanel, BorderLayout.NORTH);
        card.add(contentPanel, BorderLayout.CENTER);

        JPanel page = new JPanel(new GridBagLayout());
        page.setBackground(PAGE_COLOR);
        page.setBorder(new EmptyBorder(24, 24, 24, 24));
        page.add(card);

        frame.setContentPane(page);
        frame.getRootPane().setDefaultButton(searchButton);

        String[] circulars = {
                "Internal Examination",
                "College Arts Day",
                "Holiday Announcement",
                "Assignment Submission",
                "Sports Day"
        };

        searchButton.addActionListener(e -> {
            String searchText = searchField.getText().trim();

            if (searchText.isEmpty()) {
                resultArea.setText("Please enter a title or keyword to search.");
                return;
            }

            StringBuilder matches = new StringBuilder();

            for (String circular : circulars) {
                if (circular.toLowerCase().contains(searchText.toLowerCase())) {
                    matches.append(circular).append("\n");
                }
            }

            if (matches.length() == 0) {
                resultArea.setText("No matching circular found.");
            } else {
                resultArea.setText("Matching circulars:\n\n" + matches);
            }

            resultArea.setCaretPosition(0);
        });

        backButton.addActionListener(e -> {
            DashboardFrame.main(new String[0]);
            frame.dispose();
        });

        frame.setSize(900, 620);
        frame.setMinimumSize(new Dimension(700, 520));
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
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
