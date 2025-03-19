# Test Automation Framework

This is a Java-based test automation framework designed for efficient and scalable testing. 

It incorporates modern testing practices and supports data-driven testing, cloud execution, and headless mode for faster execution.

This framework leverages various libraries and tools to facilitate logging, reporting and integration with cloud-based testing platform like lambdatest.


## 🚀 About Me
Hi, I'm Vineet Rao. I have 3 years of experience in Testing, specializing in Selenium Web Driver for automation.

Possess experience as a Manual Tester within the Temenos T24 core banking domain, with specialization in the testing of Cards & Payments and Loan Management System functionalities.


## Author
- [vineetRao03](https://github.com/vineetRao03)
- EmailAddress: vineetrao0309@gmail.com

## 🔗 Links

[![linkedin](https://img.shields.io/badge/linkedin-0A66C2?style=for-the-badge&logo=linkedin&logoColor=white)](https://www.linkedin.com/in/vineetrao03/)



## Prerequisites

Before running this framework, ensure the following software is installed on your system:

**Java 11** - Make sure Java is installed and the JAVA_HOME environment variable is set.   
**Maven** - Ensure Maven is installed and added to the system path.
**Download Link**: https://maven.apache.org/download.cgi
## Features
- **Data-Driven Testing**: Using OpenCSV, Apache POI, and Gson for reading test data from CSV and Excel files and JSON.
- **Cross-Browser Testing**: Supports running tests on different browsers.
- **Headless Mode**: Faster execution by running tests in headless mode.
- **Cloud Testing**: Integrated with LambdaTest to run tests on the cloud.
- **Logging**: Uses Log4j for detailed logs.
- **Reporting**: Generates detailed reports using Extent Reports.

## Technologies Used
- Java 11
- TestNG
- OpenCSV
- Gson
- Apache POI
- Faker
- LambdaTest
- Log4j
- Extent Reports
## Setup Instructions


  **Clone the Repository**:

    git clone- https://github.com/vineetRao03/Test-Automation-Framework.git

    cd Test-Automation-Framework

**Running Tests on LambdaTest:**

    mvn test -Dbrowser=chrome -DisLambdaTest=true -DisHeadless=false -X

**Running Tests on Chrome browser on Local Machine in Headless Mode:**

    mvn test -Dbrowser=chrome -DisLambdaTest=false -DisHeadless=true -X


**Reports & Logs**

-Reports: After execution, a detailed HTML report will be generated at ./report.html.

The report contains information on test cases executed, passed, failed, and skipped, along with screenshots for failed tests.

**Logs:**

Logs are created during the test execution and stored in the ./logs/ directory.

    
