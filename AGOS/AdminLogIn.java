package AGOS;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.border.Border;


public class AdminLogIn extends JFrame implements ActionListener{
    
    JLabel titleLabel, userLabel, passwordLabel;
    JPanel adminPanel, userPanel, passwordPanel;
    JTextField username; //this will help for user input
    JPasswordField password; //like a textfield but has password related methods
    JButton submit;
    Border border = BorderFactory.createLineBorder(Color.BLACK,5); //creates a border named "border"

    private final String correctUsername = "admin"; //a constant value of correct username
    private final String correctPassword = "password123"; //a constant value of correct password

    AdminLogIn(){

        adminPanel = new JPanel();
        adminPanel.setBounds(25,25,425,400);
        adminPanel.setBorder(border);
        adminPanel.setLayout(null);

        this.add(adminPanel);

        titleLabel = new JLabel("Admin Log-In");
        titleLabel.setBounds(130,50,300,100);
        titleLabel.setFont(new Font("Consolas", Font.BOLD, 24));

        adminPanel.add(titleLabel);

        userPanel = new JPanel();
        userPanel.setBounds(100,150,200,50);
        userPanel.setLayout(null);
        //userPanel.setBorder(border);

        adminPanel.add(userPanel);

        userLabel = new JLabel("Username: ");
        userLabel.setBounds(10,15,80,20);
        userLabel.setFont(new Font("Consolas", Font.PLAIN, 12));

        userPanel.add(userLabel);

        username = new JTextField();
        username.setBounds(70,15,120,20);
        
        userPanel.add(username);

        passwordPanel = new JPanel();
        passwordPanel.setBounds(100,200, 200, 50);
        passwordPanel.setLayout(null);
        //passwordPanel.setBorder(border);

        adminPanel.add(passwordPanel);

        passwordLabel = new JLabel("Password: ");
        passwordLabel.setBounds(10, 15, 80, 20);
        passwordLabel.setFont(new Font("Consolas", Font.PLAIN, 12));

        passwordPanel.add(passwordLabel);

        password = new JPasswordField();
        password.setBounds(70,15,120,20);
        password.setEchoChar('*'); //this sets the character that the user will input to be '*' to not be seen in the naked eye.

        passwordPanel.add(password);

        submit = new JButton();
        submit.setText("Submit");
        submit.setBounds(180,270,80,30);
        submit.setFont(new Font("Consolas", Font.BOLD, 12));
        submit.setFocusable(false);
        submit.addActionListener(this);

        adminPanel.add(submit);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(500,500);
        this.setTitle("Admin Log-In");
        this.setLayout(null);
        

        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // Retrieve user inputs
        String enteredUsername = username.getText();
        String enteredPassword = new String(password.getPassword());

        // Validate credentials
        if (enteredUsername.equals(correctUsername) && enteredPassword.equals(correctPassword)) {
            JOptionPane.showMessageDialog(null, "Login Successful!", "Success", JOptionPane.INFORMATION_MESSAGE);
            this.dispose();
            new AdminTable();
        } else {
            JOptionPane.showMessageDialog(null, "Invalid Username or Password", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
}

