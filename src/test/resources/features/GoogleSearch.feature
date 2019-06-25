@sprint3
Feature: Gooogle Search


  Scenario: Search by typing
    Given I navigated to Google.com
    When I type searcg item
    And I click on google search button
    Then I see search results are displayed
