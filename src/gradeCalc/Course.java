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
		if (_code.length() > 3 && _code.length() < 10)
		{
			code = _code;
			return true;
		}
		
		return false;
	}
	
	public boolean setName(String _name)
	{
		if (_name.length() > 3 && _name.length() < 10)
		{
			name = _name;
			return true;
		}
		
		return false;
	}
	
	public boolean setGrade(double _grade)
	{
		if (_grade >= 0 && _grade <= 5)
		{
			grade = _grade;
			return true;
		}
		
		return false;
	}
}
