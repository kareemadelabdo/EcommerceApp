Feature: user should be able to add products to comparelist

  Scenario: user should choose shoes and add it to comparelist

    Given user should go to website homepage website
    And user choose apparel then shoes item
    When user should choose color then add shoes to comparelist
    Then comparelist success message should appear