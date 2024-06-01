# Veeva Web Automation

## Project Purpose
This project aims to give an automation test framework that uses Selenium and Cucumber with Java as the programming language.

## Tools and Libraries
This project using 2 main tools, Selenium and Cucumber.
On the other hand, I using some of the tools that support this great framework.
The complete list of tools, you can see in the `pom.xml` file.

## Requirements
* Java Development Kit
* Maven


**********************

# Project Directory Structure
```
└───src
    ├───main
    │   ├───java
    │   │   └───com
    │   │       └───automation
    │   │           └───framework
    │   │               ├───common                    # Common Hooks Package
    │   │               ├───cp                  
    │   │               │   └───pages                 # CP Product Pages 
    │   │               ├───dp1
    │   │               │   ├───pages                 # DP Product One Pages
    │   │               │   └───stepdef               # DP Product One Cucumber StepDefination Package 
    │   │               ├───dp2
    │   │               │   ├───pages                 # DP Product Two Pages  
    │   │               │   └───stepdef               # DP Product Two Cucumber StepDefination Package  
    │   │               └───utils                     # Common Package of Reusable Methods 
    │   └───resources
    └───test
        ├───java
        │   ├───com
        │   │   ├───core
        │   │   │   └───product
        │   │   │       └───runner                    # Test Runner Package for Core Product 
        │   │   └───derived
        │   │       ├───product1
        │   │       │   └───runner                    # Test Runner Package for DP One
        │   │       └───product2
        │   │           └───runner                    # Test Runner Package for DP Two
        │   └───common
        └───resources
            ├───data                                  # Data used in data driven tests stored here
            └───features                              # Feature file driven by testng_web xml file
                ├───cp
                ├───dp_one
                └───dp_two

```
