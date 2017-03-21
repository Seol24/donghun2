package donghun2.view;

import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import donghun2.dao.DaoCustomer;
import donghun2.dao.DaoEmployee;
import donghun2.dao.DaoProduct;
import donghun2.dao.DaoSellInfo;
import donghun2.dto.Customer;
import donghun2.dto.Employee;
import donghun2.dto.Product;
import donghun2.dto.SellInfo;
import donghun2.panel.CustomerPanel;
import donghun2.panel.EmployeePanel;
import donghun2.panel.ProductPanel;
import donghun2.panel.SellInfoPanel;
import erp_myframework.TextFiledPanel;

public class SellInfoView extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JButton btnSave;
	private SellInfoPanel pSellInfo;
	private JButton btnOK;
	private JPanel pE;
	private EmployeePanel pEmployee;
	private JButton btnOK1;
	private JPanel pP;
	private ProductPanel pProduct;
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

		pEmployee = EmployeePanel.getInstance();
		pE.add(pEmployee);
		pEmployee.setLayout(new GridLayout(1, 0, 0, 0));

		btnOK1 = new JButton("확인");
		btnOK1.addActionListener(this);
		pE.add(btnOK1);
		
		pP = new JPanel();
		contentPane.add(pP);
		pP.setLayout(new BoxLayout(pP, BoxLayout.X_AXIS));
		
		pProduct = ProductPanel.getInstance();
		pP.add(pProduct);
		pProduct.setLayout(new GridLayout(1, 0, 0, 0));
		
		btnOK2 = new JButton("확인");
		btnOK2.addActionListener(this);
		pP.add(btnOK2);

		pProduct.clear();
		
		pC = new JPanel();
		contentPane.add(pC);
		pC.setLayout(new BoxLayout(pC, BoxLayout.X_AXIS));
		
		pCustomer = CustomerPanel.getInstance();
		pC.add(pCustomer);
		pCustomer.setLayout(new GridLayout(1, 0, 0, 0));
		
		btnOK3 = new JButton("확인");
		btnOK3.addActionListener(this);
		pC.add(btnOK3);
		
		
		pSellInfo = SellInfoPanel.getInstance();
		btnOK = pSellInfo.getBtnOk();
		btnOK.addActionListener(this);
		contentPane.add(pSellInfo);

		pSellInfo.clear();
		
		
		JPanel pBtn = new JPanel();
		contentPane.add(pBtn);
		btnSave = new JButton("저장");
		btnSave.addActionListener(this);
		pBtn.add(btnSave);
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnOK) {
			actionPerformedBtnOK(e);
		}
		if (e.getSource() == btnOK3) {
			actionPerformedBtnOK3(e);
		}
		if (e.getSource() == btnOK2) {
			actionPerformedBtnOK2(e);
		}
		if (e.getSource() == btnOK1) {
			actionPerformedBtnOK1(e);
		}
		
		if (e.getSource() == btnSave) {
			actionPerformedBtnSave(e);
		}
	}
	

	private void actionPerformedBtnSave(ActionEvent e) {
		 Employee eitem = pEmployee.getObject();
		 Product pitem = pProduct.getObject();
		 Customer citem = pCustomer.getObject();
		if (eitem==null || pitem==null || citem==null) {
			JOptionPane.showMessageDialog(null, "공백 존재");
		}else{
			JOptionPane.showMessageDialog(null, "저장되었습니다.");
		}
		
	}
	
	private void actionPerformedBtnOK(ActionEvent e) {
		Employee eRes = pEmployee.getObject();
		Product pRes = pProduct.getObject();
		Customer cRes = pCustomer.getObject();
		SellInfo sRes = pSellInfo.getObject();
		if(eRes == null || pRes == null || cRes ==null || sRes==null){
			JOptionPane.showMessageDialog(null, "검색결과가 없습니다.");
			
		}else{
			int salePrice = pRes.getSalePrice(); 	//판매정가
			String egrade = eRes.getGrade(); //사원등급
			String cgrade = cRes.getGrade(); //거래처등급
			int dispercentage=0;
			if(egrade.equals("A")){
				dispercentage += Employee.getA();
			}else if(egrade.equals("B")){
				dispercentage += Employee.getB();
			}else if(egrade.equals("C")){
				dispercentage += Employee.getC();
			}
			if(cgrade.equals("L")){
				dispercentage += Customer.getL();
			}else if(cgrade.equals("M")){
				dispercentage += Customer.getM();
			}else if(cgrade.equals("S")){
				dispercentage += Customer.getS();
			}
			
			int unitPrice = (int) (salePrice*(1-(dispercentage*0.01)));
			int sellPrice = unitPrice*(pSellInfo.getObject().getQuantity());
			int disPrice = salePrice*(pSellInfo.getObject().getQuantity())-sellPrice;
					
			SellInfo sellinfo = new SellInfo(unitPrice, sellPrice, disPrice);
			pSellInfo.setObject(sellinfo);
			System.out.println(sellinfo);
			JOptionPane.showMessageDialog(null, "검색하였습니다.");
		}	
	}

	private void actionPerformedBtnOK1(ActionEvent e) {
		Employee res = DaoEmployee.getInstance().selectItemByNo(pEmployee.getObject());
		if (res == null ) {
			JOptionPane.showMessageDialog(null, "검색결과가 없습니다");
		} else {
			JOptionPane.showMessageDialog(null, "검색하였습니다.");
			pEmployee.setObject(res);
			
		}
	}
	private void actionPerformedBtnOK2(ActionEvent e) {
		Product res = DaoProduct.getInstance().selectItemByNoForSellInfo(pProduct.getObject());
		if(res == null){
			JOptionPane.showMessageDialog(null, "검색결과가 없습니다.");
			pProduct.clear();
		}else{
			JOptionPane.showMessageDialog(null, "검색하였습니다.");
			
			pProduct.setObject(res);
			
		}
	}
	private void actionPerformedBtnOK3(ActionEvent e) {
		Customer res = DaoCustomer.getInstance().selectItemByNo(pCustomer.getObject());
		if(res == null){
			JOptionPane.showMessageDialog(null, "검색결과가 없습니다.");
		}else{
			JOptionPane.showMessageDialog(null, "검색하였습니다.");
			pCustomer.setObject(res);
		}
	}
}
