package TestScript;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import CommonLibrary.WebDriverCommonLib;
import GenericLibrary.BaseClass;
import GenericLibrary.FileUtils1;
import GenericLibrary.RandomClass;
import ObjectRepository.ContractorPackageModule;
import ObjectRepository.ContractorPackageModule_EmailPage;
import ObjectRepository.HomePage;

public class Neha_Tasks extends BaseClass {

	WebDriverCommonLib wb = new WebDriverCommonLib();
	String programName = "Goyal"; // "Automation Program dont touch";
	String TaskBeginDate = "05/01/2021";
	String TaskEndDate = "04/01/2022";
	String Task_SelectPriority = "Normal";
	String Task_SelectStatus = "In Progress";
	String Email = "neha@nourtek.com";
	String EmailByName = "neha";
	String EmailSubjectId = RandomClass.randomTaskSubject();
	String EmailTasktext ="Hello Neha";
	

	@Test
	public void Task() throws Throwable {
		JavascriptExecutor js = (JavascriptExecutor)driver;
		HomePage.HomeMenuContractorPackage(driver).click();
		test.log(LogStatus.PASS, "Contractor Package Icon is clicked");
		Thread.sleep(9000);
		wb.scrollToTop();
		//js.executeScript("arguments[0].scrollIntoView();", ContractorPackageModule.advanceSearchIcon(driver));
		ContractorPackageModule.advanceSearchIcon(driver).click();
		test.log(LogStatus.PASS, "Advance Search icon is clicked");
		Thread.sleep(1000);
		wb.selectSingleValue(ContractorPackageModule.advanceSearchSelectProgram(driver), programName);
		test.log(LogStatus.PASS, "ProgramName is selected as " + programName + "from Advance Search");
		Thread.sleep(500);
		js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
		System.out.println("sccroll to the End");
		Thread.sleep(2000);
		ContractorPackageModule.advanceSearchSearchBtn(driver).click();
		test.log(LogStatus.PASS, "Adavance Search Search  button  at bottom is clicked");
		Thread.sleep(5000);		
		driver.switchTo().frame(ContractorPackageModule.Enrollment_frame(driver));
		System.out.println("Switched to frame");
		Thread.sleep(2000);
		WebElement TaskIcon =driver.findElement(By.xpath("//div/ul/li[@id='liTasks']/a/i"));
		wb.mouseHoverByJavaScript(TaskIcon);
		wb.JSClick(TaskIcon);
		System.out.println("AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA");
		//ContractorPackageModule.TaskIconActivityPanel(driver).click();
		test.log(LogStatus.PASS, "clicked on Task icon");
		Thread.sleep(1000);
		ContractorPackageModule.TaskIcon_SubJect(driver).sendKeys(EmailSubjectId);
		test.log(LogStatus.PASS, "Task Subject is entered");
		ContractorPackageModule.TaskIcon_AssignedTo(driver).sendKeys("Azure Devops");
		Thread.sleep(1000);
		ContractorPackageModule.TaskIcon_AssignedTo(driver).sendKeys(Keys.ENTER);
		test.log(LogStatus.PASS, "Task Assigned to Entered");
		ContractorPackageModule.TaskIcon_BeginDate(driver).click();
		ContractorPackageModule.TaskIcon_BeginDate(driver).sendKeys(TaskBeginDate);
		ContractorPackageModule.TaskIcon_BeginDate(driver).sendKeys(Keys.TAB);
		test.log(LogStatus.PASS, "Task Begin Date is entered");
		Thread.sleep(500);
		ContractorPackageModule.TaskIcon_EndDate(driver).click();
		ContractorPackageModule.TaskIcon_EndDate(driver).sendKeys(TaskEndDate);
		ContractorPackageModule.TaskIcon_EndDate(driver).sendKeys(Keys.TAB);
		test.log(LogStatus.PASS, "Task End Date is entered");
		Thread.sleep(1000);
		wb.selectSingleValue(ContractorPackageModule.TaskIcon_SelectPriority(driver),Task_SelectPriority);
		test.log(LogStatus.PASS, "Task priority is selected as " + Task_SelectPriority);
		Thread.sleep(200);
		//wb.selectSingleValue(ContractorPackageModule.TaskIcon_SelectPriority(driver),Task_SelectStatus);
		test.log(LogStatus.PASS, "Task priority is selected as " + Task_SelectStatus);
		Thread.sleep(200);
		ContractorPackageModule.TaskIcon_WriteMessage(driver).sendKeys("Write Your Message Feild");
		Thread.sleep(1000);
		ContractorPackageModule.ActivityPanel_SubmitBtn(driver).click();
		test.log(LogStatus.PASS, "Activity panel Submit button present at end is clicked");
		Thread.sleep(2000);
		try {
			driver.switchTo().defaultContent();
			wb.getWindowIDs();
			driver.switchTo().window(wb.map.get("childID"));
			driver.manage().window().maximize();
			test.log(LogStatus.PASS, "switched to EMail window at try block");
			Thread.sleep(1000);
		}catch (Exception e) {
			wb.getWindowIDs();
			driver.switchTo().window(wb.map.get("childID"));
			driver.manage().window().maximize();
			test.log(LogStatus.PASS, "switched to EMail window at  catch block");
			Thread.sleep(1000);
		}
		
		
		ContractorPackageModule_EmailPage.To_EmailFeild(driver).sendKeys(Email);
		Thread.sleep(1500);
		ContractorPackageModule_EmailPage.To_EmailFeild(driver).sendKeys(Keys.ENTER);
		test.log(LogStatus.PASS, "Email to send is enetered as" + Email);
		Thread.sleep(2000);
		ContractorPackageModule_EmailPage.SendandCloseBtn(driver).click();
		test.log(LogStatus.PASS, "Send and close button is clicked at Email Management Page");
		System.out.println(driver.getWindowHandles());
		Thread.sleep(1500);
		//wb.getWindowIDs();
		driver.switchTo().window(wb.map.get("parentID"));
		Thread.sleep(4000);
		
		try {
			System.out.println("came till here in try");
			driver.switchTo().defaultContent();
			System.out.println("Switched to default content");
			driver.navigate().refresh();
		}catch (Exception e) {
			// TODO: handle exception
			System.out.println("came till here in catch");
			driver.switchTo().parentFrame();
			System.out.println("Switched to default content");
			driver.navigate().refresh();
		}
		
		
		Thread.sleep(4000);
		HomePage.controlMenuEmailIcon(driver).click();
		test.log(LogStatus.PASS, "Email Icon at Home Page is clicked");
		Thread.sleep(3000);
		wb.mouseover(HomePage.controlMenuEmailIcon(driver));
		test.log(LogStatus.PASS, "Mouse over is performed on Email Icon in Side Panel at Home Page");
		wb.mouseMoveToElement(HomePage.HomeMenuEmail_Sent(driver));
		Thread.sleep(2000);
		wb.scrollByVisibilityOfElement(HomePage.HomeMenuEmail_Sent(driver));
		test.log(LogStatus.PASS, "Sent Email icon is clicked at Email page");
		Thread.sleep(4000);
		HomePage.SearchEmailFeild(driver).sendKeys(Email);
		//HomePage.AdvanceSearchBtn(driver).click();
		//test.log(LogStatus.PASS, "Email Advance SentBtn is cliekd");
		Thread.sleep(7000);
		HomePage.SearchEmailFeild(driver).sendKeys(Email);
		/*
		 * wb.selectSingleValue(HomePage.AdavanceSearchByprogram(driver), programName);
		 * test.log(LogStatus.PASS,
		 * "advacne by program name at Email Sent page is selected as" + programName);
		 * HomePage.AdvancesearchByFromDate(driver).click();
		 * HomePage.AdvancesearchByFromDate(driver).sendKeys(TaskBeginDate);
		 * HomePage.AdvancesearchByFromDate(driver).sendKeys(Keys.TAB);
		 * test.log(LogStatus.PASS,
		 * "advacne by From  Date  at Email Sent page is selected as" + TaskBeginDate);
		 * Thread.sleep(1000); HomePage.AdvanceSearchByToDate(driver).click();
		 * HomePage.AdvanceSearchByToDate(driver).sendKeys(TaskEndDate);
		 * HomePage.AdvanceSearchByToDate(driver).sendKeys(Keys.TAB);
		 * test.log(LogStatus.PASS,
		 * "advacne by To Date  at Email Sent page is selected as" + TaskEndDate);
		 * Thread.sleep(1000); HomePage.AdvanceSearchSearchBtn(driver).click();
		 * test.log(LogStatus.PASS, "Advacbe search button at bottom is clicked");
		 * Thread.sleep(5000);
		 */
		HomePage.SearchBtn(driver).click();
		test.log(LogStatus.PASS, "EMail is entered and cliekd on Search btn");
		Thread.sleep(8000);
		HomePage.CheckEmailDynamic(EmailByName, EmailTasktext, driver).click();
		test.log(LogStatus.PASS, "Dynamic Email with subhect is selecyed");
		Thread.sleep(4000);
		driver.switchTo().frame(HomePage.EmailPreviewPanelFrame(driver));
		
		String EmailToText = HomePage.EmailPreviewPanelToFeild(driver).getText();
		if(EmailToText.contains(Email)) {
			test.log(LogStatus.PASS, "Email is sent successfully");
		}else
		{
			test.log(LogStatus.FAIL, "Email is not sent and not displayed");
		}
		
		
		
		driver.switchTo().defaultContent();
		test.log(LogStatus.PASS, test.addScreenCapture(FileUtils1.captureScreen(driver, "Email Sent Verify after add Task")));
 
		
		
		
	}

}
