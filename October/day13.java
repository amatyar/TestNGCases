package October;

import org.testng.Assert;
import org.testng.annotations.Test;

public class day13 {
	@Test
	public void login() {
		System.out.println("Executing the login test case");
		Assert.assertEquals(true, true);
	}
	
	@Test(dependsOnMethods = "Login")
	public void search(){
		System.out.println("Executing the search testcase");
		Assert.assertEquals(false, true);
	}	
	
	@Test(dependsOnMethods = {"Login","search"})
	public void addToCart(){
		System.out.println("Adding the testcase to cart");
	}
}
