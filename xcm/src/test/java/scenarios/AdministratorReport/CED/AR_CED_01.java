package scenarios.AdministratorReport.CED;

import baseClass.BaseClass;
import iSAFE.ApplicationKeywords;

import pages.ReportPage;

public class AR_CED_01 extends ApplicationKeywords {

	BaseClass obj;
	private Boolean status = false;
	
	ReportPage reportPage;

	public AR_CED_01(BaseClass obj) {
		super(obj);
		this.obj = obj;
	}

	public void aR_CED_01() {

		String reportLink = retrieve("Report Link");
		String reportTitle = retrieve("Report Page Title");
		String runreport = retrieve("Run Report Button");

		reportPage = new ReportPage(obj);

		reportPage.clickReportTab(true);
		reportPage.clickReportLink(reportLink);
		reportPage.verifyButton(runreport, true);
		obj.transferControlToWindow(2);
		obj.validateReportPageTitle(reportTitle);
		obj.transferControlToWindow(1);

		if (obj.testFailure || reportPage.testFailure) {
			status = true;
		}
		this.testFailure = status;
	}

}
