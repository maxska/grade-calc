package gradeCalc;

import java.util.ArrayList;

public class Logic 
{	
	public static ArrayList<Course> courses = new ArrayList<Course>();
	
	public static void addCourse(Course c)
	{
		courses.add(c);
	}
	
	public void saveToFile()
	{
		
	}
	
	
	public void openFromFile()
	{
		
	}
	
	
	public static boolean checkCode(String code)
	{
		if (code.length() > 3 && code.length() < 10)
		{
			return true;
		}
		
		return false;
	}
	
	
	public static boolean checkName(String name)
	{
		if (name.length() > 3 && name.length() < 30)
		{
			return true;
		}
		
		return false;
	}
	
	/*
	public static boolean checkGrade(String grade)
	{
		if (grade == null)
		{
			return true;
		}
		
		if (grade.equals("3") || grade.equals("4") || grade.equals("5"))
		{
			return true;
		}
		
		return false;
	}
	*/
	
	
	
	
	
	
}
