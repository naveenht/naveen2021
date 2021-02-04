package scenarios.TaskDetailReports.OUT;

import baseClass.BaseClass;
import iSAFE.ApplicationKeywords;
import pages.ReportPage;

public class TDR_OUT_02 extends ApplicationKeywords {
	

	BaseClass obj;
	private Boolean status = false;
	ReportPage reportPage;
	
	public TDR_OUT_02(BaseClass obj) {
		super(obj);
		this.obj = obj;
	}
	
	
	public void tDR_OUT_02() {
		
		String reportLink=retrieve("Report Link");
		String runReportButton=retrieve("Run Report Button");
		String reportPageTitle=retrieve("Report Page Title");
		String fiscalYearLabel=retrieve("Fiscal Year Label");
		String fiscalYearValue=retrieve("Fiscal Year Value");
		
		
		reportPage = new ReportPage(obj);
		
		reportPage.clickReportTab(true);
		reportPage.clickReportLink(reportLink);
		reportPage.selectDropDownValue(fiscalYearLabel, fiscalYearValue);
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