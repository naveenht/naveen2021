package scenarios.TaskDetailReports.TTC;

import baseClass.BaseClass;
import iSAFE.ApplicationKeywords;
import pages.ReportPage;


public class TDR_TTC_13 extends ApplicationKeywords{
	
	BaseClass obj;
	private Boolean status = false;
	ReportPage reportPage;
	
	
	
	public TDR_TTC_13(BaseClass obj) {
		super(obj);
		this.obj = obj;
		
	}
	
	public void tDR_TTC_13() {
	
	String reportLink=retrieve("Report Link");
	String runReportButton=retrieve("Run Report Button");
	String reportPageTitle=retrieve("Report Page Title");
	
	String fiscalYearLabel=retrieve("Fiscal Year Label");
	String fiscalYearValue=retrieve("Fiscal Year Value");
	String fiscalYearValue1=retrieve("Fiscal Year Value1");
	
	
	String typeOfTaskLabel=retrieve("Type Of Task Label");
	String typeOfTaskValue=retrieve("Type Of Task Value");
	String typeOfTaskValue1=retrieve("Type Of Task Value1");
	
	String CompletedToDatelabel=retrieve("Completed To Date label");
	
	String CompletedToDateValue=retrieve("Completed To Date Value");
	
	String originatingLocationLabel = retrieve("Originating Location Label");
	
	String radioButtonLabel1 = retrieve("Radio Button Label1");
	String radioButtonLabel1Value1 = retrieve("Radio Button Label1 Value1");
	String radioButtonLabel1Value2 = retrieve("Radio Button Label1 Value2");
	
	reportPage = new ReportPage(obj);
	
	reportPage.clickReportTab(true);
	reportPage.clickReportLink(reportLink);
	
	reportPage.clickRadioButton(radioButtonLabel1, radioButtonLabel1Value1);
	reportPage.validateFiscalYearDropDown(fiscalYearLabel);
	reportPage.selectDropDownValue(fiscalYearLabel ,fiscalYearValue);
	reportPage.selectDropDownValue(typeOfTaskLabel, typeOfTaskValue);
	reportPage.selectRoleNameDropDownValue(originatingLocationLabel);
	reportPage.selectCalenderPopup(CompletedToDatelabel);
	reportPage.selectDate(CompletedToDateValue);
	reportPage.verifyButton(runReportButton, true);
	obj.transferControlToWindow(2);
	obj.validateReportPageTitle(reportPageTitle);
	obj.transferControlToWindow(1);
	
	reportPage.clickRadioButton(radioButtonLabel1, radioButtonLabel1Value2);
	reportPage.validateFiscalYearDropDown(fiscalYearLabel);
	reportPage.selectDropDownValue(fiscalYearLabel ,fiscalYearValue1);
	reportPage.selectDropDownValue(typeOfTaskLabel, typeOfTaskValue1);
	reportPage.selectRoleNameDropDownValue(originatingLocationLabel);
	reportPage.verifyButton(runReportButton, true);
	obj.transferControlToWindow(2);
	obj.validateReportPageTitle(reportPageTitle);
	obj.transferControlToWindow(1);
	
	
	reportPage.clickRadioButton(radioButtonLabel1, radioButtonLabel1Value2);
	reportPage.validateFiscalYearDropDown(fiscalYearLabel);
	reportPage.selectDropDownValue(fiscalYearLabel ,fiscalYearValue1);
	reportPage.selectDropDownValue(typeOfTaskLabel, typeOfTaskValue1);
	reportPage.selectRoleNameDropDownValue(originatingLocationLabel);
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

