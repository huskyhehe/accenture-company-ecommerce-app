# Tasks
## Task 1: Implementing a search API
### Background
Accenture is a Global Fortune 500 company that provides consulting and processing services across many different domains. Software Engineers at Accenture may work on a vast range of programming languages and frameworks. Recently, a company has brought on Accenture to help with the development of its e-commerce website written in Java using the Spring Boot framework. The first task they need help with is searching for products.

One of the UX designers at Accenture has already implemented the new search capability in the UI. It’s your responsibility to implement the search capability in our backend Java app. The new class will need to meet the following requirements:

- Expose an HTTP GET request on the path /api/products/search
- The request should take a single parameter named “query” which will be the text that was entered in the search bar
- The request will return a Collection of ProductItem which are the matching products for the search.

### To-Do List
- [x] Implement the “search” method of the class SearchController
- [x] The controller should use the “productItemRepository” to interface with the product database
- [x] We Use Test Driven Development. It's your responsibility to review the tests and implement the controller to the spec.

### Tips
The easiest implementation will be to use the findAll as we are below. Then filter using Java string methods such as contains(...), toLowerCase(...), equals(...), etc.  

The requirements are defined in `src/test/groovy/com/mockcompany/webapp/controller/SearchControllerSpec.groovy`  

Read through the tests to get an idea of how search should work.  When the tests are written before the code, it is known as Test Driven Development (TDD) and is a common best practice. The Spock framework is a great framework for TDD because the tests are written very descriptively using sentences.  
https://spockframework.org/spock/docs/2.0/spock_primer.html
