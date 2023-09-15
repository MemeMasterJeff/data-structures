import java.util.Iterator;
import java.util.LinkedList;

/**
 * Business utility methods.
*/
public class Business
{
    /**
      * Removes every nth element from the linked list
      *
      * @param employeeNames the linked list to remove from
      * @param n                 the parameter to determine "nth"
     */
    public static void downsize(LinkedList<String> employeeNames, int n)
    {
        Iterator<String> iterator = employeeNames.listIterator();
        while(iterator.hasNext()){
            for(int i = 0; i<n;++i){
                iterator.next();
            }
            iterator.remove();
        }
    }
}
