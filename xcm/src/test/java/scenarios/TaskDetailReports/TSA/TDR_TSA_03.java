package scenarios.TaskDetailReports.TSA;

import baseClass.BaseClass;
import iSAFE.ApplicationKeywords;
import pages.ReportPage;

public class TDR_TSA_03 extends ApplicationKeywords {
	  
			BaseClass obj;
			private Boolean status = false;
			ReportPage reportPage;
			
			public TDR_TSA_03(BaseClass obj) {
				super(obj);
				this.obj = obj;
			}
			
			public void tDR_TSA_03() {
				
					
		String reportLink=retrieve("Report Link");
	    String runReportButton=retrieve("Run Report Button");
		String reportPageTitle=retrieve("Report Page Title");
		String fiscalYearLabel=retrieve("Fiscal Year Label");
		String fiscalYearValue=retrieve("Fiscal Year Value");
		String typeOfTaskLabel=retrieve("Type Of Task Label");
		String typeOfTaskValue=retrieve("Type Of Task Value");
		String typeOfTaskHeaderLabel=retrieve("Type Of Task Header Label");
		String originatingLocationHeaderLabel= retrieve("Originating Location Header Label");
		
		
		reportPage = new ReportPage(obj);
		
		reportPage.clickReportTab(true);
	    reportPage.clickReportLink(reportLink);
	    
	    reportPage.clickOriginatingLocationDropDown();
		reportPage.selectDropDownPopupFirstValue(originatingLocationHeaderLabel);
		reportPage.clickDropDownClose();
		reportPage.selectDropDownValue(fiscalYearLabel, fiscalYearValue);
		reportPage.clickDropDown(typeOfTaskLabel);
		reportPage.selectDropDownPopupValue(typeOfTaskHeaderLabel, typeOfTaskValue);
		reportPage.clickDropDownClose();
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