Feature: user should be able to login to e-commerce website after registration

  Scenario: user login with valid credentials

    Given user should open browser and navigates to login page
    When user enters credentials
    Then login successfully with valid data

  Scenario: user login with invalid credentials

    Given user should open browser and navigates to login page
    When user enters invalid credentials
    Then  login unsuccessful with invalid data