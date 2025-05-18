package stepDefs;

import io.cucumber.java.en.Then;
import org.testng.Assert;
import pages.VehicleValuationHomePage;

public class VehicleHomePageSteps {

    VehicleValuationHomePage vehicleValuationHomePage = new VehicleValuationHomePage();

    @Then("user should be on the car checking homepage")
    public void user_should_be_on_the_car_checking_homepage() {
        Assert.assertTrue(vehicleValuationHomePage.isCarCheckingNavbarLogoDisplayed() &&
                        vehicleValuationHomePage.getPageTitle().equals("Vehicle check - Check Your Car's History Online - Car Checking"),
                "Fail to load the car-checking home page");
    }

}
