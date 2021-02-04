package scenarios.TaskDetailReports.SBCE;

import baseClass.BaseClass;
import iSAFE.ApplicationKeywords;
import pages.ReportPage;

public class TDR_SBCE_004 extends ApplicationKeywords {
	

	BaseClass obj;
	private Boolean status = false;
	ReportPage reportPage;
	
	public TDR_SBCE_004(BaseClass obj) {
		super(obj);
		this.obj = obj;
	}
	
	
	public void tDR_SBCE_004() {
	
	
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
		String customReportSaveButton=retrieve("Custom Report Save Button");
		String saveReportButton=retrieve("Save Reoprt Button");
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
		int colposition=reportPage.getSystemWideCustomReportsHeaderPosition(reporttype,reportTitleNew);
		reportPage.getRowPositionValue(reporttype,colposition, reportTitle);
		
	
		if (obj.testFailure || reportPage.testFailure) {
			status = true;
		}
		this.testFailure = status;
	}
	
	}

