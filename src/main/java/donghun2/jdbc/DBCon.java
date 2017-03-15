package donghun2.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
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
	
}
