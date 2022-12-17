package Runners;
//this runner class is responsible to run only
//failed test cases

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        //features we use to provide the path of all feature files
        features = "@target/failed.txt",
        glue = "StepsDef",
        //when you set dry run to true , it stops execution
        //it will quickly scan all the gerkin steps whether they are
        //implemented or not
        //dryRun = false,
        //when we set dryRun to false then it begins execution

        //tags = "@sprint1",
        //to remove irrelevent info from console you need to add monochrome

        monochrome = true,

        //pretty prints the steps in the console to increase readability
        //to generate the reports we need plugin of runner class

        plugin = {"pretty"}
)
public class FailedRunner {
}
