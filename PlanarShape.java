/*
Title:              Assignment2 PlanarShape.java
Course:             SENG2200
Author:             Juyong Kim
Student No:         c3244203
Date:               21/04/2019
Description:        Parent Class Planarshape is abstract

*/

//abstract classes exist to be extended, they can not be instantiated
public abstract class PlanarShape 
{
    //function that returns the output values to assignment specs
    public abstract String toString();

    //returns the area of the shape
    public abstract double area();

    //returns distance from a shapes closest point/centre to origin(0,0)
    public abstract double originDistance();

    // bigger or the same return true, if smaller return false
    public boolean compare(PlanarShape poly) 
    {
        // determine ratio between the area of two polygons
        double ratio = this.area() / poly.area();
    
        // if no area default same
        if (this.area() == 0 && poly.area() == 0) 
        {
            ratio = 1;
        }

        // area is states as the same
        if (ratio <= 1.005 && ratio >= 0.995) 
        {
            // if the distance to origin is shorter, it is technically bigger
            if (this.originDistance() > poly.originDistance()) 
            {
                return true;
            }
            // if bigger then it is smaller or distance is the same
            else
            {
                return false;
            } 
        }
        // if the area is bigger return true
        if (this.area() > poly.area()) 
        {
            return true;
        }
        else if(this.area() < poly.area())
        {
            // area is smaller
            return false;

        }

        //if all else fails, give up, hehe
        return false;


    }
}// end of PlanarShape class