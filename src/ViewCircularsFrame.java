import javax.swing.*;
import java.awt.*;

public class ViewCircularsFrame {

    private static final String[] CIRCULARS = {
            "Internal Examination",
            "College Arts Day",
            "Holiday Announcement",
            "Assignment Submission",
            "Sports Day"
    };

    private static final String[] CATEGORIES = {
            "Examination",
            "Events",
            "General",
            "Academic",
            "Events"
    };

    public static void main(String[] args) {
        show("All");
    }

    public static void show(String selectedCategory) {

        JFrame frame = new JFrame("View Circulars");

        JLabel title = new JLabel(
                selectedCategory.equals("All")
                        ? "AVAILABLE CIRCULARS"
                        : selectedCategory.toUpperCase() + " CIRCULARS"
        );
        title.setFont(new Font("Arial", Font.BOLD, 24));
        title.setHorizontalAlignment(SwingConstants.CENTER);

        DefaultListModel<String> listModel = new DefaultListModel<>();

        for (int i = 0; i < CIRCULARS.length; i++) {
            if (selectedCategory.equals("All")
                    || CATEGORIES[i].equals(selectedCategory)) {
                listModel.addElement(CIRCULARS[i]);
            }
        }

        JList<String> circularList = new JList<>(listModel);

        JButton viewButton = new JButton("View");
        JButton backButton = new JButton("Back");

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(viewButton);
        buttonPanel.add(backButton);

        frame.setLayout(new BorderLayout(15, 15));
        frame.add(title, BorderLayout.NORTH);
        frame.add(new JScrollPane(circularList), BorderLayout.CENTER);
        frame.add(buttonPanel, BorderLayout.SOUTH);

        viewButton.addActionListener(e -> {
            String selectedCircular = circularList.getSelectedValue();

            if (selectedCircular == null) {
                JOptionPane.showMessageDialog(
                        frame,
                        "Please select a circular first."
                );
            } else {
                CircularDetailsFrame.show(selectedCircular);
                frame.dispose();
            }
        });

        backButton.addActionListener(e -> {
            if (selectedCategory.equals("All")) {
                DashboardFrame.main(new String[0]);
            } else {
                CategoriesFrame.main(new String[0]);
            }
            frame.dispose();
        });

        frame.setSize(600, 450);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
