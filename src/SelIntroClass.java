import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class SelIntroClass {
    public static void main(String[] args) {
        
        System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\chromedriver-win64\\chromedriver.exe");
        Map<String, Object> prefs = new HashMap<String, Object>();

        prefs.put("profile.default_content_setting_values.notifications", 2);
        ChromeOptions options = new ChromeOptions();
        options.setExperimentalOption("prefs", prefs);
        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        driver.get("https://login.salesforce.com");
        String username = "ashish@fiademotesting.com";
        String password = "p@$$w0rd";
        WebElement usernameElement = driver.findElement(By.id("username"));
        WebElement passwordElement = driver.findElement(By.id("password"));
        WebElement loginButton = driver.findElement(By.id("Login"));

        usernameElement.sendKeys(username);
        passwordElement.sendKeys(password);
        loginButton.click();

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        driver.get("https://fiademotesting-dev-ed.develop.lightning.force.com/lightning/o/Contact/list?filterName=00BDo0000059wMlMAI");
        
        WebElement checkbox = driver.findElement(By.className("slds-align_absolute-center"));
//        WebElement checkbox = driver.findElement(By.xpath("slds-align_absolute-center"));
//        WebElement checkbox = driver.findElement(By.className("slds-align_absolute-center"));
//        WebElement checkbox = driver.findElement(By.className("slds-align_absolute-center"));
          checkbox.click();
       
        
        //driver.close();

           
        }

}
