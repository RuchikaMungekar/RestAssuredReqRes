package test;

import org.testng.Assert;
import org.testng.annotations.Test;
import static org.hamcrest.Matchers.*;

import static io.restassured.RestAssured.*;
import io.restassured.response.Response;

public class Resq1 {
	@Test
	public void Test_1() {

		Response response = get("https://reqres.in/api/users?page=2");

		System.out.println(response.getStatusCode());
		System.out.println(response.getTime());
		System.out.println(response.getBody().asString());
		System.out.println(response.getStatusLine());
		System.out.println(response.getHeader("content-type"));
		
		int statusCode = response.getStatusCode();
		Assert.assertEquals(statusCode,204);

	}
	
	@Test
public  void Test_2() {
		baseURI = "https://reqres.in/api";
		given().
			get("/users?page=2").
		then().
			statusCode(200)
			.body("data.id[0]", equalTo(7))
			.log().all();
	
}

}
