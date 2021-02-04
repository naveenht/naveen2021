package scenarios.AdministratorReport.RT;

import baseClass.BaseClass;
import iSAFE.ApplicationKeywords;
import pages.ReportPage;


public class AR_RT_03 extends ApplicationKeywords{
	
	BaseClass obj;
	private boolean status=false;
	ReportPage reportPage;
	
	public AR_RT_03(BaseClass obj){
		super(obj);
		this.obj=obj;
		
	}
	
	public void aR_RT_03(){
		
		String reportLink=retrieve("Report Link");
		String runReportButton=retrieve("Run Report Button");
		String reportPageTitle=retrieve("Report Page Title");
		
		String groupNameLabel=retrieve("Group Name Label");
		//String groupNameValue=retrieve("Group Name Value");
		
		String typeOfTaskLabel=retrieve("Type Of Task Label");
		String typeOfTaskValue=retrieve("Type Of Task Value");
		
		//String groupNumbervlaue=retrieve("Group  Number Value");
		String groupNumberLable=retrieve("Group Number Lable");
		
	
		reportPage = new ReportPage(obj);

		
		reportPage.clickReportTab(true);
		reportPage.clickReportLink(reportLink);
		
		
		//reportPage.selectRoleNameDropDownValue(groupNameLabel);
		reportPage.clickRoleNameDropDown(groupNameLabel);
		reportPage.selectDropDownValue(typeOfTaskLabel, typeOfTaskValue);
	//	reportPage.selectRoleNameDropDownValue(groupNumberLable);
		reportPage.clickRoleNameDropDown(groupNumberLable);
		
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
