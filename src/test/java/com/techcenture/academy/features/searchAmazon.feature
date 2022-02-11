Feature: Testing Amazon Search functionality

  Scenario: search for items over 1000 dollars
    Given user is on amazon page
    When user enters "relax massage chair" in the search input box
    And user clicks on search button
    And search result must contains search keyword
    Then each search result item should contain one of the three keywords
