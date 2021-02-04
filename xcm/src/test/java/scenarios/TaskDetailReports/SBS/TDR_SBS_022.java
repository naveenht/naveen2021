package scenarios.TaskDetailReports.SBS;

import baseClass.BaseClass;
import iSAFE.ApplicationKeywords;
import pages.ReportPage;

public class TDR_SBS_022 extends ApplicationKeywords {
	

	BaseClass obj;
	private Boolean status = false;
	ReportPage reportPage;
	
	public TDR_SBS_022(BaseClass obj) {
		super(obj);
		this.obj = obj;
	}
	
	
	public void tDR_SBS_022() {
      
		String reportLink=retrieve("Report Link");
		String reportPageTitle=retrieve("Report Page Title");
		String whoHasTaskLabel=retrieve("DropDowntype");
		String whoHasTaskValue=retrieve("DropdownValue");
		String selectCategoryLabel=retrieve("Select Category label");
		String selectCategoryValue=retrieve("Select Category value");
		String fisicalYearLabel=retrieve("Fiscal Year Label");
		String fisicalYearValue=retrieve("Fiscal Year Value");
		String runReportButton=retrieve("Run Report Button");
		reportPage = new ReportPage(obj);
		
		reportPage.clickReportTab(true);
		reportPage.clickReportLink(reportLink);
		reportPage.selectDropDownValue(whoHasTaskLabel, whoHasTaskValue);
		reportPage.selectDropDownValueCategory(selectCategoryLabel,selectCategoryValue);
		reportPage.selectDropDownValue(fisicalYearLabel, fisicalYearValue);
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
	


