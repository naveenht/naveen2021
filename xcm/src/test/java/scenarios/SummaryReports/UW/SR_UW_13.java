package scenarios.SummaryReports.UW;

import baseClass.BaseClass;
import iSAFE.ApplicationKeywords;
import pages.ReportPage;

public class SR_UW_13 extends ApplicationKeywords {
	
	BaseClass obj;
	private Boolean status = false;
	ReportPage reportPage;
	
	public SR_UW_13(BaseClass obj) 
	{
		super(obj);
		this.obj = obj;
	}
	
	public void sR_UW_13() {
		
	
		String reportLink=retrieve("Report Link");
		String runReportButton=retrieve("Run Report Button");		
		String reportPageTitle=retrieve("Report Page Title");		
		
		String typeOfTaskLabel=retrieve("Type Of Task Label");
		String typeOfTaskValue=retrieve("Type Of Task Value");
		
		String typeOfTaskValue1=retrieve("Type Of Task Value1");		
		
		String typeOfTaskHeaderLabel = retrieve("TypeOfTaskHeaderLabel");
		
		String radioButtonLabel1 = retrieve("Radio Button Label1");
		String radioButtonLabel1Value1 = retrieve("Radio Button Label1 Value1");
		String radioButtonLabel1Value2 = retrieve("Radio Button Label1 Value2");
		String selectCategorylabel=retrieve("Select Category label");
		String systemWideCategorytypeValue=retrieve("System Wide Categorytype");
		String myReportsCategorytypeValue=retrieve("My Reports Categorytype");
		
		reportPage = new ReportPage(obj);

		

		reportPage.clickReportTab(true);
		reportPage.clickReportLink(reportLink);

		reportPage.clickRadioButton(radioButtonLabel1, radioButtonLabel1Value1);
		reportPage.selectDropDownValue(selectCategorylabel,systemWideCategorytypeValue);
		reportPage.clickDropDown(typeOfTaskLabel);
		reportPage.selectDropDownPopupValue(typeOfTaskHeaderLabel, typeOfTaskValue);
		reportPage.clickDropDownClose();
		reportPage.verifySelectedDropDownValue(typeOfTaskValue);
		reportPage.verifyButton(runReportButton, true);
		obj.transferControlToWindow(2);
		obj.validateReportPageTitle(reportPageTitle);
		obj.transferControlToWindow(1);

		reportPage.clickRadioButton(radioButtonLabel1, radioButtonLabel1Value2);
		reportPage.selectDropDownValue(selectCategorylabel, myReportsCategorytypeValue);
		reportPage.clickDropDown(typeOfTaskLabel);
		reportPage.selectDropDownPopupValue(typeOfTaskHeaderLabel, typeOfTaskValue1);
		reportPage.clickDropDownClose();
		reportPage.verifySelectedDropDownValue(typeOfTaskValue1);
		reportPage.verifyButton(runReportButton, true);
		obj.transferControlToWindow(2);
		obj.validateReportPageTitle(reportPageTitle);
		obj.transferControlToWindow(1);
		
		reportPage.clickRadioButton(radioButtonLabel1, radioButtonLabel1Value2);
		reportPage.selectDropDownValue(selectCategorylabel, myReportsCategorytypeValue);
		reportPage.clickDropDown(typeOfTaskLabel);
		reportPage.selectDropDownPopupValue(typeOfTaskHeaderLabel, typeOfTaskValue1);
		reportPage.clickDropDownClose();
		reportPage.verifySelectedDropDownValue(typeOfTaskValue1);
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

