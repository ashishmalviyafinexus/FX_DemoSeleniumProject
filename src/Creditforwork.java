import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

public class Creditforwork {
  public static void main(String[] args) {
    WebDriver driver;
    {
      System.setProperty("webdriver.chrome.driver", "C:/Program Files/chromedriver-win64/chromedriver.exe");

      ChromeOptions options = new ChromeOptions();
      options.addArguments("disable-notifications");

      driver = new ChromeDriver(options);
      driver.manage().window().maximize();
      driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(50));
      driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(100));

      driver.get(
          "https://c4wprod--qa2021.sandbox.lightning.force.com/lightning/r/loan__Loan_Account__c/a1hD4000000lhWCIAY/view");
      driver.findElement(By.name("username")).sendKeys("vaibhavcw@finexusinc.com.qa2021");
      driver.findElement(By.name("pw")).sendKeys("Happy@99020");
      driver.findElement(By.name("Login")).click();
      driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(50));
      driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(150));

      System.out.println("Login Successfull");
      driver.switchTo().frame(0);
      WebElement checkbox = driver.findElement(By.id("00ND400000ADHsBj_id0_j_id53_loanDetailIframe_chkbox"));
      checkbox.click();

      // org.openqa.selenium.interactions.Actions actions = new
      // org.openqa.selenium.interactions.Actions(driver);
      // actions.doubleClick(checkbox).perform();

      // driver.findElement(By.name("inlineEditSave")).click();
      driver.findElement(By.name("inlineEditSave")).click();

      /*
       * driver.findElement(By.id(
       * "00ND400000ADHsBj_id0_j_id53_loanDetailIframe_chkbox")).click();
       * driver.findElement(By.id(
       * "00ND400000ADHsBj_id0_j_id53_loanDetailIframe_chkbox")).click();
       * driver.findElement(By.id(
       * "00ND400000ADHsBj_id0_j_id53_loanDetailIframe_chkbox")).click();
       * driver.findElement(By.id(
       * "00ND400000ADHsBj_id0_j_id53_loanDetailIframe_chkbox")).click();
       * driver.findElement(By.id("00ND400000ADHsBj_id0_j_id53_loanDetailIframe")).
       * click();
       * //driver.findElement(By.xpath(
       * "//*[@id=\"00ND400000ADHsBj_id0_j_id53_loanDetailIframe\"]/checkbox")).click(
       * );
       * System.out.print("Checkbox clicked");
       */

      // Actions actions = new Actions(driver);
      // actions.click(element).click(element).click(element).build().perform();
      System.out.print("Inline edit select");

      // driver.findElement(By.className("inlineEditDiv")).click();

      // driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));

      driver.findElement(By.id("00ND400000ADHsBj_id0_j_id53_loanDetailIframe")).click();
      System.out.print("checkbox clicked");

      // WebElement element =
      // driver.findElement(By.id("00ND400000ADHsBj_id0_j_id53_loanDetailIframe_ileinneredit"));

      // loan__Loan_Account__c lla = new loan__Loan_Account__c();
      // lla.Rounding_Trigger__c = true;
      // Actions actions = new Actions(driver);
      // WebElement element = null;
      // actions.click(element).click(element).click(element).build().perform();
    }
  }
}