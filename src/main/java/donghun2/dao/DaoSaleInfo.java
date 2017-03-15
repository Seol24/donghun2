package donghun2.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import donghun2.dto.Customer;
import donghun2.dto.SaleInfo;

public class DaoSaleInfo implements Dao<SaleInfo> {

	@Override
	public int replaceItem(SaleInfo item) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Vector<SaleInfo> selectItemByAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public SaleInfo getObject(ResultSet rs) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public SaleInfo selectItemByNo(SaleInfo code) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int deleteItem(SaleInfo item) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	
}
