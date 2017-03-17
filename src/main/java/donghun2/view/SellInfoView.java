package donghun2.view;

import java.awt.EventQueue;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import donghun2.SellPanel.CustomerSellPanel3;
import donghun2.SellPanel.EmployeeSellPanel;
import donghun2.SellPanel.ProductSellPanel;
import donghun2.dao.DaoCustomer;
import donghun2.dao.DaoEmployee;
import donghun2.dao.DaoProduct;
import donghun2.dto.Customer;
import donghun2.dto.Employee;
import donghun2.dto.Product;
import donghun2.panel.SellInfoPanel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import donghun2.panel.EmployeePanel;
import java.awt.GridLayout;
import donghun2.panel.ProductPanel;
import donghun2.panel.CustomerPanel;

public class SellInfoView extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JButton btnSave;
	private SellInfoPanel pSellInfo;
	private JPanel pE;
	private EmployeePanel pEmployee;
	private JButton btnOK;
	private CustomerPanel panel;
	private JPanel pP;
	private ProductSellPanel pProduct;
	private JButton btnOK2;
	private JPanel pC;
	private CustomerPanel pCustomer;
	private JButton btnOK3;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SellInfoView frame = new SellInfoView();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public SellInfoView() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 747, 728);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BoxLayout(contentPane, BoxLayout.Y_AXIS));

		pE = new JPanel();
		contentPane.add(pE);
		pE.setLayout(new BoxLayout(pE, BoxLayout.X_AXIS));

		pEmployee = new EmployeePanel();
		pE.add(pEmployee);
		pEmployee.setLayout(new GridLayout(1, 0, 0, 0));

		btnOK = new JButton("확인");
		btnOK.addActionListener(this);
		pE.add(btnOK);
		
		pP = new JPanel();
		contentPane.add(pP);
		pP.setLayout(new BoxLayout(pP, BoxLayout.X_AXIS));
		
		pProduct = new ProductSellPanel();
		pP.add(pProduct);
		
		btnOK2 = new JButton("확인");
		btnOK2.addActionListener(this);
		pP.add(btnOK2);
		
		pC = new JPanel();
		contentPane.add(pC);
		pC.setLayout(new BoxLayout(pC, BoxLayout.X_AXIS));
		
		pCustomer = new CustomerPanel();
		pC.add(pCustomer);
		pCustomer.setLayout(new GridLayout(1, 0, 0, 0));
		
		btnOK3 = new JButton("확인");
		btnOK3.addActionListener(this);
		pC.add(btnOK3);

		pSellInfo = new SellInfoPanel();
		contentPane.add(pSellInfo);

		JPanel pBtn = new JPanel();
		contentPane.add(pBtn);

		btnSave = new JButton("저장");
		btnSave.addActionListener(this);
		pBtn.add(btnSave);
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnOK3) {
			actionPerformedBtnOK3(e);
		}
		if (e.getSource() == btnOK2) {
			actionPerformedBtnOK2(e);
		}
		if (e.getSource() == btnOK) {
			actionPerformedBtnOK(e);
		}
		if (e.getSource() == pSellInfo.getButton()) {
			actionPerformedBtnConfirmE(e);
		}

		if (e.getSource() == btnSave) {
			actionPerformedBtnSave(e);
		}
	}

	protected void actionPerformedBtnConfirmS(ActionEvent e) {

	}

	protected void actionPerformedBtnConfirmC(ActionEvent e) {

	}

	protected void actionPerformedBtnConfirmP(ActionEvent e) {
		/*
		 * if(pProduct.pCode.getTfValue().isEmpty()){
		 * JOptionPane.showMessageDialog(null, "공백이 존재"); return; } Product code
		 * = new Product(pProduct.pCode.getTfValue()); Product item =
		 * DaoProduct.getInstance().selectItemByNo(code); if(item==null){
		 * JOptionPane.showMessageDialog(null, "데이터 없음"); return; }
		 * pProduct.setObject(item);
		 */
	}

	protected void actionPerformedBtnConfirmE(ActionEvent e) {

	}

	protected void actionPerformedBtnSave(ActionEvent e) {

	}

	protected void actionPerformedBtnOK(ActionEvent e) {
		Employee res = DaoEmployee.getInstance().selectItemByNo(pEmployee.getObject());
		if (res == null) {
			JOptionPane.showMessageDialog(null, "검색결과가 없습니다");
		} else {
			JOptionPane.showMessageDialog(null, "검색하였습니다.");
			pEmployee.setObject(res);
		}
	}
	protected void actionPerformedBtnOK2(ActionEvent e) {
		Product res = DaoProduct.getInstance().selectItemByNoForSellInfo(pProduct.getObject());
		if(res == null){
			JOptionPane.showMessageDialog(null, "검색결과가 없습니다.");
			pProduct.clear();
		}else{
			JOptionPane.showMessageDialog(null, "검색하였습니다.");
			
			pProduct.setObject(res);
			
		}
	}
	protected void actionPerformedBtnOK3(ActionEvent e) {
		Customer res = DaoCustomer.getInstance().selectItemByNo(pCustomer.getObject());
		if(res == null){
			JOptionPane.showMessageDialog(null, "검색결과가 없습니다.");
		}else{
			JOptionPane.showMessageDialog(null, "검색하였습니다.");
			pCustomer.setObject(res);
		}
	}
}
