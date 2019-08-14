Feature: Checkout journey
  As a registered/guest user
  I want to shop online and complete the checkout process by paying either by credit card, WH money card or Part pay card.
    
    Scenario Outline: Registered User Checkout Journey
    Given I login using "<email>" and "<password>"
    And I look for "Watches"
    When I select "Watches" from the appropriate category
    And I select to add one of the items to the cart
    And I go to cart
    And I select "<delivery method>"
    And I click Checkout
    Then I add the delivery details
    And I select the "<Payment Method>"
    And I Click Payment button to enter the card details
    And successful payment displays the order number
    
    Examples: 
      | email                | password | delivery method | Payment Method |
      | crashfix@gmail.com   | test123  | Home Delivery   | Credit Card  |
			| sampletest@gmail.com   | test123  | Home Delivery   | Warehouse Money Card  |

#	Background: User is Logged In
#		Given I launch Red App
    #When I click Hamburger menu
    #And I click Login link
    #Then I enter an "sampletest@gmail.com" and "test123"
    #And I click Sign In
    #
    #Scenario: Registered User C&C Checkout Journey
#		Given I go to cart
    #And I select "Home Delivery"
    #And I click Checkout
    #Then I add the delivery details
    #And I select the "Credit Card"
    #And I Click Payment button to enter the card details
    #And successful payment displays the order number