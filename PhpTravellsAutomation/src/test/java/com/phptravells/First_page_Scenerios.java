package com.phptravells;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.chrome.ChromeDriver;

public class First_page_Scenerios {

	
	public static void main(String[] args) {

		System.setProperty("webdriver.chrome.driver","C:\\Users\\mohit.jaiswal\\Desktop\\Selenium\\selenium\\lib\\chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();

		driver.get("https://www.phptravels.net/");

		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();

		driver.findElement(By.xpath("(//a[@href=\"javascript:void(0);\"])[3]")).click();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.findElement(By.xpath("(//a[text()=' Login'])[2]")).click();
		driver.findElement(By.xpath("//input[@placeholder=\"Email\"]")).sendKeys("user@phptravels.com");
		driver.findElement(By.xpath("//input[@type=\"password\"]")).sendKeys("demouser");
		driver.findElement(By.xpath("//button[text()='Login']")).click();
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.findElement(By.xpath("/html/body/nav/div/div[2]/ul[1]/li[4]/a/span")).click();
		driver.findElement(By.xpath("(//span[@class=\"select2-chosen\"])[2]")).click();

		driver.findElement(By.xpath("//*[@id=\"select2-drop\"]/div/input")).sendKeys("Manchester");//pick_cation
		driver.findElement(By.xpath("//*[@id=\"select2-drop\"]/ul/li/div/span")).click();
		driver.findElement(By.xpath("//input[@id=\"departcar\"]")).click();
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.findElement(By.xpath("//*[@id=\"departcar\"]")).clear();
		driver.findElement(By.xpath("//*[@id=\"departcar\"]")).sendKeys("10/09/2019");//date1
		driver.findElement(By.xpath("//select[@name=\"pickupTime\"]")).click();

		driver.findElement(By.xpath("(//option[@value=\"16:30\"])[1]")).click();//time1
		driver.findElement(By.xpath("//select[@name=\"pickupTime\"]")).click();


		driver.findElement(By.xpath("//input[@placeholder=\"Drop off Date\"]")).clear();//date2
		driver.findElement(By.xpath("//input[@placeholder=\"Drop off Date\"]")).sendKeys("11/09/2019");
		driver.findElement(By.xpath("//input[@placeholder=\"Drop off Date\"]")).click();


		driver.findElement(By.xpath("//*[@id=\"cars\"]/form/div[6]/div/select")).click();//time2
		driver.findElement(By.xpath("(//option[@value=\"17:00\"])[2]")).click();
		driver.findElement(By.xpath("//*[@id=\"cars\"]/form/div[6]/div/select")).click();

		driver.findElement(By.xpath("//*[@id=\"cars\"]/form/div[7]/button")).click();//search




		driver.findElement(By.xpath("//button[text()='Details']")).click();//details
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,1000)");
		driver.findElement(By.xpath("//button[text()='Book Now']")).click();//booknow
		JavascriptExecutor jss = (JavascriptExecutor) driver;
		jss.executeScript("window.scrollBy(0,1000)");

		driver.findElement(By.xpath("//button[text()='CONFIRM THIS BOOKING']")).click();// confirm this booking
		try {
			Thread.sleep(30000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.findElement(By.xpath("//button[text()='Pay on Arrival']")).click();//Pay on Arrival
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.switchTo().alert().accept();// alert
	
	}}


