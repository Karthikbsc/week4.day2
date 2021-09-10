package actions;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Sortable {

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://www.leafground.com/pages/sortable.html");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		WebElement item1 = driver.findElement(By.xpath("//li[text()[normalize-space()='Item 1']]"));

		WebElement item4 = driver.findElement(By.xpath("//li[text()[normalize-space()='Item 4']]"));

		Point location = item4.getLocation();
		int x = location.getX();
		int y = location.getY();

		Actions builder = new Actions(driver);

		builder.dragAndDropBy(item1, x, y).perform();

	}

}
