package scenarios.UserReports.CLS;

import baseClass.BaseClass;
import iSAFE.ApplicationKeywords;

import pages.ReportPage;

public class UR_CLS_04 extends ApplicationKeywords {

	BaseClass obj;
	private Boolean status = false;

	ReportPage reportPage;

	public UR_CLS_04(BaseClass obj) {
		super(obj);
		this.obj = obj;
	}

	public void uR_CLS_04() {

		String reportLink = retrieve("Report Link");
		String typeOfTaskLabel = retrieve("Type Of Task Label");
		String typeOfTaskValue = retrieve("Type Of Task Value");
		String fiscalYearLabel = retrieve("Fiscal Year Label");
		String fiscalYearValue = retrieve("Fiscal Year Value");
		String customerreport = retrieve("CustomerReport");
		String reporttype = retrieve("Reporttype");
		String reportTitle = retrieve("ReportTitle");
		String titleText = retrieve("TitleText");
		String reportDescription = retrieve("ReportDescription");
		String reportDescriptionValue = retrieve("ReportDescriptionValue");
		String saveReportButton = retrieve("Save Reoprt Button");
		String customReportSaveButton = retrieve("Custom Report Save Button");

		reportPage = new ReportPage(obj);

		reportPage.clickReportTab(true);
		reportPage.clickReportLink(reportLink);
		reportPage.selectDropDownValue(fiscalYearLabel, fiscalYearValue);
		reportPage.selectDropDownValue(typeOfTaskLabel, typeOfTaskValue);
		reportPage.clickRadioButton(customerreport, reporttype);
		reportPage.verifyButton(saveReportButton, true);
		String reportTitle1=reportPage.enterTextInSaveCustomReportPopup(reportTitle, titleText);
		reportPage.enterTextInSaveCustomReportPopup(reportDescription, reportDescriptionValue);
		reportPage.verifySaveCustomReportPopupButtons(customReportSaveButton);
		int colposition = reportPage.getSystemWideCustomReportsHeaderPosition(reporttype, reportTitle);
		reportPage.getRowPositionValue(reporttype, colposition, reportTitle1);

		if (obj.testFailure || reportPage.testFailure) {
			status = true;
		}
		this.testFailure = status;
	}

}
