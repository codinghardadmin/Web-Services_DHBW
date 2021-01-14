package org.dhbw.mosbach.ai.keepyourday;

import org.hamcrest.CoreMatchers;
import org.junit.jupiter.api.Test;

import io.quarkus.test.junit.QuarkusTest;
import io.restassured.RestAssured;

@QuarkusTest
public class KeepYourDayTests {
	@Test
	public void testHelloEndpoint() {

		RestAssured.given().when().get("/keepyourday/version").then().statusCode(200)
				.body(CoreMatchers.containsString("1.0"));

	}
}
