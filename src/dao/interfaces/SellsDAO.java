package dao.interfaces;

import java.sql.SQLException;

import dao.modal.Sells;

public interface SellsDAO {
	public void write(Sells sells) throws ClassNotFoundException, SQLException;
	public Sells[] read() throws ClassNotFoundException, SQLException;
        public int getMaxId() throws ClassNotFoundException, SQLException;
}
