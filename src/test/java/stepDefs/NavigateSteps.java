package stepDefs;

import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import utils.Driver;

public class NavigateSteps {

    @When("user navigate to vehicle valuation website {string}")
    public void user_navigate_to_vehicle_valuation_website(String url) {
        WebDriver driver = Driver.getDriver();
        driver.get(url);
    }

    @When("navigate to previous page")
    public void navigate_to_previous_page() {
        WebDriver driver = Driver.getDriver();
        driver.navigate().back();
    }
}
