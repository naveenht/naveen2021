package scenarios.SummaryReports.UW;
import baseClass.BaseClass;
import iSAFE.ApplicationKeywords;
import pages.ReportPage;

public class SR_UW_03 extends ApplicationKeywords {
	

	BaseClass obj;
	private Boolean status = false;
	ReportPage reportPage;
	
	public SR_UW_03(BaseClass obj) {
		super(obj);
		this.obj = obj;
	}
	
	
	public void sR_UW_03() {
		
		String reportLink=retrieve("Report Link");
		String reportPageTitle=retrieve("Report Page Title");
		String typeOfTasklabel=retrieve("Type Of Task Label");
		String typeOfTaskValue=retrieve("Type Of Task Value");
		String typeOfTaskHeaderLabel=retrieve("Type Of Task Header Label");
		String selectCategorylabel=retrieve("Select Category label");
		String selectCategoryvalue=retrieve("Select Category value");
		String runReportButton=retrieve("Run Report Button");
		
		reportPage = new ReportPage(obj);
		
		reportPage.clickReportTab(true);
		reportPage.clickReportLink(reportLink);
		reportPage.selectDropDownValue(selectCategorylabel, selectCategoryvalue);
		reportPage.clickDropDown(typeOfTasklabel);
		reportPage.selectDropDownPopupValue(typeOfTaskHeaderLabel,typeOfTaskValue);
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


