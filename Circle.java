/*
Title:              Assignment2 Circle.java
Course:             SENG2200
Author:             Juyong Kim
Student No:         c3244203
Date:               21/04/2019
Description:        Creates a Circle, extends PlanarShape
*/
import java.lang.Math;

public class Circle extends PlanarShape 
{
    //variables
    private Point centre;
    private double radius;
    private double area;
    private double distance;
    private String print;

    //constructor
    public Circle(Point pon, double r)
    {
        this.centre = pon;
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
     public double area()
     {
         return area;
     }
     public double originDistance()
     {
         return distance;
     }
 
     //calculates the area of a circle
     public void calArea()
     {
        area = Math.PI * Math.pow(radius, 2);
     } 

     //prints out polygon information according to specs
     @Override
     public String toString()
     {
         String areaVal = String.format("%5.2f", area);
         String radiusVal = String.format("%5.2f", radius);
         String temp = "CIRC=[";
         temp += centre.toString() + " " + radiusVal+" ]: "+ areaVal;

         this.print = temp;
         return temp;
     }
}