Feature: user should be able to choose different tags

  Scenario: user should choose tag and result is shown

    Given user should navigate to home page and type validated word to search and then scroll down to choose tag
    When user choose specific tag
    Then items with this tag should be displayed
