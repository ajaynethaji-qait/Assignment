package com.qait.keywords;


import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import com.qait.automation.TestSessionInitiator;
import com.qait.automation.getpageobjects.GetPage;
import com.qait.automation.utils.YamlReader;

public class BasicCourseActions extends GetPage{

	 public BasicCourseActions(WebDriver driver) {
	        super(driver, "MakeMyTrip");
	    }

	public void launchApplicationUrl() {
		driver.get(YamlReader.getData("baseUrl"));
	}
	
	public void navigateToBasicCourse() {
		element("link_basicCourse").click();
	}
	
	public String getGridHeader() {
		return element("label_grid").getText();
	}
	
	public void clickOnLogin( ) {
		element("login_Icon").click();
	}
	
	public void clickGoogleLogin() {
		element("google_Login").click();
		logMessage("USer clicks on Google Login");
	}
	
	public void selectUsername( ) {
		element("select_Username").click();
	}
	
	public void inputPassw(String str) {
		element("input_Password").sendKeys(str);
	}
	
	public void selectFlights( ) {
		element("tab_FLights").click();
	}
	
	public void selectHotels( ) {
		element("tab_Hotels").click();
	}
	
	public void selectTrains( ) {
		element("tab_Trains").click();
	}
	
	public void selectBuses( ) {
		element("tab_Buses").click();
	}
	
	public void selectCabs( ) {
		element("tab_Cabs").click();
	}
	
	public void selectVisa( ) {
		element("tab_Visa").click();
	}
	
	public void selectCharterFlights( ) {
		element("tab_CharterFlights").click();
	}
	
	public void getUrl() {
		
	}
	
	
	

	
}
