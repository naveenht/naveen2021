package scenarios.DueDateReports.SUM;

import baseClass.BaseClass;
import iSAFE.ApplicationKeywords;
import pages.Login_Logout;
import pages.ReportPage;


public class DDR_SUM_02 extends ApplicationKeywords {

	BaseClass obj;
	private Boolean status = false;
	Login_Logout loginLogout;
	ReportPage reportPage;

	public DDR_SUM_02(BaseClass obj){
		super(obj);
		this.obj=obj;
	}

	public void dDR_SUM_02(){
		
		
		reportPage=new ReportPage(obj);

		
		String reportLink=retrieve("Report Link");
		String buttonName=retrieve("Run Report Button");
		String reportPageTitle = retrieve("Report Page Title"); //Due Date - Summary
		String fiscalYearLabel = retrieve("Fiscal Year Label");
		String fiscalYearValue = retrieve("Fiscal Year Value");
		String FiscalYearHeaderLabel=retrieve("Fiscal Year Header Label");
		String originatingLocationLabel=retrieve("Originating Location Label"); //Originating Location
		String originatingLocationHeaderLabel=retrieve("Originating Location Header Label"); //Extended Origination Loc Selection
						
		reportPage.clickReportTab(true);
		reportPage.clickReportLink(reportLink);		
		
		reportPage.clickDropDown(fiscalYearLabel);
		reportPage.selectDropDownPopupValue(FiscalYearHeaderLabel, fiscalYearValue);
		reportPage.clickDropDownClose();
		reportPage.verifySelectedDropDownValue(fiscalYearValue);
		
		
		reportPage.clickDropDown(originatingLocationLabel);
		reportPage.selectAllDropDownValues(originatingLocationHeaderLabel);
		reportPage.clickDropDownClose();
		
		reportPage.verifyButton(buttonName, true);
		
		obj.transferControlToWindow(2);
		obj.validateReportPageTitle(reportPageTitle);
		obj.transferControlToWindow(1);

		if(reportPage.testFailure||reportPage.testFailure||obj.testFailure){
			status = true;
		}
		this.testFailure=status;

	}
}
