package donghuns2.view;

import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import donghun2.dao.DaoEmployee;
import donghun2.panel.EmployeePanel;

@SuppressWarnings("serial")
public class EmployeeView extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JButton btnSearch;
	private EmployeePanel pEmployee;
	private JPanel pBtn;
	private JButton btnSave;
	private JButton btnDele;

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

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnDele) {
			actionPerformedBtnDele(e);
		}
		if (e.getSource() == btnSave) {
			actionPerformedBtnSave(e);
		}
		if (e.getSource() == btnSearch) {
			actionPerformedBtnSearch(e);
		}
	}
	protected void actionPerformedBtnSearch(ActionEvent e) {
		DaoEmployee.getInstance().selectItemByNo(pEmployee.getObject());
	}
	protected void actionPerformedBtnSave(ActionEvent e) {
		DaoEmployee.getInstance().insertItem(pEmployee.getObject());
		
	}
	protected void actionPerformedBtnDele(ActionEvent e) {
		
		int res=DaoEmployee.getInstance().deleteItem(pEmployee.getObject());
		
		if(res==0){
			JOptionPane.showMessageDialog(null, "삭제실패");
		}else{
			DaoEmployee.getInstance().deleteItem(pEmployee.getObject());
			JOptionPane.showMessageDialog(null, "삭제성공");
		}
	
	}
}
