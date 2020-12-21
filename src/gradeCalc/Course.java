package gradeCalc;

public abstract class Course 
{
	private String code;
	private String name;
	
	
	/*
	 * Constructor
	 */
	public Course(String _code, String _name)
	{
		if (!Logic.checkCode(_code) || !Logic.checkName(_name))
		{
			throw new java.lang.RuntimeException("ERROR: Invalid values for members in Course class...");
		}
		
		code = _code;
		name = _name;
	}
	
	
	public String getCode()
	{
		return code;
	}
	
	
	public String getName()
	{
		return name;
	}
	
	/*
	public String getGrade()
	{
		return grade;
	}
	*/
	abstract public String getGrade();
	
	
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
	
	/*
	public boolean setGrade(String _grade)
	{
		if (Logic.checkGrade(_grade))
		{
			grade = _grade;
			return true;
		}
		
		return false;
	}
	*/
}
