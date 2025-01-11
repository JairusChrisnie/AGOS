import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

public class LoginForm {
    public static void main(String[] args) {
        // Create the frame
        JFrame frame = new JFrame("Login Form");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 250);
        frame.setLayout(null);

        // Placeholder color
        Color placeholderColor = Color.GRAY;

        // Email field with placeholder
        JTextField emailField = new JTextField("Your e-mail");
        emailField.setBounds(80, 50, 250, 40);
        emailField.setForeground(placeholderColor);
        emailField.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY, 1));

        // Add FocusListener for placeholder effect
        emailField.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if (emailField.getText().equals("Your e-mail")) {
                    emailField.setText("");
                    emailField.setForeground(Color.BLACK); // Set normal text color
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (emailField.getText().isEmpty()) {
                    emailField.setText("Your e-mail");
                    emailField.setForeground(placeholderColor); // Restore placeholder color
                }
            }
        });

        frame.add(emailField);

        // Password field with placeholder
        JPasswordField passwordField = new JPasswordField("Password");
        passwordField.setBounds(80, 110, 250, 40);
        passwordField.setForeground(placeholderColor);
        passwordField.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY, 1));

        // Add FocusListener for placeholder effect
        passwordField.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if (String.valueOf(passwordField.getPassword()).equals("Password")) {
                    passwordField.setText("");
                    passwordField.setEchoChar('●'); // Set echo char for password input
                    passwordField.setForeground(Color.BLACK);
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (String.valueOf(passwordField.getPassword()).isEmpty()) {
                    passwordField.setText("Password");
                    passwordField.setEchoChar((char) 0); // Remove echo char for placeholder
                    passwordField.setForeground(placeholderColor);
                }
            }
        });

        frame.add(passwordField);

        // Display frame
        frame.setVisible(true);
    }
}
