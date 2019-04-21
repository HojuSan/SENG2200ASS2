/*
Title:              Assignment2 SemiCircle.java
Course:             SENG2200
Author:             Juyong Kim
Student No:         c3244203
Date:               21/04/2019
Description:        Creates a SemiCircle extends PlanarShape
*/
import java.lang.Math;

public class SemiCircle extends PlanarShape 
{
    //variables
    private Point centre;
    private Point pVector;
    private double radius;
    private double area;
    private double distance;
    private String print;

    //constructor
    public SemiCircle(Point c, Point pV, double r)
    {
        this.centre = c;
        this.pVector = pV;
        this.radius = r;
        this.distance = centre.distance();
        //calculates area then saves it
        calArea();
        this.area = area();
        this.print = "";
    }

     //getters
     public String getPrint()
     {
         return print;
     }
     public double area()
     {
         return area;
     }
     public double originDistance()
     {
         return distance;
     } 

     //calculates semi circle
     public void calArea()
     {
        //make a circle then half it
        area = (Math.PI * Math.pow(radius, 2))/2;
     } 

     //prints out semiCircle information according to specs
     @Override
     public String toString()
     {
         String areaVal = String.format("%5.2f", area);
         String radiusVal = String.format("%5.2f", radius);

         String temp = "SEMI=[";
         temp += centre.toString() + " " + pVector.toString() + " " + radiusVal +" ]: "+ areaVal;

         this.print = temp;
         return temp;
     }
}//end of SemiCircle class