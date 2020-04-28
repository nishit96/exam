package practise.pr;

import static org.testng.Assert.assertEquals;

import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class AppTest
{
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver","D:\\drivers\\chromedriver.exe");
	    ChromeDriver c=new ChromeDriver();
		c.manage().window().maximize();
		c.get("http://cookbook.seleniumacademy.com/Config.html");
		//c.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		Select drop=new Select(c.findElement(By.xpath("/html/body/div/div/div[1]/p[1]/select")));
		drop.selectByVisibleText("Audi");
        WebElement radio1 = c.findElement(By.xpath("/html/body/div/div/div[1]/p[2]/input[1]"));
        WebElement radio2 = c.findElement(By.xpath("/html/body/div/div/div[1]/p[2]/input[2]"));
        radio1.click();
        WebElement option1 = c.findElement(By.xpath("/html/body/div/div/div[1]/p[3]/input[1]"));
        WebElement option2 = c.findElement(By.xpath("/html/body/div/div/div[1]/p[3]/input[2]"));
        WebElement option3 = c.findElement(By.xpath("/html/body/div/div/div[1]/p[3]/input[3]"));
        WebElement option4 = c.findElement(By.xpath("/html/body/div/div/div[1]/p[3]/input[4]"));
        option1.click();
        option2.click();
        Select col=new Select(c.findElement(By.xpath("/html/body/div/div/div[1]/p[4]/select")));
        col.selectByIndex(0);
        col.selectByIndex(1);
        c.findElement(By.xpath("/html/body/div/div/div[1]/button[2]")).click();
        String main=c.getWindowHandle(); 
        Set<String> ids=c.getWindowHandles();
		Iterator<String> it=ids.iterator();
		//String main=it.next();
		String first=it.next();
		Thread.sleep(5000);
		c.switchTo().window(first);
		String actualTitle = c.getTitle();
        System.out.println("ActualTitle is "+actualTitle);
        String expectedTitle = "Title of Page";
        assertEquals(expectedTitle,actualTitle);
        Thread.sleep(10000);
        c.findElement(By.xpath("/html/body/div/input")).click();
        Thread.sleep(10000);
        c.switchTo().window(main);
        c.close();
	}

}

