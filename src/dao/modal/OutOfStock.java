package dao.modal;

import java.sql.Date;

public class OutOfStock {
	private int item_id;
	private Date since_date;
	public OutOfStock(int id, Date date) {
		this.setItem_id(id);
		this.setSince_date(date);
	}
	public int getItem_id() {
		return item_id;
	}
	public void setItem_id(int item_id) {
		this.item_id = item_id;
	}
	public Date getSince_date() {
		return since_date;
	}
	public void setSince_date(Date since_date) {
		this.since_date = since_date;
	}
}
