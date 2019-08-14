@Login
Feature: Login Red App
  As a user with valid credentials
  I want to able to log in to the red app
  So that I can shop the stuffs
    
  Scenario: Valid User Login to the RedApp
    Given I launch Red App
    When I click Hamburger menu
    And I click Login link
    Then I enter an "jothi2k9@gmail.com" and "test123"
    And I click Sign In
    Then I see the logged in email at Hamburger menu
    
  Scenario: Invalid User Login to the RedApp
    Given I launch Red App
    When I click Hamburger menu
    And I click Login link
    Then I enter an "jothi2k9@gmail.com" and "Test123"
    And I click Sign In
    Then I see the Login failed Message
