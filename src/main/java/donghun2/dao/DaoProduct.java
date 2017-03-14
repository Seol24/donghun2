package donghun2.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import donghun2.dto.Customer;
import donghun2.dto.Product;


public class DaoProduct implements Dao<Product> {

	@Override
	public int replaceItem(Product item) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Vector<Product> selectItemByAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Product getObject(ResultSet rs) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Product selectItemByNo(String code) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int updateItem(Product item) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteItem(Product item) {
		// TODO Auto-generated method stub
		return 0;
	}

	
}
