package com.seleniumprograms;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import net.bytebuddy.implementation.bytecode.ByteCodeAppender.Size;

public class Assignment_2 {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\karti\\Downloads\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		driver.get("https://www.flipkart.com/");
		driver.findElement(By.xpath("//input[@class='_2IX_2- VJZDxU']")).sendKeys("sudarshanmali703@gmail.com");
		driver.findElement(By.xpath("//input[@class='_2IX_2- _3mctLh VJZDxU']")).sendKeys("Pass@1999",Keys.ENTER);
		Thread.sleep(3000);
		driver.findElement(By.xpath("//input[@class='_3704LK']")).sendKeys("shoes");
		driver.findElement(By.xpath("//button[@class='L0Z3Pu']")).click();
		driver.findElement(By.xpath("//div[text()='Price -- Low to High']")).click();
		driver.findElement(By.xpath("//a[text()='Running Shoes Running Shoes For Men']")).click();
		
		Set<String> windowHandles = driver.getWindowHandles();
		System.out.println(windowHandles);
		
		Iterator<String> iterator =windowHandles.iterator();
		String parentWindow = iterator.next();
		String childWindow = iterator.next();
	
		driver .switchTo().window(childWindow);	
		driver.findElement(By.xpath("//a[text()='9']")).click();
		driver.findElement(By.xpath("//button[text()='ADD TO CART']")).click();
		
		driver.switchTo().window(parentWindow);
		
		driver.findElement(By.xpath("//a[@title='588 Running Shoes For Men']")).click();
		driver.switchTo().window(childWindow);
		driver.findElement(By.xpath("//a[text()='9']")).click();
		driver.findElement(By.xpath("//button[@class='_2KpZ6l _2U9uOA _3v1-ww']")).click();
			
		driver.findElement(By.xpath("//span[text()='Cart']")).click();
	}
}
