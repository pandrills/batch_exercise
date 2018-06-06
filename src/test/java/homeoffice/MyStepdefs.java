package homeoffice;

import cucumber.api.java.en.*;
import homeoffice.page_factory.read_vehicle_reg_detailsPage;
import org.springframework.util.Assert;

/**
 * Created by musti on 06/06/2018.
 */
public class MyStepdefs extends DriverInstance{

    read_vehicle_reg_detailsPage rvp = new read_vehicle_reg_detailsPage(driver);

    @Given("^I am on the Get vehicle information from DVLA page$")
    public void iAmOnTheGetVehicleInformationFromDVLAPage() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new cucumber.api.PendingException();
    }
    @When("^I click on Start Now$")
    public void i_click_on_Start_Now() throws Throwable {

    }

    @When("^I Enter a vehicle Registration$")
    public void i_Enter_a_vehicle_Registration() throws Throwable {

    }

    @When("^I click on continue$")
    public void i_click_on_continue() throws Throwable {

    }

    @Then("^the details of the vehicle should be correctly displayed$")
    public void the_details_of_the_vehicle_should_be_correctly_displayed() throws Throwable {
        rvp.verifyCarId();

    }
}
