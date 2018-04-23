package downLayer;

import java.sql.SQLException;

import dao.modal.Attributes;
import dao.modal.CatItem;
import dao.modal.Category;
import dao.modal.Company;
import dao.modal.Item;
import dao.modal.ItemCompany;
import dao.modal.Log;
import dao.modal.OutOfStock;
import dao.modal.Sells;
import dao.modal.Stock;

public class DataWriter extends DatabaseWorker {
	
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
	
	public void write(Company com) throws ClassNotFoundException, SQLException {
		connectToDB();
		String sql = "INSERT INTO COMPANY VALUES(?,?)";
		preparedStatement = connection.prepareStatement(sql); 
		preparedStatement.setInt(1, com.getId());
		preparedStatement.setString(2,com.getName());
		preparedStatement.executeUpdate();
		closeConnection();
	}
	
	public void write(Attributes attr) throws ClassNotFoundException, SQLException {
		connectToDB();
		String sql = "INSERT INTO ATTRIBUTES VALUES(?,?,?)";
		preparedStatement = connection.prepareStatement(sql);
		preparedStatement.setInt(1, attr.getItem_id());
		preparedStatement.setInt(2,attr.getValue());
		preparedStatement.setString(3,attr.getName());
		preparedStatement.executeUpdate();
		closeConnection();
	}
	
	public void write(Stock st) throws ClassNotFoundException, SQLException {
		connectToDB();
		String sql = "INSERT INTO STOCK VALUES(?,?)";
		preparedStatement = connection.prepareStatement(sql);
		preparedStatement.setDate(1, st.getLastRestocked());
		preparedStatement.setDate(2, st.getNextRestock());
		preparedStatement.executeUpdate();
		closeConnection();
	}
	
	public void write(OutOfStock oos) throws ClassNotFoundException, SQLException {
		connectToDB();
		String sql = "INSERT INTO OUTOFSTOCK VALUES(?,?)";
		preparedStatement = connection.prepareStatement(sql);
		preparedStatement.setInt(1, oos.getItem_id());
		preparedStatement.setDate(2, oos.getSince_date());
		preparedStatement.executeUpdate();
		closeConnection();
	}
	
	public void write(Log log) throws ClassNotFoundException, SQLException {
		connectToDB();
		String sql = "INSERT INTO LOG VALUES(?,?)";
		preparedStatement = connection.prepareStatement(sql);
		preparedStatement.setString(1, log.getUsername());
		preparedStatement.setString(2, log.getPassword());
		preparedStatement.executeUpdate();
		closeConnection();
	}
	
	public void write(Sells sells) throws ClassNotFoundException, SQLException {
		connectToDB();
		String sql = "INSERT INTO ITEM VALUES(?,?,?,?,?,?,?,?)";
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
	
	public void write(CatItem ci) throws ClassNotFoundException, SQLException {
		connectToDB();
		String sql = "INSERT INTO CAT_ITEM VALUES(?,?)";
		preparedStatement = connection.prepareStatement(sql);
		preparedStatement.setInt(1, ci.getCat_id());
		preparedStatement.setInt(2, ci.getItem_id());
		preparedStatement.executeUpdate();
		closeConnection();
	}
	
	public void write(ItemCompany ic) throws ClassNotFoundException, SQLException {
		connectToDB();
		String sql = "INSERT INTO ITEM_COMPANY VALUES(?,?)";
		preparedStatement = connection.prepareStatement(sql);
		preparedStatement.setInt(1, ic.getItem_id());
		preparedStatement.setInt(2, ic.getCompany_id());
		preparedStatement.executeUpdate();
		closeConnection();
	}
}
