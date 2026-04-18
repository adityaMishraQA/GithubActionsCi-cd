package baseTest;

import constants.Constants;
import enums.BrowserEnum;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.io.*;

public class BaseTest {
    public WebDriver driver;

    @BeforeMethod(alwaysRun = true)
    public void setUp() throws IOException {

        driver=switch (BrowserEnum.valueOf(System.getProperty(Constants.BROWSER_NAME).toUpperCase()))
        {
            case CHROME -> {
                System.out.println("Running chrome browser");
                yield initializeChromeDriver();
            }
            case FIREFOX -> {
                System.out.println("Running firefox browser");
                yield initializeFirefoxDriver();
            }
            case EDGE -> {
                System.out.println("Running edge browser");
                yield initializeEdgeDriver();
            }
            default -> throw new RuntimeException("Invalid BrowserName");
        };

//        if (System.getProperty(Constants.BROWSER_NAME).equalsIgnoreCase(BrowserEnum.CHROME.getBrowserName()))
//        {
//            driver=initializeChromeDriver();
//
//        } else if (System.getProperty(Constants.BROWSER_NAME).equalsIgnoreCase(BrowserEnum.FIREFOX.getBrowserName())) {
//            driver=initializeFirefoxDriver();
//        } else {
//            driver=initializeEdgeDriver();
//        }

        driver.manage().window().maximize();

    }

    public static WebDriver initializeChromeDriver()
    {
        ChromeOptions chromeOptions=new ChromeOptions();
        chromeOptions.addArguments(Constants.BROWSER_HEADLESS_ARG,Constants.BROWSER_DIS_GPU_ARG,Constants.BROWSER_RESOLUTION_ARG);
        WebDriverManager.chromedriver().setup();
        return new ChromeDriver(chromeOptions);
    }

    public static WebDriver initializeFirefoxDriver()
    {
        FirefoxOptions firefoxOptions=new FirefoxOptions();
        firefoxOptions.addArguments(Constants.BROWSER_HEADLESS_ARG,Constants.BROWSER_DIS_GPU_ARG,Constants.BROWSER_RESOLUTION_ARG);
        WebDriverManager.firefoxdriver().setup();
        return new FirefoxDriver(firefoxOptions);
    }

    public static WebDriver initializeEdgeDriver()
    {
        EdgeOptions edgeOptions=new EdgeOptions();
        edgeOptions.addArguments(Constants.BROWSER_HEADLESS_ARG,Constants.BROWSER_DIS_GPU_ARG,Constants.BROWSER_RESOLUTION_ARG);
        WebDriverManager.edgedriver().setup();
        return new EdgeDriver(edgeOptions);
    }



    @AfterMethod(alwaysRun = true)
    public void tearDown()
    {
        driver.quit();
    }


















}
