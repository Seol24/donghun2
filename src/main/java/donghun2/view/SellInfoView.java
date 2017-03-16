package donghun2.view;

import java.awt.EventQueue;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
<<<<<<< HEAD
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import donghun2.SellPanel.CustomerSellPanel3;
import donghun2.SellPanel.EmployeeSellPanel;
import donghun2.SellPanel.ProductSellPanel;
import donghun2.dao.DaoProduct;
import donghun2.dto.Product;
import donghun2.panel.SellInfoPanel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class SellInfoView extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JButton btnSave;
	private EmployeeSellPanel pEmployee;
	private ProductSellPanel pProduct;
	private CustomerSellPanel3 pCustomer;
	private SellInfoPanel pSellInfo;
	
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
		
		pEmployee = new EmployeeSellPanel();
		contentPane.add(pEmployee);
		
		pProduct = new ProductSellPanel();
		contentPane.add(pProduct);
		
		pCustomer = new CustomerSellPanel3();
		contentPane.add(pCustomer);
		
		pSellInfo = new SellInfoPanel();
		contentPane.add(pSellInfo);
		
		JPanel pBtn = new JPanel();
		contentPane.add(pBtn);
		
		btnSave = new JButton("저장");
		btnSave.addActionListener(this);
		pBtn.add(btnSave);
	}
	
	

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == pSellInfo.getButton()) {
			actionPerformedBtnConfirmE(e);
		}
		if (e.getSource() == pEmployee.getBtnConfirm()) {
			actionPerformedBtnConfirmE(e);
		}
		if (e.getSource() == pProduct.getBtnConfirm()) {
			actionPerformedBtnConfirmP(e);
		}
		if (e.getSource() == pCustomer.getBtnConfirm()) {
			actionPerformedBtnConfirmC(e);
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
/*		if(pProduct.pCode.getTfValue().isEmpty()){
			JOptionPane.showMessageDialog(null, "공백이 존재");
			return;
		}
		Product code = new Product(pProduct.pCode.getTfValue());
		Product item = DaoProduct.getInstance().selectItemByNo(code);
		if(item==null){
			JOptionPane.showMessageDialog(null, "데이터 없음");
			return;
		}
		pProduct.setObject(item);
*/
	}
	protected void actionPerformedBtnConfirmE(ActionEvent e) {
		
	}
	protected void actionPerformedBtnSave(ActionEvent e) {
		
	}
=======
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import donghun2.SellPanel.CustomerSellPanel3;
import donghun2.SellPanel.EmployeeSellPanel;
import donghun2.SellPanel.ProductSellPanel;
import donghun2.panel.SellInfoPanel;

public class SellInfoView extends JFrame {

	private JPanel contentPane;

	
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

	/**
	 * Create the frame.
	 */
	public SellInfoView() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 747, 728);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BoxLayout(contentPane, BoxLayout.Y_AXIS));
		
		EmployeeSellPanel panel = new EmployeeSellPanel();
		contentPane.add(panel);
		
		ProductSellPanel pProduct = new ProductSellPanel();
		contentPane.add(pProduct);
		
		CustomerSellPanel3 pCustomer = new CustomerSellPanel3();
		contentPane.add(pCustomer);
		
		SellInfoPanel pSellInfo = new SellInfoPanel();
		contentPane.add(pSellInfo);
		
		JPanel pBtn = new JPanel();
		contentPane.add(pBtn);
		
		JButton btnSave = new JButton("저장");
		pBtn.add(btnSave);
	}

>>>>>>> refs/remotes/origin/master
}
