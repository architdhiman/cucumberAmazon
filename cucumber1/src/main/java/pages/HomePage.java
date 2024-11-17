package pages;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage {
	WebDriver driver;
	WebDriverWait wait;

	public HomePage(WebDriver driver) {
		this.driver = driver;
		System.out.println("homepage constructor");
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	}
	 public boolean checkHomePage() {
		WebElement element = driver.findElement(By.xpath("//*[@id=\"nav-logo-sprites\"]"));
		return true;
	 }
	public void search() {
		WebElement searchBox = driver.findElement(By.id("twotabsearchtextbox"));
		searchBox.sendKeys("iphone 15");
		searchBox.submit();

	}

	public boolean isImagePresent() {
		String xpath = "//img[contains(@src, '71d7rfSl0wL._AC_UY218_.jpg')]";

		WebElement image = driver.findElement(By.xpath(xpath));

		return image.isDisplayed();
	}

	public void clickImage() {
		String xpath = "//img[contains(@src, '71d7rfSl0wL._AC_UY218_.jpg')]";
		WebElement image = driver.findElement(By.xpath(xpath));
		image.click();
	}

	public void clickPinTab() {
		WebElement pincodeTab = driver.findElement(By.id("nav-global-location-popover-link"));

		wait.until(ExpectedConditions.elementToBeClickable(pincodeTab)).click();

	}

	public void enterPin(String pincode) {
		WebElement pinTextBox;
		pinTextBox = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("GLUXZipUpdateInput")));
		pinTextBox.clear();
		pinTextBox.sendKeys(pincode);

	}

	public void submitPin() {
		WebElement submitButton;

		submitButton = driver
				.findElement(By.cssSelector("input.a-button-input[aria-labelledby='GLUXZipUpdate-announce']"));

		submitButton.click();
	}

	public boolean checkCity(String city) {
		boolean cityElement;

		cityElement = wait.until(ExpectedConditions.textToBePresentInElementLocated(
				By.xpath("//span[@class='nav-line-2 nav-progressive-content' and @id='glow-ingress-line2']"), city));

		return cityElement;
	}

	public boolean checkPinError() {
		WebElement errorElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("GLUXZipError")));
		return errorElement.isDisplayed();
	}

}
