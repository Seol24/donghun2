package donghuns.view;

import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import donghuns.panel.EmployeePanel;

public class EmployeeView extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JButton btnSearch;
	private EmployeePanel pEmployee;
	private JPanel pBtn;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EmployeeView frame = new EmployeeView();
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
	public EmployeeView() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BoxLayout(contentPane, BoxLayout.Y_AXIS));
		
		pEmployee = new EmployeePanel();
		pEmployee.setToolTipText("");
		contentPane.add(pEmployee);
		
		pBtn = new JPanel();
		pEmployee.add(pBtn);
		pBtn.setLayout(new GridLayout(0, 3, 0, 0));
		
		JButton btnSave = new JButton("저장");
		pBtn.add(btnSave);
		
		JButton btnDele = new JButton("삭제");
		pBtn.add(btnDele);
		
		btnSearch = new JButton("검색");
		btnSearch.addActionListener(this);
		pBtn.add(btnSearch);
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnSearch) {
			actionPerformedBtnNewButton_2(e);
		}
	}
	protected void actionPerformedBtnNewButton_2(ActionEvent e) {
		
	}
}
