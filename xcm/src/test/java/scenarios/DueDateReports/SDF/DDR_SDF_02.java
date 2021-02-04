package scenarios.DueDateReports.SDF;

import baseClass.BaseClass;
import iSAFE.ApplicationKeywords;

import pages.ReportPage;

public class DDR_SDF_02 extends ApplicationKeywords {
	

	BaseClass obj;
	private Boolean status = false;
	
	ReportPage reportPage;
	
	public DDR_SDF_02(BaseClass obj) {
		super(obj);
		this.obj = obj;
	}
	
	
	public void dDR_SDF_02() {

		String reportLink = retrieve("Report Link");
		String reportTitle=retrieve("ReportTitle");
		String fiscalYearlabel=retrieve("Fiscal Year Label");
		String fiscalYearValue=retrieve("Fiscal Year Value");
		String FiscalYearHeaderLabel=retrieve("Fiscal Year Header Label");
		String runReportButton=retrieve("Run Report Button");
		String originatingLocationLabel=retrieve("Originating Location Label");
		String originatingLocationHeaderLabel=retrieve("Originating Location Header Label");
		
		reportPage = new ReportPage(obj);
		
		reportPage.clickReportTab(true);
		
		
		reportPage.clickReportLink(reportLink);
		reportPage.clickDropDown(fiscalYearlabel);
		reportPage.selectDropDownPopupValue(FiscalYearHeaderLabel,fiscalYearValue);
		reportPage.clickDropDownClose();
		reportPage.verifySelectedDropDownValue(fiscalYearValue);
		reportPage.clickDropDown(originatingLocationLabel);
		reportPage.selectAllDropDownValues(originatingLocationHeaderLabel);
		reportPage.clickDropDownClose();
		reportPage.verifyButton(runReportButton, true);
		obj.transferControlToWindow(2);
		obj.validateReportPageTitle(reportTitle);
		obj.transferControlToWindow(1);
		
       
		if (obj.testFailure || reportPage.testFailure) {
			status = true;
		}
		this.testFailure = status;
	}
	
}
	


