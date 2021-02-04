package scenarios.ComplianceReports.ED;

import baseClass.BaseClass;
import iSAFE.ApplicationKeywords;
import pages.ReportPage;

public class CR_ED_01 extends ApplicationKeywords
{
	BaseClass obj;
	private Boolean status = false;
	ReportPage reportPage;
    

	public CR_ED_01(BaseClass obj){
		super(obj);
		this.obj=obj;
	}

	public void cR_ED_01() {

		
		String reportLink=retrieve("Report Link");
		String buttonName=retrieve("Run Report Button");
		String reportPageTitle = retrieve("Report Page Title");
		
		reportPage = new ReportPage(obj);
				
		reportPage.clickReportTab(true);
		reportPage.clickReportLink(reportLink);
		reportPage.verifyButton(buttonName, true);
		obj.transferControlToWindow(2);
		obj.validateReportPageTitle(reportPageTitle);
		obj.transferControlToWindow(1);
		
		
		if(reportPage.testFailure||obj.testFailure){
			status = true;
		}
		this.testFailure=status;
	}
}




