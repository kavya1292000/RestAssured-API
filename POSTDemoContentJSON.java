package testHTTPmethods;
import org.json.JSONObject;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;

public class POSTDemoContentJSON {
public static void main(String[] args) {
		
		
		JSONObject body = new JSONObject();
		
		body.put("name", "Deba");
		body.put("salary", "12334");
		body.put("age", "33");
		
		RestAssured.given()
		.baseUri("https://dummy.restapiexample.com")
		.basePath("/api/v1")
		.contentType(ContentType.JSON)
		.body(body)
		.when().post("/create")
		.then()
		.statusCode(200).log().all();  // for this URL only , the server is sending requestcode as 200. otherwise for create it is 201
	
	}


}
