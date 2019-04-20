
/*
Title:              Assignment1 Polygon.java
Course:             SENG2200
Author:             Juyong Kim
Student No:         c3244203
Date:               21/03/2019
Description:        Creates a Node 
*/
import java.util.*;

public class LinkedList<T extends PlanarShape> implements Iterable<T> {
    // variables
    // the sentinel's next points to the first node on the list, and its prev points
    // to the last node on the list.
    // The first node's prev points to the sent`inel, as does the last node's next.
    //protected variables extened classes can access
    protected Node<T> sentinel;
    protected int size;

    // constructor
    public LinkedList() {
        this.sentinel = new Node(null);
        this.sentinel.setNext(sentinel);
        this.sentinel.setPrevious(sentinel);
        size = 0;
    }

    // getters
    public boolean isEmpty() {
        return size == 0;
    }

    public int getSize() {
        return size;
    }

    // insertion before the first node
    public void prepend(PlanarShape data) {
        Node<T> temp = new Node(data);

        temp.setNext(sentinel.getNext());
        temp.setPrevious(sentinel);

        sentinel.getNext().setPrevious(temp);
        sentinel.setNext(temp);

        size++;
    }

    // insertion before the sentinel node
    public void append(PlanarShape data) {
        Node<T> temp = new Node(data);

        temp.setNext(sentinel);
        temp.setPrevious(sentinel.getPrevious());

        sentinel.getPrevious().setNext(temp);
        sentinel.setPrevious(temp);

        size++;
    }

    public Node<T> getHead() 
    {
        return sentinel.getNext();
    }

    // print
    public String printList() 
    {
        String list = "";
        Node<T> current = sentinel.getNext();

        for (int i = 0; i < size; i++) {
            list += current.getData().toString() + "\n";
             System.out.println(current.getData());
            current = current.getNext();
        }

        return list;
    }

    public String printList(LinkedList list) {
        String listPrint = "";
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            listPrint += it.next().toString() + "\n";
        }
        return listPrint;
    }

    // @Override
    public Iterator<T> iterator() {
        return new myLinkedListIterator();
    }

    public class myLinkedListIterator implements Iterator<T> 
    {
        Node<T> current = sentinel;

        public boolean hasNext() 
        {
            if (current.getNext() == sentinel || current.getNext() == null) 
            {
                // System.out.println("returned false");
                return false;
            } else 
            {
                // System.out.println("returned true");
                return true;
            }
        }

        public void remove() 
        {
            // sentinel node must always exist within the circular doubly linked list
            if (current != sentinel) 
            {
                current.getPrevious().setNext(current.getNext());
                current.getNext().setPrevious(current.getPrevious());
            } else {
                System.out.println("can't delete sentinel node");
            }
        }

        // directional control
        public T next() 
        {
            // System.out.println("here");
            // at first iteration or just going through
            if (current == sentinel || current.getNext() != sentinel) {
                current = current.getNext();
                return current.getData();
            }
            // end of list
            else {
                throw new NoSuchElementException();
            }
        }
    }
}
