import javax.swing.*;
import java.awt.GridLayout;

public class AdminFrame extends JFrame {

    public AdminFrame() {
        setTitle("Admin - Add Circular");
        setSize(500, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(5, 2));

        add(new JLabel("Circular title:"));
        add(new JTextField());

        add(new JLabel("Department:"));
        add(new JTextField());

        add(new JLabel("Date:"));
        add(new JTextField());

        add(new JLabel("Message:"));
        add(new JTextArea());

        add(new JButton("Add Circular"));
        add(new JButton("Clear"));

        setVisible(true);
    }

    public static void main(String[] args) {
        new AdminFrame();
    }
}
