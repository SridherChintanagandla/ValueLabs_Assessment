package com.api.tests;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.*;

public class ApiTest {
	@Test
	public void applePost() {
		try {
			RequestSpecification req = given();
			req.baseUri("https://api.restful-api.dev/objects");
			req.contentType(ContentType.JSON);

			JSONObject data = new JSONObject();
			data.put("year", 2023);
			data.put("price", 7999.99);
			data.put("CPU model", "Apple ARM A7");
			data.put("Hard disk size", "1 TB");

			JSONObject payload = new JSONObject();
			payload.put("name", "Apple Max Pro 1TB");
			payload.put("data", data);
			
			Reporter.log("Connecting to EndPoint");
			Response res = req.body(payload.toString()).post();
			System.out.println(res.asPrettyString());

			String id = res.jsonPath().getString("id");
			String createdDate = res.jsonPath().getString("id");

			Assert.assertNotNull(id);
			Reporter.log("Passed: id is successfully Generated with non null value");
			Assert.assertNotNull(createdDate);
			Reporter.log("Passed: createdDate is successfully Generated with non null value");
			
			String expectedName = payload.get("name").toString();
			String expectedPrice = data.get("price").toString();
			String expectedCpuModel = data.get("CPU model").toString();
			String expectedHardDiskSize = data.get("Hard disk size").toString();
			String expectedYear = data.get("year").toString();

			String actualName = res.jsonPath().getString("name");
			String actualPrice = res.jsonPath().getString("data.price");
			String actualCpuModel = res.jsonPath().getString("data.\"CPU model\"");
			String actualHardDiskSize = res.jsonPath().getString("data.\"Hard disk size\"");
			String actualYear = res.jsonPath().getString("data.year");
			
			Assert.assertEquals(actualName, expectedName);
			Reporter.log("Passed: name is successfully matched");
			Assert.assertEquals(actualPrice, expectedPrice);
			Reporter.log("Passed: price is successfully matched");
			Assert.assertEquals(actualYear, expectedYear);
			Reporter.log("Passed: year is successfully matched");
			Assert.assertEquals(actualHardDiskSize, expectedHardDiskSize);
			Reporter.log("Passed: Hard Disk Size is successfully matched");
			Assert.assertEquals(actualCpuModel, expectedCpuModel);
			Reporter.log("Passed: cpu Model is successfully matched");
			
		} catch (AssertionError e) {
			Reporter.log("Failed: Error Ocuured "+e.getMessage());
			throw e;
		}

	}
	@Test
	public void applePost_Fail() {
		try {
			RequestSpecification req = given();
			req.baseUri("https://api.restful-api.dev/objects");
			req.contentType(ContentType.JSON);

			JSONObject data = new JSONObject();
			data.put("year", 2023);
			data.put("price", 7999.99);
			data.put("CPU model", "Apple ARM A7");
			data.put("Hard disk size", "1 TB");

			JSONObject payload = new JSONObject();
			payload.put("name", "Apple Max Pro 1TB");
			payload.put("data", data);
			
			Reporter.log("Connecting to EndPoint");
			Response res = req.body(payload.toString()).post();
			System.out.println(res.asPrettyString());

			String id = res.jsonPath().getString("id");
			String createdDate = res.jsonPath().getString("id");

			Assert.assertNotNull(id);
			Reporter.log("Passed: id is successfully Generated with non null value");
			Assert.assertNotNull(createdDate);
			Reporter.log("Passed: createdDate is successfully Generated with non null value");
			
			String expectedName = payload.get("name").toString();
			String expectedPrice = data.get("price").toString();
			String expectedCpuModel = data.get("CPU model").toString();
			String expectedHardDiskSize = data.get("Hard disk size").toString();
			String expectedYear = data.get("year").toString();

			String actualName = res.jsonPath().getString("nam"); //intentionally providing wrong to get Failure
			String actualPrice = res.jsonPath().getString("data.price");
			String actualCpuModel = res.jsonPath().getString("data.\"CPU model\"");
			String actualHardDiskSize = res.jsonPath().getString("data.\"Hard disk size\"");
			String actualYear = res.jsonPath().getString("data.year");
			
			Assert.assertEquals(actualName, expectedName);
			Reporter.log("Passed: name is successfully matched");
			Assert.assertEquals(actualPrice, expectedPrice);
			Reporter.log("Passed: price is successfully matched");
			Assert.assertEquals(actualYear, expectedYear);
			Reporter.log("Passed: year is successfully matched");
			Assert.assertEquals(actualHardDiskSize, expectedHardDiskSize);
			Reporter.log("Passed: Hard Disk Size is successfully matched");
			Assert.assertEquals(actualCpuModel, expectedCpuModel);
			Reporter.log("Passed: cpu Model is successfully matched");
			
		} catch (AssertionError e) {
			Reporter.log("Failed: Error Ocuured "+e.getMessage());
			throw e;
		}

	}
}
