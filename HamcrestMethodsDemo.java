package testHTTPmethods;
import static org.hamcrest.Matchers.*;
import org.hamcrest.Matchers;
import org.testng.annotations.Test;
import io.restassured.RestAssured;

public class HamcrestMethodsDemo {


	// contains() method. it will check response body of the request
	// contains desired items or not. Also it will check in a strict order
	
	String PMkey= "PMAK-65c9a3a82b1e850001e15e05-b7cbf0402886a643c1766664d62157795d";
	
	public void container_method_demo()
	{
		RestAssured.given()
		.baseUri("https://api.postman.com")
		.basePath("/workspaces")
		.header("x-api-key",PMkey)
		.when().get()
		.then()
		.statusCode(200)
		.body("workspaces.name", contains("Phase3-Trainer","My Workspace","Pahse3-Lesson2"));
		
		
		
	}
	
	
	
	//@Test  // validate if the response body is empty or not
	public void empyMehtoddemo()
	{
		RestAssured.given()
		.baseUri("https://api.postman.com")
		.basePath("/workspaces")
		.header("x-api-key",PMkey)
		.when().get()
		.then()
		.statusCode(200)
		.body("workspaces.name", empty());
		// assertion will occur as response body is not empty
		// if response body is empty , our test will be success
	}
	
	
	
	//@Test  // validate if the response body is empty or not
	public void IsNotEmpyMehtoddemo()
	{
		RestAssured.given()
		.baseUri("https://api.postman.com")
		.basePath("/workspaces")
		.header("x-api-key",PMkey)
		.when().get()
		.then()
		.statusCode(200)
		.body("workspaces.name", is(not(empty())));
		// assertion will occur as response body is not empty
		// if response body is empty , our test will be success
	}
	
	// hasSize() : check if the given number of collection value is as expected or not
	// if Iam expecting numbe rof workspaces to be 15, hasSize will check the repsonse body for number of workspace in the repsonse
	
	
	//@Test  // validate if the response body is empty or not
	public void hasSizeMehtoddemo()
	{
		RestAssured.given()
		.baseUri("https://api.postman.com")
		.basePath("/workspaces")
		.header("x-api-key",PMkey)
		.when().get()
		.then()
		.statusCode(200)
		.body("workspaces.name", hasSize(16))
		.body("workspaces.name", Matchers.hasItems("myworkspaceNew"));
		
	}
	
	
	//@Test
	public void everyItemMehtoddemo()
	{
		RestAssured.given()
		.baseUri("https://api.postman.com")
		.basePath("/workspaces")
		.header("x-api-key",PMkey)
		.when().get()
		.then()
		.statusCode(200)
		.body("workspaces.name", everyItem(startsWith("Team")));
		
	}
	
	//@Test
	public void hasKeyMehtoddemo()
	{
		RestAssured.given()
		.baseUri("https://api.postman.com")
		.basePath("/workspaces")
		.header("x-api-key",PMkey)
		.when().get()
		.then()
		.statusCode(200)
		.body("workspaces[0]", hasKey("id"));
	
	}
	
	
	@Test
	public void hasValueMehtoddemo()
	{
		RestAssured.given()
		.baseUri("https://api.postman.com")
		.basePath("/workspaces")
		.header("x-api-key",PMkey)
		.when().get()
		.then()
		.statusCode(200)
		.body("workspaces[0]", hasValue("team"));
	
	}
	
	// assert if a collection has a entry ==> key and value
	
	//@Test
	public void hasEntryMehtoddemo()
	{
		RestAssured.given()
		.baseUri("https://api.postman.com")
		.basePath("/workspaces")
		.header("x-api-key",PMkey)
		.when().get()
		.then()
		.statusCode(200)
		.body("workspaces[0]", hasEntry("id","Phase3-Trainer"));
	
	}
	
	
	// check in the response body we have an entry starting with a String or contains a String
	
	
	@Test
	public void AnyOfMehtoddemo()
	{
		RestAssured.given()
		.baseUri("https://api.postman.com")
		.basePath("/workspaces")
		.header("x-api-key",PMkey)
		.when().get()
		.then()
		.statusCode(200)
		.body("workspaces[0].name",anyOf(startsWith("3"),containsString("Trainer")));
	// we have used 2 assertion methods
		
	}
	


}
