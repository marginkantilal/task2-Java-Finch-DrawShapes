package task2DrawShape;

import javax.swing.JOptionPane;

//Drawing square
public class drawSquare extends drawShapeMain  { //Calls another class to use all the methods

	public static int getSquLengthInt ; // integer length 
	public static String  getSquLength=""; //String length


	public static int numOfSqu = 0;
	public static void askForInput() throws Exception  {


		getSquLength = JOptionPane.showInputDialog(null,"Please enter the Length: "); //Asking for the length of the Square
		while(getSquLength.isEmpty()  ) { //empty then show an error msg
			if(getSquLength.isEmpty()) {
				JOptionPane.showMessageDialog(null," You didn't input anything, please input value"); //Error message
				getSquLength = JOptionPane.showInputDialog(null,"Please enter the Length: "); //Asking for the length of the Square	
			}
		}
		try {
			getSquLengthInt = Integer.parseInt(getSquLength);  //converting string to integer 
		}
		catch(NumberFormatException e) {  //only positive integer should be accepted if not it displays an error msg
			JOptionPane.showMessageDialog(null, "Values must be positive integers! Try Again"); 
			getSquLength =""; 
			askForInput(); // ask for input again 
		}

		drawSqu();
	}
	public static void drawSqu() throws Exception { //main method to check valid length
		if (getSquLengthInt < 15 || getSquLengthInt > 85) {   //checks the user input whether is not between 15 to 85cm
			JOptionPane.showMessageDialog(null," Invalid input, please enter a length between 15cm to 85 cm. "); //if the length is less than 15 or above 85 then error message displays
			getSquLength =" ";
			askForInput(); //if it empty or invalid then it calls this method to get valid input if the user entered invalid
		}
		else { 
			drawTheSquare(); //Calling another method
		}
	}
	public static void	drawTheSquare() throws Exception  {	//drawing the square method
		JOptionPane.showMessageDialog(null,"The Finch is starting to draw the shape"); 
		myFinch.setLED(0,255,0); //green light displays on the finch	
		long startTime = System.currentTimeMillis(); //Start the time 
		for (int i = 1; i <= 4; i++) { // loops, move the finch 4 times
			moveFinch(getSquLengthInt); //move the finch for given length 
			myFinch.sleep(300); //wait for 0.3 seconds and turn left
			rotateLeft(90); //turn finch to left 90 degree angle
			myFinch.sleep(300); //wait for 0.3 seconds 
		}

		long endTime = System.currentTimeMillis(); //End the time
		numOfSqu++; //Adds up number of square drawn in the arraylist

		float duration = (float) (endTime - startTime)/1000; //Calculating the time it took to draw 
		durationTime.add("Square took: "+ "" + duration + "" + " Seconds"); //storing the time in the arraylist 
		myFinch.buzz(1, 1000); //Make finch buzz once when drawing completed
		float shapeSquAvgTime =  (duration / drawShapeMain.squareCount.size()); //Calculating the average time 
		squAverageTime.add("The average time is: "+ "" + shapeSquAvgTime + " " + " Seconds"); //storing the average time in the arraylist 

		JOptionPane.showMessageDialog(null," The finch completed drawing the shape"); //displays message when finch completed drawing

		mySqrInfo();//Access to the method 
		shapeSelection.selectShape(); //calling method again to get user input until they don't quit the program
	}
	public static void moveFinch(int distanceInCM) { //method to work out the length into cm 
		int duration = distanceInCM * 100; //converting Distance/Length into CM
		myFinch.setWheelVelocities(90, 90, duration); //move Finch straight the length given
	}

	public static void rotateLeft(int angleInDegrees) { //calculating the 90% left for the finch to turn
		int time = angleInDegrees * (1000/90); //time divide by 
		myFinch.setWheelVelocities(-18, 140, time);
	}
	
	public void rotateRight(int angleInDegrees) {
		int time = angleInDegrees * (1000/90);
		myFinch.setWheelVelocities(140, -18, time);

	}
	public static void mySqrInfo()  { //storing shape name and the size
		nameOfShapes.add("Square with lenght: " + getSquLengthInt + "cm" ); //storing the shape name and the size.
		int squArea = getSquLengthInt* getSquLengthInt ; //calculating the area
		shapeAreas.add((int)(squArea)); //adding the area into arraylist

	}
}