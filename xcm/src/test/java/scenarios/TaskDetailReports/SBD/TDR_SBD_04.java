package scenarios.TaskDetailReports.SBD;

import baseClass.BaseClass;
import iSAFE.ApplicationKeywords;
import pages.ReportPage;

public class TDR_SBD_04 extends ApplicationKeywords {
	

	BaseClass obj;
	private boolean status = false;
	ReportPage reportPage;
	
	public TDR_SBD_04(BaseClass obj) {
		super(obj);
		this.obj = obj;
	}
	
	
	public void tDR_SBD_04() {
		
		String reportLink=retrieve("Report Link");
		String fiscalYearLabel=retrieve("Fiscal Year Label");
		String fiscalYearValue=retrieve("Fiscal Year Value");
		String originatingLocLabel=retrieve("Originating Location Label");
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
		String fromDateLabel = retrieve("From Date Label");
		String fromDateValue = retrieve("From Date Value");	
		String toDateLabel = retrieve("To Date Label");
		String toDateValue = retrieve("To Date Value");
				
		
		reportPage = new ReportPage(obj);
		
		reportPage.clickReportTab(true);
		reportPage.clickReportLink(reportLink);
		
		reportPage.selectDropDownValue(fiscalYearLabel, fiscalYearValue);
		reportPage.selectRoleNameDropDownValue(originatingLocLabel);
		
		reportPage.selectCalenderPopup(fromDateLabel);
		reportPage.selectDate(fromDateValue);
		
		reportPage.selectCalenderPopup(toDateLabel);
		reportPage.selectDate(toDateValue);	
		
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
