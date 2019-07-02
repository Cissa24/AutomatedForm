Feature: Katalon form automation
  As a user I want to fill the form and submit

  Background:
    Given Form is opened

  Scenario Outline: Form submission
    Given user navigates to the form
    When enters first name "<firstName>"
    And enters last name "<lastName>"
    And enters gender
    And enters date of birth "<dateOfBirth>"
    And enters address
    And enters email
    And enters password
    And enters company name
    And selects a role
    And selects job's expectation
    And selects ways of development
    And enters a comment
    And clicks submit button
    Then form is submitted


    Examples:
      | firstName | lastName  | dateOfBirth |
      | Sergii    | Opanasiuk | 02/20/1988  |
      | Olga      | Cissa     | 12/24/1990  |
      | Aditi     | Adavadkar | 02/10/1070  |

