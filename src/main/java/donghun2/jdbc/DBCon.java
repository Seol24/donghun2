package donghun2.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
<<<<<<< HEAD
import java.util.Properties;


public class DBCon {
	private Connection connection;
	private LoadProperties loadProp;
	private Properties properties;
	
	public DBCon() {
		loadProp = new LoadProperties("resources/conf.properties");
		properties = loadProp.getProperties();
		try {
			connection = DriverManager.getConnection(
					properties.getProperty("url"),
					properties.getProperty("user"),
					properties.getProperty("password"));
		} catch (SQLException e) {
			System.err.printf("Mysql Driver가 없거나 URL, User, Password 확인");
			e.printStackTrace();
		}
	}
	
	public Connection getConnection() {
		return connection;
	}
	
	public void close(){
		if(connection != null){
			try {
				connection.close();
				connection = null;
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	
	}
	
=======

public class DBCon {
	private String dbName = "donghun2";
	private String url = "jdbc:mysql://localhost:3306/" + dbName;
	private String user = "user_donghun2";
	private String password = "rootroot";
	private Connection connection;

	public DBCon() {
		try {
			connection = DriverManager.getConnection(url, user, password);
		} catch (SQLException e) {
			System.out.println("연결 실패 - 사용자 정보 및 드라이버를 찾을 수 없음");
			e.printStackTrace();
		}
	}

	public Connection getConnection() {
		return connection;
	}

	public void Close() {
		if (connection != null) {
			try {
				connection.close();
				connection = null;
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
>>>>>>> refs/remotes/origin/master
}
