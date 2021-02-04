package scenarios.TaskDetailReports.TTC;

import baseClass.BaseClass;
import iSAFE.ApplicationKeywords;
import pages.ReportPage;

public class TDR_TTC_04 extends ApplicationKeywords{

	BaseClass obj;
	private Boolean status = false;
	ReportPage reportPage;
	
	
	 public TDR_TTC_04(BaseClass obj){
			super(obj);
			this.obj=obj;
	 }
	 
	        public void tDR_TTC_04() {
						
	        	String reportLink=retrieve("Report Link");
	    		String radioButtonLabel=retrieve("Radio Button Label");
	    		String radioButtonValue=retrieve("Radio Button Value");
	    		String saveReportButton=retrieve("Save Report Button");
	    		String reportTitleLabel=retrieve("Report Popup Title Label");
	    		String reportTitleValue=retrieve("Report Popup Title Value");
	    		String reportDescriptionLabel=retrieve("Report Description Label");
	    		String reportDescriptionValue=retrieve("Report Description Value");
	    		String customReportSaveButton=retrieve("Custom Report Save Button");
	    		String tableName=retrieve("Table Name");
	    		String tableColumnHeader=retrieve("Table Column Header");
	    		
	    		
	    		
	    		reportPage = new ReportPage(obj);
	    		
	    		reportPage.clickReportTab(true);
	    		reportPage.clickReportLink(reportLink);
	    		reportPage.clickRadioButton(radioButtonLabel,radioButtonValue);
	    		reportPage.verifyButton(saveReportButton, true);
	    		String reportTitle=reportPage.enterTextInSaveCustomReportPopup(reportTitleLabel, reportTitleValue);
	    		reportPage.enterTextInSaveCustomReportPopup(reportDescriptionLabel, reportDescriptionValue);
	    		reportPage.verifySaveCustomReportPopupButtons(customReportSaveButton);
	    		reportPage.verifyTableData(tableName);
	    		int colposition=reportPage.getSystemWideCustomReportsHeaderPosition(tableName,tableColumnHeader);
	    		reportPage.getRowPositionValue(tableName,colposition, reportTitle);
	    		
	    		
	    		if (obj.testFailure || reportPage.testFailure) {
	    			status = true;
	    		}
	    		this.testFailure = status;
	    	}
	    	

	    }

