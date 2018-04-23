package downLayer;

import java.sql.SQLException;
import java.util.ArrayList;

import dao.interfaces.CompanyDAO;
import dao.modal.Company;

public class CompanyJDBC extends DatabaseWorker implements CompanyDAO{
	
	public void write(Company com) throws ClassNotFoundException, SQLException {
		connectToDB();
		String sql = "INSERT INTO COMPANY VALUES(?,?)";
		preparedStatement = connection.prepareStatement(sql); 
		preparedStatement.setInt(1, com.getId());
		preparedStatement.setString(2,com.getName());
		preparedStatement.executeUpdate();
		closeConnection();
	}
	
	public Company[] read() throws SQLException, ClassNotFoundException {
		connectToDB();
		String sql = "SELECT * FROM COMPANY";
		preparedStatement = connection.prepareStatement(sql);
		resultSet = preparedStatement.executeQuery();
		
		ArrayList<Company> list = new ArrayList<>();
		while(resultSet.next()) {
			Company obj = new Company(resultSet.getInt(1), resultSet.getString(2));
			list.add(obj);
		}
		
		Company[] cArray = new Company[list.size()];
		list.toArray(cArray);
		closeConnection();
		return cArray;
	}
	
	public void update(int id, Company com) throws SQLException, ClassNotFoundException {
		connectToDB();
		String sql = "UPDATE COMPANY SET COMPANY_NAME = ?,WHERE CAT_ID = ?";
		preparedStatement = connection.prepareStatement(sql);
		preparedStatement.setString(1, com.getName());
		preparedStatement.setInt(2, id);
		preparedStatement.executeUpdate();
		closeConnection();
	}
}
