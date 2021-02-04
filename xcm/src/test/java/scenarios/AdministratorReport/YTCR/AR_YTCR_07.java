package scenarios.AdministratorReport.YTCR;

import baseClass.BaseClass;
import iSAFE.ApplicationKeywords;
import pages.ReportPage;

public class AR_YTCR_07 extends ApplicationKeywords {

	BaseClass obj;
	private Boolean status = false;
	ReportPage reportPage;

	public AR_YTCR_07(BaseClass obj) {
		super(obj);
		this.obj = obj;
	}

	public void aR_YTCR_07() {

		String reportLink=retrieve("Report Link");
		String systemWideTableName=retrieve("System Wide Table Name");
		String myReportsTableName=retrieve("My Reports Table Name");
		String systemWideColumnValue=retrieve("System Wide Column Value");
		String myReportsColumnValue=retrieve("My Reports Column Value");
		
		String groupLabel=retrieve("Group Label");
		//String systemWideGroupValue=retrieve("System Wide Group Value");
		//String myReportsGroupValue=retrieve("My Reports Group Value");
		
		String radioButtonLabel=retrieve("Radio Button Label");
		String radioButtonValue=retrieve("Radio Button Value");
		String saveReportButton=retrieve("Save Reoprt Button");
		String customReportSaveButton=retrieve("Custom Report Save Button");
		String resetReportButton=retrieve("Reset Reoprt Button");
	
		
		String tableColumnHeader=retrieve("Table Column Header");
		String tableFilterColumnHeader=retrieve("Table Filter Column Header");
		
		
	
		String radioButtonValue1=retrieve("Radio Button Value1");
		String reportTitleLabel=retrieve("Report Title Label");
		String reportDescriptionLabel=retrieve("Report Description Label");
		String reportDescriptionValue=retrieve("Report Description Value");
		
		String fromDateLabel = retrieve("From Date Label");
		String fromDateValue = retrieve("From Date Value");
		String toDateLabel = retrieve("To Date Label");
		String toDateValue = retrieve("To Date Value");
		
		reportPage = new ReportPage(obj);
		
		reportPage.clickReportTab(true);
		reportPage.clickReportLink(reportLink);
		
		//System wide Reports
		
		reportPage.selectCalenderPopup(fromDateLabel);
		reportPage.selectDate(fromDateValue);
		reportPage.selectCalenderPopup(toDateLabel);
		reportPage.selectDate(toDateValue);
		reportPage.clickRadioButton(radioButtonLabel,radioButtonValue);
		reportPage.verifyButton(saveReportButton, true);
		String systemWidereportTitle=reportPage.enterTextInSaveCustomReportPopup(reportTitleLabel, systemWideColumnValue);
		reportPage.enterTextInSaveCustomReportPopup(reportDescriptionLabel, reportDescriptionValue);
		reportPage.verifySaveCustomReportPopupButtons(customReportSaveButton);
		
		int columnPosition=reportPage.getSystemWideCustomReportsHeaderPosition(systemWideTableName,tableColumnHeader);
		int rowPosition=reportPage.getRowPositionValue(systemWideTableName,columnPosition, systemWidereportTitle);
		int columnPosition2=reportPage.getSystemWideCustomReportsHeaderPosition(systemWideTableName,tableFilterColumnHeader);
		reportPage.clickTableLinkBasedOnPosition(systemWideTableName, columnPosition2, rowPosition);
		String systemWideGroupValue=reportPage.clickRoleNameDropDown(groupLabel);
		reportPage.verifyButton(saveReportButton, true);
		reportPage.verifySaveCustomReportPopupButtons(customReportSaveButton);
		int columnPosition1=reportPage.getSystemWideCustomReportsHeaderPosition(systemWideTableName,tableColumnHeader);
		int rowPosition1=reportPage.getRowPositionValue(systemWideTableName,columnPosition1, systemWidereportTitle);
		int columnPosition3=reportPage.getSystemWideCustomReportsHeaderPosition(systemWideTableName,tableFilterColumnHeader);
		reportPage.clickTableLinkBasedOnPosition(systemWideTableName, columnPosition3, rowPosition1);
		reportPage.getSelectedDropDownValue(groupLabel,systemWideGroupValue);
		
		
		
		// My Reports
		
		
		reportPage.verifyButton(resetReportButton, true);
		reportPage.selectCalenderPopup(fromDateLabel);
		reportPage.selectDate(fromDateValue);
		reportPage.selectCalenderPopup(toDateLabel);
		reportPage.selectDate(toDateValue);
		reportPage.clickRadioButton(radioButtonLabel,radioButtonValue1);
		reportPage.verifyButton(saveReportButton, true);
		String myReportreportTitle=reportPage.enterTextInSaveCustomReportPopup(reportTitleLabel, myReportsColumnValue);
		reportPage.enterTextInSaveCustomReportPopup(reportDescriptionLabel, reportDescriptionValue);
		reportPage.verifySaveCustomReportPopupButtons(customReportSaveButton);
		
		int columnPosition6=reportPage.getSystemWideCustomReportsHeaderPosition(myReportsTableName,tableColumnHeader);
		int rowPosition2=reportPage.getRowPositionValue(myReportsTableName,columnPosition6, myReportreportTitle);
		int columnPosition4=reportPage.getSystemWideCustomReportsHeaderPosition(myReportsTableName,tableFilterColumnHeader);
		reportPage.clickTableLinkBasedOnPosition(myReportsTableName, columnPosition4, rowPosition2);
		String myReportsGroupValue= reportPage.clickRoleNameDropDown(groupLabel);
		reportPage.verifyButton(saveReportButton, true);
		reportPage.verifySaveCustomReportPopupButtons(customReportSaveButton);
		int columnPosition5=reportPage.getSystemWideCustomReportsHeaderPosition(myReportsTableName,tableColumnHeader);
		int rowPosition3=reportPage.getRowPositionValue(myReportsTableName,columnPosition5, myReportreportTitle);
		int columnPosition7=reportPage.getSystemWideCustomReportsHeaderPosition(myReportsTableName,tableFilterColumnHeader);
		reportPage.clickTableLinkBasedOnPosition(myReportsTableName, columnPosition7, rowPosition3);
		reportPage.getSelectedDropDownValue(groupLabel, myReportsGroupValue);

		if (obj.testFailure || reportPage.testFailure) {
			status = true;
		}
		this.testFailure = status;
	}

}
