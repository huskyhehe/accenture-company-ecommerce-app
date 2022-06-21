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

For an added challenge, update the ProductItemRepository to do the filtering at the database layer :)

### Resources
- Spring Boot Web Development  
https://docs.spring.io/spring-boot/docs/current/reference/html/features.html#web
 
- Spock Unit Testing  
https://spockframework.org/spock/docs/2.0/spock_primer.html

- Gradle Builds  
https://docs.gradle.org/current/userguide/userguide.html

<<<<<<< refactor
For an added challenge, update the ProductItemRepository to do the filtering at the database layer :)



## Task 2: Code Refactoring
### Background
You’ve recently implemented a new search API for them and now we’ve identified some code in the ReportController class that seems to be doing similar product searching. You will need to refactor the SearchController logic into a new SearchService class that can be used in the SearchController as well as in the ReportController. Your changes must meet the following requirements:

- Logic moved from SearchController to SearchService
- SearchController and ReportController both updated to use the SearchService
- All unit tests pass

In Spring, controllers are used to provide functionality over the web. Services, on the other hand, provide functionality that can be reused anywhere throughout an application. In this case, the controllers will be refactored to use a shared service. In this task you’ll need to do the following:

### To-Do List
- [x] Create the new SearchService class in the “services” package. All of the search logic from the SearchController should be moved into a function in this class for reusability. 
- [x] Using @Autowired, inject the SearchService into the SearchController and ReportController.
- [x] Refactor both controller classes to use the service by rewriting their functions to use the new service.
- [x] Ensure unit tests all pass

### Resources
-  SpringBoot Service Tutorial  
https://www.tutorialspoint.com/spring_boot/spring_boot_service_components.htm
