package scenarios.SummaryReports.TTT;

import baseClass.BaseClass;
import iSAFE.ApplicationKeywords;
import pages.ReportPage;

public class SR_TTT_05 extends ApplicationKeywords{

	BaseClass obj;
	private Boolean status = false;
	ReportPage reportPage;
	
	public SR_TTT_05(BaseClass obj) {
		super(obj);
		this.obj = obj;
	}
	
	
	public void sR_TTT_05() {
		

		String reportLink=retrieve("Report Link");
		String originatingLocationLabel=retrieve("Originating Location Label");
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
		String fiscalYearLabel=retrieve("Fiscal Year Label");
		String fiscalYearValue=retrieve("Fiscal Year Value");
		
		reportPage = new ReportPage(obj);
		
		
		reportPage.clickReportTab(true);
		reportPage.clickReportLink(reportLink);
		reportPage.selectRoleNameDropDownValue(originatingLocationLabel);
		reportPage.selectDropDownValue(fiscalYearLabel, fiscalYearValue);
		reportPage.clickRadioButton(radioButtonLabel,radioButtonValue);
		reportPage.verifyButton(saveReportButton, true);
		String reportTitle=reportPage.enterTextInSaveCustomReportPopup(reportTitleLabel, reportTitleValue);
		reportPage.enterTextInSaveCustomReportPopup(reportDescriptionLabel, reportDescriptionValue);
		reportPage.verifySaveCustomReportPopupButtons(customReportSaveButton);
		int colposition=reportPage.getSystemWideCustomReportsHeaderPosition(tableName,tableColumnHeader);
		reportPage.getRowPositionValue(tableName,colposition, reportTitle);
		
		
		if (obj.testFailure || reportPage.testFailure) {
			status = true;
		}
		this.testFailure = status;
	}
	



}
