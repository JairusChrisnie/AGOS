package AGOS;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PersonalInfoFrame extends JFrame implements ActionListener {

    ImageIcon perInfoicon;
    JButton save, cancel;
    JTextField nameField, ageField, addressField, phoneField;
    JRadioButton maleButton, femaleButton, otherButton, unknownButton;
    JComboBox destination;

    PersonalInfoFrame() {

        this.setTitle("Personal Information");
        this.setSize(420, 410);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new BorderLayout()); 

        perInfoicon = new ImageIcon("C:\\Users\\yvan\\IdeaProjects\\untitled\\GUI PRACTICE\\src\\AGOS\\personalInfoicon.png");

        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS)); 

        // JPanel for the Name field
        JPanel namePanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JLabel nameLabel = new JLabel("Name:");
        nameLabel.setFont(new Font("Arial", Font.BOLD, 14));

        nameField = new JTextField();
        nameField.setPreferredSize(new Dimension(315, 30));
        nameField.setFont(new Font("Consolas", Font.PLAIN, 14));
        nameField.setText("Juan A. Delacruz");

        namePanel.add(nameLabel);
        namePanel.add(nameField);
        mainPanel.add(namePanel);

        // A JPanel for the Gender selection
        JPanel genderPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JLabel genderLabel = new JLabel("Gender:");
        genderLabel.setFont(new Font("Arial", Font.BOLD, 14));

        maleButton = new JRadioButton("Male");
        femaleButton = new JRadioButton("Female");
        otherButton = new JRadioButton("Other");
        unknownButton = new JRadioButton("Prefer not to say");

        ButtonGroup genderGroup = new ButtonGroup();
        genderGroup.add(maleButton);
        genderGroup.add(femaleButton);
        genderGroup.add(otherButton);
        genderGroup.add(unknownButton);

        genderPanel.add(genderLabel);
        genderPanel.add(maleButton);
        genderPanel.add(femaleButton);
        genderPanel.add(otherButton);
        genderPanel.add(unknownButton);
        mainPanel.add(genderPanel);

        // A JPanel for the Age Field
        JPanel agePanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JLabel ageLabel = new JLabel("Age:");
        ageLabel.setFont(new Font("Arial", Font.BOLD, 14));

        ageField = new JTextField();
        ageField.setPreferredSize(new Dimension(25, 30));
        ageField.setFont(new Font("Consolas", Font.PLAIN, 14));

        agePanel.add(ageLabel);
        agePanel.add(ageField);
        mainPanel.add(agePanel);

        JPanel addressPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JLabel addressLabel = new JLabel("Address:");
        addressLabel.setFont(new Font("Arial", Font.BOLD, 14));

        addressField = new JTextField();
        addressField.setPreferredSize(new Dimension(295, 30));
        addressField.setFont(new Font("Consolas", Font.PLAIN, 14));
        addressField.setText("Block, Lot, Street, City");

        addressPanel.add(addressLabel);
        addressPanel.add(addressField);
        mainPanel.add(addressPanel);

        JPanel destinationPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JLabel destinationLabel = new JLabel("Destination:");
        destinationLabel.setFont(new Font("Arial", Font.BOLD, 14));

        String[] ferryStation = {"Quinta", "Lawton", "Escolta", "Sta. Ana", "Lambingan", "Valenzuela", "Hulo", "Guadalupe", "San Jaoquin", "Kalawaan"};
        destination = new JComboBox(ferryStation);
        destination.addActionListener(this);

        destinationPanel.add(destinationLabel);
        destinationPanel.add(destination);
        mainPanel.add(destinationPanel);

        // A JPanel for the Phone field
        JPanel phonePanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JLabel phoneLabel = new JLabel("Phone Number:");
        phoneLabel.setFont(new Font("Arial", Font.BOLD, 14));

        phoneField = new JTextField();
        phoneField.setPreferredSize(new Dimension(250, 30));
        phoneField.setFont(new Font("Consolas", Font.PLAIN, 14));
        phoneField.setText("+63");

        phonePanel.add(phoneLabel);
        phonePanel.add(phoneField);
        mainPanel.add(phonePanel);

        this.add(mainPanel, BorderLayout.CENTER);

        // A JPanel for Save and Cancel Buttons
        JPanel saveCancelPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT)); 
        save = new JButton("Save");
        cancel = new JButton("Cancel");

        save.addActionListener(this);
        cancel.addActionListener(this);

        saveCancelPanel.add(save);
        saveCancelPanel.add(cancel);

        this.add(saveCancelPanel, BorderLayout.SOUTH); 

        this.setIconImage(perInfoicon.getImage());
        this.setResizable(false);
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == save) {
            System.out.println("Save button clicked!");
            JOptionPane.showMessageDialog(null, "Save Successfully", "Personal Information", JOptionPane.INFORMATION_MESSAGE);
        } else if (e.getSource() == cancel) {
            System.out.println("Cancel button clicked!");
        }
    }
}
