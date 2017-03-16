
package donghun2.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

<<<<<<< HEAD
import donghun2.dto.Customer;
=======
import donghun2.dto.Employee;
>>>>>>> refs/remotes/origin/master

public interface Dao<T> {
	int replaceItem(T item);
	Vector<T> selectItemByAll();
	T getObject(ResultSet rs) throws SQLException;
<<<<<<< HEAD
	T selectItemByNo(T item);
	
=======
	T selectItemByNo(T item);	//이거 맞춰야됌
	int updateItem(T item);
>>>>>>> refs/remotes/origin/master
	int deleteItem(T item);
}
