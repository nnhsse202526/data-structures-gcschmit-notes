import java.util.NoSuchElementException;

/**
 * A linked list is a sequence of nodes with efficient
 * element insertion and removal. This class
 * contains a subset of the methods of the standard
 * java.util.LinkedList class.
*/
public class LinkedList
{
    /*
     * first refers to the first node in this list. If the list
     *  is empty, first is null.
     */
    private Node first;

    /**
        Constructs an empty linked list.
    */
    public LinkedList()
    {
        this.first = null;
    }

    /**
        Returns the first element in the linked list.
        @return the first element in the linked list
    */
    public Object getFirst()
    {
        if(this.first == null)
        {
            throw new NoSuchElementException();
        }

        return this.first.data;
    }

    /**
        Removes the first element in the linked list.
        @return the removed element
    */
    public Object removeFirst()
    {
        if(this.first == null)
        {
            throw new NoSuchElementException();
        }

        Object element = this.first.data;
        this.first = this.first.next;
        return element;
    }

    /**
        Adds an element to the front of the linked list.
        @param element the element to add
    */
    public void addFirst(Object element)
    {
        // #1
        Node newNode = new Node();
        newNode.data = element;

        // #2
        newNode.next = this.first;

        // #3
        this.first = newNode;
    }

    /**
        Returns an iterator for iterating through this list.
        @return an iterator for iterating through this list
    */
    public ListIterator listIterator()
    {
        return new LinkedListIterator();
    }

    // Class Node
    static class Node
    {
        public Object data;
        public Node next;
    }


    class LinkedListIterator implements ListIterator
    {
      // private data
      private Node position;
      private Node previous;
      private boolean isAfterNext;

        /**
            Constructs an iterator that points to the front
            of the linked list.
        */
        public LinkedListIterator()
        {
            position = null;
            previous = null;
            isAfterNext = false;
        }

        /**
            Moves the iterator past the next element.
            @return the traversed element
        */
        public Object next()
        {
            if(hasNext() == false)
            {
                throw new NoSuchElementException();
            }

            previous = position;
            isAfterNext = true;

            if(position == null)
            {
                position = first;
            }
            else
            {
                position = position.next;
            }

            return position.data;
        }

        /**
            Tests if there is an element after the iterator position.
            @return true if there is an element after the iterator position
        */
        public boolean hasNext()
        {
            if(position == null) // we are at the start of the list
            {
                return first != null;
            }

            return position.next != null;
        }

        /**
            Adds an element before the iterator position
            and moves the iterator past the inserted element.
            @param element the element to add
        */
        public void add(Object element)
        {
            if(position == null)
            {
                addFirst(element);
                position = first;
            }
            else
            {
                Node newNode = new Node();
                newNode.data = element;
                newNode.next = position.next;   // #1
                position.next = newNode;        // #2
                position = newNode;             // #3
            }

            isAfterNext = false;                // #4
        }

        /**
            Removes the last traversed element. This method may
            only be called after a call to the next() method.
        */
        public void remove()
        {
            if(!isAfterNext)
            {
                throw new IllegalStateException();
            }

            if(position == first)
            {
                removeFirst();
                position = null;
            }
            else
            {
                previous.next = position.next;      // #1
                position = previous;                // #2
            }

            isAfterNext = false;                    // #3
        }

        /**
            Sets the last traversed element to a different value.
            @param element the element to set
        */
        public void set(Object element)
        {
            if(!isAfterNext)
            {
                throw new IllegalStateException();
            }

            position.data = element;
        }
    }//LinkedListIterator
}//LinkedList
