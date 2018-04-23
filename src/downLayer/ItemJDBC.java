package downLayer;

import java.sql.SQLException;
import java.util.ArrayList;

import dao.interfaces.ItemDAO;
import dao.modal.Item;

public class ItemJDBC extends DatabaseWorker implements ItemDAO{

	public void write(Item item) throws ClassNotFoundException, SQLException {
		connectToDB();
		String sql = "INSERT INTO ITEM VALUES(?,?,?,?,?)";
		preparedStatement = connection.prepareStatement(sql);
		preparedStatement.setInt(1, item.getId());
		preparedStatement.setString(2,item.getName());
		preparedStatement.setDouble(3,item.getPrice());
		preparedStatement.setInt(4,item.getFrequency());
		preparedStatement.setInt(5,item.getStock());
		preparedStatement.executeUpdate();
		closeConnection();
	}
	
	public Item[] read() throws ClassNotFoundException, SQLException {
		connectToDB();
		String sql = "SELECT * FROM ITEM";
		preparedStatement = connection.prepareStatement(sql);
		resultSet = preparedStatement.executeQuery();
		
		ArrayList<Item> list = new ArrayList<>();
		while(resultSet.next()) {
			Item obj = new Item(resultSet.getInt(1), resultSet.getString(2), resultSet.getDouble(3),resultSet.getInt(4),resultSet.getInt(5));
			list.add(obj);
		}
		
		Item[] itemArray = new Item[list.size()];
		list.toArray(itemArray);
		closeConnection();
		return itemArray;
	}
	
	public void update(int id, Item i) throws SQLException, ClassNotFoundException {
		connectToDB();
		String sql = "UPDATE ITEM SET ITEM_NAME = ?,ITEM_PRICE = ?,ITEM_SELLS = ? , ITEM_STOCK = ? WHERE ITEM_ID = ?";
		preparedStatement = connection.prepareStatement(sql);
		preparedStatement.setString(1, i.getName());
		preparedStatement.setDouble(2, i.getPrice());
		preparedStatement.setInt(3, i.getFrequency());
                preparedStatement.setInt(4,i.getStock());
		preparedStatement.setInt(5, id);
		preparedStatement.executeUpdate();
		closeConnection();
	}
        
        public String getName(int id) throws ClassNotFoundException, SQLException {
            connectToDB();
            String sql = "SELECT ITEM_NAME FROM ITEM WHERE ITEM_ID = ?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1,id);
            resultSet = preparedStatement.executeQuery();
            resultSet.next();
            String name = resultSet.getString(1);
            return name;
        }
	
        public int getMaxId() throws ClassNotFoundException, SQLException {
            connectToDB();
            String sql = "SELECT MAX(ITEM_ID) FROM ITEM";
            preparedStatement = connection.prepareStatement(sql);
            resultSet = preparedStatement.executeQuery();
            resultSet.next();
            int id = resultSet.getInt(1);
            return id;
        }
}
