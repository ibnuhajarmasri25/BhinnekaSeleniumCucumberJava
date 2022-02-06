package TestRunner;


import com.cucumber.listener.Reporter;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.AfterClass;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/java/Features/",
        glue = {"StepDefinition"},
        tags = {"@Scenario"},
//        plugin = {"html:target/cucumber-report/Report.html","json:target/cucumber-report/Report.json"},
        plugin = {"com.cucumber.listener.ExtentCucumberFormatter:target/cucumber-report/ReportBhineka.html"},
        //Uncomment plugin listener to activate extent-report.html & uncomment void writeextentreport on below
        dryRun = false,
        monochrome = true
)

public class RunnerTest {
    @AfterClass
    public static void writeExtentReport() {
        Reporter.loadXMLConfig("src/resources/extent-config.xml");
        Reporter.setSystemInfo("Author ","Ibnu Hazar Masri");
        Reporter.setSystemInfo("Time Zone ", System.getProperty("user.timezone"));
        Reporter.setSystemInfo("Machine ", 	"Windows 10 " + " 64 Bit");
        Reporter.setSystemInfo("CUCUMBER SELENIUM :", "Bhinneka.com" + "Automation Web");
        Reporter.setSystemInfo("Website ","Bhinneka.com");
    }
}
