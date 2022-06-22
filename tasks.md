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
- The easiest implementation will be to use the findAll as we are below. Then filter using Java string methods such as contains(...), toLowerCase(...), equals(...), etc.  

- The requirements are defined in `src/test/groovy/com/mockcompany/webapp/controller/SearchControllerSpec.groovy`  

- Read through the tests to get an idea of how search should work.  When the tests are written before the code, it is known as Test Driven Development (TDD) and is a common best practice. The Spock framework is a great framework for TDD because the tests are written very descriptively using sentences.  
https://spockframework.org/spock/docs/2.0/spock_primer.html

- For an added challenge, update the ProductItemRepository to do the filtering at the database layer :)

### Resources
- Spring Boot Web Development  
https://docs.spring.io/spring-boot/docs/current/reference/html/features.html#web
 
- Spock Unit Testing  
https://spockframework.org/spock/docs/2.0/spock_primer.html

- Gradle Builds  
https://docs.gradle.org/current/userguide/userguide.html
  
<br>

## Task 2: Code Refactoring
### Background
You’ve recently implemented a new search API for them and now we’ve identified some code in the ReportController class that seems to be doing similar product searching. You will need to refactor the SearchController logic into a new SearchService class that can be used in the SearchController as well as in the ReportController. Your changes must meet the following requirements:

- Logic moved from SearchController to SearchService
- SearchController and ReportController both updated to use the SearchService
- All unit tests pass

### To-Do List
- [x] Create the new SearchService class in the “services” package. All of the search logic from the SearchController should be moved into a function in this class for reusability. 
- [x] Using @Autowired, inject the SearchService into the SearchController and ReportController.
- [x] Refactor both controller classes to use the service by rewriting their functions to use the new service.
- [x] Ensure unit tests all pass

### Tips
In Spring, controllers are used to provide functionality over the web. Services, on the other hand, provide functionality that can be reused anywhere throughout an application. In this case, the controllers will be refactored to use a shared service. 

### Resources
-  SpringBoot Service Tutorial  
https://www.tutorialspoint.com/spring_boot/spring_boot_service_components.htm


<br>

## Task 3: Continuous Integration
### Background
Continuous Integration is the practice of automating the integration of code changes from multiple contributors into a single software project. It's a primary DevOps best practice, allowing developers to frequently merge code changes into a central repository where building and test runs can occur. In this task, we’re going to be using the most popular Continuous Integration tool, Jenkins. We’ll be creating a Jenkinsfile that will build and test the application on all branches of the repository.

### To-Do List
- [x] Install the Pipelines application from the GitHub marketplace to use Jenkins directly or use the Simulated Jenkins for GitHub link to add a .github/workflows/workflow.yml to the repository.
- [x] Add the following stages to the Jenkinsfile, the relevant code is outlined with a TODO comment.
    - Build: ./gradlew assemble
    - Test: ./gradlew test
- [x] Continue to tweak the Jenkinsfile until the build is successful
- [x] Change the SearchService to always return Collections.emptyList() in order to break the tests.
- [x] Commit the change and validate the Continuous Integration build fails. This proves that we’ve properly set up Continuous Integration guard rails, that will catch failing tests each time a commit is made by a developer!

### Tips
Jenkins is the most popular Continuous Integration server in the world. In this task, you will be defining your build steps using the Jenkinsfile format. You will run these using a Jenkins Cloud Instance for GitHub or simulating Jenkins using the Jenkinsfile Runner Action in a GitHub Workflow. 

### Resources
- Jenkins
https://www.jenkins.io/

- Pipeline Syntax
https://www.jenkins.io/doc/book/pipeline/syntax/#declarative-steps

- Simulate Jenkins for Github App
https://github.com/jenkinsci/jenkinsfile-runner-github-actions#how-to-use-the-action