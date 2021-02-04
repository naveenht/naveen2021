package scenarios.AdministratorReport.RT;

import baseClass.BaseClass;
import iSAFE.ApplicationKeywords;
import pages.ReportPage;

public class AR_RT_05 extends ApplicationKeywords {

	BaseClass obj;
	private Boolean status = false;
	ReportPage reportPage;

	public AR_RT_05(BaseClass obj) {
		super(obj);
		this.obj = obj;
	}

	public void aR_RT_05() {

		String reportLink = retrieve("Report Link");

		String radioButtonLabel = retrieve("Radio Button Label");
		String radioButtonValue = retrieve("Radio Button Value");
		String saveReportButton = retrieve("Save Reoprt Button");
		String reportTitleLabel = retrieve("Report Title Label");
		String reportTitleValue = retrieve("Report Title Value");
		String reportDescriptionLabel = retrieve("Report Description Label");
		String reportDescriptionValue = retrieve("Report Description Value");
		String customReportSaveButton = retrieve("Custom Report Save Button");
		String tableName = retrieve("Table Name");
		String tableColumnHeader = retrieve("Table Column Header");

		String groupNameLabel = retrieve("Group Name Label");
		//String groupNameValue = retrieve("Group Name Value");

		String typeOfTaskLabel = retrieve("Type Of Task Label");
		String typeOfTaskValue = retrieve("Type Of Task Value");

		//String groupNumbervlaue = retrieve("Group  Number Value");
		String groupNumberLable = retrieve("Group Number Lable");

		reportPage = new ReportPage(obj);

		reportPage.clickReportTab(true);
		reportPage.clickReportLink(reportLink);
		//reportPage.selectRoleNameDropDownValue(groupNameLabel);
		reportPage.clickRoleNameDropDown(groupNameLabel);
		reportPage.selectDropDownValue(typeOfTaskLabel, typeOfTaskValue);
		//reportPage.selectRoleNameDropDownValue(groupNumberLable);
		reportPage.clickRoleNameDropDown(groupNumberLable);
		
		reportPage.clickRadioButton(radioButtonLabel, radioButtonValue);
		reportPage.verifyButton(saveReportButton, true);
		String reportTitle=reportPage.enterTextInSaveCustomReportPopup(reportTitleLabel, reportTitleValue);
		reportPage.enterTextInSaveCustomReportPopup(reportDescriptionLabel, reportDescriptionValue);
		reportPage.verifySaveCustomReportPopupButtons(customReportSaveButton);
		int columnPosition = reportPage.getSystemWideCustomReportsHeaderPosition(tableName, tableColumnHeader);
		reportPage.getRowPositionValue(tableName, columnPosition, reportTitle);

		if (obj.testFailure || reportPage.testFailure) {
			status = true;
		}
		this.testFailure = status;
	}

}
