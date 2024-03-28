Feature: Ewallie Customer SignUP

  Scenario Outline: Signup Customer
    Given Customer is on the Home Page
    When Customer clicks on SignUp/Login
    Then Customer enter the Mobile no. to Register with
    And Customer clicks on Proceed button
    Then Customer enters the received OTP On the Registred Mobile number
    Then Customer Checks the termsandcondition and click on signup
    Then Customer will land on the Dashboard and user logout