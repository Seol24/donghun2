package donghun2.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import donghun2.dto.Employee;
import donghun2.jdbc.DBCon;


public class DaoEmployee implements Dao<Employee> {
	private static DaoEmployee instance = new DaoEmployee();
	
	public static DaoEmployee getInstance() {
		return instance;
	}
	
	public DaoEmployee() {}

	@Override
	public int replaceItem(Employee item) {
		String sql = "replace into employee(code,name,grade) values(?,?,?)";

		DBCon dbCon = new DBCon();
		Connection connection = dbCon.getConnection();
		PreparedStatement pstmt = null;
		try {
			pstmt = connection.prepareStatement(sql);
			pstmt.setString(1, item.getCode());
			pstmt.setString(2, item.getName());
			pstmt.setString(3, item.getGrade());
			int res = pstmt.executeUpdate();
			System.out.println("insert : " + res);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				pstmt.close();
				dbCon.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return 0;
	}

	@Override
	public Vector<Employee> selectItemByAll() {
		String sql = "select code,name,grade from employee";
		Vector<Employee> list = null;
		DBCon dbCon = new DBCon();
		Connection connection = dbCon.getConnection();

		// SQL 문장 완성
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = connection.prepareStatement(sql);
			// SQL 실행
			rs = pstmt.executeQuery();
			if (rs.next()) {// 하나 이상의 결과가 존재 할 경우
				list = new Vector<>();
				do {
					list.add(getObject(rs));
				} while (rs.next());
			} else {// 하나도 없을 경우
				list = new Vector<>();
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				rs.close();
				pstmt.close();
				dbCon.close();
			} catch (SQLException e) {
				e.printStackTrace();

			}
		}
		return list;
	}

	@Override
	public Employee getObject(ResultSet rs) throws SQLException {
		String code = rs.getString("code");
		String name = rs.getString("name");
		String grade = rs.getString("grade");

		return new Employee(code, name, grade);
	}
	
	@Override
	public Employee selectItemByNo(Employee item) {
		String sql = "select code,name,grade from employee where code = ?";
		DBCon dbCon = new DBCon();
		Connection connection = dbCon.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Employee employee = null;
		try {
			pstmt = connection.prepareStatement(sql);
			pstmt.setString(1, item.getCode());
			System.out.println(pstmt);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				employee = getObject(rs);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return employee;
	}


	@Override
	public int deleteItem(Employee item) {
		String sql = "delete from employee where code=?";
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
		} finally {
			try {
				pstmt.close();
				dbCon.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			dbCon.close();
		}
		return res;
	}

}
