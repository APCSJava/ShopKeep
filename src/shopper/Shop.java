package shopper;

import java.util.List;

public class Shop {

	private List<Customer> mainQueue;
	private List<Customer> overflow;
	private List<Customer> quickCheck;
	
	/** Initialize the tills
	 * 
	 */
	public Shop() {
		//TODO initialize the mainQueue with an empty list
	}
	
	/** Add a customer to the main queue.  If five or more
	 * customers are in line, "open" (initialize) the overflow queue
	 * and add them there, instead.
	 * 
	 * @param c the customer to be added
	 */
	public void addCustomer(Customer c) {
		//TODO implement
	}
	
	/** If this is the main queue, simply remove the first customer and
	 * return its reference leaving the queue open and potentially
	 * empty.  If this is either the overflow or quick check queue and no
	 * customers remain, additionally "close" the queue (set to null)
	 * 
	 * @param till
	 * @return the customer processed
	 */
	public Customer processNextCustomer(List<Customer> till) {
		//TODO implement
		return null;
	}
	
	/** Traverse the main till and the overflow till, in that
	 * order.  Remove any customers with fewer than ten items from
	 * their current queue and add them to the quick checkout.  If
	 * quick check is closed, you may need to initialize it, first.
	 * 
	 * Postcondition: the relative order of customers with 10 or 
	 * more items remains unchanged.  Customers with fewer than
	 * ten items may appear in any order in the quick checkout.
	 */
	public void openQuickCheck(){
		//TODO implement
	}
	
	public List<Customer> getMainQueue() {
		return mainQueue;
	}
	
	public List<Customer> getOverflow(){
		return overflow;
	}
	
	public List<Customer> getQuickCheck() {
		return quickCheck;
	}

}
