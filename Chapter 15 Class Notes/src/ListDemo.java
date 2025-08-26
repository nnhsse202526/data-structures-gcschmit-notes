import java.util.LinkedList;
import java.util.ListIterator;

/**
 * This program demonstrates the LinkedList class
 * and ListIterator class.
*/
public class ListDemo
{
    public static void main(String[] args)
    {
        /*
         * The addLast method can be used to populate a list.
         */
        LinkedList<String> staff = new LinkedList<>();
        staff.addLast("Diana");
        staff.addLast("Harry");
        staff.addLast("Romeo");
        staff.addLast("Tom");

        // The list is currently: DHRT

        /*
         * The listIterator method creates a new list iterator that is
         *  positioned at the front of the list.
         * The "|" in the comment represents the iterator position.
         */
        ListIterator<String> iterator = staff.listIterator(); // |DHRT

        /*
         * The next method advances the iterator over the next element
         *  in the list.
         */
        iterator.next();    // D|HRT

        /*
         * The next method also returns a reference to the element that
         *  the iterator is passing.
         */
        String name = iterator.next();      // DH|RT
        System.out.println(name);
        System.out.println("Expected: Harry");

        /*
         * The add method inserts an element at the iterator position.
         * The iterator is then positioned after the element that was added.
         *  (The text is a bit confusing on this point....)
         */
        iterator.add("Juliet");     // DHJ|RT
        iterator.add("Nina");       // DHJN|RT

        /*
         * The remove method removes the element returned by the last
         *  call to next or previous.
         * The remove method can only be called once after calling next
         *  or previous.
         * The remove method cannot be called after calling add.
         */
        iterator.next();        // DHJNR|T
        iterator.remove();      // DHJN|T

        System.out.println(staff);
        System.out.println("Expected: [Diana, Harry, Juliet, Nina, Tom]");

        /*
         * The set method updates the element returned by the last call
         *  to next or previous.
         */
        iterator.previous();          // DHJ|NT
        iterator.set("Albert");     // DHJ|AT

        
    }
}
