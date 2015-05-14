@selenium
Feature: Enter a search term into Google and view results

  Scenario: Submit search term
    Given I am on the website 'http://www.google.com'
    When I submit the search term 'selenium webdriver'
    And accept the first search result
    Then I should be on the page 'http://www.seleniumhq.org/projects/webdriver/'



