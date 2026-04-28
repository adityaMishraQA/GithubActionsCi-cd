package utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import org.testng.ITestContext;
import org.testng.ITestResult;

import java.io.IOException;

public final class  ExtentReport extends ScreenShot {

    private  ExtentSparkReporter sparkReporter;
    private  ExtentReports reports;
    private  ExtentTest test;
    private static ThreadLocal<ExtentTest> testThreadLocal=new ThreadLocal<>();

    public  void extentReportSetup(ITestContext context)
    {
        sparkReporter=new ExtentSparkReporter("target/extent-Report/extent.html");
        sparkReporter.config().setDocumentTitle("Automation Report");
        sparkReporter.config().setReportName(context.getName());
        sparkReporter.config().setTheme(Theme.DARK);
        reports=new ExtentReports();
        reports.attachReporter(sparkReporter);
    }

    public  void extentTestCreation(ITestResult result)
    {
        test=reports.createTest(result.getName());
        testThreadLocal.set(test);
    }

    public  void extentTestCasePass(ITestResult result)
    {
        testThreadLocal.get().log(Status.PASS,"Test case got passed: "+result.getName());
    }

    public  void extentTestCaseFail(ITestResult result) throws IOException {
        testThreadLocal.get().log(Status.FAIL,"Test case got FAILED: "+result.getName());
        testThreadLocal.get().log(Status.FAIL,"Failed due to: "+result.getThrowable());
        String path=takeScreenshot();
        testThreadLocal.get().addScreenCaptureFromBase64String(path,"Screenshot_Failue");

    }

    public  void extentTestCaseSkipped(ITestResult result)
    {
        testThreadLocal.get().log(Status.SKIP,"Test case SKIPPED: "+result.getName());
    }

    public  void extentReportWindUp()
    {
        reports.flush();
    }

}
