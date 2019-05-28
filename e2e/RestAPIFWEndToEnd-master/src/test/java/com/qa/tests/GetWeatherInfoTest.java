package com.qa.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class GetWeatherInfoTest {
	
	@Test(priority=1)
	public void getWeatherDetailsWith_CorrectCityTest(){
	//1. specify the base url:
	RestAssured.baseURI = "http://restapi.demoqa.com/utilities/weather/city";
	//RestAssured.baseURI = "https://reqres.in/api/users";

	//2. Define a request:
	 RequestSpecification httpRequest =  RestAssured.given();
	//3. make a request with the parameter and http method:
	 Response response = httpRequest.request(Method.GET, "/Pune");
	 
	//4. print the response as body: convert response to string:
	 String responseBody = response.getBody().asString();
	System.out.println("Response body is: "+ responseBody);	
		
	//5. get the status code:
	int statusCode = response.getStatusCode();
	System.out.println("the status code is: "+ statusCode);
	Assert.assertEquals(statusCode, 200);
	
	//6. get all the headers:
	String contentType = response.header("Content-Type");
	System.out.println("the content type is: "+ contentType);
		
	Headers allHeaders = response.headers();
	for(Header h : allHeaders){
		System.out.println("the header key:"+ h.getName());
		System.out.println("the header value:"+ h.getValue());
	}
	
	//7. How to validate JSON Response: using Json Path utility:
	JsonPath jsonPathVal = response.jsonPath();
	
	String cityName = jsonPathVal.get("City");
	System.out.println("the value of city is:"+ cityName);
	
	Assert.assertNotNull(cityName);
	Assert.assertEquals(cityName, "Pune");
	
	String tempVal = jsonPathVal.get("Temperature");
	System.out.println("the value of temperature is: "+ tempVal);
	boolean b = tempVal.contains("Degree celsius");
	Assert.assertTrue(b);
	//Assert.assertEquals(tempVal, "12.803 Degree celsius");
	}
	
	
	@Test(priority=2)
	public void getWeatherDetailsWith_InCorrectCityTest(){
	//1. specify the base url:
	RestAssured.baseURI = "http://restapi.demoqa.com/utilities/weather/city";
	//RestAssured.baseURI = "https://reqres.in/api/users";

	//2. Define a request:
	 RequestSpecification httpRequest =  RestAssured.given();
	//3. make a request with the parameter and http method:
	 Response response = httpRequest.request(Method.GET, "/test");
	 
	//4. print the response as body: convert response to string:
	 String responseBody = response.getBody().asString();
	System.out.println("Response body is: "+ responseBody);	
		
	//5. get the status code:
	int statusCode = response.getStatusCode();
	System.out.println("the status code is: "+ statusCode);
	Assert.assertEquals(statusCode, 400);
	
	//6. get all the headers:
	String contentType = response.header("Content-Type");
	System.out.println("the content type is: "+ contentType);
		
	Headers allHeaders = response.headers();
	for(Header h : allHeaders){
		System.out.println("the header key:"+ h.getName());
		System.out.println("the header value:"+ h.getValue());
	}
	
	//7. How to validate JSON Response: using Json Path utility:
	JsonPath jsonPathVal = response.jsonPath();
	
	String FaultId = jsonPathVal.get("FaultId");
	System.out.println("the value of FaultId is:"+ FaultId);
	Assert.assertEquals(FaultId, "FAULT_INTERNAL");
	
	String fault = jsonPathVal.get("fault");
	System.out.println("the value of fault is : "+ fault);
	
	Assert.assertEquals(fault, "An internal error occured while servicing the request");
	
	
	}
	
	
	@Test(priority=3)
	public void getWeatherDetailsWith_NullCityTest(){
	//1. specify the base url:
	RestAssured.baseURI = "http://restapi.demoqa.com/utilities/weather/city";
	//RestAssured.baseURI = "https://reqres.in/api/users";

	//2. Define a request:
	 RequestSpecification httpRequest =  RestAssured.given();
	//3. make a request with the parameter and http method:
	 Response response = httpRequest.request(Method.GET, "/null");
	 
	//4. print the response as body: convert response to string:
	 String responseBody = response.getBody().asString();
	System.out.println("Response body is: "+ responseBody);	
		
	//5. get the status code:
	int statusCode = response.getStatusCode();
	System.out.println("the status code is: "+ statusCode);
	Assert.assertEquals(statusCode, 400);
	
	//6. get all the headers:
	String contentType = response.header("Content-Type");
	System.out.println("the content type is: "+ contentType);
		
	Headers allHeaders = response.headers();
	for(Header h : allHeaders){
		System.out.println("the header key:"+ h.getName());
		System.out.println("the header value:"+ h.getValue());
	}
	
	//7. How to validate JSON Response: using Json Path utility:
	JsonPath jsonPathVal = response.jsonPath();
	
	String FaultId = jsonPathVal.get("FaultId");
	System.out.println("the value of FaultId is:"+ FaultId);
	Assert.assertEquals(FaultId, "FAULT_INTERNAL");
	
	String fault = jsonPathVal.get("fault");
	System.out.println("the value of fault is : "+ fault);
	
	Assert.assertEquals(fault, "An internal error occured while servicing the request");
	
	
	}
	
	@Test(priority=4)
	public void getWeatherDetailsWith_BlankCityTest(){
	//1. specify the base url:
	RestAssured.baseURI = "http://restapi.demoqa.com/utilities/weather/city";
	//RestAssured.baseURI = "https://reqres.in/api/users";

	//2. Define a request:
	 RequestSpecification httpRequest =  RestAssured.given();
	//3. make a request with the parameter and http method:
	 Response response = httpRequest.request(Method.GET, "/");
	 
	//4. print the response as body: convert response to string:
	 String responseBody = response.getBody().asString();
	System.out.println("Response body is: "+ responseBody);	
		
	//5. get the status code:
	int statusCode = response.getStatusCode();
	System.out.println("the status code is: "+ statusCode);
	Assert.assertEquals(statusCode, 400);
	
	//6. get all the headers:
	String contentType = response.header("Content-Type");
	System.out.println("the content type is: "+ contentType);
		
	Headers allHeaders = response.headers();
	for(Header h : allHeaders){
		System.out.println("the header key:"+ h.getName());
		System.out.println("the header value:"+ h.getValue());
	}
	
	//7. How to validate JSON Response: using Json Path utility:
	JsonPath jsonPathVal = response.jsonPath();
	
	String FaultId = jsonPathVal.get("FaultId");
	System.out.println("the value of FaultId is:"+ FaultId);
	Assert.assertEquals(FaultId, "FAULT_INVALID_GET_REQUEST");
	
	String fault = jsonPathVal.get("fault");
	System.out.println("the value of fault is : "+ fault);
	
	Assert.assertEquals(fault, "Invalid or Missing GET data, please correct the request");
	
	
	}
	
	@Test(priority=5)
	public void getWeatherDetailsWith_SpecialCharsCityTest(){
	//1. specify the base url:
	RestAssured.baseURI = "http://restapi.demoqa.com/utilities/weather/city";
	//RestAssured.baseURI = "https://reqres.in/api/users";

	//2. Define a request:
	 RequestSpecification httpRequest =  RestAssured.given();
	//3. make a request with the parameter and http method:
	 Response response = httpRequest.request(Method.GET, "/!@#!");
	 
	//4. print the response as body: convert response to string:
	 String responseBody = response.getBody().asString();
	System.out.println("Response body is: "+ responseBody);	
		
	//5. get the status code:
	int statusCode = response.getStatusCode();
	System.out.println("the status code is: "+ statusCode);
	Assert.assertEquals(statusCode, 400);
	
	//6. get all the headers:
	String contentType = response.header("Content-Type");
	System.out.println("the content type is: "+ contentType);
		
	Headers allHeaders = response.headers();
	for(Header h : allHeaders){
		System.out.println("the header key:"+ h.getName());
		System.out.println("the header value:"+ h.getValue());
	}
	
	//7. How to validate JSON Response: using Json Path utility:
	JsonPath jsonPathVal = response.jsonPath();
	
	String FaultId = jsonPathVal.get("FaultId");
	System.out.println("the value of FaultId is:"+ FaultId);
	Assert.assertEquals(FaultId, "FAULT_INTERNAL");
	
	String fault = jsonPathVal.get("fault");
	System.out.println("the value of fault is : "+ fault);
	
	Assert.assertEquals(fault, "An internal error occured while servicing the request");
	
	
	}
	
	
	
	
	
	

}
