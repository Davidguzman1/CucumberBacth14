package StepsDef;

import Utils.CommonMethods;
import Utils.ConfigReader;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class SearchEmployeeSteps extends CommonMethods {
    @When("user clicks on employeeList option")
    public void user_clicks_on_employee_list_option() {
       // WebElement employeeListBtn =driver.findElement(By.xpath("//a[text()='Employee List']"));
        click(employeeListPage.employeeListOption);
    }

    @When("user enters valid employee id")
    public void user_enters_valid_employee_id() {
       // WebElement idText=driver.findElement(By.xpath("//input[contains(@id,'id')]"));
        sendText(employeeListPage.idTextField, ConfigReader.getPropertyValue("empId"));
    }
    @When("user clicks on search button")
    public void user_clicks_on_search_button() {
      // WebElement searchBtn=driver.findElement(By.xpath("//input[@id='searchBtn']"));
       click(employeeListPage.searchBtn);
    }
    @Then("user can see employee information is displayed")
    public void user_can_see_employee_information_is_displayed() {
        System.out.println("User Found");
    }

    @When("user enters valid employee name")
    public void user_enters_valid_employee_name() {
       // WebElement employeeNameText=driver.findElement(By.xpath("//input[contains(@id,'empName')]"));
        sendText(employeeListPage.nameTextField,"John Doe");

    }
}
