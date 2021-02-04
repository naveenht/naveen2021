package scenarios.TaskDetailReports.Expand;

import baseClass.BaseClass;
import iSAFE.ApplicationKeywords;

import pages.ReportPage;

public class TDR_EXPAND_01 extends ApplicationKeywords {

	BaseClass obj;
	private Boolean status = false;

	ReportPage reportPage;

	public TDR_EXPAND_01(BaseClass obj) {
		super(obj);
		this.obj = obj;
	}

	public void tDR_EXPAND_01()  {

		String reportLink = retrieve("Report Link");
		
		reportPage = new ReportPage(obj);
		reportPage.clickReportTab(true);
		reportPage.clickReportLink(reportLink);

		
		reportPage.clickExportButtonExpand(true);
		obj.validateFileExistsAndSave("");
		
				
		if (obj.testFailure || reportPage.testFailure) {
			status = true;
		}
		this.testFailure = status;
	}

}


