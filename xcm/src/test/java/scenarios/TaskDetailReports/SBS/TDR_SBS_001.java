package scenarios.TaskDetailReports.SBS;


import baseClass.BaseClass;
import iSAFE.ApplicationKeywords;
import pages.ReportPage;

public class TDR_SBS_001 extends ApplicationKeywords {
	

	BaseClass obj;
	private Boolean status = false;
	ReportPage reportPage;
	
	public TDR_SBS_001(BaseClass obj) {
		super(obj);
		this.obj = obj;
	}
	
	
	public void tDR_SBS_001() {
		
	String reportLink=retrieve("Report Link");
	String reportPageTitle=retrieve("Report Page Title");
	String runReportButton=retrieve("Run Report Button");
		reportPage = new ReportPage(obj);
		
		reportPage.clickReportTab(true);
		reportPage.clickReportLink(reportLink);
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
	