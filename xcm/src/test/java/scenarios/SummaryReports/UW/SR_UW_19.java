package scenarios.SummaryReports.UW;

import java.util.concurrent.TimeUnit;

import baseClass.BaseClass;
import iSAFE.ApplicationKeywords;
import pages.ReportPage;

public class SR_UW_19 extends ApplicationKeywords
{
	BaseClass obj;
	private Boolean status = false;
	ReportPage reportPage;
    

	public SR_UW_19(BaseClass obj){
		super(obj);
		this.obj=obj;
	}

	public void sR_UW_19() {

		
		String linklabel=retrieve("Report Link");
		String buttonName=retrieve("Run Report Button");
		String expectedTitle=retrieve("Report Page Title");
		
		reportPage = new ReportPage(obj);
				
		reportPage.clickReportTab(true);
		reportPage.clickReportLink(linklabel);
		reportPage.clickRadioButton("Select Client/Entity","My Clients/Entities");
		reportPage.verifyButton(buttonName, true);
		obj.transferControlToWindow(2);
		obj.validateReportPageTitle(expectedTitle);
		obj.transferControlToWindow(1);
		
		
		if(reportPage.testFailure||obj.testFailure){
			status = true;
		}
		this.testFailure=status;
	}
}





