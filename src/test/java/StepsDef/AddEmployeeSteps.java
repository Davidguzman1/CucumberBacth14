package StepsDef;

import Pages.EmployeeListPage;
import Utils.CommonMethods;
import Utils.ConfigReader;
import Utils.Constants;
import Utils.ExcelReader;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class AddEmployeeSteps extends CommonMethods {
    @When("user clicks on PIM option")
    public void user_clicks_on_pim_option() {
        click(dashboardPage.pimOtion);
    }

    @When("user clicks on add employee button")
    public void user_clicks_on_add_employee_button() {
       click(dashboardPage.addEmployeeOption);
    }
    @When("user enters first and last name")
    public void user_enters_first_and_last_name() {
       /*WebElement fName=driver.findElement(By.xpath("//input[@id='firstName']"));
       WebElement lName=driver.findElement(By.xpath("//input[@id='lastName']"));*/

       sendText(addEmployeePage.firstNameField,ConfigReader.getPropertyValue("fname"));
       sendText(addEmployeePage.lastNameField,ConfigReader.getPropertyValue("lname"));
    }
    @When("user clicks on save button")
    public void user_clicks_on_save_button() {
       /* WebElement saveBtn=driver.findElement(By.xpath("//input[@id='btnSave']"));
        saveBtn.click();*/
        click(addEmployeePage.saveBtn);

    }
    @Then("employee added successfully")
    public void employee_added_successfully() {
        System.out.println("Employee successfully added");
    }



    @When("user enter {string} and {string}")
    public void user_enter_(String firstName,String lastName) {
       sendText(addEmployeePage.firstNameField,firstName);
       sendText(addEmployeePage.lastNameField, lastName);
    }
    @When("user  enter {string} and {string} for adding multiple employees")
    public void user_enter_and_for_adding_multiple_employees(String firstNamev, String lastNamev) {
        sendText(addEmployeePage.firstNameField,firstNamev);
        sendText(addEmployeePage.lastNameField, lastNamev);
    }

    @When("user adds multiple employees and verify they are added successfully")
    public void user_adds_multiple_employees_and_verify_they_are_added_successfully(DataTable dataTable) throws InterruptedException {
     List<Map<String,String>> employeeNames = dataTable.asMaps();

     for(Map<String,String> employee:employeeNames){
         String employeeFirstname=employee.get("firstName");
         String employeeMiddleName=employee.get("middleName");
         String employeeLastName=employee.get("lastName");


         sendText(addEmployeePage.firstNameField,employeeFirstname);
         sendText(addEmployeePage.lastNameField, employeeLastName);
         sendText(addEmployeePage.middleNameField, employeeMiddleName);

         String empID=addEmployeePage.employeeIdField.getAttribute("value");


         click(addEmployeePage.saveBtn);
         Thread.sleep(3000);

        click(dashboardPage.employeeListOption);
        sendText(EmployeeListPage.employeeListPage.idTextField,empID);
        click(EmployeeListPage.employeeListPage.searchBtn);

         String actualEmpId=employeeListPage.employeeIdBox.getText();
        if(actualEmpId.equals(empID)){
            System.out.println("Employee has been verified and added");
        }else{
            System.out.println("Employee has not been added");
        }


         click(dashboardPage.addEmployeeOption);


     }


    }
    @When("user adds multiple employee from excel using {string} and verify it")
    public void user_adds_multiple_employee_from_excel_using_and_verify_it(String sheetName) throws InterruptedException {

        List<Map<String, String>> empFromExcel =
                ExcelReader.excelListIntoMap(Constants.TESTDATA_FILEPATH, sheetName);


        //it returns one map from list of maps
        Iterator<Map<String, String>> itr = empFromExcel.iterator();
        while (itr.hasNext()){
            //it returns the key and value for employee from excel
            Map<String, String> mapNewEmp = itr.next();

            sendText(addEmployeePage.firstNameField, mapNewEmp.get("firstName"));
            sendText(addEmployeePage.middleNameField, mapNewEmp.get("middleName"));
            sendText(addEmployeePage.lastNameField, mapNewEmp.get("lastName"));

            sendText(addEmployeePage.photograph, mapNewEmp.get("photograph"));

            if(!addEmployeePage.checkBox.isSelected()){
                click(addEmployeePage.checkBox);
            }

            sendText(addEmployeePage.createusernameField, mapNewEmp.get("username"));
            sendText(addEmployeePage.createpasswordField, mapNewEmp.get("password"));
            sendText(addEmployeePage.confirmpasswordField, mapNewEmp.get("confirmPassword"));

            String empID=addEmployeePage.employeeIdField.getAttribute("value");


            click(addEmployeePage.saveBtn);
            Thread.sleep(3000);

            click(dashboardPage.employeeListOption);
            sendText(EmployeeListPage.employeeListPage.idTextField,empID);
            click(EmployeeListPage.employeeListPage.searchBtn);

            String actualEmpId=employeeListPage.employeeIdBox.getText();
            if(actualEmpId.equals(empID)){
                System.out.println("Employee has been verified and added");
            }else{
                System.out.println("Employee has not been added");
            }
            Thread.sleep(2000);
            click(dashboardPage.addEmployeeOption);
            Thread.sleep(2000);
        }


    }

}
