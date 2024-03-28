Feature: 
  Ewallie eKYC Onboarding

  Scenario Outline: 
    After Signup eKYC Onboarding

    Given Customer is on Login Page and Signing In
    When Customer Entres Registred Mobile Number and click on Procced button
    Then Customer enter the reccieved OTP and click on login buttom
    Then Customer click on My profile and then clicks on Complete your eKYC
    Then The customer fills all the. Mandatory field and click on the Proceed button
    Then Customer Upload his EID and Click on Proceed button
    Then Customer capture its selfie and click on submit button
    Then Customer eKYC status changes from Incomplete to Advanced Resident
