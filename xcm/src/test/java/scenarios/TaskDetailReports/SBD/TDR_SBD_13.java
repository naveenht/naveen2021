package scenarios.TaskDetailReports.SBD;

import baseClass.BaseClass;
import iSAFE.ApplicationKeywords;
import pages.ReportPage;

public class TDR_SBD_13 extends ApplicationKeywords{
	
	BaseClass obj;
	private Boolean status = false;
	ReportPage reportPage;
	
	public TDR_SBD_13(BaseClass obj) {
		super(obj);
		this.obj = obj;
	}
	
	public void tDR_SBD_13() {
		
	
		String reportLink=retrieve("Report Link");
		String runReportButton=retrieve("Run Report Button");
		String reportPageTitle=retrieve("Report Page Title");
		String fiscalYearLabel=retrieve("Fiscal Year Label");
		String fiscalYearValue=retrieve("Fiscal Year Value");
		String fiscalYearValue1=retrieve("Fiscal Year Value1");
		
		String originatingLocLabel=retrieve("Originating Location Label");
		
		String fromDateLabel = retrieve("From Date Label");
		String fromDateValue = retrieve("From Date Value");	
		
		String radioButtonLabel1 = retrieve("Radio Button Label1");
		String radioButtonLabel1Value1 = retrieve("Radio Button Label1 Value1");
		String radioButtonLabel1Value2 = retrieve("Radio Button Label1 Value2");
		
		reportPage = new ReportPage(obj);
		
		reportPage.clickReportTab(true);
		reportPage.clickReportLink(reportLink);
		
		reportPage.clickRadioButton(radioButtonLabel1, radioButtonLabel1Value1);
		reportPage.validateFiscalYearDropDown(fiscalYearLabel);
		reportPage.selectDropDownValue(fiscalYearLabel, fiscalYearValue);
		reportPage.selectRoleNameDropDownValue(originatingLocLabel);
		reportPage.selectCalenderPopup(fromDateLabel);
		reportPage.selectDate(fromDateValue);
		reportPage.verifyButton(runReportButton, true);
		obj.transferControlToWindow(2);
		obj.validateReportPageTitle(reportPageTitle);
		obj.transferControlToWindow(1);
		
		reportPage.clickRadioButton(radioButtonLabel1, radioButtonLabel1Value2);
		reportPage.validateFiscalYearDropDown(fiscalYearLabel);
		reportPage.selectDropDownValue(fiscalYearLabel, fiscalYearValue1);
		reportPage.selectRoleNameDropDownValue(originatingLocLabel);
		reportPage.verifyButton(runReportButton, true);
		obj.transferControlToWindow(2);
		obj.validateReportPageTitle(reportPageTitle);
		obj.transferControlToWindow(1);
		
		reportPage.clickRadioButton(radioButtonLabel1, radioButtonLabel1Value2);
		reportPage.validateFiscalYearDropDown(fiscalYearLabel);
		reportPage.selectDropDownValue(fiscalYearLabel, fiscalYearValue1);
		reportPage.selectRoleNameDropDownValue(originatingLocLabel);
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
