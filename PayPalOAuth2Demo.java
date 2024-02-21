package testHTTPmethods;
import org.apache.http.entity.ContentType;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.response.Response;

public class PayPalOAuth2Demo {


	// Step 1 : Go to link : https://developer.paypal.com/
	// Sign up in paypal using your gmail id
	// In order to test OAUth2 authorization we need client id and client secret
	// We have to generate it on paypal dashboard
	// On our account --> click on dashboard
	// click on apps & credentials
	// Click on create App --> give a unique Name and select type as Platform
	// Country = United states
	// click on Create App
	// Copy the Client ID and secret
	// Now go to APIs & SDKs on the top --> click on Rest APis, to get the Rest api URL
	// We have to now write code to get the bearer token
	
	String clientid= "ARusOV9piJu7WnUWqcEFKsaG36cWGUQymrb6zNg67evPQYXwNusFwdphkHSwhtC1vXZ-R4tU1OTmaJGg";
	
	String clientsecret= "EJuqVbnoVWwHT7l4dhdRSQCIZDK0HUCUkVeQ51RufPlA4Fp2NIVJPaiB3V-H5mAyJyEXFZlenVyosRWO";
	
	String accesstoken;
	
	@Test
	public void getBearerToken()
	{
		Response res = RestAssured.given()
		.baseUri("https://api-m.sandbox.paypal.com")
		.basePath("/v1/oauth2/token")
		.auth().preemptive().basic(clientid, clientsecret)
		.param("grant_type", "client_credentials")
		.when().post();
		
		// res.prettyPrint();
		
		accesstoken =	res.getBody().path("access_token");
		
		System.out.println(accesstoken);
	}
	
	
	@Test
	public void paypalApitest()
	{
		RestAssured.given()
		.baseUri("https://api-m.sandbox.paypal.com")
		.basePath("/v2/invoicing/invoices")
		.queryParam("page", "3")
		.queryParam("page_size", "4")
		.queryParam("total_required", true)
		.auth().oauth2(accesstoken)
		.when().get()
		.then().statusCode(200).log().all();
	}


}
