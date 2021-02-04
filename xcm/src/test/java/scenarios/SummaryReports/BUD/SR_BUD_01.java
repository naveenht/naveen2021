package scenarios.SummaryReports.BUD;

import baseClass.BaseClass;
import iSAFE.ApplicationKeywords;
import pages.ReportPage;

public class SR_BUD_01 extends ApplicationKeywords {
	
	BaseClass obj;
	ReportPage reportPage;
	private Boolean status = false;
	
	public SR_BUD_01(BaseClass obj) {
		super(obj);
		this.obj = obj;
		
	}
	
	public void sR_BUD_01() {
		
		String reportLink=retrieve("Report Link");
		String runReportButton=retrieve("Run Report Button");
		String reportPageTitle=retrieve("Report Page Title");
		
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
