import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ButtonPractice extends JFrame implements ActionListener { //extends to JFrame so that it can use the this keyword
 // implements ActionListener to make actions to button.
    
    JButton button, button2; //button as a global variable

    ButtonPractice(){

        ImageIcon adminIcon = new ImageIcon("PracticeArea\\AdminIcon.png");
        //Resizing an image icon to your desired size
        Image imageAdminIcon = adminIcon.getImage(); //convert to image object
        Image resizedAdmin = imageAdminIcon.getScaledInstance(50, 50, Image.SCALE_SMOOTH); //resizing the image object
        ImageIcon resizedIcon = new ImageIcon(resizedAdmin); //convert back to icon

        button = new JButton(); //creates a button
        button.setBounds(150, 150, 200, 100); //sets the boundary of button (x, y, width, and height)
        button.addActionListener(this); //adds an action listener to the button (this keyword is because the button is created in the same class)
        button.setText("Admin");
        button.setFocusable(false);
        button.setIcon(resizedIcon);

        ImageIcon passengerIcon = new ImageIcon("PracticeArea\\PassengerIcon.png");
        Image imagePassengerIcon = passengerIcon.getImage();
        Image resizedPassenger = imagePassengerIcon.getScaledInstance(50, 50, Image.SCALE_SMOOTH);
        ImageIcon resizedPassengerIcon = new ImageIcon(resizedPassenger);

        
        button2 = new JButton();
        button2.setBounds(350, 350, 200, 100);
        button2.setText("Passenger");
        button2.setFocusable(false);
        button2.setIcon(resizedPassengerIcon);
        

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new FlowLayout(FlowLayout.CENTER,20,150)); //(Leading, Center, Trailing), horizontal gap and vertical gap
        this.setSize(500, 500);
        this.setTitle("AGOS");
        this.setVisible(true);
        this.add(button);
        this.add(button2);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==button){
            System.out.println("This is an admin space log-in!");
            button.setEnabled(false);
        }
    }
}
