package scenarios.DueDateReports.BDDS;

import baseClass.BaseClass;
import iSAFE.ApplicationKeywords;
import pages.ReportPage;

public class DDR_BDDS_22 extends ApplicationKeywords {

	BaseClass obj;
	ReportPage reportPage;
	
	public DDR_BDDS_22(BaseClass obj) {
		super(obj);
		this.obj = obj;
		
	}
	
	public void dDR_BDDS_22() {
		
		String reportLink=retrieve("Report Link");
		String runReportButton=retrieve("Run Report Button");
		String reportPageTitle=retrieve("Report Page Title");
		
		String selectCategorylabel=retrieve("Select Category label");
		String selectCategoryvalue=retrieve("Select Category value");
	/*	
		String fiscalYearLabel=retrieve("Fiscal Year Label");
		String fiscalYearValue=retrieve("Fiscal Year Value");
		String FiscalYearHeaderLabel=retrieve("Fiscal Year Header Label");
		String originatingLocationLabel=retrieve("Originating Location Label");
		String originatingLocationHeaderLabel=retrieve("Originating Location Header Label");
	*/	
		reportPage = new ReportPage(obj);
		
		reportPage.clickReportTab(true);
		reportPage.clickReportLink(reportLink);
		
	/*	
		reportPage.clickDropDown(fiscalYearLabel);
		reportPage.selectDropDownPopupValue(FiscalYearHeaderLabel ,fiscalYearValue);
		reportPage.clickDropDownClose();
		reportPage.clickDropDown(originatingLocationLabel);
		reportPage.selectAllDropDownValues(originatingLocationHeaderLabel);
		reportPage.clickDropDownClose();
		
		*/
		reportPage.selectDropDownValueCategory(selectCategorylabel, selectCategoryvalue);
		reportPage.verifyButton(runReportButton, true);
		obj.transferControlToWindow(2);
		obj.validateReportPageTitle(reportPageTitle);
		obj.transferControlToWindow(1);
		
	} 



}
