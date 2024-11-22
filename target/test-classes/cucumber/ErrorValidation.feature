
@tag
Feature: Title of your feature
  I want to use this template for my feature file

  
  @tag2
  Scenario Outline: Title of your scenario outline
    Given I landed on ecommerce page. 
    Given User logged in with the username <name> and password <value>
    Then "Incorrect email or password." message is displayed.

    Examples: 
       | name           | value      |
      | abcd@gmail.com |Rutvik@0211 |
 