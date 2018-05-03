# Design

## General Architecture for a Search Application

For a search application you could break down the system into two main modules:

1. **An ETL process where:**

* Extract the data from a source
* Transform the data into a search suitable format.
* Load the data into some sort of repository optimized for fast access and or search (eg. Search Engine or DB).
 
If search capabilities are the most important feature I would recommend a search engine such as Elasticsearch.

2. **A search service, which**

* Accepts a search query in some format.
* Parses/validates the specified query.
* Optionally: transforms the query into a runnable format. E.g. Elasticsearch query, SQL, etc.
* Executes the query
* Parse/transform query results into a format consumable by clients.


## Application Design

For simplicity, this application will include both modules in a single project, and we are considering a fully fledged 
search engine, database repository out of scope. 

### Programming Principles

Functional style of programming, including, but not limited to:

- ADTs
- Immutability
- Side effects isolation
- Composition
- TDD approach with Property Based Testing where possible
- No exceptions or nulls allowed.

### Free Monads

[Free monads](https://typelevel.org/cats/datatypes/freemonad.html) are very elegant and powerful technique to push the 
side effects to the boundaries of our programs. 
Allowing the developer to implement referentially transparent functions/components while simplifying testing.


### Programming language
For this sample application we are using Scala 2.12 with the [Cats](https://typelevel.org/cats/) functional library.
