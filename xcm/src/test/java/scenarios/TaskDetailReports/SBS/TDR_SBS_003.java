package scenarios.TaskDetailReports.SBS;

import baseClass.BaseClass;
import iSAFE.ApplicationKeywords;
import pages.ReportPage;

public class TDR_SBS_003 extends ApplicationKeywords {

	BaseClass obj;
	private Boolean status = false;
	ReportPage reportPage;

	public TDR_SBS_003(BaseClass obj) {
		super(obj);
		this.obj = obj;
	}

	public void tDR_SBS_003() {

		String reportLink=retrieve("Report Link");
		String reportPageTitle=retrieve("Report Page Title");
		String typeOfTaskLabel = retrieve("Type Of Task Label");
		String typeOfTaskValue = retrieve("Type Of Task Value");
		String typeOfTaskHeaderLabel = retrieve("Type Of Task Header Label");
		String selectcategory = retrieve("Typeofcategory");
		String categorytype = retrieve("Categorytype");
		String runReportButton = retrieve("Run Report Button");
		String originatingLocationLabel=retrieve("Originating Location Label");
		
		reportPage = new ReportPage(obj);
		reportPage.clickReportTab(true);
		reportPage.clickReportLink(reportLink);
		reportPage.selectRoleNameDropDownValue(originatingLocationLabel);
		reportPage.selectDropDownValue(selectcategory, categorytype);
		reportPage.clickDropDown(typeOfTaskLabel);
		reportPage.selectDropDownPopupValue(typeOfTaskHeaderLabel, typeOfTaskValue);
		reportPage.clickDropDownClose();
		reportPage.verifySelectedDropDownValue(typeOfTaskValue);
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
