@createOrder
Feature: user should be able to create successful order

  Scenario: user should login then make a successful order

    Given user should login with valid credentials
    And user should choose apparel shoes item then add to cart
    And user should navigate to shopping cart page and checkout
    And user should fill data and press continue
    And user should choose shipping method
    And user should choose payment method and then choose continue
    And user should see payment info
    And user should confirm order
    Then success message should appear stating that order is processed


