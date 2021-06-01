package TestScriptNCP_SponsorLogin;

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
import ModulerLibrary.NCP_SponsorLoginAction;
import ObjectRepository.ReportModule;
import ObjectRepository.Report_ContractorContactList;
import ObjectRepository_NCP.NCP_ReportPage;
import ObjectRepository_NCP.NCP_SponsorLoginHomePage;

public class NCP_SPL_ContractorContactList_Report_Test extends BaseClass
{
	
	WebDriverCommonLib wb = new WebDriverCommonLib();
	String selectReportName = "Contractor Contact List Report";
	
	
	@Test(dataProvider = "excelData")
	public void testEnrollmentStatusReport(String ProgramName, String Division, String Projects) throws Throwable {
		String baseUrl = driver.getCurrentUrl();

		NCP_SponsorLoginAction.logInNCP(driver);
		NCP_SponsorLoginHomePage.moduleReports(driver).click();
		Thread.sleep(3000);
		test.log(LogStatus.PASS, " Clicked on Report Module");
		try {
			wb.waitForElemnet(NCP_ReportPage.selectProgramField(driver));
			Thread.sleep(3000);
			wb.selectSingleValueFromList(NCP_ReportPage.selectProgramFromList(driver), ProgramName);
			test.log(LogStatus.PASS, ProgramName + " Program Selected Successfully");
			wb.selectSingleValueFromList(NCP_ReportPage.selectReportNameFromList(driver), selectReportName);
			test.log(LogStatus.PASS, selectReportName + " Report Selected Successfully");

			Thread.sleep(5000);
			wb.getWindowIDs();
			driver.switchTo().window(wb.map.get("childID"));
			driver.manage().window().maximize();

			wb.selectSingleValue(Report_ContractorContactList.filterSelectDivisionDropdown(driver), Division);
			test.log(LogStatus.PASS, Division+" Divisions Selected Successfully");
			wb.selectSingleValue(Report_ContractorContactList.filterSelectProjectFormOption(driver), Projects);
			test.log(LogStatus.PASS, Projects+" Project Selected Successfully");

			/*
			 * wb.selectSingleValue(Report_ContractorContactList.
			 * filterSelectContractorFormOption(driver), "All Contractors");
			 * test.log(LogStatus.PASS, " Contractor Selected Successfully");
			 */
			
			
			JavascriptExecutor js = (JavascriptExecutor)driver;
			js.executeScript("arguments[0].scrollIntoView();", Report_ContractorContactList. filterSelectContractorFormOption(driver));
			  System.out.println("All contractors is scrolled to click");
			Report_ContractorContactList. filterSelectContractorFormOption(driver).click();
		    System.out.println("All contractors is clicked");

			Report_ContractorContactList.btnBuildReport(driver).click();
			test.log(LogStatus.INFO, " Clicked On Build Report Button");
			Thread.sleep(3000);
			test.log(LogStatus.PASS, "Report Generated " + test.addScreenCapture(FileUtils1.getScreenshot(driver)));

		} catch (Throwable e) {
			test.log(LogStatus.FAIL, e + " Something Went Wrong");
			test.log(LogStatus.PASS, "Something Went Wrong" + test.addScreenCapture(FileUtils1.getScreenshot(driver)));
		}
		
		
		try {
			
			SoftAssert softAssertion= new SoftAssert();
			System.out.println(Report_ContractorContactList.reportHeaderReportName(driver).getText());
			softAssertion.assertEquals(Report_ContractorContactList.reportHeaderReportName(driver).getText(),
					"Contractor Contact List Report");
			System.out.println("Report Name is Matched");
			test.log(LogStatus.PASS, "Report Header Name Matched");
			test.log(LogStatus.PASS, "Report Generated Successfully");
			softAssertion.assertEquals(Report_ContractorContactList.programName(driver).getText(),ProgramName);
			test.log(LogStatus.PASS,"Program Name:- " + Report_ContractorContactList.programName(driver).getText());
			test.log(LogStatus.PASS,"Sponsor Name:- " + Report_ContractorContactList.sponsorName(driver).getText());
			//test.log(LogStatus.PASS,"Project Name:- " + Report_ContractorContactList.projectName(driver).getText());
			test.log(LogStatus.PASS,"Time Stamp:- " + Report_ContractorContactList.timeStamp(driver).getText());
			test.log(LogStatus.PASS,"PDF Option is Present:- " + Report_ContractorContactList.exportToPDF(driver).isDisplayed());
			test.log(LogStatus.PASS,"Excel Option is Present:- " + Report_ContractorContactList.exportToExcel(driver).isDisplayed());
			test.log(LogStatus.PASS,"================= Column Name =================" );
			List<WebElement> list = Report_ContractorContactList.allColumnName(driver);
//			wb.printListData();
			for(int i=0;i<list.size();i++)
			{
				test.log(LogStatus.PASS,"=====> "+ list.get(i).getText() +" <=====");
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
						ReportModule.filterSelectProjectFormOption(driver, "Test Project 10"));
				test.log(LogStatus.PASS, " First Project Selected Successfully");

				Thread.sleep(1000);
				js.executeScript("arguments[0].click();", Report_ContractorContactList.btnBuildReport(driver));
				test.log(LogStatus.INFO, " Clicked On Build Report Button");
				Thread.sleep(3000);

//				testCount(1, 14);
				ReportModule.FilterWindowButton(driver).click();
				Thread.sleep(3000);
				js.executeScript("arguments[0].click();", ReportModule.filterSelectProjectFormOption(driver, "Test 132 OFF"));
				test.log(LogStatus.PASS, " Second Project Selected Successfully");
				Thread.sleep(1000);
				js.executeScript("arguments[0].click();", Report_ContractorContactList.btnBuildReport(driver));
				test.log(LogStatus.INFO, " Clicked On Build Report Button");
				Thread.sleep(3000);
//				testCount(2, 18);
				
				Thread.sleep(2000);
				// Check for pdf is generated or not take screenshot
				Report_ContractorContactList.pdfLink(driver).click();
				Thread.sleep(2000);
				wb.getWindowID3();
				driver.switchTo().window(wb.map.get("subchildID"));
				Thread.sleep(5000);
				test.log(LogStatus.PASS, "Pdf Generated " + test.addScreenCapture(FileUtils1.getScreenshot(driver)));
				driver.close();
				driver.switchTo().window(wb.map.get("childID"));

				// Excel file
				Report_ContractorContactList.excelLink(driver).click();
				Thread.sleep(10000);
				if (wb.isFileDownloaded("Contractor_Contact_List_Report.xls") == true) {
					System.out.println("Excel file Downloaded Successfully");
					test.log(LogStatus.PASS, "Excel file Downloaded Successfully");
				} else {
					System.out.println("Excel file is not Downloaded Successfully");
					test.log(LogStatus.FAIL, "Excel file is not Downloaded Successfully");
				}
				Thread.sleep(5000);
		
		driver.close();
		driver.switchTo().window(wb.map.get("parentID"));
			
			
			
			
			
			
			driver.navigate().to(baseUrl);
		}

		@DataProvider(name = "excelData")
		public Object[][] passdata() {
			//String filePath = "E:\\kp workspace selenium\\Wrap Portal\\testData\\NCP Report Data.xlsx";
			String filePath="D:\\NOURTEK\\Wrap Portal-2\\testData\\NCP Report Data.xlsx";
			ExcelDataConfig config = new ExcelDataConfig(filePath);
			int row = config.getRowCount(0);// get exact row count from sheet
			int col = config.getColCount(0);
			System.out.println(col);
			System.out.println(row);

			Object[][] data = new Object[row - 1][col];
			for (int i = 1; i < row; i++) {
				for (int j = 0; j < col; j++) {
					data[i - 1][j] = config.getExcelData("Sheet1", i, j);
				}
			}
			return data;// return data to test

		}
}
