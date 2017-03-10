package donghuns.panel;

import java.awt.GridLayout;
import java.util.Vector;

import javax.swing.JPanel;

import erp_myframework.ComboPanel;
import erp_myframework.TextFiledPanel;

public class CustomerPanel extends JPanel {
	private TextFiledPanel pCode;
	private TextFiledPanel pName;
	private ComboPanel pGrade;

	/**
	 * Create the panel.
	 */
	public CustomerPanel() {
		setLayout(new GridLayout(0, 1, 0, 0));
		
		pCode = new TextFiledPanel();
		pCode.setTitle("거래처코드");
		add(pCode);
		
		pName = new TextFiledPanel();
		pName.setTitle("거래처명");
		add(pName);
		
		Vector<String> list = new Vector<>();
		list.add("L");
		list.add("M");
		list.add("S");
		
		
		pGrade = new ComboPanel();
		pGrade.setTitle("거래처 등급");
		pGrade.setcomboData(list);
		
		add(pGrade);

	}

}
