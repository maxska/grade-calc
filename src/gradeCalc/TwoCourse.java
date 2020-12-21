package gradeCalc;


// Two Grade Scale Course - grade can be U or G
public class TwoCourse extends Course
{
	private String grade;
	
	public TwoCourse(String _code, String _name, String _grade)
	{
		super(_code, _name);
		
		if (!checkTheGrade(_grade))
		{
			throw new java.lang.RuntimeException("ERROR: Invalid grade...");
		}
		
		grade = _grade;
	}
	
	public static boolean checkTheGrade(String grade)
	{
		if (grade.equals("U") || grade.equals("G"))
		{
			return true;
		}
		
		return false;
	}
	

	public String getGrade()
	{
		return grade;
	}
	
	public boolean setGrade(String _grade)
	{
		if (checkTheGrade(_grade))
		{
			grade = _grade;
			return true;
		}
		
		return false;
	}

}
