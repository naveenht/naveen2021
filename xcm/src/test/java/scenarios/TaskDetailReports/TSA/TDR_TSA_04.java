package scenarios.TaskDetailReports.TSA;

import baseClass.BaseClass;
import iSAFE.ApplicationKeywords;
import pages.ReportPage;

public class TDR_TSA_04 extends ApplicationKeywords{
	
	BaseClass obj;
	private Boolean status = false;
	ReportPage reportpage;
	
	
	 public TDR_TSA_04(BaseClass obj){
			super(obj);
			this.obj=obj;
	 }
	 
	        public void tDR_TSA_04() {
						
	        	String reportLink=retrieve("Report Link");
	    		
	    		String fiscalYearLabel=retrieve("Fiscal Year Label");
	    		String fiscalYearValue=retrieve("Fiscal Year Value");
	    		String typeOfTaskLabel=retrieve("Type Of Task Label");
	    		String typeOfTaskValue=retrieve("Type Of Task Value");
	    		String typeOfTaskHeaderLabel=retrieve("Type Of Task Header Label");
	    		
	    		String radioButtonLabel=retrieve("Radio Button Label");
				String radioButtonValue=retrieve("Radio Button Value");
				
				String saveReportButton=retrieve("Save Reoprt Button");
				String reportTitleLabel=retrieve("Report Title Label");
				String reportTitleValue=retrieve("Report Title Value");
				String reportDescriptionLabel=retrieve("Report Description Label");
				String reportDescriptionValue=retrieve("Report Description Value");
				String customReportSaveButton=retrieve("Custom Report Save Button");
				String tableName=retrieve("Table Name");
				String tableColumnHeader=retrieve("Table Column Header");
	    		
	    		reportpage = new ReportPage(obj);
	    		
	    		reportpage.clickReportTab(true);
	    		reportpage.clickReportLink(reportLink);
	    		reportpage.selectDropDownValue(fiscalYearLabel ,fiscalYearValue);
	    		reportpage.clickDropDown(typeOfTaskLabel);
	    		reportpage.selectDropDownPopupValue(typeOfTaskHeaderLabel, typeOfTaskValue);
	    		reportpage.clickDropDownClose();
	    		reportpage.clickRadioButton(radioButtonLabel,radioButtonValue);
	    		reportpage.verifyButton(saveReportButton, true);
	    		String reportTitle=reportpage.enterTextInSaveCustomReportPopup(reportTitleLabel, reportTitleValue);
	    		reportpage.enterTextInSaveCustomReportPopup(reportDescriptionLabel, reportDescriptionValue);
	    		reportpage.verifySaveCustomReportPopupButtons(customReportSaveButton);
	    		
	    		int colposition=reportpage.getSystemWideCustomReportsHeaderPosition(tableName,tableColumnHeader);
	    		reportpage.getRowPositionValue(tableName,colposition, reportTitle);
	    		
	    		if (obj.testFailure || reportpage.testFailure) {
	    			status = true;
	    		}
	    		this.testFailure = status;
	    	}
	    	

	    }
	    		


