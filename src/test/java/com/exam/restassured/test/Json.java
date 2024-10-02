package com.exam.restassured.test;

import org.testng.annotations.Test;

public class Json 
{
   // private static final String JsonSchemaValidation.matchesJsonSchemaInClasspath("storeJsonSchema.json") = null;

	@Test
    public void testGetUserSchemaValidation() 
    {
        ((Object) given())
        .when()
            .get("http://localhost:3000/store")
        .then()
            .assertThat().body( Json .matchesJsonSchemaInClasspath("storeJsonSchema.json"));
            .log().all();
    }

	private static Object matchesJsonSchemaInClasspath(String string) {
	// TODO Auto-generated method stub
	return null;
}

	private Object given() {
		// TODO Auto-generated method stub
		return null;
	}
}
