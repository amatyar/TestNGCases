package TestNG1;

import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Days8b {
	
	@Parameters({"browser"})
	@Test
public void TestCase_seven(@Optional("chromeC")String bw) {
	System.out.println("Test case 7 is passed");
	System.out.println(bw);
}
}
