#Author: your.email@your.domain.com
#Keywords Summary :
#Feature: List of scenarios.
#Scenario: Business rule through list of steps with arguments.
#Given: Some precondition step
#When: Some key actions
#Then: To observe outcomes or validation
#And,But: To enumerate more Given,When,Then steps
#Scenario Outline: List of steps for data-driven as an Examples and <placeholder>
#Examples: Container for s table
#Background: List of steps run before each of the scenarios
#""" (Doc Strings)
#| (Data Tables)
#@ (Tags/Labels):To group Scenarios
#<> (placeholder)
#""
## (Comments)
#Sample Feature Definition Template
Feature: Using Different Roles

	Background: 
		Given The Guest is on the Login Page
	
	Scenario Outline: The Guest tries to enter a valid Username and Password
		When The User types in "<username>" and "<password>"
		And Presses the Login button
		Then The Guest should be at Login page
		
		Examples:
			|		username		|		password					|
			|		Dsmith			|		123 - Home Page	  |
			|		Dwho				|		321 - Home Page	  |
			|		Rtyler		  |		213 - Home Page	  |
