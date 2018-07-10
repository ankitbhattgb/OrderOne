Feature: Book a oneway filght

  Scenario Outline: book flight
    Given user is on landing page of spice jet
    When user hovers on Login
    And user hovers on SpiceCash/SpiceClub Members
    And user clicks on Member Login
    And user enters userid "<userid>"
    And user enters password "<password>"
    And user clicks on Login button
    Then user portal should display with word Welcome
    When user clicks Book link
    Then booking page should display
    And user clicks on oneway radio button
    And user selects from city "<fromCity>" and to city "<toCity>"
    And user selects depart date "<departDate>"
    And user selects no of pax "<noOfPassanger>"
    And user selects currency "<currency>"
    And user clicks on search button
    Then search result should display

    Examples: 
      | userid       | password  | fromCity | toCity    | departDate        | noOfPassanger | currency |
      | 918884524888 | Paytm@123 | BLR      | GOI       | 20 September 2018 |             2 | AED      |
