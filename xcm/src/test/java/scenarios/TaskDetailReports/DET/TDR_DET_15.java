package scenarios.TaskDetailReports.DET;

import baseClass.BaseClass;
import iSAFE.ApplicationKeywords;
import pages.ReportPage;

public class TDR_DET_15 extends ApplicationKeywords {

	BaseClass obj;
	private Boolean status = false;
	ReportPage reportPage;
	
	public TDR_DET_15(BaseClass obj) {
		super(obj);
		this.obj = obj;
	}
	
	public void tDR_DET_15() {

		String reportLink = retrieve("Report Link");
		String runReportButton = retrieve("Run Report Button");
		String reportPageTitle = retrieve("Report Page Title");
		String fileTypeLabel = retrieve("File Type Label");
		String exportLink = retrieve("Export Link");

		reportPage = new ReportPage(obj);
		reportPage.clickReportTab(true);
		reportPage.clickReportLink(reportLink);
		reportPage.verifyButton(runReportButton, true);
		obj.transferControlToWindow(2);
		obj.validateReportPageTitle(reportPageTitle);
		reportPage.clickOnExcelCSVReports(exportLink);
		long startTime=reportPage.clickOnExcelCSVReports(fileTypeLabel);
		long endTime=obj.validateFileExists(fileTypeLabel);
		reportPage.calcualtedReportOpenedTime(startTime, endTime);
		obj.transferControlToWindow(1);

		if (obj.testFailure || reportPage.testFailure) {
			status = true;
		}
		this.testFailure = status;
	}
	

}
