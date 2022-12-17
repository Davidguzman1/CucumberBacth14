package Pages;

import Utils.CommonMethods;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class DashboardPage extends CommonMethods {

    @FindBy(xpath = "//b[text()='PIM']")
    public WebElement pimOtion;

    @FindBy(xpath = "//a[text()='Employee List']")
    public WebElement employeeListOption;

    @FindBy(id = "welcome")
    public WebElement welcomeMsg;

    @FindBy(id = "menu_pim_addEmployee")
    public WebElement addEmployeeOption;

    @FindBy(xpath = "//div[@class='menu']/ul/li")
    public List<WebElement> dashboardTabs;

    public DashboardPage(){
        PageFactory.initElements(driver,this);
    }
}
