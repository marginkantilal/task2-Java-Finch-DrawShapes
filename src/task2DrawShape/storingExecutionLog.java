package task2DrawShape;

import java.io.PrintWriter;
import javax.swing.JOptionPane;

public class storingExecutionLog extends drawShapeMain {

	//Stop drawing shapes	
	public static void stopandsavedata() throws Exception {
		String  Quit = JOptionPane.showInputDialog(null,"Are you sure you want to quit?" + "\n" + "Y=yes " +" " + " N=No");
		if (Quit.toLowerCase().equalsIgnoreCase("y")) //Assigning letter Y in upper case and lower case to stop 
		{
			PrintWriter writerLog = new PrintWriter("mylogfile.txt"); //creating text file		
			for(int i = 0; i < nameOfShapes.size(); i++) { //loop from 0 to number of shapes
				writerLog.println(nameOfShapes.get(i)); //outputs shape details in text file
			}


			for(int i1 = 0; i1 < shapeAngles.size(); i1++) { //loops angles from 0 to number of shapes	
				writerLog.println(shapeAngles.get(i1)); //outputs in text file
			}
			for(int i2 = 0; i2 < durationTime.size(); i2++) { //loops time from 0 to number of shapes drawn and their average time	
				writerLog.println(durationTime.get(i2)); //outputs in text file

			}			
			for(int i4 = 0; i4 < triAverageTime.size(); i4++) { //loops average time from 0 to number of shapes drawn and their average time	
				writerLog.println("Triangle average time:"+ " " + triAverageTime.get(i4)); //outputs in text file

			}
			for(int i5 = 0; i5 < squAverageTime.size(); i5++) { //loops average time from 0 to number of shapes drawn and their average time	
				writerLog.println("Square average time:"+ " " + squAverageTime.get(i5)); //outputs in text file

			}
			for(int i6 = 0; i6 < recAverageTime.size(); i6++) { //loops average time from 0 to number of shapes drawn and their average time	
				writerLog.println("Rectangle average time:"+ " " + recAverageTime.get(i6)); //outputs in text file

			}
			int biggestIndex = 0; //Index of biggest area
			Integer biggestShape = drawShapeMain.shapeAreas.get(biggestIndex); //Biggest shape is the first area
			for(int j = 0; j < shapeAreas.size(); j++) { //loop from 0 to the number of areas

				if(drawShapeMain.shapeAreas.get(j) > biggestShape) { //compares if current area is bigger than biggest 
					biggestShape = shapeAreas.get(j); //current area is assigned to biggest
					biggestIndex = j; //current area index is assigned to biggest index

				}
			}
			writerLog.println("Biggest shape drawn was: " + drawShapeMain.nameOfShapes.get(biggestIndex) + " with area: " + biggestShape); //uses biggest shape and biggest area
			if ((drawRectangle.numOfRec > drawTriangle.numOfTri ) || (drawRectangle.numOfRec > drawSquare.numOfSqu)) { //compares number of rectangles to the number of triangles, finds which is larger shape was drawn more time
				writerLog.println("Rectangle was chosen more times compared to other shapes: " + drawRectangle.numOfRec);
				writerLog.println("n/");
			}
			else if(( drawTriangle.numOfTri > drawRectangle.numOfRec  )|| (drawTriangle.numOfTri > drawSquare.numOfSqu)) {
				writerLog.println("Triangle was chosen more times compared to other shapes: " + drawTriangle.numOfTri);
			}
			else if ((drawSquare.numOfSqu > drawTriangle.numOfTri ) || (drawSquare.numOfSqu > drawRectangle.numOfRec)) {
				writerLog.println("Square was chosen more times compared to other shapes: " + drawSquare.numOfSqu);

			}
			else {
				writerLog.println("Three shapes were picked the same amount: " + drawSquare.numOfSqu); //in case of number of Rectangle. number of Square and number of Triangle being equal
			} 


			//Adding the count of the shapes to the file by getting the size of ArrayList we can find the number of times the shape has been drawn
			//Checking if the array is null or empty 
			int squareCount; //Counts number of square 
			if(drawShapeMain.squareCount == null || drawShapeMain.squareCount.isEmpty()){
				System.out.println(drawShapeMain.squareCount.size());
				squareCount = 0;
			}

			else {
				squareCount = drawShapeMain.squareCount.size();

			}

			int rectangleCount; //Counts number of rectangle
			if(drawShapeMain.rectangleCount == null || drawShapeMain.rectangleCount.isEmpty()){
				rectangleCount = 0;
			}
			else {
				rectangleCount = drawShapeMain.rectangleCount.size();

			}

			int triangleCount; //Counts number of Triangle
			if(drawShapeMain.triangleCount == null || drawShapeMain.triangleCount.isEmpty()){
				triangleCount = 0;
			}
			else {
				triangleCount = drawShapeMain.triangleCount.size();

			}
			writerLog.println("Square Shape was drawn: " + squareCount + " times.");//Adding the information to the file 
			writerLog.println("Triangle Shape was drawn: " + triangleCount + " times.");//Adding the information to the file 
			writerLog.println("Rectangle Shape was drawn: " + rectangleCount + " times.");//Adding the information to the file 

			int totalShapeDrawn = rectangleCount + triangleCount + squareCount; //counting total shapes 
			writerLog.println("Total number of shapes drawn are: " + " "+ totalShapeDrawn + " "+ " "+"shapes.");//Adding the information to the file 
			writerLog.close(); //closes writer
			JOptionPane.showMessageDialog(null, "The information are successfully stored into a text file and press OK to quit");
			System.exit(0);
		}
		if (Quit.toLowerCase().equals("n"))  //Assigning letter N in upper case and lower case to continue 
		{
			shapeSelection.selectShape();
		}

	}
}