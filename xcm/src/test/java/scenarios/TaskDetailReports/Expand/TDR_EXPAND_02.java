package scenarios.TaskDetailReports.Expand;

import baseClass.BaseClass;
import iSAFE.ApplicationKeywords;

import pages.ReportPage;

public class TDR_EXPAND_02 extends ApplicationKeywords {

	BaseClass obj;
	private Boolean status = false;
	ReportPage reportPage;

	public TDR_EXPAND_02(BaseClass obj) {
		super(obj);
		this.obj = obj;
	}

	public void tDR_EXPAND_02()  {

		
		String reportLink = retrieve("Report Link");
		String categoryLabel = retrieve("CategoryLabel");
		String fiscalYearLabel = retrieve("FiscalYearLabel");
		
		
		
		reportPage =new ReportPage(obj);
		
		reportPage.clickReportTab(true);
		reportPage.clickReportLink(reportLink);
		
		reportPage.selectDropDownValue(categoryLabel, "all");
		reportPage.selectDropDownValue(fiscalYearLabel, "Select");
		
		reportPage.clickExportButtonExpand(true);
		
		obj.validateFileExists("");
		
		
		
		
				
		if (obj.testFailure || reportPage.testFailure) {
			status = true;
		}
		this.testFailure = status;
	}

}


