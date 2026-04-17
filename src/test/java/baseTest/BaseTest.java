package baseTest;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.io.*;
import java.util.Properties;

public class BaseTest {
    public WebDriver driver;

    @BeforeMethod(alwaysRun = true)
    public void setUp() throws IOException {


        if (System.getProperty("browserValue").equalsIgnoreCase("chrome"))
        {
            System.out.println("Running chrome browser");
            ChromeOptions chromeOptions=new ChromeOptions();
            chromeOptions.addArguments("--headless");
            chromeOptions.addArguments("--disable-gpu");
            chromeOptions.addArguments("--window-size=1920,1080");
            WebDriverManager.chromedriver().setup();
            driver=new ChromeDriver(chromeOptions);
        } else if (System.getProperty("browserValue").equalsIgnoreCase("Firefox")) {
            System.out.println("Running firefox browser");
            FirefoxOptions firefoxOptions=new FirefoxOptions();
            firefoxOptions.addArguments("--headless");
            firefoxOptions.addArguments("--disable-gpu");
            firefoxOptions.addArguments("--window-size=1920,1080");
            WebDriverManager.firefoxdriver().setup();
            driver=new FirefoxDriver(firefoxOptions);
        } else {
            System.out.println("Running edge browser");
            EdgeOptions edgeOptions=new EdgeOptions();
            edgeOptions.addArguments("--headless");
            edgeOptions.addArguments("--disable-gpu");
            edgeOptions.addArguments("--window-size=1920,1080");
            WebDriverManager.edgedriver().setup();
            driver=new EdgeDriver(edgeOptions);
        }

        driver.manage().window().maximize();

    }

    @AfterMethod(alwaysRun = true)
    public void tearDown()
    {
        driver.quit();
    }
















}
