package pl.edu.agh.guitests;

import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.junit.*;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class AddDataToDatabase {
  private WebDriver driver;
  private String baseUrl;
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();

  @Before
  public void setUp() throws Exception {
    driver = new FirefoxDriver();
    baseUrl = "https://www.katalon.com/";
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  }

  @Test
  public void testAddDataToDatabase() throws Exception {
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

  @After
  public void tearDown() throws Exception {
    driver.quit();
    String verificationErrorString = verificationErrors.toString();
    if (!"".equals(verificationErrorString)) {
      fail(verificationErrorString);
    }
  }

  private boolean isElementPresent(By by) {
    try {
      driver.findElement(by);
      return true;
    } catch (NoSuchElementException e) {
      return false;
    }
  }

  private boolean isAlertPresent() {
    try {
      driver.switchTo().alert();
      return true;
    } catch (NoAlertPresentException e) {
      return false;
    }
  }

  private String closeAlertAndGetItsText() {
    try {
      Alert alert = driver.switchTo().alert();
      String alertText = alert.getText();
      if (acceptNextAlert) {
        alert.accept();
      } else {
        alert.dismiss();
      }
      return alertText;
    } finally {
      acceptNextAlert = true;
    }
  }
}
