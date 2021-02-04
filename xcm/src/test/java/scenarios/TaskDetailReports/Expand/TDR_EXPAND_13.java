package scenarios.TaskDetailReports.Expand;

import baseClass.BaseClass;
import iSAFE.ApplicationKeywords;

import pages.ReportPage;

public class TDR_EXPAND_13 extends ApplicationKeywords {

	BaseClass obj;
	private Boolean status = false;

	ReportPage reportPage;

	public TDR_EXPAND_13(BaseClass obj) {
		super(obj);
		this.obj = obj;
	}

	public void tDR_EXPAND_13()  {

		String reportLink = retrieve("Report Link");
		String categoryLabel = retrieve("CategoryLabel");
		String fiscalYearLabel = retrieve("FiscalYearLabel");
		
		String radioButtonLabel1 = retrieve("Radio Button Label1");
		//String radioButtonLabel1Value1 = retrieve("Radio Button Label1 Value1");
		String radioButtonLabel1Value2 = retrieve("Radio Button Label1 Value2");
		
		
		reportPage = new ReportPage(obj);

		reportPage.clickReportTab(true);
		reportPage.clickReportLink(reportLink);
		
		reportPage.selectDropDownValue(fiscalYearLabel, "Select");
		reportPage.clickExportButtonExpand(true);
		obj.validateFileExists("");
		
		driver.navigate().refresh();
		reportPage.clickReportLink(reportLink);
		reportPage.selectDropDownValue(categoryLabel, "all");		
		reportPage.clickExportButtonExpand(true);
		obj.validateFileExists("");
		
		driver.navigate().refresh();
		reportPage.clickReportLink(reportLink);
		reportPage.clickRadioButton(radioButtonLabel1, radioButtonLabel1Value2);
		reportPage.selectDropDownValue(fiscalYearLabel, "Select");
		reportPage.clickExportButtonExpand(true);
		obj.validateFileExists("");
		driver.navigate().refresh();
		
		
		if (obj.testFailure || reportPage.testFailure) {
			status = true;
		}
		this.testFailure = status;
	}

}


