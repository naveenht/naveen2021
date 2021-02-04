package scenarios.DueDateReports.SDF;

import baseClass.BaseClass;
import iSAFE.ApplicationKeywords;
import pages.ReportPage;

public class DDR_SDF_07 extends ApplicationKeywords {
	

	BaseClass obj;
	private Boolean status = false;
	ReportPage reportPage;
	
	public  DDR_SDF_07(BaseClass obj) {
		super(obj);
		this.obj = obj;
	}
	
	
	public void dDR_SDF_07() {

		String reportLink = retrieve("Report Link");
		String reportTitleNew=retrieve("ReportTitlenew");
		String reporttype=retrieve("Reporttype");
		String reporttypeone=retrieve("Reporttypeone");
		String SelectCategorylabel=retrieve("Select Category label");
		String SelectCategoryvalue=retrieve("Select Category value");
		String SelectCategoryvalue1=retrieve("Select Category value1");
		String typevalue=retrieve("TypeValue");
		String typevalue1=retrieve("TypeValue1");
	
		
		String radioButtonLabel=retrieve("Radio Button Label");
		String radioButtonValue=retrieve("Radio Button Value");
		String radioButtonValue1=retrieve("Radio Button Value1");
		String reportTitleLabel=retrieve("Report Title Label");
		String reportDescriptionLabel=retrieve("Report Description Label");
		String reportDescriptionValue=retrieve("Report Description Value");
		
		String savereport=retrieve("Savereport");
		String filter=retrieve("Filter");
		String customReportSaveButton=retrieve("Custom Report Save Button");
		String resetReportButton=retrieve("Reset Reoprt Button");
		
		reportPage = new ReportPage(obj);
		
		reportPage.clickReportTab(true);
		reportPage.clickReportLink(reportLink);
		
		//System wide Reports
		reportPage.clickRadioButton(radioButtonLabel,radioButtonValue);
		reportPage.verifyButton(savereport, true);
		String systemWidereportTitle =reportPage.enterTextInSaveCustomReportPopup(reportTitleLabel, typevalue);
		reportPage.enterTextInSaveCustomReportPopup(reportDescriptionLabel, reportDescriptionValue);
		reportPage.verifySaveCustomReportPopupButtons(customReportSaveButton);
		
		int columnPosition=reportPage.getSystemWideCustomReportsHeaderPosition(reporttype,reportTitleNew);
		int rowPosition=reportPage.getRowPositionValue(reporttype,columnPosition, systemWidereportTitle);
		int columnPosition2=reportPage.getSystemWideCustomReportsHeaderPosition(reporttype,filter);
		reportPage.clickTableLinkBasedOnPosition(reporttype, columnPosition2, rowPosition);
		reportPage.selectDropDownValue(SelectCategorylabel, SelectCategoryvalue);
		reportPage.verifyButton(savereport, true);
		reportPage.verifySaveCustomReportPopupButtons(customReportSaveButton);
		int columnPosition1=reportPage.getSystemWideCustomReportsHeaderPosition(reporttype,reportTitleNew);
		int rowPosition1=reportPage.getRowPositionValue(reporttype,columnPosition1, systemWidereportTitle);
		int columnPosition3=reportPage.getSystemWideCustomReportsHeaderPosition(reporttype,filter);
		reportPage.clickTableLinkBasedOnPosition(reporttype, columnPosition3, rowPosition1);
		reportPage.selectDropDownValue(SelectCategorylabel, SelectCategoryvalue);
		
		// My Reports
		reportPage.verifyButton(resetReportButton, true);
		reportPage.clickRadioButton(radioButtonLabel,radioButtonValue1);
		reportPage.verifyButton(savereport, true);
		String myReportreportTitle =reportPage.enterTextInSaveCustomReportPopup(reportTitleLabel, typevalue1);
		reportPage.enterTextInSaveCustomReportPopup(reportDescriptionLabel, reportDescriptionValue);
		reportPage.verifySaveCustomReportPopupButtons(customReportSaveButton);
		
		int columnPosition6=reportPage.getSystemWideCustomReportsHeaderPosition(reporttypeone,reportTitleNew);
		int rowPosition2=reportPage.getRowPositionValue(reporttypeone,columnPosition6, myReportreportTitle);
		int columnPosition4=reportPage.getSystemWideCustomReportsHeaderPosition(reporttypeone,filter);
		reportPage.clickTableLinkBasedOnPosition(reporttypeone, columnPosition4, rowPosition2);
		reportPage.selectDropDownValue(SelectCategorylabel, SelectCategoryvalue1);
		reportPage.verifyButton(savereport, true);
		reportPage.verifySaveCustomReportPopupButtons(customReportSaveButton);
		int columnPosition5=reportPage.getSystemWideCustomReportsHeaderPosition(reporttypeone,reportTitleNew);
		int rowPosition3=reportPage.getRowPositionValue(reporttypeone,columnPosition5, myReportreportTitle);
		int columnPosition7=reportPage.getSystemWideCustomReportsHeaderPosition(reporttypeone,filter);
		reportPage.clickTableLinkBasedOnPosition(reporttypeone, columnPosition7, rowPosition3);
		reportPage.selectDropDownValue(SelectCategorylabel, SelectCategoryvalue1);
	
		
		if (obj.testFailure || reportPage.testFailure) {
			status = true;
		}
		this.testFailure = status;
	}
	
}


