package week4.classroom;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Myntra {

	public static void main(String[] args) throws InterruptedException, IOException {

		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://www.myntra.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		WebElement webMen = driver.findElement(By.xpath("//a[text()='Men']"));
		Actions builder = new Actions(driver);
		builder.moveToElement(webMen).perform();

		driver.findElement(By.xpath("//a[text()='Jackets']")).click();

		WebElement webCount = driver.findElement(By.xpath("//span[@class=\"title-count\"]"));
		String count = webCount.getText();

		String repItem = count.replaceAll("[^0-9]", "");
		int countFinal = Integer.parseInt(repItem);
		System.out.println("Total Count is : " + countFinal);

		WebElement jackets = driver.findElement(By.xpath("//span[@class=\"categories-num\"]"));
		String text = jackets.getText();

		String repItem1 = text.replaceAll("[^0-9]", "");
		int countFinal1 = Integer.parseInt(repItem1);
		System.out.println("Number of Jackets : " + countFinal1);

		WebElement rainJackets = driver.findElement(By.xpath("(//span[@class='categories-num'])[2]"));
		String text2 = rainJackets.getText();

		String repItem2 = text2.replaceAll("[^0-9]", "");
		int countFinal2 = Integer.parseInt(repItem2);
		System.out.println("Number of Rain Jackets : " + countFinal2);

		int sum = countFinal1 + countFinal2;
		if (sum == countFinal) {
			System.out.println("Matches");
		}else
			System.out.println("Not Matches");

		driver.findElement(By.xpath("(//div[@class=\"common-checkboxIndicator\"])[1]")).click();
		driver.findElement(By.xpath("//div[@class=\"brand-more\"]")).click();
		driver.findElement(By.xpath("//input[@placeholder=\"Search brand\"]")).sendKeys("Duke");
		driver.findElement(By.xpath("(//span[@class='FilterDirectory-count']/following-sibling::div)[1]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//span[@class=\"myntraweb-sprite FilterDirectory-close sprites-remove\"]")).click();

		List<WebElement> duke = driver.findElements(By.tagName("h3"));
		
		int size = duke.size();
		System.out.println("No of Duke items : "+size);
		
		for (int i = 0; i < size; i++) {
			String text3 = duke.get(i).getText();
			
			if (text3.contains("Duke")) {
				System.out.println("Product is a Duke");
			} else {
				System.out.println("Not a Duke Product");
		}}
		
		
		List<String> offer = new ArrayList<String>();
		System.out.println("***Discount***");
		List<WebElement> discount = driver.findElements(By.xpath("//span[@class=\"product-discountPercentage\"]"));
		for (WebElement discountList : discount) {
			String text4 = discountList.getText();
			System.out.println(text4);
			offer.add(text4);
			
		}
		
		WebElement recommended = driver.findElement(By.xpath("//span[text()=\"Recommended\"]"));
		Actions builder1 = new Actions(driver);
		builder1.moveToElement(recommended).perform();
		
		driver.findElement(By.xpath("//label[text()=\"Better Discount\"]")).click();
		
		WebElement firstElement = driver.findElement(By.xpath("//span[@class=\"product-discountedPrice\"]"));
		String duke1 = firstElement.getText();
		System.out.println("First displayed item : "+duke1);
		
		driver.findElement(By.xpath("//img[@alt='Duke Men Purple Solid Bomber Jacket']")).click();
		Set<String> windowHandles = driver.getWindowHandles();
		List<String> windowHandle = new ArrayList<String>(windowHandles);
		driver.switchTo().window(windowHandle.get(1));
		
		File srcFile = driver.getScreenshotAs(OutputType.FILE);
		File destFile = new File(".snaps/Duke.png");
		FileUtils.copyFile(srcFile, destFile);
		
		driver.findElement(By.xpath("//span[text()=\"WISHLIST\"]")).click();
		
		driver.quit();
	}
}
