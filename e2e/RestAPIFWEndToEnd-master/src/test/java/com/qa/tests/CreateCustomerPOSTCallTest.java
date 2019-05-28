package com.qa.tests;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class CreateCustomerPOSTCallTest {
	
	@Test
	public void createCustomerTest(){
		
		//1. specify the url:
		RestAssured.baseURI = "http://restapi.demoqa.com/customer/register";
		
		//2. Define a request:
		 RequestSpecification httpRequest =  RestAssured.given();
		 
		 //3. prepare json object: add key-value pairs in JSON:
		 JSONObject requestJson = new JSONObject();
		 requestJson.put("FirstName", "Naveen2");
		 requestJson.put("LastName", "Test1");
		 requestJson.put("UserName", "Naveen1231");
		 requestJson.put("Password", "Naveen1231");
		 requestJson.put("Email", "Naveen1@gmail.com");

		 //4. add the header:
		 httpRequest.header("Content-Type", "application/json");
		 
		 //5. add the json payload to the request:
		 httpRequest.body(requestJson.toJSONString());
		 
		 //6. hit the request:
		 Response response = httpRequest.post();
		 
		//7. get the status code:
		 System.out.println("the response code is: "+ response.getStatusCode());
		
		 //8. get the response body:
		 String responseBody = response.body().asString();
		 System.out.println("The response body is: " + responseBody);		
	}

}
