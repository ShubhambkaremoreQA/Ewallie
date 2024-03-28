Feature: 
  eKYC Approval Process

  Scenario Outline: 
    After successfull Onboarding Customer eKYC Approval Starts

    Given Maker is on Login Page
    When Maker login with Username and Password
    And Maker clicks on Sign me In
    Then Maker clicks on the notification Icon
    And Maker Checks for the Pending eKYC request and Click on the Notification
    Then Maker is redirected to Customer Apporval Page and View all the details wrt to customer
    Then The maker will accept the request if all requirements are met accordingly.
    And Maker select the Industry ISIC Code of Customer and click on Approve
    Then Clicking on notfication the Maker Status has changed from Pending to Approved
    And Maker Logout clicking on Profile
    Then Checker Login with the Username and Password and click on Sign me in
    Then Checker will be landed on dashboard and clicks on notification
    And Select the Pending Approval Request
    Then Checker is redirected to customer Approval and click on Accept Request
    And Checker Select Industry ISIC Code and click on approve or deny.
    Then Alert Popup is displayed and click on OK.
    Then Checker is redirected to customer approval table and now the final status is changed to Approved for the concer customer
    And Checker clicks on Profile and Logout.