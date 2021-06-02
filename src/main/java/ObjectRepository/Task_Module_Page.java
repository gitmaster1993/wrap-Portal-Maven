package ObjectRepository;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Task_Module_Page {

	public static WebElement element;
	public static List<WebElement> listelement;

	static String Tasks_Icon = "//span[@id='ctl00_ContentPlaceHolder1_spnTasks']//a[@id='ctl00_ContentPlaceHolder1_aTask']";

	static String PlusBtn = "//div[@class='leftButtonGroup']//i[@class='fa fa-plus']";
	static String EditBtn = "//i[@class='fa fa-pencil-square-o']";
	static String DeleteBtn = "//div[@class='leftButtonGroup']//i[@class='fa fa-trash-o']";
	static String TaskModule_Searchbar = "//input[@id='ctl00_ContentPlaceHolder1_cntrlTaskList_txtSearch']";
	static String TaskModule_RefreshBtn = "//div[@class='rightButtonGroup']//i[@class='fa fa-refresh']";

	public static WebElement Tasks_Icon(WebDriver driver) {

		element = driver.findElement(By.xpath(Tasks_Icon));
		return element;
	}

	public static WebElement PlusBtn(WebDriver driver) {

		element = driver.findElement(By.xpath(PlusBtn));
		return element;
	}

	public static WebElement EditBtn(WebDriver driver) {

		element = driver.findElement(By.xpath(EditBtn));
		return element;
	}

	public static WebElement DeleteBtn(WebDriver driver) {

		element = driver.findElement(By.xpath(DeleteBtn));
		return element;
	}

	public static WebElement TaskModule_Searchbar(WebDriver driver) {

		element = driver.findElement(By.xpath(TaskModule_Searchbar));
		return element;
	}

	public static WebElement TaskModule_RefreshBtn(WebDriver driver) {

		element = driver.findElement(By.xpath(TaskModule_RefreshBtn));
		return element;
	}

	// Adavcne Search

	static String AdvSearchBtn = "//a[@data-original-title='Advanced Search']";
	static String AdvSearch_BeginDate = "//input[@id='ctl00_ContentPlaceHolder1_cntrlTaskList_startdatetimepicker']";
	static String AdvSearch_EndDate = "//input[@id='ctl00_ContentPlaceHolder1_cntrlTaskList_enddatetimepicker']";
	static String AdvSearch_SelectAdmin = "//select[@id='ctl00_ContentPlaceHolder1_cntrlTaskList_ddlNodeAdministrator']";
	static String AdvSearch_SelectProgram = "//select[@id='ctl00_ContentPlaceHolder1_cntrlTaskList_ddlProject']";
	static String AdvSearch_SelectProject = "//select[@id='ctl00_ContentPlaceHolder1_cntrlTaskList_ddlWorkSite']";
	static String SelectStatus_DropDown = "//div/a/span[@class='fltr']/i";
	static String SelectCategory = "//button[normalize-space()='Select Category']";
	static String SearBtn = "//input[@id='btnAdvanceSearch']";
	static String ClsoeBtn = "//button[normalize-space()='Close']";

	public static WebElement AdvSearchBtn(WebDriver driver) {

		element = driver.findElement(By.xpath(AdvSearchBtn));
		return element;
	}

	public static WebElement AdvSearch_BeginDate(WebDriver driver) {

		element = driver.findElement(By.xpath(AdvSearch_BeginDate));
		return element;
	}

	public static WebElement AdvSearch_EndDate(WebDriver driver) {

		element = driver.findElement(By.xpath(AdvSearch_EndDate));
		return element;
	}

	public static WebElement AdvSearch_SelectAdmin(WebDriver driver) {

		element = driver.findElement(By.xpath(AdvSearch_SelectAdmin));
		return element;
	}

	public static WebElement AdvSearch_SelectProgram(WebDriver driver) {

		element = driver.findElement(By.xpath(AdvSearch_SelectProgram));
		return element;
	}

	public static WebElement AdvSearch_SelectProject(WebDriver driver) {

		element = driver.findElement(By.xpath(AdvSearch_SelectProject));
		return element;
	}

	public static WebElement SelectStatus_DropDown(WebDriver driver) {

		element = driver.findElement(By.xpath(SelectStatus_DropDown));
		return element;
	}

	public static WebElement SelectCategory(WebDriver driver) {

		element = driver.findElement(By.xpath(SelectCategory));
		return element;
	}

	public static WebElement SearBtn(WebDriver driver) {

		element = driver.findElement(By.xpath(SearBtn));
		return element;
	}

	public static WebElement ClsoeBtn(WebDriver driver) {

		element = driver.findElement(By.xpath(ClsoeBtn));
		return element;
	}

	static String SelectSortingExpression = "//select[@id='ctl00_ContentPlaceHolder1_cntrlTaskList_ddlSort']";

	public static WebElement SelectSortingExpression(WebDriver driver) {

		element = driver.findElement(By.xpath(SelectSortingExpression));
		return element;
	}
	
	
	static String PreviewPanelSubjectText ="//div[@class='title flft']";
	public static WebElement PreviewPanelSubjectText(WebDriver driver) {

		element = driver.findElement(By.xpath(PreviewPanelSubjectText));
		return element;
	}
	

}
