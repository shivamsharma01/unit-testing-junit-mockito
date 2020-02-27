package com.in28minutes.unittesting.unittesting;

import org.json.JSONException;
import org.junit.Test;
import org.skyscreamer.jsonassert.JSONAssert;

public class JsonAssertTest {
	
	String actualResponse = "{\"id\":1,\"name\":\"Ball\",\"price\":10,\"quantity\":100}";
	
	@Test
	public void jsonAssert_Strict() throws JSONException {
		String expectedResponse = "{\"id\": 1,\"name\":\"Ball\",\"price\":10,\"quantity\":100}";
		// value different (this will fail) -> expectedResponse = "{\"id\": 1,\"name\":\"Ball\",\"price\":10}";
		// [key:value] removed (this will fail) -> expectedResponse = "{\"id\": 1,\"name\":\"Ball\",\"price\":10,\"quantity\":10}";
		// true is for strict
		// strict = true allows spaces but values should be same and key values should be present
		JSONAssert.assertEquals(expectedResponse, actualResponse, true);
	}
	
	@Test
	public void jsonAssert_NotStrict() throws JSONException {
		// strict = false allowed missing [key:value] but present [key:value] should match
		String expectedResponse = "{\"id\": 1,\"name\":\"Ball\",\"price\":10,\"quantity\":100}";
		JSONAssert.assertEquals(expectedResponse, actualResponse, false);
		// quantity missing (this will pass) 
		expectedResponse = "{\"id\": 1,\"name\":\"Ball\",\"price\":10}";
		JSONAssert.assertEquals(expectedResponse, actualResponse, false);
		// quantity changed (this will fail) -> 
		expectedResponse = "{\"id\": 1,\"name\":\"Ball\",\"price\":10,\"quantity\":10}";
		JSONAssert.assertNotEquals(expectedResponse, actualResponse, false);
	}
	
	// works even without espace characters, escape char needed only when spaces in value eq name = shivam sharma
	@Test
	public void jsonAssert_WithoutEscapeCharacters() throws JSONException {
		// strict = false allowed missing [key:value] but present [key:value] should match
		String expectedResponse = "{id: 1, name:Ball, price:10, quantity :100}";
		JSONAssert.assertEquals(expectedResponse, actualResponse, true);
	}
	

}
