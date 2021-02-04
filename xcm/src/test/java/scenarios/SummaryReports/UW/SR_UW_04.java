package scenarios.SummaryReports.UW;
import baseClass.BaseClass;
import iSAFE.ApplicationKeywords;
import pages.ReportPage;

public class SR_UW_04 extends ApplicationKeywords {
	

	BaseClass obj;
	private Boolean status = false;
	ReportPage reportPage;
	
	public SR_UW_04(BaseClass obj) {
		super(obj);
		this.obj = obj;
	}
	
	
	public void sR_UW_04() {
		

		String reportLink=retrieve("Report Link");
		String typeOfTasklabel=retrieve("Type Of Task Label");
		String typeOfTaskValue=retrieve("Type Of Task Value");
		String typeOfTaskHeaderLabel=retrieve("Type Of Task Header Label");
		String selectCategorylabel=retrieve("Select Category label");
		String selectCategoryvalue=retrieve("Select Category value");
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
		reportPage.selectDropDownValue(selectCategorylabel, selectCategoryvalue);
		reportPage.clickDropDown(typeOfTasklabel);
		reportPage.selectDropDownPopupValue(typeOfTaskHeaderLabel,typeOfTaskValue);
		reportPage.clickDropDownClose();
		reportPage.verifySelectedDropDownValue(typeOfTaskValue);
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

