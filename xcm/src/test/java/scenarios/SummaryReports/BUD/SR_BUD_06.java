package scenarios.SummaryReports.BUD;

import baseClass.BaseClass;
import iSAFE.ApplicationKeywords;
import pages.ReportPage;

public class SR_BUD_06 extends ApplicationKeywords {

	BaseClass obj;
	private Boolean status = false;
	ReportPage reportPage;

	public SR_BUD_06(BaseClass obj) {
		super(obj);
		this.obj = obj;
	}

	public void sR_BUD_06() {

		String reportLink = retrieve("Report Link");
		String reportPageTitle = retrieve("Report Page Title");
		String systemWideTableName = retrieve("System Wide Table Name");
		String myReportsTableName = retrieve("My Reports Table Name");
		String systemWideColumnValue = retrieve("System Wide Column Value");
		String myReportsColumnValue = retrieve("My Reports Column Value");
		String tableColumnLink = retrieve("Table Column Link");

		String radioButtonLabel = retrieve("Radio Button Label");
		String radioButtonValue = retrieve("Radio Button Value");
		String radioButtonValue1 = retrieve("Radio Button Value1");
		String saveReportButton = retrieve("Save Reoprt Button");
		String reportTitleLabel = retrieve("Report Title Label");
		String reportDescriptionLabel = retrieve("Report Description Label");
		String reportDescriptionValue = retrieve("Report Description Value");
		String customReportSaveButton = retrieve("Custom Report Save Button");
		String resetReportButton = retrieve("Reset Reoprt Button");
		
		int rowsCount = 0;

		reportPage = new ReportPage(obj);

		reportPage.clickReportTab(true);
		reportPage.clickReportLink(reportLink);

		// System Wide Reports
		boolean systemWideTablePresent = reportPage.verifyTableData(systemWideTableName);
		if (!systemWideTablePresent) {
			reportPage.clickRadioButton(radioButtonLabel, radioButtonValue);
			reportPage.verifyButton(saveReportButton, true);
			reportPage.enterTextInSaveCustomReportPopup(reportTitleLabel, systemWideColumnValue);
			reportPage.enterTextInSaveCustomReportPopup(reportDescriptionLabel, reportDescriptionValue);
			reportPage.verifySaveCustomReportPopupButtons(customReportSaveButton);
		}
		int columnPosition2 = reportPage.getSystemWideCustomReportsHeaderPosition(systemWideTableName, tableColumnLink);
		rowsCount = reportPage.getTabelRowsCount(systemWideTableName);
		if (rowsCount > 1) {
			for (int row = 0; row < rowsCount -1 ; row++) {
				reportPage.clickExistingFirstLink(systemWideTableName, columnPosition2, row + 2);
				obj.transferControlToWindow(2);
				obj.validateReportPageTitle(reportPageTitle);
				obj.transferControlToWindow(1);
			}
		}
		

		// My Reports
		boolean myReportTablePresent = reportPage.verifyTableData(myReportsTableName);
		if (!myReportTablePresent) {
			reportPage.verifyButton(resetReportButton, true);
			reportPage.clickRadioButton(radioButtonLabel, radioButtonValue1);
			reportPage.verifyButton(saveReportButton, true);
			reportPage.enterTextInSaveCustomReportPopup(reportTitleLabel, myReportsColumnValue);
			reportPage.enterTextInSaveCustomReportPopup(reportDescriptionLabel, reportDescriptionValue);
			reportPage.verifySaveCustomReportPopupButtons(customReportSaveButton);
		}
		int columnPosition3 = reportPage.getSystemWideCustomReportsHeaderPosition(myReportsTableName, tableColumnLink);
		rowsCount = reportPage.getTabelRowsCount(myReportsTableName);
		if (rowsCount > 1) {
			for (int row = 0; row < rowsCount-1; row++) {
				reportPage.clickExistingFirstLink(myReportsTableName, columnPosition3, row + 2);
				obj.transferControlToWindow(2);
				obj.validateReportPageTitle(reportPageTitle);
				obj.transferControlToWindow(1);
			}
		}

		if (obj.testFailure || reportPage.testFailure) {
			status = true;
		}
		this.testFailure = status;
	}

}
