@login
Feature: user should be able to login to e-commerce website after registration

  Scenario: user login with valid credentials

    When user enters credentials
    Then login successfully with valid data

  Scenario: user login with invalid credentials

    When user enters invalid credentials
    Then  login unsuccessful with invalid data