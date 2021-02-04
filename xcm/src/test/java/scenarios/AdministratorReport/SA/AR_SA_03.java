package scenarios.AdministratorReport.SA;

import baseClass.BaseClass;
import iSAFE.ApplicationKeywords;
import pages.ReportPage;

public class AR_SA_03 extends ApplicationKeywords {
	
	BaseClass obj;
	private Boolean status = false;
	ReportPage reportpage;
	
	public AR_SA_03(BaseClass obj) {
		super(obj);
		this.obj = obj;
	}
	
	public void aR_SA_03() {
		
		String reportLink=retrieve("Report Link");
		String runReportButton=retrieve("Run Report Button");
		String reportPageTitle=retrieve("Report Page Title");
		
		String originatingLocationLabel=retrieve("Originating Location Label");
		String primaryTaskTypeLabel=retrieve("Primary Task Type Label");
		String primaryTaskTypeValue=retrieve("Primary Task Type Value");
		
		reportpage = new ReportPage(obj);
		reportpage.clickReportTab(true);
		reportpage.clickReportLink(reportLink);
		
		reportpage.selectRoleNameDropDownValue(originatingLocationLabel);
		reportpage.selectDropDownValue(primaryTaskTypeLabel, primaryTaskTypeValue);
		reportpage.verifyButton(runReportButton, true);
		obj.transferControlToWindow(2);
		obj.validateReportPageTitle(reportPageTitle);
		obj.transferControlToWindow(1);
		
		
		if (obj.testFailure || reportpage.testFailure) {
			status = true;
		}
		this.testFailure = status;
	}
	




	
	

}
