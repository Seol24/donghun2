package donghuns2.view;

import java.awt.Component;
import java.awt.EventQueue;
import java.awt.GridLayout;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import donghun2.dao.DaoProduct;
import donghun2.dto.Product;
import donghun2.panel.ProductPanel;
import erp_myframework.TextFiledPanel;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ProductView extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JButton btnSave;
	private JButton btnDele;
	private JButton btnSearch;
	protected DaoProduct dao;
	private ProductPanel pProduct;
	
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
		if(isValidcheck()){
			JOptionPane.showMessageDialog(null, "공백이 존재");
			return;
		}
		Product item = getObject();
		dao.insertItem(item);
		JOptionPane.showMessageDialog(null, "추가됨");
		clear();
	}
	private Product getObject() {
		String code = pProduct.pCode.getTfValue();
		String name = pProduct.pName.getTfValue();
		int saleprice = Integer.parseInt(pProduct.pSalePrice.getTfValue());
		int origiprice = Integer.parseInt(pProduct.pOrigiPrice.getTfValue());
		return new Product(code, name, saleprice, origiprice);
	}

	protected void actionPerformedBtnDele(ActionEvent e) {
		
	}
	protected void actionPerformedBtnSearch(ActionEvent e) {
		
	}
	
	private boolean isValidcheck() {
		return isEmpty();
	}

	public void clear(){
		pProduct.pCode.setTfValue("");
		pProduct.pName.setTfValue("");
		pProduct.pSalePrice.setTfValue("");
		pProduct.pOrigiPrice.setTfValue("");
		
	}
	public boolean isEmpty(){
		for(Component c : getComponents()){
			if(c instanceof TextFiledPanel){
				TextFiledPanel tfp = (TextFiledPanel) c;
				if(tfp.isEmpty()){
					return true;
				}

			};
		}
		return false;
	}
}
