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

        JTextArea resultArea = new JTextArea();
        resultArea.setEditable(false);

        JPanel searchPanel = new JPanel();

        searchPanel.add(searchLabel);
        searchPanel.add(searchField);
        searchPanel.add(searchButton);

        frame.setLayout(new BorderLayout(15, 15));

        frame.add(title, BorderLayout.NORTH);
        frame.add(searchPanel, BorderLayout.CENTER);
        frame.add(new JScrollPane(resultArea), BorderLayout.SOUTH);

        searchButton.addActionListener(e -> {

            String text = searchField.getText();

            resultArea.setText(
                    "Search result for: " + text
            );
        });

        frame.setSize(650, 450);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
