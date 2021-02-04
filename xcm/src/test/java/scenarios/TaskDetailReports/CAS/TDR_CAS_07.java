package scenarios.TaskDetailReports.CAS;

import baseClass.BaseClass;
import iSAFE.ApplicationKeywords;
import pages.ReportPage;

public class TDR_CAS_07 extends ApplicationKeywords {
	

	BaseClass obj;
	private Boolean status = false;
	ReportPage reportpage;
	
	public TDR_CAS_07(BaseClass obj) {
		super(obj);
		this.obj = obj;
	}
	
	
	public void tDR_CAS_07() {
		
	
		String reportLink=retrieve("Report Link");
		String systemWideTableName=retrieve("System Wide Table Name");
		String myReportsTableName=retrieve("My Reports Table Name");
		String systemWideColumnValue=retrieve("System Wide Column Value");
		String myReportsColumnValue=retrieve("My Reports Column Value");
		String fiscalYearLabel=retrieve("Fiscal Year Label");
		String systemWidefiscalYearValue=retrieve("System Wide Fiscal Year Value");
		String myReportsfiscalYearValue=retrieve("My Reports Fiscal Year Value");
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
		
		
		reportpage = new ReportPage(obj);
		
		reportpage.clickReportTab(true);
		reportpage.clickReportLink(reportLink);
		
		//System wide Reports
		
		reportpage.clickRadioButton(radioButtonLabel,radioButtonValue);
		reportpage.verifyButton(saveReportButton, true);
		String systemWidereportTitle=reportpage.enterTextInSaveCustomReportPopup(reportTitleLabel, systemWideColumnValue);
		reportpage.enterTextInSaveCustomReportPopup(reportDescriptionLabel, reportDescriptionValue);
		reportpage.verifySaveCustomReportPopupButtons(customReportSaveButton);
		
		int columnPosition=reportpage.getSystemWideCustomReportsHeaderPosition(systemWideTableName,tableColumnHeader);
		int rowPosition=reportpage.getRowPositionValue(systemWideTableName,columnPosition, systemWidereportTitle);
		int columnPosition2=reportpage.getSystemWideCustomReportsHeaderPosition(systemWideTableName,tableFilterColumnHeader);
		reportpage.clickTableLinkBasedOnPosition(systemWideTableName, columnPosition2, rowPosition);
		reportpage.selectDropDownValue(fiscalYearLabel,systemWidefiscalYearValue);
		reportpage.verifyButton(saveReportButton, true);
		reportpage.verifySaveCustomReportPopupButtons(customReportSaveButton);
		int columnPosition1=reportpage.getSystemWideCustomReportsHeaderPosition(systemWideTableName,tableColumnHeader);
		int rowPosition1=reportpage.getRowPositionValue(systemWideTableName,columnPosition1, systemWidereportTitle);
		int columnPosition3=reportpage.getSystemWideCustomReportsHeaderPosition(systemWideTableName,tableFilterColumnHeader);
		reportpage.clickTableLinkBasedOnPosition(systemWideTableName, columnPosition3, rowPosition1);
		reportpage.getSelectedDropDownValue(fiscalYearLabel,systemWidefiscalYearValue);
		
		
		
		// My Reports
		
		reportpage.verifyButton(resetReportButton, true);
		reportpage.clickRadioButton(radioButtonLabel,radioButtonValue1);
		reportpage.verifyButton(saveReportButton, true);
		String myReportreportTitle=reportpage.enterTextInSaveCustomReportPopup(reportTitleLabel, myReportsColumnValue);
		reportpage.enterTextInSaveCustomReportPopup(reportDescriptionLabel, reportDescriptionValue);
		reportpage.verifySaveCustomReportPopupButtons(customReportSaveButton);
		
		int columnPosition6=reportpage.getSystemWideCustomReportsHeaderPosition(myReportsTableName,tableColumnHeader);
		int rowPosition2=reportpage.getRowPositionValue(myReportsTableName,columnPosition6, myReportreportTitle);
		int columnPosition4=reportpage.getSystemWideCustomReportsHeaderPosition(myReportsTableName,tableFilterColumnHeader);
		reportpage.clickTableLinkBasedOnPosition(myReportsTableName, columnPosition4, rowPosition2);
		reportpage.selectDropDownValue(fiscalYearLabel, myReportsfiscalYearValue);
		reportpage.verifyButton(saveReportButton, true);
		reportpage.verifySaveCustomReportPopupButtons(customReportSaveButton);
		int columnPosition5=reportpage.getSystemWideCustomReportsHeaderPosition(myReportsTableName,tableColumnHeader);
		int rowPosition3=reportpage.getRowPositionValue(myReportsTableName,columnPosition5, myReportreportTitle);
		int columnPosition7=reportpage.getSystemWideCustomReportsHeaderPosition(myReportsTableName,tableFilterColumnHeader);
		reportpage.clickTableLinkBasedOnPosition(myReportsTableName, columnPosition7, rowPosition3);
		reportpage.getSelectedDropDownValue(fiscalYearLabel, myReportsfiscalYearValue);
		
		
		if (obj.testFailure || reportpage.testFailure ) {
			status = true;
		}
		this.testFailure = status;
	}
	

}
