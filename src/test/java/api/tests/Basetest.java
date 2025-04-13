package api.tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import api.endpoints.Endpoints;
import io.restassured.RestAssured;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;

public class Basetest {
	
	@BeforeMethod
	public void setup() {
		RestAssured.baseURI= Endpoints.baseuri;
		RestAssured.basePath= Endpoints.basepath;
		RestAssured.filters(new RequestLoggingFilter(), new ResponseLoggingFilter());//no need of using log.all
	}
	
	@AfterMethod
	public void teardown() {
		RestAssured.reset();
	}

}
