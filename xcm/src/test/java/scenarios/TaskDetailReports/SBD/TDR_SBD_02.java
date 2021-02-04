package scenarios.TaskDetailReports.SBD;

import baseClass.BaseClass;
import iSAFE.ApplicationKeywords;
import pages.Login_Logout;
import pages.ReportPage;

public class TDR_SBD_02 extends ApplicationKeywords {
	
	BaseClass obj;
	private Boolean status = false;
	Login_Logout loginLogout;
	ReportPage reportPage;

	public TDR_SBD_02(BaseClass obj){
		super(obj);
		this.obj=obj;
	}

	public void tDR_SBD_02(){

		reportPage=new ReportPage(obj);

		boolean click = true;
		String reportLink=retrieve("Report Link");
		String reportPageTitle=retrieve("Report Page Title");
		String runReportButton=retrieve("Run Report Button");	
		String fisicalYearLabel=retrieve("Fiscal Year Label");
		String fisicalYearValue=retrieve("Fiscal Year Value");
						
		reportPage.clickReportTab(true);
		reportPage.clickReportLink(reportLink);	
		
		
		reportPage.selectDropDownValue(fisicalYearLabel, fisicalYearValue);		
		reportPage.verifyButton(runReportButton, click);
		obj.transferControlToWindow(2);
		obj.validateReportPageTitle(reportPageTitle);
		obj.transferControlToWindow(1);

		if(reportPage.testFailure||obj.testFailure){
			status = true;
		}
		this.testFailure=status;

	}
	

}
