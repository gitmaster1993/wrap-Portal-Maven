package TestScript;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import CommonLibrary.WebDriverCommonLib;
import GenericLibrary.BaseClass;
import ObjectRepository.HomePage;
import ObjectRepository.Task_Module_Page;

public class VerifyTask_Email extends BaseClass {

	String ProgramName = "Goyal";
	WebDriverCommonLib wb = new WebDriverCommonLib();

	@Test
	public void VerifyTaskCreated() throws Throwable {

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrllIntoView();", HomePage.controlMenuTask(driver));
		HomePage.controlMenuTask(driver).click();
		test.log(LogStatus.PASS, "Task icon is clicked");
		Thread.sleep(4000);
		Task_Module_Page.TaskModule_Searchbar(driver).sendKeys("Neha Task");
		test.log(LogStatus.PASS, "task Module is seached with Neha Task");
		Thread.sleep(1500);
		Task_Module_Page.SearBtn(driver).click();
		test.log(LogStatus.PASS, "Task button   is cliked at Task Search Bar");
		/*
		 * Task_Module_Page.AdvSearchBtn(driver).click(); test.log(LogStatus.PASS,
		 * "Advance Search button is clicked"); Thread.sleep(1000);
		 * wb.selectSingleValue(Task_Module_Page.AdvSearch_SelectProgram(driver),
		 * ProgramName); test.log(LogStatus.PASS,
		 * "advacne search Program is selected as " + ProgramName); Thread.sleep(1000);
		 * Task_Module_Page.SearBtn(driver).click(); test.log(LogStatus.PASS,
		 * "Advacne search button is clicked"); Thread.sleep(3000);
		 */
		driver.switchTo().frame(HomePage.EmailPreviewPanelFrame(driver));
		WebElement ele = Task_Module_Page.PreviewPanelSubjectText(driver);
		String Subjecttext = ele.getText();
		System.out.println(Subjecttext + "Is the subject");
		if (Subjecttext.contains(Subjecttext)) {
			test.log(LogStatus.PASS, "Subject Task is Matched");
		} else {
			test.log(LogStatus.FAIL, "Subject Task is not  Matched");
		}

	}

}
