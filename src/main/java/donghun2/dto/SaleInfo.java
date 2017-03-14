package donghun2.dto;

import java.util.Date;

public class SaleInfo {
	private String ecode;
	private String ccode;
	private String pcode;
	private int quantity;
	private int unitprice;
	private Date saleDate;
	
	public SaleInfo() {
	}

	public SaleInfo(String ecode, String ccode, String pcode, int quantity, int unitprice, Date saleDate) {
		this.ecode = ecode;
		this.ccode = ccode;
		this.pcode = pcode;
		this.quantity = quantity;
		this.unitprice = unitprice;
		this.saleDate = saleDate;
	}

	public String getEcode() {
		return ecode;
	}

	public String getCcode() {
		return ccode;
	}

	public String getPcode() {
		return pcode;
	}

	public int getQuantity() {
		return quantity;
	}

	public int getUnitprice() {
		return unitprice;
	}

	public Date getSaleDate() {
		return saleDate;
	}

	public void setEcode(String ecode) {
		this.ecode = ecode;
	}

	public void setCcode(String ccode) {
		this.ccode = ccode;
	}

	public void setPcode(String pcode) {
		this.pcode = pcode;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public void setUnitprice(int unitprice) {
		this.unitprice = unitprice;
	}

	public void setSaleDate(Date saleDate) {
		this.saleDate = saleDate;
	}

	@Override
	public String toString() {
		return String.format("ecode=%s, ccode=%s, pcode=%s, quantity=%s, unitprice=%s, saleDate=%s",
							ecode, ccode, pcode, quantity, unitprice, saleDate);
	}
	
	
	
}

