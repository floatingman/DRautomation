# ShadeTree Automation

## A set of blogging platform automation tests written in Java using Selenium

### How do I use this?
To run the tests you need Maven installed. You can run all the test
from the terminal with **"mvn clean test"**

The tests or stored in the **src/test/java/tests** folder and all of the
page specific code is located in the **src/test/java/pageobjects** folder.

Separating the concerns like this makes it easier to add new tests to existing test files
as well as update element locators for existing pages or add new pages to be tested
