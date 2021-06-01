package TestScript;

import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.relevantcodes.extentreports.LogStatus;

import CommonLibrary.WebDriverCommonLib;
import GenericLibrary.BaseClass;
import GenericLibrary.ExcelDataConfig;
import GenericLibrary.FileUtils1;
import ModulerLibrary.WPO_LoginActionClientWise;
import ObjectRepository.HomePage;
import ObjectRepository.ReportModule;
import ObjectRepository.Report_SubmittedPayroll;

public class Report_SubmittedPayroll_TC extends BaseClass {

	WebDriverCommonLib wb = new WebDriverCommonLib();
	String selectReportName = "Submitted Payroll Report";
	
//	String ProjectNAME1 ="UC - Test ";
//	String ProjectNAME2 ="UCD Tercero Dining Commons 2";

	@Test(dataProvider = "excelData")
	public void testSubmittedPayrollReport(String ProgramName, String Division, String Projects,String userName, String password, String ProjectNAME1,String ProjectNAME2)
			throws Throwable {
		
//		WPO_LoginActionClientWise.logInWTW(driver);
		try {

			WPO_LoginActionClientWise.logInCommon(driver, userName, password);
			System.out.println(ProgramName + Division + Projects);
			HomePage.controlMenuReports(driver).click();
			test.log(LogStatus.INFO, "Clicked on Report Module Icon");
			Thread.sleep(5000);
			wb.selectSingleValue(ReportModule.selectProgramDropdown(driver), ProgramName);
			test.log(LogStatus.INFO, ProgramName + "Respective Program Select Form Dropdown");
			Thread.sleep(5000);
			Report_SubmittedPayroll.selectReport(driver, selectReportName).click();
			test.log(LogStatus.PASS, selectReportName + " Report is Selected");
			wb.getWindowIDs();
			driver.switchTo().window(wb.map.get("childID"));
			wb.selectSingleValue(Report_SubmittedPayroll.filterSelectDivisionDropdown(driver), Division);
			test.log(LogStatus.PASS, Division + " Divisions Selected Successfully");
			Report_SubmittedPayroll.filterSelectProjectFormOption(driver, Projects).click();
			test.log(LogStatus.PASS, Projects + " Project Selected Successfully");

			wb.selectSingleValue(Report_SubmittedPayroll.filterSelectContractorFormOption(driver), "All Contractors");
			test.log(LogStatus.PASS, " Contractor Selected Successfully");

			wb.selectSingleValue(Report_SubmittedPayroll.filterSelectFromMonth(driver), "May - 2018");
			test.log(LogStatus.PASS, " From Month Selected Successfully");
			wb.selectSingleValue(Report_SubmittedPayroll.filterSelectToMonth(driver), "Dec - 2019");
			test.log(LogStatus.PASS, " TO Month Selected Successfully");

			Report_SubmittedPayroll.btnBuildReport(driver).click();
			test.log(LogStatus.INFO, " Clicked On Build Report Button");
			Thread.sleep(3000);
			test.log(LogStatus.PASS, "Report Generated" + test.addScreenCapture(FileUtils1.getScreenshot(driver)));

		} catch (Throwable e) {
			test.log(LogStatus.FAIL, e + " Something Went Wrong");
			test.log(LogStatus.PASS, "Something Went Wrong" + test.addScreenCapture(FileUtils1.getScreenshot(driver)));
		}
		// String reportName=ReportModule.reportHeaderReportName(driver,
		// "Contractor Enrollment Summary").getText();

		try {
			SoftAssert softAssertion = new SoftAssert();
			System.out.println(Report_SubmittedPayroll.reportHeaderReportName(driver).getText());
			softAssertion.assertEquals(Report_SubmittedPayroll.reportHeaderReportName(driver).getText(),
					"Submitted Payroll Report");
			System.out.println("Report Name is Matched");
			test.log(LogStatus.PASS, "Report Header Name Matched");
			test.log(LogStatus.PASS, "Report Generated Successfully");
			softAssertion.assertEquals(Report_SubmittedPayroll.programName(driver).getText(), ProgramName);
			test.log(LogStatus.PASS, "Program Name:- " + Report_SubmittedPayroll.programName(driver).getText());
			test.log(LogStatus.PASS, "Sponsor Name:- " + Report_SubmittedPayroll.sponsorName(driver).getText());
			test.log(LogStatus.PASS, "Project Name:- " + Report_SubmittedPayroll.projectName(driver).getText());

			test.log(LogStatus.PASS, "Time Stamp:- " + Report_SubmittedPayroll.timeStamp(driver).getText());
			test.log(LogStatus.PASS,
					"PDF Option is Present:- " + Report_SubmittedPayroll.exportToPDF(driver).isDisplayed());
			test.log(LogStatus.PASS,
					"Excel Option is Present:- " + Report_SubmittedPayroll.exportToExcel(driver).isDisplayed());

			test.log(LogStatus.PASS, "================= Column Name =================");
			List<WebElement> list = Report_SubmittedPayroll.allColumnName(driver);
			// wb.printListData();
			for (int i = 0; i < list.size(); i++) {
				test.log(LogStatus.PASS, "=====> " + list.get(i).getText() + " <=====");
			}

			softAssertion.assertAll();

		} catch (Throwable e) {
			System.out.println("report name not matched");
			test.log(LogStatus.FAIL, e + "Report Header Name Not Matched");
		}

		// Filter Testing
		ReportModule.FilterWindowButton(driver).click();
		Thread.sleep(3000);
		JavascriptExecutor js = (JavascriptExecutor) driver;

		js.executeScript("arguments[0].click();",
				ReportModule.filterSelectProjectFormOption(driver, ProjectNAME1));
		test.log(LogStatus.PASS, " First Project Selected Successfully");

		Thread.sleep(1000);
		js.executeScript("arguments[0].click();", Report_SubmittedPayroll.btnBuildReport(driver));
		test.log(LogStatus.INFO, " Clicked On Build Report Button");
		Thread.sleep(3000);

//		testCount(2);
		
		ReportModule.FilterWindowButton(driver).click();
		Thread.sleep(3000);
		js.executeScript("arguments[0].click();", ReportModule.filterSelectProjectFormOption(driver, ProjectNAME2));
		test.log(LogStatus.PASS, " Second Project Selected Successfully");
		Thread.sleep(1000);
		js.executeScript("arguments[0].click();", Report_SubmittedPayroll.btnBuildReport(driver));
		test.log(LogStatus.INFO, " Clicked On Build Report Button");
		Thread.sleep(3000);
//		testCount(4);

		Thread.sleep(2000);
		// Check for pdf is generated or not take screenshot
		Report_SubmittedPayroll.pdfLink(driver).click();
		Thread.sleep(2000);
		wb.getWindowID3();
		driver.switchTo().window(wb.map.get("subchildID"));
		Thread.sleep(5000);
		test.log(LogStatus.PASS, "Pdf Generated " + test.addScreenCapture(FileUtils1.getScreenshot(driver)));
		driver.close();
		driver.switchTo().window(wb.map.get("childID"));

		// Excel file
		Report_SubmittedPayroll.excelLink(driver).click();
		Thread.sleep(10000);
		if (wb.isFileDownloaded("Submitted_Payroll_Report.xls") == true) {
			System.out.println("Excel file Downloaded Successfully");
			test.log(LogStatus.PASS, "Excel file Downloaded Successfully");
		} else {
			System.out.println("Excel file is not Downloaded Successfully");
			test.log(LogStatus.FAIL, "Excel file is not Downloaded Successfully");
		}
		Thread.sleep(5000);
		driver.close();
		driver.switchTo().window(wb.map.get("parentID"));

	}

