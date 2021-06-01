package TestScript_NCP;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import CommonLibrary.WebDriverCommonLib;
import GenericLibrary.BaseClass;
import GenericLibrary.ExcelDataConfig;
import GenericLibrary.FileUtils1;
import ModulerLibrary.NCP_LoginAction;
import ObjectRepository.ReportModule;
import ObjectRepository_NCP.NCP_HomePage;
import ObjectRepository_NCP.NCP_ReportPage;
import ObjectRepository_NCP.Report_NCP_Contractor_Structure_By_Program;

public class Report_NCP_Contractor_Structure_By_Program_Test extends BaseClass {

	WebDriverCommonLib wb = new WebDriverCommonLib();
	String reportName = "Contractor Structure By Program";

	@Test(dataProvider = "excelData")
	public void testContractorStructureNCP(String ProgramName, String Division, String Projects)
			throws InterruptedException {
		String BaseUrl = driver.getCurrentUrl();
		try {
			NCP_LoginAction.logInNCP(driver);
			NCP_HomePage.ReportModule(driver).click();
			test.log(LogStatus.PASS, " Clicked on Report Module");
			wb.waitForElemnet(NCP_ReportPage.selectProgramField(driver));
			Thread.sleep(3000);
			wb.selectSingleValueFromList(NCP_ReportPage.selectProgramFromList(driver), ProgramName);
			test.log(LogStatus.PASS, ProgramName + " Program Selected Successfully");
			wb.selectSingleValueFromList(NCP_ReportPage.selectReportNameFromList(driver), reportName);
			test.log(LogStatus.PASS, reportName + " Report Selected Successfully");

			Thread.sleep(5000);
			wb.getWindowIDs();
			driver.switchTo().window(wb.map.get("childID"));
			driver.manage().window().maximize();
			wb.selectSingleValue(Report_NCP_Contractor_Structure_By_Program.filterSelectDivisionDropdown(driver),
					Division);
			test.log(LogStatus.PASS, Division + "  Selected Successfully");
			Report_NCP_Contractor_Structure_By_Program.filterSelectProjectFormOption(driver, Projects).click();
			test.log(LogStatus.PASS, Projects + " Project Selected Successfully");

			Report_NCP_Contractor_Structure_By_Program.btnBuildReport(driver).click();
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
			System.out.println(Report_NCP_Contractor_Structure_By_Program.reportHeaderReportName(driver).getText());
			wb.waitForElemnet(Report_NCP_Contractor_Structure_By_Program.reportHeaderReportName(driver));
			Assert.assertEquals(Report_NCP_Contractor_Structure_By_Program.reportHeaderReportName(driver).getText(),
					"Contractor Structure By Program");
			System.out.println("Report Name is Matched");
			test.log(LogStatus.PASS, "Report Header Name Matched");
			test.log(LogStatus.PASS, "Report Generated Successfully");
		} catch (Throwable e) {
			System.out.println("report name not matched");
			test.log(LogStatus.FAIL, e + "Report Header Name Not Matched");
		}
		// filter testing

		Report_NCP_Contractor_Structure_By_Program.filterWindowButton(driver).click();
		Thread.sleep(3000);
		Report_NCP_Contractor_Structure_By_Program.filterSelectProjectFormOption(driver, "Test Project 10").click();
		test.log(LogStatus.PASS, " First Project Selected Successfully");
		ReportModule.btnBuildReport(driver).click();
		test.log(LogStatus.PASS, "Clicked on Build Report Button ");
		int contPkgSize = 7;
		// testCount(contPkgSize);

		// add second project
		Report_NCP_Contractor_Structure_By_Program.filterWindowButton(driver).click();
		Thread.sleep(3000);
		Report_NCP_Contractor_Structure_By_Program.filterSelectProjectFormOption(driver, "Test 132 OFF").click();
		test.log(LogStatus.PASS, " Second Project Selected Successfully");
		ReportModule.btnBuildReport(driver).click();
		test.log(LogStatus.PASS, "Clicked on Build Report Button ");
		contPkgSize = 11;
		// testCount(contPkgSize);

		// Check for pdf is generated or not take screenshot
		Report_NCP_Contractor_Structure_By_Program.pdfLink(driver).click();
		test.log(LogStatus.PASS, "Clicked on Export To PDF Link ");
		wb.getWindowID3();
		driver.switchTo().window(wb.map.get("subchildID"));
		test.log(LogStatus.PASS, "Pdf Generated " + test.addScreenCapture(FileUtils1.getScreenshot(driver)));
		Thread.sleep(5000);
		driver.close();
		driver.switchTo().window(wb.map.get("childID"));
		test.log(LogStatus.PASS, "Clicked on Build Report Button ");

		// Excel file
		Report_NCP_Contractor_Structure_By_Program.excelLink(driver).click();
		test.log(LogStatus.PASS, "Clicked on Export to Excel Link");
		Thread.sleep(5000);
		// isFileDownloaded is the std method which accept the name of file and
		// confirms the download
		//Assert.assertTrue(wb.isFileDownloaded("Claims_Coding_-_Contractor_Summary_Report.xls"),
		//		"Failed to download Expected document");
		if (wb.isFileDownloaded("Contractor_Structure_By_Program.xls") == true) {
			System.out.println("Excel file Downloaded Successfully");
			test.log(LogStatus.PASS, "Excel file Downloaded Successfully");
		} else {
			System.out.println("Excel file is not Downloaded Successfully");
			test.log(LogStatus.FAIL, "Excel file is not Downloaded Successfully");
		}

		// Add Filter Test
		Report_NCP_Contractor_Structure_By_Program.filterWindowButton(driver).click();
		test.log(LogStatus.PASS, "Clicked on Filter ");
		Thread.sleep(3000);
		Report_NCP_Contractor_Structure_By_Program.addFilterBtnOutside(driver).click();
		test.log(LogStatus.PASS, "Clicked on Add Filter Button From Filter");
		wb.getWindowID3();
		driver.switchTo().window(wb.map.get("subchildID"));
		driver.manage().window().maximize();
		wb.waitForElemnet(Report_NCP_Contractor_Structure_By_Program.selectAnFilterDropdown(driver));
		wb.selectSingleValueByIndex(Report_NCP_Contractor_Structure_By_Program.selectAnFilterDropdown(driver), 1);
		Thread.sleep(3000);
		test.log(LogStatus.PASS, " Filter Selected Successfully From Dropdown");
		wb.selectSingleValueByIndex(Report_NCP_Contractor_Structure_By_Program.selectAFilterCondition(driver), 1);
		Thread.sleep(3000);
		test.log(LogStatus.PASS, "Filter Condition Selected Successfully ");
		Report_NCP_Contractor_Structure_By_Program.addFilterParameter1(driver).click();
		Thread.sleep(1000);
		wb.selectSingleValueFromList(Report_NCP_Contractor_Structure_By_Program.selectParameter1(driver), "Enrolled");
		test.log(LogStatus.PASS, "Parameter Selected Successfully ");
		Report_NCP_Contractor_Structure_By_Program.addFilterBtnInside(driver).click();
		test.log(LogStatus.PASS, "Clicked on Add Filter Button ");
		Thread.sleep(3000);
		driver.switchTo().window(wb.map.get("childID"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", ReportModule.btnBuildReport(driver));
		test.log(LogStatus.PASS, "Clicked on Build Report Button ");

		Thread.sleep(5000);
		driver.close();
		driver.switchTo().window(wb.map.get("parentID"));
		driver.navigate().to(BaseUrl);

	}

	@DataProvider(name = "excelData")
	public Object[][] passdata() {
		//String filePath = "E:\\kp workspace selenium\\Wrap Portal\\testData\\NCP Report Data.xlsx";
		String filePath="D:\\NOURTEK\\Wrap Portal-2\\testData\\NCP Report Data.xlsx";
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
}
