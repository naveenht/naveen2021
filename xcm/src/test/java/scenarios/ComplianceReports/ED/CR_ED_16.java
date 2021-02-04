package scenarios.ComplianceReports.ED;

import baseClass.BaseClass;
import iSAFE.ApplicationKeywords;
import pages.ReportPage;

public class CR_ED_16 extends ApplicationKeywords {

	BaseClass obj;
	private Boolean status = false;
	ReportPage reportPage;
	
	public CR_ED_16(BaseClass obj) {
		super(obj);
		this.obj = obj;
	}
	
	public void cR_ED_16() {

		String reportLink = retrieve("Report Link");
		String runReportButton = retrieve("Run Report Button");
		String reportPageTitle = retrieve("Report Page Title");
		String fileTypeLabel = retrieve("File Type Label");
		String fileTypeLabel2 = retrieve("File Type Label2");
		String exportLink = retrieve("Export Link");

		reportPage = new ReportPage(obj);
		reportPage.clickReportTab(true);
		reportPage.clickReportLink(reportLink);
		reportPage.verifyButton(runReportButton, true);
		obj.transferControlToWindow(2);
		obj.validateReportPageTitle(reportPageTitle);
		reportPage.clickOnExcelCSVReports(exportLink);
	    reportPage.clickOnExcelCSVReports(fileTypeLabel);
		obj.validateFileExists(fileTypeLabel);
		reportPage.clickOnExcelCSVReports(exportLink);
		reportPage.clickOnExcelCSVReports(fileTypeLabel2);
		obj.validateFileExists(fileTypeLabel2);
		obj.transferControlToWindow(1);

		if (obj.testFailure || reportPage.testFailure) {
			status = true;
		}
		this.testFailure = status;
	}
	

}

