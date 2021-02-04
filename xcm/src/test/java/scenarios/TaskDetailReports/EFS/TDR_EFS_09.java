package scenarios.TaskDetailReports.EFS;

import baseClass.BaseClass;
import iSAFE.ApplicationKeywords;
import pages.ReportPage;

public class TDR_EFS_09 extends ApplicationKeywords {
	

	BaseClass obj;
	private Boolean status = false;
	ReportPage reportpage;
	
	public TDR_EFS_09(BaseClass obj) {
		super(obj);
		this.obj = obj;
	}
	
	
	public void tDR_EFS_09() {
		
	
		
		String reportLink=retrieve("Report Link");
		String systemWideTableName=retrieve("System Wide Table Name");
		String systemWideColumnValue=retrieve("System Wide Column Value");
		String myReportsColumnValue=retrieve("My Reports Column Value");
		String myReportsTableName=retrieve("My Reports Table Name");
		String radioButtonLabel=retrieve("Radio Button Label");
		String systemWideradioButtonValue=retrieve("System Wide Radio Button Value");
		String myReportsradioButtonValue=retrieve("My Reports Radio Button Value");
		String saveReportButton=retrieve("Save Reoprt Button");
		String reportTitleLabel=retrieve("Report Title Label");
		String reportDescriptionLabel=retrieve("Report Description Label");
		String customReportSaveButton=retrieve("Custom Report Save Button");
		String tableColumnDeleteLink=retrieve("Table Column Delete Link");
		String reportDescriptionValue=retrieve("Report Description Value");
		String resetReportButton = retrieve("Reset Reoprt Button");
		
		reportpage = new ReportPage(obj);
		
		reportpage.clickReportTab(true);
		reportpage.clickReportLink(reportLink);
		
		//System Wide Reports
		
		boolean systemWideTablePresent=reportpage.verifyTableData(systemWideTableName);
		if(!systemWideTablePresent){
			reportpage.clickRadioButton(radioButtonLabel,systemWideradioButtonValue);
			reportpage.verifyButton(saveReportButton, true);
			reportpage.enterTextInSaveCustomReportPopup(reportTitleLabel, systemWideColumnValue);
			reportpage.enterTextInSaveCustomReportPopup(reportDescriptionLabel, reportDescriptionValue);
			reportpage.verifySaveCustomReportPopupButtons(customReportSaveButton);
		}
		int columnPosition2=reportpage.getSystemWideCustomReportsHeaderPosition(systemWideTableName,tableColumnDeleteLink);
		reportpage.clickExistingRecordLink(systemWideTableName, columnPosition2);
	
		//My Reports
		boolean myReportTablePresent=reportpage.verifyTableData(myReportsTableName);
		if(!myReportTablePresent){
			reportpage.verifyButton(resetReportButton, true);
			reportpage.clickRadioButton(radioButtonLabel,myReportsradioButtonValue);
			reportpage.verifyButton(saveReportButton, true);
			reportpage.enterTextInSaveCustomReportPopup(reportTitleLabel, myReportsColumnValue);
			reportpage.enterTextInSaveCustomReportPopup(reportDescriptionLabel, reportDescriptionValue);
			reportpage.verifySaveCustomReportPopupButtons(customReportSaveButton);
		}
		int columnPosition3=reportpage.getSystemWideCustomReportsHeaderPosition(myReportsTableName,tableColumnDeleteLink);
		reportpage.clickExistingRecordLink(myReportsTableName, columnPosition3);
		
		
		
		if (obj.testFailure || reportpage.testFailure ) {
			status = true;
		}
		this.testFailure = status;
	}
	

}
