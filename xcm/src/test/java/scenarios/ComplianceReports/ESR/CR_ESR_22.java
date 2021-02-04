package scenarios.ComplianceReports.ESR;

import baseClass.BaseClass;
import iSAFE.ApplicationKeywords;
import pages.ReportPage;

public class CR_ESR_22 extends ApplicationKeywords
{
	BaseClass obj;
	private Boolean status = false;
	ReportPage reportPage;
	
public CR_ESR_22(BaseClass obj){
	super(obj);
	this.obj=obj;
}

public void cR_ESR_22() {
	
	
	String reportLink=retrieve("Report Link");
	String buttonName=retrieve("Run Report Button");
	String expectedTitle=retrieve("Report Page Title");
	String selectCategorylabel=retrieve("Select Category label");
	String selectCategoryvalue=retrieve("Select Category value");
	
	reportPage = new ReportPage(obj);
	
	reportPage.clickReportTab(true);
	reportPage.clickReportLink(reportLink);
	reportPage.selectDropDownValueCategory(selectCategorylabel, selectCategoryvalue);
	
	reportPage.verifyButton(buttonName, true);
	obj.transferControlToWindow(2);
	obj.validateReportPageTitle(expectedTitle);
	obj.transferControlToWindow(1);
	
	
	if (obj.testFailure || reportPage.testFailure) {
		status = true;
	}
	this.testFailure = status;
}

}
