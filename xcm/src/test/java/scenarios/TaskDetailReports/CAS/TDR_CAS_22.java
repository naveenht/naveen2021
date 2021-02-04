package scenarios.TaskDetailReports.CAS;

import baseClass.BaseClass;
import iSAFE.ApplicationKeywords;
import pages.ReportPage;

public class TDR_CAS_22 extends ApplicationKeywords {
	
	BaseClass obj;
	private Boolean status = false;
	ReportPage reportPage;
	
	public TDR_CAS_22(BaseClass obj) {
		super(obj);
		this.obj = obj;
	}
	
	
	public void tDR_CAS_22() {
		
		String reportLink=retrieve("Report Link");
		String runReportButton=retrieve("Run Report Button");
		String reportPageTitle=retrieve("Report Page Title");
		String selectCategorylabel=retrieve("Select Category label");
		String selectCategoryvalue=retrieve("Select Category value");
		String originatingLocationLabel=retrieve("Originating Location Label");
		String originatingLocationHeaderLabel=retrieve("Originating Location Header Label");
		reportPage = new ReportPage(obj);
		
		reportPage.clickReportTab(true);
		reportPage.clickReportLink(reportLink);
		reportPage.selectDropDownValueCategory(selectCategorylabel, selectCategoryvalue);
		reportPage.clickDropDown(originatingLocationLabel);
		reportPage.selectAllDropDownValues(originatingLocationHeaderLabel);
		reportPage.clickDropDownClose();
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