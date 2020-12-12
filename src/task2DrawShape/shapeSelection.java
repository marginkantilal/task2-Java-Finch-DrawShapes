package task2DrawShape;

import javax.swing.JOptionPane;

public class shapeSelection extends drawShapeMain{
	//ArrayList to store the count of the shapes drawn
	


	public static void selectShape() throws Exception  {

		myFinch.setLED(0,0,255); //Blue led light when program starts
		String  TypeOfShape = JOptionPane.showInputDialog(null,"What shape would you like to draw?"+ "\n"+  "Q to quit " +"   " + " R to draw Rectangle"+ "   " + " S to draw Square" + "   " + "  T to draw Triangle");


		if (TypeOfShape.toLowerCase().equals("q"))  //Assigning letter Q to stop the drawing shapes
		{	
			storingExecutionLog.stopandsavedata(); // Store the information and stop the program when letter Q is entered
		} 

		else if (TypeOfShape.toLowerCase().equals("r"))   //Assigning letter R to draw Rectangle shape
		{	
			drawShapeMain.rectangleCount.add(1); //Keeps adding by one everytime rectangle is selected 
			drawRectangle.askForInput();//Calling another where it draws Rectangle when letter R is entered
		
		}


		else if (TypeOfShape.toLowerCase().equals("s"))   //Assigning letter S to draw square shape
		{	drawShapeMain.squareCount.add(1); // Keeps adding by one everytime square is selected
			drawSquare.askForInput();;//Calling another where it draws square when letter S is entered
			
		}

		else if (TypeOfShape.toLowerCase().equals("t"))  //Assigning letter T to draw triangle shape 
		{
			drawShapeMain.triangleCount.add(1); //Keeps adding by one everytime Triangle is selected 
			drawTriangle.askForInput(); //Calling another where it draws Triangle when letter T is entered
			
		}

		else 
		{
			JOptionPane.showMessageDialog(null," Invalid input, please enter Q to stop drawing the shapes, R to draw Rectangle, S to draw square, or T to draw a triangle "); //Show error message if input is null or invalid command is entered
			shapeSelection.selectShape();//Renter value
		}

	}
}