package scenarios.SummaryReports.TBS;

import baseClass.BaseClass;
import iSAFE.ApplicationKeywords;
import pages.ReportPage;

public class SR_TBS_02 extends ApplicationKeywords {
	
	BaseClass obj;
	ReportPage reportPage;
	private Boolean status = false;
	
	public SR_TBS_02(BaseClass obj) {
		super(obj);
		this.obj = obj;
		
	}
	
	public void sR_TBS_02() {
		
		String reportLink = retrieve("Report Link");
		String reportTitle=retrieve("ReportTitle");
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
		obj.validateReportPageTitle(reportTitle);
		obj.transferControlToWindow(1);

		if (obj.testFailure || reportPage.testFailure) {
			status = true;
		}
		this.testFailure = status;
	}
	

} 