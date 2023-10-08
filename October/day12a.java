package October;

import org.testng.annotations.Test;

public class day12a {
	@Test(groups ={"Login"})
	public void testCase4() {
		System.out.println("login test case one");
	}
	@Test(groups ={"regression"})
	public void testCase5() {
		System.out.println("regression testing");
	}
	@Test(groups ={"Login"})
	public void testCase6(){
		System.out.println("login test case two");
	}
}
