package scenarios.DueDateReports.EXT;

import baseClass.BaseClass;
import iSAFE.ApplicationKeywords;
import pages.ReportPage;

public class DDR_EXT_03 extends ApplicationKeywords {

	BaseClass obj;
	private Boolean status = false;
	ReportPage reportPage;
	
	public DDR_EXT_03(BaseClass obj) {
		super(obj);
		this.obj = obj;
	}
	
	public void dDR_EXT_03() {
		
		String reportLink=retrieve("Report Link");
		String runReportButton=retrieve("Run Report Button");
		String reportPageTitle=retrieve("Report Page Title");
		
		String fiscalYearLabel=retrieve("Fiscal Year Label");
		String fiscalYearValue=retrieve("Fiscal Year Value");
		String FiscalYearHeaderLabel=retrieve("Fiscal Year Header Label");
		
		String typeOfTaskLabel=retrieve("Type Of Task Label");
		String typeOfTaskValue=retrieve("Type Of Task Value");
		String typeOfTaskHeaderLabel=retrieve("Type Of Task Header Label");
		
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
		
		reportPage.clickDropDown(fiscalYearLabel);
		reportPage.selectDropDownPopupValue(FiscalYearHeaderLabel, fiscalYearValue);
		reportPage.clickDropDownClose();
		
		reportPage.clickDropDown(typeOfTaskLabel);
		reportPage.selectDropDownPopupValue(typeOfTaskHeaderLabel, typeOfTaskValue);
		reportPage.clickDropDownClose();
		
		reportPage.verifySelectedDropDownValue(typeOfTaskValue);
		reportPage.verifyButton(runReportButton, true);
		obj.transferControlToWindow(2);
		obj.validateReportPageTitle(reportPageTitle);
		obj.transferControlToWindow(1);
		
		
		if (obj.testFailure || reportPage.testFailure) {
			status = true;
		}
		this.testFailure = status;
	}
	





}
