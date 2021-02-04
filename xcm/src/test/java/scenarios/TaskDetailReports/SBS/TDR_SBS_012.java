package scenarios.TaskDetailReports.SBS;

import baseClass.BaseClass;
import iSAFE.ApplicationKeywords;
import pages.ReportPage;

public class TDR_SBS_012 extends ApplicationKeywords {
	

	BaseClass obj;
	private Boolean status = false;
	ReportPage reportPage;
	
	public TDR_SBS_012(BaseClass obj) {
		super(obj);
		this.obj = obj;
	}
	
	
	public void tDR_SBS_012() {
		
		
		String reportLink=retrieve("Report Link");
		String systemWideTableName=retrieve("System Wide Table Name");
		String tableColumnHeader=retrieve("Table Column Header");
		String myReportsTableName=retrieve("My Reports Table Name");
		String chooseReportSelectAllButton=retrieve("Choose Report Select All Button");
		String chooseReportSaveCloseButton=retrieve("Choose Report Save&Close Button");
		String tableColumnLink=retrieve("Table Column Link");
		String reportPageTitle=retrieve("Report Page Title");
		
		
		String radioButtonLabel=retrieve("Radio Button Label");
		String radioButtonValue=retrieve("Radio Button Value");
		String radioButtonValue1=retrieve("Radio Button Value1");
		String saveReportButton=retrieve("Save Reoprt Button");
		String reportTitleLabel=retrieve("Report Title Label");
		String reportTitleValue=retrieve("Report Title Value");
		String reportDescriptionLabel=retrieve("Report Description Label");
		String reportDescriptionValue=retrieve("Report Description Value");
		String customReportSaveButton=retrieve("Custom Report Save Button");
		String chooseReportSaveNextButton = retrieve("Choose Report Save&Next Button");
		String resetReportButton=retrieve("Reset Reoprt Button");
		
	
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
		int columnPosition2 = reportPage.getSystemWideCustomReportsHeaderPosition(systemWideTableName,tableColumnHeader);
		reportPage.clickExistingRecordLink(systemWideTableName, columnPosition2);
		obj.transferControlToWindow(2);
		reportPage.verifyChooseButtons(chooseReportSelectAllButton, true);
		reportPage.verifyChooseButtons(chooseReportSaveNextButton, true);
		reportPage.verifyChooseButtons(chooseReportSaveCloseButton, true);
		obj.transferControlToWindow(1);
		int columnPosition8 = reportPage.getSystemWideCustomReportsHeaderPosition(systemWideTableName, tableColumnLink);
		reportPage.clickExistingFirstLink(systemWideTableName, columnPosition8);
		obj.transferControlToWindow(2);
		obj.validateReportPageTitle(reportPageTitle);
		obj.transferControlToWindow(1);

		// My Reports
		boolean myReportsTablePresent=reportPage.verifyTableData(myReportsTableName);
		if(!myReportsTablePresent){
			reportPage.verifyButton(resetReportButton, true);
			reportPage.clickRadioButton(radioButtonLabel,radioButtonValue1);
			reportPage.verifyButton(saveReportButton, true);
			reportPage.enterTextInSaveCustomReportPopup(reportTitleLabel, reportTitleValue);
			reportPage.enterTextInSaveCustomReportPopup(reportDescriptionLabel, reportDescriptionValue);
			reportPage.verifySaveCustomReportPopupButtons(customReportSaveButton);
		}
		int columnPosition3 = reportPage.getSystemWideCustomReportsHeaderPosition(myReportsTableName,tableColumnHeader);
		reportPage.clickExistingRecordLink(myReportsTableName, columnPosition3);
		obj.transferControlToWindow(2);
		reportPage.verifyChooseButtons(chooseReportSelectAllButton, true);
		reportPage.verifyChooseButtons(chooseReportSaveNextButton, true);
		reportPage.verifyChooseButtons(chooseReportSaveCloseButton, true);
		obj.transferControlToWindow(1);
		int columnPosition4 = reportPage.getSystemWideCustomReportsHeaderPosition(myReportsTableName, tableColumnLink);
		reportPage.clickExistingFirstLink(myReportsTableName, columnPosition4);
		obj.transferControlToWindow(2);
		obj.validateReportPageTitle(reportPageTitle);
		obj.transferControlToWindow(1);
		
		
		if (obj.testFailure || reportPage.testFailure ) {
			status = true;
		}
		this.testFailure = status;
	}}


