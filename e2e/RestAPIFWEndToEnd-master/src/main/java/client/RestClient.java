package client;

import java.io.IOException;

import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

public class RestClient {
	
	public CloseableHttpResponse get(String url) throws ClientProtocolException, IOException{
		CloseableHttpClient httpClient =  HttpClients.createDefault();
		HttpGet httpGet = new HttpGet(url);//http get request
		CloseableHttpResponse response = httpClient.execute(httpGet); //call the api
		return response;
		
	}
	
	
	
	
	

}
