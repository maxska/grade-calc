package gradeCalc;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;

public class GUI extends JFrame
{
	private static final int FRAME_WIDTH  = 400;
	private static final int FRAME_HEIGHT = 600;    
	
	private static JList coursesList;
	
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
		
		
		ArrayList<String> testArray = new ArrayList<String>();
		testArray.add("a");
		testArray.add("b");
		testArray.add("c");
		
		coursesList.setListData(testArray.toArray());
		
	}
	
	
	private void createComponents()
	{
		JPanel mainPanel = new JPanel(new GridBagLayout());
		
		// instance of GridBagConstraints, to be able to change how JPanels are placed:
		GridBagConstraints gbc = new GridBagConstraints();
		
		gbc.gridheight = 1;
		gbc.gridx = 0; // position in x-axis is 0 (from left)
		gbc.gridy = 0; // position in y-axis is 0 (from top)
		gbc.weightx = 1; // width (50% of available space)
		gbc.weighty = 1; // height (50% of available space)
		gbc.anchor = GridBagConstraints.NORTH;
		// the element should all both horizontal and vertical space:
		gbc.fill = GridBagConstraints.BOTH; 
		
		mainPanel.add(coursesList, gbc);
		
		
		JPanel lowerTest = new JPanel(new GridLayout(1, 1));
		
		lowerTest.setBackground(Color.ORANGE);
		
		
		gbc.gridheight = 1;
		gbc.gridx = 0; // position in x-axis is 0 (from left)
		gbc.gridy = 1; // position in y-axis is 0 (from top)
		gbc.weightx = 1; // width (50% of available space)
		gbc.weighty = 1; // height (50% of available space)
		gbc.anchor = GridBagConstraints.NORTH;
		// the element should all both horizontal and vertical space:
		gbc.fill = GridBagConstraints.BOTH; 
		
		mainPanel.add(lowerTest, gbc);
		
		mainPanel.setBackground(Color.GREEN);
		
		
		
		
		JPanel lowerPanel = new JPanel(new GridLayout(2, 2));
		
		lowerPanel.setBackground(Color.LIGHT_GRAY);
		
		
		
		setLayout(new GridLayout(2, 1));
		add(mainPanel);
		add(lowerPanel);
		
	}
}
