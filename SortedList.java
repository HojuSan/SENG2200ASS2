
/*
Title:              Assignment2 SortedList.java
Course:             SENG2200
Author:             Juyong Kim
Student No:         c3244203
Date:               21/04/2019
Description:        Creates a creates a sorted list 
*/
import java.util.*;
import java.lang.*;

public class SortedList<T extends PlanarShape> extends LinkedList<T>
{
    private Node<T> current = sentinel;

    //inserts nodes and orders the correctly
    public void insertInOrder(PlanarShape shape)
    {
        current = sentinel;
        
        Node<T> shapeNode = new Node(shape);

        //prepend if list is empty or
        //head is bigger than new shape
        if(sentinel.getNext() == sentinel || sentinel.getNext().getData().compare(shape)==true)
        {
            //System.out.println("in if statement\n");
            //System.out.println("prepended "+shape.toString());
            this.prepend(shape);
        }
        //else iterate till you find the right location
        else
        {
            //System.out.println("in else statement");

            //but if its just bigger add to the end
            if(sentinel.getPrevious().getData().compare(shape)==false)
            {
                //System.out.println("value appended "+ shape.toString());
                this.append(shape);

            }
            else
            {
                current = current.getNext();
                Iterator<T> it = this.iterator();
    
                while(it.hasNext())
                {
                    T temp = it.next();
                    //System.out.println("this is current"+current.getData().toString());
                    //System.out.println("this is shape"+shape.toString());
    
                    //if next from current is bigger than shape insert between current and getnext
                    if(temp.compare(shape)==true)
                    {
                        //System.out.println("entered if statement within while!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
                        //System.out.println("added "+shape.toString());
                        //System.out.println("before "+current.getData().toString()+"\n");

                        shapeNode.setNext(current);
                        shapeNode.setPrevious(current.getPrevious());
    
                        current.getPrevious().setNext(shapeNode);
                        current.setPrevious(shapeNode);
    
                        break;
                    }
                    //System.out.println("failed to enter if");
                    current = current.getNext();
                }
            }

        }

        //up the size of the list, doesn't have any uses now but may in the future
        size++;
        
    }//end of insertInOrder
}//end of class