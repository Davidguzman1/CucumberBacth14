package StepsDef;

import Pages.AddEmployeePage;
import Pages.DashboardPage;
import Pages.EmployeeListPage;
import Pages.LoginPage;

public class PageInitializer {

    public static LoginPage login;
    public static DashboardPage dashboardPage;
    public static AddEmployeePage addEmployeePage;
    public static EmployeeListPage employeeListPage;

    public static void initializePageObjects(){
        login=new LoginPage();
        dashboardPage=new DashboardPage();
        addEmployeePage=new AddEmployeePage();
        employeeListPage=new EmployeeListPage();
    }
}
