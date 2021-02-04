package scenarios.UserReports.CLS;



import baseClass.BaseClass;
import iSAFE.ApplicationKeywords;

import pages.ReportPage;

public class UR_CLS_02 extends ApplicationKeywords {
	

	BaseClass obj;
	private Boolean status = false;
	
	ReportPage reportPage;
	
	public UR_CLS_02(BaseClass obj) {
		super(obj);
		this.obj = obj;
	}
	
	
	public void uR_CLS_02() {
		String reportName=retrieve("Report Link");
		String reportTitle=retrieve("Report Page Title");
		String originatingLocationLabel=retrieve("Originating Location Label");
		String originatingLocationHeaderLabel=retrieve("Originating Location Header Label");
		String typeOfTaskLabel=retrieve("Type Of Task Label");
		String typeOfTaskValue=retrieve("Type Of Task Value");
		String runReportButton=retrieve("Run Report Button");
		
		reportPage = new ReportPage(obj);
		
		reportPage.clickReportTab(true);
		reportPage.clickReportLink(reportName);
		reportPage.clickDropDown(originatingLocationLabel);
		reportPage.selectAllDropDownValues(originatingLocationHeaderLabel);
		reportPage.clickDropDownClose();
		reportPage.selectDropDownValue(typeOfTaskLabel,typeOfTaskValue);
		reportPage.verifyButton(runReportButton, true);
		obj.transferControlToWindow(2);
		obj.validateReportPageTitle(reportTitle);
		obj.transferControlToWindow(1);
		
		if (obj.testFailure || reportPage.testFailure) {
			status = true;
		}
		this.testFailure = status;
	}}
	


