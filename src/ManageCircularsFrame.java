import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class ManageCircularsFrame {

    private static final DefaultListModel<String> circularModel =
            new DefaultListModel<>();

    private static final Color PAGE_COLOR = new Color(241, 245, 249);
    private static final Color CARD_COLOR = Color.WHITE;
    private static final Color TITLE_COLOR = new Color(30, 58, 85);
    private static final Color PRIMARY_COLOR = new Color(37, 99, 235);
    private static final Color SECONDARY_COLOR = new Color(226, 232, 240);

    public static void main(String[] args) {
        SwingUtilities.invokeLater(ManageCircularsFrame::showWindow);
    }

    private static void showWindow() {
        if (circularModel.isEmpty()) {
            circularModel.addElement("Internal Examination");
            circularModel.addElement("College Arts Day");
            circularModel.addElement("Holiday Notice");
            circularModel.addElement("Assignment Notice");
            circularModel.addElement("Sports Day");
        }

        JFrame frame = new JFrame("Manage Circulars");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JLabel title = new JLabel("MANAGE CIRCULARS");
        title.setFont(new Font("Arial", Font.BOLD, 26));
        title.setForeground(TITLE_COLOR);
        title.setHorizontalAlignment(SwingConstants.CENTER);

        JLabel subtitle = new JLabel("Add, edit, or remove campus notices");
        subtitle.setFont(new Font("Arial", Font.PLAIN, 14));
        subtitle.setForeground(new Color(100, 116, 139));
        subtitle.setHorizontalAlignment(SwingConstants.CENTER);

        JPanel headingPanel = new JPanel(new GridLayout(2, 1, 0, 8));
        headingPanel.setOpaque(false);
        headingPanel.add(title);
        headingPanel.add(subtitle);

        JList<String> circularList = new JList<>(circularModel);
        circularList.setFont(new Font("Arial", Font.PLAIN, 16));
        circularList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        circularList.setFixedCellHeight(36);
        circularList.setSelectionBackground(new Color(219, 234, 254));
        circularList.setSelectionForeground(TITLE_COLOR);
        circularList.setBorder(new EmptyBorder(5, 8, 5, 8));

        JScrollPane scrollPane = new JScrollPane(circularList);
        scrollPane.setPreferredSize(new Dimension(590, 300));
        scrollPane.setBorder(
                BorderFactory.createLineBorder(new Color(203, 213, 225))
        );

        JButton addButton = new JButton("Add");
        JButton editButton = new JButton("Edit");
        JButton deleteButton = new JButton("Delete");
        JButton clearButton = new JButton("Clear");
        JButton backButton = new JButton("Back");

        styleButton(addButton, PRIMARY_COLOR, Color.WHITE);
        styleButton(editButton, SECONDARY_COLOR, TITLE_COLOR);
        styleButton(deleteButton, SECONDARY_COLOR, TITLE_COLOR);
        styleButton(clearButton, SECONDARY_COLOR, TITLE_COLOR);
        styleButton(backButton, SECONDARY_COLOR, TITLE_COLOR);

        JPanel buttonPanel = new JPanel(
                new FlowLayout(FlowLayout.CENTER, 9, 0)
        );
        buttonPanel.setOpaque(false);
        buttonPanel.add(addButton);
        buttonPanel.add(editButton);
        buttonPanel.add(deleteButton);
        buttonPanel.add(clearButton);
        buttonPanel.add(backButton);

        JPanel card = new JPanel(new BorderLayout(0, 22));
        card.setBackground(CARD_COLOR);
        card.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(new Color(226, 232, 240), 1),
                new EmptyBorder(28, 30, 26, 30)
        ));
        card.setPreferredSize(new Dimension(700, 480));
        card.add(headingPanel, BorderLayout.NORTH);
        card.add(scrollPane, BorderLayout.CENTER);
        card.add(buttonPanel, BorderLayout.SOUTH);

        JPanel page = new JPanel(new GridBagLayout());
        page.setBackground(PAGE_COLOR);
        page.setBorder(new EmptyBorder(24, 24, 24, 24));
        page.add(card);

        frame.setContentPane(page);

        addButton.addActionListener(e -> {
            AddCircularFrame.main(new String[0]);
            frame.dispose();
        });

        editButton.addActionListener(e -> {
            int selectedIndex = circularList.getSelectedIndex();

            if (selectedIndex == -1) {
                JOptionPane.showMessageDialog(
                        frame,
                        "Select a circular to edit."
                );
                return;
            }

            String currentTitle = circularModel.getElementAt(selectedIndex);
            String updatedTitle = JOptionPane.showInputDialog(
                    frame,
                    "Edit circular title:",
                    currentTitle
            );

            if (updatedTitle != null && !updatedTitle.trim().isEmpty()) {
                circularModel.set(selectedIndex, updatedTitle.trim());
            }
        });

        deleteButton.addActionListener(e -> {
            int selectedIndex = circularList.getSelectedIndex();

            if (selectedIndex == -1) {
                JOptionPane.showMessageDialog(
                        frame,
                        "Select a circular to delete."
                );
            } else {
                circularModel.remove(selectedIndex);
            }
        });

        clearButton.addActionListener(e -> circularList.clearSelection());

        backButton.addActionListener(e -> {
            AdminLoginFrame.main(new String[0]);
            frame.dispose();
        });

        frame.setSize(900, 650);
        frame.setMinimumSize(new Dimension(720, 540));
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    public static void addCircular(String circularTitle) {
        circularModel.addElement(circularTitle);
    }

    private static void styleButton(
            JButton button,
            Color background,
            Color foreground
    ) {
        button.setFont(new Font("Arial", Font.BOLD, 14));
        button.setBackground(background);
        button.setForeground(foreground);
        button.setPreferredSize(new Dimension(105, 40));
        button.setFocusPainted(false);
        button.setOpaque(true);
        button.setBorderPainted(false);
        button.setCursor(new Cursor(Cursor.HAND_CURSOR));
    }
}
