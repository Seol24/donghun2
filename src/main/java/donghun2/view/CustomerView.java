package donghun2.view;

import java.awt.EventQueue;
import java.awt.GridLayout;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import donghun2.panel.CustomerPanel;

public class CustomerView extends JFrame {

	private JPanel contentPane;
	private CustomerPanel pCustomer;
	private JPanel pbtn;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CustomerView frame = new CustomerView();
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
	public CustomerView() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 277);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BoxLayout(contentPane, BoxLayout.Y_AXIS));
		
		pCustomer = new CustomerPanel();
		contentPane.add(pCustomer);
		
		pbtn = new JPanel();
		contentPane.add(pbtn);
		pbtn.setLayout(new GridLayout(0, 3, 0, 0));
		
		JButton btnSave = new JButton("저장");
		pbtn.add(btnSave);
		
		JButton btnDele = new JButton("삭제");
		pbtn.add(btnDele);
		
		JButton btnSearch = new JButton("검색");
		pbtn.add(btnSearch);
	}

}
