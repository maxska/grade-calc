package gradeCalc;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.TitledBorder;
import javax.swing.table.TableColumnModel;

public class GUI extends JFrame
{
	private static final int FRAME_WIDTH  = 400;
	private static final int FRAME_HEIGHT = 600;    
	
	private static JList coursesList;
	private static JButton addCourseButton;
	private static JButton calculateButton;
	
	private static JTable coursesTable;
	private static JScrollPane jsp;
	 
	public static void main(String[] args)
	{
		GUI gui = new GUI();
	}
	
	
	/*
	 * Constructor
	 */
	public GUI()
	{
		initializeMembers();
		createComponents();
		
		setSize(FRAME_WIDTH, FRAME_HEIGHT);
		setLocation(200, 200);
		setTitle("gradeCalc");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);		
	}
	
	
	private void initializeMembers()
	{
		coursesList = new JList();
		addCourseButton = new JButton("Add course");
		calculateButton = new JButton("Calculate");
		
		String[] columnNames = {"Course code", "Course name", "Grade"};
		Object[][] data = {
				{"ABC001", "Math", 3}, {"ABC002", "Physics", 4}, {"ABC003", "Programming", 5}
		};
		
		coursesTable = new JTable(data, columnNames);
		
		coursesTable.setPreferredScrollableViewportSize(new Dimension(100, 600));
		coursesTable.setFillsViewportHeight(true);
		
		coursesTable.setFont(new Font("Georgia", Font.PLAIN, 15));
		coursesTable.setRowHeight(50);
		
		/*
		TableColumnModel tcm = coursesTable.getColumnModel();
		tcm.getColumn(0).setPreferredWidth(200);
		tcm.getColumn(1).setPreferredWidth(3330);
		tcm.getColumn(2).setPreferredWidth(330);
		*/
		
	
		jsp = new JScrollPane(coursesTable);
	}
	
	
	private void createComponents()
	{
		TitledBorder coursesBorder = BorderFactory.createTitledBorder("Courses");
		coursesList.setBorder(coursesBorder);
		
		
		JPanel mainPanel = new JPanel(new GridBagLayout());
		
		// instance of GridBagConstraints, to be able to change how JPanels are placed:
		GridBagConstraints gbc = new GridBagConstraints();
		
		gbc.gridheight = 1;
		gbc.gridx = 0; // position in x-axis is 0 (from left)
		gbc.gridy = 0; // position in y-axis is 0 (from top)
		gbc.weightx = 1; // width (100% of available space)
		gbc.weighty = 1; // height (100% of available space)
		gbc.anchor = GridBagConstraints.NORTH;
		// the element should all both horizontal and vertical space:
		gbc.fill = GridBagConstraints.BOTH; 
		
		//mainPanel.add(coursesList, gbc);
		
		
		mainPanel.add(jsp, gbc);
		
		
		
		JPanel lowerPanel = new JPanel(new GridLayout(3, 1));
		lowerPanel.add(addCourseButton);
		lowerPanel.add(calculateButton);
		
		lowerPanel.setBackground(Color.ORANGE);
		
		gbc.gridheight = 1;
		gbc.gridx = 0; // position in x-axis is 0 (from left)
		gbc.gridy = 1; // position in y-axis is 1 (from top)
		gbc.weightx = 0;
		gbc.weighty = 0; 
		gbc.anchor = GridBagConstraints.SOUTH;
		// the element should all both horizontal and vertical space:
		gbc.fill = GridBagConstraints.HORIZONTAL; 
		
		mainPanel.add(lowerPanel, gbc);	
		
		
		setLayout(new GridLayout(1, 1));
		add(mainPanel);
		
	}
}
