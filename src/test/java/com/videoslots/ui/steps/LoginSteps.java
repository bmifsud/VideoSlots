package com.videoslots.ui.steps;

import com.videoslots.ui.steps.base.BaseStep;
import com.videoslots.ui.steps.commons.StepContext;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.spring.CucumberContextConfiguration;
import org.junit.Assert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@CucumberContextConfiguration
@SpringBootTest(classes= StepContext.class)
public class LoginSteps extends BaseStep {

    @Autowired
    private StepContext stepContext;

    public LoginSteps(StepContext stepContext) {
        super(stepContext.getDriver());
    }

    @Given("^the user opens Evernote homepage$")
    public void theUserOpensEvernoteHomepage() throws Throwable {

        try {
            //Opens Main page
            geturl(stepContext.getServerURL());
            //Waits for Login Button to be displayed
            findElement("Log In",
                    Pather.linkText,
                    TimeOut.MIDDLE);
        }catch (Exception ex){
            ex.printStackTrace();
        }

    }

    @When("^the user clicks Login$")
    public void theUserClicksLogin() throws Throwable {
        try {
            //Clicks login button
            findElementClick("Log In",
                    Pather.linkText);
        }catch (Exception ex){
            ex.printStackTrace();
        }
    }

    @And("^the user fills the (.+) and presses continue$")
    public void theUserFillsTheAndPressesContinue(String username) throws Throwable {
        try {
            //Filling Username
            findElement("username",
                    Pather.id,
                    TimeOut.MIDDLE).sendKeys(username);
            //Pressing continue
            findElementClick("loginButton",
                    Pather.id);

        }catch (Exception ex){
            ex.printStackTrace();
        }
    }

    @And("^the user fills the (.+) and presses sign in$")
    public void theUserFillsTheAndPressesSignIn(String password) throws Throwable {
        try {
            //Wait for element to be clickable
            waitForElementToBeClickable("password",
                    Pather.id,
                    TimeOut.MIDDLE);
            //Filling Password
            findElement("password",
                    Pather.id,
                    TimeOut.MIDDLE).sendKeys(password);
            //Pressing Sign In
            findElementClick("loginButton",
                    Pather.id);
        }catch (Exception ex){
            ex.printStackTrace();
        }
    }

    @Then("^depends on the credentials the user is or is not (.+) access$")
    public void dependsOnTheCredentialsTheUserIsOrIsNotAccess(String granted) throws Throwable {
        try {
            // When login granted
            if ((   // Granted Access
                    Boolean.parseBoolean(granted)
                            && findElement("#qa-NAV_HOME > svg",
                            Pather.cssSelector,
                            TimeOut.HIGH) == null )
                    // Not Granted Access
                    ||(!Boolean.parseBoolean(granted)
                            && findElement("#qa-NAV_HOME > svg",
                            Pather.cssSelector,
                            TimeOut.HIGH) != null)){

                //Then above true then fail test
                Assert.fail();
                DriverQuit();
            }

        }catch (Exception ex){
            ex.printStackTrace();
        }
    }

    @And("^the user exits with logout$")
    public void theUserExitsWithLogout() throws Throwable {
        //Logout
        findElementClick("#qa-NAV_USER > div > div > span > span > div > div",Pather.cssSelector);
        findElementClick("#qa-ACCOUNT_DROPDOWN_LOGOUT",Pather.cssSelector);
        DriverQuit();
    }

    @Given("^the user is logged in Evernote$")
    public void theUserIsLoggedInEvernote() throws Throwable {
        try {
            //Opens Main page
            geturl(stepContext.getServerURL());
            //Waits for Login Button to be displayed
            findElement("Log In",
                    Pather.linkText,
                    TimeOut.MIDDLE);
            //Clicks login button
            findElementClick("Log In",
                    Pather.linkText);
            //Filling Username
            findElement("username",
                    Pather.id,
                    TimeOut.MIDDLE).sendKeys("Bernard.Mifsud@gmail.com");
            //Pressing continue
            findElementClick("loginButton",
                    Pather.id);
            //Wait for element to be clickable
            waitForElementToBeClickable("password",
                    Pather.id,
                    TimeOut.MIDDLE);
            //Filling Password
            findElement("password",
                    Pather.id,
                    TimeOut.MIDDLE).sendKeys("q~Wk%R/XPNy~6<j");
            //Pressing Sign In
            findElementClick("loginButton",
                    Pather.id);

            //Asserts login success
            if(findElement("#qa-NAV_HOME > svg",
                    Pather.cssSelector,
                    TimeOut.HIGH) == null){
                Assert.fail();
                DriverQuit();
            }

        }catch (Exception ex){
            ex.printStackTrace();
        }
    }

    @And("^the user logs out and back in again$")
    public void theUserLogsOutAndBackInAgain() throws Throwable {
        try {
            //Logout
            findElementClick("#qa-NAV_USER > div > div > span > span > div > div",Pather.cssSelector);
            findElementClick("#qa-ACCOUNT_DROPDOWN_LOGOUT",Pather.cssSelector);

            findElement("Log In",
                    Pather.linkText,
                    TimeOut.MIDDLE);
            //Clicks login button
            findElementClick("Log In",
                    Pather.linkText);
            //Filling Username
            findElement("username",
                    Pather.id,
                    TimeOut.MIDDLE).sendKeys("Bernard.Mifsud@gmail.com");
            //Pressing continue
            findElementClick("loginButton",
                    Pather.id);
            //Wait for element to be clickable
            waitForElementToBeClickable("password",
                    Pather.id,
                    TimeOut.MIDDLE);
            //Filling Password
            findElement("password",
                    Pather.id,
                    TimeOut.MIDDLE).sendKeys("q~Wk%R/XPNy~6<j");
            //Pressing Sign In
            findElementClick("loginButton",
                    Pather.id);

            //Asserts login success
            if(findElement("#qa-NAV_HOME > svg",
                    Pather.cssSelector,
                    TimeOut.HIGH) == null){
                Assert.fail();
                DriverQuit();
            }

        }catch (Exception ex){
            ex.printStackTrace();
        }
    }


}
