package scenarios.ComplianceReports.ED;

import baseClass.BaseClass;
import iSAFE.ApplicationKeywords;
import pages.ReportPage;

public class CR_ED_03 extends ApplicationKeywords

{
		BaseClass obj;
		private Boolean status = false;
		ReportPage reportPage;
		
		public CR_ED_03(BaseClass obj) {
			super(obj);
			this.obj = obj;
		}
		
		public void cR_ED_03() {
			
		    String reportLink=retrieve("Report Link");
			String runReportButton=retrieve("Run Report Button");
			String reportPageTitle=retrieve("Report Page Title");
			String fiscalYearLabel=retrieve("Fiscal Year Label");
			String fiscalYearValue=retrieve("Fiscal Year Value");
			String typeOfTaskLabel=retrieve("Type Of Task Label");
			String typeOfTaskValue=retrieve("Type Of Task Value");
	        String headertypeOfTask=retrieve("Extended Tasks Selection");
	        String originatingLocationLabel=retrieve("Originating Location Label");
		  
	        
	        reportPage = new ReportPage(obj);
			
		   reportPage.clickReportTab(true);
		   reportPage.clickReportLink(reportLink);
		   reportPage.clickDropDown(typeOfTaskLabel);
		   reportPage.selectDropDownPopupValue(headertypeOfTask, typeOfTaskValue);
		   reportPage.clickDropDownClose();
		   reportPage.selectDropDownValue(fiscalYearLabel,fiscalYearValue);
		   reportPage.verifySelectedDropDownValue(fiscalYearValue);
		   reportPage.verifySelectedDropDownValue(typeOfTaskValue);
		   reportPage.selectRoleNameDropDownValue(originatingLocationLabel);		   
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


