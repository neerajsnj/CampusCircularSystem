import javax.swing.*;
import java.awt.*;

public class CircularDetailsFrame {

    public static void main(String[] args) {
        show("Internal Examination");
    }

    public static void show(String circularTitle) {

        JFrame frame = new JFrame("Circular Details");

        JLabel title = new JLabel("CIRCULAR DETAILS");
        title.setFont(new Font("Arial", Font.BOLD, 22));
        title.setHorizontalAlignment(SwingConstants.CENTER);

        JLabel titleLabel = new JLabel("Circular Title:");
        JLabel titleValue = new JLabel(circularTitle);

        JLabel dateLabel = new JLabel("Date:");
        JLabel dateValue = new JLabel();

        JLabel categoryLabel = new JLabel("Category:");
        JLabel categoryValue = new JLabel();

        JLabel descriptionLabel = new JLabel("Description:");
        JTextArea descriptionArea = new JTextArea();

        switch (circularTitle) {
            case "Internal Examination":
                dateValue.setText("08-10-2026");
                categoryValue.setText("Examination");
                descriptionArea.setText(
                        "Internal examination will be conducted from next Monday."
                );
                break;

            case "College Arts Day":
                dateValue.setText("15-10-2026");
                categoryValue.setText("Events");
                descriptionArea.setText(
                        "The college Arts Day celebration will be held on campus."
                );
                break;

            case "Holiday Announcement":
                dateValue.setText("20-10-2026");
                categoryValue.setText("General");
                descriptionArea.setText(
                        "The college will remain closed on the announced holiday."
                );
                break;

            case "Assignment Submission":
                dateValue.setText("25-10-2026");
                categoryValue.setText("Academic");
                descriptionArea.setText(
                        "Students should submit their assignments to the subject teachers."
                );
                break;

            case "Sports Day":
                dateValue.setText("30-10-2026");
                categoryValue.setText("Events");
                descriptionArea.setText(
                        "The annual Sports Day will be held on the college grounds."
                );
                break;

            default:
                dateValue.setText("Not specified");
                categoryValue.setText("General");
                descriptionArea.setText(
                        "No additional information is available for this circular."
                );
        }

        descriptionArea.setLineWrap(true);
        descriptionArea.setWrapStyleWord(true);
        descriptionArea.setEditable(false);

        JPanel infoPanel = new JPanel(new GridLayout(3, 2, 10, 10));
        infoPanel.add(titleLabel);
        infoPanel.add(titleValue);
        infoPanel.add(dateLabel);
        infoPanel.add(dateValue);
        infoPanel.add(categoryLabel);
        infoPanel.add(categoryValue);

        JPanel descriptionPanel = new JPanel(new BorderLayout(5, 5));
        descriptionPanel.add(descriptionLabel, BorderLayout.NORTH);
        descriptionPanel.add(
                new JScrollPane(descriptionArea),
                BorderLayout.CENTER
        );

        JPanel contentPanel = new JPanel(new BorderLayout(15, 15));
        contentPanel.add(infoPanel, BorderLayout.NORTH);
        contentPanel.add(descriptionPanel, BorderLayout.CENTER);

        JButton backButton = new JButton("Back");

        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        buttonPanel.add(backButton);

        frame.setLayout(new BorderLayout(15, 15));
        frame.add(title, BorderLayout.NORTH);
        frame.add(contentPanel, BorderLayout.CENTER);
        frame.add(buttonPanel, BorderLayout.SOUTH);

        backButton.addActionListener(e -> {
            ViewCircularsFrame.main(new String[0]);
            frame.dispose();
        });

        frame.setSize(600, 450);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
