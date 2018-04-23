package dao.interfaces;

import java.sql.SQLException;

import dao.modal.ItemCompany;

public interface ItemCompanyDAO {
	public void write(ItemCompany ic) throws ClassNotFoundException, SQLException;
	public ItemCompany[] read() throws ClassNotFoundException, SQLException;
}
