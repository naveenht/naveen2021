package scenarios.ComplianceReports.SOD;

import baseClass.BaseClass;
import iSAFE.ApplicationKeywords;
import pages.ReportPage;

public class CR_SOD_02 extends ApplicationKeywords
{
	BaseClass obj;
	private Boolean status = false;
	ReportPage reportPage;
	
public CR_SOD_02(BaseClass obj){
	super(obj);
	this.obj=obj;
}

public void cR_SOD_02() {
	
	
	String reportLink=retrieve("Report Link");
	String buttonName=retrieve("Run Report Button");
	String expectedTitle=retrieve("Report Page Title");
	String labelName=retrieve("Type Of Task Label");
	String drpValue=retrieve("Type Of Task Value");
	String HeaderLabelValue=retrieve("Type Of Task Header Label");
	String selectCatagoryLabel=retrieve("Select Catagory Label");
	String selectCatagoryValue=retrieve("Select Catagory Value");
	String FiscalYearLabel=retrieve("Fiscal Year Label");
	String FiscalYearValue=retrieve("Fiscal Year Value");
	
	reportPage = new ReportPage(obj);
	
	reportPage.clickReportTab(true);
	reportPage.clickReportLink(reportLink);
	reportPage.clickDropDown(labelName);
	reportPage.selectDropDownPopupValue(HeaderLabelValue, drpValue);
	reportPage.clickDropDownClose();
	reportPage.verifySelectedDropDownValue(drpValue);
	reportPage.verifyButton(buttonName, true);
	reportPage.selectDropDownValue(selectCatagoryLabel,selectCatagoryValue);
	reportPage.selectDropDownValue(FiscalYearLabel,FiscalYearValue);
	obj.transferControlToWindow(2);
	obj.validateReportPageTitle(expectedTitle);
	obj.transferControlToWindow(1);
	
	
	if (obj.testFailure || reportPage.testFailure) {
		status = true;
	}
	this.testFailure = status;
}

}
