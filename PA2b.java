/*
Title:              Assignment1 PA2.java
Course:             SENG2200
Author:             Juyong Kim
Student No:         c3244203
Date:               05/03/2019
Description:        Main file, just prints the polygon lists, based off input and insertionsort
*/
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.lang.String;
import java.io.IOException;
public class PA2b
{
    public static void main (String[] args) throws IOException
    {

        //variables
        String dataFile = args[0]; 
        File file = new File(dataFile);

        MyPolygons myPolyList = new MyPolygons();
        MyPolygons myPolyListOrdered = new MyPolygons();

        try 
        {
            // Here we use the Scanner class to read file content line-by-line.
            Scanner scanner = new Scanner(file);

            while (scanner.hasNextLine()) 
            {
                String line = scanner.nextLine();

                // Splitting the line with spaces
                Scanner lineScanner = new Scanner(line);

                lineScanner.useDelimiter(" ");

                //testing purposes
                while (lineScanner.hasNext()) 
                {
                    String part = lineScanner.next();

                    if(part.equals("P"))
                    {

                        //num after P/ verticies
                        String verticies = lineScanner.next();
                        int pNum = Integer.parseInt(verticies);
                        int cNum = 0;

                        //creates a polygon of n+1 verticies
                        Polygon poly = new Polygon(pNum+1);

                        //creates a list of points to insert into the polygon
                        Point[] pList = new Point[pNum+1];

                        //loops till the end of the line
                        while(lineScanner.hasNext())
                        {
                            //generates values
                            String xValue = lineScanner.next();
                            String yValue = lineScanner.next();

                            //saves x point then y point respectively
                            pList[cNum] = new Point(Double.parseDouble(xValue),Double.parseDouble(yValue));
                            poly.addPoint(pList[cNum]);
                            cNum++;
                        }

                        //adds first element to the last
                        //add triggers the area/distance calculations
                        poly.addPoint(pList[0]);
                        poly.calArea();
                        poly.calDistance();
                        myPolyList.append(poly);
                        myPolyListOrdered.append(poly);

                    }
                }                
            }
        }//end of try 
        catch (FileNotFoundException e) 
        {
            e.printStackTrace();
        }

        System.out.println();
        
        //tada the actual assignment
        System.out.println(myPolyList.printList());                                 //Printing based off input order

        System.out.println(myPolyListOrdered.insertionSort().printList());          //Printing in ascending order from insertionSort

    }//end of Main 

}//end of PA1 class