package scenarios.TaskDetailReports.CAS;

import baseClass.BaseClass;
import iSAFE.ApplicationKeywords;
import pages.ReportPage;

public class TDR_CAS_12 extends ApplicationKeywords {
	

	BaseClass obj;
	private Boolean status = false;
	ReportPage reportpage;
	
	public TDR_CAS_12(BaseClass obj) {
		super(obj);
		this.obj = obj;
	}
	
	
	public void tDR_CAS_12() {
		
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
		reportpage = new ReportPage(obj);
		reportpage.clickReportTab(true);
		reportpage.clickReportLink(reportLink);
		
		// System Wide Reports
		
		boolean systemWideTablePresent=reportpage.verifyTableData(systemWideTableName);
		if(!systemWideTablePresent){
			reportpage.clickRadioButton(radioButtonLabel,radioButtonValue);
			reportpage.verifyButton(saveReportButton, true);
			reportpage.enterTextInSaveCustomReportPopup(reportTitleLabel, reportTitleValue);
			reportpage.enterTextInSaveCustomReportPopup(reportDescriptionLabel, reportDescriptionValue);
			reportpage.verifySaveCustomReportPopupButtons(customReportSaveButton);
		}
		int columnPosition2=reportpage.getSystemWideCustomReportsHeaderPosition(systemWideTableName,tableColumnSortLink);
		reportpage.clickExistingRecordLink(systemWideTableName, columnPosition2);
		obj.transferControlToWindow(2);
		reportpage.verifyChooseButtons(chooseReportSelectAllButton, true);
		reportpage.verifyChooseButtons(chooseReportSaveNextButton, true);
		reportpage.verifyChooseButtons(chooseReportSaveCloseButton, true);
		obj.transferControlToWindow(1);
		int columnPosition7=reportpage.getSystemWideCustomReportsHeaderPosition(systemWideTableName,tableColumnRunLink);
		reportpage.clickExistingFirstLink(systemWideTableName, columnPosition7);
		obj.transferControlToWindow(2);
		obj.validateReportPageTitle(reportPageTitle);
		obj.transferControlToWindow(1);

		// My Reports
		
		boolean myReportsTablePresent=reportpage.verifyTableData(myReportsTableName);
		if(!myReportsTablePresent){
			reportpage.verifyButton(resetButtonLabel, true);
			reportpage.clickRadioButton(radioButtonLabel,radioButtonValue1);
			reportpage.verifyButton(saveReportButton, true);
			reportpage.enterTextInSaveCustomReportPopup(reportTitleLabel, reportTitleValue1);
			reportpage.enterTextInSaveCustomReportPopup(reportDescriptionLabel, reportDescriptionValue);
			reportpage.verifySaveCustomReportPopupButtons(customReportSaveButton);
		}
		int columnPosition6=reportpage.getSystemWideCustomReportsHeaderPosition(myReportsTableName,tableColumnSortLink);
		reportpage.clickExistingRecordLink(myReportsTableName, columnPosition6);
		obj.transferControlToWindow(2);
		reportpage.verifyChooseButtons(chooseReportSelectAllButton, true);
		reportpage.verifyChooseButtons(chooseReportSaveNextButton, true);
		reportpage.verifyChooseButtons(chooseReportSaveCloseButton, true);
		obj.transferControlToWindow(1);
		int columnPosition5=reportpage.getSystemWideCustomReportsHeaderPosition(myReportsTableName,tableColumnRunLink);
		reportpage.clickExistingFirstLink(myReportsTableName, columnPosition5);
		obj.transferControlToWindow(2);
		obj.validateReportPageTitle(reportPageTitle);
		obj.transferControlToWindow(1);
		
		
		if (obj.testFailure || reportpage.testFailure ) {
			status = true;
		}
		this.testFailure = status;
	}
	

}
