#ShadeTree Automation

##A set of blogging platform automation tests written in Java using Selenium

###How do I use this?
To run the tests you need Maven installed. You can run all the test
from the terminal with **"mvn clean test"**

The tests or stored in the **src/test/java/tests** folder and all of the
page specific code is located in the **src/test/java/pageobjects** folder.

Separating the concerns like this makes it easier to add new tests to existing test files
as well as update element locators for existing pages or add new pages to be tested

In order to add a new page to test, you would just need to add a new class to the pageobjects
folder and make it extends the Base pageobjects class.

Adding new tests is similar, there is a Base test class that each new test will need to extend.

###[Sauce Labs](https://saucelabs.com)
You have to abilty to run your test through Sauce Labs. This opens up the capability 
of running your tests in multiple browsers on multiple OSs.

####Setup
In order to run your tests in Sauce Labs: 

1. Create an account at [saucelabs.com](https://saucelabs.com)
2. Set environment variables SAUCE_USERNAME and SAUCE_ACCESS_KEY
3. Run the tests with **mvn clean test -Dhost=saucelabs**

You can also specify various browsers, ,versions and, OSs at the command line like:
**mvn clean test -Dhost=saucelabs -Dbrowser=chrome -DbrowserVersion=40 -Dplatform="OS X 10.8"**

Here is a whole list of supported platforms. [link](https://saucelabs.com/platforms)

###Test Categories
You can categorize tests by added by using a JUnit @Category annotation above each test 
or at the top of the class. Right now I have setup two categories, Deep and Shallow. 
You can run all tests in a particular category by specifying it in the Maven command.

**mvn clean test -Dgroups=tests.groups.Deep**

If you want to run all test together, *(not recommended)* use this:

**mvn clean test -Dgroups=tests.groups.All**

The Shallow group is run by default.