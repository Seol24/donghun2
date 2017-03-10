package donghuns.panel;

import javax.swing.JPanel;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import erp_myframework.TextFiledPanel;
import javax.swing.JButton;
import javax.swing.SwingConstants;

public class SellInfoPanel extends JPanel {
	private TextFiledPanel pSaleDate;
	private TextFiledPanel pQuantity;
	private TextFiledPanel pUnPrice;
	private TextFiledPanel pSellPrice;
	private TextFiledPanel pDisPrice;

	/**
	 * Create the panel.
	 */
	public SellInfoPanel() {
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{450, 450, 0};
		gridBagLayout.rowHeights = new int[]{60, 60, 60, 60, 60, 0};
		gridBagLayout.columnWeights = new double[]{1.0, 1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{1.0, 1.0, 1.0, 1.0, 1.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		pSaleDate = new TextFiledPanel();
		pSaleDate.setTitle("거래일자");
		GridBagConstraints gbc_pSaleDate = new GridBagConstraints();
		gbc_pSaleDate.insets = new Insets(0, 0, 5, 5);
		gbc_pSaleDate.fill = GridBagConstraints.BOTH;
		gbc_pSaleDate.gridx = 0;
		gbc_pSaleDate.gridy = 0;
		add(pSaleDate, gbc_pSaleDate);
		
		pQuantity = new TextFiledPanel();
		pQuantity.setTitle("판매수량");
		GridBagConstraints gbc_pQuantity = new GridBagConstraints();
		gbc_pQuantity.insets = new Insets(0, 0, 5, 5);
		gbc_pQuantity.fill = GridBagConstraints.BOTH;
		gbc_pQuantity.gridx = 0;
		gbc_pQuantity.gridy = 1;
		add(pQuantity, gbc_pQuantity);
		
		JButton button = new JButton("확인");
		GridBagConstraints gbc_button = new GridBagConstraints();
		gbc_button.insets = new Insets(0, 0, 5, 0);
		gbc_button.gridx = 1;
		gbc_button.gridy = 1;
		add(button, gbc_button);
		
		pUnPrice = new TextFiledPanel();
		pUnPrice.setTitle("판매단가");
		GridBagConstraints gbc_pUnPrice = new GridBagConstraints();
		gbc_pUnPrice.insets = new Insets(0, 0, 5, 5);
		gbc_pUnPrice.fill = GridBagConstraints.BOTH;
		gbc_pUnPrice.gridx = 0;
		gbc_pUnPrice.gridy = 2;
		add(pUnPrice, gbc_pUnPrice);
		
		pSellPrice = new TextFiledPanel();
		pSellPrice.setTitle("판매금액");
		GridBagConstraints gbc_pSellPrice = new GridBagConstraints();
		gbc_pSellPrice.insets = new Insets(0, 0, 5, 5);
		gbc_pSellPrice.fill = GridBagConstraints.BOTH;
		gbc_pSellPrice.gridx = 0;
		gbc_pSellPrice.gridy = 3;
		add(pSellPrice, gbc_pSellPrice);
		
		pDisPrice = new TextFiledPanel();
		pDisPrice.setTitle("할인금액");
		GridBagConstraints gbc_pDisPrice = new GridBagConstraints();
		gbc_pDisPrice.insets = new Insets(0, 0, 0, 5);
		gbc_pDisPrice.fill = GridBagConstraints.BOTH;
		gbc_pDisPrice.gridx = 0;
		gbc_pDisPrice.gridy = 4;
		add(pDisPrice, gbc_pDisPrice);

	}

}
