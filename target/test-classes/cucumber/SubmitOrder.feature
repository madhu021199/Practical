
@tag
Feature: Purchasing Order from the ecommerce website
  I want to use this template for my feature file


Background:
Given I landed on ecommerce page. 

  @tag2
  Scenario Outline: Positive test of submitting the order.
  
    Given User logged in with the username <name> and password <value>
    When I add product <productName> to the cart 
    And checkout <productName> and submit the order.
    Then "Thankyou for the order." message is displayed on the confirmation page.

    Examples: 
      | name           | value       | productName  |
      | abcd@gmail.com |Ruthvik@0211 | ADIDAS ORIGINAL|
 