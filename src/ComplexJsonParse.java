import files.Payload;
import io.restassured.path.json.JsonPath;

public class ComplexJsonParse {

	
	public static void main(String[] args) {
		
		JsonPath js= new JsonPath(Payload.CoursePrice());
		
		int count = js.getInt("courses.size()");
		System.out.println(count);
		
		 int totalamount = js.getInt("dashboard.purchaseAmount");
		 System.out.println(totalamount);
		 
		 String courses= js.get("courses[0].title");
		 System.out.println(courses);
		 String courses2= js.get("courses[1].title");
		 System.out.println(courses2);
		 String courses3= js.get("courses[2].title");
		 System.out.println(courses3);
		 int Coursecopies= js.getInt("courses[0].copies");
		 System.out.println(Coursecopies);
		 
		 //print all course title and their respective price
		 for(int i=0;i<count;i++) {
			 
			 String courseTitle= js.get("courses["+i+"].title");
			int courseprice = js.getInt("courses["+i+"].price");
			int coursecopies = js.getInt("courses["+i+"].copies");
			 System.out.println(courseTitle);
			 System.out.println(courseprice);
			 System.out.println(coursecopies);
		 }
			 //
			 System.out.println("Print number of copy sold by RPA");
			 
			 for(int i=0;i<count;i++) {
				 
				 String courseTitle= js.get("courses["+i+"].title");
				 if(courseTitle.equalsIgnoreCase("RPA")) {
					 
					 int coursecopies = js.getInt("courses["+i+"].copies");
					 System.out.println(coursecopies);
					 
				 }	 
				 
			 
				 if(courseTitle.equalsIgnoreCase("Cypress")) {
					 
					 int courseprice = js.getInt("courses["+i+"].price");
					 System.out.println(courseprice);
					 
				 }
			 
		 }
	}
}
