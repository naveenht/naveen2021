package scenarios.TaskDetailReports.SBD;

import baseClass.BaseClass;
import iSAFE.ApplicationKeywords;
import pages.Login_Logout;
import pages.ReportPage;

public class TDR_SBD_01 extends ApplicationKeywords {
	
	BaseClass obj;
	private Boolean status = false;
	Login_Logout loginLogout;

	public TDR_SBD_01(BaseClass obj){
		super(obj);
		this.obj=obj;
	}

	public void tDR_SBD_01(){

		ReportPage reportPage = new ReportPage(obj);

		
		String reportLink=retrieve("Report Link");
		String reportPageTitle=retrieve("Report Page Title");
		String runReportButton=retrieve("Run Report Button");

		reportPage.clickReportTab(true);
		reportPage.clickReportLink(reportLink);		
		reportPage.verifyButton(runReportButton, true);
		obj.transferControlToWindow(2);
		obj.validateReportPageTitle(reportPageTitle);
		obj.transferControlToWindow(1);


		if(reportPage.testFailure||obj.testFailure){
			status = true;
		}
		this.testFailure=status;

	}	
	
	
}
