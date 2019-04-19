/*
Title:              Assignment1 PA2.java
Course:             SENG2200
Author:             Juyong Kim
Student No:         c3244203
Date:               05/03/2019
Description:        Main file, just prints the polygon lists, based off input and insertionsort

*/

//abstract classes exist to be extended, they can not be instantiated
public abstract class PlanarShape implements Comparable<PlanarShape>
{
        public abstract String toString();

        public abstract void area();

        public abstract double originDistance();
}//end of PA1 class