# Design

## General Architecture for a Search Application

For a search application I would normally break down the system into two main modules:
1. **An ETL process where:**

* Extract the data from a source
* Transform the data into a search suitable format.
* Load the data into some sort of repository optimized for fast access and or search (eg. Search Engine or DB).  
If search capabilities are the most important feature I would choose something like Elasticsearch.

2. **A search service, which**

* Accepts a search query in some format.
* Parses/validates the specified query.
* Optionally: transforms the query into a runnable format. E.g. Elasticsearch query, SQL, etc.
* Executes the query
* Parse/transform query results into a format consumable by clients.


## Application Design

For simplicity, this application will include both modules in a single project, and we are considering a fully fledged 
search engine, database repository out of scope. Nevertheless, as stated above for performance, robustness and search 
features completeness I would include an Elasticsearch cluster with several nodes and automatic auto-scaling policies.

### Programming Principles
Functional style of programming, including, but not limited to:
- ADTs
- Immutability
- Side effects isolation
- Composition
- TDD approach with Property Based Testing where possible
- No exceptions or nulls allowed.

### Free Monads

Free monads are very elegant and powerful technique to push the side effects to the boundaries of our programs. 
Allowing the developer to implement referentially transparent functions/components while simplifying the testing of the application.


### Programming language
For this application I have chosen to use Scala 2.12 with the Cats functional library.
