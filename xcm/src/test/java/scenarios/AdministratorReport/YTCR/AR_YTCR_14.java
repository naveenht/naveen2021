package scenarios.AdministratorReport.YTCR;

import baseClass.BaseClass;
import iSAFE.ApplicationKeywords;
import pages.ReportPage;

public class AR_YTCR_14 extends ApplicationKeywords {

	BaseClass obj;
	private Boolean status = false;
	ReportPage reportpage;

	public AR_YTCR_14(BaseClass obj) {
		super(obj);
		this.obj = obj;
	}

	public void aR_YTCR_14() {

		String reportLink = retrieve("Report Link");
		String runReportButton = retrieve("Run Report Button");
		String reportPageTitle = retrieve("Report Page Title");
		String fromDateLabel = retrieve("From Date Label");
		String fromDateValue = retrieve("From Date Value");

		String toDateLabel = retrieve("To Date Label");
		String toDateValue = retrieve("To Date Value");

		reportpage = new ReportPage(obj);
		
		reportpage.clickReportTab(true);
		reportpage.clickReportLink(reportLink);
		
		reportpage.selectCalenderPopup(fromDateLabel);
		reportpage.selectDate(fromDateValue);
		reportpage.selectCalenderPopup(toDateLabel);
		reportpage.selectDate(toDateValue);
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
