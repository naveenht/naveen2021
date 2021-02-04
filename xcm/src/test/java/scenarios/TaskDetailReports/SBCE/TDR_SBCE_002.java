package scenarios.TaskDetailReports.SBCE;

import baseClass.BaseClass;
import iSAFE.ApplicationKeywords;
import pages.ReportPage;

public class TDR_SBCE_002 extends ApplicationKeywords {
	

	BaseClass obj;
	private Boolean status = false;
	ReportPage reportPage;
	
	public TDR_SBCE_002(BaseClass obj) {
		super(obj);
		this.obj = obj;
	}
	
	
	public void tDR_SBCE_002() {
        
		String reportLink=retrieve("Report Link");
		String reportPageTitle=retrieve("Report Page Title");
		String fisicalYearLabel=retrieve("Fiscal Year Label");
		String fisicalYearValue=retrieve("Fiscal Year Value");
		String runReportButton=retrieve("Run Report Button");
		reportPage = new ReportPage(obj);
		
		reportPage.clickReportTab(true);
		reportPage.clickReportLink(reportLink);
		reportPage.selectDropDownValue(fisicalYearLabel,fisicalYearValue);
		reportPage.verifyButton(runReportButton, true);
		obj.transferControlToWindow(2);
		obj.validateReportPageTitle(reportPageTitle);
		obj.transferControlToWindow(1);
		
       
		if (obj.testFailure || reportPage.testFailure) {
			status = true;
		}
		this.testFailure = status;
	}}
	




