/*
Title:              Assignment1 Polygon.java
Course:             SENG2200
Author:             Juyong Kim
Student No:         c3244203
Date:               21/03/2019
Description:        Creates a Node 
*/
public class LinkedList //implements Iterator
{
    //variables
    //the sentinel's next points to the first node on the list, and its prev points to the last node on the list. 
    //The first node's prev points to the sentinel, as does the last node's next.
    private Node sentinel; 
    private int size;

    //constructor
    public LinkedList()
    {
        this.sentinel = new Node(null);
        this.sentinel.setNext(sentinel);
        this.sentinel.setPrevious(sentinel);
        size = 0;
    }

    //getters
    public boolean isEmpty()
    {
        return size == 0;
    }
    public int getSize()
    {
        return size;
    }

    //insertion before the first node
    public void prepend(PlanarShape data)
    {
        Node temp = new Node(data);

        temp.setNext(sentinel.getNext());
        temp.setPrevious(sentinel);

        sentinel.getNext().setPrevious(temp);
        sentinel.setNext(temp);

        size++;
    }

    //insertion before the sentinel node
    public void append(PlanarShape data)
    {
        Node temp = new Node(data);

        temp.setNext(sentinel);
        temp.setPrevious(sentinel.getPrevious());

        sentinel.getPrevious().setNext(temp);
        sentinel.setPrevious(temp);

        size++;
    }

    public Node returnHead()
    {
        return sentinel.getNext();
    }

    //print
    public String printList()
    {
        String list = "";
        Node current = sentinel.getNext();

        for(int i = 0; i < size; i++)
        {
            list += current.getData().toString()+"\n";
            //System.out.println(current.getData());
            current = current.getNext();
        }

        return list;
    }
}