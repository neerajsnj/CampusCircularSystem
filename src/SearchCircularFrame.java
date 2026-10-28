import javax.swing.*;
import java.awt.*;

public class SearchCircularFrame {

    public static void main(String[] args) {

        JFrame frame = new JFrame("Search Circular");

        JLabel title = new JLabel("SEARCH CIRCULAR");
        title.setFont(new Font("Arial", Font.BOLD, 24));
        title.setHorizontalAlignment(SwingConstants.CENTER);

        JLabel searchLabel = new JLabel("Search:");
        JTextField searchField = new JTextField(20);

        JButton searchButton = new JButton("Search");
        JButton backButton = new JButton("Back");

        JTextArea resultArea = new JTextArea();
        resultArea.setEditable(false);
        resultArea.setLineWrap(true);
        resultArea.setWrapStyleWord(true);

        JPanel searchPanel = new JPanel();
        searchPanel.add(searchLabel);
        searchPanel.add(searchField);
        searchPanel.add(searchButton);
        searchPanel.add(backButton);

        String[] circulars = {
                "Internal Examination",
                "College Arts Day",
                "Holiday Announcement",
                "Assignment Submission",
                "Sports Day"
        };

        frame.setLayout(new BorderLayout(15, 15));
        frame.add(title, BorderLayout.NORTH);
        frame.add(searchPanel, BorderLayout.PAGE_START);
        frame.add(new JScrollPane(resultArea), BorderLayout.CENTER);

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
        });

        backButton.addActionListener(e -> {
            DashboardFrame.main(new String[0]);
            frame.dispose();
        });

        frame.setSize(650, 450);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
