package dao.modal;

public class Item {
	private int id;
	private String name;
	private double price;
	private int frequency;
	private int stock;
	public Item(int id, String name, double price, int frequency, int stock) {
		this.setId(id);
		this.setName(name);
		this.setPrice(price);
		this.setFrequency(frequency);
		this.setStock(stock);
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public int getFrequency() {
		return frequency;
	}
	public void setFrequency(int frequency) {
		this.frequency = frequency;
	}
	public int getStock() {
		return stock;
	}
	public void setStock(int stock) {
		this.stock = stock;
	}
}
