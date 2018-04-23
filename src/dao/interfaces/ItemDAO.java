package dao.interfaces;

import java.sql.SQLException;

import dao.modal.Item;

public interface ItemDAO {
	public void write(Item item) throws ClassNotFoundException, SQLException;
	public Item[] read() throws ClassNotFoundException, SQLException;
        public int getMaxId() throws ClassNotFoundException, SQLException;
        public void update(int id, Item i) throws SQLException, ClassNotFoundException;
        public String getName(int id) throws ClassNotFoundException, SQLException;
}
