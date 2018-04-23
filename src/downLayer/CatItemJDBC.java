package downLayer;

import dao.interfaces.CatItemDAO;
import java.sql.SQLException;
import java.util.ArrayList;

import dao.modal.CatItem;

public class CatItemJDBC extends DatabaseWorker implements CatItemDAO{
	
	public void write(CatItem ci) throws ClassNotFoundException, SQLException {
		connectToDB();
		String sql = "INSERT INTO CAT_ITEM VALUES(?,?)";
		preparedStatement = connection.prepareStatement(sql);
		preparedStatement.setInt(1, ci.getCat_id());
		preparedStatement.setInt(2, ci.getItem_id());
		preparedStatement.executeUpdate();
		closeConnection();
	}
	
	public CatItem[] read() throws ClassNotFoundException, SQLException {
		connectToDB();
		String sql = "SELECT * FROM CAT_ITEM";
		preparedStatement = connection.prepareStatement(sql);
		resultSet = preparedStatement.executeQuery();
		
		ArrayList<CatItem> list = new ArrayList<>();
		while(resultSet.next()) {
			CatItem obj = new CatItem(resultSet.getInt(1), resultSet.getInt(2));
			list.add(obj);
		}
		
		CatItem[] ciArray = new CatItem[list.size()];
		list.toArray(ciArray);
		closeConnection();
		return ciArray;
	}
	
}
