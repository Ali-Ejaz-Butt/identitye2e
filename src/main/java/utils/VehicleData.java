package utils;

public class VehicleData {
    public String variantReg;
    public String make;
    public String model;
    public String year;

    public VehicleData(String variantReg, String make, String model, String year) {
        this.variantReg = variantReg;
        this.make = make;
        this.model = model;
        this.year = year;
    }

    public String getVariantReg() {return variantReg;}
    public String getMake() {return make;}
    public String getModel() {return model;}
    public String getYear() {return year;}
}
