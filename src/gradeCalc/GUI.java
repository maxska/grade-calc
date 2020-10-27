package gradeCalc;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.TitledBorder;
import javax.swing.table.TableColumnModel;

public class GUI extends JFrame implements ActionListener
{
	private static final int FRAME_WIDTH  = 400;
	private static final int FRAME_HEIGHT = 600;    
	
	private static JList coursesList;
	private static JButton addCourseButton;
	private static JButton calculateButton;
	private static JLabel averageLabel;
	
	private static JTable coursesTable;
	private static JScrollPane jsp;
	
	
	private JMenuItem saveMenuItem;
	private JMenuItem loadMenuItem;
	private JMenuItem aboutMenuItem;
	 
	
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
		createMenuBar();
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
		averageLabel = new JLabel("?");
		
		String[] columnNames = {"Course code", "Course name", "Grade"};
		Object[][] data = {
				{"ABC001", "Math", 3}, {"ABC002", "Physics", 4}, {"ABC003", "Programming", 5}
		};
		
		coursesTable = new JTable(data, columnNames);
		
		coursesTable.setPreferredScrollableViewportSize(new Dimension(100, 600));
		coursesTable.setFillsViewportHeight(true);
		
		coursesTable.setFont(new Font("Georgia", Font.PLAIN, 15));
		coursesTable.setRowHeight(50);
		
		
		TableColumnModel tcm = coursesTable.getColumnModel();
		tcm.getColumn(0).setPreferredWidth(30);
		tcm.getColumn(1).setPreferredWidth(200);
		tcm.getColumn(2).setPreferredWidth(10);
		
	
		jsp = new JScrollPane(coursesTable);
	}
	
	
	private void createMenuBar()
	{
		 saveMenuItem = new JMenuItem("Save to file");
		 loadMenuItem = new JMenuItem("Load from file");
		 aboutMenuItem = new JMenuItem("About");		
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu fileMenu = new JMenu("File");
		fileMenu.add(saveMenuItem);
		fileMenu.add(loadMenuItem);
		menuBar.add(fileMenu);
		
		
		JMenu aboutMenu = new JMenu("About");
		aboutMenu.add(aboutMenuItem);
		menuBar.add(aboutMenu);
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
		
		addCourseButton.addActionListener(this);
		
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
		
		
		JPanel gradePanel = new JPanel(new GridLayout(1, 2));
		
		gradePanel.add(new JLabel("Average grade: "));
		gradePanel.add(averageLabel);
		
		
		lowerPanel.add(gradePanel);
		
		mainPanel.add(lowerPanel, gbc);	
		
		
		setLayout(new GridLayout(1, 1));
		add(mainPanel);
	}
	
	
	public void actionPerformed(ActionEvent e)
	{
		Object src = e.getSource();
		
		if (src == addCourseButton)
		{
			new AddCourseWindow();
		}
		
	}
}
