package scenarios.TaskDetailReports.BA;

import java.util.concurrent.TimeUnit;

import baseClass.BaseClass;
import iSAFE.ApplicationKeywords;
import pages.ManageSettingsDefaultsPage;
import pages.ReportPage;

public class TDR_BA_01 extends ApplicationKeywords {

	BaseClass obj;
	private Boolean status = false;
	ReportPage reportPage;
	ManageSettingsDefaultsPage defaultsPage;

	public TDR_BA_01(BaseClass obj) {
		super(obj);
		this.obj = obj;
	}

	public void tDR_BA_01() {

		String reportLink = retrieve("Report Link");
		String fiscalYearLabel = retrieve("Fiscal Year Label");
		String fiscalYearValue = retrieve("Fiscal Year Value");
		String typeOfTaskLabel = retrieve("Type Of Task Label");
		String typeOfTaskValue = retrieve("Type Of Task Value");
		String dropdownHeaderLabel = retrieve("Dropdown Header Label");
		String statusLabel = retrieve("Status Label");
		String dropdownHeaderLabel1 = retrieve("Dropdown Header Label1");
		String dropdownLabel1 = retrieve("Dropdown Label1");
		
		String dropdownLabel2 = retrieve("Dropdown Label2");
		
		String dropdownLabel3 = retrieve("Dropdown Label3");
		
		String radioButtonName = retrieve("Radio Button Label");
		String originatingLocationLabel=retrieve("Originating Location Label");
		String currentLocationLabel=retrieve("Current Location Label");

		reportPage = new ReportPage(obj);
		defaultsPage = new ManageSettingsDefaultsPage(obj);
		reportPage.clickUtilitiesIcon(true);
		defaultsPage.clickManageSettingsDefaults();
		defaultsPage.clickEditRoleName();
		defaultsPage.clickUseDefaultsRadioButton(radioButtonName);
		defaultsPage.clickSaveRoleNames();
		reportPage.clickReportTab(true);
		reportPage.clickReportLink(reportLink);
		
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

		reportPage.selectRoleNameDropDownValue(originatingLocationLabel);
		
		reportPage.selectRoleNameDropDownValue(currentLocationLabel);
		reportPage.clickDropDown(typeOfTaskLabel);
		reportPage.selectDropDownPopupValue(dropdownHeaderLabel, typeOfTaskValue);
		reportPage.clickDropDownClose();
		reportPage.verifySelectedDropDownValue(typeOfTaskValue);

		reportPage.clickDropDown(statusLabel);
		reportPage.selectDropDownPopupFirstValue(dropdownHeaderLabel1);
		//reportPage.selectDropDownPopupValue(dropdownHeaderLabel1, statusValue);
		reportPage.clickDropDownClose();
		reportPage.validateFiscalYearDropDown(fiscalYearLabel);
		reportPage.selectDropDownValue(fiscalYearLabel, fiscalYearValue);
		reportPage.selectRoleNameDropDownValue(dropdownLabel1);
		reportPage.selectRoleNameDropDownValue(dropdownLabel2);
		reportPage.selectRoleNameDropDownValue(dropdownLabel3);	
		
		
		long startTime = reportPage.clickExportButton(true);
		long endTime = obj.validateFileExists("");
		reportPage.calcualtedReportOpenedTime(startTime, endTime);
		obj.transferControlToWindow(1);

		if (obj.testFailure || reportPage.testFailure) {
			status = true;
		}
		this.testFailure = status;
	}

}