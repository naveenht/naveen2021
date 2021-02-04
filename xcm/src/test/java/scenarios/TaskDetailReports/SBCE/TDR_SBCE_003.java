package scenarios.TaskDetailReports.SBCE;

import baseClass.BaseClass;
import iSAFE.ApplicationKeywords;
import pages.ReportPage;

public class TDR_SBCE_003 extends ApplicationKeywords {
	

	BaseClass obj;
	private Boolean status = false;
	ReportPage reportPage;
	
	public TDR_SBCE_003 (BaseClass obj) {
		super(obj);
		this.obj = obj;
	}
	
	
	public void tDR_SBCE_003() {
		
			String reportLink=retrieve("Report Link");
			String reportPageTitle=retrieve("Report Page Title");
			String runReportButton = retrieve("Run Report Button");
			String typeOfTaskLabel = retrieve("Type Of Task Label");
			String typeOfTaskValue = retrieve("Type Of Task Value");
			String fisicalYearLabel=retrieve("Fiscal Year Label");
			String fisicalYearValue=retrieve("Fiscal Year Value");
			String fromDateLabel = retrieve("From Date Label");
			String fromDateValue = retrieve("From Date Value");
			String originatingLocationLabel=retrieve("Originating Location Label");
			
			reportPage = new ReportPage(obj);
			
			reportPage.clickReportTab(true);
			reportPage.clickReportLink(reportLink);
			reportPage.selectRoleNameDropDownValue(originatingLocationLabel);
			reportPage.selectDropDownValue(typeOfTaskLabel, typeOfTaskValue);
			reportPage.selectDropDownValue(fisicalYearLabel, fisicalYearValue);
			reportPage.selectCalenderPopup(fromDateLabel);
			reportPage.selectDate(fromDateValue);
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



