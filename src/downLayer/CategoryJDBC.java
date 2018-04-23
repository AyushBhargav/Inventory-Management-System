package downLayer;

import java.sql.SQLException;
import java.util.ArrayList;

import dao.interfaces.CategoryDAO;
import dao.modal.Category;

public class CategoryJDBC extends DatabaseWorker implements CategoryDAO{
	
	
	public void write(Category cat) throws ClassNotFoundException, SQLException {
		connectToDB();
		String sql = "INSERT INTO ITEM_CATEGORY VALUES(?,?,?,?)";
		preparedStatement = connection.prepareStatement(sql); 
		preparedStatement.setInt(1, cat.getId());
		preparedStatement.setString(2, cat.getName());
		preparedStatement.setInt(3, cat.getFrequency());
		preparedStatement.setInt(4, cat.getStock());
		preparedStatement.executeUpdate();
		closeConnection();
	}
	
	public Category[] read() throws ClassNotFoundException, SQLException {
		connectToDB();
		String sql = "SELECT * FROM ITEM_CATEGORY";
		preparedStatement = connection.prepareStatement(sql);
		resultSet = preparedStatement.executeQuery();
		
		ArrayList<Category> list = new ArrayList<>();
		while(resultSet.next()) {
			Category obj = new Category(resultSet.getInt(1), resultSet.getString(2), resultSet.getInt(3),resultSet.getInt(4));
			list.add(obj);
		}
		
		Category[] catArray = new Category[list.size()];
		list.toArray(catArray);
		closeConnection();
		return catArray;
	}
	
	public void update(int id, Category cat) throws SQLException, ClassNotFoundException {
		connectToDB();
		String sql = "UPDATE ITEM_CATEGORY SET CAT_STOCK = ?,CAT_NAME = ?,CAT_FREQUENCY = ? WHERE CAT_ID = ?";
		preparedStatement = connection.prepareStatement(sql);
		preparedStatement.setInt(1, cat.getStock());
		preparedStatement.setString(2, cat.getName());
		preparedStatement.setInt(3, cat.getFrequency());
		preparedStatement.setInt(4, id);
		preparedStatement.executeUpdate();
		closeConnection();
	}
        
        public int getMaxCatId() throws ClassNotFoundException, SQLException {
            connectToDB();
            String sql = "SELECT MAX(CAT_ID) FROM ITEM_CATEGORY";
            preparedStatement = connection.prepareStatement(sql);
            resultSet = preparedStatement.executeQuery();
            resultSet.next();
            int id = resultSet.getInt(1);
            connection.close();
            return id;
        }
}
