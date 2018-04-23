package dao.interfaces;

import java.sql.SQLException;

import dao.modal.Stock;

public interface StockDAO {
	public void write(Stock st) throws ClassNotFoundException, SQLException;
	public Stock[] read() throws ClassNotFoundException, SQLException;
}
