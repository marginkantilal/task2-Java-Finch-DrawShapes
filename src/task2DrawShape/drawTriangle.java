package task2DrawShape;

import javax.swing.JOptionPane;

public class drawTriangle extends drawSquare{

	//LENGTH of the Triangle by the user
	public static int myTriSideA; 
	public static int myTriSideB;
	public static int myTriSideC;

	//Used to hold the Finch and it willl store values 
	public static int holdsideATime;
	public static int holdsideBTime;
	public static int holdsideCTime;

	//sideAngles to form 180 triangle
	public static double triAngleA;
	public static double triAngleB;
	public static double triAngleC;


	//Used to hold the Finch and it willl store values 
	public static int timeHoldAngleA;
	public static int timeHoldAngleB;
	public static int timeHoldAngleC;
	//string to check empty box 
	public static String  myTriAngleA="";
	public static String  myTriAngleB="";
	public static String  myTriAngleC="";

	static	int numOfTri = 0; //to count number of triangle


	public static void askForInput() throws Exception{
		myTriAngleA= JOptionPane.showInputDialog(null,"Please enter length of the Triangle Side A"); //Asking for Height X of the Triangle
		myTriAngleB= JOptionPane.showInputDialog(null,"Please enter length of the Triangle Side B"); //Asking for Height Y of the Triangle
		myTriAngleC= JOptionPane.showInputDialog(null,"Please enter length of the Triangle Side C"); //Asking for Base of the Triangle

		//Checks empty and displays error msg
		while(myTriAngleA.isEmpty() || myTriAngleB.isEmpty() || myTriAngleC.isEmpty()) {
			if(myTriAngleA.isEmpty()) {
				JOptionPane.showMessageDialog(null," You didn't input anything, please input valid value"); 
				myTriAngleA = JOptionPane.showInputDialog(null,"Please enter the length of Angle A of the Triangle"); //Asking for the length of the Rectangle


			}
			else if(myTriAngleB.isEmpty()) {
				JOptionPane.showMessageDialog(null," You didn't input anything, please input valid value"); 
				myTriAngleB = JOptionPane.showInputDialog(null,"Please enter the length of Angle B of the Triangle"); //Asking for width of the Rectangle
			} 

			else if(myTriAngleC.isEmpty()) {
				JOptionPane.showMessageDialog(null," You didn't input anything, please input valid value"); 
				myTriAngleC = JOptionPane.showInputDialog(null,"Please enter the length of Angle C of the Triangle"); //Asking for width of the Rectangle
			} 
		} 
		try { 
			myTriSideA= Integer.parseInt(myTriAngleA); //converting the string to integer for checking if the length is valid or not
			myTriSideB= Integer.parseInt(myTriAngleB); //converting the string to integer for checking if the length is valid or not
			myTriSideC= Integer.parseInt(myTriAngleC); //converting the string to integer for checking if the length is valid or not

		}  //Checks valid if it is not number then an error msg displays
		catch(NumberFormatException e) { 
			JOptionPane.showMessageDialog(null, "Values must be positive integers! Try Again"); //An error msg
			myTriAngleA="";
			askForInput(); //Re-enter the length
			myTriAngleB="";
			askForInput(); //Re-enter the length
			myTriAngleC="";
			askForInput(); //Re-enter the length
		}
		drawTri(); //Calling another method 

	}

