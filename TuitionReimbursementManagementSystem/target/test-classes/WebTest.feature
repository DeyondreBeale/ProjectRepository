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
# This is a comment in a Feature File
Feature: Webpage links work

  #Each Scenario will connect to a user story
  
   Scenario: Log In with Valid Credientials works
 	Given The User is on the Login Page
 	When The User enters username as "Rsong" and types "111" for password
 	And The User clicks the Login button
 	Then The User should be on the Login
 	
  Scenario: Reimbursements Page works
    Given The User is on the Home Page
    When The User clicks Reimbursements
    Then The User should be on the Reimbursements Home Page
    
  Scenario: Account Details Page works
  	Given The User is on the Home Page
  	When The User clicks Account Details
  	Then The User should be on the Account Details Page
  	
  	  Scenario: Contact Page works
  	Given The User is on the Home Page
  	When The User clicks Contact
  	Then The User should be on the Contact Page
  	
 Scenario: Log Out works
 	Given The User is on the Home Page
 	When The User clicks Log Out
 Then The User should be on the Login Page
  
  	