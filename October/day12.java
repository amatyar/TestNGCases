package October;

import org.testng.annotations.Test;

//Group exercises
public class day12 
{
	@Test(groups ={"smoke"})
	public void testCase1() {
		System.out.println("smoke test1");
		
	}
	@Test(groups ={"smoke","regression"})
	public void testCase2() {
		System.out.println("smoke test2");
	}
	@Test(groups ={"smoke"})
	public void testCase3(){
		System.out.println("smoke test3");
	}
}
