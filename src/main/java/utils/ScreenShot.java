package utils;

import driverManagment.DriverManage;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.io.FileHandler;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class ScreenShot {
    public String takeScreenshot() throws IOException {
        String screenshotBase64 = ((TakesScreenshot) DriverManage.getDriver()).getScreenshotAs(OutputType.BASE64);
//        File screenshotFile = ((TakesScreenshot) DriverManage.getDriver()).getScreenshotAs(OutputType.FILE);
//        LocalDateTime dateCurrent= LocalDateTime.now();
//        DateTimeFormatter timeFormatter=DateTimeFormatter.ofPattern("yyyy-MM-dd_HH-mm-ss");
//        String timeCurrent=dateCurrent.format(timeFormatter);
//        String path=".\\src\\test\\resources\\test-screenshot\\"+timeCurrent+".jpg";
//        FileHandler.copy(screenshotFile,new File(path));
        return screenshotBase64;
    }
}
