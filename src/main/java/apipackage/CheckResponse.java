package apipackage;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.apache.http.Header;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;
import org.junit.Assert;

public class CheckResponse 
	{
	


	public void ResponseCheck(String url) throws ClientProtocolException, IOException
	{
		
		String Url =url; 
		System.out.println("Request url is" +"\t" +Url);
		HttpClient client  = HttpClientBuilder.create().build();
		HttpGet request = new HttpGet(url);
		System.out.println("the Get request is processing..");
	
		HttpResponse response = client.execute(request);
		System.out.println("the Client is executing a response request");
		int actualResponseCode = response.getStatusLine().getStatusCode();
		System.out.println("Status code is stored in actualResponseCode");
		System.out.println(actualResponseCode);
		int expectedResponseCode = 200;
		Assert.assertEquals(expectedResponseCode, actualResponseCode);
		BufferedReader rd = new BufferedReader
				(new InputStreamReader(response.getEntity().getContent()));
		StringBuffer result = new StringBuffer();
		String line ="";
		while((line=rd.readLine())!=null)
			result.append(line);
			
	
	}
	
	
	
	public void readResponse(String url) throws ClientProtocolException, IOException
	{	
		HttpClient client  = HttpClientBuilder.create().build();
		HttpGet request = new HttpGet(url);
		HttpResponse response = client.execute(request);
		Header[] headers = response.getAllHeaders();
			for (Header header : headers)
			{
				System.out.println("Key : " + header.getName()) ;
		     
				
			}	
					
			String header = response.getFirstHeader("Accept-Ranges").getValue();
			System.out.println(header);
	}
	
	}
