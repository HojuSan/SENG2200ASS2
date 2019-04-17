/*
Title:              Assignment1 Polygon.java
Course:             SENG2200
Author:             Juyong Kim
Student No:         c3244203
Date:               21/03/2019
Description:        Creates a Node 
*/
public class Node<T>
{
    //variables
    private Node next;
    private Node previous;
    private T data;

    //constructor
    public Node(T dataValue)
    {
        next = null;
        previous = null;
        data = dataValue;
    }
    //constructor
    public Node()
    {
        next = null;
        previous = null;
        data = null;
    }

    //setters
    public void setData(T dataValue)
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
    public T getData()
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