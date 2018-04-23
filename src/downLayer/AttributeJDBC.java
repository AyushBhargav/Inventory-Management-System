package downLayer;

import java.sql.SQLException;
import java.util.ArrayList;

import dao.interfaces.AttributeDAO;
import dao.modal.Attributes;

public class AttributeJDBC extends DatabaseWorker implements AttributeDAO{
	
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
	
	public Attributes[] read() throws ClassNotFoundException, SQLException {
		connectToDB();
		String sql = "SELECT * FROM ATTRIBUTES";
		preparedStatement = connection.prepareStatement(sql);
		resultSet = preparedStatement.executeQuery();
		
		ArrayList<Attributes> list = new ArrayList<>();
		while(resultSet.next()) {
			Attributes obj = new Attributes(resultSet.getInt(1), resultSet.getInt(2), resultSet.getString(3));
			list.add(obj);
		}
		
		Attributes[] attrArray = new Attributes[list.size()];
		list.toArray(attrArray);
		closeConnection();
		return attrArray;
	}
	
	public void update(int id, Attributes atr) throws ClassNotFoundException, SQLException {
		connectToDB();
		String sql = "UPDATE ATTRIBUTES SET ATTRIBUTE_VALUE =  ? , ATTRIBUTE_NAME = ? WHERE ITEM_ID = ?";
		preparedStatement = connection.prepareStatement(sql);
		preparedStatement.setInt(1,atr.getValue());
		preparedStatement.setString(2,atr.getName());
		preparedStatement.setInt(3, id);
		preparedStatement.executeUpdate();
		closeConnection();
	}
        
        public int getMaxAttrValue(int item_id) throws ClassNotFoundException, SQLException {
            connectToDB();
            String sql = "SELECT MAX(ATTRIBUTE_VALUE) FROM ATTRIBUTES WHERE ITEM_ID = ?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1,item_id);
            resultSet = preparedStatement.executeQuery();
            resultSet.next();
            int value = resultSet.getInt(1);
            closeConnection();
            return value;
        }
        
}
