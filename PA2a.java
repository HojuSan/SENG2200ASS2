/*
Title:              Assignment1 PA2.java
Course:             SENG2200
Author:             Juyong Kim
Student No:         c3244203
Date:               05/03/2019
Description:        Main file, just prints the polygon lists, based off input and insertionsort

Yup, your marks are up.

Firstly, sorry this took a week longer than expected - that is COMPLETELY on me. The skinny on that is that I plan with a calendar -
 on that calendar I seem to have noted the date that I planned to start MARKING things (which is usually a week after submission closes, 
 to allow for late subs and adverse circumstances), where I would usually note the submission date! Ergo, I quickly found myself a good WEEK 
 late on starting these... So my apologies!

Now onto some group feedback.

What is massively and glaringly obvious is that some of you have a) forgotten your 1st year Data Structures content and b) failed to
 understand how a Circular Doubly Linked List w/ Sentinel is. We shall briefly go through that here, starting with b) first.

A Circular Doubly Linked List w/Sentinel is a double-linked, node-based list structure, that leverages a sentinel to make your 
list methods pretty trivial. The sentinel and its prev/next relationships are set up at INSTANTIATION time, and should look something 
like this:

public CDLLS ()
{
 sentinel = new Node();
 sentinel.setNext(sentinel);
 sentinel.setPrev(sentinel);
 sentinel.setData(null); 
}

...now what that does is remove the need for any sort of checking of edge cases (such as if the insertNode is 
first, last, going into an empty list, etc), so all of a sudden our prepend() method (and all simple insert methods for that matter) 
might look like this:

public void prepend(Obj newThing)
{
 prevNode = sentinel;
 nextNode = sentinel.getNext();

 inserting = new Node(newThing);
 inserting.setNext(nextNode);
 inserting.setPrev(prevNode);

 prevNode.setNext(inserting);
 nextNode.setPrev(inserting);
}

Sentinels are GOOD, and are used in every linear-list-style library container that I've ever taken the time to look at the source for!

The next point is your separation of DATA STRUCTURE and DATA TYPES - you all should remember SENG1120, and the basic premise that 
DATA STRUCTURES are containers that hold DATA TYPES. It should very clear that a Linked List requires a Node, and that Node is what will 
hold Polygons (which in turn hold Points); combining Node functionality into the Polygon object removes any distinction between Data Type 
and Data Structure.

And then there is SENG1110 and SENG1120 Data Hiding - Returning a NODE from your List is never good; or making your member variables in 
Node or Polygon or Point public is also never good.

Or basic Roles and Responsibilities; your Data Structure should NEVER be responsible for File Reading and Parsing the Input and creating 
the Data Types that will be stored within itself.

And then there are the cases where parts of the specification are just ignored - if you're told in the spec to name a File a certain name,
 use it! Or of you're told your project must compile with a certain command, and execute with another, do it!

This is by no means an exhaustive list of issues I came across multiple times, but just a few of the bigger ones so that if you 
have continued down this track for Assignment 2, you can reign things in and get back on track. I will try and put together 
a more comprehensive review in the future, but for now I have more marking to do ;)


*/
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.lang.String;
import java.io.IOException;
public class PA2a
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