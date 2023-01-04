Feature: user should be able to add products to wishlist
  Scenario: user should choose shoes and add it to wishlist
    Given user should go to website homepage
    And user choose apparel then shoes
    When user should choose color then add shoes to cart and go to cart page to view it
    Then wishlist success message should appear