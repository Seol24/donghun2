package donghun2.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import donghuns.dto.Employee;


public class DaoEmployee implements Dao<Employee> {

	@Override
	public int insertItem(Employee item) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Vector<Employee> selectItemByAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Employee getObject(ResultSet rs) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Employee selectItemByNo(String code) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int updateItem(Employee item) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteItem(String code) {
		// TODO Auto-generated method stub
		return 0;
	}
	
}
