package StepDefinitions;

import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class eKYCApprovalStepdefination {
	WebDriver driver;

	@Given("Maker is on Login Page")
	public void maker_is_on_login_page() throws Exception {

		System.setProperty("webdriver.chrome.driver",
				"/Users/ulistech/UlisWorkspace/Ewallie/src/test/resources/DRIVERS/chromedriver");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://wallie.kycadmin.ulis.co.uk/");
		Thread.sleep(2000);

	}

	@When("Maker login with Username and Password")
	public void maker_login_with_username_and_password() {
		WebElement Makerusername = driver.findElement(By.xpath("//input[@id='username']"));
		Makerusername.sendKeys("aditya");

		WebElement Makerpassword = driver.findElement(By.xpath("//input[@id='password']"));
		Makerpassword.sendKeys("Aditya123");
	}

	@And("Maker clicks on Sign me In")
	public void maker_clicks_on_sign_me_in() throws Exception {
		WebElement Signmein = driver.findElement(By.xpath("//button[@id='btnlogin']"));
		Signmein.click();
		Thread.sleep(1000);
	}

	@Then("Maker clicks on the notification Icon")
	public void maker_clicks_on_the_notification_icon() throws Exception {
		Thread.sleep(1000);
		WebElement Makernotification = driver.findElement(By.xpath("//a[@class='dropdown-toggle f-s-14']"));
		Makernotification.click();

	}

	@And("Maker Checks for the Pending eKYC request and Click on the Notification")
	public void maker_checks_for_the_pending_e_kyc_request_and_click_on_the_notification() throws Exception {
		Thread.sleep(1000);
		driver.findElement(By.xpath("//li[@class='dropdown show']//li[2]//a[1]")).click();
		Thread.sleep(1000);

	}

	@Then("Maker is redirected to Customer Apporval Page and View all the details wrt to customer")
	public void maker_is_redirected_to_customer_apporval_page_and_view_all_the_details_wrt_to_customer()
			throws Exception {
		WebElement viewdocs = driver
				.findElement(By.xpath("//summary[normalize-space()='Click here to view Face Comparison Documents']"));
		viewdocs.click();
		Thread.sleep(1000);
		
		WebElement closeviewdocs = driver
				.findElement(By.xpath("//summary[normalize-space()='Click here to view Face Comparison Documents']"));
		closeviewdocs.click();
		
		Thread.sleep(2000);
		WebElement approval = driver.findElement(By.xpath("//tbody/tr[1]/td[4]/label[1]"));
		String Statusbefore=approval.getText();
		System.out.println(Statusbefore);
		Assert.assertEquals("Status is Pending Before Approval", "Pending", Statusbefore);
	}

	@Then("The maker will accept the request if all requirements are met accordingly.")
	public void the_maker_will_accept_the_request_if_all_requirements_are_met_accordingly() {

		WebElement AcceptRequestbutton = driver.findElement(By.xpath("//button[normalize-space()='Accept Request']"));
		AcceptRequestbutton.click();
	}

	@And("Maker select the Industry ISIC Code of Customer and click on Approve")
	public void maker_select_the_industry_isic_code_of_customer_and_click_on_approve() throws Exception {
	/*	WebElement IndustryISICCodedropdown = driver
				.findElement(By.xpath("//span[@id='select2-industry_isic_code-container']"));
		Select select = new Select(IndustryISICCodedropdown);
		select.selectByIndex(1);*/
		JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,500)");
        
        
		
		WebElement dropdown = driver.findElement(By.xpath("//span[@id='select2-industry_isic_code-container']"));
      //  dropdown.click();
     
      //  WebElement targetElement = driver.findElement(By.xpath("/html/body/span/span/span[2]/ul/li[2]/text()"));
              Actions actions = new Actions(driver);
              System.out.println(1111111);              

                actions.sendKeys(dropdown, Keys.ARROW_DOWN).perform();
                Thread.sleep(2000);
                System.out.println(22222);              

                actions.sendKeys(Keys.ENTER).perform();
System.out.println(333333);              
		

	}

	@Then("Clicking on notfication the Maker Status has changed from Pending to Approved")
	public void clicking_on_notfication_the_maker_status_has_changed_from_pending_to_approved() throws Exception {
		
		
		Thread.sleep(1000);
		WebElement Approvebutton = driver.findElement(By.xpath("//button[normalize-space()='Approve']"));
		Approvebutton.click();
		Thread.sleep(1000);
		Alert alert = driver.switchTo().alert();
		String alertText = alert.getText();
		System.out.println("Alert Text: " + alertText);
		alert.accept();

		Thread.sleep(1000);

	}

	@And("Maker Logout clicking on Profile")
	public void maker_logout_clicking_on_profile() throws Exception {

		WebElement Profile = driver.findElement(By.xpath("//span[normalize-space()='Aditya']"));
		Profile.click();

		Thread.sleep(1000);

		WebElement Logoutbut = driver.findElement(By.xpath("//a[normalize-space()='Logout']"));
		Logoutbut.click();

	}

	@Then("Checker Login with the Username and Password and click on Sign me in")
	public void checker_login_with_the_username_and_password_and_click_on_sign_me_in() throws Exception {
		Thread.sleep(1000);
		WebElement Makerusername = driver.findElement(By.xpath("//input[@id='username']"));
		Makerusername.sendKeys("henary");

		WebElement Makerpassword = driver.findElement(By.xpath("//input[@id='password']"));
		Makerpassword.sendKeys("Tw8Amk9sWDX7");

		Thread.sleep(1000);

		WebElement Signmein = driver.findElement(By.xpath("//button[@id='btnlogin']"));
		Signmein.click();
		Thread.sleep(1000);

	}

	@Then("Checker will be landed on dashboard and clicks on notification")
	public void checker_will_be_landed_on_dashboard_and_clicks_on_notification() throws Exception {
		WebElement Makernotification = driver.findElement(By.xpath("//a[@class='dropdown-toggle f-s-14']"));
		Makernotification.click();

		Thread.sleep(1000);
		driver.findElement(By.xpath("//li[@class='dropdown show']//li[2]//a[1]")).click();
		Thread.sleep(1000);

	}

	@And("Select the Pending Approval Request")
	public void select_the_pending_approval_request() throws Exception {
		WebElement viewdocs = driver
				.findElement(By.xpath("//summary[normalize-space()='Click here to view Face Comparison Documents']"));
		viewdocs.click();
		Thread.sleep(1000);
		
		WebElement closeviewdocs = driver
				.findElement(By.xpath("//summary[normalize-space()='Click here to view Face Comparison Documents']"));
		closeviewdocs.click();
		
		Thread.sleep(1000);

		WebElement eapproval = driver.findElement(By.xpath("//tbody/tr[1]/td[4]/label[1]"));
		String Statusafter=eapproval.getText();
		System.out.println(Statusafter);
		Assert.assertEquals("Status After Approval", "Approved", Statusafter);
	}

	@Then("Checker is redirected to customer Approval and click on Accept Request")
	public void checker_is_redirected_to_customer_approval_and_click_on_accept_request() throws Exception {
		
		Thread.sleep(1000);
		WebElement AcceptRequestbutton = driver.findElement(By.xpath("//button[normalize-space()='Accept Request']"));
		AcceptRequestbutton.click();
		Thread.sleep(1000);

	}

	@And("Checker Select Industry ISIC Code and click on approve or deny.")
	public void checker_select_industry_isic_code_and_click_on_approve_or_deny() throws Exception {
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,500)");
        
        
		
		WebElement dropdown = driver.findElement(By.xpath("//span[@id='select2-industry_isic_code-container']"));
      //  dropdown.click();
     
      //  WebElement targetElement = driver.findElement(By.xpath("/html/body/span/span/span[2]/ul/li[2]/text()"));
              Actions actions = new Actions(driver);

                actions.sendKeys(dropdown, Keys.ARROW_DOWN).perform();
                Thread.sleep(2000);

                actions.sendKeys(Keys.ENTER).perform();
		

                Thread.sleep(2000);
		WebElement Approvebutton = driver.findElement(By.xpath("//button[normalize-space()='Approve']"));
		Approvebutton.click();
		Thread.sleep(1000);

	}

	@Then("Alert Popup is displayed and click on OK.")
	public void alert_popup_is_displayed_and_click_on_ok() throws Exception {

		Alert alert = driver.switchTo().alert();
		String alertText = alert.getText();
		System.out.println("Alert Text: " + alertText);
		alert.accept();

		Thread.sleep(1000);

	}

	@Then("Checker is redirected to customer approval table and now the final status is changed to Approved for the concer customer")
	public void checker_is_redirected_to_customer_approval_table_and_now_the_final_status_is_changed_to_approved_for_the_concer_customer()
			throws Exception {

		WebElement Nextbuttontable = driver.findElement(By.xpath("//a[normalize-space()='Next']"));
		Nextbuttontable.click();

		Thread.sleep(1000);

		WebElement Finalstatus = driver.findElement(By.xpath("//tbody/tr[8]/td[5]"));
		String Finalstatustext = Finalstatus.getText();
		System.out.println(Finalstatustext);

	}

	@And("Checker clicks on Profile and Logout.")
	public void checker_clicks_on_profile_and_logout() throws Exception {

		WebElement Profile = driver.findElement(By.xpath("//span[normalize-space()='henary']]"));
		Profile.click();

		Thread.sleep(1000);

		WebElement Logoutbut = driver.findElement(By.xpath("//a[normalize-space()='Logout']"));
		Logoutbut.click();
	}

}
