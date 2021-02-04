package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import baseClass.BaseClass;
import iSAFE.ApplicationKeywords;

public class ManageSettingsDefaultsPage  extends ApplicationKeywords{
	
	private static final String Frame = "Frame path#xpath=//div/iframe";
	private static final String editRoleName="Edit Role Names #cssSelector=[id*='ContentPlaceHolder1_editrolerow_Sign']";
	private static final String manageSettingsDefaults="Manage settings and defaults#cssSelector=a[id*='ContentPlaceHolder1_LinkManageFirmSettings']";
	private static final String useDefaults_RadioButton="Use Defaults Radio button #cssSelector=table[id*='editroleRadioButtonList'] td";
	private static final String saveRoleName_btn="Save role name #cssSelector=[id*='ContentPlaceHolder1_SRoles']";
	BaseClass obj;

	public ManageSettingsDefaultsPage(BaseClass obj) {
		super(obj);
		this.obj = obj;
	}
	
	/*
	 * @param :
	 * 
	 * @method : This method click's Manage Settings and Defaults Link.
	 * 
	 * @author :
	 * 
	 * @since :
	 */
	public void clickManageSettingsDefaults() {
		try {
			switchToFrame(Frame);
			mouseOver(manageSettingsDefaults);
			if (isElementDisplayed(manageSettingsDefaults)) {
				clickOn(manageSettingsDefaults);
			} else {
				testStepFailed("Manage Settings Defaults link is unable to click in utilities Page");
			}
			switchToDefaultFrame();
		} catch (Exception e) {
			testStepFailed("Exception:" + e.getMessage());
		}
	}
	
	/*
	 * @param :
	 * 
	 * @method : This method click's Edit Role Name Link.
	 * 
	 * @author :
	 * 
	 * @since :
	 */
	public void clickEditRoleName() {
		try {
			switchToFrame(Frame);
			waitForElement(editRoleName);
			if (isElementDisplayed(editRoleName)) {
				clickOn(editRoleName);
			} else {
				testStepFailed("Edit role name link is unable to click in utilities Page");
			}
			switchToDefaultFrame();
		} catch (Exception e) {
			testStepFailed("Exception:" + e.getMessage());
		}
	}
	
	/*
	 * @param : LabelName
	 * 
	 * @method : This method click's radio button based on label name.
	 * 
	 * @author :
	 * 
	 * @since :
	 */
	public void clickUseDefaultsRadioButton(String labelName) {
		try {
			switchToFrame(Frame);
			waitForElement(useDefaults_RadioButton);
			List<WebElement> radiobtns = findWebElements(useDefaults_RadioButton);
			for (int label = 0; label < radiobtns.size(); label++) {
				String label_rt = radiobtns.get(label).findElement(By.tagName("label")).getText();
				if (labelName.trim().equalsIgnoreCase(label_rt)) {
					radiobtns.get(label).findElement(By.tagName("input")).click();
					testStepPassed("Use Defaults Radio Button is selected in utilities Page");
					waitForPageToLoad();
					break;
				} else if (label == radiobtns.size() - 1) {
					testStepFailed("Use Defaults Radio Button is unable to click in utilities Page");
				}
			}
			switchToDefaultFrame();
		}
    	catch (Exception e) {
    		testStepFailed("Exception:" + e.getMessage());
		}
	}
	/*
	 * @param :
	 * 
	 * @method : This method click's Save Role Name's Button.
	 * 
	 * @author :
	 * 
	 * @since :
	 */
	public void clickSaveRoleNames() {
		try {
			switchToFrame(Frame);
			if (isElementDisplayed(saveRoleName_btn)) {
				clickOn(saveRoleName_btn);
				waitTime(3);
				if (isAlertWindowPresent()) {
					alertOk();
				}
				testStepPassed("Save role name button is clicked successfully.");
			} else {
				testStepFailed("Unable Save role name button");
			}
			switchToDefaultFrame();
		} catch (Exception e) {
			testStepFailed("Exception:" + e.getMessage());
		}
	}
	
	
	
	
	
}
