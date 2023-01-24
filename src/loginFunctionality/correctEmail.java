package loginFunctionality;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class correctEmail {
	@Test
	public void correctemailcase() {
		System.setProperty("webdriver.chrome.driver", "D:\\ChromeDriver\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("http://automationpractice.com/index.php?controller=authentication&back=my-account");
		
		WebElement usernmae = driver.findElement(By.id("email"));
		usernmae.sendKeys("dinesh.m@zenitus.com");
		WebElement password = driver.findElement(By.id("passwd"));
		password.sendKeys("SMdinesh@08088");
		WebElement login = driver.findElement(By.xpath("//*[@id=\"SubmitLogin\"]/span"));
		login.click();
		driver.quit();
	}

}
