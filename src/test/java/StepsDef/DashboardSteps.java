package StepsDef;

import Utils.CommonMethods;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class DashboardSteps extends CommonMethods {
    @Then("user verify dashboard page")
    public void user_verify_dashboard_page(DataTable dataTable) {
        List<String> expectedTabs = dataTable.asList();

        List<String> actualTabs = new ArrayList<>();

        for (WebElement element : dashboardPage.dashboardTabs) {
            actualTabs.add(element.getText());
        }

        System.out.println(expectedTabs);
        System.out.println(actualTabs);

        Assert.assertTrue(expectedTabs.equals(actualTabs));

    }



}
