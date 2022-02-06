package StepDefinition;

import PageObject.HomeObject;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import org.openqa.selenium.WebDriver;
import utility.ClassHelp;
import utility.DefaultData;
import utility.Hooks;
import utility.TestData;

public class DefinitionStep {
    WebDriver driver;
    Hooks hooks = new Hooks();
    TestData testData = new TestData();
    HomeObject homeObject = new HomeObject();

    @Given("^Initiate Browser$")
    public void initiate_Browser() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        testData.setIsHeadless(ClassHelp.getEnv("DontRunningBrowser"));
        hooks = new Hooks();
        System.out.println("Hooks :" + hooks);
        driver = hooks.openBrowser(ClassHelp.getEnv("browser"));
        System.out.println("Driver : " + driver);
        // Write code here that turns the phrase above into concrete actions
    }

    @Given("^Setup setTestData$")
    public void setup_setTestData() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        DefaultData.setTestData();
        System.out.println("**** Setup Data Done **** ");
        driver.manage().window().maximize();
    }

    @Given("^Navigate to webiste Bhinneka$")
    public void navigate_to_webiste_Bhinneka() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        homeObject.BhinnekaHomepage();
    }

    @Given("^Pergi Ke Beranda Website Bhinneka$")
    public void pergi_Ke_Beranda_Website_Bhinneka() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        homeObject.setHomePage();
    }

    @Given("^Klik Page Login$")
    public void klik_Page_Login() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        homeObject.FormLogin();
    }

    @Then("^Masukan Email dan Password$")
    public void masukan_Email_dan_Password() throws Throwable {
        homeObject.CredentialForm();
        // Write code here that turns the phrase above into concrete actions
    }

    @Then("^Melakukan Pencarian dengan detail \"([^\"]*)\"$")
    public void melakukan_Pencarian_dengan_detail(String arg1) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        homeObject.SearchProduct(arg1);
    }

    @Then("^Tambah jumlah Produk pada halaman detail produk \"([^\"]*)\"$")
    public void tambah_jumlah_Produk_pada_halaman_detail_produk(String arg1) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        homeObject.AddProductDetail(arg1);
    }

    @Then("^Tambah jumlah Produk pada halaman keranjang \"([^\"]*)\"$")
    public void tambah_jumlah_Produk_pada_halaman_keranjang(String arg1) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        homeObject.addProductOnChart(arg1);
    }

    @Then("^Logout$")
    public void logout() throws Throwable {
        homeObject.Logout();
        // Write code here that turns the phrase above into concrete actions

    }
    @Then("^View Report$")
    public void view_Report() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        testData.setIsHeadless(ClassHelp.getEnv("DontRunningBrowser"));
        hooks = new Hooks();
        System.out.println("Hooks :" + hooks);
        driver = hooks.openBrowser(ClassHelp.getEnv("browser"));
        System.out.println("Driver : " + driver);
        driver.manage().window().maximize();
        homeObject.GetReport();

    }
    @Then("^Filter Daftar Kategori$")
    public void filter_Daftar_Kategori() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        homeObject.FilterSearchProduct();
    }
}
