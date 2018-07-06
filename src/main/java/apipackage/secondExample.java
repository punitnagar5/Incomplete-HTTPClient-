package apipackage;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import org.apache.http.Header;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

public class secondExample {
public static void main(String[] args) throws ClientProtocolException, IOException
{
	HttpClient client = new DefaultHttpClient();
	HttpGet request = new HttpGet("http://www.vogella.com");
	HttpResponse response = client.execute(request);
	int actualResponseCode = response.getStatusLine().getStatusCode();
		
	BufferedReader reader = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
	{
		String textView = new String();
		String line = "";
		while((line=reader.readLine())!=null)
		{
			textView.append(line);
		}
		System.out.println(textView);
		
		
	}
	Header[] headers = response.getAllHeaders();
	for (Header header : headers)
	{
		System.out.println("Key : " + header.getName()) ;
     
		
	}	
			
	String header = response.getFirstHeader("Keep-Alive").getValue();
	System.out.println(header);
	
	
	
}
}
