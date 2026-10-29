import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class CategoriesFrame {

    private static final Color PAGE_COLOR = new Color(241, 245, 249);
    private static final Color CARD_COLOR = Color.WHITE;
    private static final Color TITLE_COLOR = new Color(30, 58, 85);
    private static final Color PRIMARY_COLOR = new Color(37, 99, 235);
    private static final Color SECONDARY_COLOR = new Color(226, 232, 240);

    public static void main(String[] args) {
        SwingUtilities.invokeLater(CategoriesFrame::showWindow);
    }

    private static void showWindow() {
        JFrame frame = new JFrame("Circular Categories");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JLabel title = new JLabel("CIRCULAR CATEGORIES");
        title.setFont(new Font("Arial", Font.BOLD, 26));
        title.setForeground(TITLE_COLOR);
        title.setHorizontalAlignment(SwingConstants.CENTER);

        JLabel subtitle = new JLabel("Choose a category to browse its circulars");
        subtitle.setFont(new Font("Arial", Font.PLAIN, 14));
        subtitle.setForeground(new Color(100, 116, 139));
        subtitle.setHorizontalAlignment(SwingConstants.CENTER);

        JPanel headingPanel = new JPanel(new GridLayout(2, 1, 0, 8));
        headingPanel.setOpaque(false);
        headingPanel.add(title);
        headingPanel.add(subtitle);

        JButton academicButton = new JButton("Academic");
        JButton examButton = new JButton("Examination");
        JButton eventsButton = new JButton("Events");
        JButton generalButton = new JButton("General");
        JButton backButton = new JButton("Back");

        styleButton(academicButton, PRIMARY_COLOR, Color.WHITE);
        styleButton(examButton, PRIMARY_COLOR, Color.WHITE);
        styleButton(eventsButton, PRIMARY_COLOR, Color.WHITE);
        styleButton(generalButton, PRIMARY_COLOR, Color.WHITE);
        styleButton(backButton, SECONDARY_COLOR, TITLE_COLOR);

        JPanel buttonPanel = new JPanel(new GridLayout(2, 2, 14, 14));
        buttonPanel.setOpaque(false);
        buttonPanel.add(academicButton);
        buttonPanel.add(examButton);
        buttonPanel.add(eventsButton);
        buttonPanel.add(generalButton);

        JPanel backPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 0, 0));
        backPanel.setOpaque(false);
        backPanel.add(backButton);

        JPanel card = new JPanel(new BorderLayout(0, 28));
        card.setBackground(CARD_COLOR);
        card.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(new Color(226, 232, 240), 1),
                new EmptyBorder(30, 34, 28, 34)
        ));
        card.setPreferredSize(new Dimension(590, 390));
        card.add(headingPanel, BorderLayout.NORTH);
        card.add(buttonPanel, BorderLayout.CENTER);
        card.add(backPanel, BorderLayout.SOUTH);

        JPanel page = new JPanel(new GridBagLayout());
        page.setBackground(PAGE_COLOR);
        page.setBorder(new EmptyBorder(28, 28, 28, 28));
        page.add(card);

        frame.setContentPane(page);

        academicButton.addActionListener(e -> {
            ViewCircularsFrame.show("Academic");
            frame.dispose();
        });

        examButton.addActionListener(e -> {
            ViewCircularsFrame.show("Examination");
            frame.dispose();
        });

        eventsButton.addActionListener(e -> {
            ViewCircularsFrame.show("Events");
            frame.dispose();
        });

        generalButton.addActionListener(e -> {
            ViewCircularsFrame.show("General");
            frame.dispose();
        });

        backButton.addActionListener(e -> {
            DashboardFrame.main(new String[0]);
            frame.dispose();
        });

        frame.setSize(850, 600);
        frame.setMinimumSize(new Dimension(680, 500));
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    private static void styleButton(
            JButton button,
            Color background,
            Color foreground
    ) {
        button.setFont(new Font("Arial", Font.BOLD, 16));
        button.setBackground(background);
        button.setForeground(foreground);
        button.setPreferredSize(new Dimension(230, 68));
        button.setFocusPainted(false);
        button.setOpaque(true);
        button.setBorderPainted(false);
        button.setCursor(new Cursor(Cursor.HAND_CURSOR));
    }
}
