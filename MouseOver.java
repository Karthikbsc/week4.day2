package actions;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MouseOver {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://www.leafground.com/pages/mouseOver.html");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		WebElement mOver = driver.findElement(By.xpath("//a[text()='TestLeaf Courses']"));
		Actions builder = new Actions(driver);
		builder.moveToElement(mOver).perform();
		
		
		WebElement selenium = driver.findElement(By.xpath("//a[text()='Selenium']"));
		Actions builder1 = new Actions(driver);
		builder1.moveToElement(selenium).perform();
		selenium.click();
		
		Alert alert = driver.switchTo().alert();
		System.out.println(alert.getText());
		alert.accept();
		Thread.sleep(2000);
		
		WebElement rpa = driver.findElement(By.xpath("//a[text()='RPA']"));
		Actions builder2 = new Actions(driver);
		builder2.moveToElement(rpa).perform();
		rpa.click();
		
		Alert alert2 = driver.switchTo().alert();
		System.out.println(alert2.getText());
		alert2.accept();
		Thread.sleep(2000);
		
		WebElement webServices = driver.findElement(By.xpath("//a[text()='WebServices']"));
		Actions builder3 = new Actions(driver);
		builder3.moveToElement(webServices).perform();
		webServices.click();
		
		Alert alert3 = driver.switchTo().alert();
		System.out.println(alert3.getText());
		alert3.accept();
		Thread.sleep(2000);
	}

}
