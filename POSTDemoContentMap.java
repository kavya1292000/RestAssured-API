package testHTTPmethods;
import java.util.HashMap;
import io.restassured.RestAssured;

public class POSTDemoContentMap {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// create a hash map to store key and value
		// these values we are going to send with our POST request
	
		
		HashMap<String,String> map = new HashMap<String, String>();
		
		map.put("name", "Sally");
		map.put("job", "tester");
		
		RestAssured.given()
		.baseUri("https://reqres.in/")   // URL
		.basePath("/api/users")  // request path
		.contentType("application/json") // what type of content boday we are sending - JSON
		.body(map)
		.when().post()
		.then().statusCode(201).log().all();
		
		
		
	}


}
