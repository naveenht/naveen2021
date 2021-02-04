package scenarios.TaskDetailReports.Expand;

import baseClass.BaseClass;
import iSAFE.ApplicationKeywords;

import pages.ReportPage;

public class TDR_EXPAND_03 extends ApplicationKeywords {

	BaseClass obj;
	private Boolean status = false;
	ReportPage reportPage;

	public TDR_EXPAND_03(BaseClass obj) {
		super(obj);
		this.obj = obj;
	}

	public void tDR_EXPAND_03()  {

		
		String reportLink = retrieve("Report Link");
		String categoryLabel = retrieve("CategoryLabel");
		String fiscalYearLabel = retrieve("FiscalYearLabel");
		
		String originatingLocationLabel = retrieve("Originating Location Label");
		String originatingLocationHeaderLabel = retrieve("Originating Location Header Label");
		
		String currentLocationLabel = retrieve("Current Location Label");
		String currentLocationHeaderLabel = retrieve("Current Location Header Label");
		
		String typeOfTaskLabel = retrieve("Type Of Task Label");
		String typeOfTaskHeaderLabel = retrieve("Type Of Task Header Label");
		
		
			
		
		reportPage =new ReportPage(obj);
		
		reportPage.clickReportTab(true);
		reportPage.clickReportLink(reportLink);
		
		reportPage.selectDropDownValue(categoryLabel, "all");
		reportPage.selectDropDownValue(fiscalYearLabel, "Select");
						
		reportPage.clickDropDown(originatingLocationLabel);
		reportPage.selectDropDownPopupSecondValue(originatingLocationHeaderLabel);
		reportPage.clickDropDownClose();
		
		reportPage.clickDropDown(currentLocationLabel);
		reportPage.selectDropDownPopupSecondValue(currentLocationHeaderLabel);
		reportPage.clickDropDownClose();
		
		reportPage.clickDropDown(typeOfTaskLabel);
		reportPage.selectDropDownPopupSecondValue(typeOfTaskHeaderLabel);
		reportPage.clickDropDownClose();
		
		
		
		
		reportPage.clickExportButtonExpand(true);
		obj.validateFileExists("");
		
		
		
		
				
		if (obj.testFailure || reportPage.testFailure) {
			status = true;
		}
		this.testFailure = status;
	}

}


