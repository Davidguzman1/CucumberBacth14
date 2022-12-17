package Pages;

import Utils.CommonMethods;
import org.apache.poi.ss.formula.functions.Today;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddEmployeePage extends CommonMethods {

    @FindBy(xpath = "//input[@id='firstName']")
    public WebElement firstNameField;

    @FindBy(xpath = "//input[@id='lastName']")
    public WebElement lastNameField;

    @FindBy(xpath = "//input[@id='btnSave']")
    public WebElement saveBtn;
    @FindBy(id = "middleName")
    public WebElement middleNameField;

    @FindBy(id = "photofile")
    public WebElement photograph;

    @FindBy(id = "chkLogin")
    public WebElement checkBox;

    @FindBy(id = "user_name")
    public WebElement createusernameField;

    @FindBy(id = "user_password")
    public WebElement createpasswordField;

    @FindBy(id = "re_password")
    public WebElement confirmpasswordField;

    @FindBy(xpath="//input[@id='employeeId']")
    public WebElement employeeIdField;

@FindBy(id="employeeId")
public WebElement empIdLocator;
    public AddEmployeePage(){
        PageFactory.initElements(driver,this);
    }

}
