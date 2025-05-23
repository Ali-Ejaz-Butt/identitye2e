package stepDefs;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import utils.Driver;

public class Hooks {

    @Before
    public void setup() {
        Driver.initDriver();
    }

    @After
    public void teardown() {
        Driver.quitDriver();
    }
}
