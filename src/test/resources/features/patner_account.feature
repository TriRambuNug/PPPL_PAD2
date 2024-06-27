Feature: Patner Accounts Management
    As an admin
    I want to manage patner accounts
    So that I can view and search

    Scenario: View patner accounts table
        Given I am on the patner accounts page
        Then I should see the patner accounts table

    Scenario: Search for a patner account
        Given I am on the patner accounts page
        When I enter "John" into the search field patner account
        Then I should see the account patner details for "John"

    Scenario: Details page for a patner account
        Given I am on the patner accounts page
        When I enter "John" into the search field
        Then I click on the account details for "John"
        Then I should see the account patner address "123 Main Street" from different page

    Scenario: Changing the status account for a patner account
        Given I am on the patner accounts page
        When I enter "John" into the search field
        And I click on the account details for "John"
        And I click on the blocked status patner button
        Then I save the changes patner account
        And I should see the account patner status "blocked" for "John"