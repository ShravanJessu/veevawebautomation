# Veeva Web Automation

## Project Purpose
This project aims to give an automation test framework that uses Selenium and Cucumber with Java as the programming language.

## Tools and Libraries
This project using 2 main tools, Selenium and Cucumber.
On the other hand, I using some of the tools that support this great framework.
The complete list of tools, you can see in the `pom.xml` file.

## Requirements
* [Java 8+](https://www.oracle.com/in/java/technologies/javase/javase8-archive-downloads.html)
* [Maven](https://maven.apache.org/) (Optional - Needed only for command line executions as IDEs have Maven in-built.)

## Running Tests
* Clone the repository from your fork to this directory
* Open the project using any Java IDE
* Run the tests with chrome browser use below
    ```shell
    $ mvn exec:java -Dbrowser="chrome" -DrunnerClass="com.derived.product1.runner.TestRunner"
    $ mvn test
    ```
* Run the tests with chrome, msedge browsers use below
    ```shell
    $ mvn exec:java -Dbrowser="chrome,msedge" -DrunnerClass="com.derived.product1.runner.TestRunner"
    $ mvn test
    ```
## Test Results
* Test report automatically generated on `target` folder after finished the test execution
* Open cucumber-reports.html file on your browser from target/ folder
* Local execution report:
  
  ![image](https://github.com/ShravanJessu/veevawebautomation/assets/171390950/d880475a-6fa3-467a-a776-2d485a1f6c8d)
 
  

---

### References
* https://cucumber.io/docs/installation/java/
* https://www.selenium.dev/documentation/en/

**********************

# Project Directory Structure
```
├───src
│   ├───main
│   │   ├───java
│   │   │   └───com
│   │   │       └───automation
│   │   │           └───framework
│   │   │               ├───cp
│   │   │               │   └───pages            # CP Product Pages
│   │   │               ├───dp1
│   │   │               │   └───pages            # DP1 Product Pages
│   │   │               ├───dp2
│   │   │               │   └───pages            # DP2 Product Pages
│   │   │               └───utils                # Common reusable methods
│   │   └───resources                            # Log4j2 prop file stored 
│   └───test
│       ├───java
│       │   ├───com
│       │   │   ├───core
│       │   │   │   └───product    
│       │   │   │       ├───runner                # Test Runner Package for Core Product
│       │   │   │       └───steps                 # Step Defination Package for Core Product   
│       │   │   └───derived
│       │   │       ├───product1
│       │   │       │   ├───runner                # Test Runner Package for DP One
│       │   │       │   └───steps                 # Step Defination Package for DP One
│       │   │       └───product2
│       │   │           ├───runner                # Test Runner Package for DP Two    
│       │   │           └───steps                 # Step Defination Package for DP Two
│       │   └───common                            # Hooks Class
│       └───resources
│           ├───data                              # Data used in data driven tests and stores here  
│           └───features                          # Cucumber/Gherkin feature files directory 
│               ├───cp
│               ├───dp_one
│               └───dp_two

```
