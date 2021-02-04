package scenarios.TaskDetailReports.SBD;

import baseClass.BaseClass;
import iSAFE.ApplicationKeywords;
import pages.ReportPage;


public class TDR_SBD_03 extends ApplicationKeywords {
	
	BaseClass obj;
	private boolean status = false;
	ReportPage reportPage;

	public TDR_SBD_03(BaseClass obj){
		super(obj);
		this.obj=obj;
	}

	public void tDR_SBD_03(){


		String reportLink=retrieve("Report Link");
		String reportPageTitle=retrieve("Report Page Title");
		String runReportButton=retrieve("Run Report Button");	
		String originatingLocationLabel = retrieve("originatingLocationLabel");
		String fiscalYearLabel = retrieve("fiscalYearLabel");
		String fiscalYearValue = retrieve("fiscalYearValue");
		String fromDateLabel = retrieve("From Date Label");
		String fromDateValue = retrieve("From Date Value");
						
		reportPage=new ReportPage(obj);

		reportPage.clickReportTab(true);
		reportPage.clickReportLink(reportLink);
		reportPage.selectRoleNameDropDownValue(originatingLocationLabel);
		reportPage.selectDropDownValue(fiscalYearLabel, fiscalYearValue);
		reportPage.selectCalenderPopup(fromDateLabel);
		reportPage.selectDate(fromDateValue);
		reportPage.verifyButton(runReportButton, true);
		obj.transferControlToWindow(2);
		obj.validateReportPageTitle(reportPageTitle);
		obj.transferControlToWindow(1);

		if(reportPage.testFailure||obj.testFailure){
			status = true;
		}
		this.testFailure=status;

	}
}
