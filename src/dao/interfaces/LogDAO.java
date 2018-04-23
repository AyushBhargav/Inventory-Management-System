package dao.interfaces;

import java.sql.SQLException;

import dao.modal.Log;

public interface LogDAO {
	public void write(Log log) throws ClassNotFoundException, SQLException;
	public Log[] read() throws ClassNotFoundException, SQLException;
        public void update(String username, Log log) throws SQLException, ClassNotFoundException;
}
