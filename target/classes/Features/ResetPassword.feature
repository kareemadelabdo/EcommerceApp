@resetPassword
Feature: user should be able to reset his password

  Scenario: user should fill Valid email to send password

    Given user enter valid email and click on recover
    Then success message should appear to user

  Scenario: user didn't fill email TF

    Given user enter empty email
    Then message displayed stating that email is empty

  Scenario: user fill data with wrong email

    Given user enter wrong email not saved in system database
    Then message should be displayed stating that email not found

  Scenario: user fill email with wrong format

    Given user enter email with wrong format
    Then message displayed stating that email is in wrong format
