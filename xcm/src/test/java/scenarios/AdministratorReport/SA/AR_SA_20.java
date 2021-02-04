package scenarios.AdministratorReport.SA;

import baseClass.BaseClass;
import iSAFE.ApplicationKeywords;
import pages.ReportPage;

public class AR_SA_20 extends ApplicationKeywords {
	
	BaseClass obj;
	private Boolean status = false;
	ReportPage reportPage;
	
	public AR_SA_20(BaseClass obj) {
		super(obj);
		this.obj = obj;
		
	}
	
	public void aR_SA_20() {
		
		String reportLink=retrieve("Report Link");
		String runReportButton=retrieve("Run Report Button");
		String reportPageTitle=retrieve("Report Page Title");
		
        reportPage = new ReportPage(obj);
		
		reportPage.clickReportTab(true);
		reportPage.clickReportLink(reportLink);
		reportPage.clickRadioButton("Choose Custom Report","My Reports");// to run with default column options
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