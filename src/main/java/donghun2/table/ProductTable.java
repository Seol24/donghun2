package donghun2.table;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.util.Vector;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import donghun2.dao.DaoProduct;
import donghun2.dto.Product;

public class ProductTable extends JPanel {
	private JTable table;
	private static DaoProduct dao;

	
	public ProductTable() {
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
		return new String[]{"제품코드","제품명","판매정가","판매원가"};
	}
	
	protected String[][] getRowDate() {
		Vector<Product> vProduct = dao.getInstance().selectItemByAll();
		String[][] datas = new String[vProduct.size()][];
		for(int i = 0; i < datas.length; i++){
			datas[i] = vProduct.get(i).toArray();
		}
		return datas;
	}
	

}
