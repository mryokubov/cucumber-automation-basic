Feature: Google search functionality

  Scenario: search for java book
    Given user is on the google search page
    When user enters "java for beginners" in the search box
    And user clicks on enter
    Then user should see results for searched item
