package scenarios.AdministratorReport.RT;

import baseClass.BaseClass;
import iSAFE.ApplicationKeywords;
import pages.ReportPage;

public class AR_RT_13 extends ApplicationKeywords {

	BaseClass obj;
	private Boolean status = false;
	ReportPage reportPage;

	public AR_RT_13(BaseClass obj) {
		super(obj);
		this.obj = obj;
	}

	public void aR_RT_13() {

		String reportLink = retrieve("Report Link");
		String runReportButton = retrieve("Run Report Button");
		String reportPageTitle = retrieve("Report Page Title");

		String groupNameLabel = retrieve("Group Name Label");
		//String groupNameValue1 = retrieve("Group Name Value1");
		//String groupNameValue2 = retrieve("Group Name Value2");

		String typeOfTaskLabel = retrieve("Type Of Task Label");
		String typeOfTaskValue1 = retrieve("Type Of Task Value1");
		String typeOfTaskValue2 = retrieve("Type Of Task Value2");

		//String groupNumbervlaue1 = retrieve("Group  Number Value1");
		//String groupNumberValue2 = retrieve("Group Number Value2");
		String groupNumberLable = retrieve("Group Number Lable");

		reportPage = new ReportPage(obj);

		reportPage.clickReportTab(true);
		reportPage.clickReportLink(reportLink);

		//reportPage.selectRoleNameDropDownValue(groupNameLabel);
		reportPage.clickRoleNameDropDown(groupNameLabel);
		reportPage.selectDropDownValue(typeOfTaskLabel, typeOfTaskValue1);
		//reportPage.selectRoleNameDropDownValue(groupNumberLable);
		reportPage.clickRoleNameDropDown(groupNumberLable);
		
		reportPage.verifyButton(runReportButton, true);
		obj.transferControlToWindow(2);
		obj.validateReportPageTitle(reportPageTitle);
		obj.transferControlToWindow(1);

		reportPage.selectRoleNameDropDownValue(groupNameLabel);
		reportPage.selectDropDownValue(typeOfTaskLabel, typeOfTaskValue2);
		reportPage.selectRoleNameDropDownValue(groupNumberLable);
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
