# Testing PrestaShop using Cucumber
This directory contains the cucumber files for testing the "adding item for sale" and "adding item to wishlist" module of the PrestaShop application.

## Running the tests
Run ```mvn test``` to run all the tests.

## Feature files
The behaviors that we tested are in the feature files that inside the [resources/hellocucumber](resources/hellocucumber) directory. See the files for a detailed description of the tests.

$$*TODO*: Make sure that the text inside the feature files is informative and self-explanatory. This includes the "Feature: ...", "Scenario: ...", and "Given/When/Then ..." lines. See the "example.feature" file for an example.$$

## Step files
The step files in the [src/test/java/hellocucumber](src/test/java/hellocucumber) directory contain the code that defines how each sentence in the feature files is translated to Selenium actions. See the files for a detailed description of the implementation.

$$*TODO* Make sure that each step is documented and properly writen (meaningful variable names, no magic number, etc.). See the [StepDefinitions.java](src/test/java/hellocucumber/StepDefinitions.java) file for an example.$$
