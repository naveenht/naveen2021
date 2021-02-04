package scenarios.TaskDetailReports.DET;

import baseClass.BaseClass;
import iSAFE.ApplicationKeywords;
import pages.ReportPage;


public class TDR_DET_03 extends ApplicationKeywords{
	
	BaseClass obj;
	private boolean status=false;
	ReportPage reportPage;
	
	public TDR_DET_03(BaseClass obj){
		super(obj);
		this.obj=obj;
		
	}
	
	public void tDR_DET_03(){
		
		String reportLink=retrieve("Report Link");
		String runReportButton=retrieve("Run Report Button");
		String reportPageTitle=retrieve("Report Page Title");
		
		String fiscalYearLabel=retrieve("Fiscal Year Label");
		String fiscalYearValue=retrieve("Fiscal Year Value");
		
		String typeOfTaskLabel=retrieve("Type Of Task Label");
		String typeOfTaskValue=retrieve("Type Of Task Value");
		
		String typeOfTaskHeaderLabel=retrieve("Type Of Task Header Label");
		
		String curentLocationdropdownHeaderLabel=retrieve("CL Dropdown Header Label");
		String currentLocationLable=retrieve("Current Location Lable");
		
		String originatingLocationHeaderLabel= retrieve("Originating Location Header Label");
		String originatingLocationLabel=retrieve("Originating Location Label");
		
		
		reportPage = new ReportPage(obj);

		
		reportPage.clickReportTab(true);
		reportPage.clickReportLink(reportLink);
		
		reportPage.clickDropDown(originatingLocationLabel);
		reportPage.selectDropDownPopupFirstValue(typeOfTaskHeaderLabel);
		reportPage.clickDropDownClose();
		
		reportPage.clickDropDown(typeOfTaskLabel);
		reportPage.selectDropDownPopupValue(originatingLocationHeaderLabel, typeOfTaskValue);
		reportPage.clickDropDownClose();
		reportPage.verifySelectedDropDownValue(typeOfTaskValue);
		
		reportPage.clickDropDown(currentLocationLable);
		reportPage.selectDropDownPopupFirstValue(curentLocationdropdownHeaderLabel);
		reportPage.clickDropDownClose();
		
		reportPage.selectDropDownValue(fiscalYearLabel, fiscalYearValue);
		
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
