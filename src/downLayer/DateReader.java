package downLayer;

import java.sql.SQLException;
import java.util.ArrayList;

import dao.modal.Attributes;
import dao.modal.CatItem;
import dao.modal.Category;
import dao.modal.Item;
import dao.modal.ItemCompany;
import dao.modal.Log;
import dao.modal.OutOfStock;
import dao.modal.Sells;
import dao.modal.Stock;


//Don't use this class. Use DAO implementation instead.
public class DateReader extends DatabaseWorker {
	
	public Category[] readCategory() throws ClassNotFoundException, SQLException {
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
	
	public Item[] readItem() throws ClassNotFoundException, SQLException {
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
	
	public Attributes[] readAttributes() throws ClassNotFoundException, SQLException {
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
	
	public Stock[] readStock() throws ClassNotFoundException, SQLException {
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
	
	public OutOfStock[] readOutOfStock() throws ClassNotFoundException, SQLException {
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
	
	public Log[] readLog() throws ClassNotFoundException, SQLException {
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
	
	public Sells[] readSells() throws ClassNotFoundException, SQLException {
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
	
	public ItemCompany[] readItemCompany() throws ClassNotFoundException, SQLException {
		connectToDB();
		String sql = "SELECT * FROM ITEM_COMPANY";
		preparedStatement = connection.prepareStatement(sql);
		resultSet = preparedStatement.executeQuery();
		
		ArrayList<ItemCompany> list = new ArrayList<>();
		while(resultSet.next()) {
			ItemCompany obj = new ItemCompany(resultSet.getInt(1), resultSet.getInt(2));
			list.add(obj);
		}
		
		ItemCompany[] icArray = new ItemCompany[list.size()];
		list.toArray(icArray);
		closeConnection();
		return icArray;
	}
	
	public CatItem[] readCatItem() throws ClassNotFoundException, SQLException {
		connectToDB();
		String sql = "SELECT * FROM CAT_ITEM";
		preparedStatement = connection.prepareStatement(sql);
		resultSet = preparedStatement.executeQuery();
		
		ArrayList<CatItem> list = new ArrayList<>();
		while(resultSet.next()) {
			CatItem obj = new CatItem(resultSet.getInt(1), resultSet.getInt(2));
			list.add(obj);
		}
		
		CatItem[] ciArray = new CatItem[list.size()];
		list.toArray(ciArray);
		closeConnection();
		return ciArray;
	}
}
