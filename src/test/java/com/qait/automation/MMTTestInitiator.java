package com.qait.automation;
import com.qait.keywords.BasicCourseActions;
import com.qait.automation.utils.YamlReader;

public class MMTTestInitiator extends TestSessionInitiator{

	
	public BasicCourseActions basiccourse;
	public  YamlReader yml;
	
	private String product_local;
	
	private void _initPage() {
		basiccourse = new BasicCourseActions(driver);
		//yml = new YamlReader();
	}
	
	public MMTTestInitiator() {
		super();
		//setYamlFilePath(product_local);
		_configureBrowser("");
		_initPage();
	}
	
	public void show() {
	
	}
}
