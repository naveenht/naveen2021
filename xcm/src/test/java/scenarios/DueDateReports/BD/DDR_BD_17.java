package scenarios.DueDateReports.BD;


import baseClass.BaseClass;
import iSAFE.ApplicationKeywords;
import pages.ReportPage;
import pages.ManageSettingsDefaultsPage;

public class DDR_BD_17 extends ApplicationKeywords {
	

	BaseClass obj;
	private Boolean status = false;
	ReportPage reportPage;
	ManageSettingsDefaultsPage defaultsPage;
	
	
	public DDR_BD_17(BaseClass obj) {
		super(obj);
		this.obj = obj;
	}
	
	
	public void dDR_BD_17() {
		
		String reportLink=retrieve("Report Link");
		String runReportButton=retrieve("Run Report Button");
		String reportPageTitle=retrieve("Report Page Title");
		String headerResponsiblePerson = retrieve("header Responsible Person");
		String headerTaxManager=retrieve("header Tax Manager");
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
		reportPage.clickRoleNameDropDown(headerResponsiblePerson);
		reportPage.clickRoleNameDropDown(headerTaxManager);
		reportPage.clickRoleNameDropDown(headerAuditStaff);
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
