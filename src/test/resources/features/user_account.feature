Feature: User Accounts Management
    As an admin
    I want to manage user accounts
    So that I can view and search

    Scenario: View user accounts table
        Given I am on the user accounts page
        Then I should see the user accounts table

    Scenario: Search for a user account
        Given I am on the user accounts page
        When I enter "tri" into the search field
        Then I should see the account details for "tri"

    Scenario: Details page for a user account
        Given I am on the user accounts page
        When I enter "tri" into the search field
        Then I click on the account details for "tri"
        Then I should see the account pin "123123" from different page

    Scenario: Changing the status account for a user account
        Given I am on the user accounts page
        When I enter "tri" into the search field
        And I click on the account details for "tri"
        And I click on the blocked status button
        Then I save the changes
        And I should see the account status "blocked" for "tri"