import javax.swing.*;

public class FerryApp implements FerryGUI {
    private JFrame frame;
    private JTable seatTable;

    @Override
    public void createWindow() {
        frame = new JFrame("Ferry Scheduling");
        frame.setSize(500, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        seatTable = new JTable(5, 5); // Example seat grid
        frame.add(new JScrollPane(seatTable));
        
        frame.setVisible(true);
    }

    @Override
    public void updateSeatTable() {
        // Example: Updating a seat to show it as booked
        seatTable.setValueAt("Booked", 0, 0);
    }

    public static void main(String[] args) {
        FerryApp app = new FerryApp();
        app.createWindow();
        app.updateSeatTable();
    }
}


