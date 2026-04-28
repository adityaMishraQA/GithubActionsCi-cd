package driverManagment;

import org.openqa.selenium.WebDriver;

public final class DriverManage {
    private static ThreadLocal<WebDriver> threadLocal=new ThreadLocal<>();

    public static void setDriver(WebDriver driver)
    {
        threadLocal.set(driver);
    }

    public static WebDriver getDriver()
    {
        return threadLocal.get();
    }
}
