package shopper;

import java.util.ArrayList;
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
		mainQueue = new ArrayList<Customer>();
	}
	
	/** Add a customer to the main queue.  If five or more
	 * customers are in line, "open" (initialize) the overflow queue
	 * and add them there, instead.
	 * 
	 * @param c the customer to be added
	 */
	public void addCustomer(Customer c) {
		//TODO implement
		if (mainQueue.size()<5) mainQueue.add(c);
		else {
			if (overflow==null) overflow = new ArrayList<Customer>();
			overflow.add(c);
		}
	}
	
	/** Remove and return the first customer.  
	 * 
	 * If this is the main queue, leave the queue open, even if no 
	 * customers remain.  However, if the action is on the overflow or 
	 * quick check queue and the operation leaves no customers 
	 * remaining in thta queue, additionally "close the queue" by
	 * setting the queue to null.
	 * 
	 * @param till the affected queue 
	 * @return the customer processed
	 */
	public Customer processNextCustomer(List<Customer> till) {
		//TODO implement
		Customer c = till.remove(0);
		if (till.size()<=0) {
			if (till.equals(overflow)) overflow = null;
			else if (till.equals(quickCheck)) quickCheck = null;
		}
		return c;
		
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
		if (this.quickCheck==null) { quickCheck=new ArrayList<Customer>();}
		for (int i = 0; i<mainQueue.size(); i++) {
			Customer c = mainQueue.get(i);
			if (c!=null && c.getNumItems()<10) {
				mainQueue.remove(i);
				i--;
				quickCheck.add(c);
			}
		}
		for (int i = overflow.size()-1; i>=0; i--) {
			Customer c = overflow.get(i);
			if (c!=null && c.getNumItems()<10) {
				overflow.remove(i);
				quickCheck.add(c);
			}
		}
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
