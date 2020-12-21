package gradeCalc;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class AddCourseWindow extends JFrame implements ActionListener
{
	JButton addButton;
	JTextField codeField;
	JTextField nameField;
	JTextField gradeField;
		
	
	public AddCourseWindow()
	{
		setSize(300, 200);
		setLocation(200, 200);
		setTitle("Add course");
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setVisible(true);
		
		createComponents();
	}
	
	
	public void createComponents()
	{		
		JPanel codePanel = new JPanel(new GridLayout(1, 2));
		codePanel.add(new JLabel("Course code: "));
		codeField = new JTextField();
		codePanel.add(codeField);

		JPanel namePanel = new JPanel(new GridLayout(1, 2));
		namePanel.add(new JLabel("Course name: "));
		nameField = new JTextField();
		namePanel.add(nameField);

		JPanel gradePanel = new JPanel(new GridLayout(1, 2));
		gradePanel.add(new JLabel("Grade: "));
		gradeField = new JTextField();
		gradePanel.add(gradeField);
		
		addButton = new JButton("Add course");
		
		setLayout(new GridLayout(4, 1));
		add(codePanel);
		add(namePanel);
		add(gradePanel);
		add(addButton);
		
		addButton.addActionListener(this);
	}
	
	
	
	
	public void actionPerformed(ActionEvent e)
	{
		Object src = e.getSource();
		
		if (src == addButton)
		{
			String code = codeField.getText();
			String name = nameField.getText();
			String grade = gradeField.getText();
			
			if (!Logic.checkCode(code))
			{
				JOptionPane.showMessageDialog(null, "Invalid course code. "
						+ "Should be longer than 3 characters and shorter than 10.");				
				return;	
			}
			
			if (!Logic.checkName(name))
			{
				JOptionPane.showMessageDialog(null, "Invalid course name. "
						+ "Should be longer than 3 characters and shorter than 30.");				
				return;	
			}
			
			if (!grade.equals("U") && !grade.equals("u"))
			{				
				if (!Logic.checkGrade(grade))
				{
					JOptionPane.showMessageDialog(null, "Invalid course grade. "
							+ "Should be 3, 4, 5 or U.");				
					return;	
				}
			}
			
			
			
			if (grade.equals("U") || grade.equals("u"))
			{
				Logic.addCourse(new Course(code, name, null));
			}
			else
			{
				Logic.addCourse(new Course(code, name, grade));
			}
			
			JOptionPane.showMessageDialog(null, "Course added successfully");
			
			GUI.refreshTable();
			
			dispose();			
		}
	}
}
