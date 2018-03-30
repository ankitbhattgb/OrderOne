Feature: Login to Spicejet webiste using special club member credentials

Scenario Outline: User login with club member

Given I am on landing page of spice jet
When I hover on Login 
And I hover on SpiceCash/SpiceClub Members
And I click on Member Login
And I enter "<user-id>" 
And I enter "<password>"
And I click on Login button
Then I should navigate to user portal 
And welcome message should appear

Examples:

|user-id     |password |
|918884524888|paytm@123|