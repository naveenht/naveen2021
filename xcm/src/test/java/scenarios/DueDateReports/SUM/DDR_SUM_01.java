package scenarios.DueDateReports.SUM;

import baseClass.BaseClass;
import iSAFE.ApplicationKeywords;
import pages.Login_Logout;
import pages.ReportPage;

public class DDR_SUM_01 extends ApplicationKeywords {

	BaseClass obj;
	ReportPage reportPage;
	private Boolean status = false;
	Login_Logout loginLogout;

	public DDR_SUM_01(BaseClass obj) {
		super(obj);
		this.obj = obj;
	}

	public void dDR_SUM_01() {

		reportPage = new ReportPage(obj);

		String reportLink=retrieve("Report Link");
		String buttonName=retrieve("Run Report Button");
		String reportPageTitle = retrieve("Report Page Title");
		
		reportPage.clickReportTab(true);
		reportPage.clickReportLink(reportLink);
		reportPage.verifyButton(buttonName, true);
		obj.transferControlToWindow(2);
		obj.validateReportPageTitle(reportPageTitle);
		obj.transferControlToWindow(1);

		if (reportPage.testFailure || reportPage.testFailure || obj.testFailure) {
			status = true;
		}
		this.testFailure = status;

	}
}
