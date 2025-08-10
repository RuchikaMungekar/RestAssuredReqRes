package test;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class PutandPatch {
	@Test
	public void PutExam() {
		JSONObject requestjson = new JSONObject();

		requestjson.put("name", "ramya");
		requestjson.put("professional", "QA");

		baseURI = "https://reqres.in/api";

		given().header("x-api-key", "reqres-free-v1").header("content-type", "application/json")
				.contentType(ContentType.JSON).accept(ContentType.JSON).body(requestjson.toJSONString()).when()
				.put("/users/2").then().statusCode(200).log().all();

	}

	@Test
	public void Patchxam() {
		JSONObject requestjson = new JSONObject();

		requestjson.put("name", "ramya");
		requestjson.put("professional", "QA");

		baseURI = "https://reqres.in/api";

		given().header("x-api-key", "reqres-free-v1").header("content-type", "application/json")
				.contentType(ContentType.JSON).accept(ContentType.JSON).body(requestjson.toJSONString()).when()
				.patch("/users/2").then().statusCode(200).log().all();

	}

	@Test
	public void deleteExam() {

		baseURI = "https://reqres.in";

		given().header("x-api-key", "reqres-free-v1").header("content-type", "application/json").
		when().delete("/api/users/2").then().statusCode(204).log().all();

	}

}
