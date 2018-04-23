package dao.modal;

import java.sql.Date;

public class Stock {
	private Date lastRestocked;
	private Date nextRestock;
	public Stock(Date lR, Date nR) {
		setLastRestocked(lR);
		setNextRestock(nR);
	}
	public Date getLastRestocked() {
		return lastRestocked;
	}
	public void setLastRestocked(Date lastRestocked) {
		this.lastRestocked = lastRestocked;
	}
	public Date getNextRestock() {
		return nextRestock;
	}
	public void setNextRestock(Date nextRestock) {
		this.nextRestock = nextRestock;
	}
}
