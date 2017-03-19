package donghun2.dto;

import java.util.Date;

public class SaleInfo {
	private Employee employee;
	private Customer customer;
	private Product product;
	private Date saleDate;
	private int quantity;
	private int unitprice;
	private int sellprice;
	private int disprice;
	
	
	
	public SaleInfo(Employee employee, Customer customer, Product product, Date saleDate, int quantity, int unitprice,
			int sellprice, int disprice) {
		super();
		this.employee = employee;
		this.customer = customer;
		this.product = product;
		this.saleDate = saleDate;
		this.quantity = quantity;
		this.unitprice = unitprice;
		this.sellprice = sellprice;
		this.disprice = disprice;
	}



	public SaleInfo() {
	}
	
	
	
	
}