package pages;

import java.text.DateFormat;
import java.text.DateFormatSymbols;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import baseClass.BaseClass;
import iSAFE.ApplicationKeywords;

public class ReportPage extends ApplicationKeywords {

	private static final String pageHeader_ReportPage = "\"User Report\" page #cssSelector=table[id='ContentPlaceHolder1_CPATable']";
	private static final String frameWindow = "Frame #cssSelector=div>iframe";
	private static final String selectDataIn_radiobtns = "Select Data In Radio Buttons #cssSelector=td";
	private static final String clear_btn = "Clear Link #cssSelector=tr[id*='Periodendonafter'] a";
	private static final String reports_label = "Name labels #cssSelector=td";
	private static final String choose_link = "Choose Link#cssSelector=a[id*='chooseid']";
	private static final String export_button = "Export Button #cssSelector=input[value='Export']";
	private static final String Frame = "Frame path#xpath=//div/iframe";
	private static final String cloumn_checkbox = "Default Column Checkboxs #cssSelector=div#TasktypePickListUpdatePane td";
	private static final String reports_tab = "Reports tab #cssSelector=a[id='reportslink']";
	private static final String report_links = "Report links #cssSelector=#ContentPlaceHolder1_CPATable a";
	private static final String drpdown_close = "Close#cssSelector=div[id*='ContentPlaceHolder1'] td[class='menu'] a";
	private static final String txt_drpValue = "Drop Down Value#cssSelector=span[style*='display:inline']";
	private static final String utilitesButton = "Utilities button icon #cssSelector=#displayfirmname +div div[class*='wheel']";
	private static final String dropdown_value = "Drop Down Values #cssSelector=div[id*='ContentPlaceHolder']";
	private static final String dropd_value = "dropdValue Value #cssSelector=li div";
	private static final String columnHeader_chkboxs = "Column Header check boxs #cssSelector=#TasktypePickListUpdatePane input";
	private static final String reportWindow_columnHeaders = "dropdValue Value #cssSelector=td>div";
	private static final String originatingLocation_dropdown = "Originating Location Dropdown #cssSelector=#ContentPlaceHolder1_OriginalLocationNameid";
	private static final String popup = "#cssSelector=div[class='ui positive circular button']";
	
	private static final String export_button1 = "Export Button #cssSelector=input[value='Export To Excel']";// task detailed expanded

	
	public ReportPage(BaseClass obj) {
		super(obj);
	}

	/*
	 * @param :
	 * 
	 * @method : Selecting the columns header based on input number.
	 * 
	 * @author :
	 * 
	 * @since :
	 */

	
	public List<String> selectColumnHeaderCheckbox(String headerNum) {
		int headerNumber = Integer.parseInt(headerNum);

		List<String> headerLabels = new ArrayList<String>();
		try {
			List<WebElement> headers = findWebElements(columnHeader_chkboxs);
			if (headers.size() > headerNumber) {
				for (int head = 0; head < headerNumber; head++) {
					headers.get(head).click();
					String headerLabel = headers.get(head).getAttribute("value").trim();
					headerLabels.add(headerLabel);
					testStepPassed("Column header \"" + headerLabel + "\" is selected.");
				}
			} else {
				testStepFailed("No Column headers are displayed");
			}
		} catch (Exception e) {
			testStepFailed("Exception:" + e.getMessage());
		}
		return headerLabels;

	}

	/*
	 * @param : selected column headers
	 * 
	 * @method : This method validates the selected column headers are displayed in
	 * report window or not.
	 * 
	 * @author :
	 * 
	 * @since :
	 */

	public void validateColumnHeaders(List<String> selectedHeaders) {
		try {
			waitTime(5);
			boolean flag = true;
			List<WebElement> headers = findWebElements(reportWindow_columnHeaders);
			if (headers.size() > 0) {
				for (WebElement header : headers) {
					if (header.getText().trim().contains("No records found for your search criteria.")) {
						testStepPassed("No records found in generated report.");
						flag = false;
						break;
					}
				}
			}
			if (flag) {
				for (WebElement header : headers) {
					if (selectedHeaders.contains(header.getText().replace(".", "").trim())) {
						testStepPassed("Column header \"" + header.getText() + "\" is displayed in Report Window.");
						selectedHeaders.remove(header.getText().replace(".", "").trim());
					}
				}
				if (selectedHeaders.size() > 0) {
					for (String header : selectedHeaders) {
						testStepInfo("Column header \"" + header + "\" is not displayed in Report Window.");
					}
				}
			}
		} catch (Exception e) {
			testStepFailed("Exception:" + e.getMessage());
		}
	}

	/*
	 * @param :
	 * 
	 * @method :
	 * 
	 * @author :
	 * 
	 * @since :
	 */

	public void verifyReportPage() {
		switchToFrame(frameWindow);
		try {
			if (isElementPresent(pageHeader_ReportPage)) {
				testStepPassed("\"Report\" page is present");
			} else {
				testStepFailed("\"Reports\" page is failed to display");
			}
		} catch (Exception e) {
			testStepFailed("Exception:" + e.getMessage());
		}
		switchToDefaultFrame();
	}

	/*
	 * @param : Label name and Corresponding value
	 * 
	 * @method : This method is used to select value from drop down based on label
	 * name.
	 * 
	 * @author :
	 * 
	 * @since :
	 */

	public void selectDropDownValue(String labelName, String dropdownValue) {
		JavascriptExecutor javascriptExecutor = (JavascriptExecutor) driver;
		try {
			waitTime(2);
			switchToDefaultFrame();
			switchToFrame(Frame);
			List<WebElement> labels = findWebElements(reports_label);
			for (int labelindex = 0; labelindex < labels.size(); labelindex++) {
				String clientEntitytext_rt = labels.get(labelindex).getText().replace(":", "").trim();
				if (clientEntitytext_rt.equalsIgnoreCase(labelName)) {
					WebElement dropdown = labels.get(labelindex + 1).findElement(By.tagName("select"));
					javascriptExecutor.executeScript("arguments[0].scrollIntoView(true);", dropdown);
					Select selectDropdown = new Select(dropdown);
					if (dropdownValue.trim().equalsIgnoreCase("all") || dropdownValue.trim().equalsIgnoreCase("Select")
							|| dropdownValue.trim().equalsIgnoreCase("Show All")) {
						selectDropdown.selectByIndex(0);
					} else {
						selectDropdown.selectByVisibleText(dropdownValue);
					}
					testStepPassed(labelName + " is entered Successfully");
					break;
				} else if (labelindex == (labels.size() - 1)) {
					testStepFailed("Failed to  enter the " + labelName);
				}
			}
			switchToDefaultFrame();
		} catch (Exception e) {
			testStepFailed("Exception:" + e.getMessage());
		}
	}

	/*
	 * @param : Label name and Corresponding value
	 * 
	 * @method : This method is used to select value from drop down based on label for category expansion changes
	 * name.
	 * 
	 * @author :
	 * 
	 * @since :
	 */
	
	
	
