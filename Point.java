/*
Title:              Assignment1 Point.java
Course:             SENG2200
Author:             Juyong Kim
Student No:         c3244203
Date:               21/03/2019
Description:        Creates a point
*/
public class Point
{
    //variables
    private double x, y, d;

    //constructor
    public Point(double xValue, double yValue)
    {
        this.x = xValue;
        this.y = yValue;
        this.d = distance();
    }

    //getters
    public double getX()
    {
        return x;
    }
    public double getY()
    {
        return y;
    }
    public double getD()
    {
        return d;
    }

    //returns distance from origin
    public double distance()
    {
        double dis = 0;

        //calculations
        dis = Math.sqrt((x*x) + (y*y));

        return dis;
    }

    //returns point in string %4.2f format 
    public String toString()
    {
        String coordinate = "";
        String xVal = String.format("%4.2f", x);
        String yVal = String.format("%4.2f", y);

        coordinate = "("+ xVal +","+ yVal +")";

        return coordinate;
    }
}