package scenarios.SummaryReports.TTT;

import baseClass.BaseClass;
import iSAFE.ApplicationKeywords;
import pages.ReportPage;

public class SR_TTT_02 extends ApplicationKeywords {
	
	BaseClass obj;
	ReportPage reportPage;
	private Boolean status = false;
	
	public SR_TTT_02(BaseClass obj) {
		super(obj);
		this.obj = obj;
		
	}
	
	public void sR_TTT_02() {
		
		String reportName=retrieve("ReportName");
		String reportTitle=retrieve("ReportTitle");
		String dropdownLabel2=retrieve("Dropdown Label2");
		String dropdownValue2=retrieve("DropdownValue2");
		String runReportButton=retrieve("Run Report Button");

		reportPage = new ReportPage(obj);
		reportPage.clickReportTab(true);
		reportPage.clickReportLink(reportName);
		reportPage.selectDropDownValue(dropdownLabel2, dropdownValue2);
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




