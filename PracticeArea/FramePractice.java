import javax.swing.ImageIcon; //for image/icons
import javax.swing.JFrame; //for frame
import java.awt.Color; //for colors

public class FramePractice {
    public static void main(String[] args) {
        JFrame frame = new JFrame(); //creates the frame
        frame.setTitle("This is a sample frame"); //sets the title of the frame
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//exit out of the application
        frame.setResizable(false);//prevents the frame from being resized
        frame.setSize(420, 420);//sets the size of the frame (x, y)
        frame.setVisible(true); //makes frame visible

        //Changing of Icon/Logo of the frame
        ImageIcon logo = new ImageIcon("PracticeArea\\ferryIcon.jpeg"); //creates an imageIcon with the path of the image
        frame.setIconImage(logo.getImage()); //change icon of the frame
        frame.getContentPane().setBackground(new Color(0x87CEEB)); //change the bg color of the frame
        
    }
}
