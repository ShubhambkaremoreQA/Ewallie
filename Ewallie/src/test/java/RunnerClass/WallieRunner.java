package RunnerClass;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features="/Users/ulistech/UlisWorkspace/Ewallie/src/test/resources/Features"
,glue= {"StepDefinitions"}, monochrome = true,
plugin= {"pretty", "html:target/HtmlReports/report.html","json:target/JSONReports/report.json","junit:target/JUNITReports/report.xml"})


public class WallieRunner {

}
