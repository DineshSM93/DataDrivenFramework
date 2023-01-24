package usingJxlLibrary;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

public class DataprovidesusingJXL {
	String [][] data = null;
	@DataProvider(name="loginData")
	public String[][] loginDataProvider() throws BiffException, IOException {
		data = getExcelData();
		return data;
	}
	
	public String[][] getExcelData() throws BiffException, IOException {
		FileInputStream excel = new FileInputStream("C:\\Users\\zenuser\\Downloads\\Book1.xls");
		Workbook workbook = Workbook.getWorkbook(excel);
		Sheet sheet = workbook.getSheet(0);
		int rowcount = sheet.getRows();
		int columncount = sheet.getColumns();
		String testData[][] = new String[rowcount-1][columncount];
		for(int i=1; i<rowcount; i++) {
			for(int j=0; j<columncount; j++) {
				testData[i-1][j]=sheet.getCell(j, i).getContents();
			}
		}
		return testData;
	}
	
	@Test(dataProvider = "loginData")
	public void logintest(String uName, String pWord) {
		System.setProperty("webdriver.chrome.driver", "D:\\ChromeDriver\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("http://automationpractice.com/index.php?controller=authentication&back=my-account");
		
		WebElement usernmae = driver.findElement(By.id("email"));
		usernmae.sendKeys(uName);
		WebElement password = driver.findElement(By.id("passwd"));
		password.sendKeys(pWord);
		WebElement login = driver.findElement(By.xpath("//*[@id=\"SubmitLogin\"]/span"));
		login.click();
		driver.quit();
	}
}
