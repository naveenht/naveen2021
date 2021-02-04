package scenarios.AdministratorReport.SA;

import baseClass.BaseClass;
import iSAFE.ApplicationKeywords;
import pages.ReportPage;

public class AR_SA_02 extends ApplicationKeywords {

	BaseClass obj;
	private Boolean status = false;
	ReportPage reportPage;
	
	public AR_SA_02(BaseClass obj) {
		super(obj);
		this.obj = obj;
	}
	
	public void aR_SA_02() {
		
		String reportLink=retrieve("Report Link");
		String runReportButton=retrieve("Run Report Button");
		String reportPageTitle=retrieve("Report Page Title");
		
		String originatingLocationLabel=retrieve("Originating Location Label");
		String originatingLocationValue=retrieve("Originating Location Value");
		
		reportPage = new ReportPage(obj);
		
		reportPage.clickReportTab(true);
		reportPage.clickReportLink(reportLink);
		reportPage.selectDropDownValue(originatingLocationLabel, originatingLocationValue);
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