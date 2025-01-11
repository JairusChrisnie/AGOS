import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FerrySchedulingSystem {
    private JFrame frame;
    private JTable seatTable;
    private DefaultTableModel tableModel;
    private boolean isAdmin = false; // Role check flag

    public FerrySchedulingSystem() {
        // GUI Setup
        frame = new JFrame("Ferry Scheduling System");
        frame.setSize(600, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Table Model (5 rows, 5 columns)
        tableModel = new DefaultTableModel(5, 5);
        seatTable = new JTable(tableModel);
        seatTable.setEnabled(false); // Initially read-only
        frame.add(new JScrollPane(seatTable));

        // Menu Bar Setup
        JMenuBar menuBar = new JMenuBar();
        JMenu userMenu = new JMenu("User");
        JMenuItem adminLogin = new JMenuItem("Admin Login");
        JMenuItem passengerLogin = new JMenuItem("Passenger Login");

        adminLogin.addActionListener(e -> adminLogin());
        passengerLogin.addActionListener(e -> passengerLogin());

        userMenu.add(adminLogin);
        userMenu.add(passengerLogin);
        menuBar.add(userMenu);
        frame.setJMenuBar(menuBar);

        frame.setVisible(true);
    }

    // Admin Login with Password
    private void adminLogin() {
        String password = JOptionPane.showInputDialog(frame, "Enter Admin Password:");
        if ("admin123".equals(password)) {
            isAdmin = true;
            seatTable.setEnabled(true);  // Allow editing
            JOptionPane.showMessageDialog(frame, "Admin access granted! You can now edit the table.");
        } else {
            JOptionPane.showMessageDialog(frame, "Incorrect password. Access denied.");
        }
    }

    // Passenger Login (Read-Only Mode)
    private void passengerLogin() {
        isAdmin = false;
        seatTable.setEnabled(false); // Prevent editing
        JOptionPane.showMessageDialog(frame, "Passenger view only. Editing disabled.");
    }

    public static void main(String[] args) {
        new FerrySchedulingSystem();
    }
}

