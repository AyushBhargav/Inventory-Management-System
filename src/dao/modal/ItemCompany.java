package dao.modal;

public class ItemCompany {
	private int item_id;
	private int company_id;
	public ItemCompany(int iid, int cid) {
		this.setItem_id(iid);
		this.setCompany_id(cid);
	}
	public int getItem_id() {
		return item_id;
	}
	public void setItem_id(int item_id) {
		this.item_id = item_id;
	}
	public int getCompany_id() {
		return company_id;
	}
	public void setCompany_id(int company_id) {
		this.company_id = company_id;
	}
}
