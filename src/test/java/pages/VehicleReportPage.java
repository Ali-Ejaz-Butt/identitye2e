package pages;

import Base.BasePage;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class VehicleReportPage extends BasePage {

    @FindBy(xpath = "//*[@class='report-header']")
    private WebElement vehicleReportHeader;

    @FindBy(id = "subForm")
    private WebElement vehicleReg;

    @FindBy(xpath = "//*[@class='m-1' and text()='HOME']")
    private WebElement homeButton;

    @FindBy(xpath = "//*[@class='general-information']//td[@class='td-left' and text()='Make']/..//td[@class='td-right']")
    private WebElement vehicleMake;

    @FindBy(xpath = "//*[@class='general-information']//td[@class='td-left' and text()='Model']/..//td[@class='td-right']")
    private WebElement vehicleModel;

    @FindBy(xpath = "//*[@class='general-information']//td[@class='td-left' and text()='Year of manufacture']/..//td[@class='td-right']")
    private WebElement vehicleYear;

    public VehicleReportPage() {
        super();
    }

    public boolean isVehicleReportPageHeaderDisplayed() {
        return waitForElementToBeVisible(vehicleReportHeader);
    }

    public String getPageTitle() {
        return driver.getTitle();
    }

    public boolean verifyVehicleReportPageDisplayed() {
        return (isVehicleReportPageHeaderDisplayed() && getPageTitle().equals("Car-Checking"));
    }

    public String getVehicleRegistrationNumber() {
        return vehicleReg.getAttribute("value");
    }

    public String getVehicleMake() {
        return vehicleMake.getText();
    }

    public String getVehicleModel() {
        return vehicleModel.getText();
    }

    public String getVehicleYear() {
        return vehicleYear.getText();
    }

    public void backToHomePage() {
        if (waitForElementToBeClickable(homeButton)) {
            homeButton.click();
        } else {
            Assert.fail("Unable to find back to the home page button.");
        }
    }
}
