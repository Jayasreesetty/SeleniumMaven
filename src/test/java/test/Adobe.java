package test;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.bonigarcia.wdm.webdriver.WebDriverBrowser;

public class Adobe {

	@Test(priority=1)
	
	public void Register()
	{
		
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.get("https://account.magento.com/customer/account/create/\r\n"
				+ "");
		driver.manage().window().maximize();
		driver.findElement(By.id("firstname")).sendKeys("Jayasri");
		driver.findElement(By.id("lastname")).sendKeys("Setty");
		driver.findElement(By.id("email_address")).sendKeys("jayasreesetty@gmail.com");
		driver.findElement(By.id("self_defined_company")).sendKeys("yesmsystems");
		Select cp = new Select(driver.findElement(By.id("company_type")));
		System.out.println(cp.isMultiple());
		cp.selectByIndex(2);
		Select role = new Select(driver.findElement(By.id("individual_role")));
		System.out.println(cp.isMultiple());
		role.selectByValue("technical/developer");
		Select country = new Select(driver.findElement(By.id("country")));
		country.selectByValue("AS");
		driver.findElement(By.id("password")).sendKeys("India");
		driver.findElement(By.id("password-confirmation")).sendKeys("India");
		//if(!driver.findElement(By.id("agree_terms")).isSelected())
		driver.switchTo().frame(driver.findElement(By.xpath("//*[@id=\"recaptcha-f979c2ff515d921c34af9bd2aee8ef076b719d03\"]/div/div/iframe")));
		driver.findElement(By.xpath("//*[@id=\"recaptcha-anchor\"]/div[1]")).click();
		driver.switchTo().defaultContent();
		driver.findElement(By.id("agree_terms")).click();
		driver.quit();
			
			
		}
	
	@Test(priority=2)
	
	public void Login()
	{
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.get("http://adobe.com");
		driver.findElement(By.xpath("//*[@id=\"gnt_754\"]/a/span")).click();
		driver.findElement(By.id("EmailPage-EmailField")).sendKeys("yesm@gmail.com");
		driver.findElement(By.xpath("//*[@id=\"EmailForm\"]/section[2]/div[2]/button/span")).click();
		String message = driver.findElement(By.xpath("//*[@id=\"EmailForm\"]/section[1]/label")).getText();
		System.out.println(message);
		if (message.equals("We couldn't find an account with that email address.\n"
				+ "Find your account or create a new account")) {

			System.out.println("True");

		} else {
			System.out.println("False");
		}
		driver.quit();
	}
	@Test
public void otp()
{
	
}

}

