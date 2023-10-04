package TestNG1;

public class EBLogic {
 public double YearlySalary(EmployeeDetails ed){
	 double YearlySalary = 0;
	 YearlySalary = ed.getM_Salary() * 12;
	return YearlySalary;
	 
 }
 
 //Calculate Bonus 
 public double Cal_Bonus(EmployeeDetails ed) {
	 int bonus =0;
	 if(ed.getM_Salary() < 1000) {
		 bonus = 200;
	 }
	 else
	 {
		 bonus = 500;
	 }
	 return bonus;
 	}
 
 }
