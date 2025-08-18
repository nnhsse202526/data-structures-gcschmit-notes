import java.util.Scanner;

/**
 * A program to add, remove, modify or print
 * student names and grades.
*/
public class Gradebook
{
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);

        // create the map for the gradebook

        boolean done = false;
        while(!done)
        {
            System.out.println("A)dd R)emove M)odify P)rint Q)uit");
            String input = in.next().toUpperCase();
            if (input.equals("Q"))
            {
                done = true;
            } else if (input.equals("A"))
            {
                // complete this case

            } else if (input.equals("R"))
            {
                // complete this case
            } else if (input.equals("M"))
            {
                // complete this case
            } else if (input.equalsIgnoreCase("P"))
            {
                // complete this case
            } else
            {
                done = true;
            }
        }
    }
}
