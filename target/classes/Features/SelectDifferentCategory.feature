@selectDifferentCategory
Feature: user should be able to select different categories

  Scenario: user select category then sub category from drop list

    Given user select computers then desktop
    Then user should be directed to desktop page

  Scenario: user select category without sub category

    Given user select digital downloads
    Then user should be directed to digital downloads page