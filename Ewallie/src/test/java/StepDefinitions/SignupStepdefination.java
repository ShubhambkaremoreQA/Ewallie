package StepDefinitions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class SignupStepdefination {
	WebDriver driver;
	@Given("Customer is on the Home Page")
	public void customer_is_on_the_home_page() throws Exception {
		System.setProperty("webdriver.chrome.driver",
				"/Users/ulistech/UlisWorkspace/Ewallie/src/test/resources/DRIVERS/chromedriver");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://ulis.co.uk/Development/ULIS/eWallet2022/portal/?");
		Thread.sleep(2000);
	}

	@When("Customer clicks on SignUp\\/Login")
	public void customer_clicks_on_sign_up_login() {
		 Actions actions = new Actions(driver);

	        // Example of performing mouse hover action
	        WebElement elementToHover = driver.findElement(By.xpath("//*[contains(text(),'  Sign Up/ Login ')]"));
	        actions.moveToElement(elementToHover).perform();

	        // Example of performing right click action
	        WebElement elementToRightClick = driver.findElement(By.xpath("//*[contains(text(),'  Sign Up/ Login ')]"));
	        actions.click(elementToRightClick).perform();
 
	}

	@Then("Customer enter the Mobile no. to Register with")
	public void customer_enter_the_mobile_no_to_register_with() {
	WebElement	Mobilenumber=driver.findElement(By.id("mobile"));
	Mobilenumber.sendKeys("0473833486");
	}

	@And("Customer clicks on Proceed button")
	public void customer_clicks_on_proceed_button() throws Exception {
		WebElement Proceedbutton=driver.findElement(By.xpath("/html/body/div[8]/div/div/form[1]/div[2]/div[2]/div/div/div/div/div[2]/button[1]"));
		Proceedbutton.click();
		Thread.sleep(2000);
	
	}

	@Then("Customer enters the received OTP On the Registred Mobile number")
	public void customer_enters_the_received_otp_on_the_registred_mobile_number() throws InterruptedException {
	Thread.sleep(1000);
		WebElement ReceivedOTP=driver.findElement(By.xpath("//input[@id='signup_otp']"));
	ReceivedOTP.sendKeys("123456");
	Thread.sleep(1000);
	}

	@Then("Customer Checks the termsandcondition and click on signup")
	public void Customer_Checks_the_termsandcondition_and_click_on_signup() throws Exception {
	WebElement termscondition=driver.findElement(By.id("term_condition"));
	termscondition.click();
	Thread.sleep(1000);
	WebElement signup=driver.findElement(By.xpath("//*[@id=\"div_btn_3\"]/button"));
	signup.click();
	Thread.sleep(1000);
	
	}

	@Then("Customer will land on the Dashboard and user logout")
	public void customer_will_land_on_the_dashboard_and_user_logout() throws Exception {
	WebElement Logo	= driver.findElement(By.xpath("//a[@title='QVWi Pay']//img[@alt='ULIS Technology']"));
     String Logotext =	Logo.getText();
       System.out.println(Logotext);
       
    Thread.sleep(1000);
    
WebElement Skip = driver.findElement(By.xpath("/html/body/div[27]/div/div/form[1]/div[1]/a/span"));
 Skip.click();
 Thread.sleep(1000);
 WebElement Logout = driver.findElement(By.xpath("/html/body/header[2]/div/div/div[2]/nav/div/ul/li[6]/a"));
 Logout.click();
      
		
	  
	}



}
