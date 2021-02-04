package iSAFE;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;

import automationFramework.APIKeywords;
import baseClass.BaseClass;

public class ApplicationKeywords extends APIKeywords {

	public ApplicationKeywords(BaseClass obj) {
		super(obj);
	}

	public ApplicationKeywords() {

	}

	/*
	 * @param :
	 * 
	 * @method : This method wait for page to load.
	 * 
	 * @author :
	 * 
	 * @since :
	 */
	public void waitForPageToLoad() {
		try {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			for (int i = 0; i < 20000; i++) {
				String status = js.executeScript("return document.readyState").toString();
				if (status.equals("complete")) {
					Thread.sleep(3000);
					testStepPassed("The page " + driver.getTitle() + " loaded successfully");
					break;
				}

			}
		} catch (Exception e) {
			testStepFailed("An exception occurred waitForPageToLoad() " + e.getMessage());
			e.printStackTrace();
		}
	}

	
	
	
	/*
	 * @param : Window index
	 * 
	 * @method : This method is used to transfer control to required window.
	 * 
	 * @author :
	 * 
	 * @since :
	 */
	public void transferControlToWindow(int index) {
		try {
			waitTime(5);
			Set<String> AllHandles = driver.getWindowHandles();
			List<String> HandlesToList = new ArrayList<String>();
			HandlesToList.addAll(AllHandles);

			if (index == 1) {
				for (int iterBrowWind = 1; iterBrowWind < HandlesToList.size(); iterBrowWind++) {
					driver.switchTo().window(HandlesToList.get(iterBrowWind));
					driver.close();
				}
			}

			if (index <= HandlesToList.size()) {
				driver.switchTo().window(HandlesToList.get(index - 1));
			} else {
				testStepFailed("The given window \"" + index + "\" is failed to open");
			}

		} catch (Exception e) {
			testStepFailed("Exception : " + e.getMessage());
		}
	}

	/*
	 * @param : Expected Title
	 * 
	 * @method : This method validates the Report Page title.
	 * 
	 * @author :
	 * 
	 * @since :
	 */
	public long validateReportPageTitle(String expectedTitle) {
		long endTime = 0;
		try {
			waitTime(10);
			driver.manage().timeouts().implicitlyWait(2, TimeUnit.MINUTES);
			// waiting for timeout of 2min .
			//  driver.manage().timeouts().implicitlyWait(8, TimeUnit.MINUTES);
			String reportTitle="dropdValue Value #cssSelector=td>div";
			List<WebElement> headers = findWebElements(reportTitle);
			if (headers.size() > 0) {
				for (int header=0;header<headers.size();header++) {
					if (headers.get(header).getText().trim().equals(expectedTitle)) {
						endTime = System.currentTimeMillis();
						//System.out.println(headers.get(header).getText());
						testStepPassed(expectedTitle +" Report Window has opened Successfully.");
						break;
					}
					else if (header == (headers.size() - 1)) {
						testStepInfo(expectedTitle + " Report not generated .");
						testStepFailed(expectedTitle + "Report not generated -Issue in the Report.");
						
					}
				}
			}
		} catch (Exception e) {
			testStepFailed("Exception : " + e.getMessage());
		}
		return endTime;
	}

	/*
	 * @param : Element
	 * 
	 * @method : Verify's Element visibility
	 * 
	 * @author :
	 * 
	 * @since :
	 */
	public boolean isElementDisplay(WebElement locator) {
		boolean locatorFlag = false;
		try {
			driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
			if (locator.isDisplayed()) {
				locatorFlag = true;
			}
		} catch (NoSuchElementException e) {
			locatorFlag = false;
			return locatorFlag;
		}
		return locatorFlag;
	}

	/*
	 * @param : startTime and endTime
	 * 
	 * @method : This method calculates the time taken.
	 * 
	 * @author :
	 * 
	 * @since :
	 */
	public void calcualtedReportOpenedTime(long startTime, long endTime) {
		try {
			
			if(endTime>0)
			{
			long totalTimeTaken = endTime - startTime;
			String reportTitle=driver.getTitle();
			System.out.println("Time taken to open the "+ reportTitle+ " report is: " + totalTimeTaken + " Milli Seconds.");
			testStepInfo("Time taken to open the "+ reportTitle+ " report is: " + totalTimeTaken + " Milli Seconds.");
			}
		} catch (Exception e) {
			testStepFailed("Exception : " + e.getMessage());
		}
	}

	/*
	 * @param :
	 * 
	 * @method : This method validates the existence of file in given location for maximum up to 1 minute.
	 * 
	 * @author :
	 * 
	 * @since :
	 */
	public long validateFileExists(String fileType) {
		long endTime = 0;
		try {
			String reportTitle=driver.getTitle();
			for (int fileExists = 0; fileExists < 100; fileExists++) {    // for large firm change 100sec to more depending on srs.
				Thread.sleep(1000);
				int files = new File("./Downloads").listFiles().length;
				if (files > 0) {
					endTime = System.currentTimeMillis();
					testStepPassed(reportTitle+ " " +fileType +" File has downloaded successfully.");
					Thread.sleep(5000);
					//FileUtils.cleanDirectory(new File("./Downloads"));  To retain the files in folder
					FileUtils.cleanDirectory(new File("./Downloads"));
					break;
				} else if (fileExists == 100) {  // for large firm change 100sec to more depending on srs.[ same as above]
					testStepInfo("Unable to download " + fileType + " file.");
				}
			}

		} catch (Exception e) {
			testStepInfo("Exception : " + e.getMessage());
		}
		return endTime;

	}
	
	public long validateFileExistsAndSave(String fileType) {
		long endTime = 0;
		try {
			String reportTitle=driver.getTitle();
			for (int fileExists = 0; fileExists < 100; fileExists++) {    // for large firm change 100sec to more depending on srs.
				Thread.sleep(1000);
				int files = new File("./Downloads").listFiles().length;
				if (files > 0) {
					endTime = System.currentTimeMillis();
					testStepPassed(reportTitle+ " " +fileType +" File has downloaded successfully.");
					Thread.sleep(5000);
					//FileUtils.cleanDirectory(new File("./Downloads"));  //To retain /retain the files in download folder
					break;
				} else if (fileExists == 100) {  // for large firm change 100sec to more depending on srs.[ same as above]
					testStepInfo("Unable to download " + fileType + " file.");
				}
			}

		} catch (Exception e) {
			testStepInfo("Exception : " + e.getMessage());
		}
		return endTime;

	}
	
	

}