package scenarios.TaskDetailReports.CAS;

import baseClass.BaseClass;
import iSAFE.ApplicationKeywords;
import pages.ReportPage;

public class TDR_CAS_10 extends ApplicationKeywords {
	

	BaseClass obj;
	private Boolean status = false;
	ReportPage reportpage;
	
	public TDR_CAS_10(BaseClass obj) {
		super(obj);
		this.obj = obj;
	}
	
	
	public void tDR_CAS_10() {
		
		
		String reportLink=retrieve("Report Link");
		String systemWideTableName=retrieve("System Wide Table Name");
		String tableDescriptionColumnHeader=retrieve("Table Description Column Header");
		String myReportsTableName=retrieve("My Reports Table Name");
		String descriptionInSavePopupLabel=retrieve("Description In Save Popup Label");
		String customReportSaveButton=retrieve("Custom Report Save Button");
		String descriptionInSavePopupValue=retrieve("Description In Save Popup Value");
		String tableColumnDescriptionLink=retrieve("Table Column Description Link");
		
		String radioButtonLabel=retrieve("Radio Button Label");
		String radioButtonValue=retrieve("Radio Button Value");
		String radioButtonValue1=retrieve("Radio Button Value1");
		String saveReportButton=retrieve("Save Reoprt Button");
		String reportTitleLabel=retrieve("Report Title Label");
		String reportTitleValue=retrieve("Report Title Value");
		String reportDescriptionLabel=retrieve("Report Description Label");
		String reportDescriptionValue=retrieve("Report Description Value");
		String resetReportButton = retrieve("Reset Reoprt Button");
		

		reportpage = new ReportPage(obj);
		
		reportpage.clickReportTab(true);
		reportpage.clickReportLink(reportLink);
		
		//System Wide Reports
		
		boolean systemWideTablePresent=reportpage.verifyTableData(systemWideTableName);
		if(!systemWideTablePresent){
			reportpage.clickRadioButton(radioButtonLabel,radioButtonValue);
			reportpage.verifyButton(saveReportButton, true);
			reportpage.enterTextInSaveCustomReportPopup(reportTitleLabel, reportTitleValue);
			reportpage.enterTextInSaveCustomReportPopup(reportDescriptionLabel, reportDescriptionValue);
			reportpage.verifySaveCustomReportPopupButtons(customReportSaveButton);
		}
		int columnPosition2=reportpage.getSystemWideCustomReportsHeaderPosition(systemWideTableName,tableColumnDescriptionLink);
		reportpage.clickExistingRecordLink(systemWideTableName, columnPosition2);
		reportpage.enterTextInSaveCustomReportPopup(descriptionInSavePopupLabel, descriptionInSavePopupValue);
		reportpage.verifySaveCustomReportPopupButtons(customReportSaveButton);
		int colposition=reportpage.getSystemWideCustomReportsHeaderPosition(systemWideTableName,tableDescriptionColumnHeader);
		reportpage.getRowPositionValue(systemWideTableName,colposition, descriptionInSavePopupValue);
		
		
		//My Reports
		
		boolean myReportsTablePresent=reportpage.verifyTableData(myReportsTableName);
		if(!myReportsTablePresent){
			reportpage.verifyButton(resetReportButton, true);
			reportpage.clickRadioButton(radioButtonLabel,radioButtonValue1);
			reportpage.verifyButton(saveReportButton, true);
			reportpage.enterTextInSaveCustomReportPopup(reportTitleLabel, reportTitleValue);
			reportpage.enterTextInSaveCustomReportPopup(reportDescriptionLabel, reportDescriptionValue);
			reportpage.verifySaveCustomReportPopupButtons(customReportSaveButton);
		}
		int columnPosition3=reportpage.getSystemWideCustomReportsHeaderPosition(myReportsTableName,tableColumnDescriptionLink);
		reportpage.clickExistingRecordLink(myReportsTableName, columnPosition3);
		reportpage.enterTextInSaveCustomReportPopup(descriptionInSavePopupLabel, descriptionInSavePopupValue);
		reportpage.verifySaveCustomReportPopupButtons(customReportSaveButton);
		int colposition1=reportpage.getSystemWideCustomReportsHeaderPosition(myReportsTableName,tableDescriptionColumnHeader);
		reportpage.getRowPositionValue(myReportsTableName,colposition1, descriptionInSavePopupValue);
		
		
		if (obj.testFailure || reportpage.testFailure) {
			status = true;
		}
		this.testFailure = status;
	}
	

}
