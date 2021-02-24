package Tests;

import PageObject.Pages.login;
import PageObject.Pages.pageDashBoard;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class TestSuite {

    String chromePath = System.getProperty("user.dir") + "\\src\\main\\resources\\Driver\\chromedriver.exe"; //Indicar la ruta del archivo ChromeDriver.exe en la propierdad webdriver.chromer.exe
    protected WebDriver driver;
    static String baseURL = "http://processa6.ongemini.com/account/login";
    login login;
    pageDashBoard pageDashBoard;


    private void inicializarPaginas(){
        login = new login(driver);
        pageDashBoard = new pageDashBoard(driver);
    }

    @Before
    public void chromeDriverConnection() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", chromePath);//Indicar la ruta del archivo ChromeDriver.exe
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get(baseURL);
        inicializarPaginas();
    }

    @After
    public void cerrarChrome(){
        driver.quit();
    }
}
