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

public class TestSessionID {
    public static void main(String[] args) {
        WebDriver driver = null;
        //System.setProperty("webdriver.chrome.driver", "C:/Program Files/chromedriver-win64/chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("disable-notifications");
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.get("https://c4wprod--preprod.sandbox.lightning.force.com/lightning/o/loan__Loan_Account__c/list?filterName=Recent");
        driver.findElement(By.name("username")).sendKeys("finexus@finexusinc.com.preprod");
        driver.findElement(By.name("pw")).sendKeys("Happy@9902");
        driver.findElement(By.name("Login")).click();

        // Read the Excel file containing IDs
        String excelFilePath = "C:/Users/ashis/Pictures/Screenshots/C4W_CLcontracts_List.xlsx"; // Replace with the actual path to your Excel file
        String sheetName = "Sheet5"; // Replace with the actual sheet name
        String[] ids = readIdsFromExcel(excelFilePath, sheetName);

        for (String id : ids) {
        	String url = "https://c4wprod--preprod.sandbox.lightning.force.com/lightning/r/loan__Loan_Account__c/" + id + "/view";
        	driver.get(url);
            performLoanActions(driver);}
    }

    public static String[] readIdsFromExcel(String filePath, String sheetName) {
        try {
            FileInputStream fis = new FileInputStream(new File(filePath));
            XSSFWorkbook workbook = new XSSFWorkbook(fis);
            Sheet sheet = workbook.getSheet(sheetName);
            int rowCount = sheet.getLastRowNum() - sheet.getFirstRowNum();
            String[] ids = new String[rowCount];
            int index = 0;

            for (int i = 1; i <= rowCount; i++) { // Assuming the IDs are in the second row (1-based index)
                Row row = sheet.getRow(i);
                String id = row.getCell(0).getStringCellValue(); // Assuming the ID is in the first column (0-based index)
                ids[index++] = id;
            }
            workbook.close();
            fis.close();
            return ids;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static void performLoanActions(WebDriver driver){
        
        try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
        //System.out.println("Before frame");
        driver.switchTo().frame(0);
        //System.out.println("After frame");
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
