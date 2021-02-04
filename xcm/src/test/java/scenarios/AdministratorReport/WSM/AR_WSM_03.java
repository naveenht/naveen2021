package scenarios.AdministratorReport.WSM;

import baseClass.BaseClass;
import iSAFE.ApplicationKeywords;
import pages.ReportPage;

public class AR_WSM_03 extends ApplicationKeywords {

	BaseClass obj;
	private Boolean status = false;
	ReportPage reportpage;

	public AR_WSM_03(BaseClass obj) {
		super(obj);
		this.obj = obj;
	}

	public void aR_WSM_03() {

		String reportLink = retrieve("Report Link");
		String runReportButton = retrieve("Run Report Button");
		String reportPageTitle = retrieve("Report Page Title");
		String typeOfTaskLabel = retrieve("Type Of Task Label");
		String typeOfTaskValue = retrieve("Type Of Task Value");
		String typeOfTaskHeaderLabel = retrieve("Type Of Task Header Label");

		reportpage = new ReportPage(obj);

		reportpage.clickReportTab(true);
		reportpage.clickReportLink(reportLink);
		reportpage.clickDropDown(typeOfTaskLabel);
		reportpage.selectDropDownPopupValue(typeOfTaskHeaderLabel, typeOfTaskValue);
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
