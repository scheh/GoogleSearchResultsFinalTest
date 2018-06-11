package test;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import page.GooglePage;

import java.util.concurrent.TimeUnit;

public class GoogleSearchBaseTest
{
    WebDriver webDriver;
    GooglePage googlePage;

    @Parameters({"browserType","envURL"})
    @BeforeMethod

    public void beforeTest(@Optional("chrome") String browserType,
                           @Optional("https://google.com/")String envURL)
    {
        switch (browserType.toLowerCase())
        {
            case "firefox" :
                WebDriverManager.firefoxdriver().setup();
                webDriver = new FirefoxDriver();
                webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
                webDriver.manage().window().maximize();
                break;
            case "chrome" :
                WebDriverManager.chromedriver().setup();
                webDriver = new ChromeDriver();
                webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
                webDriver.manage().window().maximize();
                break;
            default :
                WebDriverManager.iedriver().setup();
                webDriver = new InternetExplorerDriver();
                webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
                webDriver.manage().window().maximize();
        }
        webDriver.navigate().to(envURL);
        googlePage = new GooglePage(webDriver);

    }

    @AfterMethod
    public void after()
    {
        webDriver.close();
    }

}