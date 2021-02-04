package scenarios.DueDateReports.SUM;

import baseClass.BaseClass;
import iSAFE.ApplicationKeywords;
import pages.Login_Logout;
import pages.ReportPage;

public class DDR_SUM_05 extends ApplicationKeywords {

	BaseClass obj;
	private Boolean status = false;
	Login_Logout loginLogout;
	ReportPage reportPage;

	public DDR_SUM_05(BaseClass obj) {
		super(obj);
		this.obj = obj;
	}

	public void dDR_SUM_05() {

		reportPage = new ReportPage(obj);

		String reportLink=retrieve("Report Link");
		String SaveReoprtButton = retrieve("Save Reoprt Button");
		String CustomReportSaveButton = retrieve("Custom Report Save Button");
		String FiscalYearHeaderLabel=retrieve("Fiscal Year Header Label");
		String tableName = retrieve("tableName");
		String fiscalYearLabelName = retrieve("fiscalYearLabelName");
		String fiscalYearDrpValue = retrieve("fiscalYearDrpValue");
		String originatingLocLabelName = retrieve("originatingLocLabelName");
		String originatingLocHeaderLabel = retrieve("originatingLocHeaderLabel");
		String radioButtonLabel = retrieve("radioButtonLabel");
		String radioButtonValue = retrieve("radioButtonValue");
		String reportTitlelabel = retrieve("reportTitlelabel");
		String reportitleValue = retrieve("reportitleValue");
		String reportDescriptionlabel = retrieve("reportDescriptionlabel");
		String reportDescriptionValue = retrieve("reportDescriptionValue");

		reportPage.clickReportTab(true);
		reportPage.clickReportLink(reportLink);

		reportPage.clickDropDown(fiscalYearLabelName);
		reportPage.selectDropDownPopupValue(FiscalYearHeaderLabel, fiscalYearDrpValue);
		reportPage.clickDropDownClose();
		reportPage.verifySelectedDropDownValue(fiscalYearDrpValue);
		
		reportPage.clickDropDown(originatingLocLabelName);
		reportPage.selectDropDownPopupFirstValue(originatingLocHeaderLabel);
		reportPage.clickDropDownClose();
		
		reportPage.clickRadioButton(radioButtonLabel, radioButtonValue);
		reportPage.verifyButton(SaveReoprtButton, true);
		
		String reportTitle = reportPage.enterTextInSaveCustomReportPopup(reportTitlelabel, reportitleValue);
		reportPage.enterTextInSaveCustomReportPopup(reportDescriptionlabel, reportDescriptionValue);
		reportPage.verifySaveCustomReportPopupButtons(CustomReportSaveButton);
		
		int columnPosition = reportPage.getSystemWideCustomReportsHeaderPosition(tableName, reportTitlelabel);
		reportPage.getRowPositionValue(tableName, columnPosition, reportTitle);

		if (reportPage.testFailure || reportPage.testFailure) {
			status = true;
		}
		this.testFailure = status;

	}

}
