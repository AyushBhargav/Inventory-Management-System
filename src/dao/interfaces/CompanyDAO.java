package dao.interfaces;

import java.sql.SQLException;

import dao.modal.Company;

public interface CompanyDAO {
	public void write(Company com) throws ClassNotFoundException, SQLException;
	public Company[] read() throws ClassNotFoundException, SQLException;
}
