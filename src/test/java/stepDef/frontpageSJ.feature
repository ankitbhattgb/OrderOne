Feature:Attitude matters
Scenario Outline: I am an employee and its my attitude


Given I work in "<time>"
When I meet "<guy>"
Then I "<greet>" him

Examples:

|time    | guy        | greet       |
|morning |officeboy   | greet       |
|noon    |newspaperboy| skipgreeting|
|evening |cabdriver   | handshake   |
|night   |security    | hug         |

