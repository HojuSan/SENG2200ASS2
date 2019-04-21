/*
Title:              Assignment1 Polygon.java
Course:             SENG2200
Author:             Juyong Kim
Student No:         c3244203
Date:               21/03/2019
Description:        Creates a Polygon, implements an interface as well 
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
        calArea();
        this.area = area();
        this.print = "";
    }

     //getters
     public String getPrint()
     {
         return print;
     }
     //Inputs points into Polygon area calculation, saves value into private variable area
     public double area()
     {
         return area;
     }
 
     public void calArea()
     {
        area = (Math.PI * Math.pow(radius, 2))/2;
     } 

     public double originDistance()
     {
         return distance;
     }
 
     //prints out polygon information according to specs
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
}