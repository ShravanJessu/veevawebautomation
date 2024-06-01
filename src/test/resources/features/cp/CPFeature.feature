@CP
Feature: DP One Scenarios

Background: 
	Given User is on CP Home Page
	
	@CP_Case_One
	 Scenario: Get the list of feed details on feature site
    When User routed the new and feature site
    Then User captures feed details

	@CP_Case_Two
	 Scenario: Get the list of product (Jackets) details on Mens shop site
    When User routed the new and mens shop site
    And User select product from available options
    Then User captures all product details

        