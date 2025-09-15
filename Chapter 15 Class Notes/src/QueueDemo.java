import java.util.LinkedList;
import java.util.Queue;

/**
 * This program simulates a print queue. Note that documents are printed
 * in the same order as they are submitted.
*/
public class QueueDemo
{
    public static void main(String[] args)
    {
        // create a print queue of strings (using a linked list)
        Queue<String> jobs = new LinkedList<>();

        // add several print jobs
        jobs.add("Joe: junior photos");
        jobs.add("Cathy: faculty photos");

        System.out.println("Printing: " + jobs.remove());

        jobs.add("Cathy: XC team photo");
        jobs.add("Joe: senior photos");
        jobs.add("Joe: sophomore photos");

        System.out.println("Printing: " + jobs.remove());

        jobs.add("Cathy: robotics spread");

        while(jobs.size() > 0)
        {
            System.out.println("Printing: " + jobs.remove());
        }
    }
}
