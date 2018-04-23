package dao.interfaces;

import java.sql.SQLException;

import dao.modal.Attributes;

public interface AttributeDAO {
	public void write(Attributes attr) throws ClassNotFoundException, SQLException;
	public Attributes[] read() throws ClassNotFoundException, SQLException;
        public int getMaxAttrValue(int item_id) throws ClassNotFoundException, SQLException;
}
