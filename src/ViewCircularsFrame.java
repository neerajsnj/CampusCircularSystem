import javax.swing.*;
import javax.swing.border.EmptyBorder;
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

    private static final Color PAGE_COLOR = new Color(241, 245, 249);
    private static final Color CARD_COLOR = Color.WHITE;
    private static final Color TITLE_COLOR = new Color(30, 58, 85);
    private static final Color PRIMARY_COLOR = new Color(37, 99, 235);
    private static final Color SECONDARY_COLOR = new Color(226, 232, 240);

    public static void main(String[] args) {
        show("All");
    }

    public static void show(String selectedCategory) {
        if (SwingUtilities.isEventDispatchThread()) {
            createWindow(selectedCategory);
        } else {
            SwingUtilities.invokeLater(() -> createWindow(selectedCategory));
        }
    }

    private static void createWindow(String selectedCategory) {
        JFrame frame = new JFrame("View Circulars");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        String headingText = selectedCategory.equals("All")
                ? "AVAILABLE CIRCULARS"
                : selectedCategory.toUpperCase() + " CIRCULARS";

        JLabel title = new JLabel(headingText);
        title.setFont(new Font("Arial", Font.BOLD, 26));
        title.setForeground(TITLE_COLOR);
        title.setHorizontalAlignment(SwingConstants.CENTER);

        JLabel subtitle = new JLabel("Select a circular to read its details");
        subtitle.setFont(new Font("Arial", Font.PLAIN, 14));
        subtitle.setForeground(new Color(100, 116, 139));
        subtitle.setHorizontalAlignment(SwingConstants.CENTER);

        JPanel headingPanel = new JPanel(new GridLayout(2, 1, 0, 8));
        headingPanel.setOpaque(false);
        headingPanel.add(title);
        headingPanel.add(subtitle);

        DefaultListModel<String> listModel = new DefaultListModel<>();

        for (int i = 0; i < CIRCULARS.length; i++) {
            if (selectedCategory.equals("All")
                    || CATEGORIES[i].equals(selectedCategory)) {
                listModel.addElement(CIRCULARS[i]);
            }
        }

        JList<String> circularList = new JList<>(listModel);
        circularList.setFont(new Font("Arial", Font.PLAIN, 16));
        circularList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        circularList.setFixedCellHeight(40);
        circularList.setSelectionBackground(new Color(219, 234, 254));
        circularList.setSelectionForeground(TITLE_COLOR);
        circularList.setBorder(new EmptyBorder(6, 10, 6, 10));

        JScrollPane scrollPane = new JScrollPane(circularList);
        scrollPane.setPreferredSize(new Dimension(600, 315));
        scrollPane.setBorder(
                BorderFactory.createLineBorder(new Color(203, 213, 225))
        );

        JButton viewButton = new JButton("View");
        JButton backButton = new JButton("Back");

        styleButton(viewButton, PRIMARY_COLOR, Color.WHITE, 120);
        styleButton(backButton, SECONDARY_COLOR, TITLE_COLOR, 110);

        JPanel buttonPanel = new JPanel(
                new FlowLayout(FlowLayout.CENTER, 12, 0)
        );
        buttonPanel.setOpaque(false);
        buttonPanel.add(viewButton);
        buttonPanel.add(backButton);

        JPanel card = new JPanel(new BorderLayout(0, 22));
        card.setBackground(CARD_COLOR);
        card.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(new Color(226, 232, 240), 1),
                new EmptyBorder(28, 30, 26, 30)
        ));
        card.setPreferredSize(new Dimension(700, 485));
        card.add(headingPanel, BorderLayout.NORTH);
        card.add(scrollPane, BorderLayout.CENTER);
        card.add(buttonPanel, BorderLayout.SOUTH);

        JPanel page = new JPanel(new GridBagLayout());
        page.setBackground(PAGE_COLOR);
        page.setBorder(new EmptyBorder(24, 24, 24, 24));
        page.add(card);

        frame.setContentPane(page);
        frame.getRootPane().setDefaultButton(viewButton);

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

        frame.setSize(900, 650);
        frame.setMinimumSize(new Dimension(720, 540));
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
