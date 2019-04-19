/*
Title:              Assignment1 PA2.java
Course:             SENG2200
Author:             Juyong Kim
Student No:         c3244203
Date:               05/03/2019
Description:        Main file, just prints the polygon lists, based off input and insertionsort

*/

public class Iterator
{
    public void remove(Node node)
    {
        node.getPrevious().setNext(node.getNext());
        node.getNext().setPrevious(node.getPrevious());
    }
    //directional control
    public Node next(Node node)
    {
        return node.getNext();
    }
    public boolean hasNext(Node node)
    {
        if(node.getNext()==null)
        {
            return false;
        }
        else 
        {
            return true;
        }
    }
}