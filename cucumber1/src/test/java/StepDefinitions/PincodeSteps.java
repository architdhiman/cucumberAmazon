package StepDefinitions;

import org.testng.Assert;

import base.Browser;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.HomePage;

public class PincodeSteps extends Browser {

	HomePage home = new HomePage(driver);

	@Given("user is on the homepage")
	public void user_is_on_the_homepage() {

	Assert.assertTrue(home.checkHomePage());
	}

	@When("User clicks pincode tab")
	public void user_clicks_pincode_tab() {
		System.out.println("pincode fxn");
		home.clickPinTab();
	}

	// ENTERS PINCODE
	@When("User enters {string}")
	public void user_enters(String pincode) {
		home.enterPin(pincode);
	}

	@When("User enters invalid pincode")
	public void user_enters_invalid_pincode() {
		home.enterPin("123456");
	}

	@When("User clicked on submit")
	public void user_clicked_on_submit() {
		home.submitPin();
	}

	@Then("pincode {string} is changed successfully")
	public void pincode_is_changed_successfully(String city) {
		Assert.assertTrue(home.checkCity(city));
	}

	@Then("invalid pincode error is displayed")
	public void invalid_pincode_error_is_displayed() {
		Assert.assertTrue(home.checkPinError());
	}

}
