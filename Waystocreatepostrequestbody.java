package Day2;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.HashMap;

public class Waystocreatepostrequestbody {
	
/*	1.Hashmap
	2.org.json
	3.using pojo(plain old java object) class
	4.using external json file
	*/
@Test(priority=1)
void testpostusingHashMap()
{
	HashMap data = new HashMap();
	data.put("name", "Scott");
	data.put("location","Scotland");
	data.put("phonenumber","987623221");
	
	String courseArr[]= {"C","C++"};
	data.put("courses",courseArr);
	
	given()
		.contentType("application/json")
		.body(data)
	.when()
		.post("https://localhost:3000/students")
		
	.then()
		.statusCode(201)
		.body("name", equalTo("Scott"))
		.body("location",equalTo("France"))
		.body("phonenumber",equalTo("987623221"))
		.body("courses[0]", equalTo("C"))
		.body("courses[1]", equalTo("C++"))
		.header("Content-Type","application/json; charset=utf-8")
		.log().all();
}
@Test(priority=2)
void TestDelete()
{
	
	given()
	
	.when()
		.delete("https://localhost:3000/students/4")
	
	.then()
		.statusCode(200);
		
}
}
