package donghuns.panel;

import javax.swing.JPanel;
import java.awt.GridLayout;
import java.awt.FlowLayout;
import erp_myframework.TextFiledPanel;

public class ProductPanel extends JPanel {
	private TextFiledPanel pCode;
	private TextFiledPanel pName;
	private TextFiledPanel pSalePrice;
	private TextFiledPanel pOrigiPrice;

	/**
	 * Create the panel.
	 */
	public ProductPanel() {
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

}
