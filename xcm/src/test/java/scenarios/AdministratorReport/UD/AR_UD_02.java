package scenarios.AdministratorReport.UD;

import baseClass.BaseClass;
import iSAFE.ApplicationKeywords;

import pages.ReportPage;

public class AR_UD_02 extends ApplicationKeywords {

	BaseClass obj;
	private Boolean status = false;

	ReportPage reportPage;

	public AR_UD_02(BaseClass obj) {
		super(obj);
		this.obj = obj;
	}

	public void aR_UD_02() {
		
			
		String reportLink=retrieve("Report Link");
		String runReportButton=retrieve("Run Report Button");
		String reportPageTitle=retrieve("Report Page Title");
		
		String locationLabel=retrieve("Location Label");
		String locationValue=retrieve("Location Value");
		
		reportPage = new ReportPage(obj);
		
		reportPage.clickReportTab(true);
		reportPage.clickReportLink(reportLink);
		reportPage.selectDropDownValue(locationLabel, locationValue);
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
