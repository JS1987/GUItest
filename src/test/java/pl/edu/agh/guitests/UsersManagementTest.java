package pl.edu.agh.guitests;

import static org.junit.Assert.fail;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class UsersManagementTest {
	private WebDriver driver;
	private StringBuffer verificationErrors = new StringBuffer();

	@Before
	public void setUp() throws Exception {
		System.setProperty("webdriver.gecko.driver", "lib/geckodriver.exe");
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

	@Test
	public void testAddingNewUsers() throws Exception {
		driver.get("http://localhost:8000/");
		driver.findElement(By.linkText("Login")).click();
		driver.findElement(By.id("id_login")).click();
		driver.findElement(By.id("id_login")).clear();
		driver.findElement(By.id("id_login")).sendKeys("jnowak");
		driver.findElement(By.id("id_password")).clear();
		driver.findElement(By.id("id_password")).sendKeys("jnowak1234");
		driver.findElement(By.xpath("//input[@value='Login']")).click();

		fail("Test not fully implemented!");
	}

	@Test
	public void testEditUser() throws Exception {
		fail("Not implemented yet!");
	}

	@Test
	public void testRemoveUser() throws Exception {
		fail("Not implemented yet!");
	}

	@After
	public void tearDown() throws Exception {
		driver.quit();
		String verificationErrorString = verificationErrors.toString();
		if (!"".equals(verificationErrorString)) {
			fail(verificationErrorString);
		}
	}

}
