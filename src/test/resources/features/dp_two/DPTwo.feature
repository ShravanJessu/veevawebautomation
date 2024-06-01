@dp_two
Feature: DP Two Scenarios

Background: 
	Given User is on DP Two Home Page

  Scenario: Capture the list of available links from footer section
    When User scolls to page footer section
    Then User captures all availables links and stores in file
