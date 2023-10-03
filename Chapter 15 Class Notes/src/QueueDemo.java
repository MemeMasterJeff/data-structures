import java.util.LinkedList;
import java.util.Queue;

/**
 * This program simulates a print queue. Note that documents are printed
 * in the same order as they are submitted.
*/
public class QueueDemo
{
    public static void main(String[] args) {
        //simulate a printer queue
        Queue<String> printer = new LinkedList<>();

        //add some print jobs
        printer.add("Joe: Expense report 2023");
        printer.add("Cathy: Top Secret Document #5");

        System.out.println("Printing: "+printer.remove());

        printer.add("Cathy: Really Top Secret Document #2");
        printer.add("Joe: Grocery List");
        printer.add("Cathy: Can I Get Fired For This?");

        System.out.println("Printing: "+printer.remove());

        printer.add("Boss: Cathy's Termination Letter");

        //Print the rest of the jobs in thee queue
        while(!(printer.isEmpty())){
            System.out.println(printer.remove());
        }
    }
}
