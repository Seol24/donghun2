package donghun2.panel;

import java.awt.Component;
import java.awt.GridLayout;
import java.util.Vector;

import javax.swing.JPanel;

import donghun2.dto.Customer;
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
	public Customer getObject(){
		String code = pCode.getTfValue();
		String name = pName.getTfValue();
		String grade = (String) pGrade.getSelectItem();
		return new Customer(code, name, grade);
	}
	
	public void setObject(Customer item){
		pCode.setTfValue(item.getCode());
		pName.setTfValue(item.getName());
		pGrade.setSelectedItem(item.getGrade());
	}
	
	public void clear(){
		pCode.setTfValue("");
		pName.setTfValue("");
		pGrade.setSelectedItem("");
	}
	public boolean isEmpty(){
		boolean result = false;
		for(Component c : getComponents()){
			if(c instanceof TextFiledPanel){
				TextFiledPanel tfp =(TextFiledPanel)c;
				if(tfp.isEmpty()){
					return true;
				}
			}
		}
		return false;
	}

}
