package com.qa.tests;

import java.io.IOException;

import org.apache.http.HttpEntity;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import client.RestClient;
import junit.framework.Assert;
import util.TestUtil;

public class HttpGetAPI {
	String url;
	RestClient restClient;
	
	@BeforeMethod
	public void setUp(){
		url = "http://restapi.demoqa.com/utilities/weather/city/";
		
	}
	
	@DataProvider
	public Object[][] getTestData(){
		Object data [][] = TestUtil.getTestData("citydata");
		return data;
	}
	
	@Test(dataProvider = "getTestData")
	public void getWeatherInfo(String cityName) throws ClientProtocolException, IOException{
		restClient = new RestClient();
		CloseableHttpResponse response =  restClient.get(url+cityName);
		
		//1. status code:
		int statusCode = response.getStatusLine().getStatusCode();
		System.out.println("the status code is: "+ statusCode);
		
		Assert.assertEquals(200, statusCode);
		
		//2. get json response:
		HttpEntity entity = response.getEntity();
		String responseString = EntityUtils.toString(entity);
		System.out.println("the response is : "+ responseString);
		
		//String to json conversion:
		JSONObject jsonResponseObj = new JSONObject(responseString);
		System.out.println("the actual json response is: "+jsonResponseObj);
		
//		{
//			"Temperature":"13.944 Degree celsius",
//			"WindDirectionDegree":"255.5 Degree",
//			"Humidity":"83 Percent",
//			"WeatherDescription":"clear sky",
//			"WindSpeed":"1.17 Km per hour",
//			"City":"Pune"
//		}
		
		System.out.println(jsonResponseObj.get("City"));
		System.out.println(jsonResponseObj.get("WeatherDescription"));
		
		Assert.assertEquals(cityName, jsonResponseObj.get("City"));

		String temp = (String) jsonResponseObj.get("Temperature");
		Assert.assertNotNull(temp);
		
		
	}
	
	
	
	

}
