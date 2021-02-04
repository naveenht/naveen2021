package scenarios.DueDateReports.SDF;

import baseClass.BaseClass;
import iSAFE.ApplicationKeywords;

import pages.ReportPage;

public class DDR_SDF_22 extends ApplicationKeywords {
	

	BaseClass obj;
	private Boolean status = false;
	
	ReportPage reportPage;
	
	public DDR_SDF_22(BaseClass obj) {
		super(obj);
		this.obj = obj;
	}
	
	
	public void dDR_SDF_22() {

		String reportLink = retrieve("Report Link");
		String reportTitle=retrieve("ReportTitle");
		String runReportButton=retrieve("Run Report Button");
		
		
		String selectCategorylabel=retrieve("Select Category label");
		String selectCategoryvalue=retrieve("Select Category value");
		
		reportPage = new ReportPage(obj);
		
		reportPage.clickReportTab(true);
		
		
		reportPage.clickReportLink(reportLink);
		
		reportPage.selectDropDownValueCategory(selectCategorylabel, selectCategoryvalue);
		
		
		reportPage.verifyButton(runReportButton, true);
		obj.transferControlToWindow(2);
		obj.validateReportPageTitle(reportTitle);
		obj.transferControlToWindow(1);
		
       
		if (obj.testFailure || reportPage.testFailure) {
			status = true;
		}
		this.testFailure = status;
	}
	
}
	


