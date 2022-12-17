package StepsDef;

import Pages.LoginPage;
import Utils.CommonMethods;
import Utils.ConfigReader;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginSteps extends CommonMethods {

   @Given("user navigates to hrms application")
   public void user_navigates_to_hrms_application() {
       openBrowserAndLaunchApplication();
    }

    @When("user enters valid username and valid password")
    public void user_enters_valid_username_and_valid_password() {

        /*WebElement usernameField = driver.findElement(By.id("txtUsername"));
        //usernameField.sendKeys(ConfigReader.getPropertyValue("username"));
        WebElement passwordField = driver.findElement(By.id("txtPassword"));
        //passwordField.sendKeys(ConfigReader.getPropertyValue("password"));*/
        sendText(login.usernameTextField,ConfigReader.getPropertyValue("username"));
        sendText(login.passwordTextField,ConfigReader.getPropertyValue("password"));

    }

    @When("user clicks on login button")
    public void user_clicks_on_login_button() {
        click(login.loginBtn);
    }

    @Then("user is successfully logged in")
    public void user_is_successfully_logged_in() {
        if(dashboardPage.welcomeMsg.isDisplayed()){
            System.out.println("Test case is passed");

        }else {
            System.out.println("Test case failed");

        }

    }


    @When("user enters ess username and ess password")
    public void user_enters_ess_username_and_ess_password() {

            //WebElement usernameField = driver.findElement(By.id("txtUsername"));
            sendText(login.usernameTextField, "asmahuma321");
            //WebElement passwordField = driver.findElement(By.id("txtPassword"));
            sendText(login.passwordTextField, "Hum@nhrm123");
    }


    @When("user enters invalid username and password")
    public void user_enters_invalid_username_and_password() {

        //WebElement usernameField = driver.findElement(By.id("txtUsername"));
        sendText(login.usernameTextField, "adim1234");
       // WebElement passwordField = driver.findElement(By.id("txtPassword"));
        sendText(login.passwordTextField, "Hum@nhr");
    }




    @Then("error message is displayed")
    public void error_message_is_displayed() {
        System.out.println("error message displayed");
    }


    @When("User enters different {string} and {string} and verify the {string} for it")
    public void user_enters_different_and_and_verify_the_for_it(String username, String password, String errorMsg) {
       sendText(login.usernameTextField, username);
       sendText(login.passwordTextField, password);
       click(login.loginBtn);

       String errorActual=login.errorMsg.getText();
        Assert.assertEquals(errorMsg,errorActual);

    }


}
