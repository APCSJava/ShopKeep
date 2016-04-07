# ShopKeep
Skeleton code and testing class for a shop that implements List&lt;> operations.

A Shop has at least one and up to three checkout lines (implemented as Lists) to track their Customers:
* the main queue,
* an overflow queue that can be opened should the main queue grow too long
* a quick check queue which, when opened, can process only customers with fewer than 10 items.

Customers are modeled using their name and the number of items in their basket.

SHOP POLICIES --
* If five people are in the main queue, the store will open an overflow queue to accommodate additional customers.
* If the manager notices lots of customers holding just a few items (<10) she can direct an employee to open the quick checkout queue.  Qualifying customers will be diverted from both the main queue and the overflow (if open) to the newly opened quick checkout line.
* When the overflow queue or the quick check queue reaches 0 customers, it will be closed so that the employee can return to other business.  The main queue, however, will remain open for business.
