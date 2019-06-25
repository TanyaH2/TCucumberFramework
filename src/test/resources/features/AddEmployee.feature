#Autor: syntax team   //john.smith@wellsfargo.com
@AddEmployee @sprint5
Feature: Add Employee

  Background: 
    And I logged in into OrangeHRM
    Given I click on PIM link
    And I click on Add Employee link

  @smoke
  Scenario Outline: Add Employee
    When I provide Employee details "<FirstName>", "<MiddleName>", "<LastName>", "<Location>"
    And I click on save button
    Then I see employee "<FirstName>" and "<LastName>" is added succesfully

    Examples: 
      | FirstName | MiddleName | LastName | Location |
      | Fizz      | C          | Smih     | HQ       |
      | Roxy      | P          | Hill     | HQ       |
      | Koda      | R          | Black    | HQ       |

  @HW1+
  Scenario Outline: Add Employee and Create Login Details
    When I provide Employee details "<FirstName>", "<MiddleName>", "<LastName>", "<Location>"
    And I click on create login details
    And I provide all mandatory fields "<UserName>", "<Password>", "<ConfirmPass>", "<ESSRole>", "<SupervRole>"
    And I click on save button
    Then I see employee "<FirstName>" and "<LastName>" is added succesfully

    Examples: 
      | FirstName | MiddleName | LastName | Location       | UserName | Password      | ConfirmPass   | ESSRole     | SupervRole         |
      | Fizz      | C          | Smih     | HQ             | Drioc    | qwdcvv23@$Z   | qwdcvv23@$Z   | Default ESS | Default Supervisor |
      | Roxy      | P          | Hill     | Tech Support   | DriocZ   | qwdcvv23@$ZZ  | qwdcvv23@$ZZ  | Default ESS | Default Supervisor |
      | Koda      | R          | Black    | System Support | DriocZZ  | qwdcvv23@$ZZZ | qwdcvv23@$ZZZ | Default ESS | Default Supervisor |

  @HW2+
  Scenario: Add Employee labels verification
    Then I see following labels
      | First Name           |
      | Middle Name          |
      | Last Name            |
      | Employee Id          |
      | Location             |
      | Create Login Details |
