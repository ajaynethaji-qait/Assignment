package com.qait.keywords;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qait.automation.getpageobjects.GetPage;
import com.qait.automation.utils.YamlReader;

public class BasicCourseActions extends GetPage {

	public BasicCourseActions(WebDriver driver) {
		super(driver, "BasicCourse");
	}

	public void launchApplicationUrl() {
		driver.get(YamlReader.getData("app_url"));
		logMessage("Login page gets opened");
	}

	public void navigateToBasicCourse() {
		element("link_basicCourse").click();
	}

	public String getGridHeader() {
		return element("label_grid").getText();
	}

	public void clickOnLogin() {
		element("login_Icon").click();
		logMessage("User clicks on Login");
	}

	public void clickGoogleLogin() {
		element("google_Login").click();
		logMessage("User clicks on Google Login");
	}

	public void selectUsername() {
		element("select_Username").click();
	}

	public void inputUsername() {
		element("input_Username").sendKeys(YamlReader.getData("username"));
	}

	public void switchWindow() throws InterruptedException {
		String parent = driver.getWindowHandle();
		for (String Subwindow : driver.getWindowHandles()) {
			driver.switchTo().window(Subwindow);
		}
		element("input_Username").sendKeys(YamlReader.getData("username"));
		element("btn_Next").click();
		Thread.sleep(3000);
		element("input_Passw").sendKeys(YamlReader.getData("password"));
		element("btn_Next").click();
		Thread.sleep(3000);
		driver.close();
		driver.switchTo().window(parent);
	}

	public void selectFlights() {
		element("tab_FLights").click();
	}

	public void selectHotels() {
		element("tab_Hotels").click();
	}

	public void selectTrains() {
		element("tab_Trains").click();
	}

	public void selectBuses() {
		element("tab_Buses").click();
	}

	public void selectCabs() {
		element("tab_Cabs").click();
	}

	public void selectVisa() {
		element("tab_Visa").click();
	}

	public void selectCharterFlights() {
		element("tab_CharterFlights").click();
	}

	public void clickLogin() {
		element("tab_CharterFlights").click();
	}

	public void selectCity() throws InterruptedException {
		element("from_City").sendKeys(YamlReader.getData("from_City"));
		element("to_City").sendKeys(YamlReader.getData("to_City"));
		Thread.sleep(3000);
		element("city_Chennai").click();
//		Actions act = new Actions(driver);
//		act.sendKeys(Keys.TAB).build().perform();
	}

	public void selectTrip() {
		List<WebElement> details = driver.findElements(By.xpath("//ul[@class='fswTabs latoBlack greyText']"));
		for (WebElement webElement : details) {
			if (webElement.getText().equals("Oneway")) {
				webElement.click();
			}
		}
	}

	public void dummyTrip() {
		element("select_Trip").click();
	}

	public void selectDateCalendar() throws InterruptedException {
		element("date_Departure").click();
		String exp_date="15";
		List<WebElement> dates = driver.findElements(By.xpath("//div[@class='DayPicker-wrapper']//div[1]//div[3]//div//div//div[1]//p[1]"));
		for (WebElement ele : dates) {
			String date_text = ele.getText();
			String date[] = date_text.split("\n");
			if (date[0].equals(exp_date)) {
				ele.click();
				break;
			} 
	
		}
	}

	public void btnSearch() {
		element("btn_Search").click();
	}
	
	public void checkbox_Stops() {
		element("checkbox_Nonstop").click();
	}
	
	public void checkbox_Flight() {
		element("checkbox_Flight").click();
	}
	
	public void btnViewPrice() {
		element("btn_ViewPrices").click();
	}
	
}
