
/**
 * This is the item class has item attributes like productName, quantity , unitprice 
 * 
 * @author hanuman.verma
 *
 */
class Item {
	private String productName;
	private int quantity;
	private double unitPrice;
	
	Item(String productName, int quantity, double unitPrice) {
		this.productName = productName;
		this.quantity = quantity;
		this.unitPrice = unitPrice;
	}
	public String toString() {
		String s = this.productName + ":";
		s = s + this.quantity + "\n";
		return s;
	}
	public String getProductName() {
		return this.productName;
	}
	public int getQuantity() {
		return this.quantity;
	}
	public double getUnitPrice() {
		return this.unitPrice;
	}
}