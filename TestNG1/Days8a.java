package TestNG1;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Days8a {
	
	@Parameters({"browser", "username","password","dbadmin"})
	@Test
	public void TestCase_Four(String bw, String un, String pwd, String db) {
		System.out.println("Test case four is passed");
		System.out.println(bw +""+ un+"" + pwd +""+ db);
	}
	
	@Test
	public void TestCase_Five() {
		System.out.println("Test case Five is passed");
		
	}
	
	@Test
	public void TestCase_Six() {
		System.out.println("Test case six is passed");
		
	}


}
