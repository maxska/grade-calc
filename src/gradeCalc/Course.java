package gradeCalc;

public class Course 
{
	private String code;
	private String name;
	private double grade;
	
	
	/*
	 * Constructor
	 */
	public Course(String _code, String _name, double _grade)
	{
		if (!Logic.checkCode(_code) || !Logic.checkName(_name) || !Logic.checkGrade(_grade))
		{
			throw new java.lang.RuntimeException("ERROR: Invalid values for members in Course class...");
		}
		
		code = _code;
		name = _name;
		grade = _grade;
	}
	
	public String getCode()
	{
		return code;
	}
	
	public String getName()
	{
		return name;
	}
	
	public double getGrade()
	{
		return grade;
	}
	
	
	public boolean setCode(String _code)
	{
		if (Logic.checkCode(_code))
		{
			code = _code;
			return true;
		}
		
		return false;
	}
	
	public boolean setName(String _name)
	{
		if (Logic.checkName(_name))
		{
			name = _name;
			return true;
		}
		
		return false;
	}
	
	public boolean setGrade(double _grade)
	{
		if (Logic.checkGrade(_grade))
		{
			grade = _grade;
			return true;
		}
		
		return false;
	}
}
