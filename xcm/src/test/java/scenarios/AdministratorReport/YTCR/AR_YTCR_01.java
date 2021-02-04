
package scenarios.AdministratorReport.YTCR;

import baseClass.BaseClass;
import iSAFE.ApplicationKeywords;
import pages.ReportPage;

public class AR_YTCR_01 extends ApplicationKeywords {

	BaseClass obj;
	ReportPage reportPage;
	public boolean status = false;

	public AR_YTCR_01(BaseClass obj) {
		super(obj);
		this.obj = obj;

	}

	public void aR_YTCR_01() {

		String reportLink = retrieve("Report Link");
		String runReportButton = retrieve("Run Report Button");
		String reportPageTitle = retrieve("Report Page Title");
		String fromDateLabel = retrieve("From Date Label");
		String fromDateValue = retrieve("From Date Value");
		String toDateLabel = retrieve("To Date Label");
		String toDateValue = retrieve("To Date Value");

		reportPage = new ReportPage(obj);

		reportPage.clickReportTab(true);
		reportPage.clickReportLink(reportLink);
		
		reportPage.selectCalenderPopup(fromDateLabel);
		reportPage.selectDate(fromDateValue);
		
		reportPage.selectCalenderPopup(toDateLabel);
		reportPage.selectDate(toDateValue);
		reportPage.verifyButton(runReportButton, true);
		obj.transferControlToWindow(2);
		obj.validateReportPageTitle(reportPageTitle);
		obj.transferControlToWindow(1);
		
		if (reportPage.testFailure || obj.testFailure) {
			status = true;
		}
		this.testFailure = status;
	}

}
