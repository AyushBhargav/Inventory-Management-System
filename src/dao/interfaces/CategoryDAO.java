package dao.interfaces;

import java.sql.SQLException;

import dao.modal.Category;

public interface CategoryDAO {
	public void write(Category cat) throws ClassNotFoundException, SQLException;
	public Category[] read() throws ClassNotFoundException, SQLException;
        public int getMaxCatId() throws ClassNotFoundException, SQLException;
        public void update(int id, Category cat) throws SQLException, ClassNotFoundException;
}
