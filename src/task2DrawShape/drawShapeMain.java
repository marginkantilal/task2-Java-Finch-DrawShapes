package task2DrawShape;

import java.util.ArrayList;
import javax.swing.JOptionPane;
import edu.cmu.ri.createlab.terk.robot.finch.Finch;

public class drawShapeMain {

	public static Finch myFinch = new Finch(); //importing Finch
	public static ArrayList<String> nameOfShapes = new ArrayList<String>(); //arraylist to store shape names & length
	public static ArrayList<Integer> shapeAreas = new ArrayList<Integer>(); //arraylist to store shape areas
	public static ArrayList<String> durationTime = new ArrayList<String>(); //arraylist to store time
	public static ArrayList<String> shapeAngles = new ArrayList<>(); //arraylist to store angles for Triangle

	public static ArrayList<String> recAverageTime = new ArrayList<String>(); //arraylist to store average time
	public static ArrayList<String> squAverageTime = new ArrayList<String>(); //arraylist to store average time
	public static ArrayList<String> triAverageTime = new ArrayList<String>(); //arraylist to store average time

	public static ArrayList<Integer> squareCount = new ArrayList<Integer>(); //storing number of square 
	public static ArrayList<Integer> rectangleCount = new ArrayList<Integer>(); //storing number of rectangle 
	public static ArrayList<Integer> triangleCount = new ArrayList<Integer>();//storing number of triangle 

	public static shapeSelection selectShape = new shapeSelection(); //Creating object class which will be call it as calling method

	public static void main(String args[]) throws Exception { //main method

		JOptionPane.showMessageDialog(null," Welcome to draw the shapes"); //Welcome window with message
		JOptionPane.showMessageDialog(null, "Make sure the finch is in ground level to start the program"); // inform the user to put finch is on ground level

		int i = 0; // 
		do {

			i++; //incrementing by 1
			myFinch.sleep(50); //waits for the finch to be on ground level
			if (i == 100) //it will keep checking for 100 times
			{
				String errorMsg = "Error, the program failed to load up"; // an error msg text
				System.out.println(errorMsg ); //It  displays an error msg until the finch is not on ground level
				String checkfinch = "Please check if the finch is on ground level and try again."; 
				System.out.println(checkfinch);
				i = 0;
			}

		}
		while(!myFinch.isFinchLevel()); //if the finch is on ground level
		System.out.println("Success, starting the program now"); //the program loads up message
		JOptionPane.showMessageDialog(null, "Press Q to quit"+ "\n" + "Press R to draw Rectangle" + "\n" + "Press S to draw Square" + "\n" + "Press T to draw Triangle");
		shapeSelection.selectShape();//calling method  
	}

}
