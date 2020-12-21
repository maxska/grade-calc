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
	
	
	public static double calculateAverage()
	{
		double sum = 0;
		int passedCourses = 0;
		int thisGrade;
		
		for (int i = 0; i < courses.size(); i++)
		{
			String grade = Logic.courses.get(i).getGrade();
			
			if (!(grade.equals("G") || grade.equals("U")))
			{
				passedCourses += 1;
				
				try
				{
					thisGrade = Integer.parseInt(grade);
					sum += thisGrade;
				}
				catch(NumberFormatException e)
				{
					System.out.println("An error occurred when converting grade String to int...");
				}
			}
			// else, don't count it
		}
		
		return sum/passedCourses;
	}
	
	
	public static int countFailed()
	{
		int sum = 0;
		
		for (int i = 0; i < courses.size(); i++)
		{
			String grade = Logic.courses.get(i).getGrade();
			
			if (grade.equals("U"))
			{
				sum += 1;
			}
			// else, don't count it
		}
		
		return sum;
	}
	
	
}
