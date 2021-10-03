package stepdefinitions;

import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.BorrowingCalculatorPage;

public class BorrowingCalculatorSteps {

	WebDriver driver = null;
	BorrowingCalculatorPage bp;


	public void loadBrowser() {
		System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/chromedriver");
		driver = new ChromeDriver();
		bp = new BorrowingCalculatorPage(driver);
		driver.manage().window().maximize();

	}


	@Given("I am a user trying to understand ‘How much can I borrow’ using home loan calculator page of ANZ")
	public void i_am_a_user_trying_to_understand_how_much_can_i_borrow_using_home_loan_calculator_page_of_anz() {
		System.out.println("in main page");	
		loadBrowser();
		driver.get("https://www.anz.com.au/personal/home-loans/calculators-tools/much-borrow/");
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);

	}

	@Given("I have entered relevant information in each required field Single , {string} , live in , {string} , {string} , {string} , {string} , {string} , {string} , {string}")
	public void i_have_entered_relevant_information_in_each_required_single_live_in(String dependents,String income, String otherincome, String expenses, String currentrepayments, String otherrepayments, String commitments, String creditcardlimits) {

		bp.setIncome(income);
		bp.setOtherincome(otherincome);
		bp.setLivingexpenses(expenses);
		bp.setCurrentrepayments(currentrepayments);
		bp.setOtherrepayments(otherrepayments);
		bp.setCommitments(commitments);
		bp.setCreditcardlimits(creditcardlimits);
	}

	@When("I click on ‘Workout how much I could borrow’ button")
	public void i_click_on_workout_how_much_i_could_borrow_button() {
		System.out.println("clicks");
		bp.clickBorrowestimate();
	}

	@Then("I should see the borrowing estimate displayed as {string}")
	public void i_should_see_the_borrowing_estimate_displayed_as(String string) {
		System.out.println("Vlaidates");
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.findElement(By.id("borrowResultTextAmount")).getText();
		System.out.println(driver.findElement(By.id("borrowResultTextAmount")).getText());
		Assert.assertEquals(string, driver.findElement(By.id("borrowResultTextAmount")).getText());
		driver.close();

	}

	@Given("I have entered relevant information in each required field {string} , {string} , {string} , {string} , {string} , {string} , {string}")
	public void i_have_entered_relevant_information_in_each_required_field(String income, String otherincome, String expenses, String currentrepayments, String otherrepayments, String commitments, String creditcardlimits) {
		bp.setIncome(income);
		bp.setOtherincome(otherincome);
		bp.setLivingexpenses(expenses);
		bp.setCurrentrepayments(currentrepayments);
		bp.setOtherrepayments(otherrepayments);
		bp.setCommitments(commitments);
		bp.setCreditcardlimits(creditcardlimits);
	}
	@Given("I can see the result as per the data entered")
	public void i_can_see_the_result_as_per_the_data_entered() {
		bp.clickBorrowestimate();
		Assert.assertEquals(true, driver.findElement(By.id("borrowResultTextAmount")).isDisplayed());
	}
	@When("I click on ‘Start over’ button")
	public void i_click_on_start_over_button() {
		bp.clickStartoverButton();
	}
	@Then("I should see all the data I entered is cleared and the page is refreshed with fields being sets their default values {string}, {string} , {string} , {string} , {string} , {string} , {string} , {string} , {string} , {string}")
	public void i_should_see_all_the_data_i_entered_is_cleared_and_the_page_is_refreshed_with_fields_being_sets_their_default_values(String applicationtype, String dependents, String buyinghometo, String income, String otherincome, String expenses, String currentrepayments, String otherrepayments, String commitments, String creditlimits) {
		Assert.assertEquals(income, bp.getIncome());
		Assert.assertEquals(otherincome, bp.getOtherincome());
		Assert.assertEquals(expenses, bp.getLivingexpenses());
		Assert.assertEquals(currentrepayments, bp.getCurrentrepayments());
		Assert.assertEquals(otherrepayments, bp.getOtherrepayments());
		Assert.assertEquals(commitments, bp.getCommitments());
		Assert.assertEquals(creditlimits, bp.getCreditcardlimits());
		driver.close();
	}

	@Given("I have entered Living expenses as {string}")
	public void i_have_entered_living_expenses_as(String expenses) {
		bp.setLivingexpenses(expenses);
	}
	@Given("leave all other fields to their default values")
	public void leave_all_other_fields_to_their_default_values() {

	}
	@When("I click on the ‘Workout how much I could borrow’ button")
	public void i_click_on_the_workout_how_much_i_could_borrow_button() {
		bp.clickBorrowestimate();
	}
	@Then("I should see the message  {string}")
	public void i_should_see_the_message(String string) {
		Assert.assertEquals(string, bp.getErrormessage());
		//driver.quit();
		driver.close();
		driver.quit();
	}
	

}
