package gradeCalc;

// Four Grade Scale Course - grade can be U, 3, 4 or 5
public class FourCourse extends Course
{

	private String grade;
	
	public FourCourse(String _code, String _name, String _grade)
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
		if (grade.equals("U") || grade.equals("3") || grade.equals("4") || grade.equals("5"))
		{
			return true;
		}
		
		return false;
	}
	

	public String getGrade()
	{
		return grade;
	}
	
	

}
