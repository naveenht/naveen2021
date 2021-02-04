package scenarios.DueDateReports.SDF;

import baseClass.BaseClass;
import iSAFE.ApplicationKeywords;

import pages.ReportPage;

public class DDR_SDF_01 extends ApplicationKeywords {

	BaseClass obj;
	private Boolean status = false;

	ReportPage reportPage;

	public DDR_SDF_01(BaseClass obj) {
		super(obj);
		this.obj = obj;
	}

	public void dDR_SDF_01() {

		String reportLink = retrieve("Report Link");
		String reportTitle = retrieve("ReportTitle");
		String runReportButton = retrieve("Run Report Button");

		reportPage = new ReportPage(obj);

		reportPage.clickReportTab(true);
		reportPage.clickReportLink(reportLink);
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
