package api.utils;

import java.net.URI;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import api.payload.Registerpayload;
import io.restassured.RestAssured;
import io.restassured.response.Response;

public class Utils {
	private static final String CONTENT_TYPE = "application/json";

	private static Response sendGetRequest(String endpoint) {
		return RestAssured.given().when().get(endpoint).then().extract().response();
	}

	private static Response sendPostRequest(String endpoint, String payload) {
		return RestAssured.given().header("Content-Type", CONTENT_TYPE).body(payload).when().post(endpoint).then()
				.extract().response();
	}

	public static Response getcityrequest(String pathkey, String pathvalue, String getpath) {
		return RestAssured.given().queryParam(pathkey, pathvalue).when().get(getpath).then().extract().response();

	}

	public static Response getcitiesrequest(String getpath) {
		return sendGetRequest(getpath);
	}

	public static Response registerpostrequest(String postpath) {
		return sendPostRequest(postpath, Registerpayload.registerpayload().toString());
	}

	public static Response loginpostrequest(String postpath) {
		try {
			Loginpojo loginpayload = new Loginpojo(Registerpayload.email, Registerpayload.password);
			ObjectMapper objectMapper = new ObjectMapper();
			String requestBody = objectMapper.writeValueAsString(loginpayload); // Converts Object to JSON

			return sendPostRequest(postpath, requestBody);
		} catch (Exception e) {
			throw new RuntimeException("Error converting Loginpojo to JSON", e);
		}
	}

	public static Response getreservationrequest(String pathkey, String pathvalue, String getpath, String token) {
		return RestAssured.given().queryParam(pathkey, pathvalue).header("Authorization", "Bearer " + token).when()
				.get(getpath).then().extract().response();

	}
	
	

//	public static Response loginpostrequest(String postpath) {
//	Gson gson = new Gson();
//	String requestBody = gson.toJson(Loginpojo.loginpaylod());
//		Loginpojo loginpayload = new Loginpojo(Registerpayload.email, Registerpayload.password);
//		Response response = RestAssured.given().header("Content-Type", "application/json").body(loginpayload).when()
//				.post(postpath).then().log().all().extract().response();
//		return response;
//	}

}
