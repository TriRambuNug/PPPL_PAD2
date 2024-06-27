Feature: User Login

    Scenario: Successful Login
        Given I am on the login page
        When I fill in the login form with valid credentials
        And I submit the login form
        Then I should be on the dashboard page
