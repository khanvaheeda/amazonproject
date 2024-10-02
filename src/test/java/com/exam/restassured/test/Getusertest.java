package com.exam.restassured.test;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class Getusertest 
{
	  @Test
	    public void testGetUsers() {
	        RestAssured.baseURI = "https://reqres.in";

	        given()
	        .when()
	            .get("/api/users?page=2")
	        .then()
	            .statusCode(200)
	            .body("data", hasSize(greaterThan(0)))
	            .log().all();
	    }

	  @Test
	  public void testGetUserById() {
	      given()
	      .when()
	          .get("/api/users/2")
	      .then()
	          .statusCode(200)
	          .body("data.id", equalTo(2))
	          .body("data.email", containsString("@reqres.in"))
	          .log().all();
	  }
	  
	  @Test
	  public void testCreateUser() {
	      String requestBody = "{\"name\":\"morpheus\", \"job\":\"leader\"}";

	      given()
	          .header("Content-Type", "application/json")
	          .body(requestBody)
	      .when()
	          .post("/api/users")
	      .then()
	          .statusCode(201)
	          .body("name", equalTo("morpheus"))
	          .body("job", equalTo("leader"))
	          .log().all();
	  }
	  @Test
	  public void testUpdateUser() {
	      String requestBody = "{\"name\":\"morpheus\", \"job\":\"zion resident\"}";

	      given()
	          .header("Content-Type", "application/json")
	          .body(requestBody)
	      .when()
	          .put("/api/users/2")
	      .then()
	          .statusCode(200)
	          .body("name", equalTo("morpheus"))
	          .body("job", equalTo("zion resident"))
	          .log().all();
	  }
	  @Test
	  public void testDeleteUser() {
	      given()
	      .when()
	          .delete("/api/users/2")
	      .then()
	          .statusCode(204)
	          .log().all();
	  }


	}

