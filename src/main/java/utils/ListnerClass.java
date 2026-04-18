package utils;


import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class ListnerClass implements ITestListener {
    private ExtentSparkReporter sparkReporter;
    private ExtentReports reports;
    private ExtentTest test;

    @Override
    public void onStart(ITestContext context) {
        sparkReporter=new ExtentSparkReporter("target/extent-testReports/extent.html");
        sparkReporter.config().setDocumentTitle("Automation Report");
        sparkReporter.config().setReportName(context.getName());
        sparkReporter.config().setTheme(Theme.DARK);
        reports=new ExtentReports();
        reports.attachReporter(sparkReporter);
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        test=reports.createTest(result.getName());
        test.log(Status.PASS,"Test has been Passed: "+result.getName());
    }

    @Override
    public void onTestFailure(ITestResult result) {
        test=reports.createTest(result.getName());
        test.log(Status.FAIL,"Test Failed: "+result.getName());
        test.log(Status.FAIL,"Failed Due to: "+result.getThrowable());
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        test=reports.createTest(result.getName());
        test.log(Status.SKIP,"Test has been Skipped: "+result.getName());
    }

    @Override
    public void onFinish(ITestContext context) {
        reports.flush();
    }
}
