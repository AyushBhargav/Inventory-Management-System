package dao.interfaces;

import java.sql.SQLException;

import dao.modal.CatItem;

public interface CatItemDAO {
	public void write(CatItem ci) throws ClassNotFoundException, SQLException;
	public CatItem[] read() throws ClassNotFoundException, SQLException;
}