	public void selectDropDownValueCategory(String labelName, String dropdownValue) {
		JavascriptExecutor javascriptExecutor = (JavascriptExecutor) driver;
		try {
			waitTime(2);
			switchToDefaultFrame();
			switchToFrame(Frame);
			List<WebElement> labels = findWebElements(reports_label);
			for (int labelindex = 0; labelindex < labels.size(); labelindex++) {
				String clientEntitytext_rt = labels.get(labelindex).getText().replace(":", "").trim();
				if (clientEntitytext_rt.equalsIgnoreCase(labelName)) {
					WebElement dropdown = labels.get(labelindex + 1).findElement(By.tagName("select"));
					javascriptExecutor.executeScript("arguments[0].scrollIntoView(true);", dropdown);
					Select selectDropdown = new Select(dropdown);
					if (dropdownValue.trim().equalsIgnoreCase("all") || dropdownValue.trim().equalsIgnoreCase("Select")
							|| dropdownValue.trim().equalsIgnoreCase("Show All")) {
						selectDropdown.selectByIndex(5);
					} else {
						selectDropdown.selectByVisibleText(dropdownValue);
					}
					testStepPassed(labelName + " is entered Successfully");
					break;
				} else if (labelindex == (labels.size() - 1)) {
					testStepFailed("Failed to  enter the " + labelName);
				}
			}
			switchToDefaultFrame();
		} catch (Exception e) {
			testStepFailed("Exception:" + e.getMessage());
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	/*
	 * @param : Label name
	 * 
	 * @method : This method is used to select value from drop down based on label
	 * name.
	 * 
	 * @author :
	 * 
	 * @since :
	 */

	public String selectRoleNameDropDownValue(String labelName) {
		String dropDoenValue_rt = null;
		try {
			waitTime(2);
			switchToDefaultFrame();
			switchToFrame(Frame);
			List<WebElement> labels = findWebElements(reports_label);
			for (int labelindex = 0; labelindex < labels.size(); labelindex++) {
				String clientEntitytext_rt = labels.get(labelindex).getText().replace(":", "").trim();
				if (clientEntitytext_rt.equalsIgnoreCase(labelName)) {
					WebElement dropdown = labels.get(labelindex + 1).findElement(By.tagName("select"));
					Select selectDropdown = new Select(dropdown);
					selectDropdown.selectByIndex(1);
					dropDoenValue_rt = selectDropdown.getOptions().get(1).getText();
					testStepPassed("Dropdown value is Selected Successfully");
					break;
				} else if (labelindex == (labels.size() - 1)) {
					testStepFailed("Failed to Select the drop down Value");
				}
			}
			switchToDefaultFrame();
		} catch (Exception e) {
			testStepFailed("Exception:" + e.getMessage());
		}
		return dropDoenValue_rt;
	}

	/*
	 * @param : Label name and Corresponding selected value
	 * 
	 * @method : This method is used to verify the drop down value is present or not
	 * 
	 * @author :
	 * 
	 * @since :
	 */

	public String getSelectedDropDownValue(String labelName, String selectedValue) {
		String savedValue_rt = "";
		try {
			waitTime(2);
			switchToDefaultFrame();
			switchToFrame(Frame);
			List<WebElement> labels = findWebElements(reports_label);
			for (int labelindex = 0; labelindex < labels.size(); labelindex++) {
				String clientEntitytext_rt = labels.get(labelindex).getText().replace(":", "").trim();
				if (clientEntitytext_rt.equalsIgnoreCase(labelName.trim())) {
					WebElement dropdown = labels.get(labelindex + 1).findElement(By.tagName("select"));
					Select sc = new Select(dropdown);
					WebElement option = sc.getFirstSelectedOption();
					savedValue_rt = option.getText();
					if (selectedValue.trim().equals(savedValue_rt)) {
						testStepPassed(labelName + " is saved Successfully");
						break;
					}
				} else if (labelindex == (labels.size() - 1)) {
					testStepFailed("Failed to  saved the " + labelName);
				}
			}
			switchToDefaultFrame();
		} catch (Exception e) {
			testStepFailed("Exception:" + e.getMessage());
		}
		return savedValue_rt;
	}

	/*
	 * @param :Lable Name and Corresponding Text Value
	 * 
	 * @method : This method is used to enter the text value based on the label name
	 * 
	 * @author :
	 * 
	 * @since :
	 */

	public void enterInputTextValue(String labelName, String nameText) {
		try {
			waitTime(2);
			switchToDefaultFrame();
			switchToFrame(Frame);
			List<WebElement> labels = findWebElements(reports_label);
			for (int labelindex = 0; labelindex < labels.size(); labelindex++) {
				String clientEntitytext_rt = labels.get(labelindex).getText().trim();
				if (clientEntitytext_rt.equalsIgnoreCase(labelName.trim())) {
					labels.get(labelindex + 1).findElement(By.tagName("input")).sendKeys(nameText);
					testStepPassed(nameText + " is entered Successfully aganist " + labelName);
					break;
				} else if (labelindex == (labels.size() - 1)) {
					testStepFailed("Not able to find " + labelName);
				}
			}
			switchToDefaultFrame();

		} catch (Exception e) {
			testStepFailed("Exception:" + e.getMessage());
		}
	}

	/*
	 * @param :Lable name and corresponding value
	 * 
	 * @method : This method is used to click on the save pop up button based on the
	 * label name
	 * 
	 * @author :
	 * 
	 * @since :
	 */

	public String enterTextInSaveCustomReportPopup(String labelName, String inputValue) {
		String formattedDate = null;
		try {
			switchToDefaultFrame();
			switchToFrame(Frame);
			String customReportPopup = "Clear Link #cssSelector=table[id*='FilterNamePopup'] td";
			List<WebElement> popupLabels = findWebElements(customReportPopup);
			for (int label = 0; label < popupLabels.size(); label++) {
				String labelText_rt = popupLabels.get(label).getText().replaceAll("\\:", "").trim();
				if (labelText_rt.equalsIgnoreCase(labelName.trim())) {
					Date date = new Date();
					String strDateFormat = "yyyyMMdd_hhmmss";
					DateFormat dateFormat = new SimpleDateFormat(strDateFormat);
					formattedDate = dateFormat.format(date);
					popupLabels.get(label + 1).findElement(By.tagName("input")).sendKeys(inputValue + formattedDate);
					testStepPassed(inputValue + " is entered aganist  " + labelName);
					break;
				}
				if (labelName.trim().contains("Report Description")) {
					WebElement textBox = popupLabels.get(label + 1).findElement(By.tagName("textarea"));
					textBox.clear();
					textBox.sendKeys(inputValue);
					testStepPassed(inputValue + " is entered aganist  " + labelName);
					break;
				} else if (label == (popupLabels.size() - 1)) {
					testStepFailed("Not able to find " + labelName);
				}

			}

			switchToDefaultFrame();
		} catch (Exception e) {
			testStepFailed("Exception:" + e.getMessage());
		}

		return inputValue + formattedDate;
	}

	/*
	 * @param : Lable name
	 * 
	 * @method : This method is used to click the buttons based on the label name[save and close]
	 * 
	 * @author :
	 * 
	 * @since :
	 */

	public void verifySaveCustomReportPopupButtons(String buttonName) {
		try {
			switchToDefaultFrame();
			switchToFrame(Frame);
			String popupButtons = "Clear Link #cssSelector=table[id*='FilterNamePopup'] input[type=submit]";
			List<WebElement> buttons = findWebElements(popupButtons);
			for (int button = 0; button < buttons.size(); button++) {
				String buttonLabel = buttons.get(button).getAttribute("value").trim();
				if (buttonLabel.equalsIgnoreCase(buttonName.trim())) {
					if (buttons.get(button).isDisplayed()) {
						buttons.get(button).click();
						waitTime(2);
						testStepPassed(buttonName + " is successfully clicked.");
						break;
					}
				} else if (button == (buttons.size() - 1)) {
					testStepFailed("Not able to find " + buttonName);
				}

			}
			switchToDefaultFrame();
		} catch (Exception e) {
			testStepFailed("Exception:" + e.getMessage());
		}
	}

	/*
	 * @param : Table name and corresponding label
	 * 
	 * @method : This method is used to get the position of the header present in
	 * the table based on the table name
	 * 
	 * @author :
	 * 
	 * @since :
	 */

	public int getSystemWideCustomReportsHeaderPosition(String tableName, String headerLabel) {
		int columnPosition = 0;
		List<WebElement> headers = null;
		try {
			switchToDefaultFrame();
			switchToFrame(Frame);
			if (tableName.trim().equalsIgnoreCase("System Wide")) {
				String systemWideCustomReports_headers = "System Wide Custom Reports Headers#cssSelector=table[id*='GridViewreportsfirm'] tr[class='bttntext'] th";
				headers = findWebElements(systemWideCustomReports_headers);
			} else if (tableName.trim().equalsIgnoreCase("My Reports")) {
				String systemWideCustomReports_headers = "System Wide Custom Reports Headers#cssSelector=table[id$='GridViewreports'] tr[class='bttntext'] th";
				headers = findWebElements(systemWideCustomReports_headers);
			}
			for (int header = 0; header < headers.size(); header++) {
				String headerText_rt = headers.get(header).getText().trim().replaceAll("^ +| +$|( )+", "$1");
				if (headerLabel.trim().equalsIgnoreCase(headerText_rt)) {
					columnPosition = header + 1;
					break;
				} else if (header == (headers.size() - 1)) {
					testStepFailed("Not able to find " + headerLabel);
				}
			}
			switchToDefaultFrame();
		} catch (Exception e) {
			testStepFailed("Exception:" + e.getMessage());
		}
		return columnPosition;
	}

	/*
	 * @param : Table name , column position and corresponding value
	 * 
	 * @method : This method is used to get the position of the row for a particular
	 * value present in the table based on the table name and column value
	 * 
	 * @author :
	 * 
	 * @since :
	 */

	public int getRowPositionValue(String tableName, int columnPosition, String value) {
		int rowPosition = 0;
		List<WebElement> columnValues = null;
		try {
			switchToDefaultFrame();
			switchToFrame(Frame);
			if (tableName.trim().equalsIgnoreCase("System Wide")) {
				String tableRows = "#cssSelector=table[id*='GridViewreportsfirm'] tr>td:nth-child(" + columnPosition
						+ ")";
				columnValues = findWebElements(tableRows);
			} else if (tableName.trim().equalsIgnoreCase("My Reports")) {
				String tableRows = "#cssSelector=table[id$='GridViewreports'] tr>td:nth-child(" + columnPosition + ")";
				columnValues = findWebElements(tableRows);
			}
			for (int position = 0; position < columnValues.size(); position++) {
				String positionValue_rt = columnValues.get(position).getText();
				if (positionValue_rt.equalsIgnoreCase(value.trim())) {
					testStepPassed(value + " is existed in the custom reports");
					rowPosition = position + 2;
					break;
				} else if (position == (columnValues.size() - 1)) {
					testStepFailed("Not able to find " + value);
				}
			}
			switchToDefaultFrame();
		} catch (Exception e) {
			testStepFailed("Exception:" + e.getMessage());
		}
		return rowPosition;
	}

	/*
	 * @param : Lable name and corresponding column position
	 * 
	 * @method : This method is used to click the link present in the table based on
	 * the column position
	 * 
	 * @author :
	 * 
	 * @since :
	 */

	public void clickExistingRecordLink(String tableName, int columnPosition) {
		String positionLink = null;
		try {
			switchToDefaultFrame();
			switchToFrame(Frame);
			waitTime(4);
			if (tableName.trim().equalsIgnoreCase("System Wide")) {
				positionLink = "#cssSelector=table[id*='GridViewreportsfirm'] tr>td:nth-child(" + columnPosition
						+ ") a";
			} else if (tableName.trim().equalsIgnoreCase("My Reports")) {
				positionLink = "#cssSelector=table[id$='GridViewreports'] tr>td:nth-child(" + columnPosition + ") a";
			}
			List<WebElement> tableRows = findWebElements(positionLink);
			for (WebElement link : tableRows) {
				String linkName_rt = link.getText();
				if (isElementDisplayed(positionLink)) {
					link.click();
					waitTime(2);
					testStepPassed(" " + linkName_rt + " Is Clicked Successfully For The Existing Record");
					waitTime(2);
					if (isAlertWindowPresent()) {
						alertOk();
						waitTime(4);
					}
					break;
				} else {
					testStepFailed("Not Able To Click " + linkName_rt + "");
				}
			}
			switchToDefaultFrame();
		} catch (Exception e) {
			testStepFailed("Exception:" + e.getMessage());
		}
	}

	/*
	 * @param :
	 * 
	 * @method : This method is used to click the first link present in the table
	 * based on the table name[ run and edit]
	 * 
	 * @author :
	 * 
	 * @since :
	 */

	public void clickExistingFirstLink(String tableName, int columnPosition) {
		String positionLink = null;
		try {
			switchToDefaultFrame();
			switchToFrame(Frame);
			if (tableName.trim().equalsIgnoreCase("System Wide")) {
				positionLink = "#cssSelector=table[id*='GridViewreportsfirm'] tr>td:nth-child(" + columnPosition
						+ ") input";
			} else if (tableName.trim().equalsIgnoreCase("My Reports")) {
				positionLink = "#cssSelector=table[id$='GridViewreports'] tr>td:nth-child(" + columnPosition
						+ ") input";
			}
			List<WebElement> tableRows = findWebElements(positionLink);
			for (WebElement link : tableRows) {
				String linkName_rt = link.getAttribute("value");
				if (isElementDisplayed(positionLink)) {
					link.click();
					testStepPassed(" " + linkName_rt + " is Clicked Successfully For The Existing Record");
					break;

				} else {
					testStepFailed("Not Able To Click " + linkName_rt + "");
				}
			}
			switchToDefaultFrame();
		} catch (Exception e) {
			testStepFailed("Exception:" + e.getMessage());
		}
	}

	/*
	 * @param: Table name , column position and row position
	 * 
	 * @method : This method is used to click the table link present in the table
	 * based on the table name, row position and column position
	 * 
	 * @author :
	 * 
	 * @since :
	 */

	public void clickTableLinkBasedOnPosition(String tableName, int columnPosition, int rowPosition) {
		String positionLink = null;
		try {
			switchToDefaultFrame();
			switchToFrame(Frame);
			if (tableName.trim().equalsIgnoreCase("System Wide")) {
				positionLink = "Link #cssSelector=table[id*='GridViewreportsfirm'] tr:nth-child(" + rowPosition
						+ ")>td:nth-child(" + columnPosition + ") input";
			} else if (tableName.trim().equalsIgnoreCase("My Reports")) {
				positionLink = "Link #cssSelector=table[id$='GridViewreports'] tr:nth-child(" + rowPosition
						+ ")>td:nth-child(" + columnPosition + ") input";
			}
			if (isElementDisplayed(positionLink)) {
				clickOn(positionLink);
				testStepPassed("Able to click the link at rowPosition and column Position " + rowPosition + ","
						+ columnPosition);
			} else {
				testStepFailed("Not able to click the link at rowPosition and column Position " + rowPosition + ","
						+ columnPosition);
			}
			switchToDefaultFrame();
		} catch (Exception e) {
			testStepFailed("Exception:" + e.getMessage());
		}
	}

	/*
	 * @param : Table name
	 * 
	 * @method : This method is used to verify the data present in the table based
	 * on the table name
	 * 
	 * @author :
	 * 
	 * @since :
	 */

	public boolean verifyTableData(String tableName) {
		boolean tablePresent = false;
		WebElement tableData = null;
		try {
			switchToDefaultFrame();
			switchToFrame(Frame);
			if (tableName.trim().equalsIgnoreCase("System Wide")) {
				tableData = driver.findElement(By.cssSelector("table[id*='GridViewreportsfirm']"));
			} else if (tableName.trim().equalsIgnoreCase("My Reports")) {
				tableData = driver.findElement(By.cssSelector("table[id$='GridViewreports']"));
			}
			tablePresent = isElementDisplay(tableData);
			switchToDefaultFrame();
		} catch (Exception e) {
			return tablePresent;
		}
		return tablePresent;
	}

	/*
	 * @param : Table name , column position and row position
	 * 
	 * @method : This method is used to click the table link present in the table
	 * based on the table name, row position and column position
	 * 
	 * @author :
	 * 
	 * @since :
	 */

	public void clickDeleteExistingReport(String tableName, int columnPosition, int rowPosition) {
		String positionLink = null;
		String linkName_rt = null;
		try {
			switchToDefaultFrame();
			switchToFrame(Frame);
			if (tableName.trim().equalsIgnoreCase("System Wide")) {
				positionLink = "Link #cssSelector=table[id*='GridViewreportsfirm'] tr:nth-child(" + rowPosition
						+ ")>td:nth-child(" + columnPosition + ") a";
			} else if (tableName.trim().equalsIgnoreCase("My Reports")) {
				positionLink = "Link #cssSelector=table[id$='GridViewreports'] tr:nth-child(" + rowPosition
						+ ")>td:nth-child(" + columnPosition + ") a";
			}
			if (isElementDisplayed(positionLink)) {
				linkName_rt = getText(positionLink);
				clickOn(positionLink);
				testStepPassed(linkName_rt + "is Successfully Clicked");
				waitTime(2);
				if (isAlertWindowPresent()) {
					alertOk();
				}
			} else {
				testStepFailed("Not able to click the " + linkName_rt + " link at rowPosition and column Position "
						+ rowPosition + "," + columnPosition);
			}
			switchToDefaultFrame();
		} catch (Exception e) {
			testStepFailed("Exception:" + e.getMessage());
		}
	}

	/*
	 * @param : Button name and boolean value
	 * 
	 * @method : This method is used to click on the button name based on the
	 * boolean value
	 * 
	 * @author :
	 * 
	 * @since :
	 */

	public long verifyButton(String buttonName, boolean isClick) {
		JavascriptExecutor javascriptExecutor = (JavascriptExecutor) driver;
		long startTime = 0;
		try {
			switchToDefaultFrame(); //reset button unique comapre to other buttons.
			switchToFrame(Frame);
			Actions actions = new Actions(driver);
			if (buttonName.trim().equals("Reset")) {
				WebElement el = driver.findElement(By.xpath("//input[@type='reset' or @value='Reset']"));
				javascriptExecutor.executeScript("arguments[0].scrollIntoView(true);", el);
				if (isClick) {
					actions.moveToElement(el).click().build().perform();
					waitForPageToLoad();
				}
			} else {
				String runReport_btn = "Run Report Button#cssSelector=td>input";
				List<WebElement> buttons = findWebElements(runReport_btn);
				for (int button = 0; button < buttons.size(); button++) {
					String buttonLabel = buttons.get(button).getAttribute("value").trim();
					if (buttonLabel.equalsIgnoreCase(buttonName.trim())) {
						if (buttons.get(button).isDisplayed()) {
							testStepPassed("\"" + buttonName + "\" button is clicked Successfully.");
							if (isClick) {
								javascriptExecutor.executeScript("arguments[0].scrollIntoView(true);",
										buttons.get(button));
								javascriptExecutor.executeScript("arguments[0].click();", buttons.get(button));
								startTime = System.currentTimeMillis();
								testStepPassed("\"" + buttonName + "\" button is present in Reports page.");
								waitForPageToLoad();
								break;
							}
						}
					} else if (button == (buttons.size() - 1)) {
						testStepFailed("Not able to find " + buttonName);
					}
				}
			}
			switchToDefaultFrame();
		} catch (Exception e) {
			testStepFailed("Exception:" + e.getMessage());
		}
		return startTime;
	}

	/*
	 * @param : Button name and boolean value
	 * 
	 * @method : This method is used to click on the buttons present on the save
	 * custom report pop up based on the boolean value
	 * 
	 * @author :
	 * 
	 * @since :
	 */

	public void verifyChooseButtons(String buttonName, boolean isClick) {
		JavascriptExecutor javascriptExecutor = (JavascriptExecutor) driver;
		try {
			waitTime(3);
			String runReport_btn = "Run Report Button#cssSelector=tr input";
			List<WebElement> buttons = findWebElements(runReport_btn);
			for (int button = 0; button < buttons.size(); button++) {
				String buttonLabel = buttons.get(button).getAttribute("value").trim();
				if (buttonLabel.equalsIgnoreCase(buttonName.trim())) {
					if (buttons.get(button).isDisplayed()) {
						testStepPassed("\"" + buttonName + "\" button is present in Reports page.");
						if (isClick) {
							javascriptExecutor.executeScript("arguments[0].scrollIntoView(true);", buttons.get(button));
							javascriptExecutor.executeScript("arguments[0].click();", buttons.get(button));
							waitTime(2);
							break;
						}
					}
				} else if (button == (buttons.size() - 1)) {
					testStepFailed("Not able to find " + buttonName);
				}
			}

		} catch (Exception e) {
			testStepFailed("Exception:" + e.getMessage());
		}
	}

	/*
	 * @param : Boolaen value
	 * 
	 * @method : This method is used to click the date clear button based on the
	 * boolean value[ Not used]
	 * 
	 * @author :
	 * 
	 * @since :
	 */

	public void verifyPeriodEndDateClearButton(boolean isClick) {
		try {
			switchToDefaultFrame();
			switchToFrame(Frame);
			if (isElementDisplayed(clear_btn)) {
				testStepPassed("\"Clear \" Link is present in Reports Page.");
				if (isClick) {
					clickOn(clear_btn);
				}
			} else {
				testStepFailed("\"Clear\" Link failed to display in Reports Page.");
			}

			switchToDefaultFrame();
		} catch (Exception e) {
			testStepFailed("Exception:" + e.getMessage());
		}
	}

	/*
	 * @param : Lable name and corresponding value
	 * 
	 * @method : This method is used to click on radio button based on the label
	 * name
	 * 
	 * @author :
	 * 
	 * @since :
	 */

	public void clickRadioButton(String labelname, String radioLabel) {
		try {
			JavascriptExecutor javascriptExecutor = (JavascriptExecutor) driver;
			switchToDefaultFrame();
			switchToFrame(Frame);
			waitTime(2);
			List<WebElement> radiobtns = findWebElements(selectDataIn_radiobtns);
			for (int label1 = 0; label1 < radiobtns.size(); label1++) {
				String labelText_rt = radiobtns.get(label1).getText().replaceAll("\\:", "").trim();
				if (labelText_rt.equalsIgnoreCase(labelname.trim())) {
					List<WebElement> labels = radiobtns.get(label1 + 1).findElements(By.tagName("label"));
					for (int label2 = 0; label2 < labels.size(); label2++) {
						if (labels.get(label2).getText().trim().equalsIgnoreCase(radioLabel.trim())) {
							List<WebElement> btns = radiobtns.get(label1 + 1).findElements(By.tagName("input"));
							javascriptExecutor.executeScript("arguments[0].scrollIntoView(true);", btns.get(label2));
							javascriptExecutor.executeScript("arguments[0].click();", btns.get(label2));
							testStepPassed(radioLabel + " is Successfully clicked.");
							break;
						}
					}
					break;
				} else if (label1 == (radiobtns.size() - 1)) {
					testStepFailed("Unable to find the " + radioLabel + " radio button label.");
				}
			}
			switchToDefaultFrame();
		} catch (Exception e) {
			testStepFailed("Exception:" + e.getMessage());
		}
	}

	/*
	 * @param : Lable name
	 * 
	 * @method : This method is used to click on the buttons present in the choose
	 * link pop up based on the label name[ Not used]
	 * 
	 * @author :
	 * 
	 * @since :
	 */

	@SuppressWarnings("unused")
	public void clickChooseLinkCheckBox(String checkboxLabel) {
		try {
			switchToDefaultFrame();
			switchToFrame(Frame);
			List<WebElement> radiobtns = findWebElements(cloumn_checkbox);
			for (int label1 = 0; label1 < radiobtns.size(); label1++) {
				List<WebElement> labels = radiobtns.get(label1).findElements(By.tagName("label"));
				for (int label2 = 0; label2 < labels.size(); label2++) {
					if (labels.get(label2).getText().trim().contains(checkboxLabel.trim())) {
						List<WebElement> checkBoxs = radiobtns.get(label1).findElements(By.tagName("input"));
						if (!checkBoxs.get(label2).isSelected()) {
							checkBoxs.get(label2).click();
							testStepPassed(checkboxLabel + " is Successfully clicked.");
							break;
						}
					}
					break;
				}
				if (label1 == (radiobtns.size() - 1)) {
					testStepFailed("Unable to find the " + checkboxLabel + " radio button label.");
				}
			}
			switchToDefaultFrame();
		} catch (Exception e) {
			testStepFailed("Exception:" + e.getMessage());
		}
	}

	/*
	 * @param :
	 * 
	 * @method : This method is used to click on the choose link
	 * 
	 * @author :
	 * 
	 * @since :
	 */

	public void clickChooseLink() {
		try {
			switchToDefaultFrame();
			switchToFrame(Frame);
			if (isElementDisplayed(choose_link)) {
				clickOn(choose_link);
			} else {
				testStepFailed("\"Choose\" Link failed to display in Reports Page.");
			}
			switchToDefaultFrame();
		} catch (Exception e) {
			testStepFailed("Exception:" + e.getMessage());
		}
	}

	/*
	 * @param : Lable name
	 * 
	 * @method : This method is used to click on the file download option based on
	 * the label name
	 * 
	 * @author :
	 * 
	 * @since :
	 */

	public long clickOnExcelCSVReports(String reportLinkName) {
		long startTime = 0;
		JavascriptExecutor javascriptExecutor = (JavascriptExecutor) driver;
		try {
			String report_links = "Run Report Button#cssSelector=table a";
			List<WebElement> links = findWebElements(report_links);
			for (int label = 0; label < links.size(); label++) {
				String name = links.get(label).getAttribute("title").trim();
				if (name.equalsIgnoreCase(reportLinkName) || name.contains(reportLinkName)) {
					// links.get(label).click();
					javascriptExecutor.executeScript("arguments[0].click();", links.get(label));
					startTime = System.currentTimeMillis();
					break;
				}
			}

		} catch (Exception e) {
			testStepFailed("Exception:" + e.getMessage());
		}

		return startTime;
	}

	/*
	 * @param :
	 * 
	 * @method : This method is used to click on the report tab based on the boolean
	 * value
	 * 
	 * @author :
	 * 
	 * @since :
	 */

	public void clickReportTab(boolean isClick) {
		try {
			if (isElementPresent(popup)) {      // latest chnages on build popup.
				clickOn(popup);
			}
			switchToDefaultFrame();
			if (isElementDisplayed(reports_tab)) {
				testStepInfo("Reports page is displayed successfully");
				waitTime(3);
				if (isClick) {
					clickOn(reports_tab);
				}
			} else {
				testStepFailed("Reports tab is not displayed.");
			}
			waitForPageToLoad();
		} catch (Exception e) {
			testStepFailed("Exception:" + e.getMessage());
		}
	}

	/*
	 * @param :
	 * 
	 * @method : This method is used to click on the report tab based on the boolean
	 * value
	 * 
	 * @author :
	 * 
	 * @since :
	 */

	public long clickExportButton(boolean isClick) {
		long startTime = 0;
		try {
			switchToDefaultFrame();
			switchToFrame(Frame);
			if (isElementDisplayed(export_button)) {
				testStepInfo("Export button is displayed successfully");
				if (isClick) {
					clickOn(export_button);
					startTime = System.currentTimeMillis();
				}
			} else {
				testStepFailed("Reports tab is not displayed.");
			}
			waitForPageToLoad();
		} catch (Exception e) {
			testStepFailed("Exception:" + e.getMessage());
		}
		return startTime;
	}

	
	/*
	 * @param :
	 * 
	 * @method : This method is used to click on the export button for task detailed expanded report 
	 * value
	 * 
	 * @author :
	 * 
	 * @since :
	 */

	public long clickExportButtonExpand(boolean isClick) {
		long startTime = 0;
		try {
			switchToDefaultFrame();
			switchToFrame(Frame);
			if (isElementDisplayed(export_button1)) {
				testStepInfo("Export button is displayed successfully");
				if (isClick) {
					clickOn(export_button1);
					startTime = System.currentTimeMillis();
				}
			} else {
				testStepFailed("Reports tab is not displayed.");
			}
			waitForPageToLoad();
		} catch (Exception e) {
			testStepFailed("Exception:" + e.getMessage());
		}
		return startTime;
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	/*
	 * @param : Label name
	 * 
	 * @method : This method is used to click on the report link based on the label
	 * name
	 * 
	 * @author :
	 * 
	 * @since :
	 */

	public void clickReportLink(String linkLabel) {
		try {
			switchToFrame(Frame);
			List<WebElement> links = findWebElements(report_links);
			for (int link = 0; link < links.size(); link++) {
				String linkText_rt = links.get(link).getText();
				if (linkText_rt.equalsIgnoreCase(linkLabel)) {
					links.get(link).click();
					testStepInfo(linkLabel + " Report link is clicked Successfully");
					waitTime(2);
					break;
				} else if (link == links.size() - 1) {
					testStepFailed(linkLabel + " Report link is not displayed.");
				}
			}
			switchToDefaultFrame();
		} catch (Exception e) {
			testStepFailed("Exception:" + e.getMessage());
		}
	}

	/*
	 * @param : Label name
	 * 
	 * @method : This method is used to click on the calendar pop up based on the
	 * label name
	 * 
	 * @author :
	 * 
	 * @since :
	 */

	public void selectCalenderPopup(String labelName) {
		try {
			waitTime(2);
			switchToDefaultFrame();
			switchToFrame(Frame);
			List<WebElement> labels = findWebElements(reports_label);
			for (int labelindex = 0; labelindex < labels.size(); labelindex++) {
				String clientEntitytext_rt = labels.get(labelindex).getText().trim();
				if (clientEntitytext_rt.equalsIgnoreCase(labelName.trim())) {
					labels.get(labelindex + 1).findElement(By.tagName("input")).click();
					waitTime(2);
					testStepPassed(labelName + " is entered Successfully aganist ");
					break;
				} else if (labelindex == (labels.size() - 1)) {
					testStepFailed("Not able to find " + labelName);
				}
			}
			switchToDefaultFrame();

		} catch (Exception e) {
			testStepFailed("Exception:" + e.getMessage());
		}
	}

	/*
	 * @param : Label name
	 * 
	 * @method : This method is used to click on the drop down based on the Label
	 * name
	 * 
	 * @author :
	 * 
	 * @since :
	 */

	public void clickDropDown(String labelName) {
		try {
			waitTime(2);
			switchToDefaultFrame();
			switchToFrame(Frame);
			List<WebElement> labels = findWebElements(reports_label);
			for (int labelindex = 0; labelindex < labels.size(); labelindex++) {
				String clientEntitytext = labels.get(labelindex).getText().trim();
				if (clientEntitytext.equalsIgnoreCase(labelName)) {
					WebElement dropdown = labels.get(labelindex + 1).findElement(By.tagName("select"));
					dropdown.click();
					break;
				} else if (labelindex == (labels.size() - 1)) {
					testStepFailed("Failed to  enter the " + labelName);
				}
			}
			switchToDefaultFrame();
		} catch (Exception e) {
			testStepFailed("Exception:" + e.getMessage());
		}
	}

	/*
	 * @param :
	 * 
	 * @method : This method is used to click on the originating location drop down
	 * 
	 * @author :
	 * 
	 * @since :
	 */

	public void clickOriginatingLocationDropDown() {
		try {
			waitTime(2);
			switchToDefaultFrame();
			switchToFrame(Frame);
			WebElement dropdown = findWebElement(originatingLocation_dropdown);
			if (dropdown.isDisplayed()) {
				dropdown.click();
			} else {
				testStepFailed("Failed to  Click the Dropdown");
			}
			switchToDefaultFrame();
		} catch (Exception e) {
			testStepFailed("Exception:" + e.getMessage());
		}
	}
	/*
	 * @param :
	 * 
	 * @method : This method is used select the drop down value based on the label
	 * name
	 * 
	 * @author :multiselect
	 * 
	 * @since :
	 */

	public void selectDropDownPopupValue(String headerLabelValue, String inputValue) {
		try {
			boolean trueFlag = false;
			switchToDefaultFrame();
			switchToFrame(Frame);
			List<WebElement> dropDown_lists = findWebElements(dropdown_value);
			for (int iteration = 0; iteration < dropDown_lists.size(); iteration++) {
				List<WebElement> labels = dropDown_lists.get(iteration).findElements(By.tagName("td"));
				for (int label = 0; label < labels.size(); label++) {
					String labelText_rt = labels.get(label).getText();
					if (labelText_rt.contains(headerLabelValue)) {
						WebElement dropDown_list = dropDown_lists.get(iteration).findElement(By.tagName("Select"));
						Select dropDownValues = new Select(dropDown_list);
						if (inputValue.trim().equalsIgnoreCase("all") || inputValue.trim().equalsIgnoreCase("Select")
								|| inputValue.trim().equalsIgnoreCase("Show All")) {
							dropDownValues.selectByIndex(0);
							trueFlag = true;
						} else {
							dropDownValues.deselectAll();
							dropDownValues.selectByVisibleText(inputValue);
							testStepPassed(inputValue + " is selected from Dropdown list.");
							trueFlag = true;
						}

						break;
					}
				}
				if (trueFlag) {
					break;
				}

			}
			switchToDefaultFrame();
		} catch (Exception e) {
			testStepFailed("Exception:" + e.getMessage());
		}
	}

	/*
	 * @param : Drop down header label
	 * 
	 * @method : This method is used to select first drop down value based on the
	 * Drop down header label
	 * 
	 * @author :
	 * 
	 * @since :
	 */

	@SuppressWarnings("unused")
	public void selectDropDownPopupFirstValue(String headerLabelValue) {
		try {
			boolean trueFlag = false;
			switchToDefaultFrame();
			switchToFrame(Frame);
			List<WebElement> dropDown_lists = findWebElements(dropdown_value);
			for (int iteration = 0; iteration < dropDown_lists.size(); iteration++) {
				List<WebElement> labels = dropDown_lists.get(iteration).findElements(By.tagName("td"));
				for (int label = 0; label < labels.size(); label++) {
					String labelText_rt = labels.get(label).getText();
					if (labelText_rt.contains(headerLabelValue)) {
						WebElement dropDown_list = dropDown_lists.get(iteration).findElement(By.tagName("Select"));
						Select dropDownValues = new Select(dropDown_list);
						System.out.println(dropDownValues.getOptions().size());
						dropDownValues.deselectAll();
						dropDownValues.selectByIndex(0); // change index accordinly to select other in the list.
						trueFlag = true;
					}
					break;
				}
				if (trueFlag) {
					break;
				}

			}
			switchToDefaultFrame();
		} catch (Exception e) {
			testStepFailed("Exception:" + e.getMessage());
		}
	}

	/*
	 * @param : Drop down header label
	 * 
	 * @method : This method is used to select SECOND drop down value based on the
	 * Drop down header label
	 * 
	 * @author :
	 * 
	 * @since :
	 */

	@SuppressWarnings("unused")
	public void selectDropDownPopupSecondValue(String headerLabelValue) {
		try {
			boolean trueFlag = false;
			switchToDefaultFrame();
			switchToFrame(Frame);
			List<WebElement> dropDown_lists = findWebElements(dropdown_value);
			for (int iteration = 0; iteration < dropDown_lists.size(); iteration++) {
				List<WebElement> labels = dropDown_lists.get(iteration).findElements(By.tagName("td"));
				for (int label = 0; label < labels.size(); label++) {
					String labelText_rt = labels.get(label).getText();
					if (labelText_rt.contains(headerLabelValue)) {
						WebElement dropDown_list = dropDown_lists.get(iteration).findElement(By.tagName("Select"));
						Select dropDownValues = new Select(dropDown_list);
						System.out.println(dropDownValues.getOptions().size());
						dropDownValues.deselectAll();
						dropDownValues.selectByIndex(1); // change index accordinly to select other in the list.
						trueFlag = true;
					}
					break;
				}
				if (trueFlag) {
					break;
				}

			}
			switchToDefaultFrame();
		} catch (Exception e) {
			testStepFailed("Exception:" + e.getMessage());
		}
	}
	
	
	
	@SuppressWarnings("unused")
	public void selectDropDownPopupCategoryValue(String headerLabelValue) {
		try {
			boolean trueFlag = false;
			switchToDefaultFrame();
			switchToFrame(Frame);
			List<WebElement> dropDown_lists = findWebElements(dropdown_value);
			for (int iteration = 0; iteration < dropDown_lists.size(); iteration++) {
				List<WebElement> labels = dropDown_lists.get(iteration).findElements(By.tagName("td"));
				for (int label = 0; label < labels.size(); label++) {
					String labelText_rt = labels.get(label).getText();
					if (labelText_rt.contains(headerLabelValue)) {
						WebElement dropDown_list = dropDown_lists.get(iteration).findElement(By.tagName("Select"));
						Select dropDownValues = new Select(dropDown_list);
						System.out.println(dropDownValues.getOptions().size());
						dropDownValues.deselectAll();
						dropDownValues.selectByIndex(4); // change index accordinly to select other in the list.
						trueFlag = true;
					}
					break;
				}
				if (trueFlag) {
					break;
				}

			}
			switchToDefaultFrame();
		} catch (Exception e) {
			testStepFailed("Exception:" + e.getMessage());
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	/*
	 * @param : Drop down value
	 * 
	 * @method : This method is used to verify the selected drop down value is
	 * present based on the value
	 * 
	 * @author :
	 * 
	 * @since :
	 */

	public void clickDropDownClose() {
		try {
			switchToDefaultFrame();
			switchToFrame(Frame);
			JavascriptExecutor javascriptExecutor = (JavascriptExecutor) driver;
			List<WebElement> close_btn = findWebElements(drpdown_close);
			for (int label = 0; label < close_btn.size(); label++) {
				String labelText_rt = close_btn.get(label).getText().trim();
				if (labelText_rt.equalsIgnoreCase("Close")) {
					javascriptExecutor.executeScript("arguments[0].click();", close_btn.get(label));
					break;
				} else if (label == (close_btn.size() - 1)) {
					testStepFailed("Failed to find " + labelText_rt + " Link.");
				}
			}
			switchToDefaultFrame();
		} catch (Exception e) {
			testStepFailed("Exception:" + e.getMessage());
		}
	}

	/*
	 * @param : Drop down value
	 * 
	 * @method : This method is used to verify the selected drop down value is
	 * present based on the value[ down the filter page]
	 * 
	 * @author :
	 * 
	 * @since :
	 */

	public void verifySelectedDropDownValue(String selectedValue) {
		try {
			switchToDefaultFrame();
			switchToFrame(Frame);
			List<WebElement> dropDownValues = findWebElements(txt_drpValue);
			for (int iteration = 0; iteration < dropDownValues.size(); iteration++) {
				String value_rt = dropDownValues.get(iteration).getText().trim();
				if (value_rt.equalsIgnoreCase(selectedValue)) {
					testStepPassed(value_rt + " is selected from dropdown list.");
					break;
				} else if (iteration == (dropDownValues.size() - 1)) {
					testStepPassed(value_rt + " is not present displayed in dropdown selected Values.");
					break;
				}
			}
			switchToDefaultFrame();
		} catch (Exception e) {
			testStepFailed("Exception:" + e.getMessage());
		}
	}

	/*
	 * @param : Year value
	 * 
	 * @method : This method is used to select the year on the calendar based on the
	 * input year value
	 * 
	 * @author :
	 * 
	 * @since :
	 */

	public void selectYear(String inputYear) {
		int year_ip;
		List<WebElement> yearElements = null;
		try {
			switchToDefaultFrame();
			switchToFrame(Frame);
			String yearValue = "Year #cssSelector=#CalendarControl td[class='title']";
			if (inputYear.length() == 2) {
				year_ip = Integer.parseInt("20" + inputYear);
			} else {
				year_ip = Integer.parseInt(inputYear);
			}
			int year_rt = Integer.parseInt(getText(yearValue).split("\n")[1]);
			int difference = Math.abs(year_ip - year_rt);
			if (year_ip > year_rt) {
				for (int iteration = 0; iteration < difference; iteration++) {
					yearElements = driver.findElements(By.cssSelector("#CalendarControl td[class='next'] a"));
					for (WebElement element : yearElements) {
						String attributeValue = element.getAttribute("href");
						if (attributeValue.contains("Year")) {
							element.click();
							break;
						}
					}
				}
			} else if (year_ip < year_rt) {
				for (int iteration = 0; iteration < difference; iteration++) {
					yearElements = driver.findElements(By.cssSelector("#CalendarControl td[class='previous'] a"));
					for (WebElement element : yearElements) {
						String attributeValue = element.getAttribute("href");
						if (attributeValue.contains("Year")) {
							element.click();
							break;
						}
					}
				}
			}
			switchToDefaultFrame();
		} catch (Exception e) {
			testStepFailed("Exception:" + e.getMessage());
		}
	}

	/*
	 * @param : Month value
	 * 
	 * @method : This method is used to select the method based on the input month
	 * value
	 * 
	 * @author :
	 * 
	 * @since :
	 */

	public void selectMonth(String inputMonth) {
		boolean matchedMonth = false;
		try {
			int monthIndex = Integer.parseInt(inputMonth);
			String monthName = new DateFormatSymbols().getMonths()[monthIndex - 1];
			switchToDefaultFrame();
			switchToFrame(Frame);
			for (int iteration = 0; iteration < 12; iteration++) {
				List<WebElement> links = driver.findElements(By.cssSelector("#CalendarControl td[class='previous'] a"));
				String monthTitle = "Year #cssSelector=#CalendarControl td[class='title']";
				String month_rt = getText(monthTitle).split("\n")[0];
				for (WebElement previousLink : links) {
					String attributeValue = previousLink.getAttribute("href");
					if (attributeValue.contains("Month")) {
						if (monthName.equalsIgnoreCase(month_rt)) {
							matchedMonth = true;
							break;
						} else {
							previousLink.click();
							break;
						}
					}
				}
				if (matchedMonth == true) {
					break;
				}
			}
			switchToDefaultFrame();
		} catch (Exception e) {
			testStepFailed("Exception:" + e.getMessage());
		}
	}

	/*
	 * @param : Day value
	 * 
	 * @method : This method is used to select the day based on the input day value
	 * 
	 * @author :
	 * 
	 * @since :
	 */

	public void selectDay(String inputDay) {
		try {
			switchToDefaultFrame();
			switchToFrame(Frame);
			Integer day_tmp = Integer.parseInt(inputDay);
			String day_ip = day_tmp.toString();
			List<WebElement> days = driver.findElements(By.xpath(
					"//*[@id='CalendarControl']//tr//td//a[@class='weekday' or @class='current' or @class='weekend']"));
			for (WebElement dayLink : days) {
				String day_rt = dayLink.getText().trim();
				if (day_rt.equals(day_ip)) {
					dayLink.click();
					break;
				}
			}
			switchToDefaultFrame();
		} catch (Exception e) {
			testStepFailed("Exception:" + e.getMessage());
		}
	}

	/*
	 * @param : Date value
	 * 
	 * @method : This method is used to select the date based on the input date
	 * value
	 * 
	 * @author :
	 * 
	 * @since :
	 */

	public void selectDate(String date) {
		try {
			String year = date.split("/")[2];
			String day = date.split("/")[0];
			String month = date.split("/")[1];
			selectMonth(month);
			selectYear(year);
			selectDay(day);
			testStepPassed(date + " is entered in date field.");
		} catch (Exception e) {
			testStepFailed("Exception:" + e.getMessage());
		}
	}

	/*
	 * @param : Boolean value
	 * 
	 * @method : This method is used to click on the utilities icon based the
	 * boolean value
	 * 
	 * @author :
	 * 
	 * @since :
	 */

	public void clickUtilitiesIcon(boolean isClick) {
		try {
			if (isElementDisplayed(utilitesButton)) {
				testStepPassed("Utilites icon is successfully clicked.");
				if (isClick) {
					clickOn(utilitesButton);
					waitForPageToLoad();
				}

			} else {
				testStepFailed("Utilites icon is not displayed.");
			}
		} catch (Exception e) {
			testStepFailed("Exception:" + e.getMessage());
		}
	}

	/*
	 * @param : header label
	 * 
	 * @method : This method is used to select all the dropdown values in the
	 * dropdown based on the header label[ Ori. loc]
	 * 
	 * @author :
	 * 
	 * @since :
	 */

	public void selectAllDropDownValues(String headerLabelValue) {
		try {
			boolean trueFlag = false;
			switchToDefaultFrame();
			switchToFrame(Frame);
			List<WebElement> dropDown_lists = findWebElements(dropdown_value);
			for (int iteration = 0; iteration < dropDown_lists.size(); iteration++) {
				List<WebElement> labels = dropDown_lists.get(iteration).findElements(By.tagName("td"));
				for (int label = 0; label < labels.size(); label++) {
					String labelText_rt = labels.get(label).getText();
					if (labelText_rt.contains(headerLabelValue)) {
						WebElement dropDown_list = dropDown_lists.get(iteration).findElement(By.tagName("Select"));
						Select dropDownValues = new Select(dropDown_list);
						dropDownValues.deselectAll();
						List<WebElement> allDropdownValues_rt = dropDownValues.getOptions();
						
						//for (int iteration1 = 0; iteration1 < 2; iteration1++) //selecting 2-3 or customised  values
						
						for (int iteration1 = 0; iteration1 < allDropdownValues_rt.size(); iteration1++) {
							dropDownValues.selectByIndex(iteration1);
							((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);",
									allDropdownValues_rt.get(iteration1));
						}
						List<WebElement> allSelectedDropdownValues = dropDownValues.getAllSelectedOptions();
						if (allSelectedDropdownValues.size() != 0) {
							testStepPassed("All dropdown are selected from Dropdown list.");
							trueFlag = true;
						} else {
							testStepFailed("Failed to Seleted the dropdown values");
							trueFlag = false;
							break;
						}

					}
				}
				if (trueFlag) {
					break;
				}

			}
			switchToDefaultFrame();
		} catch (Exception e) {
			testStepFailed("Exception:" + e.getMessage());
		}
	}

	/*
	 * @param : header label
	 * 
	 * @method : This method is used to select the first dropdown value in the role
	 * name dropdown based on the header label[ new UI dropdowns]
	 * 
	 * @author :
	 * 
	 * @since :
	 */
	public String clickRoleNameDropDown(String labelName) {
		String selectedDropdownValue=null;
		
		try {
			waitTime(2);
			switchToDefaultFrame();
			switchToFrame(Frame);
			List<WebElement> labels = findWebElements(reports_label);
			for (int labelindex = 0; labelindex < labels.size(); labelindex++) {
				String clientEntitytext = labels.get(labelindex).getText().replaceAll(":"," ").trim();
				if (clientEntitytext.equalsIgnoreCase(labelName)) {
					WebElement dropdown = labels.get(labelindex + 1).findElement(By.tagName("span"));
					dropdown.click();
					List<WebElement> labelsNames = findWebElements(dropd_value);
					for (int labelindex1 = 0; labelindex1 < labelsNames.size(); labelindex1++) {
						if (labelindex1 == 2) {
							selectedDropdownValue=labelsNames.get(labelindex1).getText();
							labelsNames.get(labelindex1).click();							
							testStepPassed(" Dropdown value is entered Successfully");
							break;
						} else if (labelsNames.size() == 0) {
							testStepFailed("Not able to find Drop down values");
						}
					}
					break;
				} else if (labelindex == (labels.size() - 1)) {
					testStepFailed("Failed to enter the " + labelName);
				}
			}
			switchToDefaultFrame();
		} catch (Exception e) {
			testStepFailed("Exception:" + e.getMessage());
		}
		return selectedDropdownValue;
	}

	/*
	 * @param : Table name , column position and row position
	 * 
	 * @method : This method is used to click the run button present in the table
	 * based on the table name, row position and column position
	 * 
	 * @author :
	 * 
	 * @since :
	 */

	public void clickExistingFirstLink(String tableName, int columnPosition, int rowPosition) {
		String positionLink = null;
		try {
			switchToDefaultFrame();
			switchToFrame(Frame);
			if (tableName.trim().equalsIgnoreCase("System Wide")) {
				positionLink = "#cssSelector=table[id*='GridViewreportsfirm'] tr:nth-child(" + rowPosition
						+ ")>td:nth-child(" + columnPosition + ") input";
			} else if (tableName.trim().equalsIgnoreCase("My Reports")) {
				positionLink = "#cssSelector=table[id$='GridViewreports'] tr:nth-child(" + rowPosition
						+ ")>td:nth-child(" + columnPosition + ") input";
			}
			List<WebElement> tableRows = findWebElements(positionLink);
			for (WebElement link : tableRows) {
				String linkName_rt = link.getAttribute("value");
				if (isElementDisplayed(positionLink)) {
					link.click();
					testStepPassed(" " + linkName_rt + " is Clicked Successfully For The Existing Record");
					break;

				} else {
					testStepFailed("Not Able To Click " + linkName_rt + "");
				}
			}
			switchToDefaultFrame();
		} catch (Exception e) {
			testStepFailed("Exception:" + e.getMessage());
		}
	}

	/*
	 * @param : Table name
	 * 
	 * @method : This method is used to get the rows count present in the table
	 * based on the table name
	 * 
	 * @author :
	 * 
	 * @since :
	 */

	public int getTabelRowsCount(String tableName) {
		int rowCount = 0;
		try {
			String positionLink = null;
			switchToDefaultFrame();
			switchToFrame(Frame);
			if (tableName.trim().equalsIgnoreCase("System Wide")) {
				positionLink = "#cssSelector=table[id*='GridViewreportsfirm'] tr";
			} else if (tableName.trim().equalsIgnoreCase("My Reports")) {
				positionLink = "#cssSelector=table[id$='GridViewreports'] tr";
			}
			List<WebElement> tableRows = findWebElements(positionLink);
			rowCount = tableRows.size();
			switchToDefaultFrame();
		} catch (Exception e) {
			testStepFailed("Exception:" + e.getMessage());
		}
		return rowCount;
	}

	/*
	 * @param : time value
	 * 
	 * @method : This method waits till page load based on time.
	 * 
	 * @author :
	 * 
	 * @since :
	 */
	public void waitForPageLoad(int timeInSeconds) {
		try {
			driver.manage().timeouts().implicitlyWait(timeInSeconds, TimeUnit.SECONDS);
		} catch (Exception e) {
			testStepFailed("Exception : " + e.getMessage());
		}
	}

	/*
	 * @param : Label name
	 * 
	 * @method : This method is used to validate the fiscal year drop down based on
	 * label name.[ archive and current years]
	 * 
	 * @author :
	 * 
	 * @since :
	 */

	public void validateFiscalYearDropDown(String labelName) {
		JavascriptExecutor javascriptExecutor = (JavascriptExecutor) driver;
		try {
			waitTime(2);
			switchToDefaultFrame();
			switchToFrame(Frame);
			ArrayList<String> dropDown_list = new ArrayList<String>();
			List<WebElement> labels = findWebElements(reports_label);
			for (int labelindex = 0; labelindex < labels.size(); labelindex++) {
				String clientEntitytext_rt = labels.get(labelindex).getText().replace(":", "").trim();
				if (clientEntitytext_rt.equalsIgnoreCase(labelName)) {
					WebElement dropdown = labels.get(labelindex + 1).findElement(By.tagName("select"));
					javascriptExecutor.executeScript("arguments[0].scrollIntoView(true);", dropdown);
					Select selectDropdown = new Select(dropdown);
					List<WebElement> dropDownValues = selectDropdown.getOptions();
					dropDownValues.remove(0);
					int dropDownValuesSize = dropDownValues.size();
					testStepInfo("Size of Fiscal Year Dropdown is : " + dropDownValuesSize);
					for (int index = 0; index < dropDownValues.size(); index++) {
						String dropDown_rt = dropDownValues.get(index).getText().trim();
						dropDown_list.add(dropDown_rt);
					}
					testStepInfo("Fiscal Year dropdown values are : " + dropDown_list);
					break;
				} else if (labelindex == (labels.size() - 1)) {
					testStepFailed("Failed to validate the " + labelName);
				}
			}
			switchToDefaultFrame();
		} catch (Exception e) {
			testStepFailed("Exception:" + e.getMessage());
		}
	}

	/*
	 * @param :
	 * 
	 * @method : This method is used select the drop down value based on the label
	 * name
	 * 
	 * @author :
	 * 
	 * @since :
	 */

	public void validateFiscalyearDropDownPopup(String headerLabel) {
		try {
			boolean trueFlag = false;
			switchToDefaultFrame();
			switchToFrame(Frame);
			ArrayList<String> dropDown_values = new ArrayList<String>();
			List<WebElement> dropDown_lists = findWebElements(dropdown_value);
			for (int iteration = 0; iteration < dropDown_lists.size(); iteration++) {
				List<WebElement> labels = dropDown_lists.get(iteration).findElements(By.tagName("td"));
				for (int label = 0; label < labels.size(); label++) {
					String labelText_rt = labels.get(label).getText();
					if (labelText_rt.contains(headerLabel)) {
						WebElement dropDown_list = dropDown_lists.get(iteration).findElement(By.tagName("Select"));
						Select dropDownValues = new Select(dropDown_list);
						if (headerLabel.trim().equalsIgnoreCase("Multiple Year Selection")) {
							List<WebElement> dropDownValues_rt = dropDownValues.getOptions();
							dropDownValues_rt.remove(0);
							int dropDownValuesSize = dropDownValues_rt.size();
							testStepInfo("Size of Fiscal Year Dropdown is : " + dropDownValuesSize);
							for (int index = 0; index < dropDownValues_rt.size(); index++) {
								String dropDown_rt = dropDownValues_rt.get(index).getText().trim();
								dropDown_values.add(dropDown_rt);
							}
							testStepInfo("Fiscal Year dropdown values are : " + dropDown_values);
							trueFlag = true;
						} else {
							testStepFailed("Failed to validate the Fiscal Year");
							trueFlag = true;
						}
						break;
					}
				}
				if (trueFlag) {
					break;
				}
			}
			switchToDefaultFrame();
		} catch (Exception e) {
			testStepFailed("Exception:" + e.getMessage());
		}
	}

}
