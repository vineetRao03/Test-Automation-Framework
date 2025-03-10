package com.utility;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.text.SimpleDateFormat;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.constants.Browser;

public abstract class BrowserUtility {

	private static ThreadLocal<WebDriver> driver = new ThreadLocal<WebDriver>();
	Logger logger = LoggerUtility.getlogger(this.getClass());
	private WebDriverWait wait;

	public WebDriver getDriver() { // getter method for the driver variable.
		return driver.get();
	}

	/* Instance variable created above so, we need a constructor to Initialize it */

	public BrowserUtility(WebDriver driver) {
		super();
		this.driver.set(driver);

		wait = new WebDriverWait(driver, Duration.ofSeconds(30L));
	}

//	public BrowserUtility(String browserName) {
//
//		logger.info("Launching browser for " + browserName);
//		if (browserName.equalsIgnoreCase("chrome")) {
//
//			driver.set(new ChromeDriver());
//	     wait= new WebDriverWait(driver.get(), Duration.ofSeconds(30L));

//		} else if (browserName.equalsIgnoreCase("edge")) {
//			driver.set(new EdgeDriver());
//		} else {
//			logger.error("Invalid Browser name....Please Select chrome or egde only!!");
//
//			System.err.println("Invalid Browser name....Please Select chrome or egde only!!");
//		}
//
//	}
//
//	public BrowserUtility(Browser browserName) {
//
//		logger.info("Launching browser for " + browserName);
//
//		if (browserName == Browser.CHROME) {
//			driver.set(new ChromeDriver());
//		} else if (browserName == Browser.EDGE) {
//			driver.set(new EdgeDriver());
//		} else if (browserName == Browser.FIREFOX) {
//			driver.set(new FirefoxDriver());
//		}
//
//	}

	public BrowserUtility(Browser browserName, boolean isHeadless) {

		logger.info("Launching browser for " + browserName);

		if (browserName == Browser.CHROME) {
			if (isHeadless) {
				ChromeOptions options = new ChromeOptions();
				options.addArguments("--headless=new");
				options.addArguments("--window-size=1920,1080");
				driver.set(new ChromeDriver(options));
				wait = new WebDriverWait(driver.get(), Duration.ofSeconds(30L));
			} else {
				driver.set(new ChromeDriver());
				wait = new WebDriverWait(driver.get(), Duration.ofSeconds(30L));
			}

		} else if (browserName == Browser.EDGE) {
			if (isHeadless) {
				EdgeOptions options = new EdgeOptions();
				options.addArguments("--headless=new");
				options.addArguments("--disable-gpu");
				options.addArguments("--no-sandbox");
				options.addArguments("--disable-dev-shm-usage");
				wait = new WebDriverWait(driver.get(), Duration.ofSeconds(30L));
				driver.set(new EdgeDriver(options));
			} else {
				driver.set(new EdgeDriver());
				wait = new WebDriverWait(driver.get(), Duration.ofSeconds(30L));
			}

		} else if (browserName == Browser.FIREFOX) {
			if (isHeadless) {
				FirefoxOptions options = new FirefoxOptions();
				options.addArguments("--headless=old");
				driver.set(new FirefoxDriver(options));
				wait = new WebDriverWait(driver.get(), Duration.ofSeconds(30L));
			} else {
				driver.set(new FirefoxDriver());
				wait = new WebDriverWait(driver.get(), Duration.ofSeconds(30L));
			}
		}

	}

	public void goToWebsite(String url) {
		logger.info("Visiting the Website " + url);
		driver.get().get(url);
	}

	public void maximizeWindow() {
		logger.info("Maximizing the browser window");
		driver.get().manage().window().maximize();
	}

	public void clickOn(By locator) {
		logger.info("Finding element with the locator " + locator);
//		WebElement element = driver.get().findElement(locator);
		WebElement element=wait.until(ExpectedConditions.elementToBeClickable(locator));
		logger.info("Element found and performing the click");

		element.click();
	}
	public void clickOnCheckBox(By locator) {
		logger.info("Finding element with the locator " + locator);
//		WebElement element = driver.get().findElement(locator);
		WebElement element=wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
		logger.info("Element found and performing the click");

		element.click();
	}

	public void clickOn(WebElement element) {

		logger.info("Element found and performing the click");

		element.click();
	}

	public void enterText(By locator, String textToEnter) {

		logger.info("Finding element with the locator " + locator);
//		WebElement element = driver.get().findElement(locator);
		WebElement element=wait.until(ExpectedConditions.visibilityOfElementLocated(locator));

		logger.info("Element found and enter text" + textToEnter);
		element.sendKeys(textToEnter);
	}

	public void clearText(By textBoxlocator) {

		logger.info("Finding element with the locator " + textBoxlocator);
//		WebElement element = driver.get().findElement(textBoxlocator);
		WebElement element=wait.until(ExpectedConditions.visibilityOfElementLocated(textBoxlocator));

		logger.info("Element found and clearing the text box field");
		element.clear();
	}

	public void selectFromDropDown(By dropDownLocator, String optionToSelect) {
		logger.info("Finding element with the locator " + dropDownLocator);
		WebElement element = driver.get().findElement(dropDownLocator);
		Select select = new Select(element);

		logger.info("Selecting the option " + optionToSelect);
		select.selectByVisibleText(optionToSelect);

	}

	public void enterSpecialKey(By locator, Keys keyToEnter) {

		logger.info("Finding element with the locator " + locator);

//		WebElement element = driver.get().findElement(locator);
		WebElement element=wait.until(ExpectedConditions.visibilityOfElementLocated(locator));

		logger.info("Element found and now entering Special Key" + keyToEnter);

		element.sendKeys(keyToEnter);
	}

	public String getVisibleText(By locator) {

		logger.info("Finding element with the locator " + locator);
		WebElement element = driver.get().findElement(locator);
		logger.info("Element found and now returning the visible text" + element.getText());
		return element.getText();
	}

	public String getVisibleText(WebElement element) {

		logger.info("Returning the visible text" + element.getText());
		return element.getText();
	}

	public List<String> getAllVisibleText(By locator) {

		logger.info("Finding All elements with the locator " + locator);
		List<WebElement> elementList = driver.get().findElements(locator);
		logger.info("Elements found and now printing the list of elements");
		List<String> visibleTestList = new ArrayList<String>();

		for (WebElement element : elementList) {

			System.out.println(getVisibleText(element));
			visibleTestList.add(getVisibleText(element));
		}
		return visibleTestList;
	}

	public List<WebElement> getAllElements(By locator) {

		logger.info("Finding All elements with the locator " + locator);
		List<WebElement> elementList = driver.get().findElements(locator);
		logger.info("Elements found and now printing the list of elements");

		return elementList;
	}

	public String takeScreenshot(String name) {

		TakesScreenshot screenshot = (TakesScreenshot) driver.get();

		File screenshotData = screenshot.getScreenshotAs(OutputType.FILE);
		Date date = new Date();
		SimpleDateFormat format = new SimpleDateFormat("HH-mm-ss");
		String timeStamp = format.format(date);
		String path = "./screenshots/" + name + " - " + timeStamp + ".png";
		File screenshotFile = new File(path);
		try {
			FileUtils.copyFile(screenshotData, screenshotFile);
		} catch (IOException e) {

			e.printStackTrace();
		}

		return path;
	}
	public void quit() {
		driver.get().quit();
	}

}
