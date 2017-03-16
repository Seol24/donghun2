package donghun2.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import donghun2.dto.Employee;

public interface Dao<T> {
	int insertItem(T item);
	Vector<T> selectItemByAll();
	T getObject(ResultSet rs) throws SQLException;
	T selectItemByNo(T item);	//이거 맞춰야됌
	int updateItem(T item);
	int deleteItem(T item);
}
