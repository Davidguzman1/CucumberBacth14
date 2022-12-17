package Pages;

import Utils.CommonMethods;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends CommonMethods {


    @FindBy(id = "txtUsername")
    public WebElement usernameTextField;

    @FindBy(id = "txtPassword")
    public WebElement passwordTextField;

    @FindBy(id = "btnLogin")
    public WebElement loginBtn;

    @FindBy(id = "spanMessage")
    public WebElement errorMsg;

   public LoginPage(){
       PageFactory.initElements(driver,this);

    }








}
