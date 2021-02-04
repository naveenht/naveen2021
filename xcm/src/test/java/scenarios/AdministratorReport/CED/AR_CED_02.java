package scenarios.AdministratorReport.CED;

import baseClass.BaseClass;
import iSAFE.ApplicationKeywords;

import pages.ReportPage;

public class AR_CED_02 extends ApplicationKeywords {

	BaseClass obj;
	private Boolean status = false;

	ReportPage reportPage;

	public AR_CED_02(BaseClass obj) {
		super(obj);
		this.obj = obj;
	}

	public void aR_CED_02() {
		
			
		String reportLink=retrieve("Report Link");
		String runReportButton=retrieve("Run Report Button");
		String reportPageTitle=retrieve("Report Page Title");
		
		String typeOfTaskLabel=retrieve("Type Of Task Label");
		String typeOfTaskValue=retrieve("Type Of Task Value");
		
		reportPage = new ReportPage(obj);
		
		reportPage.clickReportTab(true);
		reportPage.clickReportLink(reportLink);
		
		reportPage.selectDropDownValue(typeOfTaskLabel, typeOfTaskValue);
		reportPage.verifyButton(runReportButton, true);
		obj.transferControlToWindow(2);
	//	driver.manage().timeouts().implicitlyWait(6, TimeUnit.MINUTES);
		
		obj.validateReportPageTitle(reportPageTitle);
		obj.transferControlToWindow(1);

			if (obj.testFailure || reportPage.testFailure) {
				status = true;
			}
			this.testFailure = status;

	

}
}
