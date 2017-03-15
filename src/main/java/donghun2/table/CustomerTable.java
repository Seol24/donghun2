package donghun2.table;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.util.Vector;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import donghun2.dao.DaoCustomer;
import donghun2.dto.Customer;

public class CustomerTable extends JPanel {
	private JTable table;
	private static DaoCustomer dao;

	/**
	 * Create the panel.
	 */
	public CustomerTable() {
		setLayout(new BorderLayout(0, 0));
		
		JScrollPane scrollPane = new JScrollPane();
		add(scrollPane, BorderLayout.CENTER);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		loadDate();

	}
	public void loadDate(){
		table.setModel(new DefaultTableModel(getRowDate(),getColumn()));
	}
	
	
	protected String[] getColumn() {
		return new String[]{"거래처코드","거래처명","거래처등급"};
	}
	
	protected String[][] getRowDate() {
		Vector<Customer> vCustomer = dao.getInstance().selectItemByAll();
		String[][] datas = new String[vCustomer.size()][];
		for(int i = 0; i < datas.length; i++){
			datas[i] = vCustomer.get(i).toArray();
		}
		return datas;
	}
	

}
