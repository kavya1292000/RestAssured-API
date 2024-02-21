package testHTTPmethods;
import org.hamcrest.Matchers;
import org.json.JSONObject;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;

public class PetStorePOSTGETRequest {


	// validate if the response body has your required workspace or not
	// we will make use of Hamrcrest dependency which gives us a class Matchers class
	// And methods to match expected and  actuals results
	
	@Test(priority='1')
	public void ValidatePostmanApi()
	{
		String postman_APIkey= "PMAK-65c9a3a82b1e850001e15e05-b7cbf0402886a643c1766664d62157795d";
		
		RestAssured.given()
		.baseUri("https://api.postman.com")
		.basePath("/workspaces")
		.header("x-api-key",postman_APIkey)
		.when().get()
		.then().statusCode(200)
		.body("workspaces[0].name",Matchers.equalTo("Phase3-Trainer"),
			  "workspaces[0].id",Matchers.equalTo("68b46be6-9cd7-471c-837f-39dae936858b"),
			  "workspaces[0].visibility",Matchers.equalTo("team"))
	
// OR


	.body("workspaces.name",Matchers.hasItems("Phase3-Trainer","My Workspace","myworkspaceNew"),
			  "workspaces.type",Matchers.hasItems("team","personal")
);
			
		
	}
		


}
