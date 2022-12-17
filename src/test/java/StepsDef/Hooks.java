package StepsDef;

import Utils.CommonMethods;
import io.cucumber.java.Before;
import io.cucumber.java.After;
import io.cucumber.java.Scenario;

public class Hooks extends CommonMethods {
    @Before
    public void preCondition(){
        openBrowserAndLaunchApplication();
    }


    //We use sepcial class called scenario from cucumber
    //this class holds the complete info of your execution
    @After
    public void postCondition(Scenario scenario){
        byte[] pic;
        if(scenario.isFailed()){
            pic=takeScreenShot("failed/"+scenario.getName());
        }else{
            pic =takeScreenShot("passed/"+scenario.getName());
        }
     //to attach the screenshot in our report
        scenario.attach(pic, "image/png", scenario.getName());

        closeBrowser();

   }

}
