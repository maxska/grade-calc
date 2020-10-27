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
		if (!Logic.codeCheck(_code) || !Logic.nameCheck(_name) || !Logic.gradeCheck(_grade))
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
		if (Logic.codeCheck(_code))
		{
			code = _code;
			return true;
		}
		
		return false;
	}
	
	public boolean setName(String _name)
	{
		if (Logic.nameCheck(_name))
		{
			name = _name;
			return true;
		}
		
		return false;
	}
	
	public boolean setGrade(double _grade)
	{
		if (Logic.gradeCheck(_grade))
		{
			grade = _grade;
			return true;
		}
		
		return false;
	}
}
