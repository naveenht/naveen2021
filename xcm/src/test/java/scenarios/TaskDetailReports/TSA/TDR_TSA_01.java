package scenarios.TaskDetailReports.TSA;

import baseClass.BaseClass;
import iSAFE.ApplicationKeywords;
import pages.ReportPage;

public class TDR_TSA_01 extends ApplicationKeywords
{
	BaseClass obj;
	private Boolean status = false;
	ReportPage reportPage;
    

	public TDR_TSA_01(BaseClass obj){
		super(obj);
		this.obj=obj;
	}

	public void tDR_TSA_01() {

		
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
		
		
		if(reportPage.testFailure||obj.testFailure){
			status = true;
		}
		this.testFailure=status;
	}






}
