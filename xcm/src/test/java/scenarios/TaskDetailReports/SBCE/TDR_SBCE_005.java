package scenarios.TaskDetailReports.SBCE;

import baseClass.BaseClass;
import iSAFE.ApplicationKeywords;
import pages.ReportPage;

public class TDR_SBCE_005 extends ApplicationKeywords {
	

	BaseClass obj;
	private Boolean status = false;
	ReportPage reportPage;
	
	public TDR_SBCE_005(BaseClass obj) {
		super(obj);
		this.obj = obj;
	}
	
	
	public void tDR_SBCE_005() {
		
	   
		String reportLink=retrieve("Report Link");
		String typeOfTaskLabel = retrieve("Type Of Task Label");
		String typeOfTaskValue = retrieve("Type Of Task Value");
		String fisicalYearLabel=retrieve("Fiscal Year Label");
		String fisicalYearValue=retrieve("Fiscal Year Value");
		String customerreport=retrieve("CustomerReport");
		String reporttype=retrieve("Reporttype");
		String reportTitleNew=retrieve("ReportTitleNew");
		String titleText=retrieve("TitleText");
		String reportDescription=retrieve("ReportDescription");
		String reportDescriptionValue=retrieve("ReportDescriptionValue");
		String saveReportButton=retrieve("Save Reoprt Button");
		String customReportSaveButton=retrieve("Custom Report Save Button");
		reportPage = new ReportPage(obj);
		
		reportPage.clickReportTab(true);
		reportPage.clickReportLink(reportLink);
		reportPage.selectDropDownValue(fisicalYearLabel, fisicalYearValue);
		reportPage.selectDropDownValue(typeOfTaskLabel, typeOfTaskValue);
		reportPage.clickRadioButton(customerreport,reporttype);
		reportPage.verifyButton(saveReportButton, true);
		String reportTitle=reportPage.enterTextInSaveCustomReportPopup(reportTitleNew, titleText);
		reportPage.enterTextInSaveCustomReportPopup(reportDescription, reportDescriptionValue);
		reportPage.verifySaveCustomReportPopupButtons(customReportSaveButton);
		int columnPosition=reportPage.getSystemWideCustomReportsHeaderPosition(reporttype,reportTitleNew);
		reportPage.getRowPositionValue(reporttype,columnPosition, reportTitle);
	    
		if (obj.testFailure || reportPage.testFailure) {
			status = true;
		}
		this.testFailure = status;
	}}
	




