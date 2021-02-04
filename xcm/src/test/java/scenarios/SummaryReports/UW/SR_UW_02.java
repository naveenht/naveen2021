package scenarios.SummaryReports.UW;

import baseClass.BaseClass;
import iSAFE.ApplicationKeywords;
import pages.ReportPage;

public class SR_UW_02 extends ApplicationKeywords {
	

	BaseClass obj;
	private Boolean status = false;
	ReportPage reportPage;
	
	public SR_UW_02(BaseClass obj) {
		super(obj);
		this.obj = obj;
	}
	
	
	public void sR_UW_02() {
		
		String reportLink=retrieve("Report Link");
		String reportPageTitle=retrieve("Report Page Title");
		String userLocationLabel=retrieve("User Location Label");
		String originatingLocationHeaderLabel=retrieve("Originating Location Header Label");
		String runReportButton=retrieve("Run Report Button");

		reportPage = new ReportPage(obj);
		reportPage.clickReportTab(true);
		reportPage.clickReportLink(reportLink);
		reportPage.clickDropDown(userLocationLabel);
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

