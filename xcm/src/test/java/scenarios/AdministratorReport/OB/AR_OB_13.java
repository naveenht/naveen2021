package scenarios.AdministratorReport.OB;

import baseClass.BaseClass;
import iSAFE.ApplicationKeywords;
import pages.ReportPage;

public class AR_OB_13 extends ApplicationKeywords {
	
	BaseClass obj;
	private Boolean status = false;
	ReportPage reportPage;
	
	public AR_OB_13(BaseClass obj) {
		super(obj);
		this.obj = obj;
		
	}
	
	public void aR_OB_13() {
	
	String reportLink=retrieve("Report Link");
	String runReportButton=retrieve("Run Report Button");
	String reportPageTitle=retrieve("Report Page Title");
	
	String locationLabel=retrieve("Location Label");
	String fromDateLabel=retrieve("From Date Label");
	String fromDateValue=retrieve("From Date Value");
	
	String toDateLabel=retrieve("To Date Label");
	String toDateValue=retrieve("To Date Value");
	
	reportPage = new ReportPage(obj);
	reportPage.clickReportTab(true);
	reportPage.clickReportLink(reportLink);
	
	reportPage.selectRoleNameDropDownValue(locationLabel);
	reportPage.selectCalenderPopup(fromDateLabel);
	reportPage.selectDate(fromDateValue);
	reportPage.selectCalenderPopup(toDateLabel);
	reportPage.selectDate(toDateValue);
	reportPage.verifyButton(runReportButton, true);
	obj.transferControlToWindow(2);
	obj.validateReportPageTitle(reportPageTitle);
	obj.transferControlToWindow(1);
	
	
	
	reportPage.selectRoleNameDropDownValue(locationLabel);
	reportPage.selectCalenderPopup(fromDateLabel);
	reportPage.selectDate(fromDateValue);
	reportPage.selectCalenderPopup(toDateLabel);
	reportPage.selectDate(toDateValue);
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
