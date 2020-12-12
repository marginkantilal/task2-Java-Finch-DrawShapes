package task2DrawShape;
import javax.swing.JOptionPane;

public class drawRectangle extends drawSquare {

	public static shapeSelection selectShape = new shapeSelection(); //Creating object class which will be call it as calling method

	public static int recLength ; // integer length
	public static int recWidth ; // integer length
	public static String  getRecLength=""; //String length
	public static String  getRecWidgth=""; //String length

	public static int numOfRec = 0; //number of rectangle 

	public static void askForInput() throws Exception  { //asking and checking valid length whether it is empty or number is not entered
		getRecLength = JOptionPane.showInputDialog(null,"Please enter the length of Rectangle Side 1 "); //Asking for the length of the Rectangle side 1
		getRecWidgth = JOptionPane.showInputDialog(null,"Please enter the length of Rectangle Side 2 "); //Asking for the length of the Rectangle side 2
		while(getRecLength.isEmpty()  ) { //empty then show an error msg
			if(getRecLength.isEmpty()) { //Checks if length is not entered
				JOptionPane.showMessageDialog(null," You didn't input anything, please input value"); //Displays Error message if length box is empty
				getRecLength = JOptionPane.showInputDialog(null,"Please enter the length of Rectangle Side 1 "); //Asking for the length of the Rectangle side 1
			}

			else if (getRecWidgth.isEmpty()) { //checks if the width box is empty
				JOptionPane.showMessageDialog(null," You didn't input anything, please input value"); //Displays Error message if it is empty
				getRecWidgth = JOptionPane.showInputDialog(null,"Please enter the length of Rectangle Side 2 "); //Asking for the length of the Rectangle side 2
			}
		}
		try {
			recLength = Integer.parseInt(getRecLength);  //converting string to integer
			recWidth = Integer.parseInt(getRecWidgth);  //converting string to integer
		}
		catch(NumberFormatException e) {  //only positive integer should be accepted if not it displays an error msg
			JOptionPane.showMessageDialog(null, "Values must be positive integers! Try Again"); // An Error msg
			getRecLength =""; 
			askForInput(); //Re-enter the length
			getRecWidgth="";
			askForInput(); //Re-enter the length
		}

		drawRec();//Calling another method
	}

	public static void drawRec() throws Exception { //main method to check valid length between 15cm and 85
		if (recLength < 15 || recLength > 85) {  //checks the user length between 15cm and 85
			JOptionPane.showMessageDialog(null," Invalid input, please enter a length between 15cm to 85 cm. "); //invalid input and error message displays
			getRecLength =" "; 
			askForInput(); //calling method
		}

		else if (recWidth < 15 || recWidth > 85) //checks if the width is between 15 to 85 cm
		{
			JOptionPane.showMessageDialog(null," Invalid input, please enter a length between 15cm to 85 cm. "); //invalid input and error message displays
			getRecWidgth=" ";
			askForInput(); //calling method
		} 

		else {
			drawTheRectangle(); //Calling method where it will start drawing the shape
		}
	}

	public static void	drawTheRectangle() throws Exception  {	//drawing the shape mehtod
		JOptionPane.showMessageDialog(null," The Finch is starting to draw the shape"); //display start gui with message
		myFinch.setLED(255,128,0); //Orange light displays on the finch
		long startTime = System.currentTimeMillis(); //Start the time
		for (int i = 1; i <= 2; i++) { //loops length and width 2 times
			moveFinch(recLength); //going straight with the length given 
			rotateLeft(90); //moving 90% left

			moveFinch(recWidth); //going straight with the width given 
			rotateLeft(90); //moving 90% left 

		}
		myFinch.sleep(200); //waits 
		myFinch.buzz(1, 1000); //Finch beeps once
		numOfRec++; //Ads up 1 to the number of rectangle drawn arraylist
		long endTime = System.currentTimeMillis(); //End the time
		float duration = (float) (endTime - startTime)/1000; //Calculating the time  
		durationTime.add("Rectangle took: "+ " " + duration + " " + "Seconds"); //storing the time in the arraylist 
		float shapeRecAvgTime =  (duration / drawShapeMain.rectangleCount.size()); //Calculating the average time 
		recAverageTime.add("The average time is: "+ " " + shapeRecAvgTime + " " + "Seconds"); //storing the average time in the arraylist 
		JOptionPane.showMessageDialog(null," The finch completed drawing the shape"); //GUI displays 
		myRecInfo();//Accessing to this method to store log into arraylist
		shapeSelection.selectShape(); //calling the method to get user input 
	}

	public static void myRecInfo()  { //storing shape name and the size
		nameOfShapes.add("Rectangle with lenght: " + recLength + " "+  "CM"+ " "+ "and" + " " + "Width" + " "+  recWidth + " "+ "CM" ); //storing the shape name and the size.
		int recArea = recLength* recWidth ; //Calculating the area of the rectangle Length times Height

		shapeAreas.add((int)(recArea)); // Adding the area into arraylist
	}
}