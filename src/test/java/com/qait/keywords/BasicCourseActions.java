package com.qait.keywords;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

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
		element("input_Passw").sendKeys(YamlReader.getData("password"));
		element("btn_Next").click();
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
		element("to_City").sendKeys(YamlReader.getData("to_NewCity"));
		element("city_Kanpur").click();
		logMessage("City gets selected");
//		Actions act = new Actions(driver);
//		act.sendKeys(Keys.TAB).build().perform();
	}

	public void selectTrip() {
		List<WebElement> details = elements("trip_OneWay");
		// List<WebElement> details = driver.findElements(By.xpath("//ul[@class='fswTabs
		// latoBlack greyText']"));
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
		SimpleDateFormat sdf = new SimpleDateFormat("dd");
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.DAY_OF_MONTH, 7);
		String newDate = sdf.format(cal.getTime());
		//String exp_date = "15";
		List<WebElement> dates = elements("flight_Calendar");
		// List<WebElement> dates =
		// driver.findElements(By.xpath("//div[@class='DayPicker-wrapper']//div[1]//div[3]//div//div//div[1]//p[1]"));
		for (WebElement ele : dates) {
			String date_text = ele.getText();
			String date[] = date_text.split("\n");
			if (date[0].equals(newDate)) {
				ele.click();
				break;
			}

		}
	}

	public void btnSearch() {
		element("btn_Search").click();
		logMessage("Search results displayed");
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

	public void selectDateCalendarHotel() throws InterruptedException {
		// element("date_BusTravel").click();
		SimpleDateFormat sdf = new SimpleDateFormat("dd");
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.DAY_OF_MONTH, 7);
		String newDate = sdf.format(cal.getTime());
		//String exp_date = "29";
		List<WebElement> dates = elements("hotel_Calendar");
//		List<WebElement> dates = driver
//				.findElements(By.xpath("//div[@class='DayPicker-wrapper']//div[1]//div//div//div"));
		for (WebElement ele : dates) {
			System.out.println(ele);
			String date_text = ele.getText();
			String date[] = date_text.split("\n");
			if (date[0].equals(newDate)) {
				ele.click();
				break;
			}

		}
	}

	public void selectHotelCity() throws InterruptedException {
		// element("lbl_City").click();
		element("input_City").sendKeys(YamlReader.getData("City"));
		element("hotel_City").click();
	}

	public void selectDateCalendarBus() throws InterruptedException {
		SimpleDateFormat sdf = new SimpleDateFormat("dd");
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.DAY_OF_MONTH, 7);
		String newDate = sdf.format(cal.getTime());
		// String exp_date = "29";
		List<WebElement> dates = elements("bus_Calendar");
		// List<WebElement> dates =
		// driver.findElements(By.xpath("//div[@class='DayPicker-wrapper']//div[1]//div//div//div"));
		for (WebElement ele : dates) {
			String date_text = ele.getText();
			String date[] = date_text.split("\n");
			if (date[0].equals(newDate)) {
				ele.click();
				break;
			}

		}
	}

	public void clickSearchBuses() {
		element("btn_SearchBuses").click();
		logMessage("Search results displayed");

	}

	public String publicTransport() {
		return element("bus_Transport").getText();
	}

	public void clickViewBus() {
		element("view_Bus").click();
		logMessage("Bus results displayed");

	}

	public String textTravelBlog() {
		return element("txt_TravelBlog").getText();

	}

	public void clickViewTravelBlog() {
		element("btn_ViewTravelBlog").click();
		logMessage("Blog Page displayed");

	}
	
	public void selectBusCity() throws InterruptedException {
		element("from_City").sendKeys(YamlReader.getData("from_City"));
		element("to_City").sendKeys(YamlReader.getData("to_City"));
		element("city_Kanpur").click();
		logMessage("City gets selected");
//		Actions act = new Actions(driver);
//		act.sendKeys(Keys.TAB).build().perform();
	}

}
