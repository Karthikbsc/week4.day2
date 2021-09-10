package week4.classroom;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Nykaa {

	public static void main(String[] args) throws InterruptedException {

		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://www.nykaa.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		WebElement brands = driver.findElement(By.xpath("//a[text()='brands']"));
		Actions builder = new Actions(driver);
		builder.moveToElement(brands).perform();

		WebElement popular = driver.findElement(By.xpath("//a[text()='Popular']"));
		Actions builder1 = new Actions(driver);
		builder1.moveToElement(popular).perform();

		driver.findElement(By.xpath("//img[@src=\"https://adn-static2.nykaa.com/media/wysiwyg/2019/lorealparis.png\"]"))
				.click();
		System.out.println(driver.getTitle());
		Set<String> windowHandles = driver.getWindowHandles();
		List<String> window1 = new ArrayList<String>(windowHandles);
		driver.switchTo().window(window1.get(1));

		WebElement title = driver.findElement(By.tagName("h1"));
		// System.out.println(title.getText());

		if (driver.findElement(By.tagName("h1")).equals(title)) {
			System.out.println("Entering to L'OREAL PARIS");

		} else {
			System.out.println("Wrongly redirecting");

		}

		driver.findElement(By.xpath("//span[text()='Sort By : ']")).click();
		driver.findElement(By.xpath("//span[text()='customer top rated']")).click();

		driver.findElement(By.xpath("//div[text()='Category']")).click();
		driver.findElement(By.xpath("//span[text()='Hair']")).click();
		driver.findElement(By.xpath("//span[text()='Hair Care']")).click();
		driver.findElement(By.xpath("//span[text()='Shampoo']")).click();

		if (driver.findElement(By.xpath("//span[text()='filters applied']")).isEnabled()) {
			System.out.println("Filters Appiled");
		} else {
			System.out.println("Filter Not Applied");
		}
		Thread.sleep(2000);

		driver.findElement(By.xpath("//img[@alt=\"L'Oreal Paris Long Hair Dreams\"]")).click();
		Set<String> windowHandles2 = driver.getWindowHandles();
		List<String> window2 = new ArrayList<String>(windowHandles2);
		driver.switchTo().window(window2.get(2));

		WebElement price = driver.findElement(By.className("post-card__content-price-offer"));
		System.out.println("MRP : " + price.getText());

		driver.findElement(By.xpath("//button[@class=\"combo-add-to-btn prdt-des-btn js--toggle-sbag nk-btn nk-btn-rnd atc-bundle m-content__product-list__cart-btn  \"]")).click();
		Thread.sleep(1000);

		driver.findElement(By.className("AddBagIcon")).click();
		Thread.sleep(1000);

		WebElement grandTotal = driver.findElement(By.xpath("//div[@class=\"value medium-strong\"]"));
		String text = grandTotal.getText();
		String replaceAll = text.replaceAll("[^0-9]", "");
		int gT = Integer.parseInt(replaceAll);
		System.out.println("Grand Total : " + gT);

		driver.findElement(By.xpath("//span[text()='Proceed']")).click();

		driver.findElement(By.xpath("//button[text()='CONTINUE AS GUEST']")).click();

		WebElement finalPrice = driver.findElement(By.xpath("(//div[@class=\'value\'])[2]"));
		String text2 = finalPrice.getText();
		String replaceAll2 = text2.replaceAll("[^0-9]", "");
		int fP = Integer.parseInt(replaceAll2);
		System.out.println("Final Price : " + fP);

		if (fP == gT) {
			System.out.println("Both are same amount");
		} else {
			System.out.println("Amount Differs");
			
			driver.close();

		}

	}
}