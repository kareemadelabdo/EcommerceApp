@addToCompareList
Feature: user should be able to add products to compare list

  Scenario: user should choose shoes and add it to compare list

    Given user choose apparel then shoes item
    When user should choose color then add shoes to comparelist
    Then comparelist success message should appear