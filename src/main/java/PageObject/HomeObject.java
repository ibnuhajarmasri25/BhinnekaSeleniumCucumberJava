package PageObject;

import Configuration.InspectElement;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.testng.Assert;
import utility.Hooks;
import utility.TestData;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class HomeObject extends Hooks {
    private static TestData testData = new TestData();
    public void BhinnekaPage(String url) {
        driver.get(url.replace("\"",""));
        System.out.println("SuccessFully Opening Website : " + url);
        driver.manage().window().maximize();
    }
    public void BhinnekaHomepage (){
        BhinnekaPage(testData.getUrl());
    }
    public void GetReport () {
        driver.get("http://localhost:63342/BhinnekaSeleniumCucumberJava/target/cucumber-report/ReportBhineka.html?_ijt=he0psr7q6m3df65blhgup1r9u1&_ij_reload=RELOAD_ON_SAVE");
    }

//    Call ELEMENT XPATH
    By PopUpNotification = By.xpath(InspectElement.XpathPopUpCancel);
    By FormLogin         = By.xpath(InspectElement.XpathFormLogin);
    By EmailId           = By.xpath(InspectElement.XpathEmailID);
    By Next              = By.xpath(InspectElement.XpathNext);
    By Password          = By.xpath(InspectElement.XpathPassword);
    By SignInBtn         = By.xpath(InspectElement.XpathSignin);
    By clickAcc          = By.xpath(InspectElement.XpathClickAcc);
    By AccForm           = By.xpath(InspectElement.XpathAkunForm);
    By DashboardAcc      = By.xpath(InspectElement.XpathDashboard);
    By Search            = By.xpath(InspectElement.XpathSearch);
    By pickproduct       = By.xpath(InspectElement.XpathClickProduct);
    By valProduct        = By.xpath(InspectElement.XpathValidationForm);
    By AddQuantity       = By.xpath(InspectElement.XpathAddQuantity);
    By InputQuantity     = By.xpath(InspectElement.XpathInputQuantity);
    By AddToChart        = By.xpath(InspectElement.XpathAddToChart);
    By NextToChart       = By.xpath(InspectElement.XpathNextToChart);
    By Logout            = By.xpath(InspectElement.XpathLogout);
    By filterSearch      = By.xpath(InspectElement.XpathFiltersearch);
    By BerandaBhinneka   = By.xpath(InspectElement.XpathBerandaBhinneka);
// End By XPATH
// Mini Config SS
public static void takeScreenshoot() {
    File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
    try {
        FileUtils.copyFile(scrFile, new File("src/ScreenShoot/" + System.currentTimeMillis() + ".png"));
    } catch (IOException e) {
        e.printStackTrace();
    }
}
    //Mini config ss End
    public void setHomePage () throws InterruptedException {
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        Thread.sleep(5000);
            driver.findElement(PopUpNotification).click();
            System.out.println( "Page Title Is : " + driver.getTitle());
            Assert.assertEquals(driver.getTitle(),"Bhinneka: Solusi Praktis Untuk Kebutuhan Bisnis Terlengkap");
            System.out.println("Assert Passed");
            takeScreenshoot();
        }
    public void FormLogin() throws InterruptedException {
        Thread.sleep(500);
        driver.findElement(FormLogin).click();
        Assert.assertEquals(driver.getTitle(),"Login");
        System.out.println("Assert Passed on page: " + driver.getTitle());
    takeScreenshoot();
}

    public void CredentialForm() throws InterruptedException {
        driver.findElement(EmailId).sendKeys(testData.getUsername());
        driver.findElement(Next).click();
        driver.findElement(Password).sendKeys(testData.getPassword());
        driver.findElement(SignInBtn).click();
        Thread.sleep(5000);
        driver.findElement(clickAcc).click();
        driver.findElement(AccForm).click();
        Thread.sleep(5000);
        Assert.assertEquals(driver.getTitle(), "Akun Saya | Bhinneka");
        System.out.println("Assert Passed Login Succesfully");
        driver.findElement(DashboardAcc).click();
        takeScreenshoot();
    }

        public void SearchProduct(String arg1) {
        driver.findElement(Search).sendKeys(arg1);
        driver.findElement(Search).sendKeys(Keys.ENTER);
        }
        public void AddProductDetail (String arg1) throws InterruptedException {
        Thread.sleep(5000);
        driver.findElement(pickproduct).click();
        driver.findElement(valProduct).getText().equals("PRODUK LOKAL");
        driver.findElement(InputQuantity).clear();
        driver.findElement(InputQuantity).sendKeys(arg1);
        driver.findElement(AddToChart).click();
        driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
        driver.findElement(NextToChart).click();

//        driver.findElement(AddQuantity).click();
//        driver.findElement(AddQuantity).click();
//        driver.findElement(AddQuantity).click();
            takeScreenshoot();
        }
        public void addProductOnChart (String arg1) throws InterruptedException {
            driver.findElement(InputQuantity).clear();
            driver.findElement(InputQuantity).sendKeys(arg1);
            Thread.sleep(5000);
            takeScreenshoot();
        }
        public void Logout() throws InterruptedException {

            driver.findElement(clickAcc).click();
            driver.findElement(Logout).click();
            Thread.sleep(5000);
            takeScreenshoot();
            driver.findElement(BerandaBhinneka).click();
            Assert.assertEquals(driver.getTitle(), "Bhinneka: Solusi Praktis Untuk Kebutuhan Bisnis Terlengkap");
            driver.close();
        }
        public void FilterSearchProduct () throws InterruptedException {

        Thread.sleep(5000);
        driver.findElement(filterSearch).click();
        takeScreenshoot();
        }
    }
