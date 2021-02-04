package scenarios.DueDateReports.SDF;

import baseClass.BaseClass;
import iSAFE.ApplicationKeywords;
import pages.ReportPage;

public class DDR_SDF_08 extends ApplicationKeywords {
	

	BaseClass obj;
	private Boolean status = false;
	ReportPage reportPage;
	
	public DDR_SDF_08(BaseClass obj) {
		super(obj);
		this.obj = obj;
	}
	
	
	public void dDR_SDF_08() {
		
	  
		String reportLink = retrieve("Report Link");
		String reporttype=retrieve("Reporttype");
		String reportTitleNew=retrieve("ReportTitlenew");
		String reportTitle=retrieve("ReportTitle");
		String selectcategory=retrieve("Select Category label");
		String typevalue=retrieve("TypeValue");
		String reporttitleverify=retrieve("ReportTitleverify");
		String categorytype=retrieve("Select Category value");
		String savereport=retrieve("Savereport");
		String reporttypeone=retrieve("Reporttypeone");
		String typevalue1=retrieve("TypeValue1");
		
		String radioButtonLabel=retrieve("Radio Button Label");
		String radioButtonValue=retrieve("Radio Button Value");
		String radioButtonValue1=retrieve("Radio Button Value1");
		String reportTitleLabel=retrieve("Report Title Label");
		String reportDescriptionLabel=retrieve("Report Description Label");
		String reportDescriptionValue=retrieve("Report Description Value");
		
		String categorytype2=retrieve("Categorytype2");
		String filter=retrieve("Filter");
		String customReportSaveButton=retrieve("Custom Report Save Button");
		String TableRunHeader=retrieve("Table Run Header");
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
		reportPage.selectDropDownValue(selectcategory, categorytype);
		reportPage.verifyButton(savereport, true);
		reportPage.verifySaveCustomReportPopupButtons(customReportSaveButton);
		int columnPosition1=reportPage.getSystemWideCustomReportsHeaderPosition(reporttype,reportTitleNew);
		int rowPosition1=reportPage.getRowPositionValue(reporttype,columnPosition1, systemWidereportTitle);
		int columnPosition3=reportPage.getSystemWideCustomReportsHeaderPosition(reporttype,filter);
		reportPage.clickTableLinkBasedOnPosition(reporttype, columnPosition3, rowPosition1);
		reportPage.getSelectedDropDownValue(selectcategory,categorytype);
		int columnPosition9=reportPage.getSystemWideCustomReportsHeaderPosition(reporttype,reportTitleNew);
		int rowPosition5=reportPage.getRowPositionValue(reporttype,columnPosition9, systemWidereportTitle);
		int columnPosition8=reportPage.getSystemWideCustomReportsHeaderPosition(reporttype,TableRunHeader);
		reportPage.clickTableLinkBasedOnPosition(reporttype, columnPosition8, rowPosition5);
		obj.transferControlToWindow(2);
		obj.validateReportPageTitle(reportTitle);
		obj.transferControlToWindow(1);
		
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
		reportPage.selectDropDownValue(selectcategory, categorytype2);
		reportPage.verifyButton(savereport, true);
		reportPage.verifySaveCustomReportPopupButtons(customReportSaveButton);
		int columnPosition5=reportPage.getSystemWideCustomReportsHeaderPosition(reporttypeone,reportTitleNew);
		int rowPosition3=reportPage.getRowPositionValue(reporttypeone,columnPosition5, myReportreportTitle);
		int columnPosition7=reportPage.getSystemWideCustomReportsHeaderPosition(reporttypeone,filter);
		reportPage.clickTableLinkBasedOnPosition(reporttypeone, columnPosition7, rowPosition3);
		reportPage.getSelectedDropDownValue(selectcategory,categorytype2);
		int columnPosition10=reportPage.getSystemWideCustomReportsHeaderPosition(reporttypeone,reportTitleNew);
		int rowPosition6=reportPage.getRowPositionValue(reporttypeone,columnPosition10, myReportreportTitle);
		int columnPosition11=reportPage.getSystemWideCustomReportsHeaderPosition(reporttypeone,TableRunHeader);
		reportPage.clickTableLinkBasedOnPosition(reporttypeone, columnPosition11, rowPosition6);
		obj.transferControlToWindow(2);
		obj.validateReportPageTitle(reporttitleverify);
		obj.transferControlToWindow(1);
	
	   
		if (obj.testFailure || reportPage.testFailure) {
			status = true;
		}
		this.testFailure = status;
	}
	
}

