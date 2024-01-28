package ecart;

import java.util.Arrays;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class base {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		System.setProperty("Webdriver.chorme.driver",
				"\"C:\\Users\\win11\\Downloads\\chromedriver_win32\\chromedriver.exe\"");
		ChromeDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
		
		Thread.sleep(2000);
		String[] vegies = { "Cucumber", "Brocolli", "Beetroot" };
		addItems(driver,vegies);
		driver.findElement(By.cssSelector(" img[alt='Cart']")).click();
		driver.findElement(By.xpath("//button[contains(text(),'PROCEED TO CHECKOUT')]")).click();
		driver.findElement(By.cssSelector("input.promocode")).sendKeys("rahulshettyacademy");
		driver.findElement(By.cssSelector("button.promobtn")).click();
		//explicit wait
		
		
		System.out.println(driver.findElement(By.cssSelector("span.promoInfo")).getText());
		
	}

	public static void addItems(WebDriver driver,String[] vegies) {
		int j = 0;
		
		List<WebElement> products = driver.findElements(By.cssSelector("h4.product-name"));
		for (int i = 0; i < products.size(); i++) {
			String[] name = products.get(i).getText().split("-");
			String formatName = name[0].trim();

			List itemNeeded = Arrays.asList(vegies);

			if (itemNeeded.contains(formatName)) {
				j++;
				driver.findElements(By.xpath("//div[@class='product-action']")).get(i).click();
				if (j == 3) {
					break;
				}

			}

		}

	}
}
