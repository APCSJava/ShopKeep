# ShopKeep
Skeleton code and testing class for a shop that implements List&lt;> operations.

A Shop has potentially three checkout lines (implemented as Lists) for their Customers:
* the main queue,
* an overflow queue opened when the main queue grows too long
* a quick check queue which, when opened, will process customers with fewer than 10 items.

The
