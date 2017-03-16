package donghun2.view;

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

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

	/*public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnSearch) {
			actionPerformedBtnSearch(e);
		}
		if (e.getSource() == btnDele) {
			actionPerformedBtnDele(e);
		}
		if (e.getSource() == btnSave) {
			actionPerformedBtnSave(e);
		}
	}*/
	/*protected void actionPerformedBtnSave(ActionEvent e) {
		if(isValidcheck()){
			JOptionPane.showMessageDialog(null, "빈칸이 있습니다.");
			return;
		}
		Product item = dao.getObject();
		dao.getInstance().replaceItem(item);
		JOptionPane.showMessageDialog(null, "저장되었습니다.");
		clear();
	}
	

	protected void actionPerformedBtnDele(ActionEvent e) {
		if(isValidcheck()){
			JOptionPane.showMessageDialog(null, "코드 입력하세요.");
			return;
			int res = dao.getInstance().deleteItem(pProduct.get)
		}
		Product item = getObject();
		dao.getInstance().deleteItem(item);
		JOptionPane.showMessageDialog(null, "저장되었습니다.");
		clear();
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
	}*/
}
