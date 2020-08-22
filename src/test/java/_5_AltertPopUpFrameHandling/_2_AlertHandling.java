package _5_AltertPopUpFrameHandling;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class _2_AlertHandling {
	
	WebDriver driver;

	@Before
	public void setUp()
	{
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get("http://demo.automationtesting.in/Alerts.html");
	}

	@Test
	public void dropDown() throws InterruptedException
	{
		WebElement alertTypeSelection = driver.findElement(By.xpath("//a[contains(text(),'Alert with OK & Cancel')]"));
		alertTypeSelection.click();
		
		WebElement alertButton = driver.findElement(By.xpath("//button[contains(text(),'click the button to display a confirm box')]"));
		alertButton.click();
		
		Alert alert = driver.switchTo().alert();
		// To Halt the execution for sometime (demonstration purposes)
		Thread.sleep(2000);
		
		alert.accept();
		//alert.dismiss();

		// Asserting the alert accepted message
		WebElement alertConfirmMessage = driver.findElement(By.xpath("//p[contains(text(),'You pressed Ok')]"));
		Assert.assertEquals("You pressed Ok", alertConfirmMessage.getText());


	}

	@After
	public void teardown() throws InterruptedException
	{
		// To Halt the execution for sometime (demonstration purposes)
		Thread.sleep(3000);
		driver.quit();
	}
	
}
