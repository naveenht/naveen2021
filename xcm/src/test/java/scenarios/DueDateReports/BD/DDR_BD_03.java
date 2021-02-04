package scenarios.DueDateReports.BD;

import baseClass.BaseClass;
import iSAFE.ApplicationKeywords;
import pages.ReportPage;

public class DDR_BD_03 extends ApplicationKeywords

{
	BaseClass obj;
	private Boolean status = false;
	ReportPage reportPage;

	public DDR_BD_03(BaseClass obj) {
		super(obj);
		this.obj = obj;
	}

	public void dDR_BD_03() {

		String reportLink = retrieve("Report Link");
		String runReportButton = retrieve("Run Report Button");
		String reportPageTitle = retrieve("Report Page Title");
		String fiscalYearLabel = retrieve("Fiscal Year Label");
		String fiscalYearValue = retrieve("Fiscal Year Value");
		String typeOfTaskLabel = retrieve("Type Of Task Label");
		String typeOfTaskValue = retrieve("Type Of Task Value");
		String FiscalYearHeaderLabel=retrieve("Fiscal Year Header Label");
		String headertypeOfTask = retrieve("Extended Tasks Selection");
		String originatingLocationLabel = retrieve("Originating Location Label");
		String originatingLocationHeaderLabel = retrieve("Originating Location Header Label");
		String currentLocationLabel = retrieve("Current Location Label");
		String currentLocationHeaderLabel = retrieve("Current Location Header Label");

		reportPage = new ReportPage(obj);

		reportPage.clickReportTab(true);
		reportPage.clickReportLink(reportLink);
		reportPage.clickDropDown(fiscalYearLabel);
		reportPage.selectDropDownPopupValue(FiscalYearHeaderLabel, fiscalYearValue);
		reportPage.clickDropDownClose();
		reportPage.verifySelectedDropDownValue(fiscalYearValue);
		reportPage.clickDropDown(typeOfTaskLabel);
		reportPage.selectDropDownPopupValue(headertypeOfTask, typeOfTaskValue);
		reportPage.clickDropDownClose();
		reportPage.verifySelectedDropDownValue(typeOfTaskValue);
		reportPage.clickDropDown(originatingLocationLabel);
		reportPage.selectDropDownPopupFirstValue(originatingLocationHeaderLabel);
		reportPage.clickDropDownClose();
		reportPage.clickDropDown(currentLocationLabel);
		reportPage.selectDropDownPopupFirstValue(currentLocationHeaderLabel);
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
