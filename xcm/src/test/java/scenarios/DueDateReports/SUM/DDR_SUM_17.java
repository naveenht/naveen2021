package scenarios.DueDateReports.SUM;

import baseClass.BaseClass;
import iSAFE.ApplicationKeywords;
import pages.ManageSettingsDefaultsPage;
import pages.ReportPage;

public class DDR_SUM_17 extends ApplicationKeywords {

	BaseClass obj;
	private Boolean status = false;
	ReportPage reportPage;
	ManageSettingsDefaultsPage defaultsPage;

	public DDR_SUM_17(BaseClass obj) {
		super(obj);
		this.obj = obj;
	}

	public void dDR_SUM_17() {

		String reportLink = retrieve("Report Link");
		String runReportButton = retrieve("Run Report Button");
		String reportPageTitle = retrieve("Report Page Title");
		String dropdownLabel1 = retrieve("Dropdown Label1");
		String dropdownLabel2 = retrieve("Dropdown Label2");
		String dropdownLabel3 = retrieve("Dropdown Label3");
		String radioButtonName = retrieve("Radio Button Label");

		reportPage = new ReportPage(obj);
		defaultsPage = new ManageSettingsDefaultsPage(obj);

		reportPage.clickUtilitiesIcon(true);
		defaultsPage.clickManageSettingsDefaults();
		defaultsPage.clickEditRoleName();
		defaultsPage.clickUseDefaultsRadioButton(radioButtonName);
		
		defaultsPage.clickSaveRoleNames();
		reportPage.clickReportTab(true);
		reportPage.clickReportLink(reportLink);
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
