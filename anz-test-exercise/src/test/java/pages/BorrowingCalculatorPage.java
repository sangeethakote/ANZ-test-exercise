package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class BorrowingCalculatorPage {

	WebDriver driver;
	By t_income = By.xpath("//div/input[@aria-labelledby='q2q1']");
	By t_otherincome = By.xpath("//div/input[@aria-labelledby='q2q2']");
	By t_expenses = By.id("expenses");
	By t_homelones = By.id("homeloans");
	By t_otherloans = By.id("otherloans");
	By t_commitments = By.xpath("//div/input[@aria-labelledby='q3q4']");
	By t_credit = By.id("credit");
	By t_borrowestimate = By.id("btnBorrowCalculater");
	By t_startoverbutton = By.xpath("//div/button[@aria-label='Start over']");
	By t_borrowerrortext = By.xpath("//div/span[@class='borrow__error__text']");
	

	public BorrowingCalculatorPage(WebDriver driver) {
		this.driver = driver;
	}

	public void setIncome(String incomes){
		System.out.println("inside setincome");
		driver.findElement(t_income).sendKeys(incomes);

	}
	public void setOtherincome(String otherincome){

		driver.findElement(t_otherincome).sendKeys(otherincome);

	}
	public void setLivingexpenses(String livingexpenses){

		driver.findElement(t_expenses).sendKeys(livingexpenses);

	}
	public void setCurrentrepayments(String currentpayments){

		driver.findElement(t_homelones).sendKeys(currentpayments);

	}
	public void setOtherrepayments(String otherpayments){

		driver.findElement(t_otherloans).sendKeys(otherpayments);

	}
	public void setCommitments(String commitments){

		driver.findElement(t_commitments).sendKeys(commitments);

	}
	public void setCreditcardlimits(String creditcardlimits){

		driver.findElement(t_credit).sendKeys(creditcardlimits);

	}
	public void clickBorrowestimate(){

		driver.findElement(t_borrowestimate).click();

	}
	
	public void clickStartoverButton(){

		driver.findElement(t_startoverbutton).click();

	}
	
	public String getIncome(){
		
		return driver.findElement(t_income).getAttribute("value");

	}
	public String getOtherincome(){

		return driver.findElement(t_otherincome).getAttribute("value");

	}
	public String getLivingexpenses(){

		return driver.findElement(t_expenses).getAttribute("value");

	}
	public String getCurrentrepayments(){

		return driver.findElement(t_homelones).getAttribute("value");
		
	}
	public String getOtherrepayments(){

		return driver.findElement(t_otherloans).getAttribute("value");

	}
	public String getCommitments(){

		return driver.findElement(t_commitments).getAttribute("value");

	}
	public String getCreditcardlimits(){

		return driver.findElement(t_credit).getAttribute("value");

	}
	
	public String getErrormessage() {
		return driver.findElement(t_borrowerrortext).getText();
	}


}
