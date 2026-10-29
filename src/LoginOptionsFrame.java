import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class LoginOptionsFrame {

    private static final Color PAGE_COLOR = new Color(241, 245, 249);
    private static final Color CARD_COLOR = Color.WHITE;
    private static final Color TITLE_COLOR = new Color(30, 58, 85);
    private static final Color PRIMARY_COLOR = new Color(37, 99, 235);
    private static final Color SECONDARY_COLOR = new Color(226, 232, 240);

    public static void main(String[] args) {
        SwingUtilities.invokeLater(LoginOptionsFrame::showWindow);
    }

    private static void showWindow() {
        JFrame frame = new JFrame("Choose Login");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JLabel title = new JLabel("CHOOSE LOGIN TYPE");
        title.setFont(new Font("Arial", Font.BOLD, 26));
        title.setForeground(TITLE_COLOR);
        title.setHorizontalAlignment(SwingConstants.CENTER);

        JLabel subtitle = new JLabel("Select how you want to continue");
        subtitle.setFont(new Font("Arial", Font.PLAIN, 14));
        subtitle.setForeground(new Color(100, 116, 139));
        subtitle.setHorizontalAlignment(SwingConstants.CENTER);

        JPanel headingPanel = new JPanel(new GridLayout(2, 1, 0, 8));
        headingPanel.setOpaque(false);
        headingPanel.add(title);
        headingPanel.add(subtitle);

        JButton studentButton = new JButton("Student Login");
        JButton adminButton = new JButton("Admin Login");
        JButton backButton = new JButton("Back");

        styleButton(studentButton, PRIMARY_COLOR, Color.WHITE);
        styleButton(adminButton, PRIMARY_COLOR, Color.WHITE);
        styleButton(backButton, SECONDARY_COLOR, TITLE_COLOR);

        JPanel choicePanel = new JPanel(new GridLayout(2, 1, 0, 14));
        choicePanel.setOpaque(false);
        choicePanel.add(studentButton);
        choicePanel.add(adminButton);

        JPanel backPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 0, 0));
        backPanel.setOpaque(false);
        backPanel.add(backButton);

        JPanel card = new JPanel(new BorderLayout(0, 28));
        card.setBackground(CARD_COLOR);
        card.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(new Color(226, 232, 240), 1),
                new EmptyBorder(32, 44, 28, 44)
        ));
        card.setPreferredSize(new Dimension(500, 355));

        card.add(headingPanel, BorderLayout.NORTH);

        JPanel choiceHolder = new JPanel(new GridBagLayout());
        choiceHolder.setOpaque(false);
        choiceHolder.add(choicePanel);
        card.add(choiceHolder, BorderLayout.CENTER);

        card.add(backPanel, BorderLayout.SOUTH);

        JPanel page = new JPanel(new GridBagLayout());
        page.setBackground(PAGE_COLOR);
        page.setBorder(new EmptyBorder(28, 28, 28, 28));
        page.add(card);

        frame.setContentPane(page);
        frame.getRootPane().setDefaultButton(studentButton);

        studentButton.addActionListener(e -> {
            LoginFrame.main(new String[0]);
            frame.dispose();
        });

        adminButton.addActionListener(e -> {
            AdminLoginFrame.main(new String[0]);
            frame.dispose();
        });

        backButton.addActionListener(e -> {
            WelcomeFrame.main(new String[0]);
            frame.dispose();
        });

        frame.setSize(800, 540);
        frame.setMinimumSize(new Dimension(650, 440));
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    private static void styleButton(
            JButton button,
            Color background,
            Color foreground
    ) {
        button.setFont(new Font("Arial", Font.BOLD, 15));
        button.setBackground(background);
        button.setForeground(foreground);
        button.setPreferredSize(new Dimension(270, 46));
        button.setFocusPainted(false);
        button.setOpaque(true);
        button.setBorderPainted(false);
        button.setCursor(new Cursor(Cursor.HAND_CURSOR));
    }
}
