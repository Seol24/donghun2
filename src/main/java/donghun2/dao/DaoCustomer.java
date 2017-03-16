package donghun2.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import donghun2.dto.Customer;
import donghun2.jdbc.DBCon;


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
		String sql = "select code, name, grade from customer";
		DBCon dbCon = new DBCon();
		Connection connection = dbCon.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Vector<Customer> list = new Vector<>();
		try {
			pstmt = connection.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()){
				list.add(getObject(rs));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			
			try {
				pstmt.close();
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			dbCon.close();
		}
		return list;
	}

	@Override
	public Customer getObject(ResultSet rs) throws SQLException {
		String code = rs.getString("code");
		String name = rs.getString("name");
		String grade = rs.getString("grade");
		return new Customer(code, name, grade);
	}

	@Override
	public Customer selectItemByNo(Customer item) {
		String sql = "select code, name, grade from customer where code = ?";
		DBCon dbCon = new DBCon();
		Connection connection = dbCon.getConnection();
		PreparedStatement pstmt = null;
		Customer customer = null;
		ResultSet rs = null;
		try {
			pstmt = connection.prepareStatement(sql);
			pstmt.setString(1, item.getCode());
			rs = pstmt.executeQuery();
			if(rs.next()){
				customer = getObject(rs);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				pstmt.close();
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}			
			dbCon.close();
		}
		
		
		return customer;
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