	//This method checks valid length between 15 to 85 Cm
	public static void drawTri() throws Exception  {

		if (myTriSideA < 15 || myTriSideA > 85)
		{
			JOptionPane.showMessageDialog(null," Invalid input, please enter a length between 15cm to 85 cm. "); //invalid input and error message displays
			myTriAngleA=" ";
			askForInput();//calling method
		} 

		else if (myTriSideB < 15 || myTriSideB > 85) 
		{
			JOptionPane.showMessageDialog(null," Invalid input, please enter a length between 15cm to 85 cm. "); //invalid input and error message displays
			myTriAngleB=" ";
			askForInput(); //calling method
		} 

		else if (myTriSideC < 15 || myTriSideC > 85)
		{
			JOptionPane.showMessageDialog(null," Invalid input, please enter a length between 15cm to 85 cm. "); //invalid input and error message displays
			myTriAngleC=" ";
			askForInput();//calling method
		} 

		else 
		{

			checkAnglesTo180(); // Calling another method 
		}


	}
	//Checks if the valid length forms a correct triangle by adding angles to 180
	static void checkAnglesTo180() throws Exception { 

		triAngleC = Math.toDegrees(Math.acos((Math.pow(myTriSideA, 2) + Math.pow(myTriSideB, 2) - Math.pow(myTriSideC, 2)) / (2 * myTriSideA * myTriSideB))); // Finds angles 
		triAngleA = Math.toDegrees(Math.acos((Math.pow(myTriSideB, 2) + Math.pow(myTriSideC, 2) - Math.pow(myTriSideA, 2)) / (2 * myTriSideB * myTriSideC))); // Finds angles 
		triAngleB = Math.toDegrees(Math.acos((Math.pow(myTriSideA, 2) + Math.pow(myTriSideC, 2) - Math.pow(myTriSideB, 2)) / (2 * myTriSideA * myTriSideC))); //  Finds angles	


		if ((triAngleC + triAngleA + triAngleB) != 180) { //if all the angles is not equal to 180
			System.out.println("Not a valid triangle! Angles only go up to " + String.valueOf(triAngleA + triAngleB + triAngleC) + " according to the cosine rule."); //Print it is not valid triangle 
			JOptionPane.showMessageDialog(null,"You can’t draw a triangle with this length, Please enter correct length that forms a triangle ");
			myFinch.sleep(1000); //wait for 1 seconds
			askForInput(); //Get valid length 
		}

		else {
			drawingTri(); //Calling method 
		}

	}
	public static void drawingTri() throws Exception {  //Method drawing the shape

		int neightDegree = 435; //used to turn the finch 90 degree
		double oneDegree = neightDegree/90; 

		holdsideATime = (myTriSideA/10 *1000); //Speed=Distance/time to find the time for the finch to move
		timeHoldAngleA = (int) ((triAngleA - 90)* oneDegree); //



		holdsideBTime = (myTriSideB/10 *1000);//Speed=Distance/time to find the time for the finch to move
		timeHoldAngleB = (int) ((triAngleB - 90)* oneDegree);


		holdsideCTime = (myTriSideC/10 *1000);//Speed=Distance/time to find the time for the finch to move
		timeHoldAngleC = (int) ((triAngleC - 90)* oneDegree);



		JOptionPane.showMessageDialog(null,"The Finch is starting to draw the shape"); // display Message to inform user that the finch is about start drawing the shape
		myFinch.setLED(255,255,0); //yellow light when start drawing
		long startTime = System.currentTimeMillis(); //Start the time 
		myFinch.setWheelVelocities(100, 100, holdsideATime); 
		myFinch.setWheelVelocities(-150,150, neightDegree -timeHoldAngleA);

		myFinch.setWheelVelocities(100, 100, holdsideBTime);
		myFinch.setWheelVelocities(-150,150, neightDegree -timeHoldAngleB); 

		myFinch.setWheelVelocities(100, 100, holdsideCTime);
		myFinch.setWheelVelocities(-150,150, neightDegree -timeHoldAngleC);

		long endTime = System.currentTimeMillis(); //End the time 
		float duration = (float) (endTime - startTime)/1000; //Calculating the time it took draw
		numOfTri++;

		durationTime.add("Triangle took: "+ " " + duration + " " + "Seconds"); //storing the time  
		myFinch.buzz(1, 1000); //Make finch buzz once when drawing completed

		float shapeTriAvgTime =  (duration / drawShapeMain.triangleCount.size()); //Calculating the average time 
		triAverageTime.add("The average time is: "+ " " + shapeTriAvgTime + " " + "Seconds"); //storing the time in the arraylist 
		JOptionPane.showMessageDialog(null,"The Finch completed drawing the shape");

		myTriInfo(); //Calling method to store the data
		shapeSelection.selectShape(); //Calling method to get the user input

	}
	public static void myTriInfo()  { //storing shape name and the size
		nameOfShapes.add("Triangle with lenght: " + myTriSideA + "cm" + "x" + myTriSideB +"x" + "cm"  + myTriSideC + "cm"  ); //storing the info.
		double TriangleArea = ((myTriSideA*myTriSideB)/myTriSideC); //Calculating the area of the Triangle
		shapeAreas.add((int) TriangleArea ); //storing the area.

		//Storing the angles of the Triangle
		shapeAngles.add("Triangle with angles:" + " "+ (int)+ triAngleC );
		shapeAngles.add("Triangle with angles:" + " "+(int) + triAngleA );
		shapeAngles.add("Triangle with angles:" + " " + (int)+ triAngleB );
	}

}