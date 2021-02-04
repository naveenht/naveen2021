package scenarios.DueDateReports.EXT;

import baseClass.BaseClass;
import iSAFE.ApplicationKeywords;
import pages.ReportPage;

public class DDR_EXT_22 extends ApplicationKeywords{
	
	BaseClass obj;
	ReportPage reportPage;
	
	public DDR_EXT_22(BaseClass obj) {
		super(obj);
		this.obj = obj;
		
	}
	
	public void dDR_EXT_22() {
		
		String reportLink=retrieve("Report Link");
		String runReportButton=retrieve("Run Report Button");
		String reportPageTitle=retrieve("Report Page Title");
		String selectCategorylabel=retrieve("Select Category label");
		String selectCategoryvalue=retrieve("Select Category value");
		
		reportPage = new ReportPage(obj);
		
		reportPage.clickReportTab(true);
		reportPage.clickReportLink(reportLink);
		
	
		reportPage.selectDropDownValueCategory(selectCategorylabel, selectCategoryvalue);
		reportPage.verifyButton(runReportButton, true);
		obj.transferControlToWindow(2);
		obj.validateReportPageTitle(reportPageTitle);
		obj.transferControlToWindow(1);
		
	} 





}
