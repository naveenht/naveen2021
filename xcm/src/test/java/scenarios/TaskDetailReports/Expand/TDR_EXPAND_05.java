package scenarios.TaskDetailReports.Expand;

import baseClass.BaseClass;
import iSAFE.ApplicationKeywords;

import pages.ReportPage;

public class TDR_EXPAND_05 extends ApplicationKeywords {

	BaseClass obj;
	private Boolean status = false;
	ReportPage reportPage;

	public TDR_EXPAND_05(BaseClass obj) {
		super(obj);
		this.obj = obj;
	}

	public void tDR_EXPAND_05()  {

		
		String reportLink = retrieve("Report Link");
	
		String fiscalYearLabel = retrieve("FiscalYearLabel");
		String typeOfTaskLabel = retrieve("Type Of Task Label");
		String typeOfTaskHeaderLabel = retrieve("Type Of Task Header Label");
		
		
		String buttonName = retrieve("buttonName");
		String buttonNameSave = retrieve("buttonNameSave");
		String tableName = retrieve("tableName");
		
		String radioButtonLabel = retrieve("radioButtonLabel");
		String radioButtonValue = retrieve("radioButtonValue");
		
		String reportTitlelabel = retrieve("reportTitlelabel");
		String reportitleValue = retrieve("reportitleValue");
		
		String reportDescriptionlabel = retrieve("reportDescriptionlabel");
		String reportDescriptionValue = retrieve("reportDescriptionValue");
			
		
		reportPage =new ReportPage(obj);
		
		reportPage.clickReportTab(true);
		reportPage.clickReportLink(reportLink);
		
		
		reportPage.selectDropDownValue(fiscalYearLabel, "Select");
								
		reportPage.clickDropDown(typeOfTaskLabel);
		reportPage.selectDropDownPopupSecondValue(typeOfTaskHeaderLabel);
		reportPage.clickDropDownClose();
		
		reportPage.clickRadioButton(radioButtonLabel, radioButtonValue);
		reportPage.verifyButton(buttonName, true);
		
		String reportTitle = reportPage.enterTextInSaveCustomReportPopup(reportTitlelabel, reportitleValue);
		reportPage.enterTextInSaveCustomReportPopup(reportDescriptionlabel, reportDescriptionValue);
		reportPage.verifySaveCustomReportPopupButtons(buttonNameSave);
		int columnPosition = reportPage.getSystemWideCustomReportsHeaderPosition(tableName, reportTitlelabel);
		reportPage.getRowPositionValue(tableName, columnPosition, reportTitle);
		
								
		if (obj.testFailure || reportPage.testFailure) {
			status = true;
		}
		this.testFailure = status;
	}

}


