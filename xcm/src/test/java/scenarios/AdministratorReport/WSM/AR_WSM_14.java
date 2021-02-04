package scenarios.AdministratorReport.WSM;

import baseClass.BaseClass;
import iSAFE.ApplicationKeywords;
import pages.ReportPage;

public class AR_WSM_14 extends ApplicationKeywords {

	BaseClass obj;
	private Boolean status = false;
	ReportPage reportpage;

	public AR_WSM_14(BaseClass obj) {
		super(obj);
		this.obj = obj;
	}

	public void aR_WSM_14() {

		String reportLink = retrieve("Report Link");
		String runReportButton = retrieve("Run Report Button");
		String reportPageTitle = retrieve("Report Page Title");

		reportpage = new ReportPage(obj);

		reportpage.clickReportTab(true);
		reportpage.clickReportLink(reportLink);
		long startTime = reportpage.verifyButton(runReportButton, true);
		obj.transferControlToWindow(2);
		long endTime =obj.validateReportPageTitle(reportPageTitle);
		reportpage.calcualtedReportOpenedTime(startTime, endTime);
		obj.transferControlToWindow(1);

		if (obj.testFailure || reportpage.testFailure) {
			status = true;
		}
		this.testFailure = status;
	}

}
