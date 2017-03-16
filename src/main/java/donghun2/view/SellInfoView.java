package donghun2.view;

import java.awt.EventQueue;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
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

}
