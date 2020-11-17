package gradeCalc;

import java.util.ArrayList;

public class Logic 
{	
	ArrayList<Course> courses = new ArrayList<Course>();
	
	
	
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
	
	public static boolean checkGrade(double grade)
	{
		if (grade >= 0 && grade <= 5)
		{
			return true;
		}
		
		return false;
	}
	
	
	
	
	
	
}
