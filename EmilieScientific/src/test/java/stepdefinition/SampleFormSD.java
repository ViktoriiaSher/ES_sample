package stepdefinition;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import framework.page_object_model_web.SampleFormApplication;


public class SampleFormSD {

    private SampleFormApplication sfa = new SampleFormApplication();

    @Given("^I am on application submission page$")
    public void submissionPage() { }

    @When("^I enter an email as (.+)$")
    public void enterEmail(String emailAddressInput) {sfa.enterEmail(emailAddressInput); }

    @And("^I enter a secondary email as (.+)$")
    public void enterSecEmail (String secEmailInput) {sfa.enterSecEmail(secEmailInput);}

    @And("^I enter a phone number as (.+)$")
    public void enterPhoneNum(String phoneNumInput) {sfa.enterPhoneNum(phoneNumInput);}

    @And("^I enter a zip code as (.+)$")
    public void setText(String zipInput){sfa.enterZip(zipInput);}

    @And("^I click on submit button$")
    public void clickOnSubmit() {sfa.clickSubmitButton(); }

    @Then("^a response that submitted data is successfully recorded should be displayed$")
    public void verifyServerResponse () throws InterruptedException {sfa.verifySubmission();}

    @Then("^I get an appropriate error for blank form$")
    public void verifyBlanFormMessage() {sfa.verifyBlankFormError();}

    @Then("^I get invalid email address error message$")
    public void getErrorMessage() throws InterruptedException {sfa.verifyInvalidEmailMessage();}

    @Then("^I get invalid phone error message$")
    public void getErrorMessage1() throws InterruptedException {sfa.verifyInvalidPhoneMessage();}

    @Then("^I get invalid zip code error message$")
    public void getError () throws InterruptedException {sfa.verifyInvalidZipCodeMessage();

    }
}
