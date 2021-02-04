package scenarios.DueDateReports.SDF;

import baseClass.BaseClass;
import iSAFE.ApplicationKeywords;

import pages.ReportPage;

public class DDR_SDF_03 extends ApplicationKeywords {
	

	BaseClass obj;
	private Boolean status = false;
	
	ReportPage reportPage;
	
	public DDR_SDF_03(BaseClass obj) {
		super(obj);
		this.obj = obj;
	}
	
	
	public void dDR_SDF_03() {
		
		
		String reportLink = retrieve("Report Link");
		String reportTitle=retrieve("ReportTitle");
		String TypeOfTaskLabel=retrieve("Type Of Task Label");
		String TypeOfTaskValue=retrieve("Type Of Task Value");
		String TypeOfTaskHeaderLabel=retrieve("Type Of Task Header Label");
		String SelectCategorylabel=retrieve("Select Category label");
		String SelectCategoryvalue=retrieve("Select Category value");
		String runReportButton=retrieve("Run Report Button");
		String originatingLocationLabel = retrieve("Originating Location Label");
		String originatingLocationHeaderLabel = retrieve("Originating Location Header Label");
		String currentLocationLabel = retrieve("Current Location Label");
		String currentLocationHeaderLabel = retrieve("Current Location Header Label");
		
		
		reportPage = new ReportPage(obj);
		reportPage.clickReportTab(true);
		reportPage.clickReportLink(reportLink);
		reportPage.clickDropDown(originatingLocationLabel);
		reportPage.selectDropDownPopupFirstValue(originatingLocationHeaderLabel);
		reportPage.clickDropDownClose();
		reportPage.clickDropDown(currentLocationLabel);
		reportPage.selectDropDownPopupFirstValue(currentLocationHeaderLabel);
		reportPage.clickDropDownClose();
		reportPage.selectDropDownValue(SelectCategorylabel, SelectCategoryvalue);
		reportPage.clickDropDown(TypeOfTaskLabel);
		reportPage.selectDropDownPopupValue(TypeOfTaskHeaderLabel,TypeOfTaskValue);
		reportPage.clickDropDownClose();
		reportPage.verifySelectedDropDownValue(TypeOfTaskValue);
		reportPage.verifyButton(runReportButton, true);
		obj.transferControlToWindow(2);
		obj.validateReportPageTitle(reportTitle);
		obj.transferControlToWindow(1);
		
		
		if (obj.testFailure|| reportPage.testFailure) {
			status = true;
		}
		this.testFailure = status;
	}
	
	
}



