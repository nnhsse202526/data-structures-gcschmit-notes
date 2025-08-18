import java.util.LinkedList;

/**
 * A test class for the downsize method.
*/
public class DownsizeTester
{
    public static void main(String[] args)
    {
        // Test 1: n = 2, even number of elements
        LinkedList<String> list1 = new LinkedList<>();
        list1.add("Dick");
        list1.add("Harry");
        list1.add("Romeo");
        list1.add("Juliet");
        Business.downsize(list1, 2);
        System.out.println("Test 1: n=2, even size");
        System.out.println("Actual:   " + list1);
        System.out.println("Expected: [Dick, Romeo]");
        System.out.println();

        // Test 2: n = 2, odd number of elements
        LinkedList<String> list2 = new LinkedList<>();
        list2.add("A");
        list2.add("B");
        list2.add("C");
        list2.add("D");
        list2.add("E");
        Business.downsize(list2, 2);
        System.out.println("Test 2: n=2, odd size");
        System.out.println("Actual:   " + list2);
        System.out.println("Expected: [A, C, E]");
        System.out.println();

        // Test 3: n = 1 (should remove all elements)
        LinkedList<String> list3 = new LinkedList<>();
        list3.add("X");
        list3.add("Y");
        list3.add("Z");
        Business.downsize(list3, 1);
        System.out.println("Test 3: n=1");
        System.out.println("Actual:   " + list3);
        System.out.println("Expected: []");
        System.out.println();

        // Test 4: n = 3
        LinkedList<String> list4 = new LinkedList<>();
        list4.add("Tom");
        list4.add("Jerry");
        list4.add("Spike");
        list4.add("Tyke");
        list4.add("Butch");
        list4.add("Nibbles");
        Business.downsize(list4, 3);
        System.out.println("Test 4: n=3");
        System.out.println("Actual:   " + list4);
        System.out.println("Expected: [Tom, Jerry, Tyke, Butch]");
        System.out.println();
        
        // Test 5: n > list size (should not remove anything)
        LinkedList<String> list7 = new LinkedList<>();
        list7.add("Red");
        list7.add("Blue");
        Business.downsize(list7, 5);
        System.out.println("Test 7: n=5, n > size");
        System.out.println("Actual:   " + list7);
        System.out.println("Expected: [Red, Blue]");
        System.out.println();

        // Test 6: empty list
        LinkedList<String> list8 = new LinkedList<>();
        Business.downsize(list8, 2);
        System.out.println("Test 8: empty list");
        System.out.println("Actual:   " + list8);
        System.out.println("Expected: []");
        System.out.println();

        // Test 7: single element, n=2
        LinkedList<String> list9 = new LinkedList<>();
        list9.add("Solo");
        Business.downsize(list9, 2);
        System.out.println("Test 9: single element, n=2");
        System.out.println("Actual:   " + list9);
        System.out.println("Expected: [Solo]");
        System.out.println();
    }
}
