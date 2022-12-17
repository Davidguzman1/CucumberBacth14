package Runners;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        //features we use to provide the path of all feature files
        features = "src/test/resources/features",
        glue = "StepsDef",
        //when you set dry run to true , it stops execution
        //it will quickly scan all the gerkin steps whether they are
        //implemented or not
        dryRun = false,
        //when we set dryRun to false then it begins execution

        tags = "@excel",
        //to remove irrelevent info from console you need to add monochrome

        monochrome = true,

        //pretty prints the steps in the console to increase readability
        //to generate the reports we need plugin of runner class

        plugin = {"pretty","html:target/cucumber.html","json:target/cucumber.json",
        "rerun:target/failed.txt"}
)

public class SmokeRunner {

}
