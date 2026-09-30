import javax.swing.*;
import java.awt.GridLayout;

public class CircularDetailsFrame extends JFrame {

    public CircularDetailsFrame() {
        setTitle("Circular Details");
        setSize(500, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(3, 1));

        add(new JLabel("Latest Circular"));

        JTextArea details = new JTextArea(
            "Title: Mid-term Examination Schedule\n" +
            "Department: Examination Cell\n" +
            "Date: 25-09-2026\n\n" +
            "Mid-term examinations begin on 12 October."
        );
        details.setEditable(false);
        add(details);

        add(new JButton("OK"));

        setVisible(true);
    }

    public static void main(String[] args) {
        new CircularDetailsFrame();
    }
}
