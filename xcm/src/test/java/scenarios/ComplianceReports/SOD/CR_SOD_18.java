package scenarios.ComplianceReports.SOD;

import baseClass.BaseClass;
import iSAFE.ApplicationKeywords;
import pages.ReportPage;

public class CR_SOD_18 extends ApplicationKeywords
{
	BaseClass obj;
	private Boolean status = false;
	ReportPage reportPage;
    

	public CR_SOD_18(BaseClass obj){
		super(obj);
		this.obj=obj;
	}

	public void cR_SOD_18() {

		
		String linklabel=retrieve("Report Link");
		String buttonName=retrieve("Run Report Button");
		String expectedTitle=retrieve("Report Page Title");
		
		reportPage = new ReportPage(obj);
				
		reportPage.clickReportTab(true);
		reportPage.clickReportLink(linklabel);
		reportPage.clickRadioButton("Select Data In","Archive");// to run archive
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





