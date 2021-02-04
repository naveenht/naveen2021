package scenarios.AdministratorReport.GD;

import baseClass.BaseClass;
import iSAFE.ApplicationKeywords;

import pages.ReportPage;

public class AR_GD_02 extends ApplicationKeywords {

	BaseClass obj;
	private Boolean status = false;

	ReportPage reportPage;

	public AR_GD_02(BaseClass obj) {
		super(obj);
		this.obj = obj;
	}

	public void aR_GD_02() {
		
			
		String reportLink=retrieve("Report Link");
		String runReportButton=retrieve("Run Report Button");
		String reportPageTitle=retrieve("Report Page Title");
		
		String locationLabel=retrieve("Location Label");
		
		
		reportPage = new ReportPage(obj);
		
		reportPage.clickReportTab(true);
		reportPage.clickReportLink(reportLink);
		reportPage.selectRoleNameDropDownValue(locationLabel);
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
