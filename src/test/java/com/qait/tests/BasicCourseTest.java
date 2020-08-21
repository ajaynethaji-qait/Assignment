package com.qait.tests;

import static org.junit.Assert.assertTrue;
import static org.testng.Assert.assertEquals;

import org.testng.Assert;
import org.testng.annotations.Test;
import com.qait.automation.TestSessionInitiator;
import com.qait.automation.utils.YamlReader;

public class BasicCourseTest extends TestSessionInitiator {

	@Test(priority = 1, enabled = false)
	public void launchApplication() throws Throwable {
		basicCourse.launchApplicationUrl();
		String url = basicCourse.getCurrentURL();
		Assert.assertEquals(url, "https://www.makemytrip.com/");
		basicCourse.clickOnLogin();
		basicCourse.clickGoogleLogin();
		basicCourse.switchWindow();

	}

	@Test(priority = 2, enabled = false)
	public void navigateToCabs() throws Throwable {
		basicCourse.launchApplicationUrl();
		basicCourse.selectCabs();
		basicCourse.selectCityCabs();
		basicCourse.selectDateCalendarCabs(YamlReader.getData("month_year"), YamlReader.getData("dt_date"));
		basicCourse.selectCabTime(YamlReader.getData("cab_time"));
		basicCourse.btnSearchCharter();
		String txtcty = basicCourse.getTextCityArrv();
		Assert.assertEquals(txtcty, YamlReader.getData("to_Place"));
		String txt = basicCourse.verifyText();
		Assert.assertEquals(txt, "Your Safety: Our Priority");

	}

	@Test(priority = 3, enabled = false)
	public void navigateToCharterFlights() throws Throwable {
		basicCourse.launchApplicationUrl();
		basicCourse.selectCharterFlights();
		basicCourse.selectCity();
		basicCourse.selectDateCalendarCharter(YamlReader.getData("month_year"), YamlReader.getData("dt_date"));
		basicCourse.selectTime();
		// basicCourse.selectPassengerCount();
		Thread.sleep(3000);
		basicCourse.btnSearchCharter();
		basicCourse.checkbox();
		String str = basicCourse.getflight_Name();
		Assert.assertEquals(str, "Pilatus PC 12");
	}

	@Test(enabled = false)
	public void navigateToFlights() throws Throwable {
		basicCourse.launchApplicationUrl();
		basicCourse.selectFlights();
		basicCourse.selectTrip();
		basicCourse.selectCity();
		basicCourse.selectDateCalendar(YamlReader.getData("flight_month"), YamlReader.getData("dt_date"));
		basicCourse.btnSearch();
		String txt = basicCourse.getTextCity();
		String news = txt.replace("Flights from", "").trim();
		String str = news.replace("to Chennai", "").trim();
		Assert.assertEquals(str, YamlReader.getData("to_city"));
		basicCourse.checkbox_Stops();
		basicCourse.checkbox_Flight();
		basicCourse.btnViewPrice();
	}

	@Test(priority = 2, enabled = false)
	public void navigateToHotels() throws Throwable {
		basicCourse.launchApplicationUrl();
		basicCourse.selectHotels();
		basicCourse.selectHotelCity();
//		basicCourse.selectDateCalendarHotel();
//		basicCourse.btnSearch();

	}

	@Test(enabled = false)
	public void navigateToBuses() throws Throwable {
		basicCourse.launchApplicationUrl();
		basicCourse.selectBuses();
		basicCourse.selectBusCity();
		basicCourse.selectDateCalendarBus(YamlReader.getData("month_year"), YamlReader.getData("dt_date"));
		String txt = basicCourse.getTextCityArrv();
		Assert.assertEquals(txt, YamlReader.getData("to_City"));
		basicCourse.clickSearchBuses();
		String str = basicCourse.publicTransport();
		Assert.assertEquals(str, "State Transports");
		basicCourse.clickViewBus();

	}

	@Test(enabled = false)
	public void verifyTravelBlogText() throws Throwable {
		basicCourse.launchApplicationUrl();
		String txt = basicCourse.textTravelBlog();
		String news = txt.replace("VIEW ALL", "").trim();
		Assert.assertEquals(news, "Travel Blog");
		basicCourse.clickViewTravelBlog();
		basicCourse.btnContinueBlog();
		String url = basicCourse.getCurrentURL();
		Assert.assertEquals(url, "https://www.makemytrip.com/blog/?intid=Blog_HomePage_Tab_Stories");

	}

	@Test(priority = 2, enabled = true)
	public void navigateToTrains() throws Throwable {
		basicCourse.launchApplicationUrl();
		basicCourse.selectTrains();
		basicCourse.selectTrainCity();
		// basicCourse.selectDateCalendarTrain(YamlReader.getData("month_year"),
		// YamlReader.getData("dt_date"));
		basicCourse.btnSearchCharter();
		String txt = basicCourse.getTextCityArrvTrain();
		Assert.assertEquals(txt, YamlReader.getData("arr_City"));
		basicCourse.btnSearchTatkal();

	}

}
