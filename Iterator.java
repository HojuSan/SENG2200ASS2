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
    private Node current;

    public Node getCurrent()
    {
        return current;
    }
    //directional control
    public void forward()
    {
        current = current.getNext();
    }
    public void backward()
    {
        current = current.getPrevious();
    }
    public void moveToHead()
    {
        current = head;
    }
    public void moveToTail()
    {
        current = tail;
    }
}//end of PA1 class