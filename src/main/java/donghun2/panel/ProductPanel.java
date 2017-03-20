package donghun2.panel;

import javax.swing.JPanel;

import donghun2.dto.Customer;
import donghun2.dto.Product;

import java.awt.GridLayout;
import java.awt.Component;
import java.awt.FlowLayout;
import erp_myframework.TextFiledPanel;

public class ProductPanel extends JPanel {
	private static final ProductPanel instance = new ProductPanel();
	public static ProductPanel getInstance() {return instance;}
	
	
	
	
	private TextFiledPanel pCode;
	private TextFiledPanel pName;
	private TextFiledPanel pSalePrice;
	private TextFiledPanel pOrigiPrice;

	private ProductPanel() {
		setLayout(new GridLayout(0, 1, 0, 0));
		
		pCode = new TextFiledPanel();
		pCode.setTitle("제품코드");
		add(pCode);
		
		pName = new TextFiledPanel();
		pName.setTitle("제 품 명");
		add(pName);
		
		pSalePrice = new TextFiledPanel();
		pSalePrice.setTitle("판매정가");
		add(pSalePrice);
		
		pOrigiPrice = new TextFiledPanel();
		pOrigiPrice.setTitle("판매원가");
		add(pOrigiPrice);

	}
	
	public TextFiledPanel getpCode() {
		return pCode;
	}
	public TextFiledPanel getpName() {
		return pName;
	}
	public TextFiledPanel getpSalePrice() {
		return pSalePrice;
	}
	public TextFiledPanel getpOrigiPrice() {
		return pOrigiPrice;
	}
	public Product getObject(){
		String code = pCode.getTfValue();
		String name = pName.getTfValue();
		int salePrice = Integer.parseInt(pSalePrice.getTfValue());
		int origiPrice = Integer.parseInt(pOrigiPrice.getTfValue());
		return new Product(code, name, salePrice, origiPrice);
	}
	
	public void setObject(Product item){
		pCode.setTfValue(item.getCode());
		pName.setTfValue(item.getName());
		pSalePrice.setTfValue(String.valueOf(item.getSalePrice()));
		pOrigiPrice.setTfValue(String.valueOf(item.getOrigiPrice()));
	}

	public void clear(){
		pCode.setTfValue("");
		pName.setTfValue("");
		pSalePrice.setTfValue("0");
		pOrigiPrice.setTfValue("0");
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
