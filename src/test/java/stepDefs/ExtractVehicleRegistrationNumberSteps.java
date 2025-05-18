package stepDefs;

import context.TestContext;
import io.cucumber.java.en.Given;
import utils.ExtractPattern;
import utils.FileReader;
import java.util.List;

public class ExtractVehicleRegistrationNumberSteps {

    private final TestContext testContext;

    public ExtractVehicleRegistrationNumberSteps(TestContext testContext) {
        this.testContext = testContext;
    }

    @Given("extract all vehicle registration numbers present in {string} file")
    public void extract_all_vehicle_registration_numbers_present_in_file(String fileName) {
        List<String> lines = FileReader.readFile(fileName);
        String vehicleRegistrationNumberRegex = "[A-Z]{2}[0-9]{2}\\s?[A-Z]{3}";
        List<String> vehicleRegistrationNumbers = ExtractPattern.extractVehicleRegistrationPattern(lines, vehicleRegistrationNumberRegex);
        testContext.setExtractedVehicleRegistrationNumbers(vehicleRegistrationNumbers);
    }
}
