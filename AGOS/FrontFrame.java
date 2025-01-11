package AGOS;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FrontFrame extends JFrame implements ActionListener{//extends to JFrame so that it can use the this keyword
    // implements ActionListener to make actions to button.
    JPanel titlePanel, buttonPanel; //These are objects created from the library of javax swing.
    JButton adminButton, passengerButton;
    JLabel titleLabel, subtitle, buttonMessage;

    
    FrontFrame(){
        titlePanel = new JPanel(); //creates a panel. A panel is a container that contains components
        titlePanel.setBounds(0, 0, 500, 150); //sets the size of the panel
        titlePanel.setLayout(null); //sets the layout to null so that we can customize the said layout

        this.add(titlePanel); //the this keyword refers to the constructor FrontFrame so that we don't need to create an object for JFrame

        buttonPanel = new JPanel();
        buttonPanel.setBounds(0, 150, 500, 350);
        buttonPanel.setLayout(null);

        this.add(buttonPanel);

        titleLabel = new JLabel(); //creates a label
        titleLabel.setText("AGOS"); //sets the text for the label
        titleLabel.setFont(new Font("Consolas", Font.BOLD, 32)); //sets the font, style, and size of the label
        titleLabel.setForeground(Color.black); //color of the text
        titleLabel.setBounds(200, 20, 75, 75); //sets the size of the label (think of it as a customized box)

        titlePanel.add(titleLabel); //adds the titeLabel to titlePanel. It is added inside of the panel instead of the frame.

        subtitle = new JLabel();
        subtitle.setText("A PUP Ferry Terminal Information Management");
        subtitle.setFont(new Font("Serif", Font.ITALIC, 16));
        subtitle.setForeground(Color.black);
        subtitle.setBounds(80,50,500,100);

        titlePanel.add(subtitle);

        buttonMessage = new JLabel();
        buttonMessage.setText("Choose your destination:");
        buttonMessage.setFont(new Font("Consolas", Font.PLAIN, 16));
        buttonMessage.setForeground(Color.black);
        buttonMessage.setBounds(130, 20, 250, 50);

        buttonPanel.add(buttonMessage);

        adminButton = new JButton(); //creates a button
        adminButton.setBounds(150, 100, 200, 100);//sets the boundary of the button or button size
        adminButton.setText("Admin");//text inside of a button
        adminButton.setFocusable(false);//this is the border of the text so we made it false to not be seen
        adminButton.addActionListener(this); //this means that we created an action listener to the button so this button will do something

        ImageIcon adminIcon = new ImageIcon("AGOS\\AdminIcon.png"); //creates an image icon from the source or file path
        Image imageAdminIcon = adminIcon.getImage(); //convert to image object
        Image resizedAdmin = imageAdminIcon.getScaledInstance(50, 50, Image.SCALE_SMOOTH); //resizing the image object
        ImageIcon resizedIcon = new ImageIcon(resizedAdmin); //convert back to icon
        adminButton.setIcon(resizedIcon); //set the resized icon
        
        buttonPanel.add(adminButton); //adds the button to the button panel

        passengerButton = new JButton();
        passengerButton.setBounds(150, 220, 200, 100);
        passengerButton.setText("Passenger");
        passengerButton.setFocusable(false);

        ImageIcon passengerIcon = new ImageIcon("AGOS\\PassengerIcon.png");
        Image imagePassengerIcon = passengerIcon.getImage();
        Image resizedPassenger = imagePassengerIcon.getScaledInstance(50, 50, Image.SCALE_SMOOTH);
        ImageIcon resizedPassengerIcon = new ImageIcon(resizedPassenger);
        passengerButton.setIcon(resizedPassengerIcon);

        buttonPanel.add(passengerButton);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //this means that when we close the frame, it will really close the program
        this.setSize(500,500); //this is the size of the frame
        this.setTitle("AGOS"); //title of the frame
        this.setLayout(null); //layout is null so we can customize the boundaries

        this.setVisible(true); //this will make the frame visible
    }

    @Override
    public void actionPerformed(ActionEvent e) { //this is the action listener that the button will do
        if(e.getSource()==adminButton){ //this means that if we clicked on the button it will do something
            this.dispose(); //if we click the admin button, the front frame will be disposed or it will exit
            new AdminLogIn(); //a new frame will appear
        }
    }
}
