
/*
Title:              Assignment2 PA2a.java
Course:             SENG2200
Author:             Juyong Kim
Student No:         c3244203
Date:               21/04/2019
Description:        Main file, prints polygons, based off input and sorted by area/originDistance
*/
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;
import java.lang.*;

public class PA2a 
{
    public static void main(String[] args) throws IOException 
    {
        // variables
        String dataFile = args[0];
        File file = new File(dataFile);

        LinkedList myPolyList = new LinkedList();
        SortedList myPolyListOrdered = new SortedList();

        try 
        {
            // Here we use the Scanner class to read file content line-by-line.
            Scanner scanner = new Scanner(file);

            while (scanner.hasNextLine()) 
            {
                //saves the shape data into line
                String line = scanner.nextLine();

                //call shapeFactory
                shapeFactory(myPolyList, line);                
            }
        } // end of try
        catch (FileNotFoundException e) 
        {
            e.printStackTrace();
        }

        System.out.println();

        //sorted by input
        System.out.println("SORTED BY INPUT\n");
        System.out.println(myPolyList.printList(myPolyList));

        //make it look clean
        System.out.println();
        System.out.println();

        //iterator, adds a planar shape one by one
        Iterator<PlanarShape> it = myPolyList.iterator();

        while (it.hasNext()) 
        {
            myPolyListOrdered.insertInOrder(it.next());

        }

        //sorted list
        System.out.println("SORTED BY AREA/ORIGIN DISTANCE\n");
        System.out.println(myPolyListOrdered.printList(myPolyListOrdered));

    }// end of Main

    public static void shapeFactory(LinkedList list, String shapeData)
    {
        String[] details = shapeData.split(" ");
        String id_char = details[0];

        //switch statement that decides what shape it is based off
        //the initial character of the string
        switch(id_char)
        {
            case "P":
                // num after P/ verticies
                String verticies = details[1];
                int pNum = Integer.parseInt(verticies);
                int cNum = 0;

                // creates a polygon of n+1 verticies
                Polygon poly = new Polygon(pNum + 1);

                // creates a list of points to insert into the polygon
                Point[] pList = new Point[pNum + 1];

                //x,y values start at array num 2
                for(int i = 2; i < details.length; i+=2) 
                {
                    // generates values
                    //System.out.println("array length is "+ details.length);
                    //System.out.println("i is at "+i+" "+(i+1));
                    String xValue = details[i];
                    String yValue = details[i+1];

                    // saves x point then y point respectively
                    pList[cNum] = new Point(Double.parseDouble(xValue), Double.parseDouble(yValue));
                    poly.addPoint(pList[cNum]);
                    cNum++;
                }

                // adds first element to the last
                // add triggers the area/distance calculations
                poly.addPoint(pList[0]);
                poly.calArea();
                poly.calOriginDistance();
                //creates a planar shape and the prepends it
                PlanarShape shape = poly;
                list.append(shape);

            break;

//            case "C":
//
//            break;
//
//            case "S":
//
//            break;

            default:

                //default print out for errors
                System.out.println("Invalid shape Input");

            break;

        }
    }

}// end of PA2a class