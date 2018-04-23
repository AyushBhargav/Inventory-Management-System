package dao.modal;

public class Attributes {
	private int item_id;
	private int value;
	private String name;
	public Attributes(int cat_id, int value, String name) {
		this.setItem_id(cat_id);
		this.setValue(value);
		this.setName(name);
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getValue() {
		return value;
	}
	public void setValue(int value) {
		this.value = value;
	}
	public int getItem_id() {
		return item_id;
	}
	public void setItem_id(int item_id) {
		this.item_id = item_id;
	}
}
