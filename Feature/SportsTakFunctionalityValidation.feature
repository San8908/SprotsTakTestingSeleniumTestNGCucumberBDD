#author:cu.18bcs6599@gmail.com
#Run this feature file using testng.xml
#Run this feature file using testng.xml
@SportsTakTest
Feature: Sportstak functionalities validations

  Scenario Outline: Validating and verifying the functionality of Sportstak
    Given Open chrome browser and enter URL
    Then Click on each thumbnail and verify that links are not broken on Home
    And Click on "<tab>"
    Then scroll to the page "<PageNo>" and click on the links and verify the links are not broken.
    And Change the theme from "<Col1>" to "<Col2>".
    And Change the theme from "<Col3>" to "<Col4>".
    And Click on "<tab1>"
    And Capture the text on each Web Stories on page "<Page_number>".
    And Click on "<WebStoryNo>" webstory displayed.
    Then click on the next webstory and return to the homepage.

    Examples: 
      | tab     | PageNo | Col1  | Col2 | Col3 | Col4  | tab1        | Page_number | WebStoryNo |
      | Cricket |      3 | Light | Dark | Dark | Light | Web Stories |           1 |          1 |
