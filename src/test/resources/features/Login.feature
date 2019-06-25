#Autor: syntax team   //john.smith@wellsfargo.com
@sprint3
Feature: Login

  Background: 
    Given I see OrangeHRM logo

  @smoke @login @test
  Scenario: Valid Login
    When I enter valid userName and password
    And I click login Btn
    Then I successfully logged in

  @regression @login
  Scenario: Invalid Login
    When I enter invalid userName and password
    And I click login Btn
    Then I see error message is displayed

  @err
  Scenario: Error message Validation
    When I enter invalid username and password I see the errorMessage
      | UserName | Password   | ErrorMessage        |
      | Admins   | Admin123   | Invalid Credentials |
      | Admins   | Syntax123! | Invalid Credentials |
      | Admins1  | Syntax123! | Invalid Credentials |
      | Admin    | @81EpCSguV | Invalid Credentials |
