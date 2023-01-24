package usingTestNgParameters;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class bothCorrect {
	@Test
	@Parameters({"username","password"})
	public void bothcorrectcase(String uName, String pWord) {
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
