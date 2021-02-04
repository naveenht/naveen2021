package scenarios.AdministratorReport.SA;

import baseClass.BaseClass;
import iSAFE.ApplicationKeywords;
import pages.ReportPage;

public class AR_SA_13 extends ApplicationKeywords {

	BaseClass obj;
	private Boolean status = false;
	ReportPage reportpage;
	
	public AR_SA_13(BaseClass obj) {
		super(obj);
		this.obj = obj;
		
	}
	
	public void aR_SA_13() {
	
	String reportLink=retrieve("Report Link");
	String runReportButton=retrieve("Run Report Button");
	String reportPageTitle=retrieve("Report Page Title");
	
	String originatingLocationLabel=retrieve("Originating Location Label");
	String primaryTaskTypeLabel=retrieve("Primary Task Type Label");
	String primaryTaskTypeValue=retrieve("Primary Task Type Value");
	String primaryTaskTypeValue1=retrieve("Primary Task Type Value1");
	
	String responsibilityLabel=retrieve("Responsibility Label");
	String responsibilityLabelValue=retrieve("Responsibility Label Value");
	String responsibilityLabelValue1=retrieve("Responsibility Label Value1");
	
	
	reportpage = new ReportPage(obj);
	reportpage.clickReportTab(true);
	reportpage.clickReportLink(reportLink);
	
	reportpage.selectRoleNameDropDownValue(originatingLocationLabel);
	reportpage.selectDropDownValue(primaryTaskTypeLabel, primaryTaskTypeValue);
	reportpage.selectDropDownValue(responsibilityLabel, responsibilityLabelValue);
	reportpage.verifyButton(runReportButton, true);
	obj.transferControlToWindow(2);
	obj.validateReportPageTitle(reportPageTitle);
	obj.transferControlToWindow(1);
	
	reportpage.selectRoleNameDropDownValue(originatingLocationLabel);
	reportpage.selectDropDownValue(primaryTaskTypeLabel, primaryTaskTypeValue1);
	reportpage.selectDropDownValue(responsibilityLabel, responsibilityLabelValue1);
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
