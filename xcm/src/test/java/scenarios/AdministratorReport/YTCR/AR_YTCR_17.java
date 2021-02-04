package scenarios.AdministratorReport.YTCR;

import baseClass.BaseClass;
import iSAFE.ApplicationKeywords;
import pages.ManageSettingsDefaultsPage;
import pages.ReportPage;

public class AR_YTCR_17 extends ApplicationKeywords {

	BaseClass obj;
	private Boolean status = false;
	ReportPage reportPage;
	ManageSettingsDefaultsPage defaultsPage;

	public AR_YTCR_17(BaseClass obj) {
		super(obj);
		this.obj = obj;

	}

	public void aR_YTCR_17() {

		String reportLink=retrieve("Report Link");
		String runReportButton=retrieve("Run Report Button");
		String reportPageTitle=retrieve("Report Page Title");
		String dropdownLabel1=retrieve("Dropdown Label1");
		String dropdownLabel2=retrieve("Dropdown Label2");
		String dropdownLabel3=retrieve("Dropdown Label3");
		String radioButtonName=retrieve("Radio Button Label");
		
		String fromDateLabel = retrieve("From Date Label");
		String fromDateValue = retrieve("From Date Value");
		String toDateLabel = retrieve("To Date Label");
		String toDateValue = retrieve("To Date Value");
		
		reportPage = new ReportPage(obj);
		defaultsPage=new ManageSettingsDefaultsPage(obj);
		
		
		
		reportPage.clickUtilitiesIcon(true);
		defaultsPage.clickManageSettingsDefaults();
		defaultsPage.clickEditRoleName();
		defaultsPage.clickUseDefaultsRadioButton(radioButtonName);
		defaultsPage.clickSaveRoleNames();
		reportPage.clickReportTab(true);
		reportPage.clickReportLink(reportLink);
		reportPage.selectCalenderPopup(fromDateLabel);
		reportPage.selectDate(fromDateValue);
		reportPage.selectCalenderPopup(toDateLabel);
		reportPage.selectDate(toDateValue);
		reportPage.clickRoleNameDropDown(dropdownLabel1);
		reportPage.clickRoleNameDropDown(dropdownLabel2);
		reportPage.clickRoleNameDropDown(dropdownLabel3);
		reportPage.verifyButton(runReportButton, true);
		obj.transferControlToWindow(2);
		obj.validateReportPageTitle(reportPageTitle);
		obj.transferControlToWindow(1);
		

		if (obj.testFailure || reportPage.testFailure) {
			status = true;
		}
		this.testFailure = status;
	}

}
