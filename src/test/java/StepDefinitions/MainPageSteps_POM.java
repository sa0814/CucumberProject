package StepDefinitions;

import static org.junit.Assert.assertTrue;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.mainPage;


public class MainPageSteps_POM {

	WebDriver driver = null;
	mainPage main;
	private List<String> dataValues;

	@Before("browser is open")
	public void browser_is_open() {

		System.out.println("  ===  I am inside the step definition file  ===== ");

		System.out.println("Inside Step - browser is open");

		String projectPath = System.getProperty("user.dir");
		System.out.println("Project path is : " + projectPath);

		System.setProperty("webdriver.chromedriver", projectPath + "/src/test/resources/drivers/chromedriver1.exe");

		driver = new ChromeDriver();

		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);

		// driver.manage().window().maximize();

	}

	@Given ("I browse to website")
	public void user_is_on_main_page() {

		driver.navigate().to("https://www.exercise1.com/values");
		main = new mainPage(driver);
	}

	@Then("I verify the correct values appear on the screen")
	public void verifyTheCountOfValues() {
		assertTrue(dataValues.size()==5);
	}

	@When("^user enters (.*), (.*), (.*), (.*) and (.*)$")
	public void user_enters_values(String val1, String val2, String val3, String val4, String val5)
			throws InterruptedException {

		dataValues.add(val1);
		dataValues.add(val2);
		dataValues.add(val3);
		dataValues.add(val4);
		dataValues.add(val5);
		main.enterValues(val1, val2, val3, val4, val5);

		Thread.sleep(2000);
	}

	@Then("I verify on of the values on the screen are greater than zero")
	public void verifynonzerovalues() {

		for (Float i : main.getInputValues()) {

			assertTrue((i) > 0);
			Assert.fail("Value is not greater than zero");

		}

	}



	@Then("I verify the total balance matches sum of the values")
	public void IverifytotalbalanceValue() {
		Float givenTotal = Float.parseFloat(main.getTotalBalance().substring(1));
		assertTrue(main.checkTotalSum() - givenTotal == 0);
	}

	@Then("I verify the currency format")
	public void Verifyifthevalueshavecorrectformat() throws InterruptedException {

		for (String i : dataValues) {
			assertTrue(main.CheckCurrency(i) == true);

		}

	}

	@After("Close the browser")
	public void teardown() {
		driver.close();
	}

}
