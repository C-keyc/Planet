package seu.list.widget;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.EventObject;

import javax.swing.AbstractCellEditor;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.event.CellEditorListener;
import javax.swing.table.TableCellEditor;
import javax.swing.table.TableCellRenderer;

public class ButtonColumn extends AbstractCellEditor implements
		TableCellEditor, TableCellRenderer, ActionListener {

	private JButton btnRender;
	private JButton btnEditor;
	private String text = "Yes";

	public ButtonColumn() {

		this.btnEditor = new JButton(text);
		this.btnRender = new JButton(text);
		this.btnEditor.addActionListener(this);
	}

	@Override
	public void addCellEditorListener(CellEditorListener cl) {
		super.addCellEditorListener(cl);

	}

	@Override
	public void cancelCellEditing() {
		super.cancelCellEditing();
	}

	@Override
	public Object getCellEditorValue() {
		
		return text;
	}

	@Override
	public boolean isCellEditable(EventObject arg0) {

		return true;
	}

	@Override
	public void removeCellEditorListener(CellEditorListener arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean shouldSelectCell(EventObject arg0) {

		return true;
	}

	@Override
	public boolean stopCellEditing() {
		System.out.println("stopCellEditing");
		super.stopCellEditing();
		return true;
	}

	@Override
	public Component getTableCellRendererComponent(JTable table, Object value,
			boolean isSelected, boolean hasFocus, int rowIndex, int colIndex) {
		System.out.println("Rendering--" + text);
		btnRender.setText(text);
		return btnRender;
	}

	@Override
	public Component getTableCellEditorComponent(JTable table, Object value,
			boolean isSelected, int row, int column) {
		System.out.println("Editing--" + text);
		text = (text.equals("Yes")?"No":"Yes");
		btnEditor.setText(text);
		return btnEditor;
	}

	@Override
	public void actionPerformed(ActionEvent evt) {
		System.out.println(evt.getSource());
		//Make the renderer reappear.
        fireEditingStopped();
	}

}
