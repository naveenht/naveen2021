package scenarios.DueDateReports.BD;

import baseClass.BaseClass;
import iSAFE.ApplicationKeywords;
import pages.ReportPage;

public class DDR_BD_02 extends ApplicationKeywords
{
	BaseClass obj;
	private Boolean status = false;
	ReportPage reportPage;
	
public DDR_BD_02(BaseClass obj){
	super(obj);
	this.obj=obj;
}

public void dDR_BD_02() {
	
	
	String reportLink=retrieve("Report Link");
	String buttonName=retrieve("Run Report Button");
	String expectedTitle=retrieve("Report Page Title");
	String FiscalYearLabel=retrieve("Fiscal Year Label");
	String FiscalYearHeaderLabel=retrieve("Fiscal Year Header Label");
	String FiscalYearValue=retrieve("Fiscal Year Value");
	String originatingLocationLabel=retrieve("Originating Location Label");
	String originatingLocationHeaderLabel=retrieve("Originating Location Header Label");
	
	reportPage = new ReportPage(obj);
	
	reportPage.clickReportTab(true);
	reportPage.clickReportLink(reportLink);
	reportPage.clickDropDown(FiscalYearLabel);
	reportPage.selectDropDownPopupValue(FiscalYearHeaderLabel,FiscalYearValue);
	reportPage.clickDropDownClose();
	reportPage.verifySelectedDropDownValue(FiscalYearValue);
	reportPage.clickDropDown(originatingLocationLabel);
	reportPage.selectAllDropDownValues(originatingLocationHeaderLabel);
	reportPage.clickDropDownClose();
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
