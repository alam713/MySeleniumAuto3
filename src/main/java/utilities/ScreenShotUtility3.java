package utilities;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class ScreenShotUtility3 {
	
	 public static void takeScreenshot(WebDriver driver, String filePath) {
	        File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
	        try {
	            Files.createDirectories(Paths.get(filePath).getParent());
	            Files.copy(scrFile.toPath(), Paths.get(filePath), StandardCopyOption.REPLACE_EXISTING);
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	    }
	}


