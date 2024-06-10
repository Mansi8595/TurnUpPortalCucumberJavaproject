package StepDefinations;

import Pages.Homepage;
import Pages.Login;
import Pages.TimeMaterialPage;
import Utils.CommonDriver;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TMStepdefs extends CommonDriver {
    Login loginObj = new Login();
    Homepage homepageObj = new Homepage();
    TimeMaterialPage timeMaterialPageObj = new TimeMaterialPage();

    @Before
    public void setup() {
        driver = new ChromeDriver();
    }

    @After
    public void Close() {
        driver.quit();
    }

    @Given("I logged into turnup portal successfully")
    public void iLoggedIntoTurnupPortalSuccessfully() {
     loginObj.LoginActions(driver, "hari", "123123");
    }

    @When("I navigate to time and material page")
    public void iNavigateToTimeAndMaterialPage() {
        homepageObj.NavigateToTimeMaterialPage(driver);
    }


    @And("I create a new time and material record {string} {string} {string} {string}")
    public void iCreateANewTimeAndMaterialRecord(String code, String typeCode, String description, String price) {
         timeMaterialPageObj.CreateTimeRecord(driver, code, typeCode, description, price);
    }

    @Then("The record should be created successfully {string} {string} {string} {string}")
    public void theRecordShouldBeCreatedSuccessfully(String code, String typeCode, String description, String price) {
         timeMaterialPageObj.CreateTMAssertion(driver, code, typeCode, description, price);
    }

    @And("I edit an existing time and material record {string} {string} {string} {string} {string} {string} {string} {string}")
    public void iEditAnExistingTimeAndMaterialRecord(String oldCode, String oldTypeCode, String oldDescription, String oldPrice, String newCode, String newTypeCode, String newDescription, String newPrice) {
        timeMaterialPageObj.EditTMRecord(driver, oldCode, oldTypeCode, oldDescription, oldPrice, newCode, newTypeCode, newDescription, newPrice);
    }

    @Then("The record should be updated successfully {string} {string} {string} {string}")
    public void theRecordShouldBeUpdatedSuccessfully(String newCode, String newTypeCode, String newDescription, String newPrice) {
        timeMaterialPageObj.EditTMAssertion(driver, newCode, newTypeCode, newDescription, newPrice);
    }

    @And("I delete an existing time and material record")
    public void iDeleteAnExistingTimeAndMaterialRecord() {
        timeMaterialPageObj.DeleteTM(driver);
    }

    @Then("The record should be deleted successfully {string} {string} {string} {string}")
    public void theRecordShouldBeDeletedSuccessfully(String code, String typeCode, String description, String price) {
        timeMaterialPageObj.DeleteTMAssertion(driver, code, typeCode, description, price);
    }
}
