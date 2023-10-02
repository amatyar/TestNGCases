package TestNG1;

public class EmployeeDetails {
	private String name;
	private double Salary;
	private int age;
	public void EmployeeDetails(String nm, double sl,int ag) {
		this.name =   nm;
		this.Salary = sl;
		this.age   =  ag;				
	}
	public String getName() 
	{
		return name;
	}
	public void setName(String nm) {
		this.name = nm;
	}
	public double getM_Salary() 
	{
		return Salary;
	}
	public void setM_Salary(double sl) {
		this.Salary = sl;
	}
	public int getAge() 
	{
		return age;
	}
	public void setAge(int ag) {
		this.age = ag;
	}
	public double M_getSalary() {
		// TODO Auto-generated method stub
		return 0;
	}

}
