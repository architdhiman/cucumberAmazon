@PincodeTag
Feature: Pincode Functionality

Background:	
		Given user is on the homepage
		When User clicks pincode tab
	@valid
	Scenario Outline: User changes pincode successfully
		And User enters "<pincode>"
		And User clicked on submit
		Then pincode "<city>" is changed successfully
	
	
			Examples:
      | pincode  | city        |
      | 110030    | New Delhi  |
      | 110017    | New Delhi  |
  
  @invalid 
	Scenario: User types invalid pincode
		And User enters invalid pincode
		And User clicked on submit
		Then invalid pincode error is displayed
		
