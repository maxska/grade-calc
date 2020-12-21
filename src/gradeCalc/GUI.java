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
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;
import javax.swing.table.TableModel;

public class GUI extends JFrame implements ActionListener
{
	// ########################################################################
	//                              Members
	// ########################################################################
	
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
	
	
	// ########################################################################
	//                              Functions
	// ########################################################################
	
	
	/*
	 * Main function, initializes the gui by calling the GUI constructor.
	 */
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
	
	
	/*
	 * Refreshes coursesTable by rebuilding the tableModel 
	 * from all courses in Logic.java
	 */
	public static void refreshTable()
	{
		//System.out.println("before");
		//System.out.println(Logic.courses.size());
		
		DefaultTableModel tableModel = getTableModel();
		
		//coursesTable = new JTable(tableModel);	
		
		for (int i = 0; i < Logic.courses.size(); i++)
		{
			String code = Logic.courses.get(i).getCode();
			String name = Logic.courses.get(i).getName();
			String grade = Logic.courses.get(i).getGrade();
			
			Object[] obj = {code, name, grade};
			
			tableModel.addRow(obj);
		}
		
		//tableModel.fireTableDataChanged();
		coursesTable.setModel(tableModel);

		//System.out.println("after");
	}
	
	
	/*
	 * Creates a DefaultTableModel containing the column headers and returns it
	 */
	private static DefaultTableModel getTableModel()
	{
		String columnNames[] = {"Course code", "Course title", "Grade"};
		DefaultTableModel tableModel = new DefaultTableModel(columnNames, 0);
		return tableModel;		
	}
	
	
	/*
	 * Handles the actions in the gui, e.g. clicking
	 */
	public void actionPerformed(ActionEvent e)
	{
		Object src = e.getSource();
		
		if (src == addCourseButton)
		{
			new AddCourseWindow();
		}
		
		if (src == calculateButton)
		{
			double average = Logic.calculateAverage();
			int failed = Logic.countFailed();
			
			JOptionPane.showMessageDialog(null, "Calculated");
			
			if (failed == 0)
			{
				averageLabel.setText("Average: " + average);
			}
			else
			{
				averageLabel.setText("Average: " + average + ", with " + failed + " failed");
			}
		}
	}
	
	
	// ########################################################################
	//                              Initialization
	// ########################################################################

	/*
	 * Initializing members of this class
	 */
	private void initializeMembers()
	{
		coursesList = new JList();
		addCourseButton = new JButton("Add course");
		calculateButton = new JButton("Calculate");
		averageLabel = new JLabel("Average grade hasn't been calculated yet");
		
		DefaultTableModel tableModel = getTableModel();
		coursesTable = new JTable(tableModel);
		Logic.addCourse(new FourCourse("ABC001", "Math", "3"));  // for testing
		refreshTable();
		
		coursesTable.setPreferredScrollableViewportSize(new Dimension(100, 600));
		coursesTable.setFillsViewportHeight(true);
		
		coursesTable.setFont(new Font("Georgia", Font.PLAIN, 15));
		coursesTable.setRowHeight(50);
		
		//TableColumnModel tcm = coursesTable.getColumnModel();
		//tcm.getColumn(0).setPreferredWidth(30);
		//tcm.getColumn(1).setPreferredWidth(200);
		//tcm.getColumn(2).setPreferredWidth(10);
	
		jsp = new JScrollPane(coursesTable);
	}
	
	
	/*
	 * Creates the menu bar in the gui
	 */
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
	
	
	/*
	 * Creates and adds components to the gui
	 */
	private void createComponents()
	{		
		TitledBorder coursesBorder = BorderFactory.createTitledBorder("Courses");
		coursesList.setBorder(coursesBorder);
		
		
		JPanel mainPanel = new JPanel(new GridBagLayout());
		
		// instance of GridBagConstraints, to be able to change how JPanels 
		// are placed:
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
		calculateButton.addActionListener(this);
		
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
		
		gradePanel.add(averageLabel);
		
		
		lowerPanel.add(gradePanel);
		
		mainPanel.add(lowerPanel, gbc);	
		
		
		setLayout(new GridLayout(1, 1));
		add(mainPanel);
	}
	
}



