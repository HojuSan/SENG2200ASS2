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

        if(sentinel.getData()==null)
        {
            System.out.println("yup1");
        }
        if(sentinel.getNext()==sentinel)
        {
            System.out.println("yup2");
        }
        if(sentinel.getPrevious()==sentinel)
        {
            System.out.println("yup3");
        }
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

    public void prepend(int data)
    {
        Node temp = new Node(data);

        if(sentinel.getData()==null)
        {
            System.out.println("yup1");
        }
        if(sentinel.getNext()==sentinel)
        {
            System.out.println("yup2");
        }
        temp.setNext(sentinel.getNext());
        temp.setPrevious(sentinel);

        sentinel.setNext(temp);
        sentinel.setPrevious(temp);

        size++;
    }
    /*
    public void prepend(Obj newData)
    {
        Node temp = new Node(newData);

            prevNode = new Node(sentinel);
            nextNode = new Node(sentinel.getNext());
           
            inserting = new Node(newData);
            inserting.setNext(nextNode);
            inserting.setPrev(prevNode);
           
            prevNode.setNext(inserting);
            nextNode.setPrev(inserting);

            //
        sentinel.setPrevious(sentinel);
        sentinel.setNext(sentinel.getNext());

        //inserting temp into new position
        temp.setNext(sentinel.getNext());
        temp.setPrev(sentinel);

        //setting next and previous nodes to temp
        sentinel.setNext(temp);
        sentinel.setPrev(temp);
        


        //increase size
        size++;
    }
*/
    public void append()
    {

    }

    public Node returnHead()
    {
        return sentinel.getNext();
    }
/*
    //add elements to the back
    public void prepend(Polygon poly)
    {
        Node temp = new Node(poly);
        //if its empty just add
        if(head == null)
        {
            temp.setNext(temp);
            temp.setPrevious(temp);
            head = temp;
            tail = head;
        }
        //making sure next and previous is set correctly
        else
        {
            temp.setPrevious(tail);
            tail.setNext(temp);
            head.setPrevious(temp);
            temp.setNext(head);
            head = temp;
            current = head;
        }
        //ups size
        size++;

    }

    //add elements to the front
    public void append(Polygon poly)
    {
        Node temp = new Node(poly);       
        //if its empty just add
        if (head == null)
        {
            temp.setNext(temp);
            temp.setPrevious(temp);
            head = temp;
            tail = head;
            current = tail;
        }
        //making sure next and previous is set correctly
        else
        {
            temp.setPrevious(tail);
            tail.setNext(temp);
            head.setPrevious(temp);
            temp.setNext(head);
            tail = temp;
            current = tail;
        }
        //updates size
        size++;        
    }
*/
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