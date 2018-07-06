package apipackage;


import java.io.IOException;
 
import org.apache.http.Header;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;
 
public class HttpCilentHeadersExample {
 
    public static void main(String[] args) throws Exception {
        HttpCilentHeadersExample client = new HttpCilentHeadersExample();
        client.getHeaders();
    }
 
    public void getHeaders() {
        try {
            HttpClient client = HttpClientBuilder.create().build();
            HttpGet request = new HttpGet("http://www.technicalkeeda.com/get-request");
            HttpResponse response = client.execute(request);
 
            int responseCode = response.getStatusLine().getStatusCode();
 
            System.out.println("Request Url: " + request.getURI());
            System.out.println("Response Code: " + responseCode);
 
            Header[] headers = response.getAllHeaders();
            for (Header header: headers) {
                System.out.println("Key [ " + header.getName() + "], Value[ " + header.getValue() + " ]");
            }
 
            System.out.println("\nRead Specific Header Value");
            System.out.println("Date Header:- " + response.getFirstHeader("Date").getValue());
 
        } catch (ClientProtocolException e) {
            e.printStackTrace();
        } catch (UnsupportedOperationException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
 
}