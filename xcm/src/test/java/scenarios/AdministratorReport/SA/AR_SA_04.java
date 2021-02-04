package scenarios.AdministratorReport.SA;

import baseClass.BaseClass;
import iSAFE.ApplicationKeywords;
import pages.ReportPage;

public class AR_SA_04 extends ApplicationKeywords{
	
	BaseClass obj;
	private Boolean status = false;
	ReportPage reportpage;
	
	public AR_SA_04(BaseClass obj) {
		super(obj);
		this.obj = obj;
	}
	
	
	public void aR_SA_04() {

		String reportLink=retrieve("Report Link");
		String primaryTaskTypeLabel=retrieve("Primary Task Type Label");
		String primaryTaskTypeValue=retrieve("Primary Task Type Value");
		String responsibilityLabel=retrieve("Responsibility Label");
		String responsibilityLabelValue=retrieve("Responsibility Label Value");
		
		String radioButtonLabel=retrieve("Radio Button Label");
		String radioButtonValue=retrieve("Radio Button Value");
		String saveReportButton=retrieve("Save Reoprt Button");
		String reportTitleLabel=retrieve("Report Title Label");
		String reportTitleValue=retrieve("Report Title Value");
		String reportDescriptionLabel=retrieve("Report Description Label");
		String reportDescriptionValue=retrieve("Report Description Value");
		String customReportSaveButton=retrieve("Custom Report Save Button");
		String tableName=retrieve("Table Name");
		String tableColumnHeader=retrieve("Table Column Header");
		
		reportpage = new ReportPage(obj);
		
		reportpage.clickReportTab(true);
		reportpage.clickReportLink(reportLink);
		reportpage.selectDropDownValue(primaryTaskTypeLabel, primaryTaskTypeValue);
		reportpage.selectDropDownValue(responsibilityLabel, responsibilityLabelValue);
		
		reportpage.clickRadioButton(radioButtonLabel,radioButtonValue);
		reportpage.verifyButton(saveReportButton, true);
		String reportTitle=reportpage.enterTextInSaveCustomReportPopup(reportTitleLabel, reportTitleValue);
		reportpage.enterTextInSaveCustomReportPopup(reportDescriptionLabel, reportDescriptionValue);
		reportpage.verifySaveCustomReportPopupButtons(customReportSaveButton);
		int colposition=reportpage.getSystemWideCustomReportsHeaderPosition(tableName,tableColumnHeader);
		reportpage.getRowPositionValue(tableName,colposition, reportTitle);
		
		
		if (obj.testFailure || reportpage.testFailure) {
			status = true;
		}
		this.testFailure = status;
	}
	



}