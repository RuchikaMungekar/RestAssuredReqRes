package test;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;
import java.util.HashMap;
import java.util.Map;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class TestGetAndPost {
	@Test
	public void getUser() {
		baseURI = "https://reqres.in/api";
		given().get("/users?page=2").then().statusCode(200).body("data[4].first_name", equalTo("George")).log().all();
	}

	@Test
	public void getUser1() {
		baseURI = "https://reqres.in/api";
		given().get("/users?page=2").then().statusCode(200).body("data[4].email", equalTo("george.edwards@reqres.in"))
				.body("data.first_name", hasItems("George","Rachel")).
				log().headers();
	}

	@Test
	public void postUser() {
		Map<String, Object>maps =new HashMap<String, Object>();
		
		System.out.println("maps"+ maps);
		
		JSONObject requestjson =new JSONObject();
		
	requestjson.put("name", "ramya");
		requestjson.put("professional","QA" );
		
		baseURI ="https://reqres.in/api";
		
		given().header("x-api-key", "reqres-free-v1").
		header("content-type","application/json").contentType(ContentType.JSON).accept(ContentType.JSON).
		body(requestjson.toJSONString()).when().post("/users").then().statusCode(201).log().all();
		

	}

}
