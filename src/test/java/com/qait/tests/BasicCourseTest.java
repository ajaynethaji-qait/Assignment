package com.qait.tests;


import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import static com.qait.automation.utils.YamlReader.getData;
import com.qait.automation.MMTTestInitiator;
import com.qait.automation.TestSessionInitiator;


public class BasicCourseTest extends TestSessionInitiator{

	
	MMTTestInitiator test;
	String baseUrl, password;
	
	private void initvars() {
		baseUrl = getData("baseUrl");
		
	}
	
	@BeforeClass
	public void start_test_session() {
		test = new MMTTestInitiator(); 
		initvars();
		test.launchMyApplication();
		
	}
	
	
//	@Test(priority=1)
//	public void launchApplication() throws Throwable {
//		basicCourse.launchApplicationUrl();
//		Assert.assertEquals(basicCourse.getPageTitle(), "Welcome - T.A.T.O.C");
//	}
//	
//	@Test(priority=2)
//	public void navigateToBasicCourse() throws Throwable {
//		basicCourse.navigateToBasicCourse();
//		Assert.assertEquals(basicCourse.getGridHeader(), "Grid Gate");
//	}
	
	@Test
	public void verify_LoginPage() {
		
		String url = test.getCurrentURL();
		System.out.println(url);
		Assert.assertEquals(url, "");
		test.basiccourse.clickOnLogin();
		test.basiccourse.clickGoogleLogin();
		
	}
	
	}
