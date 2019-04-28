
/*
Title:              Assignment2 PA2b.java
Course:             SENG2200
Author:             Juyong Kim
Student No:         c3244203
Date:               21/04/2019
Description:        Main file, prints shapes, based off input and sorted by area/originDistance,
                    adds circles and semi circles
*/
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;
import java.lang.*;
//import java.io.BufferedReader;
//import java.io.FileReader;

public class PA2b 
{
    public static void main(String[] args) throws IOException 
    {
        // variables
        String dataFile = args[0];
        File file = new File(dataFile);
        StringBuilder sb = new StringBuilder();
        int nextChar = 0;
        String strInp;

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
                sb.append(line.toUpperCase());
                //sb.append(("\n"));             
            }

            //String that has all the data in its exact format
            String inputStr = sb.toString().trim();
            inputStr.replaceAll("\\s+","");
            //System.out.println(inputStr);

            int inputLength = inputStr.length();
            //System.out.println("inputlength is: "+inputLength);
            int curPos = 0;
            StringBuilder shapeSb = new StringBuilder();
            char ch;
            int chCount = 0;            
      
            // Process the input, ueses a cursor to dictait its location
            while (curPos < inputLength)
            {
                if (Character.isLetter(inputStr.charAt(curPos)))
                {
                    //System.out.println("Entered if statement, curPos is at: "+curPos);
                    // Shape mode. Append letter delimiter to string builder
                    ch = inputStr.charAt(curPos);
                    shapeSb.append(ch);
                    curPos++;

                    // Get input data of the detected shape
                    while (curPos < inputLength)
                    {
                        ch = inputStr.charAt(curPos);
                        // stop traversing when another letter is encountered
                        if (Character.isLetter(ch))
                            break;
                        else
                        {
                            // increase character count
                            // append character to string builder
                            // replace newlines with spaces
                            if (ch == '\n')
                                ch = ' ';
                            chCount++;
                            shapeSb.append(ch);
                        }
                        curPos++;
                    }

                    //System.out.println("shape factory input string will be: "+shapeSb.toString());
                    // Use shapeFactory to create Polygons
                    shapeFactory(myPolyList,shapeSb.toString().trim());
                    // Clear the collated string. +1 chCount because the range 0 to max, doesn't include max?
                    shapeSb.delete(0, chCount + 1);
                    chCount = 0;
                }
                else
                {
                    // move curPos if the character is not a letter
                    curPos++;
                }
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

        //didn't want to do it but no matter how i cast Iterator or change types
        //unchecked won't go away, so i'm just suppressing it, i didn't want to though
        @SuppressWarnings("unchecked")
        //iterator, adds a planar shape one by one
        Iterator<PlanarShape> it = (Iterator<PlanarShape>) myPolyList.iterator();

        while (it.hasNext()) 
        {
            PlanarShape temp = it.next();
            myPolyListOrdered.insertInOrder(temp);
        }

        //sorted list
        System.out.println("SORTED BY AREA/ORIGIN DISTANCE\n");
        System.out.println(myPolyListOrdered.printList(myPolyListOrdered));

    }// end of Main

    public static void shapeFactory(LinkedList list, String shapeData)
    {
        String[] details = shapeData.split(" ");
        String id_char = details[0];
        //System.out.println("char is "+id_char);

        //switch statement that decides what shape it is based off
        //the initial character of the string
        switch(id_char)
        {
            //Polygons
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
                //creates a planar shape and appends it
                PlanarShape shape = poly;
                list.append(shape);

            break;

            //Circles
            case "C":
                //xy values
                String xValue = details[1];
                String yValue = details[2];
                //radius
                double radius = Double.parseDouble(details[3]);

                Point centre = new Point(Double.parseDouble(xValue), Double.parseDouble(yValue));
                //creates a circle
                Circle circle = new Circle(centre,radius);
                //creates a planar shape and appends it
                PlanarShape planarCircle = circle;
                list.append(planarCircle);
            break;

            //SemiCircles
            case "S":
                //xy values
                double xValue1 = Double.parseDouble(details[1]);
                double yValue1 = Double.parseDouble(details[2]);
                double xValue2 = Double.parseDouble(details[3]);
                double yValue2 = Double.parseDouble(details[4]);

                //creating the centre
                Point sCentre = new Point(xValue1,yValue1);
                //the other point needed to create the radius
                Point pVector = new Point(xValue2,yValue2);
                //calculate the radius
                double sRadius = Math.sqrt(Math.pow((xValue2-xValue1),2) + Math.pow((yValue2-yValue1),2));
                //creates a semi circle
                SemiCircle semiCircle = new SemiCircle(sCentre, pVector, sRadius);
                //creates a planar shape and appends it
                PlanarShape planarSM = semiCircle;
                list.append(planarSM);
            break;

            default:

                //default print out for errors
                System.out.println("Invalid shape Input");

            break;

        }
    }

}//class