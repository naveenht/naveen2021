package scenarios.AdministratorReport.YTCR;

import baseClass.BaseClass;
import iSAFE.ApplicationKeywords;
import pages.ReportPage;

public class AR_YTCR_13 extends ApplicationKeywords {

	BaseClass obj;
	private Boolean status = false;
	ReportPage reportpage;

	public AR_YTCR_13(BaseClass obj) {
		super(obj);
		this.obj = obj;

	}

	public void aR_YTCR_13() {

		String reportLink = retrieve("Report Link");
		String runReportButton = retrieve("Run Report Button");
		String reportPageTitle = retrieve("Report Page Title");

		String originatingLocationLabel = retrieve("Originating Location Label");

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
		reportpage.selectRoleNameDropDownValue(originatingLocationLabel);
		reportpage.verifyButton(runReportButton, true);
		obj.transferControlToWindow(2);
		obj.validateReportPageTitle(reportPageTitle);
		obj.transferControlToWindow(1);

		reportpage.selectRoleNameDropDownValue(originatingLocationLabel);
		reportpage.selectCalenderPopup(fromDateLabel);
		reportpage.selectDate(fromDateValue);
		reportpage.selectCalenderPopup(toDateLabel);
		reportpage.selectDate(toDateValue);
		reportpage.verifyButton(runReportButton, true);
		obj.transferControlToWindow(2);
		obj.validateReportPageTitle(reportPageTitle);
		obj.transferControlToWindow(1);

		if (obj.testFailure || reportpage.testFailure) {
			status = true;
		}
		this.testFailure = status;
	}

}
