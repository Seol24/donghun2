package donghun2.panel;

import java.awt.GridLayout;
import java.util.Vector;

import javax.swing.JPanel;

import erp_myframework.ComboPanel;
import erp_myframework.TextFiledPanel;
import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import donghun2.dto.Employee;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class EmployeePanel extends JPanel{
	private TextFiledPanel pCode;
	private TextFiledPanel pName;
	private ComboPanel<String> pGrade;

	
	public EmployeePanel() {
		setLayout(new GridLayout(0, 1, 0, 0));
		
		pCode = new TextFiledPanel();
		pCode.setTitle("사원코드");
		add(pCode);
		
		pName = new TextFiledPanel();
		pName.setTitle("사 원 명");
		add(pName);
		
		Vector<String> list = new Vector<>();
		list.add("A");
		list.add("B");
		list.add("C");
		
		pGrade = new ComboPanel();
		pGrade.setTitle("사원등급");
		pGrade.setcomboData(list);
		add(pGrade);

	}
	public Employee getObject(){
		String code = pCode.getTfValue();
		String name = pName.getTfValue();
		String grade = (String) pGrade.getSelectItem();
		return new Employee(code, name,grade);
	}
	public void setObject(Employee item){
		pCode.setTfValue(item.getCode());
		pName.setTfValue(item.getName());
		pGrade.setSelectedItem(item.getGrade());
	}
	public void Clear(){
		pCode.setTfValue("");
		pName.setTfValue("");
		pGrade.setSelectedItem("");;
	}
}





