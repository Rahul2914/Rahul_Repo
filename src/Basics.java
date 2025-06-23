import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
import files.Payload;
import files.ReuseableMethod;


public class Basics {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//verify if add place API  is working as expected
		//given- all input details
		//when- submit the API
		//Then- validate the response
		
		
		//add place
		
		RestAssured.baseURI= "https://rahulshettyacademy.com";
		String response= given().queryParam("key", "qaclick123").header("content-Type","application/json")
		.body(Payload.Addplace())
		.when().post("maps/api/place/add/json")
		.then().log().all().assertThat().statusCode(200).body("scope", equalTo("APP"))
		.extract().response().asString();
	
		System.out.println(response);
		//for printing the result in json-- we need to create object of JSONPATH class.
		
		JsonPath js= new JsonPath(response); // for parsing json
		String placeId= js.getString("place_id");
		System.out.println(placeId);
		
	
		//update place
		
		// GET place details using place_id
		String getPlaceResponse = given().log().all()
		    .queryParam("key", "qaclick123")
		    .queryParam("place_id", placeId)
		.when()
		    .get("maps/api/place/get/json")
		.then()
		    .log().all()
		    .assertThat().statusCode(200)
		    .extract().response().asString();

		System.out.println("GET Response:\n" + getPlaceResponse);

		JsonPath Js= ReuseableMethod.rawToJson(getPlaceResponse);
		String actualaddress= Js.getString("address");
		System.out.println(actualaddress);
		
		
		//for comparing or validating whether results are correct.
		//use assert.assertEquals(actual, Expected);
		
	}

}
