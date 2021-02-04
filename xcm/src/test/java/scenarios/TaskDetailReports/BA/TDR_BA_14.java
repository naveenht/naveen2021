package scenarios.TaskDetailReports.BA;

import java.util.concurrent.TimeUnit;

import baseClass.BaseClass;
import iSAFE.ApplicationKeywords;
import pages.ManageSettingsDefaultsPage;
import pages.ReportPage;

public class TDR_BA_14 extends ApplicationKeywords {

	BaseClass obj;
	private Boolean status = false;
	ReportPage reportPage;
	ManageSettingsDefaultsPage defaultsPage;

	public TDR_BA_14(BaseClass obj) {
		super(obj);
		this.obj = obj;
	}

	public void tDR_BA_14() {

		String reportLink = retrieve("Report Link");
		

		reportPage = new ReportPage(obj);
		reportPage.clickReportTab(true);
		reportPage.clickReportLink(reportLink);
		
		
		long startTime = reportPage.clickExportButton(true);
		long endTime = obj.validateFileExists("");
		reportPage.calcualtedReportOpenedTime(startTime, endTime);
		obj.transferControlToWindow(1);

		if (obj.testFailure || reportPage.testFailure) {
			status = true;
		}
		this.testFailure = status;
	}

}
