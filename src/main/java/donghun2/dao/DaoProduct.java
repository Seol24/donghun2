package donghun2.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import donghun2.dto.Product;
import donghun2.jdbc.DBCon;




public class DaoProduct implements Dao<Product> {
	private static final DaoProduct instance = new DaoProduct();
	
	private DaoProduct(){}

	public static DaoProduct getInstance() {return instance;}

	@Override
<<<<<<< HEAD
	public int replaceItem(Product item) {
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
			System.out.println(pstmt);
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
=======
>>>>>>> refs/remotes/origin/master
	public Vector<Product> selectItemByAll() {
		String sql = "select code,name,saleprice,origiprice from product";
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
	public Product selectItemByNo(Product item) {
		String sql = "select code,name,saleprice,origiprice from product where code=?";
		DBCon dbCon = new DBCon();
		Connection connection = dbCon.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Product product = null;
			try {
				pstmt = connection.prepareStatement(sql);
				pstmt.setString(1, item.getCode());
				rs = pstmt.executeQuery();
				if(rs.next()){
					product = getObject(rs);
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
			return product;
	}


	@Override
	public int deleteItem(Product item) {
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

<<<<<<< HEAD
	
	@Override
	public Product getObject(ResultSet rs) throws SQLException {
		String code = rs.getString("code");
		String name = rs.getString("name");
		int salePrice = rs.getInt("salePrice");
		int origiPrice = rs.getInt("origiPrice");
		return new Product(code, name, salePrice, origiPrice);
	}

=======
	@Override
	public int replaceItem(Product item) {
		// TODO Auto-generated method stub
		return 0;
	}
>>>>>>> refs/remotes/origin/master
	
}
