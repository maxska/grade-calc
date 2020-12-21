package gradeCalc;

import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.swing.JOptionPane;

public class Logic 
{	
	public static ArrayList<Course> courses = new ArrayList<Course>();
	
	
	public static void addCourse(Course c)
	{
		courses.add(c);
	}
	
	
	public static boolean saveToFile()
	{
		String res = "";
		
		for (int i = 0; i < courses.size(); i++)
		{
			res += courses.get(i).getCode() + ";" 
					+ courses.get(i).getName() + ";" 
					+ courses.get(i).getGrade() + "\n";		
		}
		
		try 
		{					
			PrintWriter pw = new PrintWriter(new FileWriter("program_files/grades.txt"));
			pw.write(res);
			pw.close();
			
			JOptionPane.showMessageDialog(null, "Saved to program_files/grades.txt");
			//return false;
		} 
		catch (FileNotFoundException e1)
		{
			JOptionPane.showMessageDialog(null, "Error finding the file...");
		} 
		catch (IOException e2) 
		{
			JOptionPane.showMessageDialog(null, "Unknown error...");
		}
		
		return true;
	}
	
	
	public void openFromFile()
	{
		
	}
	
	
	public static boolean checkCode(String code)
	{
		return code.length() == 6;
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
			String grade = courses.get(i).getGrade();
			
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
			String grade = courses.get(i).getGrade();
			
			if (grade.equals("U"))
			{
				sum += 1;
			}
			// else, don't count it
		}
		
		return sum;
	}
	
}
