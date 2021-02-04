package scenarios.AdministratorReport.CED;

import baseClass.BaseClass;
import iSAFE.ApplicationKeywords;
import pages.ReportPage;

public class AR_CED_13 extends ApplicationKeywords {

	BaseClass obj;
	private Boolean status = false;
	ReportPage reportpage;
	
	public AR_CED_13(BaseClass obj) {
		super(obj);
		this.obj = obj;
		
	}
	
	public void aR_CED_13() {
	
	String reportLink=retrieve("Report Link");
	String runReportButton=retrieve("Run Report Button");
	String reportPageTitle=retrieve("Report Page Title");
	
	String originatingLocationLabel=retrieve("Originating Location Label");
	
	String primaryTaskTypeLabel=retrieve("Primary Task Type Label");
	String primaryTaskTypeValue=retrieve("Primary Task Type Value");
	String primaryTaskTypeValue1=retrieve("Primary Task Type Value1");
	
	String clientEntityTypeLabel=retrieve("Client/Entity Type Label");
	String clientEntityTypeValue=retrieve("Client/Entity Type Value");
	String clientEntityTypeValue1=retrieve("Client/Entity Type Value1");
	
	
	reportpage = new ReportPage(obj);
	reportpage.clickReportTab(true);
	reportpage.clickReportLink(reportLink);
	
	
	reportpage.selectRoleNameDropDownValue(originatingLocationLabel);
	reportpage.selectDropDownValue(primaryTaskTypeLabel, primaryTaskTypeValue);
	reportpage.selectDropDownValue(clientEntityTypeLabel, clientEntityTypeValue);
	reportpage.verifyButton(runReportButton, true);
	obj.transferControlToWindow(2);
	obj.validateReportPageTitle(reportPageTitle);
	obj.transferControlToWindow(1);
	
	
	reportpage.selectRoleNameDropDownValue(originatingLocationLabel);
	reportpage.selectDropDownValue(primaryTaskTypeLabel, primaryTaskTypeValue1);
	reportpage.selectDropDownValue(clientEntityTypeLabel, clientEntityTypeValue1);
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
