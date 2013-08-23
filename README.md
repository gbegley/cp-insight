### GP-Insight - Statistical analysis of transaction profitability

Trading analysis to using cloud resources.

Target Implementations

* SQL-92 compliance for relational data interchange from local (hypersonic) to cloud. 
* AWS Redshift
* Bigquery
* HBase

#### Goals
* Plugin platform
** A configurable set of analytics
** Graphical representations of the results of configurable analytics.
** Automated selection of aggregates

#### Process flow
1. Load transactions containing sales, cost and aggregation components
2. Provide users with an intuitive analysis to help users understand business performance metrics


#### Graphical map reduce
* Choose any record attributes to use for grouping (map).
* Choose metrics to produce analysis results (init, reduce and finalize).

