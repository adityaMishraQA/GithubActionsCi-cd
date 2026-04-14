package testPages;

import baseTest.BaseTest;
import org.testng.annotations.Test;

public class Test1 extends BaseTest {

    @Test(groups = "smoke")
    public void test1()
    {
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");
        System.out.println("Only smoke suite");

    }



    @Test(groups = "regression")
    public void test2()
    {
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");
        System.out.println("only regression suite");

    }

    @Test(groups = {"smoke","regression"})
    public void test3()
    {
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");
        System.out.println("Both smoke and regression");

    }

    @Test(groups = "smoke")
    public void test4()
    {
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");
        System.out.println("only smoke 2nd suite");

    }@Test(groups = "feature")
    public void test5()
    {
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");
        System.out.println("Feature testing script running");

    }


}
