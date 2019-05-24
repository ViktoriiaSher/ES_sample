package framework.page_object_model_web;

import framework.actions_web.BasePage;
import org.apache.logging.log4j.core.config.plugins.validation.constraints.Required;
import org.eclipse.jetty.util.Fields;
import org.jsoup.helper.StringUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import stepdefinition.DriverWrapper;

import java.util.List;
import java.util.Set;

public class SampleFormApplication extends BasePage {

    private By emailAddress = By.xpath("//input[@name='emailAddress']");
    private By secondaryEmailAddress = By.xpath("//input[@name='entry.1117825157']");
    private By phoneNumber = By.xpath("//input[@name='entry.1499383259']");
    private By zipCode = By.xpath("//input[@name='entry.577894688']");
    private By submitButton = By.cssSelector("body.freebirdLightBackground:nth-child(2) div.freebirdFormviewerViewFormContentWrapper:nth-child(9) div.freebirdFormviewerViewCenteredContent div.freebirdFormviewerViewFormCard.exportFormCard div.freebirdFormviewerViewFormContent div.freebirdFormviewerViewNavigationNavControls:nth-child(3) div.freebirdFormviewerViewNavigationButtonsAndProgress div.freebirdFormviewerViewNavigationButtons > div.quantumWizButtonEl.quantumWizButtonPaperbuttonEl.quantumWizButtonPaperbuttonFlat.quantumWizButtonPaperbuttonDark.quantumWizButtonPaperbutton2El2.freebirdFormviewerViewNavigationSubmitButton");
    private By successfulSubmissionText = By.xpath("//div[@class='freebirdFormviewerViewResponseConfirmationMessage']");
    private String expectedSubmissionResponse = "Your response has been recorded.";
    private By allBlankFormError = By.xpath("//div[@class='freebirdFormviewerViewItemsItemErrorMessage']");
    private String blankErrorMessage = "This is a required question";
    private By actualPhoneError = By.id("i.err.1114021586");
    private String expectedPhoneError = "phone number must be in the format nnn-nnn-nnnn where \"n\" is a digit from 0-9";
    private By actualEmailError = By.id("i2");
    private String expectedEmailError = "Must be a valid email address";
    private By actualZipCodeError = By.id("i.err.1955442999");
    private String expectedZipCodeError = "zip code must be a 5-digit or 9-digit US ZIP code. 9-digit codes should have a hyphen between first five and last four digits";




    public void enterEmail(String expectedText){ sendText(emailAddress, expectedText);}


    public void enterSecEmail(String expectedText){ sendText(secondaryEmailAddress, expectedText);}


    public void enterPhoneNum(String expectedText){ sendText(phoneNumber, expectedText); }


    public void enterZip(String expectedText){ sendText(zipCode, expectedText);}


    public void clickSubmitButton() { clickOn(submitButton); }


    public void verifySubmission () throws InterruptedException{
        Thread.sleep(1000);
        Assert.assertEquals(expectedSubmissionResponse, getText(successfulSubmissionText));
    }


    public void verifyBlankFormError() {

        List<WebElement> errorElements = DriverWrapper.getDriver().findElements(allBlankFormError);
        for (WebElement errorElement : errorElements) {

            Assert.assertEquals(errorElement.getText(), blankErrorMessage);
        }
    }

    public void verifyInvalidEmailMessage() throws InterruptedException {
        Thread.sleep(1000);

        Assert.assertEquals(expectedEmailError, getText(actualEmailError));
    }

    public void verifyInvalidPhoneMessage() throws InterruptedException {
        Thread.sleep(1000);

        Assert.assertEquals(expectedPhoneError, getText(actualPhoneError));
    }

    public void verifyInvalidZipCodeMessage() throws InterruptedException {
        Thread.sleep(1000);

        Assert.assertEquals(expectedZipCodeError, getText(actualZipCodeError));
    }
}
