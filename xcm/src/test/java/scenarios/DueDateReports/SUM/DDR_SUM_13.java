package scenarios.DueDateReports.SUM;

import baseClass.BaseClass;
import iSAFE.ApplicationKeywords;
import pages.ReportPage;

public class DDR_SUM_13 extends ApplicationKeywords {

	BaseClass obj;
	private Boolean status = false;
	ReportPage reportPage;

	public DDR_SUM_13(BaseClass obj) {
		super(obj);
		this.obj = obj;
	}

	public void dDR_SUM_13() {

		String reportLink = retrieve("Report Link");
		String runReportButton = retrieve("Run Report Button");
		String reportPageTitle = retrieve("Report Page Title");

		String fiscalYearLabel = retrieve("Fiscal Year Label");
		String fiscalYearValue = retrieve("Fiscal Year Value");
		String typeOfTaskLabel = retrieve("Type Of Task Label");

		String typeOfTaskValue = retrieve("Type Of Task Value");
		String fiscalYearValue1 = retrieve("Fiscal Year Value1");
		String typeOfTaskValue1 = retrieve("Type Of Task Value1");
		String FiscalYearHeaderLabel=retrieve("Fiscal Year Header Label");
		String typeOfTaskHeaderLabel = retrieve("typeOfTaskHeaderLabel");

		String radioButtonLabel1 = retrieve("Radio Button Label1");
		String radioButtonLabel1Value1 = retrieve("Radio Button Label1 Value1");
		String radioButtonLabel1Value2 = retrieve("Radio Button Label1 Value2");

		reportPage = new ReportPage(obj);

		reportPage.clickReportTab(true);
		reportPage.clickReportLink(reportLink);

		reportPage.clickRadioButton(radioButtonLabel1, radioButtonLabel1Value1);
		reportPage.clickDropDown(fiscalYearLabel);
		reportPage.validateFiscalyearDropDownPopup(FiscalYearHeaderLabel);
		reportPage.selectDropDownPopupValue(FiscalYearHeaderLabel, fiscalYearValue);
		reportPage.clickDropDownClose();
		reportPage.verifySelectedDropDownValue(fiscalYearValue);
		reportPage.clickDropDown(typeOfTaskLabel);
		reportPage.selectDropDownPopupValue(typeOfTaskHeaderLabel, typeOfTaskValue);
		reportPage.clickDropDownClose();
		reportPage.verifySelectedDropDownValue(typeOfTaskValue);
		reportPage.verifyButton(runReportButton, true);
		obj.transferControlToWindow(2);
		obj.validateReportPageTitle(reportPageTitle);
		obj.transferControlToWindow(1);

		reportPage.clickRadioButton(radioButtonLabel1, radioButtonLabel1Value2);
		reportPage.clickDropDown(fiscalYearLabel);
		reportPage.validateFiscalyearDropDownPopup(FiscalYearHeaderLabel);
		reportPage.selectDropDownPopupValue(FiscalYearHeaderLabel, fiscalYearValue1);
		reportPage.clickDropDownClose();
		reportPage.verifySelectedDropDownValue(fiscalYearValue1);
		reportPage.clickDropDown(typeOfTaskLabel);
		reportPage.selectDropDownPopupValue(typeOfTaskHeaderLabel, typeOfTaskValue1);
		reportPage.clickDropDownClose();
		reportPage.verifySelectedDropDownValue(typeOfTaskValue1);
		reportPage.verifyButton(runReportButton, true);
		obj.transferControlToWindow(2);
		obj.validateReportPageTitle(reportPageTitle);
		obj.transferControlToWindow(1);

		reportPage.clickRadioButton(radioButtonLabel1, radioButtonLabel1Value2);
		reportPage.clickDropDown(fiscalYearLabel);
		reportPage.validateFiscalyearDropDownPopup(FiscalYearHeaderLabel);
		reportPage.selectDropDownPopupValue(FiscalYearHeaderLabel, fiscalYearValue1);
		reportPage.clickDropDownClose();
		reportPage.verifySelectedDropDownValue(fiscalYearValue1);
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
