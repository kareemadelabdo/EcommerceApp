@addToCart
Feature: Adding products to carts

  Scenario: add shoes to cart

    Given user should choose apparel then shoes
    When user should choose color and add shoes to cart and go to cart page to view it
    Then success message should appear