package scenarios.DueDateReports.EXT;

import baseClass.BaseClass;
import iSAFE.ApplicationKeywords;
import pages.ReportPage;

public class DDR_EXT_02 extends ApplicationKeywords{
	
	BaseClass obj;
	ReportPage reportPage;
	
	public DDR_EXT_02(BaseClass obj) {
		super(obj);
		this.obj = obj;
		
	}
	
	public void dDR_EXT_02() {
		
		String reportLink=retrieve("Report Link");
		String runReportButton=retrieve("Run Report Button");
		String reportPageTitle=retrieve("Report Page Title");
		String fiscalYearLabel=retrieve("Fiscal Year Label");
		String fiscalYearValue=retrieve("Fiscal Year Value");
		String FiscalYearHeaderLabel=retrieve("Fiscal Year Header Label");
		String originatingLocationLabel=retrieve("Originating Location Label");
		String originatingLocationHeaderLabel=retrieve("Originating Location Header Label");
		
		reportPage = new ReportPage(obj);
		
		reportPage.clickReportTab(true);
		reportPage.clickReportLink(reportLink);
		reportPage.clickDropDown(originatingLocationLabel);
		reportPage.selectAllDropDownValues(originatingLocationHeaderLabel);
		reportPage.clickDropDownClose();
		reportPage.clickDropDown(fiscalYearLabel);
		reportPage.selectDropDownPopupValue(FiscalYearHeaderLabel, fiscalYearValue);
		reportPage.clickDropDownClose();
		reportPage.verifyButton(runReportButton, true);
		obj.transferControlToWindow(2);
		obj.validateReportPageTitle(reportPageTitle);
		obj.transferControlToWindow(1);
		
	} 





}
