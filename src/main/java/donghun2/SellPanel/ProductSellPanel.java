package donghun2.SellPanel;

import javax.swing.JPanel;
import java.awt.GridLayout;
import erp_myframework.TextFiledPanel;
import javax.swing.JButton;
import javax.swing.BoxLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.FlowLayout;

public class ProductSellPanel extends JPanel implements ActionListener {
	private JButton btnConfirm;
	private TextFiledPanel pCode;
	private TextFiledPanel pName;
	private TextFiledPanel pGrade;

	public ProductSellPanel() {
		setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
		
		pCode = new TextFiledPanel();
		pCode.setTitle("제품코드");
		add(pCode);
		
		JPanel pBtn = new JPanel();
		add(pBtn);
		
		btnConfirm = new JButton("확인");
		btnConfirm.addActionListener(this);
		pBtn.setLayout(new BoxLayout(pBtn, BoxLayout.X_AXIS));
		pBtn.add(btnConfirm);
		
		pName = new TextFiledPanel();
		pName.setTitle("제품명");
		add(pName);
		
		pGrade = new TextFiledPanel();
		pGrade.setTitle("제품등급");
		add(pGrade);

	}
	
	

	public JButton getBtnConfirm() {
		return btnConfirm;
	}



	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnConfirm) {
			actionPerformedBtnNewButton(e);
		}
	}
	protected void actionPerformedBtnNewButton(ActionEvent e) {
	}
}
