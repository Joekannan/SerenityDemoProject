Feature: Search the String
  I want to search the product in the app
  To know the options available for online shopping

  Scenario: Search Product
    Given I launch the AUT
    When I click SearchButton
    Then I enter "Rings"
    And I click Find button
