import javax.swing.JFrame;
import javax.swing.JLabel; // package for label
import javax.swing.border.Border;

import java.awt.Color;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;

public class LabelPractice {
    public static void main(String[] args) {
        JFrame frame = new JFrame();
        JLabel label = new JLabel(); //creates a label
        Border border = BorderFactory.createLineBorder(new Color(0x1E3A5F), 15); //creates a border with color and border thickness

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500,500);
        frame.setVisible(true);
        frame.getContentPane().setBackground(new Color(0x87CEEB));
        frame.setLayout(null); // customized the layout of the frame
        frame.add(label); //add the label to the frame

        ImageIcon image = new ImageIcon("PracticeArea\\FerryIcon.png");

        label.setText("AGOS"); //set text of label
        label.setIcon(image); //sets the image of the label
        label.setHorizontalTextPosition(JLabel.CENTER); //sets text LEFT, CENTER, RIGHT of imageIcon
        label.setVerticalTextPosition(JLabel.TOP); //sets the text TOP, CENTER, BOTTOM of imageIcon
        
        label.setForeground(new Color(0xF5F5F5)); //set the font color of text
        label.setFont(new Font("Consolas", Font.BOLD, 32)); //sets the font style of text
        label.setIconTextGap(-5); //set gap of text to image
        label.setBorder(border); //sets the border of label (not image and text)
        label.setVerticalAlignment(JLabel.CENTER); //sets the vertical position of icon (TOP, CENTER, BOTTOM)
        label.setHorizontalAlignment(JLabel.CENTER); //sets the horizontal position of icon (LEFT, CENTER, RIGHT)
        label.setBackground(new Color(0x002147)); //sets the background of label
        label.setOpaque(true); //displays the background
        label.setBounds(100, 100, 300, 300); //sets x, y position within frame as dimensions and width and height of the label

    }
}
