package actions;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class QuerySelectable {

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://jqueryui.com/selectable/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		WebElement frame = driver.findElement(By.className("demo-frame"));
		driver.switchTo().frame(frame);

		WebElement Item2 = driver.findElement(By.xpath("//li[text()='Item 2']"));
		WebElement Item6 = driver.findElement(By.xpath("//li[text()='Item 6']"));

		Actions builder = new Actions(driver);

		builder.clickAndHold(Item2).moveToElement(Item6).release().perform();
		driver.switchTo().defaultContent();
	}

}
