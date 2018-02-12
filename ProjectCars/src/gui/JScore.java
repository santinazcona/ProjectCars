package gui;

import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import java.awt.BorderLayout;

public class JScore extends JFrame{

	private JFrame frame = new JFrame();
	private JTable table;
	private DefaultTableModel mDatos;
	public JScore(){
		
		frame.setBounds(450, 200, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		table = new JTable();
		table.setRowSelectionAllowed(false);
		getContentPane().add(table, BorderLayout.CENTER);
		mDatos = new DefaultTableModel() { 
			{setColumnIdentifiers( new Object[] { "Nick", "Tiempo" } ); }
			@Override
			public void setValueAt(Object aValue, int row, int column) {
				super.setValueAt(aValue, row, column);
				
			}
		};
	}
}
