package scenarios.UserReports.CLS;

import baseClass.BaseClass;
import iSAFE.ApplicationKeywords;

import pages.ReportPage;

public class UR_CLS_01 extends ApplicationKeywords {

	BaseClass obj;
	private Boolean status = false;

	ReportPage reportPage;

	public UR_CLS_01(BaseClass obj) {
		super(obj);
		this.obj = obj;
	}

	public void uR_CLS_01() {

		String reportName = retrieve("Report Link");
		String reportTitle = retrieve("Report Page Title");
		String runReportButton = retrieve("Run Report Button");

		reportPage = new ReportPage(obj);

		reportPage.clickReportTab(true);
		reportPage.clickReportLink(reportName);
		reportPage.verifyButton(runReportButton, true);
		obj.transferControlToWindow(2);
		obj.validateReportPageTitle(reportTitle);
		obj.transferControlToWindow(1);

		if (obj.testFailure || reportPage.testFailure) {
			status = true;
		}
		this.testFailure = status;
	}

}
