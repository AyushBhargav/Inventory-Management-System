package dao.modal;

public class CatItem {
	private int cat_id;
	private int item_id;
	public CatItem(int cid, int iid) {
		this.setCat_id(cid);
		this.setItem_id(iid);
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
}
