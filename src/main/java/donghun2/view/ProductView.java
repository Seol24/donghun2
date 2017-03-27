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

		pProduct = ProductPanel.getInstance();
		contentPane.add(pProduct);

		JPanel pBtn = new JPanel();
		contentPane.add(pBtn);
		pBtn.setLayout(new GridLayout(0, 3, 0, 0));

		btnSave = new JButton("���옣");
		btnSave.addActionListener(this);
		pBtn.add(btnSave);

		btnDele = new JButton("�궘�젣");
		btnDele.addActionListener(this);
		pBtn.add(btnDele);

		btnSearch = new JButton("寃��깋");
		btnSearch.addActionListener(this);
		pBtn.add(btnSearch);
		
		pTable = new ProductTable();
		contentPane.add(this);
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
			JOptionPane.showMessageDialog(null, "怨듬갚�씠 議댁옱");
			return;
		}
		if(Integer.parseInt(pProduct.getpSalePrice().getTfValue())<Integer.parseInt(pProduct.getpOrigiPrice().getTfValue())){
			JOptionPane.showMessageDialog(null, "�젙媛�蹂대떎 �썝媛�媛� �겢 �닔 �뾾�쓬");
			return;
		}
		String msg = "異붽��맖";
		Product item = pProduct.getObject();
		if(DaoProduct.getInstance().selectItemByNo(item)!=null){
			msg = "�뜲�씠�꽣媛� �씠誘� 議댁옱�븯誘�濡� �뜮�뼱��";
		}
		DaoProduct.getInstance().replaceItem(item);
		JOptionPane.showMessageDialog(null, msg);
		pProduct.clear();
		pTable.loadData();
	}
	protected void actionPerformedBtnDele(ActionEvent e) {
		if(pProduct.getpCode().isEmpty()){
			JOptionPane.showMessageDialog(null, "怨듬갚�씠 議댁옱");
			return;
		}
		Product item = pProduct.getObject();
		if(DaoProduct.getInstance().deleteItem(item)==0){
			JOptionPane.showMessageDialog(null, "�궘�젣�븷 �뜲�씠�꽣 �뾾�쓬");
		}else{
			JOptionPane.showMessageDialog(null, "�궘�젣 �릺�뿀�뒿�땲�떎");
		}
		pProduct.clear();
		pTable.loadData();
	}
	protected void actionPerformedBtnSearch(ActionEvent e) {
		Product res = DaoProduct.getInstance().selectItemByNo(pProduct.getObject());
		if(res == null){
			JOptionPane.showMessageDialog(null, "寃��깋寃곌낵媛� �뾾�뒿�땲�떎.");
		}else{
			JOptionPane.showMessageDialog(null, "寃��깋�븯���뒿�땲�떎.");
			pProduct.setObject(res);
		}
	}
}
