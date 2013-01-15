Consume transactions CSV. 
Present user with header and first 10 rows of data.

Choose attributes from within the file for grouping. For example trader, security, market sector, strategy.

Metrics are to be provided from a catalog of plugins. 
* count distinct attributes
* sum numeric field
* formula

Metrics can have dependencies.
```sql
sum(cost) as totalCost
sum(sale) as totalSales
(totalSales - totalCost) as margin
(margin/totalCost) as grossMarginPercentage
```

