/*
Title:              Assignment2 Polygon.java
Course:             SENG2200
Author:             Juyong Kim
Student No:         c3244203
Date:               21/04/2019
Description:        Creates a Polygon that is a Planarshape
*/
import java.lang.Math;
public class Polygon extends PlanarShape 
{
    //variables
    private Point[] poly;
    private int size;
    private int sides;
    private double area;
    private double distance;
    private String print;

    //constructor
    public Polygon(int num)
    {
        this.poly = new Point[num];
        this.area = 0;
        this.sides = num;
        this.size = 0;
        this.print = "";
        this.distance = 0;
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

    //adds points to an array of points saved in polygon
    public void addPoint(Point pon)
    {
        poly[size] = pon;
        size++;
    }

    //calculates the polygon area to the assignment specs
    public void calArea()
    {
        //Start of the formula
        for(int i = 0; i < sides-1; i++)
        {
            area += (poly[i].getX()*poly[i+1].getY())-(poly[i].getY()*poly[i+1].getX());
        }

        //absoloute value of the area
        area = Math.abs(area);

        //half the total calculation
        area = area/2;

    }

    //calculates the closest point to the origin, returns the distance
    public void calOriginDistance()
    {
        double closest = poly[0].getD();

        //cycles through all the points
        for(int i = 1; i < sides; i++)
        {
            if(closest > poly[i].getD())
            {
                closest = poly[i].getD();
            }
        }
        //saves the closest points distance
        this.distance = closest;
    }

    //prints out polygon information according to specs
    @Override
    public String toString()
    {
        String temp = "POLY=[";
        String areaVal = String.format("%5.2f", area);

        //adds each point
        for(int i = 0; i < sides; i++)
        {
            temp += poly[i].toString();
        }

        temp += "]: "+ areaVal;
        this.print = temp;
        return temp;
    }
}//end of Polygon Class