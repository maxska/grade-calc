package gradeCalc;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

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
					+ courses.get(i).getGrade() + ";";
			
			if (courses.get(i) instanceof TwoCourse)
				res += "t";
			else if (courses.get(i) instanceof FourCourse)
				res += "f";
			else if (courses.get(i) instanceof CourseSeparator)
				res += "s";
			else
				throw new java.lang.RuntimeException(
						"ERROR: Invalid class when saving to file...");
			
			res += "\n";
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
	
	
	public static void openFromFile()
	{
		if (courses.size() > 0)
		{
			int answer = JOptionPane.showConfirmDialog(null,
					"You have unsaved work, do you want to open file and overwrite it?",
					"Warning",
					JOptionPane.YES_NO_OPTION);
			
			if (answer == JOptionPane.NO_OPTION)
			{
				return;
			}
			// proceed otherwise
			
			courses.clear();
		}
		
		
		try
		{
			Scanner s = new Scanner(new File("program_files/grades.txt"));
			
			while (s.hasNextLine())
			{
				String lineString = s.nextLine();
				String line[] = lineString.split(";");
				
				if (line[3].equals("t"))
				{
					courses.add(new TwoCourse(line[0], line[1], line[2]));
				}
				else if (line[3].equals("f"))
				{
					courses.add(new FourCourse(line[0], line[1], line[2]));					
				}
				else if(line[3].equals("s"))
				{
					String name = line[1].replaceAll("-", "");
					courses.add(new CourseSeparator(name));			
				}
				else
				{
					throw new java.lang.RuntimeException(
							"ERROR: Invalid class when reading to file...");
				}
			}
			
			GUI.refreshTable();
			JOptionPane.showMessageDialog(null, "Opened program_files/grades.txt");
		}
		catch (FileNotFoundException e)
		{
			System.out.println("File not found...");
		}
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
	
	public static boolean uniqueCourseCode(String code)
	{
		for (int i = 0; i < courses.size(); i++)
		{
			if (courses.get(i).getCode().equals(code))
			{
				return false;
			}
		}
		
		return true;
	}
	
	/*
	 * Perhaps a temporary solution...
	 */
	public static void addSeparator()
	{
		String answer = JOptionPane.showInputDialog(null, "Enter the text for the separator:");
		courses.add(new CourseSeparator(answer));
		
		GUI.refreshTable();
	}
}
