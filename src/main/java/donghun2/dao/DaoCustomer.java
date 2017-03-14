package donghun2.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import donghun2.dto.Customer;
import donghuns2.jdbc.DBCon;


public class DaoCustomer implements Dao<Customer> {
	private static final DaoCustomer instance = new DaoCustomer();
	
	public static DaoCustomer getInstance() {
		return instance;
	}
	
	

	private DaoCustomer() {}



	@Override
	public int replaceItem(Customer item) {
		String sql ="replace into Customer(code, name, grade) values(?,?,?)";
		DBCon dbCon = new DBCon();
		Connection connection = dbCon.getConnection();
		PreparedStatement pstmt = null;
		int res = -1;
		try {
			pstmt = connection.prepareStatement(sql);
			pstmt.setString(1, item.getCode());
			pstmt.setString(2, item.getName());
			pstmt.setString(3, item.getGrade());
			res = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			try {
				pstmt.close();
				connection.close();
				dbCon.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		
		return 0;
	}

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
	public Customer selectItemByNo(String code) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int updateItem(Customer item) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteItem(Customer item) {
		String sql = "delete from Customer where code = ?";
		DBCon dbCon = new DBCon();
		Connection connection = dbCon.getConnection();
		PreparedStatement pstmt = null;
		int res = -1;
		try {
			pstmt = connection.prepareStatement(sql);
			pstmt.setString(1, item.getCode());
			res = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			try {
				pstmt.close();
				connection.close();
				dbCon.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return res;
	}



	
}
