package scenarios.DueDateReports.BDDS;

import baseClass.BaseClass;
import iSAFE.ApplicationKeywords;
import pages.ManageSettingsDefaultsPage;
import pages.ReportPage;

public class DDR_BDDS_17 extends ApplicationKeywords{
	
	BaseClass obj;
	private Boolean status = false;
	ReportPage reportPage;
	ManageSettingsDefaultsPage defaultsPage;
	
	public DDR_BDDS_17(BaseClass obj) {
		super(obj);
		this.obj = obj;
		
	}
	
	public void dDR_BDDS_17() {
		
		String reportLink=retrieve("Report Link");
		String runReportButton=retrieve("Run Report Button");
		String reportPageTitle=retrieve("Report Page Title");
		String dropdownLabel1=retrieve("dropdownLabel1");
		String headerResponsiblePerson = retrieve("header Responsible Person");
		String dropdownLabel2=retrieve("dropdownLabel2");
		String headerTaxManager=retrieve("header Tax Manager");
		String dropdownLabel3=retrieve("dropdownLabel3");
		String headerAuditStaff=retrieve("header Audit Staff");
		String radioButtonName=retrieve("Radio Button Label");
		
		reportPage = new ReportPage(obj);
		defaultsPage=new ManageSettingsDefaultsPage(obj);
		
		reportPage.clickUtilitiesIcon(true);
		defaultsPage.clickManageSettingsDefaults();
		defaultsPage.clickEditRoleName();
		defaultsPage.clickUseDefaultsRadioButton(radioButtonName);
		defaultsPage.clickSaveRoleNames();
		
		reportPage.clickReportTab(true);
		reportPage.clickReportLink(reportLink);
		reportPage.clickDropDown(dropdownLabel1);
		reportPage.selectDropDownPopupFirstValue(headerResponsiblePerson);
		reportPage.clickDropDownClose();
		reportPage.clickDropDown(dropdownLabel2);
		reportPage.selectDropDownPopupFirstValue(headerTaxManager);
		reportPage.clickDropDownClose();
		reportPage.clickDropDown(dropdownLabel3);
		reportPage.selectDropDownPopupFirstValue(headerAuditStaff);
		reportPage.clickDropDownClose();
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
