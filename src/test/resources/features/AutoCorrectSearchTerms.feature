@bbc
Feature: Automatically correct mistyped search terms

  Scenario: Enter search term and view related images
    Given I am on the website 'http://www.google.com'
    When I submit the search term 'bbc'
    And accept the first search result
    Then I should be on the page 'http://www.bbc.co.uk/'