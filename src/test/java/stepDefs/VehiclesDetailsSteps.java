package stepDefs;

import context.TestContext;
import io.cucumber.java.en.Given;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;
import pages.VehicleReportPage;
import pages.VehicleValuationHomePage;
import utils.FileReader;
import utils.VehicleData;

import java.util.List;
import java.util.Map;

public class VehiclesDetailsSteps {
    private final TestContext testContext;

    public VehiclesDetailsSteps(TestContext testContext) {
        this.testContext = testContext;
    }

    @Given("user verifies vehicle details from file {string}")
    public void user_verifies_vehicle_details_from_file(String fileName) {
        SoftAssert softAssert = new SoftAssert();
        VehicleValuationHomePage vehicleValuationHomePage = new VehicleValuationHomePage();
        VehicleReportPage vehicleReportPage = new VehicleReportPage();
        NavigateSteps navigateSteps = new NavigateSteps();

        //Get all the saved vehicle registration numbers from input file
        List<String> vehicleRegistrationNumbers = testContext.getExtractedVehicleRegistrationNumbers();

        //Load expected vehicle data from output file
        Map<String, VehicleData> vehicles = FileReader.getVehicleData("src/test/resources/" + fileName);
        Assert.assertFalse(vehicles.isEmpty(), "No vehicles found in file " + fileName);

        //Verifying each vehicle's details on the car-checking valuation page
        for (String vehicleRegistrationNumber : vehicleRegistrationNumbers) {
            //Search for vehicle registration number
            vehicleValuationHomePage.searchByVehicleRegistrationNumber(vehicleRegistrationNumber);

            //Verifying if searched vehicle registration number is valid or not.
            if (vehicleValuationHomePage.isVehicleRegistrationNotRecognisedErrorDisplayed()) {
                //Soft Assert used so it doesn't fail straightaway
                softAssert.fail(vehicleRegistrationNumber + " is not recognised");
            } else {
                //Validate user is on the vehicle report page after search
                Assert.assertTrue(vehicleReportPage.verifyVehicleReportPageDisplayed(), "Fail to navigate to vehicle report page");

                //Get expected vehicle details from output file
                VehicleData expectedVehicleData = vehicles.get(vehicleRegistrationNumber.replace(" ", ""));
                Assert.assertNotNull(expectedVehicleData, "");

                String actualVehicleRegistrationNumber = vehicleReportPage.getVehicleRegistrationNumber();
                String actualVehicleMake = vehicleReportPage.getVehicleMake();
                String actualVehicleModel = vehicleReportPage.getVehicleModel();
                String actualVehicleYear = vehicleReportPage.getVehicleYear();

                //User soft assertion to continue testing all vehicles even if some checks fail
                softAssert.assertEquals(actualVehicleRegistrationNumber.replace(" ", ""), expectedVehicleData.variantReg.replace(" ", ""), "Registration number not matched for vehicle reg:  " + actualVehicleRegistrationNumber);
                softAssert.assertEquals(actualVehicleMake, expectedVehicleData.make, "Make not matched for vehicle reg: " + actualVehicleMake);
                softAssert.assertEquals(actualVehicleModel, expectedVehicleData.model, "Model not matched for vehicle reg:  " + actualVehicleModel);
                softAssert.assertEquals(actualVehicleYear, expectedVehicleData.year, "Year not matched for vehicle reg: " + actualVehicleYear);

                vehicleReportPage.backToHomePage();
            }
        }
        //Collected soft assertion failures
        softAssert.assertAll();
    }
}
