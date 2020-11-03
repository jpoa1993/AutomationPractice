Feature: Search

Scenario: View product preview
    Given I have searched for a product
    When I view the product preview
    Then I see the related product preview

