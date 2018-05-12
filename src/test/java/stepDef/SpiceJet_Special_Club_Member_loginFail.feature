Feature: Login to Spicejet webiste using incorrect special club member credentials

Scenario Outline: User login with incorrect credentials

Given user is on landing page of spice jet
When user hovers on Login
And user hovers on SpiceCash/SpiceClub Members
And user clicks on Member Login
And user enters userid "<userid>" 
And user enters password "<password>"
And user clicks on Login button
Then Alert message should display

Examples:

|userid      |password|
|918884524888|Paytm@23|
