package pages;

import Base.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class VehicleValuationHomePage extends BasePage {

    @FindBy(id = "subForm1")
    private WebElement enterReg;

    @FindBy(xpath = "//*[@type='submit']")
    private WebElement checkNowButton;

    @FindBy(xpath = "//*[@class='navbar-brand']")
    private WebElement carCheckingNavbarLogo;

    @FindBy(xpath = "//*[@class='alert alert-danger' and contains(text(), 'The license plate number is not recognised')]")
    private WebElement regNumberNotRecognizedError;

    public VehicleValuationHomePage() {
        super();
    }

    public boolean isCarCheckingNavbarLogoDisplayed() {
        return waitForElementToBeVisible(carCheckingNavbarLogo);
    }

    public String getPageTitle() {
        return driver.getTitle();
    }

    public void enterReg(String reg) {
        if (waitForElementToBeVisible(enterReg)) {
            enterReg.sendKeys(reg);
        }
    }

    public void clickCheckNowButton() {
        if (waitForElementToBeVisible(checkNowButton)) {
            checkNowButton.click();
        }
    }

    public boolean isVehicleRegistrationNotRecognisedErrorDisplayed() {
        return waitForElementToBeVisible(regNumberNotRecognizedError);
    }

    public void searchByVehicleRegistrationNumber(String vehicleRegistrationNumber) {
        enterReg(vehicleRegistrationNumber);
        clickCheckNowButton();
    }
}
