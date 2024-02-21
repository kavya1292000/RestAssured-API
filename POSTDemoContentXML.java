package testHTTPmethods;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;

public class POSTDemoContentXML {
	public static void main(String [] args)
	{
		
		String xmlrequestBody = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\r\n"
				+ "<Pet>\r\n"
				+ "	<id>0</id>\r\n"
				+ "	<Category>\r\n"
				+ "		<id>123</id>\r\n"
				+ "		<name>string</name>\r\n"
				+ "	</Category>\r\n"
				+ "	<name>dog</name>\r\n"
				+ "	<photoUrls>\r\n"
				+ "		<photoUrl>string</photoUrl>\r\n"
				+ "	</photoUrls>\r\n"
				+ "	<tags>\r\n"
				+ "		<Tag>\r\n"
				+ "			<id>0</id>\r\n"
				+ "			<name>string</name>\r\n"
				+ "		</Tag>\r\n"
				+ "	</tags>\r\n"
				+ "	<status>available</status>\r\n"
				+ "</Pet>";
		
		
		RestAssured.given()
		.baseUri("https://petstore.swagger.io")
		.basePath("/v2/pet")
		.contentType(ContentType.XML)
		.body(xmlrequestBody)
		.when().post()
		.then()
		.statusCode(200)
		.log().all();
		
		
	
	}


}
