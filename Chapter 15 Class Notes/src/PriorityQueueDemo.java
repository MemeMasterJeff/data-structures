import java.util.PriorityQueue;
import java.util.Queue;


/**
 * This program demonstrates a priority queue of to-do items. The
 * most important to-do items are removed first.
*/
public class PriorityQueueDemo
{
    public static void main(String[] args) {
        // create a priority queue of to-do items
        //a work order has a message ID that is used to determine the importance of objects
        Queue<WorkOrder> toDo = new PriorityQueue<>();

        toDo.add(new WorkOrder(3,"water plants"));
        toDo.add(new WorkOrder(2,"make dinner"));
        toDo.add(new WorkOrder(2,"walk dog"));
        toDo.add(new WorkOrder(9,"play vidja games"));
        toDo.add(new WorkOrder(1,"study for the chapter 15 exam"));

        System.out.println(toDo);

    }
}
