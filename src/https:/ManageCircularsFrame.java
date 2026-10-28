import javax.swing.*;
import java.awt.*;

public class ManageCircularsFrame {

    private static final DefaultListModel<String> circularModel =
            new DefaultListModel<>();

    public static void main(String[] args) {

        if (circularModel.isEmpty()) {
            circularModel.addElement("Internal Examination");
            circularModel.addElement("College Arts Day");
            circularModel.addElement("Holiday Notice");
            circularModel.addElement("Assignment Notice");
            circularModel.addElement("Sports Day");
        }

        JFrame frame = new JFrame("Manage Circulars");

        JLabel title = new JLabel("MANAGE CIRCULARS");
        title.setFont(new Font("Arial", Font.BOLD, 22));
        title.setHorizontalAlignment(SwingConstants.CENTER);

        JList<String> circularList = new JList<>(circularModel);
        circularList.setFont(new Font("Arial", Font.PLAIN, 15));
        circularList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        JScrollPane scrollPane = new JScrollPane(circularList);
        scrollPane.setPreferredSize(new Dimension(430, 220));

        JPanel listPanel = new JPanel(new GridBagLayout());
        listPanel.add(scrollPane);

        JButton addButton = new JButton("Add");
        JButton editButton = new JButton("Edit");
        JButton deleteButton = new JButton("Delete");
        JButton clearButton = new JButton("Clear");
        JButton backButton = new JButton("Back");

        JPanel buttonPanel = new JPanel(
                new FlowLayout(FlowLayout.CENTER, 10, 5)
        );

        buttonPanel.add(addButton);
        buttonPanel.add(editButton);
        buttonPanel.add(deleteButton);
        buttonPanel.add(clearButton);
        buttonPanel.add(backButton);

        frame.setLayout(new BorderLayout(15, 15));
        frame.add(title, BorderLayout.NORTH);
        frame.add(listPanel, BorderLayout.CENTER);
        frame.add(buttonPanel, BorderLayout.SOUTH);

        addButton.addActionListener(e -> {
            AddCircularFrame.main(new String[0]);
            frame.dispose();
        });

        editButton.addActionListener(e -> {
            int selectedIndex = circularList.getSelectedIndex();

            if (selectedIndex == -1) {
                JOptionPane.showMessageDialog(frame, "Select a circular to edit.");
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
                JOptionPane.showMessageDialog(frame, "Select a circular to delete.");
            } else {
                circularModel.remove(selectedIndex);
            }
        });

        clearButton.addActionListener(e -> circularList.clearSelection());

        backButton.addActionListener(e -> {
            AdminLoginFrame.main(new String[0]);
            frame.dispose();
        });

        frame.setSize(650, 500);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    public static void addCircular(String circularTitle) {
        circularModel.addElement(circularTitle);
    }
}
