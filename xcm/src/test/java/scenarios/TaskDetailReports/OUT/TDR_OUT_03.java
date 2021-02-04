package scenarios.TaskDetailReports.OUT;

import baseClass.BaseClass;
import iSAFE.ApplicationKeywords;
import pages.ReportPage;


public class TDR_OUT_03 extends ApplicationKeywords{
	
	BaseClass obj;
	private boolean status=false;
	ReportPage reportPage;
	
	public TDR_OUT_03(BaseClass obj){
		super(obj);
		this.obj=obj;
		
	}
	
	public void tDR_OUT_03(){
		
		String reportLink=retrieve("Report Link");
		String runReportButton=retrieve("Run Report Button");
		String reportPageTitle=retrieve("Report Page Title");
		String fiscalYearLabel=retrieve("Fiscal Year Label");
		String fiscalYearValue=retrieve("Fiscal Year Value");
		String typeOfTaskLabel=retrieve("Type Of Task Label");
		String typeOfTaskValue=retrieve("Type Of Task Value");
		String originatingLocationLabel=retrieve("Originating Location Label");
		
	
		reportPage = new ReportPage(obj);

		
		reportPage.clickReportTab(true);
		reportPage.clickReportLink(reportLink);
		
		reportPage.selectDropDownValue(typeOfTaskLabel, typeOfTaskValue);
		
		reportPage.selectRoleNameDropDownValue(originatingLocationLabel);
		
		reportPage.selectDropDownValue(fiscalYearLabel, fiscalYearValue);
		
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
