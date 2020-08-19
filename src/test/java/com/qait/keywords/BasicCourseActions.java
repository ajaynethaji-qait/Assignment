package com.qait.keywords;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

import javax.swing.text.html.parser.Element;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

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
		Thread.sleep(1000);
		element("to_City").sendKeys(YamlReader.getData("to_NewCity"));
		Thread.sleep(1000);
		element("city_Chennai").click();
		Thread.sleep(1000);
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
		// String exp_date = "15";
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
		// String exp_date = "29";
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

	public void clickViewTravelBlog() throws InterruptedException {
		WebElement lblTravelBlog = driver
				.findElement(By.xpath("//div[@class='makeFlex column blackText latoBold appendBottom20']"));
		WebElement lblViewAll = driver
				.findElement(By.xpath("//span[@class='makeFlex pushRight']/a[contains(@href,'Tab_Stories')]"));
		scrollDown(lblTravelBlog);
		Thread.sleep(3000);
		click(lblViewAll);
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

	public String getTextCity() {
		return element("read_City").getText();
	}

	public String getTextCityArrv() {
		return element("to_City").getAttribute("value");
		// to_City
	}

	public void selectDateCalendarVisa() throws InterruptedException {
		element("charter_CalendarDt").click();
		SimpleDateFormat sdf = new SimpleDateFormat("dd");
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.DAY_OF_MONTH, 7);
		String newDate = sdf.format(cal.getTime());
		List<WebElement> dates = elements("charter_Calendar");
		for (WebElement ele : dates) {
			String date_text = ele.getText();
			String date[] = date_text.split("\n");
			if (date[0].equals(newDate)) {
				ele.click();
				break;
			}

		}

	}

	public void btnSearchCharter() {
		element("btn_SearchCharter").click();
		logMessage("Search results displayed");
	}

	public void checkbox() {
		element("checkbox_HeavyJet").click();
		logMessage("Aircraft Type Selected");
	}

	// checkbox_FlightAttendant
	public void selectTime() {
		List<WebElement> details = elements("charter_Time");
		for (WebElement element : details) {
			// String time_text = element.getText();
			// String date[] = time_text.split("\n");
			// System.out.println(time_text);
			if (element.getAttribute("innerHTML").equals("11:00 AM")) {
				System.out.println(element.toString());
				click(element);
				break;
			}
		}
	}

//	if (element.getAttribute("innerHTML").equals("12:30 AM")) {
//		System.out.println(element.toString());
//		scrollDown(element);
//		click(element);
//		break;

	public void selectPassengerCount() {
		element("passengers_Count").click();
		List<WebElement> details = elements("passenger_Cnt");
		for (WebElement webElement : details) {
			String date_text = webElement.getText();
			System.out.println(date_text);
			if (webElement.getAttribute("innerHTML").equals("1")) {
				click(webElement);
			}
		}
	}

	public void selectCityCabs() throws InterruptedException {
		element("from_City").sendKeys(YamlReader.getData("from_City"));
		// element("city_Delhi").click();
		element("to_City").sendKeys(YamlReader.getData("to_Place"));
		element("select_City").click();
		logMessage("City gets selected");
	}

	public void selectDateCalendarCabs(String strMonth, String strDay) throws InterruptedException {
		element("select_CabCalendar").click();
		List<WebElement> detailMonth = elements("cabs_MonthCalendar");
		for (WebElement element : detailMonth) {
			if (element.getAttribute("innerText").contains(strMonth)) {
				List<WebElement> detailsDay = driver.findElements(By.xpath("//div[contains(text(),'" + strMonth
						+ "')]/parent::div/following-sibling::div[@class='DayPicker-Body']/div[@class='DayPicker-Week']/div"));
				for (WebElement element1 : detailsDay) {
					if (element1.getAttribute("innerText").contains(strDay)) {
						click(element1);
						break;
					}

				}
				break;
			}
		}
	}

	public void selectCabTime(String strTime) throws InterruptedException {
		element("select_CabTime").click();

		List<WebElement> details = elements("cab_Time");
		for (WebElement element : details) {

			if (element.getAttribute("innerHTML").equals(strTime)) {
				System.out.println(element.toString());
				scrollDown(element);
				click(element);
				break;

			}
		}
	}

	public String verifyText() {
		return element("text_Visible").getText();
	}

	public String getlistCabs() {
		return element("list_Cabs").getText();

	}

	public String getCabPrice() {
		return element("cab_Price").getText();
	}

	public String getflight_Name() {
		return element("flight_Name").getText();
	}

	public void launchUrl() {
		driver.get(YamlReader.getData("blog_url"));
		logMessage("Login page gets opened");
	}

	public void btnContinueBlog() {
		element("btn_ContinueBlogPage").click();
		logMessage("Blog results displayed");
	}

}
