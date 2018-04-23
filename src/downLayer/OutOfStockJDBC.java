package downLayer;

import java.sql.SQLException;
import java.util.ArrayList;

import dao.interfaces.OutOfStockDAO;
import dao.modal.OutOfStock;

public class OutOfStockJDBC extends DatabaseWorker implements OutOfStockDAO{

	public void write(OutOfStock oos) throws ClassNotFoundException, SQLException {
		connectToDB();
		String sql = "INSERT INTO OUTOFSTOCK VALUES(?,?)";
		preparedStatement = connection.prepareStatement(sql);
		preparedStatement.setInt(1, oos.getItem_id());
		preparedStatement.setDate(2, oos.getSince_date());
		preparedStatement.executeUpdate();
		closeConnection();
	}
	
	public OutOfStock[] read() throws ClassNotFoundException, SQLException {
		connectToDB();
		String sql = "SELECT * FROM OUTOFSTOCK";
		preparedStatement = connection.prepareStatement(sql);
		resultSet = preparedStatement.executeQuery();
		
		ArrayList<OutOfStock> list = new ArrayList<>();
		while(resultSet.next()) {
			OutOfStock obj = new OutOfStock(resultSet.getInt(1), resultSet.getDate(2));
			list.add(obj);
		}
		
		OutOfStock[] outOfStockArray = new OutOfStock[list.size()];
		list.toArray(outOfStockArray);
		closeConnection();
		return outOfStockArray;
	}
	
	public void delete(int id) throws SQLException, ClassNotFoundException {
		connectToDB();
		String sql = "DELETE FROM OUTOFSTOCK WHERE ITEM_ID = ?";
		preparedStatement = connection.prepareStatement(sql);
		preparedStatement.setInt(1, id);
		preparedStatement.executeUpdate();
		closeConnection();
	}
}
