package pl.edu.agh.guitests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
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
		driver.get("http://127.0.0.1:8000/");
	    driver.findElement(By.linkText("Login")).click();
	    driver.findElement(By.id("id_login")).click();
	    driver.findElement(By.id("id_login")).clear();
	    driver.findElement(By.id("id_login")).sendKeys("akowalska");
	    driver.findElement(By.id("id_password")).click();
	    driver.findElement(By.id("id_password")).clear();
	    driver.findElement(By.id("id_password")).sendKeys("akowalska1234");
	    driver.findElement(By.xpath("//input[@value='Login']")).click();
	    driver.findElement(By.id("id_create_button")).click();
	    driver.findElement(By.id("id_first_name")).click();
	    driver.findElement(By.id("id_first_name")).clear();
	    driver.findElement(By.id("id_first_name")).sendKeys("Janusz");
	    driver.findElement(By.id("id_last_name")).clear();
	    driver.findElement(By.id("id_last_name")).sendKeys("Janusz");
	    driver.findElement(By.id("id_login")).clear();
	    driver.findElement(By.id("id_login")).sendKeys("Janusz");
	    driver.findElement(By.id("id_password")).clear();
	    driver.findElement(By.id("id_password")).sendKeys("Janusz1234");
	    driver.findElement(By.id("id_email")).clear();
	    driver.findElement(By.id("id_email")).sendKeys("janusz@gmail.com");
	    driver.findElement(By.xpath("//input[@value='Save']")).click();
	    driver.findElement(By.xpath("//button[@type='button']")).click();
	    driver.findElement(By.linkText("Logout")).click();
	    assertEquals("janusz@gmail.com", driver.findElement(By.xpath("//td[5]")).getText());
	    assertEquals("Janusz", driver.findElement(By.xpath("//td[4]")).getText());
	    assertEquals("Janusz", driver.findElement(By.xpath("//td[3]")).getText());
	    assertEquals("Janusz", driver.findElement(By.xpath("//td[2]")).getText());
	  
	}

	
	
	@Test
	public void testEditUser() throws Exception {
		driver.get("http://127.0.0.1:8000/");
	    driver.findElement(By.linkText("Login")).click();
	    driver.findElement(By.id("id_login")).click();
	    driver.findElement(By.id("id_login")).clear();
	    driver.findElement(By.id("id_login")).sendKeys("akowalska");
	    driver.findElement(By.id("id_password")).click();
	    driver.findElement(By.id("id_password")).clear();
	    driver.findElement(By.id("id_password")).sendKeys("akowalska1234");
	    driver.findElement(By.xpath("//input[@value='Login']")).click();
	    driver.findElement(By.id("id_edit_button_1")).click();
	    driver.findElement(By.id("id_last_name")).click();
	    driver.findElement(By.id("id_last_name")).clear();
	    driver.findElement(By.id("id_last_name")).sendKeys("Nowak123");
	    driver.findElement(By.xpath("//input[@value='Save']")).click();
	    driver.findElement(By.xpath("//button[@type='button']")).click();
	    driver.findElement(By.linkText("Logout")).click();
	}

	@Test
	public void testRemoveUser() throws Exception {
		driver.get("http://127.0.0.1:8000/");
	    driver.findElement(By.linkText("Login")).click();
	    driver.findElement(By.id("id_login")).click();
	    driver.findElement(By.id("id_login")).clear();
	    driver.findElement(By.id("id_login")).sendKeys("akowalska");
	    driver.findElement(By.id("id_password")).clear();
	    driver.findElement(By.id("id_password")).sendKeys("akowalska1234");
	    driver.findElement(By.xpath("//input[@value='Login']")).click();
	    driver.findElement(By.id("id_delete_button_3")).click();
	    driver.findElement(By.xpath("//button[@type='button']")).click();
	    driver.findElement(By.linkText("Logout")).click();
	    // Warning: assertTextNotPresent may require manual changes
	    assertFalse(driver.findElement(By.cssSelector("BODY")).getText().matches("^[\\s\\S]*Janusz[\\s\\S]*$"));
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
