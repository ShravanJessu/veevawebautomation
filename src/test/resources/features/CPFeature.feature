Feature: Login

@smoke
  Scenario: Successful Login
    Given User is on Login Page
    When User enters username as "user" and password as "pass"
    Then User should be logged in
