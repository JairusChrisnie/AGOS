import javax.swing.*;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;

import java.awt.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class FerrySchedule {

	public static void main(String[] args) {
		JFrame frame = new JFrame(); 
		frame.setTitle("Pasig River Ferry Service Scheduling");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(753, 532);
		frame.getContentPane().setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 74, 739, 351);
		frame.getContentPane().add(scrollPane);
		String[] columnHeader = {"Trip ID", "Body No.", "Route", "Location", "ETA", "Seats Available", "Status"};
		DefaultTableModel tableModel = new DefaultTableModel(columnHeader, 0) {
		public boolean isCellEditable(int row, int column) {
			return true;
		}
	};
		JTable table = new JTable(tableModel);
		scrollPane.setViewportView(table);
		
		JButton btnNewButton = new JButton("+ Row");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Object[] emptyRow = new Object[columnHeader.length];
				tableModel.addRow(emptyRow);
			}
		});
		btnNewButton.setBounds(644, 435, 85, 21);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Save");
		btnNewButton_1.setBounds(644, 43, 85, 21);
		btnNewButton_1.setFocusable(false);
		frame.getContentPane().add(btnNewButton_1);
		
		String[] statusOptions = {"On Time", "Delayed", "Cancelled"};
		JComboBox statusOptCB = new JComboBox(statusOptions);
		table.getColumnModel().getColumn(6).setCellEditor(new DefaultCellEditor(statusOptCB));
		
		JLabel lblNewLabel = new JLabel("Downstream - Pinagbutan to Escolta");
		lblNewLabel.setFont(new Font("Lucida Sans", Font.PLAIN, 20));
		lblNewLabel.setBounds(10, 426, 363, 30);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblUpstreamEscolta = new JLabel("Upstream - Escolta to Kalawaan");
		lblUpstreamEscolta.setFont(new Font("Lucida Sans", Font.PLAIN, 20));
		lblUpstreamEscolta.setBounds(10, 456, 334, 29);
		frame.getContentPane().add(lblUpstreamEscolta);
		
		JButton btnNewButton_2 = new JButton("Delete");
		btnNewButton_2.setBounds(540, 435, 85, 21);
		frame.getContentPane().add(btnNewButton_2);
		table.getColumnModel().getColumn(5).setPreferredWidth(84);
		
		btnNewButton_2.addActionListener(new ActionListener() {
			 public void actionPerformed(ActionEvent e) {
			        int selectedRow = table.getSelectedRow();
			        if (selectedRow != -1) { 
			            tableModel.removeRow(selectedRow); 
			            table.repaint();
			        }
			 }
		});
		
		tableModel.addTableModelListener(new TableModelListener() {
			public void tableChanged(TableModelEvent update) {
				if(update.getType() == TableModelEvent.UPDATE) {
					int filledCol = update.getColumn();
					int filledRow = update.getFirstRow();
					
					if(filledCol == 0) {
						String tripID = (String) tableModel.getValueAt(filledRow, 0);
						if(tripID != null && tripID.toUpperCase().startsWith("U")) {
							tableModel.setValueAt("Upstream", filledRow, 2);
						} else {
							tableModel.setValueAt("Downstream", filledRow, 2);
						}
					}
				}
			}
		});
		
		String[] upstreamLoc = {"Quinta", "Lawton", "Escolta"};
		String[] downstreamLoc = {"Sta. Ana", "Lambingan", "Valenzuela", "Hulo", "Guadalupe", "San Joaquin", "Kalawaan"};
		JComboBox locCB = new JComboBox();
		table.getColumnModel().getColumn(3).setCellEditor(new DefaultCellEditor(locCB));
		tableModel.addTableModelListener(new TableModelListener() {
			public void tableChanged(TableModelEvent update) {
				if(update.getType() == TableModelEvent.UPDATE) {
					int row = update.getFirstRow(); 
					String route =(String) tableModel.getValueAt(row,2); 
					locCB.removeAllItems();
					if("Upstream".equals(route)) {
						for(int i = 0; i <upstreamLoc.length; i++) {
							String loc = upstreamLoc[i];
							locCB.addItem(loc);
						}
					} else if("Downstream".equals(route)) {
						for(int i = 0; i <downstreamLoc.length; i++) {
							String loc = downstreamLoc[i];
							locCB.addItem(loc);
						}
					}
				}
			}
		});
		JComboBox etaCB = new JComboBox();
		for (int i = 1; i<=60; i++) {
			etaCB.addItem(i);
		}
		table.getColumnModel().getColumn(4).setCellEditor(new DefaultCellEditor(etaCB));
		
		JComboBox availSeatCB = new JComboBox();
		for (int i = 1; i<=55; i++) {
			availSeatCB.addItem(i);
		}
		table.getColumnModel().getColumn(5).setCellEditor(new DefaultCellEditor(availSeatCB));
		
		frame.setVisible(true);
		
	}
}
