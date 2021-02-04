package scenarios.DueDateReports.BDDF;
import baseClass.BaseClass;
import iSAFE.ApplicationKeywords;
import pages.ReportPage;

public class DDR_BDDF_12 extends ApplicationKeywords {

	BaseClass obj;
	private Boolean status = false;
	ReportPage reportPage;

	public DDR_BDDF_12(BaseClass obj) {
		super(obj);
		this.obj = obj;
	}

	public void dDR_BDDF_12() {
		
		String reportLink=retrieve("Report Link");
		String systemWideTableName=retrieve("System Wide Table Name");
		String myReportsTableName=retrieve("My Reports Table Name");
		String chooseReportSelectAllButton=retrieve("Choose Report Select All Button");
		String chooseReportSaveNextButton=retrieve("Choose Report Save&Next Button");
		String chooseReportSaveCloseButton=retrieve("Choose Report Save&Close Button");
		String reportPageTitle=retrieve("Report Page Title");
		String tableColumnSortLink=retrieve("Table Column Sort Link");
		String tableColumnRunLink=retrieve("Table Column Run Link");
		
		
		String radioButtonLabel=retrieve("Radio Button Label");
		String radioButtonValue=retrieve("Radio Button Value");
		String radioButtonValue1=retrieve("Radio Button Value1");
		String saveReportButton=retrieve("Save Reoprt Button");
		String reportTitleLabel=retrieve("Report Title Label");
		String reportDescriptionLabel=retrieve("Report Description Label");
		String reportDescriptionValue=retrieve("Report Description Value");
		String customReportSaveButton=retrieve("Custom Report Save Button");
		String reportTitleValue=retrieve("Report Title Value");
		String reportTitleValue1=retrieve("Report Title Value1");
		String resetButtonLabel=retrieve("Reset Button Label");
		reportPage = new ReportPage(obj);
		reportPage.clickReportTab(true);
		reportPage.clickReportLink(reportLink);
		
		// System Wide Reports
		
		boolean systemWideTablePresent=reportPage.verifyTableData(systemWideTableName);
		if(!systemWideTablePresent){
			reportPage.clickRadioButton(radioButtonLabel,radioButtonValue);
			reportPage.verifyButton(saveReportButton, true);
			reportPage.enterTextInSaveCustomReportPopup(reportTitleLabel, reportTitleValue);
			reportPage.enterTextInSaveCustomReportPopup(reportDescriptionLabel, reportDescriptionValue);
			reportPage.verifySaveCustomReportPopupButtons(customReportSaveButton);
		}
		int columnPosition2=reportPage.getSystemWideCustomReportsHeaderPosition(systemWideTableName,tableColumnSortLink);
		reportPage.clickExistingRecordLink(systemWideTableName, columnPosition2);
		obj.transferControlToWindow(2);
		reportPage.verifyChooseButtons(chooseReportSelectAllButton, true);
		reportPage.verifyChooseButtons(chooseReportSaveNextButton, true);
		reportPage.verifyChooseButtons(chooseReportSaveCloseButton, true);
		obj.transferControlToWindow(1);
		int columnPosition7=reportPage.getSystemWideCustomReportsHeaderPosition(systemWideTableName,tableColumnRunLink);
		reportPage.clickExistingFirstLink(systemWideTableName, columnPosition7);
		obj.transferControlToWindow(2);
		obj.validateReportPageTitle(reportPageTitle);
		obj.transferControlToWindow(1);

		// My Reports
		
		boolean myReportsTablePresent=reportPage.verifyTableData(myReportsTableName);
		if(!myReportsTablePresent){
			reportPage.verifyButton(resetButtonLabel, true);
			reportPage.clickRadioButton(radioButtonLabel,radioButtonValue1);
			reportPage.verifyButton(saveReportButton, true);
			reportPage.enterTextInSaveCustomReportPopup(reportTitleLabel, reportTitleValue1);
			reportPage.enterTextInSaveCustomReportPopup(reportDescriptionLabel, reportDescriptionValue);
			reportPage.verifySaveCustomReportPopupButtons(customReportSaveButton);
		}
		int columnPosition6=reportPage.getSystemWideCustomReportsHeaderPosition(myReportsTableName,tableColumnSortLink);
		reportPage.clickExistingRecordLink(myReportsTableName, columnPosition6);
		obj.transferControlToWindow(2);
		reportPage.verifyChooseButtons(chooseReportSelectAllButton, true);
		reportPage.verifyChooseButtons(chooseReportSaveNextButton, true);
		reportPage.verifyChooseButtons(chooseReportSaveCloseButton, true);
		obj.transferControlToWindow(1);
		int columnPosition5=reportPage.getSystemWideCustomReportsHeaderPosition(myReportsTableName,tableColumnRunLink);
		reportPage.clickExistingFirstLink(myReportsTableName, columnPosition5);
		obj.transferControlToWindow(2);
		obj.validateReportPageTitle(reportPageTitle);
		obj.transferControlToWindow(1);
		
		
		if (obj.testFailure || reportPage.testFailure ) {
			status = true;
		}
		this.testFailure = status;
	}

}
