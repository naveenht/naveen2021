package scenarios.Portal;


import baseClass.BaseClass;
import iSAFE.ApplicationKeywords;

import pages.ReportPage;

public class TDR_PORT_14 extends ApplicationKeywords {

	BaseClass obj;
	private Boolean status = false;

	ReportPage reportPage;

	public TDR_PORT_14(BaseClass obj) {
		super(obj);
		this.obj = obj;
	}

	public void tDR_PORT_14() {

		String reportLink = retrieve("Report Link");
		String reportTitle = retrieve("Report Page Title");
		String runreport = retrieve("Run Report Button");
		
		String fromDateLabel = retrieve("From Date Label");
		String fromDateValue = retrieve("From Date Value");
		String toDateLabel = retrieve("To Date Label");
		String toDateValue = retrieve("To Date Value");
		
		
		

		reportPage = new ReportPage(obj);

		reportPage.clickReportTab(true);
		reportPage.clickReportLink(reportLink);
		
		reportPage.selectCalenderPopup(fromDateLabel);
		reportPage.selectDate(fromDateValue);
		reportPage.selectCalenderPopup(toDateLabel);
		reportPage.selectDate(toDateValue);
		
		
		
		long startTime=reportPage.verifyButton(runreport, true);
		obj.transferControlToWindow(2);
		long endTime=obj.validateReportPageTitle(reportTitle);
		reportPage.calcualtedReportOpenedTime(startTime, endTime);
		obj.transferControlToWindow(1);
		
		if (obj.testFailure || reportPage.testFailure) {
			status = true;
		}
		this.testFailure = status;
	}

}
