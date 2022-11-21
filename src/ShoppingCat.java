import java.util.ArrayList;
import java.util.ListIterator;

/**
 * This is the cart class having cart information and utility methods .
 * @author hanuman.verma
 *
 */
class ShoppingCart {
	ArrayList<Item> item;
	double totalAmount;
	double payableAmount;
	double discount;
	double tax;
	String coupon;
	
	ShoppingCart() {
		this.item = new ArrayList<Item>();
		this.coupon = "";
		this.totalAmount = 0;
		this.payableAmount = 0;
		this.discount = 0;
		this.tax = 0;
	}
	public void addToCart(Item item) {
		this.item.add(item);
	}
	public void showCart() {
		ListIterator<Item> iterator = item.listIterator();
		while(iterator.hasNext()) {
			Item item1 = iterator.next();
			System.out.println(item1);
		}
	}
	
	/**
	 * Remove a given item from cart 
	 * @param i
	 */
	public void removeFromCart(Item i) {
		ListIterator<Item> iterator1 = item.listIterator();
		while(iterator1.hasNext()) {
			Item item2 = iterator1.next();
			if (item2.getProductName().equals(i.getProductName())) {
				this.item.remove(i);
				break;
			}
		}
	}
	
	/**
	 * Return the total amount 
	 * @return
	 */
	public double getTotalAmount() {
		ListIterator<Item> iterator2 = item.listIterator();
		this.totalAmount = 0;
		while(iterator2.hasNext()) {
			Item item3 = iterator2.next();
			this.totalAmount = this.totalAmount + (item3.getUnitPrice() * item3.getQuantity());
		}
		return this.totalAmount;
	}
	
	/**
	 * Apply a copon code
	 * @param coupon
	 */
	public void applyCoupon(String coupon) {
		this.coupon = coupon;
		if (coupon.equals("IND10")) {
			this.discount = this.getTotalAmount() * (0.1);
			this.totalAmount = this.totalAmount - this.discount;
		} else {
			this.totalAmount = this.totalAmount;
		}
	}
	
	/**
	 * total payable amount including tax
	 * @return
	 */
	public double getPayableAmount() {
		this.payableAmount = 0;
		this.tax = this.totalAmount * (0.14);
		this.payableAmount = this.totalAmount + this.tax;
		return this.payableAmount;
	}
	public void printInvoice() {
		ListIterator<Item> iterator3 = item.listIterator();
		while(iterator3.hasNext()) {
			Item item4 = iterator3.next();
			System.out.print(item4.getProductName() + "\t");
			System.out.print(item4.getQuantity() + "\t");
			System.out.print(item4.getUnitPrice() + "\t");
			System.out.println(item4.getUnitPrice() * item4.getQuantity());
		}
		System.out.println("\t\t\t" + "Total    : " + this.getTotalAmount());
		this.applyCoupon(this.coupon);
		System.out.println("\t\t\t" + "Discount : " + this.discount);
		this.getPayableAmount();
		System.out.println("\t\t\t" + "Tax      : " + this.tax);
		System.out.println("\t\t\t" + "Total    : " + this.getPayableAmount());
	}
}