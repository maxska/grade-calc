package gradeCalc;

import javax.swing.JFrame;

public class GUI extends JFrame
{
	private static final int FRAME_WIDTH  = 400;
	private static final int FRAME_HEIGHT = 600;    
	
	
	public static void main(String[] args)
	{
		GUI gui = new GUI();
	}
	
	
	/*
	 * Constructor
	 */
	public GUI()
	{
		//intitializeMembers();
		createComponents();
		
		setSize(FRAME_WIDTH, FRAME_HEIGHT);
		setLocation(200, 200);
		setTitle("gradeCalc");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);		
	}
	
	
	private void initializeMembers()
	{
		
	}
	
	
	private void createComponents()
	{
		
	}
}
