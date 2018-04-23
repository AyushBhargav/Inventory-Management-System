package dao.modal;

public class Category {
	private int stock;
	private String name;
	private int frequency;
	private int id;
	public Category(int id,String name, int frequency, int stock) {
		this.setId(id);
		this.setName(name);
		this.setFrequency(frequency);
		this.setStock(stock);
	}
	public int getStock() {
		return stock;
	}
	public void setStock(int stock) {
		this.stock = stock;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getFrequency() {
		return frequency;
	}
	public void setFrequency(int frequency) {
		this.frequency = frequency;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
}
