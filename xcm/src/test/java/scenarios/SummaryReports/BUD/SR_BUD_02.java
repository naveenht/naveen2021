package scenarios.SummaryReports.BUD;

import baseClass.BaseClass;
import iSAFE.ApplicationKeywords;
import pages.ReportPage;

public class SR_BUD_02 extends ApplicationKeywords {
	
	BaseClass obj;
	private Boolean status = false;
	ReportPage reportPage;
	
	public SR_BUD_02(BaseClass obj) {
		super(obj);
		this.obj = obj;
		
	}
	
	public void sR_BUD_02() {
		
		String reportLink=retrieve("Report Link");
		String reportPageTitle=retrieve("Report Page Title");	
		String selectCategorylabel=retrieve("Select Category label");
		String selectCategoryvalue=retrieve("Select Category value");
		String fiscalYearLabel = retrieve("Fiscal Year Label");
		String fiscalYearValue = retrieve("Fiscal Year Value");
		String runReportButton=retrieve("Run Report Button");
		
		

		reportPage = new ReportPage(obj);
		reportPage.clickReportTab(true);
		reportPage.clickReportLink(reportLink);
		reportPage.selectDropDownValue(selectCategorylabel, selectCategoryvalue);
		reportPage.selectDropDownValue(fiscalYearLabel, fiscalYearValue);
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


