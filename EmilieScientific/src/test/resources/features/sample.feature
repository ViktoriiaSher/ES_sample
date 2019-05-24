@web-application
Feature: Sample form application

  Background:
    Given I am on application submission page

  @positive-submission
  Scenario: Verify a response that submission data is successfully recorded
    When I enter an email as xyz@xyz.co
    And I enter a secondary email as xyz@xyz.com
    And I enter a phone number as 999-999-9999
    And I enter a zip code as 99999
    And I click on submit button
    Then a response that submitted data is successfully recorded should be displayed

  @negative-submission
  Scenario: Verify I get appropriate error when submit blank form
    When I click on submit button
    Then I get an appropriate error for blank form

  @negative-submission
  Scenario Outline: Validate email format
    When I enter an email as <email>
    And I enter a secondary email as <secondary email>
    And I enter a phone number as 999-999-9999
    And I enter a zip code as 99999
    And I click on submit button
    Then I get invalid email address error message

    Examples:
      | email              | secondary email |
      |  test#gmail.com    | xyz@gmail.com   |
      |  test@gmail        | 112             |
      |  &^@gmail.com      | 1               |
      |  test#gmail.com    | error           |
      |  . sa              | .  sd           |
      |  abc.com           | &^@gmail.com    |
      |  a@sample.co.uk    | .               |
      |  %%12@gmail.com    | ac.@oal.com     |

  @negative-submission
  Scenario Outline: Verify phone number format
    When I enter an email as xyz@xyz.com
    And I enter a secondary email as xyz@xyz.com
    And I enter a phone number as <phone number>
    And I enter a zip code as 99999
    And I click on submit button
    Then I get invalid phone error message

    Examples:
      | phone number  |
      | &^2-999-!@99  |
      | 000000000     |
      | abc-abc-9999  |
      | 999-999-999   |

  @negative-submission
  Scenario Outline: Verify US zip code format
    When I enter an email as xyz@xyz.com
      And I enter a secondary email as xyz@xyz.com
      And I enter a phone number as 999-999-9999
      And I enter a zip code as  <zip code>
      And I click on submit button
    Then I get invalid zip code error message

    Examples:
      | zip code    |
      | 4444        |
      | 444444      |
      | !@#$%       |
      | abcde       |
      | 55555-55555 |
      | 55555-555   |
      | 5555-55555  |
      | 55555-      |
      |    -5555    |
