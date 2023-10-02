package TestNG1;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TestEmployeeDetails {

	EmployeeDetails ed = new EmployeeDetails();
	EBLogic eb = new EBLogic();
	
	@Test
	public void testCalBonus() {
	ed.setName("Rabindra");
	ed.setAge(45);
	ed.setM_Salary(500);
	
	//double salary = ;
	double bonus = eb.Cal_Bonus(ed);
	Assert.assertEquals(200, bonus, 0.0, "200");
	}
	
	@Test
	public void testCalYearlySal() {
		ed.setName("Rabindra");
		ed.setAge(45);
		ed.setM_Salary(8000);
		
		double salary = eb.YearlySalary(ed);
		Assert.assertEquals(6000, salary, 0.0, "200");
	}
}
