package seu.list.widget;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellEditor;
import javax.swing.table.TableColumn;
import javax.swing.table.TableModel;

public class MyTable extends JTable {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		JFrame jf = new JFrame();
		MyTable mt = new MyTable();
		JScrollPane jsp = new JScrollPane(mt);
		jf.add(jsp);
		
		//
		DefaultTableModel dtm = new DefaultTableModel();
		dtm.addColumn("First");
		dtm.addColumn("Second");
		dtm.addColumn("Third");
		for(int i = 0; i < 9; i++)
			dtm.addRow(new String[] {"1","2"});
		mt.setModel(dtm);
		
		ButtonColumn btnColumn = new ButtonColumn();
		//
		TableColumn column = mt.getColumn("Third");
		column.setCellEditor(btnColumn);
		column.setCellRenderer(btnColumn);
		//
		jf.pack();
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jf.setVisible(true);

	}

}
