package scenarios.UserReports.CLD;

import baseClass.BaseClass;
import iSAFE.ApplicationKeywords;
import pages.ReportPage;

public class UR_CLD_21 extends ApplicationKeywords {

	BaseClass obj;
	private Boolean status = false;
	ReportPage reportPage;
	
	public UR_CLD_21(BaseClass obj) {
		super(obj);
		this.obj = obj;
	}
	
	public void uR_CLD_21() {

		String reportLink = retrieve("Report Link");
		String runReportButton = retrieve("Run Report Button");
		String reportPageTitle = retrieve("Report Page Title");

		reportPage = new ReportPage(obj);
		reportPage.clickReportTab(true);
		//String TCName=new Object() {}.getClass().getEnclosingMethod().getName();
		//System.out.println(TCName);
		reportPage.clickReportLink(reportLink);
		reportPage.clickRadioButton("Pick Columns","Default");// to run with My report options
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
