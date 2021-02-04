package scenarios.TaskDetailReports.SBS;

import baseClass.BaseClass;
import iSAFE.ApplicationKeywords;
import pages.ReportPage;

public class TDR_SBS_009 extends ApplicationKeywords {
	

	BaseClass obj;
	private Boolean status = false;
	ReportPage reportPage;
	
	public TDR_SBS_009(BaseClass obj) {
		super(obj);
		this.obj = obj;
	}
	
	
	public void tDR_SBS_009() {
	String reportLink=retrieve("Report Link");
	String systemWideTableName=retrieve("System Wide Table Name");
	String systemWideColumnValue=retrieve("System Wide Column Value");
	String myReportsColumnValue=retrieve("My Reports Column Value");
	String myReportsTableName=retrieve("My Reports Table Name");
	String radioButtonLabel=retrieve("Radio Button Label");
	String systemWideradioButtonValue=retrieve("System Wide Radio Button Value");
	String myReportsradioButtonValue=retrieve("My Reports Radio Button Value");
	String saveReportButton=retrieve("Save Reoprt Button");
	String reportDescriptionLabel=retrieve("Report Description Label");
	String customReportSaveButton=retrieve("Custom Report Save Button");
	String tableColumnDeleteLink=retrieve("Table Column Delete Link");
	String reportDescriptionValue=retrieve("Report Description Value");
	String reportTitlenew=retrieve("ReportTitlenew");
	String resetReportButton = retrieve("Reset Reoprt Button");
	
	reportPage = new ReportPage(obj);
	
	reportPage.clickReportTab(true);
	reportPage.clickReportLink(reportLink);
	
	//System Wide Reports
	
	boolean systemWideTablePresent=reportPage.verifyTableData(systemWideTableName);
	if(!systemWideTablePresent){
		reportPage.clickRadioButton(radioButtonLabel,systemWideradioButtonValue);
		reportPage.verifyButton(saveReportButton, true);
		reportPage.enterTextInSaveCustomReportPopup(reportTitlenew, systemWideColumnValue);
		reportPage.enterTextInSaveCustomReportPopup(reportDescriptionLabel, reportDescriptionValue);
		reportPage.verifySaveCustomReportPopupButtons(customReportSaveButton);
	}
	int columnPosition2=reportPage.getSystemWideCustomReportsHeaderPosition(systemWideTableName,tableColumnDeleteLink);
	reportPage.clickExistingRecordLink(systemWideTableName, columnPosition2);

	//My Reports
	boolean myReportTablePresent=reportPage.verifyTableData(myReportsTableName);
	if(!myReportTablePresent){
		reportPage.verifyButton(resetReportButton, true);
		reportPage.clickRadioButton(radioButtonLabel,myReportsradioButtonValue);
		reportPage.verifyButton(saveReportButton, true);
		reportPage.enterTextInSaveCustomReportPopup(reportTitlenew, myReportsColumnValue);
		reportPage.enterTextInSaveCustomReportPopup(reportDescriptionLabel, reportDescriptionValue);
		reportPage.verifySaveCustomReportPopupButtons(customReportSaveButton);
	}
	int columnPosition3=reportPage.getSystemWideCustomReportsHeaderPosition(myReportsTableName,tableColumnDeleteLink);
	reportPage.clickExistingRecordLink(myReportsTableName, columnPosition3);
	
	
	
	if (obj.testFailure || reportPage.testFailure ) {
		status = true;
	}
	this.testFailure = status;
}
}
