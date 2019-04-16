/*
Title:              Assignment1 Polygon.java
Course:             SENG2200
Author:             Juyong Kim
Student No:         c3244203
Date:               21/03/2019
Description:        Creates a Node 
*/
public class Node
{
    //variables
    private Node next;
    private Node previous;
    private Polygon data;

    //constructor
    public Node(Polygon dataValue)
    {
        next = null;
        previous = null;
        data = dataValue;
    }

    //setters
    public void setData(Polygon dataValue)
    {
        data = dataValue;
    }
    public void setNext(Node newNext)
    {
        next = newNext;
    }
    public void setPrevious(Node newPrevious)
    {
        previous = newPrevious;
    }

    //getters
    public Polygon getData()
    {
        return data;
    }
    public Node getNext()
    {
        return next;
    }
    public Node getPrevious()
    {
        return previous;
    }
    
}