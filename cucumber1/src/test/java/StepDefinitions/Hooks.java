package StepDefinitions;

import base.Browser;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;

public class Hooks extends Browser {

    @Before
    public void setup() {
        System.out.println("Before test setup");
        System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\architdhiman\\Downloads\\chromedriver-win641\\chromedriver-win64\\chromedriver.exe"); // Automatically sets up the ChromeDriver
        driver = new ChromeDriver();
        driver.get("https://www.amazon.in/");
        driver.manage().window().maximize();
    }

    @After
    public void cleanUp() {
        if (driver != null) {
            driver.close();
        }
    }
}
