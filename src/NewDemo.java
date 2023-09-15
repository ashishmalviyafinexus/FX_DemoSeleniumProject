import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

public class NewDemo {
  public static void main(String[] args) {
    WebDriver driver = null;
    System.setProperty("webdriver.chrome.driver", "C:/Program Files/chromedriver-win64/chromedriver.exe");
    ChromeOptions options = new ChromeOptions();
    options.addArguments("disable-notifications");
    ///////////////////////////////////
    driver = new ChromeDriver(options);
    driver.manage().window().maximize();
    driver.get(
        "https://c4wprod--preprod.sandbox.lightning.force.com/lightning/o/loan__Loan_Account__c/list?filterName=Recent");
    driver.findElement(By.name("username")).sendKeys("finexus@finexusinc.com.preprod");
    driver.findElement(By.name("pw")).sendKeys("Happy@9902");
    driver.findElement(By.name("Login")).click();

    try {
      Thread.sleep(7000);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    System.out.println("Before frame");
    driver.switchTo().frame(0);
    System.out.println("After frame");
    WebElement checkbox = driver.findElement(By.id("00N6t000005lRKMj_id0_j_id53_loanDetailIframe_chkbox"));
    checkbox.click();
    Actions actions = new Actions(driver);
    actions.doubleClick(checkbox).perform();
    driver.findElement(By.id("00N6t000005lRKMj_id0_j_id53_loanDetailIframe")).click();

    driver.findElement(By.name("inlineEditSave")).click();

    try {
      Thread.sleep(2000);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }
}
