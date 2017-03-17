package donghun2.view;

import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import donghun2.dao.DaoCustomer;
import donghun2.dao.DaoProduct;
import donghun2.dto.Customer;
import donghun2.dto.Product;
import donghun2.panel.ProductPanel;
import donghun2.table.CustomerTable;
import donghun2.table.ProductTable;
import java.awt.event.ActionListener;

public class ProductView extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JButton btnSave;
	private JButton btnDele;
	private JButton btnSearch;
	protected DaoProduct dao;
	private ProductPanel pProduct;
	private ProductTable pTable;

	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ProductView frame = new ProductView();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public ProductView() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 322);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BoxLayout(contentPane, BoxLayout.Y_AXIS));

		pProduct = new ProductPanel();
		contentPane.add(pProduct);

		JPanel pBtn = new JPanel();
		contentPane.add(pBtn);
		pBtn.setLayout(new GridLayout(0, 3, 0, 0));

		btnSave = new JButton("저장");
		btnSave.addActionListener(this);
		pBtn.add(btnSave);

		btnDele = new JButton("삭제");
		btnDele.addActionListener(this);
		pBtn.add(btnDele);

		btnSearch = new JButton("검색");
		btnSearch.addActionListener(this);
		pBtn.add(btnSearch);
		
		pTable = new ProductTable();
		contentPane.add(pTable);
		pTable.setVisible(true);
		
		
		pProduct.clear();
	}

	public void setDao(DaoProduct dao) {
		this.dao = dao;
	}
	

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnSearch) {
			actionPerformedBtnSearch(e);
		}
		if (e.getSource() == btnDele) {
			actionPerformedBtnDele(e);
		}
		if (e.getSource() == btnSave) {
			actionPerformedBtnSave(e);
		}
	}
	
	protected void actionPerformedBtnSave(ActionEvent e) {
		if(pProduct.isEmpty()){
			JOptionPane.showMessageDialog(null, "공백이 존재");
			return;
		}
		if(Integer.parseInt(pProduct.pSalePrice.getTfValue())<Integer.parseInt(pProduct.pOrigiPrice.getTfValue())){
			JOptionPane.showMessageDialog(null, "정가보다 원가가 클 수 없음");
			return;
		}
		String msg = "추가됨";
		Product item = pProduct.getObject();
		if(DaoProduct.getInstance().selectItemByNo(item)!=null){
			msg = "데이터가 이미 존재하므로 덮어씀";
		}
		DaoProduct.getInstance().replaceItem(item);
		JOptionPane.showMessageDialog(null, msg);
		pProduct.clear();
		pTable.loadData();
	}
	protected void actionPerformedBtnDele(ActionEvent e) {
		if(pProduct.pCode.isEmpty()){
			JOptionPane.showMessageDialog(null, "공백이 존재");
			return;
		}
		Product item = pProduct.getObject();
		if(DaoProduct.getInstance().deleteItem(item)==0){
			JOptionPane.showMessageDialog(null, "삭제할 데이터 없음");
		}else{
			JOptionPane.showMessageDialog(null, "삭제 되었습니다");
		}
		pProduct.clear();
		pTable.loadData();
	}
	protected void actionPerformedBtnSearch(ActionEvent e) {
		Product res = DaoProduct.getInstance().selectItemByNo(pProduct.getObject());
		if(res == null){
			JOptionPane.showMessageDialog(null, "검색결과가 없습니다.");
		}else{
			JOptionPane.showMessageDialog(null, "검색하였습니다.");
			pProduct.setObject(res);
		}
	}
}
