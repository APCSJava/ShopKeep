package shopper;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.fail;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class ShopTest {
	
	Shop shop;
	List<Customer> customers;

	@Before
	public void setUp() throws Exception {
		shop = new Shop();
		// roster of shoppers to use during testing
		customers = new ArrayList<Customer>();
		customers.add(new Customer("Susan", 2));
		customers.add(new Customer("Bruno", 27));
		customers.add(new Customer("Kerry", 8));
		customers.add(new Customer("Tim", 4));
		customers.add(new Customer("Dmitri", 22));
		customers.add(new Customer("George", 5));
		customers.add(new Customer("Casandra", 3));
		customers.add(new Customer("Jody", 43));
		customers.add(new Customer("Whitford", 2));
		customers.add(new Customer("Ladasia", 17));
		customers.add(new Customer("Amy", 15));
		customers.add(new Customer("Nancy", 4));
		customers.add(new Customer("Bob", 43));
		customers.add(new Customer("Terrence", 9));
		customers.add(new Customer("Howard", 22));
		customers.add(new Customer("Kim", 6));
		customers.add(new Customer("Tai-feng", 21));
	}

	@Test
	public void testShop() {
		assertNotNull("Main queue initialized?", shop.getMainQueue());
		assertNull("Overflow queue is closed?", shop.getOverflow());
		assertNull("Quickcheck queue is closed?", shop.getQuickCheck());
		assertEquals("Main queue empty?", 0, shop.getMainQueue().size());
	}

	@Test
	public void testAddCustomer() {
		shop.addCustomer(customers.get(0));
		assertNotNull("Main queue ready?", shop.getMainQueue());
		assertEquals("First person added?", shop.getMainQueue().size(), 1);
		assertEquals("Correct customer?", customers.get(0), shop.getMainQueue().get(0));
		assertEquals("Correct name?", "Susan", shop.getMainQueue().get(0).getName());
		assertNull("Overflow queue is closed?", shop.getOverflow());
		assertNull("Quickcheck queue is closed?", shop.getQuickCheck());
		shop.addCustomer(customers.get(1));
		assertEquals("Second person added?", shop.getMainQueue().size(), 2);
		assertEquals("Correct name?", "Bruno", shop.getMainQueue().get(1).getName());
	}
	
	@Test
	public void testOpenOverflowQueue() {
		for (int i = 0; i<6; i++) {
			shop.addCustomer(customers.get(i));
		}
		assertNotNull("Overflow queue is open?", shop.getOverflow());
		assertNull("Quickcheck queue is closed?", shop.getQuickCheck());
		assertEquals("Overflow holds 1 shopper?", 1, shop.getOverflow().size());
	}
	
	@Test
	public void testCloseOverflowQueue() {
		for (int i = 0; i<6; i++) {
			shop.addCustomer(customers.get(i));
		}
		Customer c = shop.processNextCustomer(shop.getOverflow());
		assertEquals("Processed correct customer?", customers.get(5), c);
		assertNull("Close overflow when empty?", shop.getOverflow());
		assertNotNull("Leave main queue open?", shop.getMainQueue());
	}

	@Test
	public void testProcessNextCustomer() {
		for (int i = 0; i<6; i++) {
			shop.addCustomer(customers.get(i));
		}
		Customer c1 = shop.processNextCustomer(shop.getMainQueue());
		assertEquals("Removed first?", c1, customers.get(0));
		Customer c2 = shop.processNextCustomer(shop.getMainQueue());
		assertEquals("Removed second?", c2, customers.get(1));
		assertEquals("Main size correct?", 3, shop.getMainQueue().size());

	}

	@Test
	public void testOpenQuickCheck() {
		for (int i = 0; i<10; i++) {
			shop.addCustomer(customers.get(i));
		}
		assertNotNull("Main queue initialized?", shop.getMainQueue());
		assertNotNull("Overflow queue initialized?", shop.getOverflow());
		assertEquals("Customer count?", 10, shop.getMainQueue().size()+shop.getOverflow().size());
		shop.openQuickCheck();
		assertEquals("Main queue reduced by 3", 2, shop.getMainQueue().size());
		assertEquals("Overflow queue reduced 3", 2, shop.getOverflow().size());
	}

}
