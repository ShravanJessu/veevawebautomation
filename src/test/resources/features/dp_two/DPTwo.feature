@dp_two
Feature: DP Two Scenarios

Background: 
	Given User is on DP Two Home Page

  Scenario: Get the list of available items
    When User enters username as "user" and password as "pass"
    Then User should be logged in
