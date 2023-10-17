import java.util.ListIterator;
import java.util.NoSuchElementException;

/**
 * A linked list is a sequence of nodes with efficient
 * element insertion and removal. This class
 * contains a subset of the methods of the standard
 * java.util.LinkedList class.
*/
public class LinkedList
{


    /** first refers to the first node in this list
     * If the list is empty, first is null
     */
    private Node first;
    /**
        Constructs an empty linked list.
    */
    public LinkedList(){
        this.first = null;
    }



    /**
        Returns the first element in the linked list.
        @return the first element in the linked list
    */
    public Object getFirst(){
        if (this.first == null){
          throw new NoSuchElementException();
        }
        return this.first.item;
    }



    /**
        Removes the first element in the linked list.
        @return the removed element
    */
    public Object removeFirst(){
        if(this.first == null){
            throw new NoSuchElementException();
        }

        Object element = this.first.item;
        this.first  = this.first.next;
        return element;
    }




    /**
        Adds an element to the front of the linked list.
        @param element the element to add
    */
    public void addFirst(Object element){
        Node newNode  = new Node();
        newNode.item = element;
        newNode.next = this.first;
        this.first = newNode;
    }




    /**
        Returns an iterator for iterating through this list.
        @return an iterator for iterating through this list
    */
    public ListIterator listIterator(){
        return new LinkedListIterator();
    }




    //Class Node
    static class Node<T>{
        public Object item;
        public Node<T> prev,next;

        Node(Node<T> prev, Node<T> next, T item){
            this.item = item;
            this.next = next;
            this.prev = prev;
        }
    }

    class LinkedListIterator implements ListIterator
    {
      //private data
        private Node<T> pos,last;
        private boolean moved;

        /**
            Constructs an iterator that points to the front
            of the linked list.
        */
        public LinkedListIterator(){

        }

        /**
            Moves the iterator past the next element.
            @return the traversed element
        */
        public Object next(){
            if(!hasNext()){
                throw new NoSuchElementException();
            }
            prev = pos;
            isAfterNext = true;

            if(pos == null){
                pos = first;
            }else{
                pos = pos.next;
            }
            return pos.item;
        }




        /**
            Tests if there is an element after the iterator position.
            @return true if there is an element after the iterator position
        */
        public boolean hasNext(){
            return pos != null;
        }

        /**
            Adds an element before the iterator position
            and moves the iterator past the inserted element.
            @param element the element to add
        */
        public void add(Object element){
            //check if the iterator is at the beginning of thee list
            if (pos == null){
                addFirst(element);
                pos = first;
            }
            else {
                Node newNode = new Node();
                newNode.item = element;
                newNode.next = pos.next;
                pos.next = newNode;
                pos = newNode;
            }
        }





        /**
            Removes the last traversed element. This method may
            only be called after a call to the next() method.
        */
        public void remove(){
            if(!isAfterNext){
                throw new IllegalStateException();
            }
        }
        if(pos == first){
            removeFirst();
            pos = null;
    }






        /**
            Sets the last traversed element to a different value.
            @param element the element to set
        */
        @Override
        public void set(Object element) {
            if(!isAfterNext){
            throw new IllegalStateException();
            }

            pos.item = element;
        }
    }//LinkedListIterator
}//LinkedList
