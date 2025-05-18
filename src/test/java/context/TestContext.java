package context;

import java.util.ArrayList;
import java.util.List;

public class TestContext {
    private List<String> extractedVehicleRegistrationNumbers = new ArrayList<>();

    public List<String> getExtractedVehicleRegistrationNumbers() {
        return extractedVehicleRegistrationNumbers;
    }

    public void setExtractedVehicleRegistrationNumbers(List<String> extractedVehicleRegistrationNumbers) {
        this.extractedVehicleRegistrationNumbers = extractedVehicleRegistrationNumbers;
    }
}
