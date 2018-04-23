package downLayer;



import java.sql.*;


public class DatabaseWorker {
	protected static String username = "root";
	protected static String password = "root";
	
	
	static final String dbURL = "jdbc:mysql://localhost/inventory";
	static final String jdbcDriver = "com.mysql.jdbc.Driver";
	
	protected Connection connection = null;
	protected Statement statement = null;
	protected PreparedStatement preparedStatement = null;
	protected ResultSet resultSet = null;
	
	public void connectToDB() throws ClassNotFoundException, SQLException {
		Class.forName(jdbcDriver);
		connection = DriverManager.getConnection(dbURL + "?user="+username+"&password="+password);
		statement = connection.createStatement();
	}
	
	public void closeConnection() throws SQLException {
		if(connection != null)
			connection.close();
		if(statement != null)
			statement.close();
		if(preparedStatement != null)
			preparedStatement.close();
		if(resultSet != null)
			resultSet.close();
	}
	
}
