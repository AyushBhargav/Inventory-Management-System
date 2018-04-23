package downLayer;

import java.sql.SQLException;
import java.util.ArrayList;

import dao.interfaces.ItemCompanyDAO;
import dao.modal.ItemCompany;

public class ItemCompanyJDBC extends DatabaseWorker implements ItemCompanyDAO{

	public void write(ItemCompany ic) throws ClassNotFoundException, SQLException {
		connectToDB();
		String sql = "INSERT INTO ITEM_COMPANY VALUES(?,?)";
		preparedStatement = connection.prepareStatement(sql);
		preparedStatement.setInt(1, ic.getItem_id());
		preparedStatement.setInt(2, ic.getCompany_id());
		preparedStatement.executeUpdate();
		closeConnection();
	}
	
	public ItemCompany[] read() throws ClassNotFoundException, SQLException {
		connectToDB();
		String sql = "SELECT * FROM ITEM_COMPANY";
		preparedStatement = connection.prepareStatement(sql);
		resultSet = preparedStatement.executeQuery();
		
		ArrayList<ItemCompany> list = new ArrayList<>();
		while(resultSet.next()) {
			ItemCompany obj = new ItemCompany(resultSet.getInt(1), resultSet.getInt(2));
			list.add(obj);
		}
		
		ItemCompany[] icArray = new ItemCompany[list.size()];
		list.toArray(icArray);
		closeConnection();
		return icArray;
	}
	
	
}
