package Pages;

import Utils.CommonMethods;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class EmployeeListPage extends CommonMethods {

    @FindBy(xpath = "//a[text()='Employee List']")
    public WebElement employeeListOption;

    @FindBy(xpath = "//input[contains(@id,'id')]")
    public WebElement idTextField;

    @FindBy(xpath = "//input[contains(@id,'empName')]")
    public WebElement nameTextField;

    @FindBy(xpath = "//input[@id='searchBtn']")
    public WebElement searchBtn;

    @FindBy(xpath = "//table[@class='table hover']/tbody/tr/td[2]")
    public WebElement employeeIdBox;

    public EmployeeListPage(){
        PageFactory.initElements(driver,this);
    }




}
