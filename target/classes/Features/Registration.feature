Feature: user should be able to register to e-commerce website

  Background: prerequisite steps

    Given user should open browser
    And user should navigate to registration page
    When user enters valid data
    And user click on register button

  Scenario: user enters valid data for registration

    Then success message should be displayed

  Scenario: user enter duplicate email

    Then duplicate email message appears

  Scenario: user didn't specify first name

    Then verify that firstname is required

  Scenario: user didn't specify last name

    Then verify that lastname is required

  Scenario: user didn't specify email

    Then verify that email is required

  Scenario: user didn't specify password

    Then verify that password is required

  Scenario: user didn't specify confirm password

    Then verify that confirm password is required

