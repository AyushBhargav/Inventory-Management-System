package downLayer;

import java.sql.SQLException;
import java.util.ArrayList;

import dao.interfaces.SellsDAO;
import dao.modal.Sells;

public class SellsJDBC extends DatabaseWorker implements SellsDAO{

	public void write(Sells sells) throws ClassNotFoundException, SQLException {
		connectToDB();
		String sql = "INSERT INTO SELLS VALUES(?,?,?,?,?,?,?,?)";
		preparedStatement = connection.prepareStatement(sql);
		preparedStatement.setInt(1, sells.getCat_id());
		preparedStatement.setInt(2,sells.getItem_id());
		preparedStatement.setDate(3,sells.getSell_date());
		preparedStatement.setInt(4,sells.getSell_time_hour());
		preparedStatement.setInt(5,sells.getSell_time_min());
		preparedStatement.setInt(6,sells.getSell_time_sec());
		preparedStatement.setInt(7,sells.getSell_num());
		preparedStatement.setInt(8,sells.getSell_id());
		preparedStatement.executeUpdate();
		closeConnection();
	}
	
	public Sells[] read() throws ClassNotFoundException, SQLException {
		connectToDB();
		String sql = "SELECT * FROM SELLS";
		preparedStatement = connection.prepareStatement(sql);
		resultSet = preparedStatement.executeQuery();
		
		ArrayList<Sells> list = new ArrayList<>();
		while(resultSet.next()) {
			Sells obj = new Sells(resultSet.getInt(1), resultSet.getInt(2), resultSet.getDate(3), resultSet.getInt(4), resultSet.getInt(5)
					, resultSet.getInt(6), resultSet.getInt(7), resultSet.getInt(8));
			list.add(obj);
		}
		
		Sells[] sellArray = new Sells[list.size()];
		list.toArray(sellArray);
		closeConnection();
		return sellArray;
	}
        
        public int getMaxId() throws ClassNotFoundException, SQLException{
            connectToDB();
            String sql = "SELECT MAX(SELL_ID) FROM SELLS";
            preparedStatement = connection.prepareStatement(sql);
            resultSet = preparedStatement.executeQuery();
            resultSet.next();
            return resultSet.getInt(1);
        }
}
