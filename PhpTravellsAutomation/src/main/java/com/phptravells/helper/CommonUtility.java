package com.phptravells.helper;

import java.time.Duration;

import java.util.List;
import java.util.function.Function;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;


public class CommonUtility {

	static WebDriver driver;
	/**
	 * method click the Element using the fluent wait concepts ignoring the ElementClickInterceptedException.
	 * @param driver
	 * @param xpath
	 */

	public static void clickElement(WebDriver driver,final String xpath) {
		FluentWait<WebDriver> fluentWait= new FluentWait<WebDriver>(driver)
				.ignoring(ElementClickInterceptedException.class).pollingEvery(Duration.ofMillis(1000))
				.withTimeout(Duration.ofMillis(30000));
		fluentWait.until(new Function<WebDriver, Boolean>() {
			public Boolean apply(WebDriver driver) {
				WebElement element= driver.findElement(By.xpath(xpath));
				element.click();
				return true;
			}


		});



	}
	/**
	 * method takes parameter as
	 * @param driver
	 * @param xpath
	 * @param timeOut
	 * @param text
	 * and select the items from the drop down.
	 */

	public static void selectDropdown(WebDriver driver, final String xpath,int timeOut,final String text) {
		FluentWait<WebDriver> fluentWait= new FluentWait<WebDriver>(driver).pollingEvery(Duration.ofMillis(1000))
				.withTimeout(Duration.ofMillis(30000));
		fluentWait.until(new Function<WebDriver, Boolean>() {
			public Boolean apply(WebDriver driver) {
				WebElement element =driver.findElement(By.xpath(xpath));
				Select select= new Select(element);

				select.selectByVisibleText(text);
				return true;
			}

		});
	}
	/**
	 * method click the blank fields and send the text to be entered
	 * @param driver
	 * @param xpath
	 * @param timeOutInSeconds
	 * @param text
	 */
	public static void clickAndSendText(WebDriver driver, final String xpath,int timeOutInSeconds, final String text) {
		FluentWait<WebDriver> fluentWait = new FluentWait<WebDriver>(driver)
				.ignoring(ElementClickInterceptedException.class).pollingEvery(Duration.ofMillis(1000))
				.withTimeout(Duration.ofMillis(30000));

		fluentWait.until(new Function<WebDriver, Boolean>() {
			public Boolean apply(WebDriver driver) {
				WebElement element = driver.findElement(By.xpath(xpath));
				element.sendKeys(text);
				element.click();
				return true;
			}
		});
	}

	

	/**
	 * method takes parameters as
	 * @param driver
	 * @param xpath
	 * @param timeOutInSeconds
	 * @param text
	 * and get the text of the web element
	 */
	public static String getText(WebDriver driver,final String xpath) {
		FluentWait<WebDriver> fluentWait= new FluentWait<WebDriver>(driver)
				.ignoring(ElementClickInterceptedException.class).pollingEvery(Duration.ofMillis(1000))
				.withTimeout(Duration.ofMillis(30000));
		return fluentWait.until(new Function<WebDriver, String>() {
			public String apply(WebDriver driver) {
				WebElement element= driver.findElement(By.xpath(xpath));
				String text =element.getText();
				return text;
			}


		});
	}

	/**
	 * method takes parameter as 
	 * @param driver
	 * @param xpath
	 * @param text
	 * @return WebElement
	 */
	public static WebElement getElement(WebDriver driver, String xpath, String text) {

		WebElement element = driver.findElement(By.xpath(xpath));
		element.sendKeys(text);
		return element;
	}

	/**
	 * method takes parameters as
	 * 
	 * @param driver
	 * @param XPathIsDisplayed
	 * @return a boolean value for the displayed element on the web page
	 */
	public static boolean isDisplayed(WebDriver driver, String XPathIsDisplayed) {
		boolean isDisplayed = false;
		try {
			isDisplayed = driver.findElement(By.xpath(XPathIsDisplayed)).isDisplayed();
		} catch (Exception e) {
			isDisplayed = false;
		}
		return isDisplayed;
	}



	public static void clearElement(WebDriver driver,final String xpath) {
		FluentWait<WebDriver> fluentWait= new FluentWait<WebDriver>(driver)
				.ignoring(ElementClickInterceptedException.class).pollingEvery(Duration.ofMillis(1000))
				.withTimeout(Duration.ofMillis(30000));
		fluentWait.until(new Function<WebDriver, Boolean>() {
			public Boolean apply(WebDriver driver) {
				WebElement element= driver.findElement(By.xpath(xpath));
				element.clear();
				return true;
			}
		});
	}


	/**
	 * method takes parameters as
	 * 
	 * @param driver
	 * @param xpath  and uses the explicit wait concept
	 * @return a boolean value after checking the visibility of the.
	 */
	public static boolean isElementVisible(WebDriver driver, String xpath) {

		WebDriverWait wait = new WebDriverWait(driver, 30);
		try {
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
		} catch (Exception exception) {

			return false;
		}
		return true;
	}
	/**
	 * method takes parameters as
	 * 
	 * @param driver
	 * @param xpath
	 * @return the list of elements
	 */

	public static List<WebElement> getElementsList(WebDriver driver, final String xpath) {

		List<WebElement> element = driver.findElements(By.xpath(xpath));
		return element;
	}
	/**
	 * method scroll down the window on the web page
	 * @param driver
	 */

	/**
	 * the method takes parameter as 
	 * @param driver
	 * @param byResolution
	 * and scroll down the window.
	 */
	public static void scrollDownPage(WebDriver driver,int byResolution) {

		JavascriptExecutor js = (JavascriptExecutor) driver;
		String scroll= "window.scrollBy(0,"+byResolution+")";
		js.executeScript(scroll);

	}
	public static  void scrollToElement(WebDriver driver,String xpath) {
		WebElement element= driver.findElement(By.xpath(xpath));
		JavascriptExecutor js= (JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView();", element);
	}



	public static void wait(int timeOut)
	{
		try {
			Thread.sleep(timeOut);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


	/**
	 * 
	 * @param actual
	 * @param expected
	 * @param message
	 */
	public void verify(String actual , String expected , String message) {
		try {


			Assert.assertEquals(actual, expected, message);
			System.out.println("passed");

		} catch (AssertionError e) {
			System.out.println(message);
		}
	}
	public static String removeINR(String cost) {
		cost=cost.replace("INR ", "");
		return cost;
	}


}

