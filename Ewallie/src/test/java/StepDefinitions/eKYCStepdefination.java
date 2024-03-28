package StepDefinitions;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class eKYCStepdefination {
	WebDriver driver;

	@Given("Customer is on Login Page and Signing In")
	public void customer_is_on_login_page_and_signing_in() throws Exception {
		System.setProperty("webdriver.chrome.driver",
				"/Users/ulistech/UlisWorkspace/Ewallie/src/test/resources/DRIVERS/chromedriver");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://ulis.co.uk/Development/ULIS/eWallet2022/portal/?");
		Thread.sleep(2000);
	}

	@When("Customer Entres Registred Mobile Number and click on Procced button")
	public void customer_entres_registred_mobile_number_and_click_on_procced_button() throws Exception {
		Actions actions = new Actions(driver);

		// Example of performing mouse hover action
		WebElement elementToHover = driver.findElement(By.xpath("//*[contains(text(),'  Sign Up/ Login ')]"));
		actions.moveToElement(elementToHover).perform();

		// Example of performing right click action
		WebElement elementToRightClick = driver.findElement(By.xpath("//*[contains(text(),'  Sign Up/ Login ')]"));
		actions.click(elementToRightClick).perform();

		WebElement Mobilenumber = driver.findElement(By.id("mobile"));
		Mobilenumber.sendKeys("0473833486");

		WebElement Proceedbutton = driver.findElement(
				By.xpath("/html/body/div[8]/div/div/form[1]/div[2]/div[2]/div/div/div/div/div[2]/button[1]"));
		Proceedbutton.click();
		Thread.sleep(2000);
	}

	@Then("Customer enter the reccieved OTP and click on login buttom")
	public void customer_enter_the_reccieved_otp_and_click_on_login_buttom() throws InterruptedException {
		WebElement OTP = driver.findElement(By.xpath("//input[@id='login_otp']"));
		OTP.sendKeys("123456");

		WebElement Loginbutton = driver.findElement(By.xpath("//button[normalize-space()='Login']"));
		Loginbutton.click();
		Thread.sleep(3000);

	}

	@Then("Customer click on My profile and then clicks on Complete your eKYC")
	public void customer_click_on_my_profile_and_then_clicks_on_complete_your_e_kyc() throws Exception {
		WebElement Skip = driver.findElement(By.xpath("//a//span[contains(@class, 'text-muted')][text() = 'Skip']"));
		Skip.click();
		Thread.sleep(1000);
		Actions actions = new Actions(driver);

		// Example of performing mouse hover action
		WebElement elementToHover = driver.findElement(By.xpath("//a[normalize-space()='My Profile']"));
		actions.moveToElement(elementToHover).perform();

		// Example of performing right click action
		WebElement elementToRightClick = driver.findElement(By.xpath("//a[normalize-space()='My Profile']"));
		actions.click(elementToRightClick).perform();

		Thread.sleep(1000);

		WebElement Completeyourekycbutton = driver.findElement(By.xpath("//a[normalize-space()='Complete your eKYC']"));
		Completeyourekycbutton.click();

	}

	@Then("The customer fills all the. Mandatory field and click on the Proceed button")
	public void the_customer_fills_all_the_mandatory_field_and_click_on_the_proceed_button() throws Exception {

		WebElement Firstname = driver.findElement(By.xpath("//div[@class='col-sm-3']//input[@id='first_name']"));
		Firstname.sendKeys("Utkarsha");

		WebElement Middlename = driver.findElement(By.xpath("//div[@class='col-sm-3']//input[@id='middle_name']"));
		Middlename.sendKeys("B");

		WebElement Lastname = driver.findElement(By.xpath("//div[@class='col-sm-3']//input[@id='last_name']"));
		Lastname.sendKeys("Patil");

		WebElement Gender = driver.findElement(By.xpath("//div[@class='col-sm-3']//select[@id='gender']"));
		Select select = new Select(Gender);
		select.selectByVisibleText("Female");

		WebElement Email = driver.findElement(By.xpath("//div[@class='col-sm-3']//input[@id='signup_email']"));
		Email.sendKeys("utkarsha.bp@yopmail.com");

		WebElement EID = driver.findElement(By.xpath("//input[@id='id_document_number']"));
		EID.sendKeys("784198012345679");

		Thread.sleep(1000);
		try {
			// Switch to the alert
			Alert alert = driver.switchTo().alert();

			alert.accept();

			String alertText = alert.getText();
			System.out.println("Alert Text: " + alertText);
		} catch (NoAlertPresentException e) {

		}

		WebElement Expirydate = driver.findElement(By.xpath("//input[@id='id_expiry_date']"));
		Expirydate.click();

		int numberOfClicks = 3;

		for (int i = 0; i < numberOfClicks; i++) {

			WebElement Nextmonth = driver
					.findElement(By.xpath("//div[@class='datepicker-days']//th[@class='next'][normalize-space()='»']"));
			Nextmonth.click();
		}
		WebElement Selectdate = driver.findElement(By.xpath("//td[normalize-space()='19']"));
		Selectdate.click();

		WebElement Password = driver.findElement(By.xpath("//div[@id='approval_1']//input[@id='password_update']"));
		Password.sendKeys("Test@123");

		Thread.sleep(2000);

		WebElement ConfirmPassword = driver
				.findElement(By.xpath("//div[@id='approval_1']//input[@id='re_password_update']"));
		ConfirmPassword.sendKeys("Test@123");

		WebElement TransactionPin = driver
				.findElement(By.xpath("//div[@id='approval_1']//input[@id='new_pin_update']"));
		TransactionPin.sendKeys("123456");

		WebElement ConfirmTransactionPin = driver
				.findElement(By.xpath("//div[@id='approval_1']//input[@id='re_pin_update']"));
		ConfirmTransactionPin.sendKeys("123456");

		WebElement Proceedbutton = driver.findElement(By.xpath("//button[@class='round btn btn-primary mt-3']"));
		Proceedbutton.click();

		Thread.sleep(2000);
	}

	@Then("Customer Upload his EID and Click on Proceed button")
	public void customer_upload_his_eid_and_click_on_proceed_button() throws Exception {

		WebElement frontimageInputfront = driver
				.findElement(By.xpath("//div[@class='col-sm-4 text-center']//input[@id='civil_id_file']"));
		String filePath = "/Users/ulistech/Documents/Screenshot at Mar 14 15-48-12.png";
		frontimageInputfront.sendKeys(filePath);

		Thread.sleep(2000);

		WebElement backimageInputfront = driver
				.findElement(By.xpath("//div[@class='col-sm-4 text-center']//input[@id='civil_id_file_back']"));
		// String filePath = "/Users/ulistech/Documents/Screenshot at Mar 14
		// 15-48-12.png";
		backimageInputfront.sendKeys(filePath);

		Thread.sleep(2000);

		WebElement Procedb = driver
				.findElement(By.xpath("//button[@class='btn btn-primary'][normalize-space()='Proceed']"));
		Procedb.click();
	}

	@Then("Customer capture its selfie and click on submit button")
	public void customer_capture_its_selfie_and_click_on_submit_button() throws Exception {
		Thread.sleep(1000);

		WebElement takeselfie = driver.findElement(By.xpath("//button[@id='selfy_btn_selfie']"));
		takeselfie.click();

		Thread.sleep(2000);

		WebElement Submitb = driver
				.findElement(By.xpath("//button[@class='btn btn-primary'][normalize-space()='Submit']"));
		Submitb.click();

		Thread.sleep(2000);
	}

	@Then("Customer eKYC status changes from Incomplete to Advanced Resident")
	public void customer_e_kyc_status_changes_from_incomplete_to_advanced_resident() throws Exception {
		Thread.sleep(2000);
		Actions actions = new Actions(driver);

		WebElement eKYCupdate = driver
				.findElement(By.xpath("//font[normalize-space()='KYC Status : Advanced Resident']"));
		actions.moveToElement(eKYCupdate).perform();
		String eKYCstatus = eKYCupdate.getText();
		System.out.println(eKYCstatus);
	}

}
