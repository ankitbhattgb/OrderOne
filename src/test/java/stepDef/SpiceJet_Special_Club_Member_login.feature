Feature: Login to Spicejet webiste using special club member credentials
@SmokeTest
  Scenario Outline: User login with club member
    Given user is on landing page of spice jet
    When user hovers on Login
    And user hovers on SpiceCash/SpiceClub Members
    And user clicks on Member Login
    And user enters userid "<userid>"
    And user enters password "<password>"
    And user clicks on Login button
    Then user portal should display with word Welcome
    When user clicks on logout
    Then user should logout

    Examples: 
      | userid       | password  |
      | 918884524888 | Paytm@123 |
