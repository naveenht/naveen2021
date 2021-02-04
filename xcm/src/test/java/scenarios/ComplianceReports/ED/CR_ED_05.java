package scenarios.ComplianceReports.ED;

import baseClass.BaseClass;
import iSAFE.ApplicationKeywords;
import pages.ReportPage;

public class CR_ED_05 extends ApplicationKeywords {

	BaseClass obj;
	private Boolean status = false;
	ReportPage reportPage;
	
	public CR_ED_05(BaseClass obj) {
		super(obj);
		this.obj = obj;
	}
	
	public void cR_ED_05() {
		
		String reportLink=retrieve("Report Link");
		String radioButtonLabel=retrieve("Radio Button Label");
		String radioButtonValue=retrieve("Radio Button Value");
		String saveReportButton=retrieve("Save Report Button");
		String reportTitleLabel=retrieve("Report Popup Title Label");
		String reportTitleValue=retrieve("Report Popup Title Value");
		String reportDescriptionLabel=retrieve("Report Description Label");
		String reportDescriptionValue=retrieve("Report Description Value");
		String customReportSaveButton=retrieve("Custom Report Save Button");
		String tableName=retrieve("Table Name");
		String tableColumnHeader=retrieve("Table Column Header");
		String fiscalYearLabel=retrieve("Fiscal Year Label");
		String fiscalYearValue=retrieve("Fiscal Year Value");
		String typeOfTaskLabel=retrieve("Type Of Task Label");
		String typeOfTaskValue=retrieve("Type Of Task Value");
		String HeaderTypeOfTask=retrieve("Header Type Of Task");
		
		
		
		reportPage = new ReportPage(obj);
		
		reportPage.clickReportTab(true);
		reportPage.clickReportLink(reportLink);
		reportPage.selectDropDownValue(fiscalYearLabel, fiscalYearValue);
		reportPage.clickDropDown(typeOfTaskLabel);
		reportPage.selectDropDownPopupValue(HeaderTypeOfTask, typeOfTaskValue);
		reportPage.clickDropDownClose();
		
		reportPage.clickRadioButton(radioButtonLabel,radioButtonValue);
		reportPage.verifyButton(saveReportButton, true);
		String reportTitle=reportPage.enterTextInSaveCustomReportPopup(reportTitleLabel, reportTitleValue);
		reportPage.enterTextInSaveCustomReportPopup(reportDescriptionLabel, reportDescriptionValue);
		reportPage.verifySaveCustomReportPopupButtons(customReportSaveButton);
		int colposition=reportPage.getSystemWideCustomReportsHeaderPosition(tableName,tableColumnHeader);
		reportPage.getRowPositionValue(tableName,colposition, reportTitle);
		
		
		
		if (obj.testFailure  || reportPage.testFailure) {
			status = true;
		}
		this.testFailure = status;
	}
	

}


