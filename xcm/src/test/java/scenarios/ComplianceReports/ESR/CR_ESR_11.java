package scenarios.ComplianceReports.ESR;

import java.util.List;

import baseClass.BaseClass;
import iSAFE.ApplicationKeywords;
import pages.ReportPage;

public class CR_ESR_11 extends ApplicationKeywords 
{
	BaseClass obj;
	private Boolean status = false;
	ReportPage reportPage;
	
	public CR_ESR_11(BaseClass obj) {
		super(obj);
		this.obj = obj;
	}
	
	
	public void cR_ESR_11() {
		
		String reportLink=retrieve("Report Link");
		String radioButtonLabel=retrieve("Radio Button Label");
		String radioButtonValue=retrieve("Radio Button Value");
		String chooseReportSaveCloseButton=retrieve("Choose Report Save&Close Button");
		String runReportButton=retrieve("Run Report Button");
		String reportPageTitle=retrieve("Report Page Title");
		String chooseReportSaveNextButton=retrieve("Choose Report Save&Next Button");

		String resetButton = retrieve("Reset Button");
		String noOfCheckBoxes = retrieve("No Of Check Boxes");
		
		
		
		
		
		reportPage = new ReportPage(obj);
		
		reportPage.clickReportTab(true);
		reportPage.clickReportLink(reportLink);
		
		
		reportPage.clickRadioButton(radioButtonLabel,radioButtonValue);
		reportPage.clickChooseLink();
		obj.transferControlToWindow(2);
		reportPage.verifyChooseButtons(resetButton, true);
		List<String> headerLabels1 = reportPage.selectColumnHeaderCheckbox(noOfCheckBoxes);
		reportPage.verifyChooseButtons(chooseReportSaveNextButton, true);
		reportPage.verifyChooseButtons(chooseReportSaveCloseButton, true);
		obj.transferControlToWindow(1);
		reportPage.verifyButton(runReportButton, true);
		obj.transferControlToWindow(2);
		reportPage.validateColumnHeaders(headerLabels1);
		obj.validateReportPageTitle(reportPageTitle);
		obj.transferControlToWindow(1);
		
		
		if (obj.testFailure || reportPage.testFailure) {
			status = true;
		}
		this.testFailure = status;
	}
	

}
