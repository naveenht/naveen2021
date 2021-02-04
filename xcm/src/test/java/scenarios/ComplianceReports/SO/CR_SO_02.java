package scenarios.ComplianceReports.SO;

import baseClass.BaseClass;
import iSAFE.ApplicationKeywords;
import pages.ReportPage;

public class CR_SO_02 extends ApplicationKeywords
{
	BaseClass obj;
	private Boolean status = false;
	ReportPage reportPage;
	
public CR_SO_02(BaseClass obj){
	super(obj);
	this.obj=obj;
}

public void cR_SO_02() {
	
	
	String reportLink=retrieve("Report Link");
	String buttonName=retrieve("Run Report Button");
	String expectedTitle=retrieve("Report Page Title");
	String typeOfTaskLabel=retrieve("Type Of Task Label");
	String typeOfTaskValue=retrieve("Type Of Task Value");
	String TypeOfTaskHeaderLabel=retrieve("Type Of Task Header Label");
	String selectCatagoryLabel=retrieve("Select Catagory Label");
	String selectCatagoryValue=retrieve("Select Catagory Value");
	String FiscalYearLabel=retrieve("Fiscal Year Label");
	String FiscalYearValue=retrieve("Fiscal Year Value");
	
	
	reportPage = new ReportPage(obj);
	
	reportPage.clickReportTab(true);
	reportPage.clickReportLink(reportLink);
	reportPage.clickDropDown(typeOfTaskLabel);
	reportPage.selectDropDownPopupValue(TypeOfTaskHeaderLabel, typeOfTaskValue);
	reportPage.clickDropDownClose();
	reportPage.verifySelectedDropDownValue(typeOfTaskValue);
	reportPage.selectDropDownValue(selectCatagoryLabel,selectCatagoryValue);
	reportPage.selectDropDownValue(FiscalYearLabel,FiscalYearValue);
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
