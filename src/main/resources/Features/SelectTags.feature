@selectTags
Feature: user should be able to choose different tags

  Scenario: user should choose tag and result is shown

    Given user choose specific tag
    Then items with this tag should be displayed
