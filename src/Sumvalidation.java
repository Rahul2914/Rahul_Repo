import org.testng.annotations.Test;

import files.Payload;
import io.restassured.path.json.JsonPath;

public class Sumvalidation {

	
	@Test
	public void sumOfcourse()
	{
		
		int sum =0;
		JsonPath js= new JsonPath(Payload.CoursePrice());
		
		int count = js.getInt("courses.size()");
		for(int i=0;i<count;i++) {
			 
			 
			int courseprice = js.getInt("courses["+i+"].price");
			int coursecopies = js.getInt("courses["+i+"].copies");
			int amount = courseprice *coursecopies;
			System.out.println(amount);
			sum = sum + amount;
			System.out.println(amount);
		
	}
	
	
}
}
