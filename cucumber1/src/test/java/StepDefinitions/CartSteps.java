package StepDefinitions;

import org.testng.Assert;

import base.Browser;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.CartPage;
import pages.HomePage;
import pages.ProductPage;

public class CartSteps extends Browser {
	HomePage home = new HomePage(driver);
	ProductPage product = new ProductPage(driver);
	CartPage cart = new CartPage(driver);

	@Given("user is at the homepage")
	public void user_is_at_the_homepage() {
		Assert.assertTrue(home.checkHomePage());

	}

	@When("User searches the product")
	public void user_searches_the_product() {
		home.search();
	}

	@When("User clicks on the product")
	public void user_clicks_on_the_product() {
		home.clickImage();
		product.switchTab();
	}

	@When("User clicks add to cart button")
	public void user_clicks_add_to_cart_button() {
		product.addToCart();
		product.openCart();
	}

	@Then("the product gets added to the cart successfully")
	public void the_product_gets_added_to_the_cart_successfully() {
		Assert.assertTrue(cart.checkCart("Apple iPhone 15 (128 GB) - Blue"));
	}

	@Given("User is at the cart page with a product")
	public void user_is_at_the_cart_page_with_a_product() {
		Assert.assertTrue(cart.checkCart("Apple iPhone 15 (128 GB) - Blue"));
	}

	@When("User clicks on delete button")
	public void user_clicks_on_delete_button() {
		cart.deleteFromCart();
	}

	@Then("the product is removed from the cart successfully")
	public void the_product_is_removed_from_the_cart_successfully() {
		Assert.assertTrue(cart.checkEmptyCart());
	}

}
