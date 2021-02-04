package scenarios.DueDateReports.SDF;

import baseClass.BaseClass;
import iSAFE.ApplicationKeywords;

import pages.ReportPage;

public class DDR_SDF_05 extends ApplicationKeywords {
	

	BaseClass obj;
	private Boolean status = false;
	
	ReportPage reportPage;
	
	public DDR_SDF_05(BaseClass obj) {
		super(obj);
		this.obj = obj;
	}
	
	
	public void dDR_SDF_05() {
		
	   
		String reportLink = retrieve("Report Link");
		String TypeOfTaskLabel=retrieve("Type Of Task Label");
		String TypeOfTaskValue=retrieve("Type Of Task Value");
		String TypeOfTaskHeaderLabel=retrieve("Type Of Task Header Label");
		String SelectCategorylabel=retrieve("Select Category label");
		String SelectCategoryvalue=retrieve("Select Category value");
		String customerreport=retrieve("CustomerReport");
		String reporttype=retrieve("Reporttype");
		String titleText=retrieve("TitleText");
		String reportDescription=retrieve("ReportDescription");
		String reportDescriptionValue=retrieve("ReportDescriptionValue");
		String reportTitlenew=retrieve("ReportTitlenew");
		String saveReportButton=retrieve("Save Reoprt Button");
		String customReportSaveButton=retrieve("Custom Report Save Button");
        reportPage = new ReportPage(obj);
		
		reportPage.clickReportTab(true);
		reportPage.clickReportLink(reportLink);
		reportPage.selectDropDownValue(SelectCategorylabel, SelectCategoryvalue);
		reportPage.clickDropDown(TypeOfTaskLabel);
		reportPage.selectDropDownPopupValue(TypeOfTaskHeaderLabel,TypeOfTaskValue);
		reportPage.clickDropDownClose();
		reportPage.verifySelectedDropDownValue(TypeOfTaskValue);
		reportPage.clickRadioButton(customerreport,reporttype);
		reportPage.verifyButton(saveReportButton, true);
		String reportTitle=reportPage.enterTextInSaveCustomReportPopup(reportTitlenew, titleText);
		reportPage.enterTextInSaveCustomReportPopup(reportDescription, reportDescriptionValue);
		reportPage.verifySaveCustomReportPopupButtons(customReportSaveButton);
		int columnPosition=reportPage.getSystemWideCustomReportsHeaderPosition(reporttype,reportTitlenew);
		reportPage.getRowPositionValue(reporttype,columnPosition, reportTitle);
		
	   
		if (obj.testFailure || reportPage.testFailure) {
			status = true;
		}
		this.testFailure = status;
	}

}



