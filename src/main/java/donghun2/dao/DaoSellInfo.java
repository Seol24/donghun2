package donghun2.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Date;
import java.util.Vector;

import donghun2.dto.Customer;
import donghun2.dto.Employee;
import donghun2.dto.Product;
import donghun2.dto.SellInfo;
import donghun2.dto.SellInfo;
import donghun2.jdbc.DBCon;

public class DaoSellInfo implements Dao<SellInfo> {
	private static final DaoSellInfo instance = new DaoSellInfo();
	
	public static DaoSellInfo getInstance() {
		return instance;
	}
	
	private DaoSellInfo() {}

	
	@Override
	public int replaceItem(SellInfo item) {
		String sql ="replace into sellinfo(saleDate,quantity,unitprice,sellprice,disprice) values(?,?,?,?,?)";
		DBCon dbCon = new DBCon();
		Connection connection = dbCon.getConnection();
		PreparedStatement pstmt = null;
		int res = -1;
		try {
			pstmt = connection.prepareStatement(sql);
			pstmt.setString(1, String.format("%Tf", item.getSaleDate()));
			pstmt.setInt(2, item.getQuantity());
			pstmt.setInt(3, item.getUnitprice());
			pstmt.setInt(4, item.getSellprice());
			pstmt.setInt(5, item.getDisprice());
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
	public Vector<SellInfo> selectItemByAll() {
		String sql = "select * from sellinfo";
		DBCon dbCon = new DBCon();
		Connection connection = dbCon.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Vector<SellInfo> list = new Vector<>();
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
	public SellInfo getObject(ResultSet rs) throws SQLException {
		Date saleDate = rs.getDate("saleDate");
		int quantity = rs.getInt("quantity");
		int unitprice = rs.getInt("unitprice");
		int sellprice = rs.getInt("sellprice");
		int disprice = rs.getInt("disprice");
		return new SellInfo(saleDate, quantity, unitprice, sellprice, disprice);
	}
	
	@Override
	public SellInfo selectItemByNo(SellInfo item) {
		// TODO Auto-generated method stub
		return null;
	}


	public SellInfo selectItemByNo(Employee item1, Product item2, Customer item3) {
		String sql = "select * from v_totalinfo where ecode=? and pcode=? and ccode=?";
		DBCon dbCon = new DBCon();
		Connection connection = dbCon.getConnection();
		PreparedStatement pstmt = null;
		SellInfo SellInfo = null;
		ResultSet rs = null;
		try {
			pstmt = connection.prepareStatement(sql);
			pstmt.setString(1, item1.getCode());
			pstmt.setString(2, item2.getCode());
			pstmt.setString(3, item3.getCode());
			System.out.println(pstmt);
			rs = pstmt.executeQuery();
			if(rs.next()){
				SellInfo = getObject(rs);
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
		
		
		return SellInfo;
	}

	@Override
	public int deleteItem(SellInfo item) {
		// TODO Auto-generated method stub
		return 0;
	}


	
	

}