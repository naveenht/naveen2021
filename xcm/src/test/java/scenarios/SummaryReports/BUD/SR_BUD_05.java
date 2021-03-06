package scenarios.SummaryReports.BUD;

import baseClass.BaseClass;
import iSAFE.ApplicationKeywords;
import pages.ReportPage;

public class SR_BUD_05 extends ApplicationKeywords {
	

	BaseClass obj;
	private Boolean status = false;
	ReportPage reportPage;
	
	public SR_BUD_05(BaseClass obj) {
		super(obj);
		this.obj = obj;
	}
	
	
	public void sR_BUD_05() {
		

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
		String typeOfTaskHeaderLabel=retrieve("type Of Task Header Label");
		String typeOfTaskLabel=retrieve("Type Of Task Label");
		String typeOfTaskValue=retrieve("Type Of Task Value");
		
		
		reportPage = new ReportPage(obj);
		
		
		reportPage.clickReportTab(true);
		reportPage.clickReportLink(reportLink);
		reportPage.selectRoleNameDropDownValue(originatingLocationLabel);
		reportPage.clickDropDown(typeOfTaskLabel);
		reportPage.selectDropDownPopupValue(typeOfTaskHeaderLabel, typeOfTaskValue);
		reportPage.clickDropDownClose();
		reportPage.verifySelectedDropDownValue(typeOfTaskValue);
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
