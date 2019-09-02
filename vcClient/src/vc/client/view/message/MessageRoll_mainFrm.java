package vc.client.view.message;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.JButton;
import javax.swing.JDialog;

import java.awt.Toolkit;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import vc.list.common.Goods;
import vc.list.common.Student;
import vc.list.common.User;

import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.util.List;
import java.awt.event.ActionEvent;

public class MessageRoll_mainFrm extends JFrame {

	private JPanel contentPane;
	private JTable tblMessage;
	boolean tableEditable = false;
	private DefaultTableModel tablemodel;//表格模型
	
	//新增类的属性
	
	private User owner;
	private List<Student> stlist;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					User u = new User();
					MessageRoll_mainFrm frame = new MessageRoll_mainFrm(u);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public MessageRoll_mainFrm(User user) {
		
		this.owner=user;
		
		MessageRoll_mainMgr.add(owner.getUserID(), this);
		
		initialize();
		
		
	}
	public void initialize() {
		setTitle("\u5FEB\u4E50\u661F\u7403\u865A\u62DF\u6821\u56ED\u5B66\u7C4D\u4FE1\u606F");
		setIconImage(Toolkit.getDefaultToolkit().getImage(MessageRoll_mainFrm.class.getResource("/image/logo.jpg")));
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 600);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(240, 255, 240));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnSearch = new JButton("\u67E5\u8BE2\u5B66\u7C4D\u4FE1\u606F");
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MessageRoll_searchDlg dialog = new MessageRoll_searchDlg();
				dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
				dialog.setVisible(true);
			}
		});
		btnSearch.setFont(new Font("宋体", Font.PLAIN, 15));
		btnSearch.setBounds(625, 437, 128, 38);
		contentPane.add(btnSearch);
		
		JButton btnAdd = new JButton("\u589E\u52A0\u5B66\u7C4D\u4FE1\u606F");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				MessageRoll_addDlg dialog = new MessageRoll_addDlg();
				dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
				dialog.setVisible(true);
			}
		});
		btnAdd.setFont(new Font("宋体", Font.PLAIN, 15));
		btnAdd.setBounds(36, 437, 128, 38);
		contentPane.add(btnAdd);
		
		JButton btnDelete = new JButton("\u5220\u9664\u5B66\u7C4D\u4FE1\u606F");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int selectedRow = tblMessage.getSelectedRow();
				tablemodel.removeRow(selectedRow) ;
	    	    tablemodel.fireTableDataChanged();
			}
		});
		btnDelete.setFont(new Font("宋体", Font.PLAIN, 15));
		btnDelete.setBounds(239, 437, 128, 38);

		contentPane.add(btnDelete);
		
		JButton btnUpdate = new JButton("\u4FEE\u6539\u5B66\u7C4D\u4FE1\u606F");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(tableEditable==false) {
					tableEditable=true;
					JOptionPane.showMessageDialog(contentPane, "修改后输入回车确认", "提示", JOptionPane.INFORMATION_MESSAGE);
					btnUpdate.setText("完成修改");
					btnAdd.setEnabled(false);
					btnDelete.setEnabled(false);
					btnSearch.setEnabled(false);
				}
				else
				{
					tableEditable=false;
					btnUpdate.setText("\u4FEE\u6539\u5B66\u7C4D\u4FE1\u606F");
					btnAdd.setEnabled(true);
					btnDelete.setEnabled(true);
					btnSearch.setEnabled(true);
				}
			}
		});
		btnUpdate.setFont(new Font("宋体", Font.PLAIN, 15));
		btnUpdate.setBounds(434, 437, 128, 38);
		
		contentPane.add(btnUpdate);
		
		
		
		/*if(UserType="Student"){
		btnSearch.setVisible(false);
		btnSearch.setEnabled(false);
		btnAdd.setVisible(false);
		btnAdd.setEnabled(false);
		btnDelete.setVisible(false);
		btnDelete.setEnabled(false);
		btnUpdate.setVisible(false);
		btnUpdate.setEnabled(false);
		}//学生界面所有按钮不可见不可使用
		
		if(UserType="Teacher"){
		btnAdd.setVisible(false);
		btnAdd.setEnabled(false);
		btnDelete.setVisible(false);
		btnDelete.setEnabled(false);
		btnUpdate.setVisible(false);
		btnUpdate.setEnabled(false);
		}//教师界面仅可查询，其他按钮不可见不可用
		*/
		
		JLabel lblName = new JLabel("\u59D3\u540D\uFF1A");
		lblName.setFont(new Font("宋体", Font.PLAIN, 16));
		lblName.setBounds(36, 25, 50, 30);
		contentPane.add(lblName);
		
		JLabel lblNameXX = new JLabel("\u59D3\u540DXX");
		lblNameXX.setFont(new Font("宋体", Font.PLAIN, 16));
		lblNameXX.setBounds(81, 25, 90, 30);
		contentPane.add(lblNameXX);
		
		JLabel lblECard = new JLabel("\u4E00\u5361\u901A\u53F7\uFF1A");
		lblECard.setFont(new Font("宋体", Font.PLAIN, 16));
		lblECard.setBounds(176, 25, 80, 30);
		contentPane.add(lblECard);
		
		JLabel lblECardXX = new JLabel("\u4E00\u5361\u901A\u53F7XX");
		lblECardXX.setFont(new Font("宋体", Font.PLAIN, 16));
		lblECardXX.setBounds(256, 25, 143, 30);
		contentPane.add(lblECardXX);
		
		JLabel lblIdentity = new JLabel("\u8EAB\u4EFD\uFF1A");
		lblIdentity.setFont(new Font("宋体", Font.PLAIN, 16));
		lblIdentity.setBounds(403, 25, 50, 30);
		contentPane.add(lblIdentity);
		
		JLabel lblIdentityXX = new JLabel("\u8EAB\u4EFDXX");
		lblIdentityXX.setFont(new Font("宋体", Font.PLAIN, 16));
		lblIdentityXX.setBounds(448, 25, 90, 30);
		contentPane.add(lblIdentityXX);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(36, 88, 717, 246);
		contentPane.add(scrollPane);
		
		tblMessage = new JTable();
		tblMessage.setBackground(new Color(255, 255, 240));
		tblMessage.setRowHeight(30);
		scrollPane.setViewportView(tblMessage);
		
		tablemodel =new DefaultTableModel(
				new Object[][] {
					{null, null, null, null, null, null, null, null, null, null},
					{null, null, null, null, null, null, null, null, null, null},
					{null, null, null, null, null, null, null, null, null, null},
					{null, null, null, null, null, null, null, null, null, null},
					{null, null, null, null, null, null, null, null, null, null},
					{null, null, null, null, null, null, null, null, null, null},
					{null, null, null, null, null, null, null, null, null, null},
				},
				new String[] {
					"\u59D3\u540D", "\u4E00\u5361\u901A\u53F7", "\u5B66\u53F7", "\u9662\u7CFB", "\u4E13\u4E1A", "\u73ED\u7EA7", "\u5165\u5B66\u5E74\u4EFD", "\u5B66\u5236", "\u662F\u5426\u5728\u7C4D", "\u662F\u5426\u5728\u6821"
				}
			) 
		{
				Class[] columnTypes = new Class[] {
					Object.class, Object.class, Object.class, Object.class, Object.class, Object.class, Object.class, Object.class, Object.class, Object.class
				};
				public Class getColumnClass(int columnIndex) {
					return columnTypes[columnIndex];
				}
				public boolean isCellEditable(int row, int column) {
					if(column==1)
						return false;
					return tableEditable;
				}
			};
		tablemodel.addTableModelListener(new TableModelListener() {
			public void tableChanged(TableModelEvent e) {
				int type = e.getType();
				int row = e.getFirstRow();
				int column = e.getColumn();
				if (type == TableModelEvent.UPDATE) {
					System.out.println("此事件是由\"修改\"触发，在"+row+"行"+ column +"列");
				}
			}
		});
		/*DefaultTableModel tableModel = new DefaultTableModel(tblMessage,scrollPane);
	    JTable table = new JTable(tableModel);
	    for(int j = 0;j < table.getRowCount();j ++){ //获得删除时选择的ID在JTABLE中的行号
	    	if(Integer.parseInt(table.getValueAt(j, 0).toString()) == id){
	    	    int selIndex = j;
	    	    if( selIndex < 0 || selIndex >=table.getRowCount() ){
	    	    return ;
	    	    }//删除这一行
	    	    tableModel.removeRow(selIndex) ;//刷新
	    	    tableModel.fireTableDataChanged();
	    	    break;
	    	    }*/
		tblMessage.setModel(tablemodel);
	}
}
