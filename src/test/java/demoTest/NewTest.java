package demoTest;

import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.testng.annotations.BeforeClass;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterClass;

public class NewTest {
	WebDriver driver;
	@BeforeClass
	public void launchApplication() {
		System.setProperty("webdriver.chrome.driver", "/home/manzoormehadi/StackRoute/Training Workspace/CGI/Wave9/Jar Files/chromedriver_linux64/chromedriver");
		driver = new ChromeDriver();
		driver.get("http://demowebshop.tricentis.com/");
		driver.manage().window().maximize();
	}
	@Test
	public void login() {
		driver.findElement(By.linkText("Log in")).click();
		driver.findElement(By.id("Email")).sendKeys("manz@mass.com");
		driver.findElement(By.id("Password")).sendKeys("mass123");
		driver.findElement(By.xpath("//input[@value='Log in']")).click();
		String expected="manz@mass.com";
		String actual =driver.findElement(By.linkText("manz@mass.com")).getText();
		assertEquals(expected, actual);
	}
	@Test
	public void logout() {
		driver.findElement(By.linkText("Log out")).click();
		String expectedLink="Log in";
		String actualLink=driver.findElement(By.linkText("Log in")).getText();
		assertEquals(actualLink, expectedLink);
	}
	@AfterClass
	public void closeApplication() {
		driver.close();
	}

}
