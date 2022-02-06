package utility;

import cucumber.api.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriverService;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.safari.SafariDriver;

import java.io.File;
import java.net.MalformedURLException;
import java.util.HashMap;

public class Hooks {
    /* For windows based OS */
    static String firefoxDriverPath =  System.getProperty("user.dir")+File.separator+"src"+File.separator+"driver"+File.separator+ClassHelp.getEnv("firefox");
    static String chromeDriverPath = System.getProperty("user.dir")+File.separator+"src"+File.separator+"driver"+File.separator+ClassHelp.getEnv("googleChrome");
    /************************/
    public static WebDriver driver;
    TestData testData = new TestData();
    public WebDriver openBrowser(String browser) throws MalformedURLException {


        if ("chrome".equals(browser)) {/* Windows based OS */
            System.setProperty("webdriver.chrome.driver", chromeDriverPath);
            /********************/
            String downloadFilepath = System.getProperty("user.dir") + File.separator + "src" + File.separator + "test" + File.separator + "resources" + File.separator + "Download" + File.separator;
            HashMap<String, Object> chromePrefs = new HashMap<String, Object>();
            chromePrefs.put("profile.default_content_settings.popups", 0);
            chromePrefs.put("download.default_directory", downloadFilepath);
            ChromeOptions chromeOptions = new ChromeOptions();
            chromeOptions.setExperimentalOption("prefs", chromePrefs);
            if (testData.getIsHeadless().equalsIgnoreCase("yes")) {
                chromeOptions.addArguments("--headless");
            }
            chromeOptions.addArguments("--window-size=1366, 768");//1920,1080
            driver = new ChromeDriver(chromeOptions);
        } else if ("firefox".equals(browser)) {/* Windows based OS */
            System.setProperty("webdriver.gecko.driver", firefoxDriverPath);
            /********************/
            FirefoxOptions firefoxOptions = new FirefoxOptions();
            if (testData.getIsHeadless().toLowerCase().equals("yes")) {
                firefoxOptions.addArguments("--headless");
            }
            firefoxOptions.addArguments("--window-size=1366, 768");//1920,1080
            driver = new FirefoxDriver(firefoxOptions);
        } else if ("ie".equals(browser)) {
            driver = new InternetExplorerDriver();
        } else if ("safari".equals(browser)) {
            driver = new SafariDriver();
        } else if ("phantomjs".equals(browser)) {
            String[] cli_args = new String[]{"--ignore-ssl-errors=true"};
            DesiredCapabilities caps = new DesiredCapabilities();
            caps.setCapability(PhantomJSDriverService.PHANTOMJS_CLI_ARGS, cli_args);
            caps.setCapability(PhantomJSDriverService.PHANTOMJS_EXECUTABLE_PATH_PROPERTY, "/usr/local/bin/phantomjs");
            caps.setJavascriptEnabled(true);
            caps.setCapability("locationContextEnabled", true);
            caps.setCapability("applicationCacheEnabled", true);
            caps.setCapability("browserConnectionEnabled", true);
            caps.setCapability("localToRemoteUrlAccessEnabled", true);
            caps.setCapability("locationContextEnabled", true);
            caps.setCapability("takesScreenshot", true);
            caps.setCapability("acceptSslCerts", true);
            driver = new PhantomJSDriver(caps);
        } else {
            System.out.println("Selected browser not supported - " + browser);
        }
        System.out.println("Opening Browser: " + browser);
        return driver;

    }

//    public void afterEveryStep(Scenario scenario) {
//        if (testData.getScreenShotEveryStep().equalsIgnoreCase(Constant.yes)
//                || testData.getScreenShotStep().equalsIgnoreCase(Constant.yes)
//                || scenario.isFailed()) {
//            takeScreenshot(scenario);
//        }
//
//        if (testData.getScreenShotStep().equalsIgnoreCase(Constant.yes)) {
//            testData.setScreenShotStep(Constant.no);
//        }
//    }


    public void takeScreenshot(Scenario scenario) {
        try {
            scenario.write("Current Page URL is " + driver.getCurrentUrl());
            // byte[] screenshot = getScreenshotAs(OutputType.BYTES);
            byte[] screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
            scenario.embed(screenshot, "image/png");
        } catch (WebDriverException somePlatformsDontSupportScreenshots) {
            System.err.println(somePlatformsDontSupportScreenshots.getMessage());
        }
    }
}