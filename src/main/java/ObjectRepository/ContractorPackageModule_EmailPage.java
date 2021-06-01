package ObjectRepository;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ContractorPackageModule_EmailPage {

	private static WebElement element;
	private static List<WebElement> listElement;
	
	

	static String To_EmailFeild = "//input[@id='token-input-txt_ToEmail']";
	static String Email_SubjectFeild ="//input[@id='txt_Subject']";
	static String SendandCloseBtn ="//input[@id='btnSend']";
	static String closebtn ="//button[normalize-space()='Close']";
	static String GroupsBtn ="//a[normalize-space()='Groups']";
	

	public static WebElement To_EmailFeild(WebDriver driver) {
		element = driver.findElement(By.xpath(To_EmailFeild));
		return element;
	}
	

	public static WebElement Email_SubjectFeild(WebDriver driver) {
		element = driver.findElement(By.xpath(Email_SubjectFeild));
		return element;
	}
	
	public static WebElement SendandCloseBtn(WebDriver driver) {
		element = driver.findElement(By.xpath(SendandCloseBtn));
		return element;
	}
	public static WebElement closebtn(WebDriver driver) {
		element = driver.findElement(By.xpath(closebtn));
		return element;
	}
	public static WebElement GroupsBtn(WebDriver driver) {
		element = driver.findElement(By.xpath(GroupsBtn));
		return element;
	}
	
	
	
	

}
