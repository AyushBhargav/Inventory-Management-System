package downLayer;

import java.sql.SQLException;
import java.util.ArrayList;

import dao.interfaces.StockDAO;
import dao.modal.Stock;

public class StockJDBC extends DatabaseWorker implements StockDAO{

	public void write(Stock st) throws ClassNotFoundException, SQLException {
		connectToDB();
		String sql = "INSERT INTO STOCK VALUES(?,?)";
		preparedStatement = connection.prepareStatement(sql);
		preparedStatement.setDate(1, st.getLastRestocked());
		preparedStatement.setDate(2, st.getNextRestock());
		preparedStatement.executeUpdate();
		closeConnection();
	}
	
	public Stock[] read() throws ClassNotFoundException, SQLException {
		connectToDB();
		String sql = "SELECT * FROM STOCK";
		preparedStatement = connection.prepareStatement(sql);
		resultSet = preparedStatement.executeQuery();
		
		ArrayList<Stock> list = new ArrayList<>();
		while(resultSet.next()) {
			Stock obj = new Stock(resultSet.getDate(1), resultSet.getDate(2));
			list.add(obj);
		}
		
		Stock[] stockArray = new Stock[list.size()];
		list.toArray(stockArray);
		closeConnection();
		return stockArray;
	}
	
	public void update(Stock stock) throws SQLException, ClassNotFoundException {
		connectToDB();
		String sql = "UPDATE STOCK SET LAST_RESTOCKED = ?, NEXT_RESTOCK = ?";
		preparedStatement = connection.prepareStatement(sql);
		preparedStatement.setDate(1, stock.getLastRestocked());
		preparedStatement.setDate(2, stock.getNextRestock());
		preparedStatement.executeUpdate();
		closeConnection();
	}
}
