package donghun2.view;

import java.awt.EventQueue;
import java.awt.GridLayout;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import donghun2.dao.DaoCustomer;
import donghun2.dto.Customer;
import donghun2.panel.CustomerPanel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import donghun2.table.CustomerTable;

public class CustomerView extends JFrame implements ActionListener {

	private JPanel contentPane;
	private CustomerPanel pCustomer;
	private JPanel pbtn;
	private JButton btnSave;
	private JButton btnDele;
	private CustomerTable pTable;
	private JButton btnSearch;
	
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
		
		btnSave = new JButton("저장");
		btnSave.addActionListener(this);
		pbtn.add(btnSave);
		
		btnDele = new JButton("삭제");
		btnDele.addActionListener(this);
		pbtn.add(btnDele);
		
		btnSearch = new JButton("검색");
		btnSearch.addActionListener(this);
		pbtn.add(btnSearch);
		
		pTable = new CustomerTable();
		contentPane.add(pTable);
		pTable.setVisible(true);
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
		if(pCustomer.isEmpty()){
			JOptionPane.showMessageDialog(null, "빈칸이 있습니다.");
		}else{
			DaoCustomer.getInstance().replaceItem(pCustomer.getObject());
			JOptionPane.showMessageDialog(null, "저장되었습니다.");
			pTable.loadDate();
		}
		
		
	}
	protected void actionPerformedBtnDele(ActionEvent e) {
		int res = DaoCustomer.getInstance().deleteItem(pCustomer.getObject());
		if(res==0){
			JOptionPane.showMessageDialog(null, "삭제안댐");
		}else{
			JOptionPane.showMessageDialog(null, "삭제댐");
			pTable.loadDate();
		}
	}
	protected void actionPerformedBtnSearch(ActionEvent e) {
		Customer res = DaoCustomer.getInstance().selectItemByNo(pCustomer.getObject());
		if(res == null){
			JOptionPane.showMessageDialog(null, "검색결과가 없습니다.");
		}else{
			JOptionPane.showMessageDialog(null, "검색하였습니다.");
			pCustomer.setObject(res);
		}
		
	}


}
