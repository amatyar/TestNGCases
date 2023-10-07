package TestNG1;

import org.testng.annotations.Test;

public class Days8c {
	@Test(priority =1)
	public void TestCase_Eight() {
		System.out.println("Test Case Eight pass");
	}
	@Test(priority =2, enabled = false)
	public void TestCase_Nine() {
		System.out.println("Test Case Nine pass");
	}
	@Test(priority =3)
	public void TestCase_Ten() {
		System.out.println("Test Case Ten pass");
	}
	
	
}
