/*
Title:              Assignment1 PA2.java
Course:             SENG2200
Author:             Juyong Kim
Student No:         c3244203
Date:               05/03/2019
Description:        Main file, just prints the polygon lists, based off input and insertionsort

*/

//abstract classes exist to be extended, they can not be instantiated
public abstract class PlanarShape 
{
    public abstract String toString();

    public abstract double area();

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
            System.out.println("entered orgin distance comparison~~~~~~~~~~");
            // if the distance to origin is shorter, it is technically bigger
            if (this.originDistance() > poly.originDistance()) 
            {
                return true;
            }
            ////or distance is the same
            //else if(this.originDistance() == poly.originDistance())
            //{
            //    return true;
            //}
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


        return false;


    }
}// end of PA1 class