package scenarios.AdministratorReport.CED;

import baseClass.BaseClass;
import iSAFE.ApplicationKeywords;

import pages.ReportPage;

public class AR_CED_03 extends ApplicationKeywords {

	BaseClass obj;
	private Boolean status = false;

	ReportPage reportPage;

	public AR_CED_03(BaseClass obj) {
		super(obj);
		this.obj = obj;
	}

	public void aR_CED_03() {
		
		String reportLink=retrieve("Report Link");
		String runReportButton=retrieve("Run Report Button");
		String reportPageTitle=retrieve("Report Page Title");
		
		String originatingLocationLabel=retrieve("Originating Location Label");
		String primaryTaskTypeLabel=retrieve("Primary Task Type Label");
		String primaryTaskTypeValue=retrieve("Primary Task Type Value");
		
		reportPage = new ReportPage(obj);
		reportPage.clickReportTab(true);
		reportPage.clickReportLink(reportLink);
		reportPage.selectDropDownPopupFirstValue(originatingLocationLabel);
		reportPage.selectDropDownValue(primaryTaskTypeLabel, primaryTaskTypeValue);
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
