
import javax.swing.*;
import java.awt.*;

public class FrontFrame extends JFrame {
    
    JPanel buttonPanel;
    JButton adminButton, passengerButton;

    FrontFrame(){
        // Button Panel
        buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(2, 1));  // 2 rows, 1 column
        buttonPanel.setBounds(0, 150, 500, 250);
        buttonPanel.setBackground(Color.RED);

        // Admin Button
        adminButton = new JButton("Admin");
        adminButton.setFont(new Font("Consolas", Font.PLAIN, 16));
        adminButton.setBackground(Color.BLUE);
        adminButton.setForeground(Color.WHITE);
        
        // Passenger Button
        passengerButton = new JButton("Passenger");
        passengerButton.setFont(new Font("Consolas", Font.PLAIN, 16));
        passengerButton.setBackground(Color.GREEN);
        passengerButton.setForeground(Color.WHITE);

        // Add buttons to the panel
        buttonPanel.add(adminButton);
        buttonPanel.add(passengerButton);

        // Frame Setup
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(500, 500);
        this.setTitle("AGOS");
        this.setLayout(null);
        this.add(buttonPanel);  // Add the buttonPanel to the frame
        this.setVisible(true);
    }

    public static void main(String[] args) {
        new FrontFrame();  // Running the frame
    }
}

