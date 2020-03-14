Feature: verifying adactin hotel detail
Scenario Outline: To book an hotel in Adactin

Given User is on Adactin page
When User enters "<userName>" and "<password>"
And User should click on Login button
And User Selects "<location>","<hotel>","<type>","<rooms>","<indate>","<outdate>","<adultesperroom>"
When User click on Search button
And User should click on HotelName
And User clicks on continue button
And User enters "<firstName>","<lastName>","<billingAddress>","<cardNumber>","<cardType>","<expiryMonth>","<expiryYear>","<cvvNumber>"
Then User click on Booknow button

Examples:
	|userName|password |location|   hotel      | type | rooms |  indate  | outdate  |adultesperroom|firstName|lastName|billingAddress|   cardNumber   |cardType|expiryMonth|expiryYear|cvvNumber|
	|kpkaviya|kaviya123| Paris  |Hotel Sunshine|Deluxe|1 - One|27/02/2020|28/02/2020|   1 - One    | kaviya  | priya  |  Tambaram    |1009500187470543|  VISA  |    July   |    2022  |  7653   |