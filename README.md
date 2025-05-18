## IdentityE2E Test for Vehicle registration check

### A few key points regarding the framework approach:

- Followed the Page Object Model (POM) design pattern.
- Focused not just on completing the immediate test, but on designing a scalable, reusable automation framework to support future enhancements and expanded test coverage. - Ofcourse it needs further improvements

### Some points related to actual test: 

- Step reads all vehicle registration numbers from an input file.
- The test iterates through each registration number and verifies corresponding vehicle details on the web page with Output file.
- Soft assertions are used to:
  - Prevent test failure if a registration number is not found.
  - Allow all field validations to complete even if some values do not match.
  - All errors are reported at the end to provide a complete overview

### Identified Issues Causing Test Failures:

1. UI Interaction Limitation Due to Chrome Automation Dialog:
   - The presence of Chrome’s automated control notification is obstructing interaction with top header elements, such as the "Home" navigation option.
   - This is preventing tests from performing expected actions in the header section.
2. Application Crash When Searching for the Last Vehicle Registration:
   - Executing a search for the last vehicle registration causes the application to break, likely due to unhandled backend or UI behavior.
   - This results in test failure and may indicate a critical issue in the search or data retrieval flow.

### An automation framework built using the following stack:

- Java 17 – Programming language
- Maven – Dependency management and build tool
- Selenium WebDriver – Browser automation
- TestNG – Test execution framework
- Cucumber – BDD (Behavior Driven Development) tool
- WebDriverManager – Automatically manages browser drivers

### To run tests:

- Use IntelliJ: Right-click on Runner.java → Run
- Or use Maven CLI: mvn clean test -Dcucumber.filter.tags="@test"
