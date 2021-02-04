package scenarios.UserReports.CLD;

import baseClass.BaseClass;
import iSAFE.ApplicationKeywords;
import pages.ReportPage;

public class UR_CLD_03 extends ApplicationKeywords {
	

	BaseClass obj;
	private Boolean status = false;
	ReportPage reportPage;
	
	public UR_CLD_03(BaseClass obj) {
		super(obj);
		this.obj = obj;
	}
	
	
	public void uR_CLD_03() {
		
	
		String reportLink=retrieve("Report Link");
		String runReportButton=retrieve("Run Report Button");
		String reportPageTitle=retrieve("Report Page Title");
		String fiscalYearLabel=retrieve("Fiscal Year Label");
		String fiscalYearValue=retrieve("Fiscal Year Value");
		String typeOfTaskLabel=retrieve("Type Of Task Label");
		String typeOfTaskValue=retrieve("Type Of Task Value");
		String originatingLocationHeaderLabel= retrieve("Originating Location Header Label");
		String originatingLocationLabel=retrieve("Originating Location Label");
		
		reportPage = new ReportPage(obj);
		
		reportPage.clickReportTab(true);
		reportPage.clickReportLink(reportLink);
		reportPage.clickDropDown(originatingLocationLabel);
		reportPage.selectDropDownPopupFirstValue(originatingLocationHeaderLabel);
		reportPage.clickDropDownClose();
		reportPage.selectDropDownValue(fiscalYearLabel, fiscalYearValue);
		reportPage.selectDropDownValue(typeOfTaskLabel ,typeOfTaskValue);
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
