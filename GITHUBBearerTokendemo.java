package testHTTPmethods;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.response.Response;

public class GITHUBBearerTokendemo {
	@Test
	public void githubaipi_test()
	{
	Response res= 	RestAssured.given()
		.baseUri("https://api.github.com")
		.basePath("/user/repos")
		.header("Authorization","Bearer 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")
		.when().get()
		.then().statusCode(200)
		.extract().response();
		
	res.prettyPrint();
		
	}
	
	@Test(priority='2')
	public void githubaipi_Getonerepo()
	{
		String ownerRepo = "/sonal04devops/DevOps-08Aug-In-class-Notes";
	
		
	Response res= 	RestAssured.given()
		.baseUri("https://api.github.com/repos")
		.basePath(ownerRepo)
		.header("Authorization","Bearer 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")
		.when().get()
		.then().statusCode(200)
		.extract().response();
		
	res.prettyPrint();
		
	}
	


}
