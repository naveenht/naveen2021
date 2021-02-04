package scenarios.DueDateReports.BD;

import baseClass.BaseClass;
import iSAFE.ApplicationKeywords;
import pages.ReportPage;

public class DDR_BD_14 extends ApplicationKeywords {
	

	BaseClass obj;
	private Boolean status = false;
	ReportPage reportPage;
	
	public DDR_BD_14(BaseClass obj) {
		super(obj);
		this.obj = obj;
	}
	
	
	public void dDR_BD_14() {
		
	
		String reportLink=retrieve("Report Link");
		String runReportButton=retrieve("Run Report Button");
		String reportPageTitle=retrieve("Report Page Title");
		
		reportPage = new ReportPage(obj);
		
		reportPage.clickReportTab(true);
		reportPage.clickReportLink(reportLink);
		long startTime=reportPage.verifyButton(runReportButton, true);
		obj.transferControlToWindow(2);
		long endTime=obj.validateReportPageTitle(reportPageTitle);
		obj.calcualtedReportOpenedTime(startTime, endTime);
		obj.transferControlToWindow(1);
		
		
		if (obj.testFailure || reportPage.testFailure ) {
			status = true;
		}
		this.testFailure = status;
	}
	

}
