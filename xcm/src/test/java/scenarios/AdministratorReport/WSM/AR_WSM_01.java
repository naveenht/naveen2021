package scenarios.AdministratorReport.WSM;

import baseClass.BaseClass;
import iSAFE.ApplicationKeywords;
import pages.ReportPage;

public class AR_WSM_01 extends ApplicationKeywords {

	BaseClass obj;
	ReportPage reportPage;
	private Boolean status = false;

	public AR_WSM_01(BaseClass obj) {
		super(obj);
		this.obj = obj;

	}

	public void aR_WSM_01() {

		String reportLink = retrieve("Report Link");
		String runReportButton = retrieve("Run Report Button");
		String reportPageTitle = retrieve("Report Page Title");

		reportPage = new ReportPage(obj);

		reportPage.clickReportTab(true);
		reportPage.clickReportLink(reportLink);
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
