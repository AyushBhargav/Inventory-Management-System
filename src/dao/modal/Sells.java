package dao.modal;

import java.sql.Date;

public class Sells {
	private int cat_id;
	private int item_id;
	private Date sell_date;
	private int sell_time_hour;
	private int sell_time_min;
	private int sell_time_sec;
	private int sell_num;
	private int sell_id;
	public Sells(int cid, int iid, Date date, int hour, int min, int sec, int num, int sid) {
		setCat_id(cid);
		setItem_id(iid);
		setSell_date(date);
		setSell_time_hour(hour);
		setSell_time_min(min);
		setSell_time_sec(sec);
		setSell_num(num);
		setSell_id(sid);
	}
	public int getCat_id() {
		return cat_id;
	}
	public void setCat_id(int cat_id) {
		this.cat_id = cat_id;
	}
	public int getItem_id() {
		return item_id;
	}
	public void setItem_id(int item_id) {
		this.item_id = item_id;
	}
	public Date getSell_date() {
		return sell_date;
	}
	public void setSell_date(Date sell_date) {
		this.sell_date = sell_date;
	}
	public int getSell_time_hour() {
		return sell_time_hour;
	}
	public void setSell_time_hour(int sell_time_hour) {
		this.sell_time_hour = sell_time_hour;
	}
	public int getSell_time_min() {
		return sell_time_min;
	}
	public void setSell_time_min(int sell_time_min) {
		this.sell_time_min = sell_time_min;
	}
	public int getSell_time_sec() {
		return sell_time_sec;
	}
	public void setSell_time_sec(int sell_time_sec) {
		this.sell_time_sec = sell_time_sec;
	}
	public int getSell_num() {
		return sell_num;
	}
	public void setSell_num(int sell_num) {
		this.sell_num = sell_num;
	}
	public int getSell_id() {
		return sell_id;
	}
	public void setSell_id(int sell_id) {
		this.sell_id = sell_id;
	}
}
