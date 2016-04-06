package shopper;

public class Customer {
	private String name;
	private int numItems;
	
	/** Initialize a customer
	 * 
	 * @param s customer name
	 * @param n number of items for checkout
	 */
	public Customer(String s, int n) {
		name = s;
		numItems = n;
	}
	
	/** Override the default string
	 * 
	 */
	public String toString() {
		String s = "";
		s+=name+" is checking out with "+numItems+" items";
		return s;
	}
	
	public String getName(){return name;}
	public int getNumItems() {return numItems;}
}
