package scenarios.UserReports.MCT;

import baseClass.BaseClass;
import iSAFE.ApplicationKeywords;
import pages.ReportPage;


public class UR_MCT_03 extends ApplicationKeywords {
	

	BaseClass obj;
	private Boolean status = false;
	ReportPage reportPage;
	
	public UR_MCT_03(BaseClass obj) {
		super(obj);
		this.obj = obj;
	}
	
	
	public void uR_MCT_03() {
		
	
		String reportLink=retrieve("Report Link");
		String runReportButton=retrieve("Run Report Button");
		String reportPageTitle=retrieve("Report Page Title");
		String originatingLocationLabel=retrieve("Originating Location Label");
		String primaryTaskTypeLabel=retrieve("Primary Task Type Label");
		String primaryTaskTypeValue=retrieve("Primary Task Type Value");
		
		reportPage = new ReportPage(obj);
		
		reportPage.clickReportTab(true);
		reportPage.clickReportLink(reportLink);
		
		reportPage.selectRoleNameDropDownValue(originatingLocationLabel);
		
		reportPage.selectDropDownValue(primaryTaskTypeLabel ,primaryTaskTypeValue);
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
