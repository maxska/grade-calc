package gradeCalc;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class AddCourseWindow extends JFrame implements ActionListener
{
	JButton addButton;
	JTextField codeField;
	JTextField nameField;
	JTextField gradeField;
	JRadioButton twoButton;
	JRadioButton fourButton;
		
	
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
		JPanel courseTypePanel = new JPanel(new GridLayout(2, 1));
		twoButton = new JRadioButton("U/G-course");
		fourButton = new JRadioButton("U/3/4/5-course");
		courseTypePanel.add(twoButton);
		courseTypePanel.add(fourButton);
		
		ButtonGroup BG = new ButtonGroup();
		BG.add(twoButton);
		BG.add(fourButton);
		
		
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
		
		setLayout(new GridLayout(5, 1));
		add(courseTypePanel);
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
						+ "Should be 6 characters.");				
				return;	
			}
			
			if (!Logic.checkName(name))
			{
				JOptionPane.showMessageDialog(null, "Invalid course name. "
						+ "Should be longer than 3 characters and shorter than 30.");				
				return;	
			}
			
			if (grade.equals("u"))
				grade = "U";
			else if (grade.equals("g"))
				grade = "G";
			
			code = code.toUpperCase();
			name = name.substring(0, 1).toUpperCase() + name.substring(1, name.length());
			
			if (code.contains(";") || name.contains(";"))
			{
				JOptionPane.showMessageDialog(null, 
						"The fields cannot contain ';'");				
				return;	
			}
			
			if (!Logic.uniqueCourseCode(code))
			{
				JOptionPane.showMessageDialog(null, 
						"This course code has been used before. "
						+ "It needs to be unique.");				
				return;	
			}
				
			
			if (fourButton.isSelected())
			{
				if (!FourCourse.checkTheGrade(grade))
				{
					JOptionPane.showMessageDialog(null, "Invalid course grade. "
							+ "Should be U, 3, 4 or 5.");					
					return;	
				}

				Logic.addCourse(new FourCourse(code, name, grade));
			}
			else if (twoButton.isSelected())
			{
				if (!TwoCourse.checkTheGrade(grade))
				{
					JOptionPane.showMessageDialog(null, "Invalid course grade. "
							+ "Should be U or G.");
					return;	
				}

				Logic.addCourse(new TwoCourse(code, name, grade));
			}
			else
			{
				JOptionPane.showMessageDialog(null, "Select a course type.");
				return;	
			}
			
			JOptionPane.showMessageDialog(null, "Course added successfully");
			GUI.refreshTable();
			dispose();			
		}
	}
}