	@DataProvider(name = "excelData")
	public Object[][] passdata() {


		// Excel sheet as on 14-04-2021
				
		String filePath ="D:\\NOURTEK\\Wrap Portal-2\\testData\\clientWiseReportTestData.xlsx";

//String filePath="E:\\kp workspace selenium\\Wrap Portal\\testData\\clientWiseReportTestData.xlsx";
//		String filePath="D:\\NOURTEK\\Wrap Portal-2\\testData\\WTWTestData.xlsx";
		ExcelDataConfig config = new ExcelDataConfig(filePath);// put all excel
																// data in to
																// the config
																// object
		int row = config.getRowCount(0);// get exact row count from sheet
		int col = config.getColCount(0);
		System.out.println(col);
		System.out.println(row);

		Object[][] data = new Object[row - 1][col];// store all row and column
													// in multidimensional array
													// and print one by one
		for (int i = 1; i < row; i++) {
			for (int j = 0; j < col; j++) {
				data[i - 1][j] = config.getExcelData("Sheet1", i, j);
			}
		}
		return data;// return data to test
	}

	public void testCount(int contPkgSize) {

		
		List<WebElement> countOfContractorPkg = Report_SubmittedPayroll.countProjectWiseContractorPkg(driver);

		

		if (countOfContractorPkg.size() == contPkgSize) {
			System.out.println("Contractor Pkg Count is Matached");
			test.log(LogStatus.PASS, countOfContractorPkg.size() + " Contractor Pkg Count is Matached");
		} else {
			System.out.println("Contractor Pkg Count is Not Matached");
			test.log(LogStatus.FAIL, countOfContractorPkg.size() + "Contractor Pkg Count is Not Matached");
		}

	}
}
