package scenarios.TaskDetailReports.Expand;

import baseClass.BaseClass;
import iSAFE.ApplicationKeywords;

import pages.ReportPage;

public class TDR_EXPAND_16 extends ApplicationKeywords {

	BaseClass obj;
	private Boolean status = false;

	ReportPage reportPage;

	public TDR_EXPAND_16(BaseClass obj) {
		super(obj);
		this.obj = obj;
	}

	public void tDR_EXPAND_16()  {

		String reportLink = retrieve("Report Link");
			
		
		reportPage = new ReportPage(obj);

		reportPage.clickReportTab(true);
		reportPage.clickReportLink(reportLink);
		
		
		long startTime = reportPage.clickExportButtonExpand(true);
		long endTime = obj.validateFileExistsAndSave("");
		reportPage.calcualtedReportOpenedTime(startTime, endTime);
		obj.transferControlToWindow(1);
		
		
				
		if (obj.testFailure || reportPage.testFailure) {
			status = true;
		}
		this.testFailure = status;
	}

}


