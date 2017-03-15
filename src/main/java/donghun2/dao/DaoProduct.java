package donghun2.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import donghun2.dto.Product;

import donghuns2.jdbc.DBCon;




public class DaoProduct implements Dao<Product> {

	@Override

	public int replaceItem(Product item) {
		// TODO Auto-generated method stub
		return 0;
	}
	public int insertItem(Product item) {
		String sql = "replace into product(code,name,saleprice,origiprice) VALUES (?,?,?,?)";
		DBCon dbCon = new DBCon();
		Connection connection = dbCon.getConnection();
		PreparedStatement pstmt = null;
		int res = -1;
		try {
			pstmt = connection.prepareStatement(sql);
			pstmt.setString(1, item.getCode());
			pstmt.setString(2, item.getName());
			pstmt.setInt(3, item.getSalePrice());
			pstmt.setInt(4, item.getOrigiPrice());
			
			res = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				pstmt.close();
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return res;

	}

	@Override
	public Vector<Product> selectItemByAll() {
		String sql = "select code,name,saleprice,origiprice from product";
		//DataBase 연결(접속)
		DBCon dbCon = new DBCon();
		Connection connection = dbCon.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Vector<Product> list = new Vector<>();
			try {
				pstmt = connection.prepareStatement(sql);
				rs = pstmt.executeQuery();
				while(rs.next()){
					list.add(getObject(rs));
				}
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				try {
					rs.close();
					pstmt.close();
					connection.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			return list;
	}

	

	@Override
	public Product selectItemByNo(Product code) {
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
	@Override
	public Product getObject(ResultSet rs) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	
}
