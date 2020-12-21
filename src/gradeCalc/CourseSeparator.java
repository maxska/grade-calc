package gradeCalc;


/*
 * Temporary solution for separators
 */
public class CourseSeparator extends Course
{
	private String grade;

	public CourseSeparator(String name) 
	{
		super(" ", "--------------------" + name + "--------------------");
		grade = " ";
	}
	
	@Override
	public boolean checkCode(String code)
	{
		return true;
	}
	
	@Override
	public boolean checkName(String name)
	{
		return true;
	}

	
	public String getGrade() {
		return grade;
	}

	
	public boolean setGrade(String grade) {
		return false;
	}
}
