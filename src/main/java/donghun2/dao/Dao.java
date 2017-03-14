package donghun2.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import donghun2.dto.Customer;

public interface Dao<T> {
	int replaceItem(T item);
	Vector<T> selectItemByAll();
	T getObject(ResultSet rs) throws SQLException;
	T selectItemByNo(String code);
	int updateItem(T item);
	
	int deleteItem(T item);
}
