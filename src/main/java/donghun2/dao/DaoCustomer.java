package donghun2.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import donghun2.dto.Customer;


public class DaoCustomer implements Dao<Customer> {


	@Override
	public Vector<Customer> selectItemByAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Customer getObject(ResultSet rs) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	

	@Override
	public int updateItem(Customer item) {
		// TODO Auto-generated method stub
		return 0;
	}


	@Override
	public Customer selectItemByNo(Customer item) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int deleteItem(Customer item) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int replaceItem(Customer item) {
		// TODO Auto-generated method stub
		return 0;
	}
	
}
