package scenarios.ComplianceReports.ESR;

import baseClass.BaseClass;
import iSAFE.ApplicationKeywords;
import pages.ReportPage;

public class CR_ESR_10 extends ApplicationKeywords {
	
	BaseClass obj;
	private Boolean status = false;
	ReportPage reportPage;
	
	public CR_ESR_10(BaseClass obj) {
		super(obj);
		this.obj = obj;
	}
	
	
	public void cR_ESR_10() {
		
		
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
		

		reportPage = new ReportPage(obj);
		
		reportPage.clickReportTab(true);
		reportPage.clickReportLink(reportLink);
		
		//System Wide Reports
		
		boolean systemWideTablePresent=reportPage.verifyTableData(systemWideTableName);
		if(!systemWideTablePresent){
			reportPage.clickRadioButton(radioButtonLabel,radioButtonValue);
			reportPage.verifyButton(saveReportButton, true);
			reportPage.enterTextInSaveCustomReportPopup(reportTitleLabel, reportTitleValue);
			reportPage.enterTextInSaveCustomReportPopup(reportDescriptionLabel, reportDescriptionValue);
			reportPage.verifySaveCustomReportPopupButtons(customReportSaveButton);
		}
		int columnPosition2=reportPage.getSystemWideCustomReportsHeaderPosition(systemWideTableName,tableColumnDescriptionLink);
		reportPage.clickExistingRecordLink(systemWideTableName, columnPosition2);
		reportPage.enterTextInSaveCustomReportPopup(descriptionInSavePopupLabel, descriptionInSavePopupValue);
		reportPage.verifySaveCustomReportPopupButtons(customReportSaveButton);
		int colposition=reportPage.getSystemWideCustomReportsHeaderPosition(systemWideTableName,tableDescriptionColumnHeader);
		reportPage.getRowPositionValue(systemWideTableName,colposition, descriptionInSavePopupValue);
		
		
		//My Reports
		
		boolean myReportsTablePresent=reportPage.verifyTableData(myReportsTableName);
		if(!myReportsTablePresent){
			reportPage.verifyButton(resetReportButton, true);
			reportPage.clickRadioButton(radioButtonLabel,radioButtonValue1);
			reportPage.verifyButton(saveReportButton, true);
			reportPage.enterTextInSaveCustomReportPopup(reportTitleLabel, reportTitleValue);
			reportPage.enterTextInSaveCustomReportPopup(reportDescriptionLabel, reportDescriptionValue);
			reportPage.verifySaveCustomReportPopupButtons(customReportSaveButton);
		}
		int columnPosition3=reportPage.getSystemWideCustomReportsHeaderPosition(myReportsTableName,tableColumnDescriptionLink);
		reportPage.clickExistingRecordLink(myReportsTableName, columnPosition3);
		reportPage.enterTextInSaveCustomReportPopup(descriptionInSavePopupLabel, descriptionInSavePopupValue);
		reportPage.verifySaveCustomReportPopupButtons(customReportSaveButton);
		int colposition1=reportPage.getSystemWideCustomReportsHeaderPosition(myReportsTableName,tableDescriptionColumnHeader);
		reportPage.getRowPositionValue(myReportsTableName,colposition1, descriptionInSavePopupValue);
		
		
		if (obj.testFailure || reportPage.testFailure) {
			status = true;
		}
		this.testFailure = status;
	}
	

}
