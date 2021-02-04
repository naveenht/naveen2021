package scenarios.ComplianceReports.SOD;

import baseClass.BaseClass;
import iSAFE.ApplicationKeywords;
import pages.ReportPage;

public class CR_SOD_03 extends ApplicationKeywords

{
		BaseClass obj;
		private Boolean status = false;
		ReportPage reportPage;
		
		public CR_SOD_03(BaseClass obj) {
			super(obj);
			this.obj = obj;
		}
		
		public void cR_SOD_03() {
			
			  String reportLink=retrieve("Report Link");
				String runReportButton=retrieve("Run Report Button");
				String reportPageTitle=retrieve("Report Page Title");
				String fiscalYearLabel=retrieve("Fiscal Year Label");
				String fiscalYearValue=retrieve("Fiscal Year Value");
				String typeOfTaskLabel=retrieve("Type Of Task Label");
				String typeOfTaskValue=retrieve("Type Of Task Value");
		        String headertypeOfTask=retrieve("Extended Tasks Selection");
		        String originatingLocationLabel=retrieve("Originating Location Label");
		        String currentLocationLabel=retrieve("Current Location Label");
		        
			   reportPage = new ReportPage(obj);
				
			   reportPage.clickReportTab(true);
			   reportPage.clickReportLink(reportLink);
			   reportPage.selectRoleNameDropDownValue(originatingLocationLabel);
			   reportPage.selectRoleNameDropDownValue(currentLocationLabel);
			   reportPage.clickDropDown(typeOfTaskLabel);
			   reportPage.selectDropDownPopupValue(headertypeOfTask, typeOfTaskValue);
			   reportPage.clickDropDownClose();
			   reportPage.selectDropDownValue(fiscalYearLabel,fiscalYearValue);
			   reportPage.verifySelectedDropDownValue(fiscalYearValue);
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


