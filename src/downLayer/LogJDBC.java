package downLayer;

import java.sql.SQLException;
import java.util.ArrayList;

import dao.interfaces.LogDAO;
import dao.modal.Log;

public class LogJDBC extends DatabaseWorker implements LogDAO{

	public void write(Log log) throws ClassNotFoundException, SQLException {
		connectToDB();
		String sql = "INSERT INTO LOG VALUES(?,?)";
		preparedStatement = connection.prepareStatement(sql);
		preparedStatement.setString(1, log.getUsername());
		preparedStatement.setString(2, log.getPassword());
		preparedStatement.executeUpdate();
		closeConnection();
	}
	
	public Log[] read() throws ClassNotFoundException, SQLException {
		connectToDB();
		String sql = "SELECT * FROM LOG";
		preparedStatement = connection.prepareStatement(sql);
		resultSet = preparedStatement.executeQuery();
		
		ArrayList<Log> list = new ArrayList<>();
		while(resultSet.next()) {
			Log obj = new Log(resultSet.getString(1), resultSet.getString(2));
			list.add(obj);
		}
		
		Log[] logArray = new Log[list.size()];
		list.toArray(logArray);
		closeConnection();
		return logArray;
	}
	
	public void update(String username, Log log) throws SQLException, ClassNotFoundException {
		connectToDB();
		String sql = "UPDATE LOG SET PASSWORD = ? , USERNAME = ?";
		preparedStatement = connection.prepareStatement(sql);
		preparedStatement.setString(1, log.getPassword());
		preparedStatement.setString(2, log.getUsername());
		preparedStatement.executeUpdate();
		closeConnection();
	}
}
