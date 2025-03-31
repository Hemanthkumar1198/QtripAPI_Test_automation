package api.tests;

import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;

import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

import api.config.Config;
import api.utils.CitiesPojo;
import api.utils.Utils;
import io.restassured.response.Response;

public class QtripApiTests extends Basetest {

	String token;
	String userId;

	@Test(priority = 0)
	public void verifyRegisterResponse() {
		Response response = Utils.registerpostrequest(Config.getProperty("register_endpoint"));
		Assert.assertEquals(response.statusCode(), 201);
		Assert.assertEquals(response.jsonPath().getBoolean("success"), true, "success mismatch");
		System.out.println(response.asPrettyString());

	}

	@Test(priority = 1)
	public void verifyLoginResponse() {
		Response response = Utils.loginpostrequest(Config.getProperty("login_endpoint"));
		Assert.assertEquals(response.statusCode(), 201);
		
		token = response.jsonPath().getString("data.token");
        userId = response.jsonPath().getString("data.id");
        
        Assert.assertNotNull(token, "Token is null");
        Assert.assertNotNull(userId, "User ID is null");
		
		Assert.assertEquals(response.jsonPath().getBoolean("success"), true, "success mismatch");
		System.out.println(response.asPrettyString());

	}

	@Test(priority = 2)
	public void veriyGetCitiesResponse() {
		Response response = Utils.getcitiesrequest("cities");
		response.then().assertThat().body(matchesJsonSchemaInClasspath("city-schema.json"));
		
		List<CitiesPojo> cities = response.jsonPath().getList("", CitiesPojo.class);
		String citiyid = cities.get(0).getId();
		System.out.println(citiyid);
		
		Assert.assertEquals(response.statusCode(), 200);
		Assert.assertTrue(response.statusLine().contains("OK"), "Status line does not contain OK");
		System.out.println(response.asPrettyString());
	}

	@Test(priority = 3)
	public void veriyGetCityResponse() {
		Response response = Utils.getcityrequest
				(Config.getProperty("citiespathkey"),
			     Config.getProperty("citiespathvalue"),
			     Config.getProperty("cities_endpoint"));
		
		Assert.assertEquals(response.statusCode(), 200);
		Assert.assertTrue(response.statusLine().contains("OK"), "Status line does not contain OK");
		System.out.println(response.asPrettyString());

	}

	@Test(priority = 4)
	public void veriyGetReservationResponse() {
		Response response = Utils.getreservationrequest(
				Config.getProperty("reservationpathkey"),
				userId, 
				Config.getProperty("reservation_endpoint"),
				token);
		
		Assert.assertEquals(response.statusCode(), 200);
		Assert.assertTrue(response.statusLine().contains("OK"), "Status line does not contain OK");
		System.out.println(response.asPrettyString());

	}

}
