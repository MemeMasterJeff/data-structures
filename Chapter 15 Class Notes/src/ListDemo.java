import java.util.LinkedList;
import java.util.ListIterator;

/**
 * This program demonstrates the LinkedList class
 * and ListIterator class.
*/
public class ListDemo
{
    public static void main(String[] args){
        LinkedList<String> staff = new LinkedList<>();
        staff.addLast("Diana");
        staff.addLast("Harry");
        staff.addLast("Romeo");
        staff.addLast("Tom");
        //the list is currently:DHRT
        /* the listIterator method creates a new list iterator
        that is positioned at the head of the list
        the "|" is used to represent the iterator position
         */
        ListIterator<String> iterator = staff.listIterator();// |DHRT

        iterator.next();
        // the next method also returns the element that the iterator is passing.
        String name = iterator.next(); //DH|RT
        System.out.println(name);

        /* the add method for iterators inserts an element at the iterator postiion.
        the iterator is then positioned after the element that was added.
         */
        iterator.add("Juliet");//DHJ|RT
        iterator.add("Nina"); //DHJN|RT

        /* enhanced for loope automatically creates an iterator! */
        for (String n: staff){
            if(n.equals("Harry")){
                staff.add("Charlie");
            }
        }
    }
}
