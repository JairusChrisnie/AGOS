package SampleProgram;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FerryBookingGUI {
    private FerrySeatManager seatManager;
    private JTable seatTable;
    private JTextField seatNumberField;

    public FerryBookingGUI(int totalSeats) {
        seatManager = new FerrySeatManager(totalSeats);

        JFrame frame = new JFrame("Ferry Seat Booking System");
        frame.setSize(500, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());

        // Table setup
        String[] columnNames = {"Seat Number", "Availability"};
        String[][] data = new String[totalSeats][2];
        for (int i = 0; i < totalSeats; i++) {
            data[i][0] = String.valueOf(i + 1);
            data[i][1] = "Available";
        }
        seatTable = new JTable(data, columnNames);
        seatTable.setEnabled(false);  // Prevent direct editing by the user

        JScrollPane scrollPane = new JScrollPane(seatTable);
        frame.add(scrollPane, BorderLayout.CENTER);

        // Booking panel setup
        JPanel bookingPanel = new JPanel();
        seatNumberField = new JTextField(5);
        JButton bookButton = new JButton("Book Seat");
        bookingPanel.add(new JLabel("Seat Number:"));
        bookingPanel.add(seatNumberField);
        bookingPanel.add(bookButton);
        frame.add(bookingPanel, BorderLayout.SOUTH);

        // Button functionality
        bookButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    int seatNumber = Integer.parseInt(seatNumberField.getText());
                    if (seatManager.bookSeat(seatNumber)) {
                        seatTable.setValueAt("Taken", seatNumber - 1, 1);
                        JOptionPane.showMessageDialog(frame, "Seat " + seatNumber + " booked!");
                    } else {
                        JOptionPane.showMessageDialog(frame, "Seat not available or invalid.");
                    }
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(frame, "Please enter a valid seat number.");
                }
            }
        });

        frame.setVisible(true);
    }

    public static void main(String[] args) {
        new FerryBookingGUI(20);  // Create a ferry with 20 seats
    }
}
