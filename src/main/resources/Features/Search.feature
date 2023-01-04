Feature: user should be able to search for items

  Scenario: when user types minimum 3 character results should be shown in table

    Given user open browser and navigates to login page
    And user should login successfully with valid email and password
    When user enters valid search query
    Then user should see results in table of items

  Scenario: when user types less than 3 characters error message should be displayed
    Given user open browser and navigates to login page
    And user should login successfully with valid email and password
    When user enter less than 3 character in search field
    Then error message should be displayed
