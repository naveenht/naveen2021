package scenarios.AdministratorReport.YTCR;

import baseClass.BaseClass;
import iSAFE.ApplicationKeywords;
import pages.ReportPage;

public class AR_YTCR_15 extends ApplicationKeywords {

	BaseClass obj;
	private Boolean status = false;
	ReportPage reportPage;

	public AR_YTCR_15(BaseClass obj) {
		super(obj);
		this.obj = obj;
	}

	public void aR_YTCR_15() {

		String reportLink = retrieve("Report Link");
		String runReportButton = retrieve("Run Report Button");
		String reportPageTitle = retrieve("Report Page Title");
		String fileTypeLabel = retrieve("File Type Label");
		String exportLink = retrieve("Export Link");
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
		reportPage.clickOnExcelCSVReports(exportLink);
		long startTime = reportPage.clickOnExcelCSVReports(fileTypeLabel);
		long endTime = obj.validateFileExists(fileTypeLabel);
		reportPage.calcualtedReportOpenedTime(startTime, endTime);
		obj.transferControlToWindow(1);

		if (obj.testFailure || reportPage.testFailure) {
			status = true;
		}
		this.testFailure = status;
	}

}
