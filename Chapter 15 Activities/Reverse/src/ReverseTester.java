import java.util.LinkedList;


/**
 * A test program to reverse the entries in a linked list.
*/
public class ReverseTester
{
    public static void main(String[] args)
    {
        // Test 1: Even number of elements
        LinkedList<String> employeeNames = new LinkedList<>();
        employeeNames.addLast("Dick");
        employeeNames.addLast("Harry");
        employeeNames.addLast("Romeo");
        employeeNames.addLast("Tom");
        ListUtil.reverse(employeeNames);
        System.out.println("Test 1: " + employeeNames);
        System.out.println("Expected: [Tom, Romeo, Harry, Dick]");

        // Test 2: Odd number of elements
        LinkedList<String> oddList = new LinkedList<>();
        oddList.add("A");
        oddList.add("B");
        oddList.add("C");
        ListUtil.reverse(oddList);
        System.out.println("Test 2: " + oddList);
        System.out.println("Expected: [C, B, A]");

        // Test 3: Single element
        LinkedList<String> single = new LinkedList<>();
        single.add("Only");
        ListUtil.reverse(single);
        System.out.println("Test 3: " + single);
        System.out.println("Expected: [Only]");

        // Test 4: Empty list
        LinkedList<String> empty = new LinkedList<>();
        ListUtil.reverse(empty);
        System.out.println("Test 4: " + empty);
        System.out.println("Expected: []");

        // Test 5: Duplicates
        LinkedList<String> duplicates = new LinkedList<>();
        duplicates.add("X");
        duplicates.add("Y");
        duplicates.add("X");
        duplicates.add("Y");
        ListUtil.reverse(duplicates);
        System.out.println("Test 5: " + duplicates);
        System.out.println("Expected: [Y, X, Y, X]");

        // Test 6: Palindrome
        LinkedList<String> palindrome = new LinkedList<>();
        palindrome.add("a");
        palindrome.add("b");
        palindrome.add("c");
        palindrome.add("b");
        palindrome.add("a");
        ListUtil.reverse(palindrome);
        System.out.println("Test 6: " + palindrome);
        System.out.println("Expected: [a, b, c, b, a]");
    }
}