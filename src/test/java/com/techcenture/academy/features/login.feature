#Author: Alex Peterson
#Date:  Feb 8 2022
Feature: Login Functionality of OpenMRS Demo APP

  Scenario: Login Functionality Positive Test
#    each step here will be mapped to its implememting methods called step definitions
    Given user is on the login page
    When user enters username and password
    And user selects inpatient ward
    And user clicks on login button
    Then user should be navigated to home page

#    Scenario: Login Functionality Negative Test
#      Given user is on the login page
#      When user enters incorrect username and password
#      And user selects inpatient ward
#      And user clicks on login button
#      Then user should see invalid user name error message