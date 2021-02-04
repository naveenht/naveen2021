package scenarios.TaskDetailReports.SBS;

import baseClass.BaseClass;
import iSAFE.ApplicationKeywords;
import pages.ReportPage;

public class TDR_SBS_005 extends ApplicationKeywords {
	

	BaseClass obj;
	private Boolean status = false;
	ReportPage reportPage;
	
	public TDR_SBS_005(BaseClass obj) {
		super(obj);
		this.obj = obj;
	}
	
	
	public void tDR_SBS_005() {
		
	  
		String reportLink=retrieve("Report Link");
		String typeOfTaskLabel = retrieve("Type Of Task Label");
		String typeOfTaskValue = retrieve("Type Of Task Value");
		String typeOfTaskHeaderLabel = retrieve("Type Of Task Header Label");
		String selectcategorylabel=retrieve("Select Category label");
		String categorytype=retrieve("Categorytype");
		String customerreport=retrieve("CustomerReport");
		String reporttype=retrieve("Reporttype");
		String titleText=retrieve("TitleText");
		String reportDescription=retrieve("ReportDescription");
		String reportDescriptionValue=retrieve("ReportDescriptionValue");
		String reportTitlenew=retrieve("ReportTitlenew");
		String reportTitlenew1=retrieve("ReportTitlenew1");
		String saveReportButton=retrieve("Save Reoprt Button");
		String customReportSaveButton=retrieve("Custom Report Save Button");
		
		reportPage = new ReportPage(obj);
		
		reportPage.clickReportTab(true);
		reportPage.clickReportLink(reportLink);
		reportPage.selectDropDownValue(selectcategorylabel, categorytype);
		reportPage.clickDropDown(typeOfTaskLabel);
		reportPage.selectDropDownPopupValue(typeOfTaskHeaderLabel,typeOfTaskValue);
		reportPage.clickDropDownClose();
		reportPage.verifySelectedDropDownValue(typeOfTaskValue);
		reportPage.clickRadioButton(customerreport,reporttype);
		reportPage.verifyButton(saveReportButton, true);
		String reportTitle=reportPage.enterTextInSaveCustomReportPopup(reportTitlenew, titleText);
		reportPage.enterTextInSaveCustomReportPopup(reportDescription, reportDescriptionValue);
		reportPage.verifySaveCustomReportPopupButtons(customReportSaveButton);
		int columnPosition=reportPage.getSystemWideCustomReportsHeaderPosition(reporttype,reportTitlenew1);
		reportPage.getRowPositionValue(reporttype,columnPosition, reportTitle);
		
	   
		if (obj.testFailure || reportPage.testFailure) {
			status = true;
		}
		this.testFailure = status;
	}
	}




