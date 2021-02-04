package scenarios.DueDateReports.SDF;

import baseClass.BaseClass;
import iSAFE.ApplicationKeywords;

import pages.ReportPage;

public class DDR_SDF_04 extends ApplicationKeywords {
	

	BaseClass obj;
	private Boolean status = false;
	
	ReportPage reportPage;
	
	public DDR_SDF_04(BaseClass obj) {
		super(obj);
		this.obj = obj;
	}
	
	
	public void dDR_SDF_04() {
		
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
		String customReportSaveButton=retrieve("Custom Report Save Button");
		String saveReportButton=retrieve("Save Reoprt Button");
		
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
		int colposition=reportPage.getSystemWideCustomReportsHeaderPosition(reporttype,reportTitlenew);
		reportPage.getRowPositionValue(reporttype,colposition, reportTitle);

		
		if (obj.testFailure || reportPage.testFailure) {
			status = true;
		}
		this.testFailure = status;
	}
	
}


