package utils;


import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import lombok.SneakyThrows;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.IOException;

public class ListnerClass implements ITestListener {

    private ExtentReport extentReport;

    @Override
    public void onStart(ITestContext context) {
        extentReport=new ExtentReport();
        extentReport.extentReportSetup(context);
    }

    @Override
    public void onTestStart(ITestResult result) {
        extentReport.extentTestCreation(result);
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        extentReport.extentTestCasePass(result);
    }

    @Override
    public void onTestFailure(ITestResult result) {
        try {
            extentReport.extentTestCaseFail(result);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        extentReport.extentTestCaseSkipped(result);
    }

    @Override
    public void onFinish(ITestContext context) {
        extentReport.extentReportWindUp();
    }
}
