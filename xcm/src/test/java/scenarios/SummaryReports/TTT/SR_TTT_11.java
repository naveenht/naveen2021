package scenarios.SummaryReports.TTT;

import java.util.List;

import baseClass.BaseClass;
import iSAFE.ApplicationKeywords;
import pages.ReportPage;

public class SR_TTT_11 extends ApplicationKeywords {

	BaseClass obj;
	private Boolean status = false;
	ReportPage reportPage;

	public SR_TTT_11(BaseClass obj) {
		super(obj);
		this.obj = obj;
	}

	public void sR_TTT_11() {

		String reportLink = retrieve("Report Link");
		String radioButtonLabel = retrieve("Radio Button Label");
		String radioButtonValue = retrieve("Radio Button Value");
		String chooseReportSaveCloseButton = retrieve("Choose Report Save&Close Button");
		String runReportButton = retrieve("Run Report Button");
		String reportPageTitle = retrieve("Report Page Title");
		String chooseReportSaveNextButton = retrieve("Choose Report Save&Next Button");

		String resetButton = retrieve("Reset Button");
		String noOfCheckBoxes = retrieve("No Of Check Boxes");
		
		String radioButtonLabel1 = retrieve("Radio Button Label1");
		String radioButtonLabel1Value1 = retrieve("Radio Button Label1 Value1");
		String radioButtonLabel1Value2 = retrieve("Radio Button Label1 Value2");
		
		reportPage = new ReportPage(obj);

		reportPage.clickReportTab(true);
		reportPage.clickReportLink(reportLink);
		
		reportPage.clickRadioButton(radioButtonLabel1, radioButtonLabel1Value1);
		reportPage.clickRadioButton(radioButtonLabel, radioButtonValue);
		reportPage.clickChooseLink();
		obj.transferControlToWindow(2);
		reportPage.verifyChooseButtons(resetButton, true);
		List<String> headerLabels = reportPage.selectColumnHeaderCheckbox(noOfCheckBoxes);
		reportPage.verifyChooseButtons(chooseReportSaveNextButton, true);
		reportPage.verifyChooseButtons(chooseReportSaveCloseButton, true);
		obj.transferControlToWindow(1);
		reportPage.verifyButton(runReportButton, true);
		obj.transferControlToWindow(2);
		reportPage.validateColumnHeaders(headerLabels);
		obj.validateReportPageTitle(reportPageTitle);
		obj.transferControlToWindow(1);
		
		reportPage.clickRadioButton(radioButtonLabel1, radioButtonLabel1Value2);
		reportPage.clickRadioButton(radioButtonLabel, radioButtonValue);
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
