package Day3;
import org.testng.annotations.Test;
import io.restassured.response.Response;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.Map;
public class CookiesDemo {
	
	//@Test(priority=1)
	void TestCookies()
	{
		given()
		
		.when()
			.get("https://www.google.com/")
		
		.then()
			.cookie("AEC","Ae3NU9NebgCbonwOakm8Poti-iVy6L49fbP7PlzfaPzt9_mRan84EZVT5Q")
			.log().all();
	}
	@Test(priority=2)
	void GetCookiesInfo()
	{
		Response res=given()
		
		.when()
			.get("https://www.google.com/");
		
	// get single cookie information
		//String cookie_value=res.getCookie("AEC");
		//System.out.println("The value of cookie is:"+cookie_value);
		
	// get all the cookies information
		
		Map<String,String>cookies_values = res.getCookies();
		
		//System.out.println(cookies_values.keySet());
		
		for(String k:cookies_values.keySet())
		{
			String cookie_value=res.getCookie(k);
			System.out.println(k+"     "+cookie_value);
		}
		}
	}
	

