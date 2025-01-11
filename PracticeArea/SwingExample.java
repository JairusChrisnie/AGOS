import javax.swing.*;
import java.awt.*;

public class SwingExample {
    public static void main(String[] args) {
        // Create the frame
        JFrame frame = new JFrame("Swing Components Example");
        frame.setSize(400, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());

        // Create a panel and set a layout
        JPanel panel = new JPanel();
        panel.setBackground(Color.CYAN);

        // Create a label and add it to the panel
        JLabel label = new JLabel("Hello, Swing!");
        panel.add(label);

        // Add the panel to the frame
        frame.add(panel, BorderLayout.CENTER);
        frame.setVisible(true);
    }
}


