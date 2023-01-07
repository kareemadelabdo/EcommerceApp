@registration
Feature: user should be able to register to e-commerce website


  Scenario: user enters valid data for registration
    When user enters valid data "kareem"and"adel"and"kiki@hotmail.com"and"company"and"123456"and"123456"
    And user click on register button
    Then success message should be displayed

  Scenario: user enter duplicate email
    When user enters valid data "kareem"and"adel"and"kiki@hotmail.com"and"company"and"123456"and"123456"
    And user click on register button
    Then duplicate email message appears

  Scenario: user didn't specify first name
    When user enters valid data ""and"adel"and"to@hotmail.com"and"company"and"123456"and"123456"
    And user click on register button
    Then verify that firstname is required

  Scenario: user didn't specify last name
    When user enters valid data "kareem"and""and"yo@hotmail.com"and"company"and"123456"and"123456"
    And user click on register button
    Then verify that lastname is required

  Scenario: user didn't specify email
    When user enters valid data "kareem"and"adel"and""and"company"and"123456"and"123456"
    And user click on register button
    Then verify that email is required

  Scenario: user didn't specify password
    When user enters valid data "kareem"and"adel"and"uo@hotmail.com"and"company"and""and"123456"
    And user click on register button
    Then verify that password is required

  Scenario: user didn't specify confirm password
    When user enters valid data "kareem"and"adel"and"op@hotmail.com"and"company"and"123456"and""
    And user click on register button
    Then verify that confirm password is required

