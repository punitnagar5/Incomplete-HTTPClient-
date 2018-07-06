import java.io.IOException;

import org.apache.http.client.ClientProtocolException;
import org.testng.annotations.Test;

import apipackage.CheckResponse;

public class TestCheckResponse {

	String link;
	CheckResponse checkres;
	public TestCheckResponse()
	{
		checkres = new CheckResponse();
		 link ="http://www.technicalkeeda.com/get-request";
			
	}
	@Test
	public void Testcheck() throws ClientProtocolException, IOException
	{	
		checkres.ResponseCheck(link);
	}
	
	@Test
	public void TestReadResponse() throws ClientProtocolException, IOException
	{
		checkres.readResponse(link);
	}
}
