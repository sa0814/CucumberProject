Feature: Objectives

Background:
	Given I browse to website
	When user enters "$122365.24","$599.00","$850139.99","$23329.50","$566.27"


Scenario: Right Count of Values
	Then I verify the correct values appear on the screen

Scenario: Values greater than Zero
	Then I verify on of the values on the screen are greater than zero

Scenario: Total Balance Value
	Then I verify the total balance value

Scenario: Formatted currency|
	Then I verify the currency format

Scenario: Total Balance Sum
	Then I verify the total balance matches sum of the values