#ShadeTree Automation

##A set of blogging platform automation tests written in Java using Selenium

###How do I use this?
To run the tests you need Maven installed. You can run all the test
from the terminal with **"mvn clean test"**

The tests or stored in the **src/test/java/tests** folder and all of the
page specific code is located in the **src/test/java/pageobjects** folder.

Separating the concerns like this makes it easier to add new tests to existing test files
as well as update element locators for existing pages or add new pages to be tested

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