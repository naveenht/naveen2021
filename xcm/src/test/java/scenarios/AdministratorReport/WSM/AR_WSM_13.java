package scenarios.AdministratorReport.WSM;

import baseClass.BaseClass;
import iSAFE.ApplicationKeywords;
import pages.ReportPage;

public class AR_WSM_13 extends ApplicationKeywords {

	BaseClass obj;
	private Boolean status = false;
	ReportPage reportpage;

	public AR_WSM_13(BaseClass obj) {
		super(obj);
		this.obj = obj;

	}

	public void aR_WSM_13() {

		String reportLink = retrieve("Report Link");
		String runReportButton = retrieve("Run Report Button");
		String reportPageTitle = retrieve("Report Page Title");

		String SelectCategorylabel = retrieve("Select Category label");
		String SelectCategoryvalue = retrieve("Select Category value");

		String SelectCategoryvalue1 = retrieve("Select Category value1");

		String typeOfTaskLabel = retrieve("Type Of Task Label");
		String typeOfTaskValue1 = retrieve("Type Of Task Value1");
		String typeOfTaskValue2 = retrieve("Type Of Task Value2");
		String typeOfTaskHeaderLabel = retrieve("Type Of Task Header Label");
		
		reportpage = new ReportPage(obj);
		
		
		reportpage.clickReportTab(true);
		reportpage.clickReportLink(reportLink);
		reportpage.selectDropDownValue(SelectCategorylabel, SelectCategoryvalue);
		reportpage.clickDropDown(typeOfTaskLabel);
		reportpage.selectDropDownPopupValue(typeOfTaskHeaderLabel, typeOfTaskValue1);
		reportpage.clickDropDownClose();
		reportpage.verifyButton(runReportButton, true);
		obj.transferControlToWindow(2);
		obj.validateReportPageTitle(reportPageTitle);
		obj.transferControlToWindow(1);
		
		reportpage.selectDropDownValue(SelectCategorylabel, SelectCategoryvalue1);
		reportpage.clickDropDown(typeOfTaskLabel);
		reportpage.selectDropDownPopupValue(typeOfTaskHeaderLabel, typeOfTaskValue2);
		reportpage.clickDropDownClose();
		reportpage.verifyButton(runReportButton, true);
		obj.transferControlToWindow(2);
		obj.validateReportPageTitle(reportPageTitle);
		obj.transferControlToWindow(1);

		if (obj.testFailure || reportpage.testFailure) {
			status = true;
		}
		this.testFailure = status;
	}

}
