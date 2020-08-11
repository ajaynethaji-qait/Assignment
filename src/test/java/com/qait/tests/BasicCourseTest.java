package com.qait.tests;


import org.testng.Assert;
import org.testng.annotations.Test;
import com.qait.automation.TestSessionInitiator;

import static com.qait.automation.TestSessionInitiator.test;


public class BasicCourseTest extends TestSessionInitiator{

	@Test(priority=1,enabled = false)
	public void launchApplication() throws Throwable {
		basicCourse.launchApplicationUrl();
		String url = basicCourse.getCurrentURL();
		Assert.assertEquals(url, "https://www.makemytrip.com/");
		basicCourse.clickOnLogin();
		basicCourse.clickGoogleLogin();
		basicCourse.switchWindow();

	
	}
	
	@Test(priority=2, enabled = true)
	public void navigateToFlights() throws Throwable {
		basicCourse.launchApplicationUrl();
		basicCourse.selectFlights();
		basicCourse.selectTrip();
		basicCourse.selectCity();
		basicCourse.selectDateCalendar();
		Thread.sleep(3000);
		basicCourse.btnSearch();
		Thread.sleep(3000);
	}

	}
